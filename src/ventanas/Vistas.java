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
import javax.swing.ImageIcon;
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
    String titulo;
    public Vistas() throws IOException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        setLocationRelativeTo(null);
        crearTablaVistas();
    }
    
    private String nombreUsuario() throws IOException {
        String usuario;
        FileReader f = new FileReader("usuario.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            usuario = b.readLine();
            return usuario;
        }
    }
    
    private void crearTablaVistas() throws FileNotFoundException, IOException {
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
    private void crearTabla() {
        modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        for (int i = 0; i < peli.consultar().size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peli.consultar().get(i).getTitulo();
            fila[1] = peli.consultar().get(i).getDirector();
            fila[2] = peli.consultar().get(i).getGenero();
            fila[3] = peli.consultar().get(i).getAnnoEstreno();
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

        annadirPVista = new javax.swing.JFrame();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mensaje = new javax.swing.JDialog();
        si = new javax.swing.JButton();
        no = new javax.swing.JButton();
        jLInformacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTFbusqueda = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        jButton3.setText("Buscar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout annadirPVistaLayout = new javax.swing.GroupLayout(annadirPVista.getContentPane());
        annadirPVista.getContentPane().setLayout(annadirPVistaLayout);
        annadirPVistaLayout.setHorizontalGroup(
            annadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, annadirPVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(annadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(annadirPVistaLayout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        annadirPVistaLayout.setVerticalGroup(
            annadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annadirPVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(annadirPVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        si.setText("Sí");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        no.setText("No");

        jLInformacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInformacion.setText("jLabel2");

        javax.swing.GroupLayout mensajeLayout = new javax.swing.GroupLayout(mensaje.getContentPane());
        mensaje.getContentPane().setLayout(mensajeLayout);
        mensajeLayout.setHorizontalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mensajeLayout.createSequentialGroup()
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addComponent(si, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mensajeLayout.setVerticalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLInformacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(si, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tus Peliculas Vistas");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_peque.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFbusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscar)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jTFbusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String usuario = null;
        try {
            usuario = nombreUsuario();
        } catch (IOException ex) {
            Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        if (!jTFbusqueda.getText().equals(null)) {
            for (int i = 0; i < peli.buscarVista(usuario, jTFbusqueda.getText()).size(); i++) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = peli.buscarVista(usuario, jTFbusqueda.getText()).get(i).getTitulo();
                fila[1] = peli.buscarVista(usuario, jTFbusqueda.getText()).get(i).getDirector();
                fila[2] = peli.buscarVista(usuario, jTFbusqueda.getText()).get(i).getGenero();
                fila[3] = peli.buscarVista(usuario, jTFbusqueda.getText()).get(i).getAnnoEstreno();
                modelo.addRow(fila);
            }
        } else {
            for (int i = 0; i < peli.peliculaVista(usuario).size(); i++) {
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = peli.peliculaVista(usuario).get(i).getTitulo();
                fila[1] = peli.peliculaVista(usuario).get(i).getDirector();
                fila[2] = peli.peliculaVista(usuario).get(i).getGenero();
                fila[3] = peli.peliculaVista(usuario).get(i).getAnnoEstreno();
                modelo.addRow(fila);
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.rowAtPoint(evt.getPoint());
        int columna = jTable1.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna == 0)) {
            titulo = (String) modelo.getValueAt(fila, columna);
            mensaje.setSize(325, 150);
            mensaje.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
            mensaje.setLocationRelativeTo(null);
            mensaje.setVisible(true);
            jLInformacion.setText("¿Quieres añadir "+titulo+" como pelicula vista?");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        annadirPVista.setSize(520, 375);
        annadirPVista.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        annadirPVista.setLocationRelativeTo(null);
        crearTabla();
        annadirPVista.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        peli.marcarComoVista(titulo);
        mensaje.dispose();
        try {
            crearTablaVistas();
        } catch (IOException ex) {
            Logger.getLogger(Vistas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_siActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EliminarVista ev;
        try {
            ev = new EliminarVista();
            ev.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Vistas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JFrame annadirPVista;
    private javax.swing.JButton buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLInformacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFbusqueda;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog mensaje;
    private javax.swing.JButton no;
    private javax.swing.JButton si;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
