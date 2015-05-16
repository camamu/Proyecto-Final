package ventanas;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import peliculas.Pelicula;
import peliculas.PeliculasOpImp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    PeliculasOpImp peli = new PeliculasOpImp();
    DefaultTableModel modelo;
    String caratulaDefecto = "/imagenes/no_disponible.jpg";
    public Principal(){
        initComponents();
        setLocationRelativeTo(null);
        PeliculasOpImp peliculas = new PeliculasOpImp();
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        for (int i = 0; i < peliculas.consultar().size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peliculas.consultar().get(i).getTitulo();
            fila[1] = peliculas.consultar().get(i).getDirector();
            fila[2] = peliculas.consultar().get(i).getGenero();
            fila[3] = peliculas.consultar().get(i).getAnnoEstreno();
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

        InformacionPelicula = new javax.swing.JFrame();
        infPeliculaTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        infPeliculaDirector = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        infPeliculaGenero = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        infPeliculaAnno = new javax.swing.JLabel();
        jPanel1 = new Panel(caratulaDefecto);
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jTextBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        categoria = new javax.swing.JComboBox();
        filtrarPor = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        pelis = new javax.swing.JMenu();
        editar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        nueva = new javax.swing.JMenuItem();
        tusPeliculas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        prestamos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        opciones = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        infPeliculaTitulo.setText("contenido del titulo");

        jLabel1.setText("Titulo:");

        jLabel2.setText("Director:");

        infPeliculaDirector.setText("nombre del director");

        jLabel4.setText("Género:");

        infPeliculaGenero.setText("genero de la pelicula");

        jLabel6.setText("Año de estreno:");

        infPeliculaAnno.setText("año de estreno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InformacionPeliculaLayout = new javax.swing.GroupLayout(InformacionPelicula.getContentPane());
        InformacionPelicula.getContentPane().setLayout(InformacionPeliculaLayout);
        InformacionPeliculaLayout.setHorizontalGroup(
            InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformacionPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(infPeliculaTitulo))
                    .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infPeliculaDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(infPeliculaGenero))
                    .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infPeliculaAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        InformacionPeliculaLayout.setVerticalGroup(
            InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infPeliculaTitulo)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infPeliculaDirector))
                .addGap(18, 18, 18)
                .addGroup(InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(infPeliculaGenero))
                .addGap(18, 18, 18)
                .addGroup(InformacionPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(infPeliculaAnno))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(InformacionPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\iconoLupa.png")); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguna", "Comedia", "Terror/Suspense", "Románticas", "Acción", "Musicales", "Animación", "Ciencia Ficción" }));
        categoria.setToolTipText("Selecciona una categoria para filtrar por ella ");
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });

        filtrarPor.setText("Filtrar por:");

        titulo.setText("Titulo:");

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pelis.setText("Peliculas");

        editar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\stock-tool-pencil-22.png")); // NOI18N
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        pelis.add(editar);

        eliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\eliminar_peque.png")); // NOI18N
        eliminar.setText("Eliminar");
        pelis.add(eliminar);

        nueva.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\agregar.png")); // NOI18N
        nueva.setText("Nueva");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });
        pelis.add(nueva);

        tusPeliculas.setText("Tus peliculas...");

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\star.png")); // NOI18N
        jMenuItem4.setText("Favoritas");
        tusPeliculas.add(jMenuItem4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\ojo22.png")); // NOI18N
        jMenuItem3.setText("Vistas");
        tusPeliculas.add(jMenuItem3);

        pelis.add(tusPeliculas);

        jMenuBar1.add(pelis);

        prestamos.setText("Prestamos");

        jMenuItem1.setText("Nuevo");
        prestamos.add(jMenuItem1);

        jMenuItem2.setText("Ver");
        prestamos.add(jMenuItem2);

        jMenuBar1.add(prestamos);

        opciones.setText("Opciones");

        jMenuItem5.setText("Cerrar Sesión");
        opciones.add(jMenuItem5);

        jMenuItem6.setText("Salir");
        opciones.add(jMenuItem6);

        jMenuBar1.add(opciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtrarPor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextBusqueda)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(titulo))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrarPor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PeliculasOpImp peliculas = new PeliculasOpImp();
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        for (int i = 0; i < peliculas.buscarPelicula(jTextBusqueda.getText()).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peliculas.buscarPelicula(jTextBusqueda.getText()).get(i).getTitulo();
            fila[1] = peliculas.buscarPelicula(jTextBusqueda.getText()).get(i).getDirector();
            fila[2] = peliculas.buscarPelicula(jTextBusqueda.getText()).get(i).getGenero();
            fila[3] = peliculas.buscarPelicula(jTextBusqueda.getText()).get(i).getAnnoEstreno();
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed
        // TODO add your handling code here:
        PeliculasOpImp peliculas = new PeliculasOpImp();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Género");
        modelo.addColumn("Año");
        System.out.println((String)categoria.getSelectedItem());
        for (int i = 0; i < peliculas.filtrarCategoria((String)categoria.getSelectedItem()).size(); i++) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = peliculas.filtrarCategoria(jTextBusqueda.getText()).get(i).getTitulo();
            fila[1] = peliculas.filtrarCategoria(jTextBusqueda.getText()).get(i).getDirector();
            fila[2] = peliculas.filtrarCategoria(jTextBusqueda.getText()).get(i).getGenero();
            fila[3] = peliculas.filtrarCategoria(jTextBusqueda.getText()).get(i).getAnnoEstreno();
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_categoriaActionPerformed

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        // TODO add your handling code here:
        InsertarPelicula insertarPelicula = new InsertarPelicula();
        insertarPelicula.setVisible(true);
    }//GEN-LAST:event_nuevaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna == 0)){
           InformacionPelicula.setSize(472, 359);
           InformacionPelicula.setVisible(true);
            for (Pelicula p : peli.buscarPelicula((String)modelo.getValueAt(fila, columna))) {
                infPeliculaTitulo.setText(p.getTitulo());
                infPeliculaDirector.setText(p.getDirector());
                infPeliculaGenero.setText(p.getGenero());
                infPeliculaAnno.setText(String.valueOf(p.getAnnoEstreno()));
               try {
                   if (p.getCaratula() == null){
                        System.out.println("no hay foto");
                   }else {
                        peli.RecuperarBLOB((String)modelo.getValueAt(fila, columna));
                        caratulaDefecto = "/imagenes/caratula.jpg";
                        jPanel1 = new Panel(caratulaDefecto);
                        jPanel1.updateUI();
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame InformacionPelicula;
    private javax.swing.JComboBox categoria;
    private javax.swing.JMenuItem editar;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel filtrarPor;
    private javax.swing.JLabel infPeliculaAnno;
    private javax.swing.JLabel infPeliculaDirector;
    private javax.swing.JLabel infPeliculaGenero;
    private javax.swing.JLabel infPeliculaTitulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBusqueda;
    private javax.swing.JMenuItem nueva;
    private javax.swing.JMenu opciones;
    private javax.swing.JMenu pelis;
    private javax.swing.JMenu prestamos;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    private javax.swing.JMenu tusPeliculas;
    // End of variables declaration//GEN-END:variables
}
