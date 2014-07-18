package com.corvustec.rtoqab.process.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.corvustec.rtoqab.process.util.Const;
import com.corvustec.rtoqab.process.util.ReadConfiguration;
import com.corvustec.rtoqab.process.view.util.MessageBox;

public class CambiarClave extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField pwdActual;
	private JPasswordField pwdNueva;
	private JPasswordField pwdConfirmar;
	


	/**
	 * Create the application.
	 */
	public CambiarClave() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Cambiar Clave");
		setToolTipText("");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 451, 211);
		getContentPane().setLayout(null);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual:");
		lblContraseaActual.setBounds(40, 29, 115, 14);
		getContentPane().add(lblContraseaActual);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a Nueva:");
		lblContraseaNueva.setBounds(40, 54, 115, 14);
		getContentPane().add(lblContraseaNueva);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar Nueva Contrase\u00F1a:");
		lblConfirmarNuevaContrasea.setBounds(40, 79, 165, 14);
		getContentPane().add(lblConfirmarNuevaContrasea);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCambiarActionListener(arg0);
			}
		});
		btnCambiar.setBounds(163, 125, 89, 23);
		getContentPane().add(btnCambiar);
		
		pwdActual = new JPasswordField();
		pwdActual.setBounds(209, 26, 187, 20);
		getContentPane().add(pwdActual);
		
		pwdNueva = new JPasswordField();
		pwdNueva.setToolTipText("");
		pwdNueva.setBounds(209, 51, 187, 20);
		getContentPane().add(pwdNueva);
		
		pwdConfirmar = new JPasswordField();
		pwdConfirmar.setBounds(209, 76, 187, 20);
		getContentPane().add(pwdConfirmar);
		
	}
	
	private void btnCambiarActionListener(ActionEvent arg)
	{
		String passNuevo,passConfirmar;
		try {
			passNuevo=new String(pwdNueva.getPassword());
			passConfirmar=new String(pwdConfirmar.getPassword());
			if(passNuevo.equals(passConfirmar)){
				ReadConfiguration.getInstance().replaceValue(Const.PASSWORD_KEY, passConfirmar);
				MessageBox.info("Cambiado Exitosamente");
			}
			else
				MessageBox.error("Las claves no coinciden");
		} catch (Exception e) {
			MessageBox.error(e.toString());
		}

	}
}
