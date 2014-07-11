package com.corvustec.rtoqab.process.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuItem menuItemConfiguracion;
    private javax.swing.JMenuItem menuItemFactorAjuste;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        menuItemConfiguracion = new javax.swing.JMenuItem();
        menuItemFactorAjuste=new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuOpciones.setText("Opciones");

        menuItemConfiguracion.setText("Configuración");
        menuItemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	configurationActionPerformed(evt);
            }
        });
        
        menuItemFactorAjuste.setText("Factor de Ajuste");
        menuItemFactorAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	factorAjusteActionPerformed(evt);
            }
        });
        
        
        menuOpciones.add(menuItemConfiguracion);
        menuOpciones.add(menuItemFactorAjuste);

        menuBar.add(menuOpciones);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
	}
	
	
    private void configurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Se crea el objeto        
        Configuracion h1 = new Configuracion();
        // se añade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void factorAjusteActionPerformed(java.awt.event.ActionEvent evt)
    {
        FactorAjuste h1 = new FactorAjuste();
        // se añade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();    	
    }

}
