/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto.mensal.Telas;

import dao.ConexaoBanco;
import dao.FormaDePagamentoDao;
import dao.ItemVendaDao;
import dao.ProdutoDao;
import dao.VendasDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import modelo.Estoque;
import modelo.FormaDePagamento;
import modelo.ItemCarrinho;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author difoz
 */
public class Vendas extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    private Produto produtoAtual;
    private Estoque Estoque;
    
    Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;
   
    public Vendas() {
        initComponents();
     ConexaoBanco conexaoBanco = new ConexaoBanco();
    try {
        conn = conexaoBanco.getConnection();  // Tente obter a conexão diretamente aqui
        if (conn != null) {
            System.out.println("Conexão estabelecida com o banco!");
        } else {
            System.out.println("Falha na conexão com o banco.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Erro ao tentar estabelecer a conexão: " + e.getMessage());
    }
    }
    
    
    private void abrirConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = new ConexaoBanco().getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao estabelecer a conexão com o banco", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jValorTotal = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaCarrinho = new javax.swing.JTable();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPagamento = new javax.swing.JComboBox<>();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MARCA", "DESCRIÇÃO", "QUANTIDADE", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaVenda);
        if (jTabelaVenda.getColumnModel().getColumnCount() > 0) {
            jTabelaVenda.getColumnModel().getColumn(0).setResizable(false);
            jTabelaVenda.getColumnModel().getColumn(1).setResizable(false);
            jTabelaVenda.getColumnModel().getColumn(2).setResizable(false);
            jTabelaVenda.getColumnModel().getColumn(3).setResizable(false);
            jTabelaVenda.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carrinho");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Valor Total");

        jValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$ #,##0.###"))));

        jTabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "MARCA", "DESCRIÇÃO", "QUANTIDADE", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTabelaCarrinho);
        if (jTabelaCarrinho.getColumnModel().getColumnCount() > 0) {
            jTabelaCarrinho.getColumnModel().getColumn(0).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(1).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(2).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(3).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(4).setResizable(false);
        }

        btnComprar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(499, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(495, 495, 495))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVendaMouseClicked
       if ((jTabelaVenda.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)) {
        String idProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 0).toString();
        String nomeProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 1).toString();
        String valorProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 4).toString();
        String estoqueDisponivel = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 3).toString();

        String quantidadeCompra = JOptionPane.showInputDialog(this, "Digite a quantidade desejada:", "Quantidade", JOptionPane.PLAIN_MESSAGE);

        if (quantidadeCompra != null && !quantidadeCompra.isEmpty()) {
            try {
                int quantidade = Integer.parseInt(quantidadeCompra);
                int estoque = Integer.parseInt(estoqueDisponivel);

                if (quantidade > 0 && quantidade <= estoque) {
                    double valorUnitario = Double.parseDouble(valorProduto.replace(",", "."));
                    double valorTotal = valorUnitario * quantidade;

                    boolean itemExistente = false;
                    for (ItemCarrinho item : itensCarrinho) {
                        if (item.getIdProduto() == Integer.parseInt(idProduto)) {
                            itemExistente = true;
                            break;
                        }
                    }

                    if (!itemExistente) {
                        DefaultTableModel modeloTabelaCarrinho = (DefaultTableModel) jTabelaCarrinho.getModel();
                        modeloTabelaCarrinho.addRow(new Object[]{
                            idProduto,
                            nomeProduto,
                            quantidade,
                            valorTotal
                        });

                        itensCarrinho.add(new ItemCarrinho(Integer.parseInt(idProduto), nomeProduto, quantidade, valorUnitario));

                        atualizaValorTotal();
                        ItemVendaDao itemVendaDao = new ItemVendaDao();
                        itemVendaDao.conectar();

                        StringBuilder idsProduto = new StringBuilder();
                        int quantidadeTotalCarrinho = 0; 

                        for (ItemCarrinho item : itensCarrinho) {
                            if (idsProduto.length() > 0) {
                                idsProduto.append(",");  
                            }
                            idsProduto.append(item.getIdProduto());  
                            quantidadeTotalCarrinho += item.getQuantidade();  

                        }

                        itemVendaDao.adicionarItemVenda(idsProduto.toString(), quantidadeTotalCarrinho, atualizaValorTotal());

                        itemVendaDao.fecharConexao();
                        
                        

                    } else {
                        JOptionPane.showMessageDialog(this, "Este item já está no carrinho!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                    System.out.println("Estoque após compra: " + (estoque - quantidade));

                } else {
                    JOptionPane.showMessageDialog(this, "Quantidade solicitada inválida ou maior que o estoque disponível!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_jTabelaVendaMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ProdutoDao cadastroPessoaP = new ProdutoDao();
        atualizaTabela(cadastroPessoaP);
        FormaDePagamentoDao formadepagamentoDao = new FormaDePagamentoDao();
         atualizaForma(formadepagamentoDao);
    }//GEN-LAST:event_formComponentShown

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
    finalizarCompra();

   // limparCarrinho();

    JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    limparCarrinho();
    JOptionPane.showMessageDialog(this, "Compra cancelada.");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private double  atualizaValorTotal() {
    double total = 0.0;
    DefaultTableModel modeloTabelaCarrinho = (DefaultTableModel) jTabelaCarrinho.getModel();

    for (int i = 0; i < modeloTabelaCarrinho.getRowCount(); i++) {
        Object valorObj = modeloTabelaCarrinho.getValueAt(i, 3);  

        if (valorObj instanceof String) {
            try {
                String valorStr = ((String) valorObj).replace(",", ".");
                total += Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Erro ao calcular o valor total: formato inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (valorObj instanceof Number) {
            total += ((Number) valorObj).doubleValue();
        }
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");
    String valorFormatado = df.format(total);

    jValorTotal.setText("R$ " + valorFormatado);
    return total;
}
    public double calcularValorTotal() {
    double total = 0.0;

    for (ItemCarrinho item : itensCarrinho) {
        total += item.getQuantidade() * item.getPrecoUnitario();
    }

    return total;
}
    private boolean simularPagamento(double valorTotal) {
    System.out.println("Valor total da compra: R$ " + jValorTotal);  
    
    int resposta = JOptionPane.showConfirmDialog(
        null, 
        "Total da compra: R$ " +  jValorTotal.getText() + ". Deseja confirmar o pagamento?", 
        "Pagamento", 
        JOptionPane.YES_NO_OPTION
    );
    
    return resposta == JOptionPane.YES_OPTION;
}
    
    
    public double obterPrecoProduto(int idProduto) {
    String sql = "SELECT precoVenda FROM produto WHERE idProduto = ?";
    double preco = 0.0;

    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, idProduto);  
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            preco = rs.getDouble("precoVenda");  
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado no banco de dados.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar preço do produto: " + e.getMessage());
    }

    return preco;  
}
  
    
    private void atualizaTabela(ProdutoDao cadastroPDao)
    {
                try
                {

                    limparTabela();

                    ArrayList<Produto> listaCadastros;
                    listaCadastros = cadastroPDao.consultar(); 

                    DefaultTableModel modeloTabela = (DefaultTableModel) jTabelaVenda.getModel();

                    for(Produto cadastroP : listaCadastros)
                    {
                        modeloTabela.addRow(new String[]{Integer.toString(cadastroP.getIdProduto()),
                                                                          cadastroP.getMarca(),
                                                                          cadastroP.getDescricao(),
                                                                          String.valueOf(cadastroP.getEstoque()),
                                                                          String.valueOf(cadastroP.getPrecoVenda())});
                    }

                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
                }
     
    }
    
    
    private void limparTabela()
    {
        while(jTabelaCarrinho.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) jTabelaCarrinho.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
    
    
    public void atualizarEstoque(ArrayList<ItemCarrinho> itensCarrinho) {
    abrirConexao();

    if (itensCarrinho.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Carrinho vazio. Adicione produtos antes de finalizar a compra.");
        return;
    }

    ProdutoDao produtoDao = new ProdutoDao(); 

    for (ItemCarrinho item : itensCarrinho) {
        int idProduto = item.getIdProduto();
        int quantidadeComprada = item.getQuantidade();

        // Consultar a quantidade de estoque diretamente na tabela produto
        //JOptionPane.showMessageDialog(null, idProduto);

        int quantidadeEmEstoque = produtoDao.consultarQuantidadeEstoque(idProduto);

        if (quantidadeEmEstoque >= quantidadeComprada) {
            int novaQuantidade = quantidadeEmEstoque - quantidadeComprada;

            boolean sucesso = produtoDao.atualizarQuantidadeEstoque(idProduto, novaQuantidade);

            if (sucesso) {
               // JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque do produto: " + idProduto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade solicitada maior que o estoque disponível para o produto: " + idProduto);
        }
    }
}
    
    private ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<>();
    private void finalizarCompra() {
        try {
        abrirConexao(); 

        double totalCompra = calcularValorTotal();  

        boolean pagamentoConfirmado = simularPagamento(totalCompra);

        if (pagamentoConfirmado) {
            atualizarEstoque(itensCarrinho);
            
            FormaDePagamento forma = new FormaDePagamento();
            VendasDao produtoDao = new VendasDao();

            Venda venda = new Venda();
            venda.setIdCliente(1);  
            venda.setIdFormaPagamento(jPagamento.getSelectedIndex() + 1);
            venda.setIdUsuario(1);
            venda.setIdTipoVenda(1);  
            venda.setIdRelatorio(1);  

            boolean vendaInserida = produtoDao.inserirVenda(venda);  

            if (vendaInserida) {
                JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
                limparCarrinho();  
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao registrar a venda.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pagamento cancelado. A compra não foi concluída.");
        }
    } catch (Exception e) {
        System.out.println("Erro ao finalizar a compra: " + e.getMessage());
        e.printStackTrace();
    }
}
    public void limparCarrinho() {
    itensCarrinho.clear();
    
    DefaultTableModel modeloTabelaCarrinho = (DefaultTableModel)  jTabelaCarrinho.getModel();
    modeloTabelaCarrinho.setRowCount(0);  // Remove todas as linhas da tabela
    
    JOptionPane.showMessageDialog(null, "Carrinho limpo com sucesso.");
}
    
    private void atualizaForma(FormaDePagamentoDao formaDao)
    {
        

                try
                {
                    limparCbxSexo();
                    ArrayList<FormaDePagamento> listarForma;
                    listarForma = formaDao.consultar(); 

                    for(FormaDePagamento forma : listarForma)
                    {
                        jPagamento.addItem(forma.getDescricao());
                    }
                    jPagamento.setSelectedIndex(-1);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
                }
           
        
    }

private void limparCbxSexo()
    {
     //  if(!(jcSexo.get().trim().isEmpty())){ 
         // jFornecedor.removeAllItems();
          //jFormaDePagamento.removeAllItems();
      // }
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jPagamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabelaCarrinho;
    private javax.swing.JTable jTabelaVenda;
    private javax.swing.JFormattedTextField jValorTotal;
    // End of variables declaration//GEN-END:variables
}
