package com.corvustec.rtoqab.process.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import com.corvustec.rtoqab.process.util.Const;
import com.corvustec.rtoqab.process.util.MessagesApplicacion;
import com.corvustec.rtoqab.process.util.ReadConfiguration;
import com.corvustec.rtoqab.process.view.util.MessageBox;

public class ConfiguracionSftp extends JInternalFrame{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTextField txtServidor;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtclaveArchivo;
	private JTextField txtPathLocal;
	private JTextField txtPathRemoto;
	
	
	private JCheckBox chbAplicarArchivo;
	
	
	public String servidor = Const.SERVIDOR_KEY;
	public String puerto = Const.PUERTO_KEY;
	public String usuario = Const.USUARIO_KEY;
	public String clave = Const.CLAVE_KEY;
	public String claveArvhivo = Const.CLAVE_ARCHIVO_KEY;
	public String aplicarClaveArchivo = Const.APLICAR_CLAVE_ARCHIVO_KEY;
	public String pathLocal = Const.PATH_LOCAL_KEY;
	public String pathRemoto = Const.PATH_REMOTO_KEY;

	
	/**
	 * Create the application.
	 */
	public ConfiguracionSftp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Configuraci\u00F3n SFTP");
		setToolTipText("");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 855, 347);
		getContentPane().setLayout(null);
		
		JPanel pnlAcceso = new JPanel();
		pnlAcceso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAcceso.setBounds(10, 22, 440, 236);
		getContentPane().add(pnlAcceso);
		pnlAcceso.setLayout(null);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(10, 74, 106, 14);
		pnlAcceso.add(lblPuerto);
		
		JLabel lblServidor = new JLabel("Servidor:");
		lblServidor.setBounds(10, 48, 106, 14);
		pnlAcceso.add(lblServidor);
		
		txtServidor = new JTextField();
		txtServidor.setBounds(126, 45, 159, 20);
		pnlAcceso.add(txtServidor);
		txtServidor.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setColumns(10);
		txtPuerto.setBounds(126, 71, 159, 20);
		pnlAcceso.add(txtPuerto);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(126, 96, 159, 20);
		pnlAcceso.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 99, 106, 14);
		pnlAcceso.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 125, 106, 14);
		pnlAcceso.add(lblContrasea);
		
		txtClave = new JTextField();
		txtClave.setBounds(126, 122, 159, 20);
		pnlAcceso.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblContraseaArchivo = new JLabel("Contrase\u00F1a Archivo:");
		lblContraseaArchivo.setBounds(10, 153, 106, 14);
		pnlAcceso.add(lblContraseaArchivo);
		
		txtclaveArchivo = new JTextField();
		txtclaveArchivo.setBounds(126, 150, 159, 20);
		pnlAcceso.add(txtclaveArchivo);
		txtclaveArchivo.setColumns(10);
		
		chbAplicarArchivo = new JCheckBox("Aplicar Archivo");
		chbAplicarArchivo.setBounds(302, 149, 119, 23);
		pnlAcceso.add(chbAplicarArchivo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarActionPerformed(arg0);
			}
		});
		btnGuardar.setBounds(409, 269, 89, 23);
		getContentPane().add(btnGuardar);
		
		JPanel pnlDirectorio = new JPanel();
		pnlDirectorio.setBorder(new TitledBorder(null, "Directorio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDirectorio.setBounds(460, 22, 365, 236);
		getContentPane().add(pnlDirectorio);
		pnlDirectorio.setLayout(null);
		
		JLabel lblPathLocal = new JLabel("Path Local:");
		lblPathLocal.setBounds(10, 48, 76, 14);
		pnlDirectorio.add(lblPathLocal);
		
		txtPathLocal = new JTextField();
		txtPathLocal.setBounds(149, 45, 206, 20);
		pnlDirectorio.add(txtPathLocal);
		txtPathLocal.setColumns(10);
		
		txtPathRemoto = new JTextField();
		txtPathRemoto.setBounds(149, 76, 206, 20);
		pnlDirectorio.add(txtPathRemoto);
		txtPathRemoto.setColumns(10);
		
		JLabel lblPathRemoto = new JLabel("Path Remoto:");
		lblPathRemoto.setBounds(10, 79, 96, 14);
		pnlDirectorio.add(lblPathRemoto);
		
		setValue();
	}
	
	private void btnGuardarActionPerformed(ActionEvent arg0)
	{
		try {
			ReadConfiguration.getInstance().replaceValue(servidor, txtServidor.getText());
			ReadConfiguration.getInstance().replaceValue(puerto, txtPuerto.getText());
			ReadConfiguration.getInstance().replaceValue(usuario, txtUsuario.getText());
			ReadConfiguration.getInstance().replaceValue(clave, txtClave.getText());
			ReadConfiguration.getInstance().replaceValue(claveArvhivo, txtclaveArchivo.getText());
			ReadConfiguration.getInstance().replaceValue(pathLocal, txtPathLocal.getText());
			ReadConfiguration.getInstance().replaceValue(pathRemoto, txtPathRemoto.getText());
			if(chbAplicarArchivo.isSelected())
				ReadConfiguration.getInstance().replaceValue(aplicarClaveArchivo,  String.valueOf(1));
			else
				ReadConfiguration.getInstance().replaceValue(aplicarClaveArchivo,  String.valueOf(0));
			
			setValue();
			
			MessageBox.info(MessagesApplicacion.getString("com.corvustec.rtoqab.change.ok"));
		} catch (Exception e) {
			MessageBox.error(e.toString());
		}
	}
	
	private void setValue()
	{
		txtServidor.setText(ReadConfiguration.getInstance().readValue(servidor));
		txtPuerto.setText(ReadConfiguration.getInstance().readValue(puerto));
		txtUsuario.setText(ReadConfiguration.getInstance().readValue(usuario));
		txtClave.setText(ReadConfiguration.getInstance().readValue(clave));
		txtclaveArchivo.setText(ReadConfiguration.getInstance().readValue(claveArvhivo));
		txtPathLocal.setText(ReadConfiguration.getInstance().readValue(pathLocal));
		txtPathRemoto.setText(ReadConfiguration.getInstance().readValue(pathRemoto));
		
		if(Integer.valueOf(ReadConfiguration.getInstance().readValue(aplicarClaveArchivo))==1)
			chbAplicarArchivo.setSelected(true);
		else
			chbAplicarArchivo.setSelected(false);
		
	}
}
