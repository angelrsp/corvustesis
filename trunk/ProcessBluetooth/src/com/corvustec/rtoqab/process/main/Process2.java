package com.corvustec.rtoqab.process.main;

import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sumFrom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.corvustec.rtoqab.process.util.ReadAgencia;
import com.corvustec.rtoqab.process.util.UtilApplication;
import com.corvustec.rtoqad.process.dto.DataDTO;
import com.corvustec.rtoqad.process.dto.IntervaloTiempoDTO;


public class Process2 {

	
	
	public static void main(String[] args) {
		
		long start, end;
		Double diff;
		start = System.currentTimeMillis();
		
		//insertValue();
		processOne();
		
		end = System.currentTimeMillis();
		diff=(double) (end-start);
		diff= diff* 0.001;
		System.out.println("Procesado en: "+ ( diff ) +" segundos");				
	}

	
	@SuppressWarnings("unchecked")
	private static void processOne()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String codigoAgencia="0016";
		String fechaCorte=formatter.format(new Date());
		File fileIn=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0016")+"INAQUITO 14-ABR.txt");		
		File fileOut=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0016")+"INAQUITO 14-ABRFinal.txt");

//		File fileIn=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0036")+"20140510.txt");		
//		File fileOut=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0036")+"20140510Final.txt");

		
		List<String> lines;
		String line[];
		Integer linea = null;
		List<DataDTO> dataList;
		DataDTO data;
		
		FileWriter writer;
		
		List<DataDTO> dataListDistinct;
		List<DataDTO> baliza;
		List<DataDTO> dataMac;
		List<DataDTO> dataMax;
		
		int balizaSum,index;
		double balizaAvg,balizaAvgDia;
		double varianza= 0.0,desviacion = 0.0,rango=0.0,balizaSumDbl,balizaAvgDbl,limiteSuperior,limiteInferior,limiteSuperiorDia,limiteInferiorDia,limiteSuperiorInt,limiteInferiorInt;
		
		double diaSum,diaAvg;
		
		final String baliza1="00:15:83:0C:BF:EB";
		final String baliza2="00:15:83:44:38:46";
		final String baliza3="00:15:83:45:32:D3";///esta no esta
		final String baliza4="00:15:83:4C:27:69";			

		
//		final String baliza1="00:68:58:09:15:33";
//		final String baliza2="2C:44:01:B3:F9:DD";
//		final String baliza3="F8:5F:2A:79:66:8F";
//		final String baliza4="40:BA:61:5B:31:E9";			

		
		try{			
			
			dataListDistinct =new ArrayList<DataDTO>();
			baliza=new ArrayList<DataDTO>();
			writer=new FileWriter(fileOut);
			
			dataList=new ArrayList<DataDTO>();
			dataMac=new ArrayList<DataDTO>();
			dataMax=new ArrayList<DataDTO>();			
			 
			
			lines = FileUtils.readLines(fileIn);

			for(int i=0;i<lines.size();i++)
			{
				line=lines.get(i).split("\\|");
				data=new DataDTO();
				data.setFecha(Timestamp.valueOf(line[0]));
				data.setMinuto(Time.valueOf(line[0].substring(11, 19)));
				data.setMac(line[1]);
				data.setRssi(Integer.valueOf(line[2]));
				dataList.add(data);
			}
			
			lines=null;
			
			baliza.addAll((List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                 DataDTO dat= (DataDTO)arg0;
                 if(dat.getMac().equals(baliza1)
                		 ||dat.getMac().equals(baliza2)
                		 ||dat.getMac().equals(baliza3)
                		 ||dat.getMac().equals(baliza4))
                	 return true;
                 else
                	 return false;
				}
			}));

			if(baliza.size()<=0)
			{
				System.out.println("No se encontraron balizas de referencia");
				writer.close();
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
			
			System.out.println("Se encontraron "+dataListDistinct.size());
			
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
			 * Se descartan las señales menores entre la media y desv. estandar por un factor.
			 */
			for(final DataDTO dat:dataMax)
			{
				//El numero 1 debe ser dinamico (pendiente por analizar) Factor del maximo
				if(dat.getRssi()<(balizaAvg-(desviacion*1)))
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

			System.out.println("Se encontraron "+dataListDistinct.size());
			
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

				//Sorting
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
			
			dataListDistinct=getDistinct(dataList);
			
			//Suavizar la curso con limites
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
					try {
						datoTemp=(DataDTO) BeanUtils.cloneBean(dat);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}					
					
					if(!(dat.getMedia()>=limiteInferior&&dat.getMedia()<=limiteSuperior))
						if((index-1)>=0&&(index+1)<temp.size())
							datoTemp.setMedia((temp.get(index-1).getMedia()+dat.getMedia()+temp.get(index+1).getMedia())/3);

					index=index+1;
					temp2.add(datoTemp);
				}
			}
			
			dataList=temp2;

			
			//Obtengo la media de las balizas en grupo para cada intervalo
			baliza=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                 DataDTO dat= (DataDTO)arg0;
                 if(dat.getMac().equals(baliza1)
                		 ||dat.getMac().equals(baliza2)
                		 ||dat.getMac().equals(baliza3)
                		 ||dat.getMac().equals(baliza4))
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
					temp2.get(0).setMedia(balizaAvg-(desviacion*1.65));//Factor de ajuste
										
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
			
			System.out.println("Antes de limites tiempo fila "+dataList.size());
			
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
			
			System.out.println("Antes de limites tiempo agencia "+dataList.size());
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
			
			
			System.out.println("Despues de limites tiempo agencia "+dataList.size());
			
			if(dataList.size()<=0)
			{
				System.out.println("Sin datos posible dia no atención");
				writer.close();
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
			limiteSuperiorDia=diaAvg+desviacion*1.5;
			limiteInferiorDia=diaAvg-desviacion*1.5;

			System.out.println("Avg: "+diaAvg);
			System.out.println("Des: "+desviacion);
			System.out.println("Sup: "+limiteSuperiorDia);
			System.out.println("Inf: "+limiteInferiorDia);
			
			///Aplico rangos de 15 min....
			intervaloMinuto=generateMinute();
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
			
			System.out.println("En intervalos quedan: "+ dataList.size());
			
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
					limiteSuperiorInt=balizaAvg+(desviacion*1);
					limiteInferiorInt=balizaAvg-(desviacion*1);
					
					
					
					for(DataDTO d:temp)
					{
						System.out.print("Mac : "+d.getMac()+"|");
						System.out.print("Tiempo : "+d.getTiempoFila()+"|");
						System.out.print("Media : "+balizaAvg+"|");
						System.out.print("Desviacion : "+desviacion+"|");
						System.out.print("Intervalo : "+d.getNumeroIntervaloMinuto()+"|");
						System.out.print("Limite Inferior : "+limiteInferiorInt+"|");
						System.out.println("Limite Superior : "+limiteSuperiorInt+"|");
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


			
		} catch (IOException e) {
			System.out.println("Error linea: "+linea);
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Se produjo un error: "+e.toString());
			e.printStackTrace();
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
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
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
			e.printStackTrace();
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
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
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
			e.printStackTrace();
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
}
