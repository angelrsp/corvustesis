package com.corvustec.process.excel.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.lang3.StringUtils;

import com.corvustec.process.excel.service.ExcelService;
import com.corvustec.process.excel.util.MessageBox;
import com.corvustec.process.excel.util.MessagesApplicacion;

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
		
		JButton btnNewButton = new JButton("Seleccionar...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			  /**llamamos el metodo que permite cargar la ventana*/
			   JFileChooser fileChooser=new JFileChooser();
			   FileFilter filter=new FileNameExtensionFilter("CSV file", new String[] {"csv"});
			   fileChooser.setFileFilter(filter);
			   fileChooser.setAcceptAllFileFilterUsed(false);
			   fileChooser.showOpenDialog(frame);
			   /**abrimos el archivo seleccionado*/
			   File file=fileChooser.getSelectedFile();
			   if(file!=null)
				   textField.setText(file.getAbsolutePath());
			   
			}
		});
		btnNewButton.setBounds(10, 83, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(144, 84, 280, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JButton btnCargar = new JButton("Cargar Datos");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {				
					if(!StringUtils.isEmpty(textField.getText()))
					ExcelService.executeImport(textField.getText());
					MessageBox.info("Consulta Terminada");
				} catch (SQLException e) {
					MessageBox.error(e.toString());
				}
			}
		});
		btnCargar.setBounds(132, 129, 134, 23);
		frame.getContentPane().add(btnCargar);
		
		JButton btnExportarExcel = new JButton("Exportar Excel");
		btnExportarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ExcelService.cargarExcel(MessagesApplicacion.getString("com.corvustec.excel.template"));
					MessageBox.info("Proceso Terminado");
				} catch (IOException | SQLException e) {
					MessageBox.error(e.toString());
				}
			}
		});
		btnExportarExcel.setBounds(132, 184, 112, 23);
		frame.getContentPane().add(btnExportarExcel);
	}
}
