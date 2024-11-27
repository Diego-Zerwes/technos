/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto.mensal.Telas;

import dao.ConexaoBanco;
import dao.EstoqueDao;
import dao.ProdutoDao;
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
    
    
    // Método para abrir a conexão com o banco
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

    // Método para fechar a conexão com o banco
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

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "QUANTIDADE", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carrinho");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Valor Total");

        jValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$ #,##0.###"))));

        jTabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "QUANTIDADE", "VALOR"
            }
        ));
        jScrollPane2.setViewportView(jTabelaCarrinho);

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
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVendaMouseClicked
         if((jTabelaVenda.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)){
        String idProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 0).toString();
        String nomeProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 1).toString();
        String valorProduto = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 3).toString();
        String estoqueDisponivel = jTabelaVenda.getValueAt(jTabelaVenda.getSelectedRow(), 2).toString();
        
        // A quantidade solicitada (para a compra) é capturada via JOptionPane
        String quantidadeCompra = JOptionPane.showInputDialog(this, "Digite a quantidade desejada:", "Quantidade", JOptionPane.PLAIN_MESSAGE);

        if (quantidadeCompra != null && !quantidadeCompra.isEmpty()) {
            try {
                int quantidade = Integer.parseInt(quantidadeCompra);
                int estoque = Integer.parseInt(estoqueDisponivel);

                if (quantidade > 0 && quantidade <= estoque) {
                    double valorUnitario = Double.parseDouble(valorProduto.replace(",", "."));
                    double valorTotal = valorUnitario * quantidade;

                    // Adicionar a linha no carrinho de compras
                    DefaultTableModel modeloTabelaCompra = (DefaultTableModel) jTabelaCarrinho.getModel();
                    modeloTabelaCompra.addRow(new Object[]{
                        idProduto,
                        nomeProduto,
                        quantidade,
                        valorTotal
                    });

                    // Atualiza o valor total da compra
                    atualizaValorTotal();

                    // Agora, a manipulação do estoque
                    EstoqueDao estoqueDao = new EstoqueDao();  // Cria uma instância de EstoqueDao
                    estoqueDao.atualizarQuantidadeEstoque(Integer.parseInt(idProduto), estoque - quantidade); // Atualiza o estoque no banco de dados

                    // Exibe a quantidade de estoque após a compra
                    System.out.println("Estoque após compra: " + (estoque - quantidade));  // Exibe quantidade no estoque após a compra

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
        conectarEBuscarProdutos();
    }//GEN-LAST:event_formComponentShown

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // Chama a função que irá atualizar o estoque, passando os itens do carrinho
    finalizarCompra();

    // Após finalizar a compra, você pode limpar o carrinho
    limparCarrinho();

    // Exibe uma mensagem de confirmação
    JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpa o carrinho sem realizar nenhuma ação no estoque
    limparCarrinho();

    // Exibe uma mensagem de cancelamento
    JOptionPane.showMessageDialog(this, "Compra cancelada.");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private double  atualizaValorTotal() {
    double total = 0.0;
    DefaultTableModel modeloTabela2 = (DefaultTableModel) jTabelaCarrinho.getModel();

    for (int i = 0; i < modeloTabela2.getRowCount(); i++) {
        Object valorObj = modeloTabela2.getValueAt(i, 3);  

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

    jValorTotal.setText(valorFormatado);
    return total;
}
    public double calcularValorTotal() {
    double total = 0.0;

    // Itera sobre todos os itens no carrinho e soma o preço total
    for (ItemCarrinho item : itensCarrinho) {
        total += item.getQuantidade() * item.getPrecoUnitario();
    }

    return total;
}
    private boolean simularPagamento(double valorTotal) {
    // Simulando pagamento com 100% de aprovação (isso pode ser substituído por integração com sistema de pagamento)
    int resposta = JOptionPane.showConfirmDialog(null, "Total da compra: R$ " + valorTotal + ". Deseja confirmar o pagamento?", "Pagamento", JOptionPane.YES_NO_OPTION);
    return resposta == JOptionPane.YES_OPTION;
}
    public double obterPrecoProduto(int idProduto) {
    // Supondo que 'conn' seja a conexão com o banco de dados
    String sql = "SELECT precoVenda FROM produto WHERE idProduto = ?";
    double preco = 0.0;

    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, idProduto);  // Configura o ID do produto na consulta
        ResultSet rs = pst.executeQuery();

        // Verifica se o produto foi encontrado e obtém o preço
        if (rs.next()) {
            preco = rs.getDouble("precoVenda");  // Obtém o preço do produto
        } else {
            // Caso o produto não seja encontrado, pode-se lançar uma exceção ou retornar um valor padrão
            JOptionPane.showMessageDialog(null, "Produto não encontrado no banco de dados.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar preço do produto: " + e.getMessage());
    }

    return preco;  // Retorna o preço do produto
}
  
    public void atualizaTabela(ArrayList<Produto> listaProdutos) {
        // Usando a conexão global já aberta
    if (conn == null) {
        JOptionPane.showMessageDialog(this, "Conexão com o banco não estabelecida.");
        return;
    }

    try {
        // Limpa a tabela antes de adicionar as novas linhas
        limparTabela();

        DefaultTableModel modeloTabela = (DefaultTableModel) jTabelaVenda.getModel();

        // Criação de uma instância do ProdutoDao sem passar a conexão explicitamente
        ProdutoDao produtoDao = new ProdutoDao(); // Não passamos a conexão, pois já está sendo utilizada globalmente

        // Para cada produto na lista, consultar o estoque e adicionar à tabela
        for (Produto cadastroP : listaProdutos) {
            // Obtém o ID do produto
            int idProduto = cadastroP.getIdProduto();

            // Consulta a quantidade do estoque usando o DAO de Produto
            int quantidadeEstoque = produtoDao.consultarQuantidadePorId(idProduto);  // Método para consultar quantidade por ID

            // Verifique o valor retornado
            System.out.println("Quantidade de estoque para o produto " + idProduto + ": " + quantidadeEstoque);

            // Adiciona a linha na tabela com as informações do produto
            if (quantidadeEstoque >= 0) { // Se a quantidade é válida (pode ser alterado para outro critério)
                modeloTabela.addRow(new String[] {
                    Integer.toString(idProduto), // ID do produto
                    cadastroP.getDescricao(), // Descrição do produto
                    String.valueOf(quantidadeEstoque), // Quantidade de estoque
                    String.valueOf(cadastroP.getPrecoVenda()) // Preço de venda
                });
            } else {
                modeloTabela.addRow(new String[] {
                    Integer.toString(idProduto), // ID do produto
                    cadastroP.getDescricao(), // Descrição do produto
                    "Estoque não encontrado", // Mensagem de erro ou valor padrão
                    String.valueOf(cadastroP.getPrecoVenda()) // Preço de venda
                });
            }
        }

    } catch (Exception e) {
        // Exibe o erro completo no console
        e.printStackTrace(); // Isso irá exibir o erro completo no console
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar o estoque:\n" + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
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
    
    private void conectarEBuscarProdutos() {
         // Verifica se a conexão está aberta
    abrirConexao(); // Certifica-se de que a conexão foi aberta

    ProdutoDao cadastroPDao = new ProdutoDao();  // Não passamos a conexão explicitamente

    try {
        if (cadastroPDao.conectar()) {  // Conecta ao banco de dados
            ArrayList<Produto> listaProdutos = cadastroPDao.consultar();  // Consulta os produtos
            atualizaTabela(listaProdutos);  // Atualiza a tabela com os produtos
        } else {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        // Captura exceções relacionadas ao banco de dados
        JOptionPane.showMessageDialog(null, "Erro ao carregar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        try {
            // Fechar a conexão no final (não precisa ser aqui, pode ser feito quando for necessário)
            // cadastroPDao.fecharConexao(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    
    
    
    public void atualizarEstoque(ArrayList<ItemCarrinho> itensCarrinho) {
    // Verifica se o carrinho está vazio
    abrirConexao();
    if (itensCarrinho.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Carrinho vazio. Adicione produtos antes de finalizar a compra.");
        return;
    }

    // Cria uma instância de EstoqueDao (passando a conexão do banco)
    EstoqueDao estoqueDao = new EstoqueDao(); // Aqui você usa a conexão já existente

    // Itera sobre os itens do carrinho para atualizar o estoque
    for (ItemCarrinho item : itensCarrinho) {
        // Obtém o produto e a quantidade comprada
        int idProduto = item.getIdProduto();
        int quantidadeComprada = item.getQuantidade();

        // Verifica a quantidade em estoque do produto usando o EstoqueDao
        int quantidadeEmEstoque = estoqueDao.consultarQuantidadeEstoque(idProduto);

        if (quantidadeEmEstoque >= quantidadeComprada) {
            // Subtrai a quantidade comprada do estoque
            int novaQuantidade = quantidadeEmEstoque - quantidadeComprada;

            // Atualiza o estoque no banco de dados usando o EstoqueDao
            boolean sucesso = estoqueDao.atualizarQuantidadeEstoque(idProduto, novaQuantidade);

            // Notifica o usuário se a atualização foi bem-sucedida ou não
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque do produto: " + idProduto);
            }
        } else {
            // Exibe uma mensagem se a quantidade solicitada for maior que o estoque disponível
            JOptionPane.showMessageDialog(null, "Quantidade solicitada maior que o estoque disponível para o produto: " + idProduto);
        }
    }
}
    private ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<>();
    private void finalizarCompra() {
        abrirConexao();
    // Calcula o valor total da compra
    double totalCompra = calcularValorTotal();

    // Simula o pagamento
    boolean pagamentoConfirmado = simularPagamento(totalCompra);

    if (pagamentoConfirmado) {
        // Atualiza o estoque com base nos itens no carrinho
        atualizarEstoque(itensCarrinho);

        // Exemplo: Você pode registrar a venda no banco de dados, se necessário
        // Exemplo: salvarVenda(itensCarrinho);

        // Exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
        
        // Limpa o carrinho após a compra ser concluída
        limparCarrinho();
    } else {
        // Caso o pagamento não seja confirmado
        JOptionPane.showMessageDialog(this, "Pagamento cancelado. A compra não foi concluída.");
    }
}
    public void limparCarrinho() {
    // Limpa a lista de itens do carrinho (se for uma lista de objetos ItemCarrinho)
    itensCarrinho.clear();
    
    // Atualiza a tabela ou interface gráfica do carrinho, se necessário
    DefaultTableModel modeloTabelaCarrinho = (DefaultTableModel) jTabelaCarrinho.getModel();
    modeloTabelaCarrinho.setRowCount(0);  // Remove todas as linhas da tabela
    
    // Se quiser exibir uma mensagem informando que o carrinho foi limpo
    JOptionPane.showMessageDialog(null, "Carrinho limpo com sucesso.");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabelaCarrinho;
    private javax.swing.JTable jTabelaVenda;
    private javax.swing.JFormattedTextField jValorTotal;
    // End of variables declaration//GEN-END:variables
}
