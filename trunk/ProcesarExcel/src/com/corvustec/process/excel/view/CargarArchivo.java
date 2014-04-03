package com.corvustec.process.excel.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargarArchivo {

	private JFrame frame;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarArchivo window = new CargarArchivo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CargarArchivo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			  /**llamamos el metodo que permite cargar la ventana*/
			   JFileChooser fileChooser=new JFileChooser();
			   FileFilter filter=new FileNameExtensionFilter("JPEG file", new String[] {"jpg", "jpeg"});
			   fileChooser.setFileFilter(filter);
			   fileChooser.setAcceptAllFileFilterUsed(false);
			   fileChooser.showOpenDialog(frame);
			   /**abrimos el archivo seleccionado*/
			   File file=fileChooser.getSelectedFile();
			   if(file!=null)
				   textField.setText(file.getAbsolutePath());
			   
			}
		});
		btnNewButton.setBounds(88, 83, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(187, 84, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
