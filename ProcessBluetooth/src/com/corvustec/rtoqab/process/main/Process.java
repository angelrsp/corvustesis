package com.corvustec.rtoqab.process.main;

import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sumFrom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.rtoqab.process.util.Const;
import com.corvustec.rtoqab.process.util.UtilApplication;
import com.corvustec.rtoqad.process.dto.DataDTO;
import com.corvustec.rtoqad.process.dto.IntervaloTiempoDTO;


public class Process {

	private final static Logger logger = LoggerFactory.getLogger(Process.class);
	
	private static Process instance;
	
	private static String horaInicio=Const.HORA_INICIO;
	private static String horaFin=Const.HORA_FIN;
	private static String pathProcesado=Const.PATH_PROCESADO;
	private static String pathNoProcesado=Const.PATH_NOPROCESADO;
	
	//Singleton
	public static Process getInstance()
	{
		if(instance==null)
			instance=new Process();
		return instance;
	}
	
	public static void main(String[] args) {
		
		long start, end;
		Double diff;
		start = System.currentTimeMillis();
		
		File[] files=Process.getInstance().getFiles(Const.PATH_RECOLECTOR);
		if(files!=null)
		{
			for(File file:files)
				Process.getInstance().processOne(file);
		}

		Process.getInstance().borrarArchivos();
		
		end = System.currentTimeMillis();
		diff=(double) (end-start);
		diff= diff* 0.001;
		logger.info("Procesado en: "+ ( diff ) +" segundos");
	}

	
	@SuppressWarnings("unchecked")
	private void processOne(File fileIn)
	{
		String codigoAgencia,fechaCorte;

		File fileOut;
		
		List<String> lines;
		String line[];

		DataDTO data;
		
		FileWriter writer;
		
		List<DataDTO> dataList,dataListDistinct,baliza,dataMac,dataMax;
		
		int balizaSum,index;
		double balizaAvg,balizaAvgDia;
		double varianza= 0.0,desviacion = 0.0,rango=0.0,balizaSumDbl,balizaAvgDbl,limiteSuperior,limiteInferior,limiteSuperiorDia,limiteInferiorDia,limiteSuperiorInt,limiteInferiorInt;
		
		double diaSum,diaAvg;
		
		final String balizas[];			

		double factorMaximo, factorAjuste,factorPromedioDia,factorIntervaloTiempo3;
		
		try{			
			
			codigoAgencia=Const.CODIGO_AGENCIA;

			factorMaximo=Double.valueOf(Const.FACTOR_MAXIMO);
			factorAjuste=Double.valueOf(Const.FACTOR_AJUSTE);
			factorPromedioDia=Double.valueOf(Const.FACTOR_PROMEDIO_DIA);
			factorIntervaloTiempo3=Double.valueOf(Const.FACTOR_INTERVALO3);

			balizas=Const.BALIZAS;
			
			dataListDistinct =new ArrayList<DataDTO>();
			baliza=new ArrayList<DataDTO>();
			
			dataList=new ArrayList<DataDTO>();
			dataMac=new ArrayList<DataDTO>();
			dataMax=new ArrayList<DataDTO>();			
			 
			lines = FileUtils.readLines(fileIn);

			line=lines.get(0).split("\\|");
			fechaCorte=getFechaCorte(line[0]);
			fileOut=new File(Const.PATH_FINAL+fileIn.getName());
			writer=new FileWriter(fileOut);
			
			//Establezo los datos en la lista de objetos
			for(int i=0;i<lines.size();i++)
			{
				line=lines.get(i).split("\\|");
				data=new DataDTO();
				data.setFecha(Timestamp.valueOf(line[0]));
				data.setMinuto(Time.valueOf(line[0].substring(11, 19)));
				data.setMac(line[1]);
				data.setRssi(Integer.valueOf(line[3]));
				dataList.add(data);
			}
			//vacio el arreglo
			lines=null;
			
			//obtengo las balizas
			baliza.addAll((List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                 DataDTO dat= (DataDTO)arg0;
                 if(Arrays.asList(balizas).contains(dat.getMac()))
                	 return true;
                 else
                	 return false;
				}
			}));

			if(baliza.size()<=0)
			{
				logger.info("No se encontraron balizas de referencia");
				writeBitacora("No se encontraron balizas de referencia "+fechaCorte);
				writer.close();
				UtilApplication.moverArchivo(fileIn, pathNoProcesado+fileIn.getName());
				UtilApplication.eliminarArchivo(fileOut);
				return;
			}
			
			
			balizaSum=sumFrom(baliza).getRssi();
			balizaAvg=balizaSum/baliza.size();
			
			balizaAvgDia=balizaAvg;
			
			for(DataDTO dat:baliza)
			{
			   rango = Math.pow(dat.getRssi()-balizaAvg,2);
			   varianza = varianza + rango;				
			}
			
			varianza=varianza/baliza.size();
			desviacion=Math.sqrt(varianza);
			
			varianza=0.0;
			
			dataListDistinct = getDistinct(dataList);
						
			logger.info("Se encontraron total dispositivos censados: "+dataListDistinct.size());
			
			for(final DataDTO dat:dataListDistinct)
			{				
				dataMac=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
				     DataDTO d= (DataDTO)arg0;
				     if(d.getMac().equals(dat.getMac()))
				    	 return true;
				     else
				    	 return false;
					}
				});
				
				data=new DataDTO();
				data.setRssi(max(dataMac, on(DataDTO.class).getRssi()));
				data.setMac(dat.getMac());
				data.setFecha(dat.getFecha());
				
				dataMax.add(data);
			}

			//Libero memoria lista
			dataListDistinct=null;
			
			/*
			 * Se descartan las señales menores entre la media y desv. estandar de las balizas por un factor.
			 */
			for(final DataDTO dat:dataMax)
			{
				//El numero 1 debe ser dinamico (pendiente por analizar) Factor del maximo
				if(dat.getRssi()<(balizaAvg-(desviacion*factorMaximo)))
				{
					dataList.removeAll(CollectionUtils.select(dataList, new Predicate() {
						@Override
						public boolean evaluate(Object arg0) {
		                 DataDTO d= (DataDTO)arg0;
		                 if(d.getMac().equals(dat.getMac()))
		                	 return true;
		                 else
		                	 return false;
						}
					}));
				}
			}	 			
			dataMax=null;
			
			logger.info("Se descartan las seniales menores entre la media y desv. estandar de las balizas quedan: "+getDistinct(dataList).size());
			
			
			//Todavia es el Paso 1
			List<IntervaloTiempoDTO> intervaloSegundo;
			List<IntervaloTiempoDTO> intervaloMinuto;
			
			List<DataDTO> temp=new ArrayList<DataDTO>();
			List<DataDTO> temp2=new ArrayList<DataDTO>();
			List<DataDTO> temp3=new ArrayList<DataDTO>();
			List<DataDTO> temp4=new ArrayList<DataDTO>();
			StringBuilder sb=new StringBuilder();
			
			intervaloSegundo=generateIntervalSecond();
			
			DataDTO datoTemp;

			index=1;
			//selecciona solo intervalos necesarios
			for(final IntervaloTiempoDTO inter:intervaloSegundo)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMinuto().getTime()>=inter.getTimeDesde().getTime()
                    		 &&dat.getMinuto().getTime()<inter.getTimeHasta().getTime())
                    	 return true;
                     else
                    	 return false;
					}
				});
			
				if(temp.size()>0)
				{
					for(DataDTO dat:temp)
					{
						//datoTemp=dat;
						dat.setIntervaloSegundoDesde(inter.getTimeDesde());
						dat.setIntervaloSegundoHasta(inter.getTimeHasta());
						dat.setNumeroIntervalo(index);
						temp2.add(dat);
					}
					index=index+1;
				}
			}
			
			//Paso los datos con intervalos a dataList			
			dataList=temp2;
						
			dataListDistinct=getDistinct(dataList);

			logger.info("Datos con intervalos de tiempo se encontraron: "+dataListDistinct.size());
			
			//Encuentro promedio por intervalos
			for(final DataDTO dato:dataListDistinct)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMac().equals(dato.getMac()))
                    	 return true;
                     else
                    	 return false;
					}
				});
				
				temp2=getDistinctByNumeroIntervalo(temp);

				//Sorting (ordenar)
				Collections.sort(temp2, new Comparator<DataDTO>() {
			        @Override
			        public int compare(DataDTO  dato1, DataDTO  dato2){
			            return dato1.getNumeroIntervalo()> dato2.getNumeroIntervalo()?1:-1;
			        }
			    });
				
				for(final DataDTO d:temp2)
				{
					temp3= (List<DataDTO>) CollectionUtils.select(temp, new Predicate() {
						@Override
						public boolean evaluate(Object arg0) {
	                     DataDTO dat= (DataDTO)arg0;
	                     if(dat.getNumeroIntervalo()==d.getNumeroIntervalo())
	                    	 return true;
	                     else
	                    	 return false;
						}
					});
					
					if(temp3.size()>0)
					{
						datoTemp=temp3.get(0);
						balizaSum=sumFrom(temp3).getRssi();
						balizaAvg=balizaSum/temp3.size();
						datoTemp.setMedia(balizaAvg);
						temp4.add(datoTemp);
					}
				}
			}

			dataList=temp4;
			
			logger.info("Datos con intervalos de tiempo se encontraron: "+dataList.size());
			
			dataListDistinct=getDistinct(dataList);
			
			logger.info("Dispositivos con intervalos de tiempo se encontraron: "+dataListDistinct.size());
			
			//Suavizar la curva con limites
			temp2=new ArrayList<DataDTO>();
			
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMac().equals(dato.getMac()))
                    	 return true;
                     else
                    	 return false;
					}
				});
				balizaSumDbl=sumFrom(temp).getMedia();
				balizaAvgDbl=balizaSumDbl/temp.size();
				
				varianza=0.0;
				
				for(DataDTO dat:temp)
				{
				   rango = Math.pow(dat.getMedia()-balizaAvgDbl,2);
				   varianza = varianza + rango;				
				}
				varianza=varianza/(temp.size());
				desviacion=Math.sqrt(varianza);
				
				//3 es el numero de sigmas
				limiteSuperior=balizaAvgDbl+(desviacion*1);
				limiteInferior=balizaAvgDbl-(desviacion*1);
				
				index=0;
				for(DataDTO dat:temp)
				{
					datoTemp=null;
					
						datoTemp=(DataDTO) BeanUtils.cloneBean(dat);
					
					if(!(dat.getMedia()>=limiteInferior&&dat.getMedia()<=limiteSuperior))
						if((index-1)>=0&&(index+1)<temp.size())
							datoTemp.setMedia((temp.get(index-1).getMedia()+dat.getMedia()+temp.get(index+1).getMedia())/3);

					index=index+1;
					temp2.add(datoTemp);
				}
			}
			
			dataList=temp2;

			
			//Obtengo la media de las balizas en grupo para cada intervalo de tiempo
			baliza=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                 DataDTO dat= (DataDTO)arg0;
                 if(Arrays.asList(balizas).contains(dat.getMac()))
                	 return true;
                 else
                	 return false;
				}
			});
			

			temp=getDistinctByNumeroIntervalo(baliza);
			
			temp3=new ArrayList<DataDTO>();
			
			for(final DataDTO dato:temp)
			{
				temp2=(List<DataDTO>) CollectionUtils.select(baliza, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getNumeroIntervalo()==dato.getNumeroIntervalo())
	                	 return true;
	                 else
	                	 return false;
					}
				});				

				if(temp2.size()>0)
				{
					balizaSum=sumFrom(temp2).getRssi();
					balizaAvg=balizaSum/(temp2.size());
					temp2.get(0).setMedia(balizaAvg-(desviacion*factorAjuste));//Factor de ajuste
										
					temp3.add(temp2.get(0));
				}
			}
			
			baliza=temp3;
			
			temp3=new ArrayList<DataDTO>();
			
			
			//Comparcion con balizas
			for(final DataDTO dato:dataList)
			{
				temp2=(List<DataDTO>) CollectionUtils.select(baliza, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getNumeroIntervalo()==dato.getNumeroIntervalo())
	                	 return true;
	                 else
	                	 return false;
					}
				});
				datoTemp=new DataDTO();
				datoTemp=dato;
				if(temp2.size()>0)
				{
					if(dato.getMedia()<temp2.get(0).getMedia())
						datoTemp.setEstado(0);
					else
						datoTemp.setEstado(1);					
				}
				else
				{
					if(dato.getMedia()<balizaAvgDia)
						datoTemp.setEstado(0);
					else
						datoTemp.setEstado(1);
				}
				temp3.add(datoTemp);
			}

			dataList=temp3;
			
			
			dataListDistinct=getDistinct(dataList);
			
			temp2=new ArrayList<DataDTO>();
			
			
			//Moda
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getMac().equals(dato.getMac()))
	                	 return true;
	                 else
	                	 return false;
					}
				});

				
				temp.get(0).setEstado(0);
				temp.get(temp.size()-1).setEstado(0);
				
				for(int i=0;i<temp.size();i++)
				{
					if(temp.get(i).getEstado()==1)
					{
						if((i-2)>=0&&(i-1)>=0&&(i+1)<temp.size()&&(i+2)<temp.size())
						{
							if(temp.get(i-2).getEstado()==0&&temp.get(i-1).getEstado()==0&&temp.get(i+1).getEstado()==0&&temp.get(i+2).getEstado()==0)
							{
								temp.get(i).setEstado(0);	
							}
						}
					}
				}
				
				temp2.addAll(temp);
			}
			
			dataList=temp2;
			
			
			//Paso a analizar
			temp3=new ArrayList<DataDTO>();
			//Diferencia de tiempos
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getMac().equals(dato.getMac()))
	                	 return true;
	                 else
	                	 return false;
					}
				});
				
				//Dato de tiempos
				DataDTO dataDTO=new DataDTO();
				
				if(temp.size()>0)
				{
					dataDTO.setEntradaAgencia(temp.get(0).getIntervaloSegundoDesde());
					dataDTO.setMac(temp.get(0).getMac());
					dataDTO.setSalidaAgencia(temp.get(temp.size()-1).getIntervaloSegundoDesde());
				}
				
				for(int i=0;i<temp.size();i++)
				{
					if(temp.get(i).getEstado()==1)
					{
						dataDTO.setEntradaFila(temp.get(i).getIntervaloSegundoDesde());
						break;
					}
				}
				
				for(int j=temp.size()-1;j>=0;j--)
				{
					if(temp.get(j).getEstado()==1)
					{
						dataDTO.setSalidaFila(temp.get(j).getIntervaloSegundoDesde());
						break;
					}			
				}
				
				temp3.add(dataDTO);
			}
			
			dataList=temp3;
			////////////////////////////Fin data tiempos
			
			
			temp=new ArrayList<DataDTO>();
			
			for(DataDTO dat:dataList)
			{
				if(dat.getEntradaAgencia()!=null&&dat.getSalidaAgencia()!=null)
					dat.setTiempoAgencia((dat.getSalidaAgencia().getTime()-dat.getEntradaAgencia().getTime())*0.0000166666);
				
				if(dat.getEntradaFila()!=null&&dat.getSalidaFila()!=null)
					dat.setTiempoFila((dat.getSalidaFila().getTime()-dat.getEntradaFila().getTime())*0.0000166666);
				
				temp.add(dat);
			}
			
			dataList=temp;
			
			logger.info("Antes de limites tiempo fila "+dataList.size());
			
			///Tiempo en fila
			dataListDistinct=getDistinct(dataList);
			
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getMac().equals(dato.getMac()))
	                	 return true;
	                 else
	                	 return false;
					}
				});
				if(temp.size()>0)
				{
					if(temp.get(0).getTiempoFila()!=null)
					{
						if(temp.get(0).getTiempoFila()<1||temp.get(0).getTiempoFila()>60)//1 y 55 deben ser parametrizables
						{
							dataList.remove(temp.get(0));
						}
					}
					else
						dataList.remove(temp.get(0));
				}
			}
			
			logger.info("Antes de limites tiempo agencia "+dataList.size());
			//Tiempo en agencia
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getMac().equals(dato.getMac()))
	                	 return true;
	                 else
	                	 return false;
					}
				});
				if(temp.size()>0)
				{
					if(temp.get(0).getTiempoAgencia()!=null)
					{
						if(temp.get(0).getTiempoAgencia()<2||temp.get(0).getTiempoAgencia()>80)//1 y 55 deben ser parametrizables
						{
							dataList.remove(temp.get(0));
						}
					}
					else
						dataList.remove(temp.get(0));
				}
			}
			
			
			logger.info("Despues de limites tiempo agencia "+dataList.size());
			
			if(dataList.size()<=0)
			{
				logger.info("Sin datos posible dia no atención");
				writeBitacora("Sin datos posible dia no atención "+fechaCorte);
				UtilApplication.moverArchivo(fileIn, pathNoProcesado+fileIn.getName());
				writer.close();
				UtilApplication.eliminarArchivo(fileOut);
				return;
			}
			
			///Promedio dia....
			diaSum=sumFrom(dataList).getTiempoFila();
			diaAvg=diaSum/dataList.size();
			
			varianza=0.0;
			
			for(DataDTO dat:dataList)
			{
			   rango = Math.pow(dat.getTiempoFila()-diaAvg,2);
			   varianza = varianza + rango;				
			}
			
			varianza=varianza/dataList.size();
			desviacion=Math.sqrt(varianza);

			//parametrizable.
			limiteSuperiorDia=diaAvg+desviacion*factorPromedioDia;
			limiteInferiorDia=diaAvg-desviacion;

			logger.info("Avg: "+diaAvg);
			logger.info("Des: "+desviacion);
			logger.info("Sup: "+limiteSuperiorDia);
			logger.info("Inf: "+limiteInferiorDia);
			
			///Aplico rangos de 15 min....
			intervaloMinuto=generateMinute();
			index=1;
			for(final IntervaloTiempoDTO inter:intervaloMinuto)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getEntradaFila().getTime()>=inter.getTimeDesde().getTime()
                    		 &&dat.getEntradaFila().getTime()<inter.getTimeHasta().getTime())
                    	 return true;
                     else
                    	 return false;
					}
				});
				
				if(temp.size()>0)
				{
					for(DataDTO dat:temp)
					{
						//datoTemp=dat;
						dat.setIntervaloMinutoDesde(inter.getTimeDesde());
						dat.setIntervaloMinutoHasta(inter.getTimeHasta());
						dat.setNumeroIntervaloMinuto(index);
						temp2.add(dat);
					}
					index=index+1;
				}
			}
			
			logger.info("En intervalos quedan: "+ dataList.size());
			
			dataListDistinct=getDistinctByNumeroIntervaloMinuto(dataList);
			
			//Sorting
			Collections.sort(dataListDistinct, new Comparator<DataDTO>() {
		        @Override
		        public int compare(DataDTO  dato1, DataDTO  dato2){
		            return dato1.getNumeroIntervaloMinuto()> dato2.getNumeroIntervaloMinuto()?1:-1;
		        }
		    });
			
			temp2=new ArrayList<DataDTO>();
			
			for(final DataDTO inter:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getNumeroIntervaloMinuto()==inter.getNumeroIntervaloMinuto())
                    	 return true;
                     else
                    	 return false;
					}
				});
				
				
				if(temp.size()>=3)
				{
					///Promedio
					balizaAvg=(sumFrom(temp).getTiempoFila())/temp.size();
					
					varianza=0.0;
					
					for(DataDTO dat:temp)
					{
					   rango = Math.pow(dat.getTiempoFila()-balizaAvg,2);
					   varianza = varianza + rango;				
					}
					
					varianza=varianza/temp.size();
					desviacion=Math.sqrt(varianza);

					//parametrizable.
					limiteSuperiorInt=balizaAvg+(desviacion*factorIntervaloTiempo3);
					limiteInferiorInt=balizaAvg-(desviacion*factorIntervaloTiempo3);
					
					
					
					for(DataDTO d:temp)
					{
						if(d.getTiempoFila()>=limiteInferiorInt&&d.getTiempoFila()<=limiteSuperiorInt)
							temp2.add(d);
					}
				}
				if(temp.size()==2)
				{
					if(temp.get(0).getTiempoFila()>=limiteInferiorDia&&temp.get(0).getTiempoFila()<=limiteSuperiorDia)
						temp2.add(temp.get(0));
					if(temp.get(1).getTiempoFila()>=limiteInferiorDia&&temp.get(1).getTiempoFila()<=limiteSuperiorDia)
						temp2.add(temp.get(1));
				}
				if(temp.size()==1)
				{
					if(temp.get(0).getTiempoFila()>=limiteInferiorDia&&temp.get(0).getTiempoFila()<=limiteSuperiorDia)
						temp2.add(temp.get(0));
				}
			}
			
			dataList=temp2;
			
			for(DataDTO dat:dataList){
				sb.append(codigoAgencia+"|");
				sb.append(fechaCorte+"|");
				sb.append(dat.getMac()+"|");
//				sb.append(dat.getIntervaloSegundoDesde()+"|");
//				sb.append(dat.getIntervaloSegundoHasta()+"|");
				sb.append(dat.getEntradaAgencia()+"|");
				sb.append(dat.getEntradaFila()+"|");
				sb.append(dat.getSalidaFila()+"|");
				sb.append(dat.getSalidaAgencia()+"|");
//				sb.append(dat.getIntervaloMinutoDesde()+"|");
//				sb.append(dat.getIntervaloMinutoHasta()+"|");
				sb.append(dat.getNumeroIntervaloMinuto()+"|");
				sb.append(dat.getTiempoFila().toString().replace('.', ',')+"|");
				sb.append(dat.getTiempoAgencia().toString().replace('.', ',')+"\n");
//				sb.append(dat.getRssi()+"|");				
//				sb.append(dat.getEstado()+"|");
//				sb.append(dat.getMedia()+"\n");
				writer.write(sb.toString());
				sb=new StringBuilder();
			}
			writer.close();
			
			UtilApplication.moverArchivo(fileIn, pathProcesado+fileIn.getName());
			
			writeBitacora("Proceso Exitoso Fecha: "+fechaCorte+" Agencia "+codigoAgencia);
			fileOut.setWritable(false);
			fileOut.setExecutable(false);
			fileOut.setReadOnly();
			logger.info(String.valueOf(fileOut.canWrite()));
			
		} catch (IOException e) {
			UtilApplication.moverArchivo(fileIn, pathNoProcesado+fileIn.getName());
			logger.info("Error {}",e.toString());
		}
		catch (Exception e) {
			UtilApplication.moverArchivo(fileIn, pathNoProcesado+fileIn.getName());
			logger.info("Error {}",e.toString());
		}
	}
	
	
	public static List<IntervaloTiempoDTO> generateIntervalSecond()
	{
		Time desde,hasta;
		String incremento;
		List<IntervaloTiempoDTO> intervaloTiempo = null;
		IntervaloTiempoDTO intervalo;
		try {
			intervaloTiempo=new ArrayList<IntervaloTiempoDTO>();
			desde=Time.valueOf(horaInicio);
			hasta= Time.valueOf(horaFin);
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addSecond(desde.toString(), 15);

				intervalo= new IntervaloTiempoDTO();
				intervalo.setTimeDesde(desde);
				intervalo.setTimeHasta(Time.valueOf(incremento));
				intervaloTiempo.add(intervalo);
				
				desde=Time.valueOf(UtilApplication.addSecond(desde.toString(), 15));
			}
			
		} catch (Exception e) {
			logger.info("Error {}",e.toString());
		}
		return intervaloTiempo;		
	}
	
	public static List<IntervaloTiempoDTO> generateMinute()
	{
		Time desde,hasta;
		String incremento;
		List<IntervaloTiempoDTO> intervaloTiempo = null;
		IntervaloTiempoDTO intervalo;
		try {
			intervaloTiempo=new ArrayList<IntervaloTiempoDTO>();
			desde=Time.valueOf(horaInicio);
			hasta= Time.valueOf(horaFin);
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addMinute(desde.toString(), 15);

				intervalo= new IntervaloTiempoDTO();
				intervalo.setTimeDesde(desde);
				intervalo.setTimeHasta(Time.valueOf(incremento));
				intervaloTiempo.add(intervalo);
				
				desde=Time.valueOf(UtilApplication.addMinute(desde.toString(), 15));
			}
			
		} catch (Exception e) {
			logger.info("Error {}",e.toString());
		}
		return intervaloTiempo;		
	}
	
	public static List<DataDTO> getDistinct(List<DataDTO> dataList)
	{
		List<DataDTO> list;
		Map<String, DataDTO> map = new HashMap<String, DataDTO>();
		for (DataDTO p : dataList) {
		    if (!map.containsKey(p.getMac())) {
		        map.put(p.getMac(), p);
		    }
		}
		list= new ArrayList<DataDTO>(map.values());
		return list;
	}

	
	public static List<DataDTO> getDistinctByNumeroIntervalo(List<DataDTO> dataList)
	{
		List<DataDTO> list;
		Map<Integer, DataDTO> map = new HashMap<Integer, DataDTO>();
		for (DataDTO p : dataList) {
		    if (!map.containsKey(p.getNumeroIntervalo())) {
		        map.put(p.getNumeroIntervalo(), p);
		    }
		}
		list= new ArrayList<DataDTO>(map.values());
		return list;
	}

	public static List<DataDTO> getDistinctByNumeroIntervaloMinuto(List<DataDTO> dataList)
	{
		List<DataDTO> list;
		Map<Integer, DataDTO> map = new HashMap<Integer, DataDTO>();
		for (DataDTO p : dataList) {
		    if (!map.containsKey(p.getNumeroIntervaloMinuto())) {
		        map.put(p.getNumeroIntervaloMinuto(), p);
		    }
		}
		list= new ArrayList<DataDTO>(map.values());
		return list;
	}
	
	public static long timeDiff(String timeStart,String timeEnd)
	{

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = null,date2 = null;
		try {
			date1 = format.parse(timeStart);
			date2 = format.parse(timeEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return date2.getTime() - date1.getTime(); 
	}
	
	public File[] getFiles(String path)
	{
		File file;
		File[] files=null;
		try{
			file=new File(path);
			if(file.exists())
			{
				files=file.listFiles();
			}
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
		}
		return files;
	}
	
	private String getFechaCorte(String fechaArchivo)
	{
		String result=null;
		try{
			if(StringUtils.isNotBlank(fechaArchivo)&&StringUtils.isNotEmpty(fechaArchivo))
				result=fechaArchivo.substring(0, 10);
		}
		catch(Exception e)
		{
			logger.info("Error {}",e.toString());	
		}
		return result;
	}
	
	private void writeBitacora(String mensaje)
	{
		File fileBitacora;
		FileWriter writerBitacora;
		try {
			fileBitacora=new File(Const.PATH_BITACORA+"bitacora.txt");
			if(fileBitacora.exists())
				writerBitacora=new FileWriter(fileBitacora,true);
			else
				writerBitacora=new FileWriter(fileBitacora);
			
			writerBitacora.write(mensaje+"\n");
			writerBitacora.close();
		} catch (IOException e) {
			logger.info("Error {}",e.toString());
		}
	}
	
	
	public void borrarArchivos()
	{
		File[] files;
		try{
			files=Process.getInstance().getFiles(Const.PATH_RECOLECTOR);
			if(files!=null)
			for(File f:files)
				eliminarArchivoPorPeriodo(f);

			files=Process.getInstance().getFiles(Const.PATH_FINAL);
			if(files!=null)
			for(File f:files)
				eliminarArchivoPorPeriodo(f);

			files=Process.getInstance().getFiles(Const.PATH_NOPROCESADO);
			if(files!=null)
			for(File f:files)
				eliminarArchivoPorPeriodo(f);

			files=Process.getInstance().getFiles(Const.PATH_PROCESADO);
			if(files!=null)
			for(File f:files)
				eliminarArchivoPorPeriodo(f);

			files=Process.getInstance().getFiles("C://Program Files//BluetoothLector//Logs//");
			if(files!=null)
			for(File f:files)
				eliminarArchivoPorPeriodo(f);
			
			
		}catch (Exception e) {
			logger.info("Error {}",e.toString());
		}
	}
	
	private void eliminarArchivoPorPeriodo(File file)
	{
		int diasBorrado;
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
		Date hoy;
		long diferencia;
		try{
			hoy = new Date(); //Fecha de hoy
			diasBorrado=Integer.valueOf(Const.TIEMPO_BORRADO);
			

			diferencia = ( hoy.getTime() - file.lastModified() )/MILLSECS_PER_DAY;

			if(diferencia>diasBorrado)
				file.delete();
			
		}catch (Exception e) {
			logger.info("Error {}",e.toString());
		}
		
	}
}
