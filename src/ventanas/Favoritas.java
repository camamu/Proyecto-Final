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
public class Favoritas extends javax.swing.JFrame {

    /**
     * Creates new form Vistas
     */
    private final PeliculasOpImp peli = new PeliculasOpImp();
    private DefaultTableModel modelo;

    public Favoritas() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        crearTablaFavoritas();
    }

    private void crearTabla() {
        modelo = new DefaultTableModel();
        tabla2.setModel(modelo);
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

    private void crearTablaFavoritas() throws FileNotFoundException, IOException {
        String cadena;
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        FileReader f = new FileReader("usuario.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            cadena = b.readLine();
            System.out.println(cadena);
        }
        for (int i = 0; i < peli.peliculaFavorita(cadena).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peli.peliculaFavorita(cadena).get(i).getTitulo();
            fila[1] = peli.peliculaFavorita(cadena).get(i).getDirector();
            fila[2] = peli.peliculaFavorita(cadena).get(i).getGenero();
            fila[3] = peli.peliculaFavorita(cadena).get(i).getAnnoEstreno();
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

        annadirPFavorita = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextBusqueda = new javax.swing.JTextField();
        buscarAnnadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volver = new javax.swing.JButton();
        jTFbusqueda = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        annadirPFavorita.setTitle("Añadir Pelicula Favorita");
        annadirPFavorita.setResizable(false);

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabla2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecciona una pelicula de la tabla para marcarla como Favorita");

        buscarAnnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        buscarAnnadir.setText("Buscar");
        buscarAnnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAnnadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout annadirPFavoritaLayout = new javax.swing.GroupLayout(annadirPFavorita.getContentPane());
        annadirPFavorita.getContentPane().setLayout(annadirPFavoritaLayout);
        annadirPFavoritaLayout.setHorizontalGroup(
            annadirPFavoritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annadirPFavoritaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(annadirPFavoritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(annadirPFavoritaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(annadirPFavoritaLayout.createSequentialGroup()
                        .addComponent(jTextBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarAnnadir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        annadirPFavoritaLayout.setVerticalGroup(
            annadirPFavoritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, annadirPFavoritaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(annadirPFavoritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarAnnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Peliculas Favoritas");

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

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoLupa.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tus Peliculas Favoritas");

        jMenu1.setText("Opciones");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        jMenuItem1.setText("Añadir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_peque.png"))); // NOI18N
        jMenuItem2.setText("Eliminar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTFbusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(buscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void buscarAnnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAnnadirActionPerformed
        modelo = new DefaultTableModel();
        tabla2.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        for (int i = 0; i < peli.buscarPelicula(jTextBusqueda.getText()).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peli.buscarPelicula(jTextBusqueda.getText()).get(i).getTitulo();
            fila[1] = peli.buscarPelicula(jTextBusqueda.getText()).get(i).getDirector();
            fila[2] = peli.buscarPelicula(jTextBusqueda.getText()).get(i).getGenero();
            fila[3] = peli.buscarPelicula(jTextBusqueda.getText()).get(i).getAnnoEstreno();
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_buscarAnnadirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        annadirPFavorita.setVisible(true);
        annadirPFavorita.setSize(460, 395);
        annadirPFavorita.setLocationRelativeTo(null);
        crearTabla();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Favoritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Favoritas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame annadirPFavorita;
    private javax.swing.JButton buscar;
    private javax.swing.JButton buscarAnnadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFbusqueda;
    private javax.swing.JTextField jTextBusqueda;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
