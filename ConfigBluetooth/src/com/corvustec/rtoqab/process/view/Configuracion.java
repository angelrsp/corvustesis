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
		setBounds(100, 100, 569, 570);
		getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarActionPerformed(arg0);
			}
		});
		btnGuardar.setBounds(215, 507, 89, 23);
		getContentPane().add(btnGuardar);
		
		JPanel pnlRuta = new JPanel();
		pnlRuta.setBounds(10, 11, 533, 148);
		getContentPane().add(pnlRuta);
		pnlRuta.setLayout(null);
		pnlRuta.setBorder(new TitledBorder(null, "Ruta Archivos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblRutaArchivoRecolector = new JLabel("Ruta archivo recolector:");
		lblRutaArchivoRecolector.setBounds(32, 35, 201, 14);
		pnlRuta.add(lblRutaArchivoRecolector);
		
		
		txtRecolector = new JTextField();
		txtRecolector.setBounds(243, 29, 195, 20);
		pnlRuta.add(txtRecolector);
		txtRecolector.setColumns(10);
		
		JLabel lblRutaArchivoProcesado = new JLabel("Ruta archivo procesado:");
		lblRutaArchivoProcesado.setBounds(32, 59, 201, 14);
		pnlRuta.add(lblRutaArchivoProcesado);
		
		txtProcesado = new JTextField();
		txtProcesado.setBounds(243, 53, 195, 20);
		pnlRuta.add(txtProcesado);
		txtProcesado.setColumns(10);
		
		JLabel lblRutaArchivoFinal = new JLabel("Ruta archivo final:");
		lblRutaArchivoFinal.setBounds(32, 83, 201, 14);
		pnlRuta.add(lblRutaArchivoFinal);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(243, 77, 195, 20);
		pnlRuta.add(txtFinal);
		txtFinal.setColumns(10);
		
		JLabel lblRutaArchivoEjecutable = new JLabel("Ruta archivo ejecutable:");
		lblRutaArchivoEjecutable.setBounds(32, 109, 201, 14);
		pnlRuta.add(lblRutaArchivoEjecutable);
		
		txtPathEjecutable = new JTextField();
		txtPathEjecutable.setColumns(10);
		txtPathEjecutable.setBounds(243, 103, 195, 20);
		pnlRuta.add(txtPathEjecutable);
		
		JPanel pnlProceso = new JPanel();
		pnlProceso.setBorder(new TitledBorder(null, "Proceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlProceso.setBounds(10, 177, 533, 319);
		getContentPane().add(pnlProceso);
		pnlProceso.setLayout(null);
		
		JLabel lblCdigoDeAgencia = new JLabel("C\u00F3digo de agencia:");
		lblCdigoDeAgencia.setBounds(38, 64, 157, 14);
		pnlProceso.add(lblCdigoDeAgencia);
		
		txtCodigoAgencia = new JTextField();
		txtCodigoAgencia.setBounds(245, 61, 195, 20);
		pnlProceso.add(txtCodigoAgencia);
		txtCodigoAgencia.setColumns(10);
		
		txtBaliza1 = new JTextField();
		txtBaliza1.setBounds(245, 85, 195, 20);
		pnlProceso.add(txtBaliza1);
		txtBaliza1.setColumns(10);
		
		JLabel lblBaliza = new JLabel("Baliza 1:");
		lblBaliza.setBounds(38, 89, 157, 14);
		pnlProceso.add(lblBaliza);
		
		JLabel lblBaliza_1 = new JLabel("Baliza 2:");
		lblBaliza_1.setBounds(38, 113, 157, 14);
		pnlProceso.add(lblBaliza_1);
		
		txtBaliza2 = new JTextField();
		txtBaliza2.setColumns(10);
		txtBaliza2.setBounds(245, 110, 195, 20);
		pnlProceso.add(txtBaliza2);
		
		txtBaliza3 = new JTextField();
		txtBaliza3.setColumns(10);
		txtBaliza3.setBounds(245, 135, 195, 20);
		pnlProceso.add(txtBaliza3);
		
		JLabel lblBaliza_2 = new JLabel("Baliza 3:");
		lblBaliza_2.setBounds(38, 138, 157, 14);
		pnlProceso.add(lblBaliza_2);
		
		JLabel lblBaliza_3 = new JLabel("Baliza 4:");
		lblBaliza_3.setBounds(38, 163, 157, 14);
		pnlProceso.add(lblBaliza_3);
		
		txtBaliza4 = new JTextField();
		txtBaliza4.setColumns(10);
		txtBaliza4.setBounds(245, 160, 195, 20);
		pnlProceso.add(txtBaliza4);
		
		JLabel lblTiempoDeComprobacin = new JLabel("Minuto de comprobaci\u00F3n:");
		lblTiempoDeComprobacin.setBounds(38, 40, 157, 14);
		pnlProceso.add(lblTiempoDeComprobacin);
		
		txtMinutoComprobacion = new JTextField();
		txtMinutoComprobacion.setColumns(10);
		txtMinutoComprobacion.setBounds(245, 37, 195, 20);
		pnlProceso.add(txtMinutoComprobacion);
		
		JLabel lblFactorDeAjuste = new JLabel("Factor de Ajuste:");
		lblFactorDeAjuste.setBounds(38, 191, 157, 14);
		pnlProceso.add(lblFactorDeAjuste);
		
		txtFactorAjuste = new JTextField();
		txtFactorAjuste.setColumns(10);
		txtFactorAjuste.setBounds(245, 185, 195, 20);
		pnlProceso.add(txtFactorAjuste);
		
		txtFactorMaximo = new JTextField();
		txtFactorMaximo.setColumns(10);
		txtFactorMaximo.setBounds(245, 208, 195, 20);
		pnlProceso.add(txtFactorMaximo);
		
		JLabel lblFactorDeMaximo = new JLabel("Factor de Maximo:");
		lblFactorDeMaximo.setBounds(38, 214, 157, 14);
		pnlProceso.add(lblFactorDeMaximo);
		
		txtFactorPromedioDia = new JTextField();
		txtFactorPromedioDia.setColumns(10);
		txtFactorPromedioDia.setBounds(245, 231, 195, 20);
		pnlProceso.add(txtFactorPromedioDia);
		
		JLabel lblFactorPromedioDia = new JLabel("Factor Promedio Dia:");
		lblFactorPromedioDia.setBounds(38, 237, 157, 14);
		pnlProceso.add(lblFactorPromedioDia);
		
		JLabel lblFactorIntervalo = new JLabel("Factor Intervalo 3:");
		lblFactorIntervalo.setBounds(38, 260, 157, 14);
		pnlProceso.add(lblFactorIntervalo);
		
		txtFactorIntervalo3 = new JTextField();
		txtFactorIntervalo3.setColumns(10);
		txtFactorIntervalo3.setBounds(245, 254, 195, 20);
		pnlProceso.add(txtFactorIntervalo3);

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
		}
		catch (Exception e)
		{
			MessageBox.error(e.toString());
		}
	}
}
