package projeto.mensal.Telas;

import dao.RelatoriosDAO;
import dao.ConexaoBanco;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Relatorio extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    Connection conn = null;
   // PreparedStatement pstEnd = null;
    //PreparedStatement pstForn = null;
   // PreparedStatement pstCont = null;
   // ResultSet rs = null;
    
    //ConexaoBanco conexao = null;
    private Connection conexao;
    public RelatoriosDAO relatoriosDAO;
    
    
    
    public Relatorio() {
       initComponents();
       relatoriosDAO = new RelatoriosDAO();
       ConexaoBanco con = new ConexaoBanco();
        if(con.conectar()){
            conexao = con.getConnection();
        }else{
            JOptionPane.showMessageDialog(null, "Conexao com o Banco falhou");
        }
    }

    private void buscarRelatorios() { 
    try {
        String dataInicio = jDataInicial.getText(); 
        String dataFim = jDataFinal.getText(); 

        if (jRadioCompras.isSelected()) { 
            DefaultTableModel modeloCompras = relatoriosDAO.buscarCompras(dataInicio, dataFim); 
            tbCompras.setModel(modeloCompras); 
        } else if (jRadioVendas.isSelected()) { 
            DefaultTableModel modeloVendas = relatoriosDAO.buscarVendas(dataInicio, dataFim); 
            tbCompras.setModel(modeloVendas); 
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
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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
        jRadioCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioComprasActionPerformed(evt);
            }
        });

        jRadioVendas.setText("Vendas");
        jRadioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioVendasActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Compra", "Forma de Pagamento", "Data"
            }
        ));
        tbCompras.setEnabled(false);
        jScrollPane1.setViewportView(tbCompras);

        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdVenda", "formaPagamento", "tipoVenda", "clientes", "dataVenda"
            }
        ));
        jScrollPane2.setViewportView(tbVendas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioCompras)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioVendas))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jDataInicial)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(btnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCompras)
                    .addComponent(jRadioVendas))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        buscarRelatorios();
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void jRadioComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioComprasActionPerformed
 
    }//GEN-LAST:event_jRadioComprasActionPerformed

    private void jRadioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioVendasActionPerformed
   
    }//GEN-LAST:event_jRadioVendasActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    jScrollPane1.setVisible(false);
    jScrollPane2.setVisible(false);
        
        
    }//GEN-LAST:event_formComponentShown

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
    jScrollPane1.setVisible(false);
    jScrollPane2.setVisible(false);
   

    if (jRadioCompras.isSelected()) {
        System.out.println("Exibindo Tabela de Compras");
        try {
            carregarCompras(); 
        } catch (ParseException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        jScrollPane1.setVisible(true);  
    } else if (jRadioVendas.isSelected()) {
        System.out.println("Exibindo Tabela de Vendas");
        carregarVendas();
        jScrollPane2.setVisible(true);  
    } 

    Container parent = this.getRootPane();  

    if (parent != null) {
        parent.repaint();  
        parent.revalidate();  
    } else {
        System.out.println("Erro: contêiner pai não encontrado.");
    }
    }//GEN-LAST:event_btnConfirmarActionPerformed
 
    private void carregarCompras() throws ParseException {
   DefaultTableModel modelo = (DefaultTableModel) tbCompras.getModel();
    modelo.setRowCount(0); 
    
    String dataInicio = jDataInicial.getText();  
    String dataFim = jDataFinal.getText();  

    SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

    try {
        java.util.Date dateInicio = formatoEntrada.parse(dataInicio);
        java.util.Date dateFim = formatoEntrada.parse(dataFim);

        java.sql.Date sqlDataInicio = new java.sql.Date(dateInicio.getTime());
        java.sql.Date sqlDataFim = new java.sql.Date(dateFim.getTime());

        String sql = "SELECT c.idCompra," + 
                   "CASE f.idFormaPagamento " +
                       " WHEN 1 THEN 'Dinheiro' " +
                       " WHEN 2 THEN 'Crédito' " +
                       "WHEN 3 THEN 'Débito' " +
                   "END AS formaPagamento, " +
                   "c.dataCompra " +
            "FROM compra c " +
            "JOIN formapagamento f ON c.idFormaPagamento = f.idFormaPagamento " +
            "WHERE c.dataCompra BETWEEN ? AND ?";

        if (conexao == null) {
            JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não foi inicializada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setDate(1, sqlDataInicio);
        ps.setDate(2, sqlDataFim);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCompra = rs.getInt("idCompra");
            String formaPagamento = rs.getString("formaPagamento");
            java.sql.Date dataCompraSql = rs.getDate("dataCompra");

            String dataCompra = formatoEntrada.format(dataCompraSql);

            modelo.addRow(new Object[]{idCompra, formaPagamento, dataCompra});
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar compras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void carregarVendas() {
    DefaultTableModel modelo = (DefaultTableModel) tbVendas.getModel();
    modelo.setRowCount(0); 

    String sql = "SELECT v.idVenda, " +
                 "CASE f.idFormaPagamento " +
                 " WHEN 1 THEN 'Dinheiro' " +
                 " WHEN 2 THEN 'Crédito' " +
                 " WHEN 3 THEN 'Débito' " +
                 "END AS formaPagamento, " +
                 "CASE tv.idTipoVenda " +
                 " WHEN 1 THEN 'Atacado' " +
                 " WHEN 2 THEN 'A Prazo' " +
                 "END AS tipoVenda, " +
                 "c.nomeRazaoSocial AS clientes, " +
                 "v.dataVenda " +
                 "FROM venda v " +
                 "JOIN formapagamento f ON v.idFormaPagamento = f.idFormaPagamento " +
                 "JOIN tipovenda tv ON v.idTipoVenda = tv.idTipoVenda " +
                 "JOIN clientes c ON v.idCliente = c.idCliente";

    try (PreparedStatement ps = conexao.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int idVenda = rs.getInt("idVenda");
            String formaPagamento = rs.getString("formaPagamento");
            String tipoVenda = rs.getString("tipoVenda");
            String cliente = rs.getString("clientes");
            String dataVenda = rs.getString("dataVenda");

            modelo.addRow(new Object[]{idVenda, formaPagamento, tipoVenda, cliente, dataVenda});
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar vendas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JFormattedTextField jDataFinal;
    private javax.swing.JFormattedTextField jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioCompras;
    private javax.swing.JRadioButton jRadioVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTable tbVendas;
    // End of variables declaration//GEN-END:variables
}
