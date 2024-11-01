/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto.mensal.Telas;

import dao.ComprasDao;
import dao.ConexaoBanco;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Produto;


public class Relatorio extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    

    public Relatorio() {
        initComponents();
       
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Compra", "Data", "Fornecedor", "Forma Pagamento", "Caixa"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        jLabel1.setText("Buscar");

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
         ComprasDao comp = new ComprasDao();
        buscarNome(comp);
    }//GEN-LAST:event_txtBuscaKeyPressed
    public void limparTabela()
    {
        while(tbl.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) tbl.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
    public void adicionarCompraNaTabela(Compra comps) {
    DefaultTableModel modeloTabela = (DefaultTableModel) tbl.getModel();
    modeloTabela.addRow(new String[]{
        Integer.toString(comps.getIdCompra()),
        comps.getDataCompra(),
        Integer.toString(comps.getIdFornecedor()),
        Integer.toString(comps.getIdFormaPagamento()),
        Integer.toString(comps.getIdCaixa())
    });
}

    public void atualizaTabela(ArrayList<Compra> listaCompras) {
    try {
        limparTabela();
        for (Compra comps : listaCompras) {
            if (Integer.toString(comps.getIdCompra()) != null) {
                adicionarCompraNaTabela(comps);
            }
        }
    } catch (Exception ex) {
        mostrarErro("Ocorreu um erro inesperado:\n" + ex.getMessage());
    }
}

private void buscarNome(ComprasDao comp) {
    try {
        limparTabela();
        ArrayList<Compra> listaCadastrosStr = comp.consultar(txtBusca.getText());
        for (Compra comps : listaCadastrosStr) {
            adicionarCompraNaTabela(comps);
        }
    } catch (Exception ex) {
        mostrarErro("Ocorreu um erro inesperado:\n" + ex.getMessage());
    }
}

private void mostrarErro(String mensagem) {
    JOptionPane.showMessageDialog(null, mensagem, "ERRO!", JOptionPane.ERROR_MESSAGE);
}








    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
