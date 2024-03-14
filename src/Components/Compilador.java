/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Components;

public class  Compilador extends javax.swing.JFrame {

    public Compilador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnGuardarArchivo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnNuevoArchivo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dataforge");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 255));

        Consola.setEditable(false);
        Consola.setBackground(new java.awt.Color(255, 204, 255));
        Components.Consola.setConsola(Consola);
        Consola.setColumns(20);
        Consola.setRows(5);
        jScrollPane1.setViewportView(Consola);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("CONSOLA");

        btnAbrirArchivo.setBackground(new java.awt.Color(255, 204, 255));
        btnAbrirArchivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAbrirArchivo.setText("ABRIR ARCHIVO");
        btnAbrirArchivo.setActionCommand("Abrir archivo");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        btnAnalizar.setBackground(new java.awt.Color(255, 204, 255));
        btnAnalizar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAnalizar.setText("ANALIZAR");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnGuardarArchivo.setBackground(new java.awt.Color(255, 204, 255));
        btnGuardarArchivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardarArchivo.setText("GUARDAR ARCHIVO");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 102, 255));

        btnNuevoArchivo.setBackground(new java.awt.Color(255, 204, 255));
        btnNuevoArchivo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNuevoArchivo.setText("NUEVO ARCHIVO");
        btnNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArchivoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel2.setText("DATAFORGE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoArchivo)
                    .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrirArchivo)
                        .addGap(25, 25, 25)
                        .addComponent(btnNuevoArchivo))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizar)
                        .addGap(24, 24, 24)
                        .addComponent(btnGuardarArchivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed

        TabManager.agregarPestanaDinamica(jTabbedPane1);
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed

        Util.Reports.listaTokens.clear();
        Consola.setText("");
        Analisis.analizarContenido(jTabbedPane1, Consola);
        

        Util.HTMLGenerator.generateHTML(Util.Reports.listaTokens, "Lista de Tokens", "TokensCorrectos");
        Util.Reports.listaTokens.clear();
        

        Util.HTMLGenerator.generateHTMLErr(Util.Reports.listaErroresTok, "Lista de Errores", "ReporteErrores");
        Util.Reports.listaErroresTok.clear();
        
        
        Util.HTMLGenerator.generateHTMLTabSimb(Util.Instruction.tablaVariables, "Tabla de Simbolos", "TablaSimbolos");
        Util.Instruction.tablaVariables.clear();
        
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed

        TabManager.guardarArchivo(jTabbedPane1);
        
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArchivoActionPerformed

        TabManager.agregarNuevaPestana(jTabbedPane1);
    }//GEN-LAST:event_btnNuevoArchivoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea Consola;
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnNuevoArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}


