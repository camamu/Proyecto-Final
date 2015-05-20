/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import peliculas.PeliculasOpImp;

/**
 *
 * @author Carlos
 */
public class Vistas extends javax.swing.JFrame {

    /**
     * Creates new form Vistas
     */
    private PeliculasOpImp peli = new PeliculasOpImp();
    private DefaultTableModel modelo;

    public Vistas() throws IOException {
        initComponents();
        crearTabla();
    }

    private void crearTabla() throws FileNotFoundException, IOException {
        String cadena;
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        FileReader f = new FileReader("usuario.txt");
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        System.out.println(cadena);
        b.close();
        for (int i = 0; i < peli.peliculaVista(cadena).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peli.peliculaVista(cadena).get(i).getTitulo();
            fila[1] = peli.peliculaVista(cadena).get(i).getDirector();
            fila[2] = peli.peliculaVista(cadena).get(i).getGenero();
            fila[3] = peli.peliculaVista(cadena).get(i).getAnnoEstreno();
            modelo.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        añadirPVista = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTFbusqueda = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        javax.swing.GroupLayout añadirPVistaLayout = new javax.swing.GroupLayout(añadirPVista.getContentPane());
        añadirPVista.getContentPane().setLayout(añadirPVistaLayout);
        añadirPVistaLayout.setHorizontalGroup(
            añadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        añadirPVistaLayout.setVerticalGroup(
            añadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Peliculas Vistas");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        jButton1.setText("Añadir");

        jButton2.setText("Volver");

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTFbusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(buscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        for (int i = 0; i < peli.buscarPelicula(jTFbusqueda.getText()).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peli.buscarPelicula(jTFbusqueda.getText()).get(i).getTitulo();
            fila[1] = peli.buscarPelicula(jTFbusqueda.getText()).get(i).getDirector();
            fila[2] = peli.buscarPelicula(jTFbusqueda.getText()).get(i).getGenero();
            fila[3] = peli.buscarPelicula(jTFbusqueda.getText()).get(i).getAnnoEstreno();
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Vistas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Vistas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame añadirPVista;
    private javax.swing.JButton buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFbusqueda;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
