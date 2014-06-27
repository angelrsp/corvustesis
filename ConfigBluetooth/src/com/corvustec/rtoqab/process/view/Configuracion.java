package com.corvustec.rtoqab.process.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.StringUtils;

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
	private JTextField txtBitacora;
	private JTextField txtFactorAjuste;
	private JTextField txtFactorMaximo;
	private JTextField txtFactorPromedioDia;
	private JTextField txtFactorIntervalo3;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JTextField txtTiempoComprobacion;
	private JTextField txtNoProcesado;
	private JTextField txtBaliza;
	private JTextField txtMaximoArchivo;
	
	private JList<String> jlistBaliza;
	private DefaultListModel<String> defaultListModel;
	

	private final String codigoAgenciaKey=Const.CODIGO_AGENCIA_KEY;
	private final String recolectorKey=Const.RECOLECTOR_KEY;
	private final String procesadoKey=Const.PROCESADO_KEY;
	private final String noProcesadoKey=Const.NOPROCESADO_KEY;
	private final String finalKey=Const.FINAL_KEY;
	private final String balizaKey=Const.BALIZA_KEY;
	private final String bitacoraKey=Const.BITACORA_KEY;
	
	private final String tiempoComprobacionKey=Const.TIEMPO_COMPROBACION_KEY;
	private final String factorAjusteKey=Const.FACTOR_AJUSTE_KEY;
	private final String factorMaximoKey=Const.FACTOR_MAXIMO_KEY;
	private final String factorPromedioDia=Const.FACTOR_PROMEDIO_DIA_KEY;
	private final String factorIntervalo3=Const.FACTOR_INTERVALO3_KEY;
	
	private final String horaInicio=Const.HORA_INICIO_KEY;
	private final String horaFin=Const.HORA_FIN_KEY;
	private final String tiempoMaximoArchivo=Const.TIEMPO_MAXIMO_ARCHIVO_KEY;
	

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
		setBounds(100, 100, 907, 466);
		getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarActionPerformed(arg0);
			}
		});
		btnGuardar.setBounds(400, 403, 89, 23);
		getContentPane().add(btnGuardar);
		
		JPanel pnlRuta = new JPanel();
		pnlRuta.setBounds(10, 11, 479, 171);
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
		
		JLabel lblRutaArchivoEjecutable = new JLabel("Ruta archivo bitacora:");
		lblRutaArchivoEjecutable.setBounds(24, 106, 201, 14);
		pnlRuta.add(lblRutaArchivoEjecutable);
		
		txtBitacora = new JTextField();
		txtBitacora.setColumns(10);
		txtBitacora.setBounds(235, 103, 229, 20);
		pnlRuta.add(txtBitacora);
		
		txtNoProcesado = new JTextField();
		txtNoProcesado.setText((String) null);
		txtNoProcesado.setColumns(10);
		txtNoProcesado.setBounds(235, 128, 229, 20);
		pnlRuta.add(txtNoProcesado);
		
		JLabel lblRutaArchivoNo = new JLabel("Ruta archivo no procesado:");
		lblRutaArchivoNo.setBounds(24, 131, 201, 14);
		pnlRuta.add(lblRutaArchivoNo);
		
		JPanel pnlProceso = new JPanel();
		pnlProceso.setBorder(new TitledBorder(null, "Proceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlProceso.setBounds(10, 182, 479, 210);
		getContentPane().add(pnlProceso);
		pnlProceso.setLayout(null);
		
		JLabel lblCdigoDeAgencia = new JLabel("C\u00F3digo de agencia:");
		lblCdigoDeAgencia.setBounds(26, 35, 157, 14);
		pnlProceso.add(lblCdigoDeAgencia);
		
		txtCodigoAgencia = new JTextField();
		txtCodigoAgencia.setBounds(233, 32, 229, 20);
		pnlProceso.add(txtCodigoAgencia);
		txtCodigoAgencia.setColumns(10);
		
		JLabel lblFactorDeAjuste = new JLabel("Factor de Ajuste:");
		lblFactorDeAjuste.setBounds(26, 58, 157, 14);
		pnlProceso.add(lblFactorDeAjuste);
		
		txtFactorAjuste = new JTextField();
		txtFactorAjuste.setColumns(10);
		txtFactorAjuste.setBounds(233, 55, 229, 20);
		pnlProceso.add(txtFactorAjuste);
		
		txtFactorMaximo = new JTextField();
		txtFactorMaximo.setColumns(10);
		txtFactorMaximo.setBounds(233, 79, 229, 20);
		pnlProceso.add(txtFactorMaximo);
		
		JLabel lblFactorDeMaximo = new JLabel("Factor de Maximo:");
		lblFactorDeMaximo.setBounds(26, 82, 157, 14);
		pnlProceso.add(lblFactorDeMaximo);
		
		txtFactorPromedioDia = new JTextField();
		txtFactorPromedioDia.setColumns(10);
		txtFactorPromedioDia.setBounds(233, 103, 229, 20);
		pnlProceso.add(txtFactorPromedioDia);
		
		JLabel lblFactorPromedioDia = new JLabel("Factor Promedio Dia:");
		lblFactorPromedioDia.setBounds(26, 106, 157, 14);
		pnlProceso.add(lblFactorPromedioDia);
		
		JLabel lblFactorIntervalo = new JLabel("Factor Intervalo 3:");
		lblFactorIntervalo.setBounds(26, 131, 157, 14);
		pnlProceso.add(lblFactorIntervalo);
		
		txtFactorIntervalo3 = new JTextField();
		txtFactorIntervalo3.setColumns(10);
		txtFactorIntervalo3.setBounds(233, 128, 229, 20);
		pnlProceso.add(txtFactorIntervalo3);
		
		txtMaximoArchivo = new JTextField();
		txtMaximoArchivo.setText("1");
		txtMaximoArchivo.setColumns(10);
		txtMaximoArchivo.setBounds(233, 154, 229, 20);
		pnlProceso.add(txtMaximoArchivo);
		
		JLabel lblTiempoMaximoArchivos = new JLabel("Tiempo Maximo Archivos (d\u00EDa):");
		lblTiempoMaximoArchivos.setBounds(26, 157, 157, 14);
		pnlProceso.add(lblTiempoMaximoArchivos);
		
		JPanel pnlServicio = new JPanel();
		pnlServicio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tiempo (Servicio)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlServicio.setBounds(488, 11, 393, 115);
		getContentPane().add(pnlServicio);
		pnlServicio.setLayout(null);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setColumns(10);
		txtHoraInicio.setBounds(181, 30, 202, 20);
		pnlServicio.add(txtHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(10, 33, 101, 14);
		pnlServicio.add(lblHoraInicio);
		
		txtHoraFin = new JTextField();
		txtHoraFin.setColumns(10);
		txtHoraFin.setBounds(181, 54, 202, 20);
		pnlServicio.add(txtHoraFin);
		
		JLabel lblHoraFin = new JLabel("Hora Fin:");
		lblHoraFin.setBounds(10, 57, 101, 14);
		pnlServicio.add(lblHoraFin);
		
		JLabel lblComprobacionIniciom = new JLabel("Comprobacion (seg):");
		lblComprobacionIniciom.setBounds(10, 83, 161, 14);
		pnlServicio.add(lblComprobacionIniciom);
		
		txtTiempoComprobacion = new JTextField();
		txtTiempoComprobacion.setColumns(10);
		txtTiempoComprobacion.setBounds(181, 80, 202, 20);
		pnlServicio.add(txtTiempoComprobacion);
		
		JPanel pnlBaliza = new JPanel();
		pnlBaliza.setLayout(null);
		pnlBaliza.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Balizas de Referencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBaliza.setBounds(488, 137, 393, 216);
		getContentPane().add(pnlBaliza);
		
		JLabel lblBaliza = new JLabel("Baliza (mac):");
		lblBaliza.setBounds(10, 32, 161, 14);
		pnlBaliza.add(lblBaliza);
		
		txtBaliza = new JTextField();
		txtBaliza.setText((String) null);
		txtBaliza.setColumns(10);
		txtBaliza.setBounds(181, 26, 202, 20);
		pnlBaliza.add(txtBaliza);
		
		JButton btnAgregarBaliza = new JButton("Agregar");
		btnAgregarBaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAgregarBalizaActionPerformed(arg0);
			}
		});
		
		btnAgregarBaliza.setBounds(68, 57, 89, 23);
		pnlBaliza.add(btnAgregarBaliza);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 373, 107);
		pnlBaliza.add(scrollPane);
		
		jlistBaliza = new JList<String>();
		scrollPane.setViewportView(jlistBaliza);
		jlistBaliza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jlistBalizaMouseListener(arg0);
			}
		});
		jlistBaliza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnResetBaliza = new JButton("Reset");
		btnResetBaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnResetBalizaActionPerformed(arg0);
			}
		});
		btnResetBaliza.setBounds(167, 57, 89, 23);
		pnlBaliza.add(btnResetBaliza);
		
		JButton btnEliminarBaliza = new JButton("Eliminar");
		btnEliminarBaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarBalizaActionPerformed(arg0);
			}
		});
		btnEliminarBaliza.setBounds(266, 57, 89, 23);
		pnlBaliza.add(btnEliminarBaliza);

		setTxtValues();
	}
	
	private void btnEliminarBalizaActionPerformed(ActionEvent event)
	{
		defaultListModel.removeElement(jlistBaliza.getSelectedValue());
		jlistBaliza.setModel(defaultListModel);
	}

	private void btnResetBalizaActionPerformed(ActionEvent event)
	{
		jlistBaliza.clearSelection();
		txtBaliza.setText(null);
	}

	
	private void jlistBalizaMouseListener(MouseEvent event)
	{
		if(event.getClickCount()==2)
		{
			txtBaliza.setText(jlistBaliza.getSelectedValue());
		}
	}
	
	private void btnAgregarBalizaActionPerformed(ActionEvent event)
	{
		try{
			if(StringUtils.isNotBlank(txtBaliza.getText())&&StringUtils.isNotEmpty(txtBaliza.getText())){
				if(jlistBaliza.isSelectionEmpty()){
					defaultListModel.addElement(txtBaliza.getText());
				}
				else{
					defaultListModel.set(jlistBaliza.getSelectedIndex(), txtBaliza.getText());
				}
				jlistBaliza.setModel(defaultListModel);
				txtBaliza.setText(null);
			}
		}
		catch(Exception e){
			MessageBox.error(e.toString());
		}
	}
	
	
	private void btnGuardarActionPerformed(ActionEvent event)
	{
		String balizasValue="";
		try{
			
			if(defaultListModel.getSize()<=0)
			{
				MessageBox.error("Debe agregar balizas de referencia");
				return;
			}
			
			ReadConfiguration.getInstance().replaceValue(codigoAgenciaKey, txtCodigoAgencia.getText());
			ReadConfiguration.getInstance().replaceValue(recolectorKey, txtRecolector.getText());
			ReadConfiguration.getInstance().replaceValue(procesadoKey, txtProcesado.getText());
			ReadConfiguration.getInstance().replaceValue(finalKey, txtFinal.getText());
			
			ReadConfiguration.getInstance().replaceValue(tiempoComprobacionKey, txtTiempoComprobacion.getText());
			ReadConfiguration.getInstance().replaceValue(factorAjusteKey, txtFactorAjuste.getText());
			ReadConfiguration.getInstance().replaceValue(factorMaximoKey, txtFactorMaximo.getText());
			ReadConfiguration.getInstance().replaceValue(factorPromedioDia, txtFactorPromedioDia.getText());
			ReadConfiguration.getInstance().replaceValue(factorIntervalo3, txtFactorIntervalo3.getText());
			ReadConfiguration.getInstance().replaceValue(bitacoraKey, txtBitacora.getText());
			ReadConfiguration.getInstance().replaceValue(noProcesadoKey, txtNoProcesado.getText());

			ReadConfiguration.getInstance().replaceValue(horaInicio, txtHoraInicio.getText());
			ReadConfiguration.getInstance().replaceValue(horaFin, txtHoraFin.getText());
			ReadConfiguration.getInstance().replaceValue(tiempoMaximoArchivo, txtMaximoArchivo.getText());
			
			for(int i=0;i< defaultListModel.getSize();i++)
			{
				balizasValue=defaultListModel.get(i)+"|"+balizasValue;
			}
			
			ReadConfiguration.getInstance().replaceValue(balizaKey, balizasValue);
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
		String[] balizas;
		try{
			txtCodigoAgencia.setText(ReadConfiguration.getInstance().readValue(codigoAgenciaKey));
			txtRecolector.setText(ReadConfiguration.getInstance().readValue(recolectorKey));
			txtProcesado.setText(ReadConfiguration.getInstance().readValue(procesadoKey));
			txtFinal.setText(ReadConfiguration.getInstance().readValue(finalKey));
			txtBitacora.setText(ReadConfiguration.getInstance().readValue(bitacoraKey));
			txtFactorAjuste.setText(ReadConfiguration.getInstance().readValue(factorAjusteKey));
			txtFactorMaximo.setText(ReadConfiguration.getInstance().readValue(factorMaximoKey));
			txtFactorPromedioDia.setText(ReadConfiguration.getInstance().readValue(factorPromedioDia));
			txtFactorIntervalo3.setText(ReadConfiguration.getInstance().readValue(factorIntervalo3));
			txtNoProcesado.setText(ReadConfiguration.getInstance().readValue(noProcesadoKey));
			txtHoraInicio.setText(ReadConfiguration.getInstance().readValue(horaInicio));
			txtHoraFin.setText(ReadConfiguration.getInstance().readValue(horaFin));
			txtTiempoComprobacion.setText(ReadConfiguration.getInstance().readValue(tiempoComprobacionKey));
			txtMaximoArchivo.setText(ReadConfiguration.getInstance().readValue(tiempoMaximoArchivo));
			
			
			balizas=ReadConfiguration.getInstance().readValue(balizaKey).split("\\|");
			defaultListModel=new DefaultListModel<String>();
			for(int i=0;i<balizas.length;i++)
			{
				defaultListModel.addElement(balizas[i]);
			}
			jlistBaliza.setModel(defaultListModel);
		}
		catch (Exception e)
		{
			MessageBox.error(e.toString());
		}
	}
}
