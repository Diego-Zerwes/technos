package projeto.mensal.Telas;

import dao.RelatoriosDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Relatorio extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    Connection conexao = null;
    ResultSet rs = null;
    public RelatoriosDAO relatoriosDAO;
    
    public Relatorio() {
       initComponents();
       relatoriosDAO = new RelatoriosDAO();
    }

    private void buscarRelatorios() { 
    try {
        String dataInicio = jDataInicial.getText(); // Pega a data inicial como String
        String dataFim = jDataFinal.getText(); // Pega a data final como String

        if (jRadioCompras.isSelected()) { 
            DefaultTableModel modeloCompras = relatoriosDAO.buscarCompras(dataInicio, dataFim); 
            tblRelatorios.setModel(modeloCompras); 
        } else if (jRadioVendas.isSelected()) { 
            DefaultTableModel modeloVendas = relatoriosDAO.buscarVendas(dataInicio, dataFim); 
            tblRelatorios.setModel(modeloVendas); 
        } else if (jRadioFornecedor.isSelected()) { 
            DefaultTableModel modeloFornecedores = relatoriosDAO.buscarFornecedores(dataInicio, dataFim); 
            tblRelatorios.setModel(modeloFornecedores); 
        } else if (jRadioEstoque.isSelected()) { 
            DefaultTableModel modeloEstoque = relatoriosDAO.buscarEstoque(dataInicio, dataFim); 
            tblRelatorios.setModel(modeloEstoque); 
        } else { 
            JOptionPane.showMessageDialog(null, "Por favor, selecione um tipo de relatório.");
        } 
    } catch (IllegalArgumentException e) { 
        JOptionPane.showMessageDialog(null, "Formato de data inválido."); 
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDataInicial = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDataFinal = new javax.swing.JFormattedTextField();
        jRadioCompras = new javax.swing.JRadioButton();
        jRadioVendas = new javax.swing.JRadioButton();
        jRadioEstoque = new javax.swing.JRadioButton();
        jRadioFornecedor = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorios = new javax.swing.JTable();

        try {
            jDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

        try {
            jDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jRadioCompras.setText("Compras");

        jRadioVendas.setText("Vendas");

        jRadioEstoque.setText("Estoque");

        jRadioFornecedor.setText("Fornecedor");

        jLabel3.setText("Produto");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        tblRelatorios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRelatorios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioCompras)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioVendas)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioEstoque)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioFornecedor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))))))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCompras)
                    .addComponent(jRadioVendas)
                    .addComponent(jRadioEstoque)
                    .addComponent(jRadioFornecedor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        buscarRelatorios();
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JFormattedTextField jDataFinal;
    private javax.swing.JFormattedTextField jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioCompras;
    private javax.swing.JRadioButton jRadioEstoque;
    private javax.swing.JRadioButton jRadioFornecedor;
    private javax.swing.JRadioButton jRadioVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRelatorios;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
