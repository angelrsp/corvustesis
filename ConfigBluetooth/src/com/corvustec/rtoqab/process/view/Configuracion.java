package com.corvustec.rtoqab.process.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.corvustec.rtoqab.process.util.Const;
import com.corvustec.rtoqab.process.util.MessagesApplicacion;
import com.corvustec.rtoqab.process.util.ReadConfiguration;
import com.corvustec.rtoqab.process.view.util.MessageBox;
import javax.swing.UIManager;

public class Configuracion extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtCodigoAgencia;
	private JTextField txtRecolector;
	private JTextField txtProcesado;
	private JTextField txtFinal;

	private final String codigoAgenciaKey=Const.CODIGO_AGENCIA_KEY;
	private final String recolectorKey=Const.RECOLECTOR_KEY;
	private final String procesadoKey=Const.PROCESADO_KEY;
	private final String finalKey=Const.FINAL_KEY;
	private final String baliza1Key=Const.BALIZA1;
	private final String baliza2Key=Const.BALIZA2;
	private final String baliza3Key=Const.BALIZA3;
	private final String baliza4Key=Const.BALIZA4;
	private final String pathEjecutableKey=Const.PATH_EJECUTABLE;
	private final String minutoComprobacionKey=Const.MINUTO_COMPROBACION;
	private final String factorAjusteKey=Const.FACTOR_AJUSTE;
	private final String factorMaximoKey=Const.FACTOR_MAXIMO;
	private final String factorPromedioDia=Const.FACTOR_PROMEDIO_DIA;
	private final String factorIntervalo3=Const.FACTOR_INTERVALO3;
	
	private final String horaInicio=Const.HORA_INICIO;
	private final String horaFin=Const.HORA_FIN;
	private final String comprobarInicio=Const.COMPROBAR_INICIO;
	private final String comprobarFin=Const.COMPROBAR_FIN;
	
	private JTextField txtBaliza1;
	private JTextField txtBaliza2;
	private JTextField txtBaliza3;
	private JTextField txtBaliza4;
	private JTextField txtPathEjecutable;
	private JTextField txtMinutoComprobacion;
	private JTextField txtFactorAjuste;
	private JTextField txtFactorMaximo;
	private JTextField txtFactorPromedioDia;
	private JTextField txtFactorIntervalo3;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JTextField txtComprobacionInicio;
	private JTextField txtComprobacionFin;
	

	/**
	 * Create the frame.
	 */
	public Configuracion() {
		setTitle("Configuraci\u00F3n");
		setToolTipText("");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 863, 538);
		getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarActionPerformed(arg0);
			}
		});
		btnGuardar.setBounds(212, 467, 89, 23);
		getContentPane().add(btnGuardar);
		
		JPanel pnlRuta = new JPanel();
		pnlRuta.setBounds(10, 11, 479, 148);
		getContentPane().add(pnlRuta);
		pnlRuta.setLayout(null);
		pnlRuta.setBorder(new TitledBorder(null, "Ruta Archivos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblRutaArchivoRecolector = new JLabel("Ruta archivo recolector:");
		lblRutaArchivoRecolector.setBounds(24, 35, 201, 14);
		pnlRuta.add(lblRutaArchivoRecolector);
		
		
		txtRecolector = new JTextField();
		txtRecolector.setBounds(235, 29, 229, 20);
		pnlRuta.add(txtRecolector);
		txtRecolector.setColumns(10);
		
		JLabel lblRutaArchivoProcesado = new JLabel("Ruta archivo procesado:");
		lblRutaArchivoProcesado.setBounds(24, 59, 201, 14);
		pnlRuta.add(lblRutaArchivoProcesado);
		
		txtProcesado = new JTextField();
		txtProcesado.setBounds(235, 53, 229, 20);
		pnlRuta.add(txtProcesado);
		txtProcesado.setColumns(10);
		
		JLabel lblRutaArchivoFinal = new JLabel("Ruta archivo final:");
		lblRutaArchivoFinal.setBounds(24, 83, 201, 14);
		pnlRuta.add(lblRutaArchivoFinal);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(235, 77, 229, 20);
		pnlRuta.add(txtFinal);
		txtFinal.setColumns(10);
		
		JLabel lblRutaArchivoEjecutable = new JLabel("Ruta archivo ejecutable:");
		lblRutaArchivoEjecutable.setBounds(24, 109, 201, 14);
		pnlRuta.add(lblRutaArchivoEjecutable);
		
		txtPathEjecutable = new JTextField();
		txtPathEjecutable.setColumns(10);
		txtPathEjecutable.setBounds(235, 103, 229, 20);
		pnlRuta.add(txtPathEjecutable);
		
		JPanel pnlProceso = new JPanel();
		pnlProceso.setBorder(new TitledBorder(null, "Proceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlProceso.setBounds(10, 177, 479, 279);
		getContentPane().add(pnlProceso);
		pnlProceso.setLayout(null);
		
		JLabel lblCdigoDeAgencia = new JLabel("C\u00F3digo de agencia:");
		lblCdigoDeAgencia.setBounds(26, 62, 157, 14);
		pnlProceso.add(lblCdigoDeAgencia);
		
		txtCodigoAgencia = new JTextField();
		txtCodigoAgencia.setBounds(233, 59, 229, 20);
		pnlProceso.add(txtCodigoAgencia);
		txtCodigoAgencia.setColumns(10);
		
		txtBaliza1 = new JTextField();
		txtBaliza1.setBounds(233, 81, 229, 20);
		pnlProceso.add(txtBaliza1);
		txtBaliza1.setColumns(10);
		
		JLabel lblBaliza = new JLabel("Baliza 1:");
		lblBaliza.setBounds(26, 84, 157, 14);
		pnlProceso.add(lblBaliza);
		
		JLabel lblBaliza_1 = new JLabel("Baliza 2:");
		lblBaliza_1.setBounds(26, 106, 157, 14);
		pnlProceso.add(lblBaliza_1);
		
		txtBaliza2 = new JTextField();
		txtBaliza2.setColumns(10);
		txtBaliza2.setBounds(233, 103, 229, 20);
		pnlProceso.add(txtBaliza2);
		
		txtBaliza3 = new JTextField();
		txtBaliza3.setColumns(10);
		txtBaliza3.setBounds(233, 125, 229, 20);
		pnlProceso.add(txtBaliza3);
		
		JLabel lblBaliza_2 = new JLabel("Baliza 3:");
		lblBaliza_2.setBounds(26, 128, 157, 14);
		pnlProceso.add(lblBaliza_2);
		
		JLabel lblBaliza_3 = new JLabel("Baliza 4:");
		lblBaliza_3.setBounds(26, 150, 157, 14);
		pnlProceso.add(lblBaliza_3);
		
		txtBaliza4 = new JTextField();
		txtBaliza4.setColumns(10);
		txtBaliza4.setBounds(233, 147, 229, 20);
		pnlProceso.add(txtBaliza4);
		
		JLabel lblTiempoDeComprobacin = new JLabel("Intervalo comprobaci\u00F3n (min):");
		lblTiempoDeComprobacin.setBounds(26, 40, 157, 14);
		pnlProceso.add(lblTiempoDeComprobacin);
		
		txtMinutoComprobacion = new JTextField();
		txtMinutoComprobacion.setColumns(10);
		txtMinutoComprobacion.setBounds(233, 37, 229, 20);
		pnlProceso.add(txtMinutoComprobacion);
		
		JLabel lblFactorDeAjuste = new JLabel("Factor de Ajuste:");
		lblFactorDeAjuste.setBounds(26, 172, 157, 14);
		pnlProceso.add(lblFactorDeAjuste);
		
		txtFactorAjuste = new JTextField();
		txtFactorAjuste.setColumns(10);
		txtFactorAjuste.setBounds(233, 169, 229, 20);
		pnlProceso.add(txtFactorAjuste);
		
		txtFactorMaximo = new JTextField();
		txtFactorMaximo.setColumns(10);
		txtFactorMaximo.setBounds(233, 191, 229, 20);
		pnlProceso.add(txtFactorMaximo);
		
		JLabel lblFactorDeMaximo = new JLabel("Factor de Maximo:");
		lblFactorDeMaximo.setBounds(26, 194, 157, 14);
		pnlProceso.add(lblFactorDeMaximo);
		
		txtFactorPromedioDia = new JTextField();
		txtFactorPromedioDia.setColumns(10);
		txtFactorPromedioDia.setBounds(233, 214, 229, 20);
		pnlProceso.add(txtFactorPromedioDia);
		
		JLabel lblFactorPromedioDia = new JLabel("Factor Promedio Dia:");
		lblFactorPromedioDia.setBounds(26, 217, 157, 14);
		pnlProceso.add(lblFactorPromedioDia);
		
		JLabel lblFactorIntervalo = new JLabel("Factor Intervalo 3:");
		lblFactorIntervalo.setBounds(26, 240, 157, 14);
		pnlProceso.add(lblFactorIntervalo);
		
		txtFactorIntervalo3 = new JTextField();
		txtFactorIntervalo3.setColumns(10);
		txtFactorIntervalo3.setBounds(233, 237, 229, 20);
		pnlProceso.add(txtFactorIntervalo3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tiempo (Servicio)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(488, 11, 350, 148);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setColumns(10);
		txtHoraInicio.setBounds(181, 30, 159, 20);
		panel.add(txtHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(10, 33, 101, 14);
		panel.add(lblHoraInicio);
		
		txtHoraFin = new JTextField();
		txtHoraFin.setColumns(10);
		txtHoraFin.setBounds(181, 54, 159, 20);
		panel.add(txtHoraFin);
		
		JLabel lblHoraFin = new JLabel("Hora Fin:");
		lblHoraFin.setBounds(10, 57, 101, 14);
		panel.add(lblHoraFin);
		
		JLabel lblComprobacionIniciom = new JLabel("Comprobacion Inicio (min):");
		lblComprobacionIniciom.setBounds(10, 83, 161, 14);
		panel.add(lblComprobacionIniciom);
		
		txtComprobacionInicio = new JTextField();
		txtComprobacionInicio.setColumns(10);
		txtComprobacionInicio.setBounds(181, 80, 159, 20);
		panel.add(txtComprobacionInicio);
		
		JLabel lblComprobacionFinm = new JLabel("Comprobacion Fin (min):");
		lblComprobacionFinm.setBounds(10, 108, 161, 14);
		panel.add(lblComprobacionFinm);
		
		txtComprobacionFin = new JTextField();
		txtComprobacionFin.setColumns(10);
		txtComprobacionFin.setBounds(181, 105, 159, 20);
		panel.add(txtComprobacionFin);

		setTxtValues();
	}
	
	
	private void btnGuardarActionPerformed(ActionEvent event)
	{
		try{
			ReadConfiguration.getInstance().replaceValue(codigoAgenciaKey, txtCodigoAgencia.getText());
			ReadConfiguration.getInstance().replaceValue(recolectorKey, txtRecolector.getText());
			ReadConfiguration.getInstance().replaceValue(procesadoKey, txtProcesado.getText());
			ReadConfiguration.getInstance().replaceValue(finalKey, txtFinal.getText());
			ReadConfiguration.getInstance().replaceValue(baliza1Key, txtBaliza1.getText());
			ReadConfiguration.getInstance().replaceValue(baliza2Key, txtBaliza2.getText());
			ReadConfiguration.getInstance().replaceValue(baliza3Key, txtBaliza3.getText());
			ReadConfiguration.getInstance().replaceValue(baliza4Key, txtBaliza4.getText());
			ReadConfiguration.getInstance().replaceValue(pathEjecutableKey, txtPathEjecutable.getText());
			ReadConfiguration.getInstance().replaceValue(minutoComprobacionKey, txtMinutoComprobacion.getText());
			ReadConfiguration.getInstance().replaceValue(factorAjusteKey, txtFactorAjuste.getText());
			ReadConfiguration.getInstance().replaceValue(factorMaximoKey, txtFactorMaximo.getText());
			ReadConfiguration.getInstance().replaceValue(factorPromedioDia, txtFactorPromedioDia.getText());
			ReadConfiguration.getInstance().replaceValue(factorIntervalo3, txtFactorIntervalo3.getText());

			ReadConfiguration.getInstance().replaceValue(horaInicio, txtHoraInicio.getText());
			ReadConfiguration.getInstance().replaceValue(horaFin, txtHoraFin.getText());
			ReadConfiguration.getInstance().replaceValue(comprobarInicio, txtComprobacionInicio.getText());
			ReadConfiguration.getInstance().replaceValue(comprobarFin, txtComprobacionFin.getText());

			
			setTxtValues();
			
			MessageBox.info(MessagesApplicacion.getString("com.corvustec.rtoqab.change.ok"));
		}
		catch (Exception e)
		{
			MessageBox.error(e.toString());
		}
	}
	
	private void setTxtValues()
	{
		try{
			txtCodigoAgencia.setText(ReadConfiguration.getInstance().readValue(codigoAgenciaKey));
			txtRecolector.setText(ReadConfiguration.getInstance().readValue(recolectorKey));
			txtProcesado.setText(ReadConfiguration.getInstance().readValue(procesadoKey));
			txtFinal.setText(ReadConfiguration.getInstance().readValue(finalKey));
			txtBaliza1.setText(ReadConfiguration.getInstance().readValue(baliza1Key));
			txtBaliza2.setText(ReadConfiguration.getInstance().readValue(baliza2Key));
			txtBaliza3.setText(ReadConfiguration.getInstance().readValue(baliza3Key));
			txtBaliza4.setText(ReadConfiguration.getInstance().readValue(baliza4Key));
			txtPathEjecutable.setText(ReadConfiguration.getInstance().readValue(pathEjecutableKey));
			txtMinutoComprobacion.setText(ReadConfiguration.getInstance().readValue(minutoComprobacionKey));
			txtFactorAjuste.setText(ReadConfiguration.getInstance().readValue(factorAjusteKey));
			txtFactorMaximo.setText(ReadConfiguration.getInstance().readValue(factorMaximoKey));
			txtFactorPromedioDia.setText(ReadConfiguration.getInstance().readValue(factorPromedioDia));
			txtFactorIntervalo3.setText(ReadConfiguration.getInstance().readValue(factorIntervalo3));
			
			txtHoraInicio.setText(ReadConfiguration.getInstance().readValue(horaInicio));
			txtHoraFin.setText(ReadConfiguration.getInstance().readValue(horaFin));
			txtComprobacionInicio.setText(ReadConfiguration.getInstance().readValue(comprobarInicio));
			txtComprobacionFin.setText(ReadConfiguration.getInstance().readValue(comprobarFin));
		}
		catch (Exception e)
		{
			MessageBox.error(e.toString());
		}
	}
}
