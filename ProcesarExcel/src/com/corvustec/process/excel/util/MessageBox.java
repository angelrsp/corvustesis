package com.corvustec.process.excel.util;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MessageBox {

	
	public static void error(String string){
		
		JTextArea textarea= new JTextArea(string);
		textarea.setEditable(true);
		JOptionPane.showMessageDialog(null, textarea, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void info(String string){
		
		JTextArea textarea= new JTextArea(string);
		textarea.setEditable(true);
		
		JOptionPane.showMessageDialog(null, textarea, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	
}
