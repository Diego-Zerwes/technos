/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package projeto.mensal.Telas;

import dao.ProdutoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;
import modelo.Estoque;
import dao.ConexaoBanco;
import dao.FornecedorDao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.Fornecedor;

/**
 *
 * @author diegozerwesfeitosa
 */
public class Compras extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    

    public Compras() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jMarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCompras = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jFornecedor = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("ID");

        txtId.setEditable(false);

        jLabel2.setText("Descrição");

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyPressed(evt);
            }
        });

        jLabel3.setText("Modelo");

        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModeloKeyPressed(evt);
            }
        });

        jMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iphone", "Xiaomi", "Samsung" }));
        jMarca.setSelectedIndex(-1);
        jMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMarcaKeyPressed(evt);
            }
        });

        jLabel4.setText("Marca");

        jLabel5.setText("Quantidade");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
        });

        jLabel6.setText("Cor");

        jCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branco", "Preto", "Rosa", "Roxo" }));
        jCor.setSelectedIndex(-1);
        jCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCorKeyPressed(evt);
            }
        });

        jLabel8.setText("Preço de Compra");

        txtPrecoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecoCompraKeyPressed(evt);
            }
        });

        jLabel9.setText("Preço de Venda");

        btnCancelar.setText("Cancelar");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        TabelaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Modelo", "Fornecedor", "Cor", "Marca", "Quantidade", "Preço de Compra", "Preço de venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCompras);
        if (TabelaCompras.getColumnModel().getColumnCount() > 0) {
            TabelaCompras.getColumnModel().getColumn(0).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(1).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(2).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(3).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(4).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(5).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(6).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(7).setResizable(false);
            TabelaCompras.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel10.setText("Fornecedor");

        jLabel7.setText("jLabel7");

        jLabel11.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(483, 483, 483))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBuscar)
                                                .addGap(229, 229, 229)))
                                        .addComponent(btnCadastrar)
                                        .addGap(29, 29, 29))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(173, Short.MAX_VALUE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jCor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)))
                .addComponent(btnCancelar)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnCadastrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtModelo.requestFocus();
        }
    }//GEN-LAST:event_txtDescricaoKeyPressed

    private void txtModeloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtQuantidade.requestFocus();
        }
    }//GEN-LAST:event_txtModeloKeyPressed

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            jCor.requestFocus();
        }
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void jCorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCorKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            jMarca.requestFocus();
        }
    }//GEN-LAST:event_jCorKeyPressed

    private void jMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMarcaKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            jFornecedor.requestFocus();
        }
    }//GEN-LAST:event_jMarcaKeyPressed

    private void txtPrecoCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoCompraKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtPrecoVenda.requestFocus();
        }
    }//GEN-LAST:event_txtPrecoCompraKeyPressed

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        if ((txtDescricao.getText().trim().isEmpty()) 
    || (txtModelo.getText().trim().isEmpty()) 
    || (txtQuantidade.getText().trim().isEmpty())
    || (jCor.getSelectedIndex() < 0)
    || (jMarca.getSelectedIndex() < 0)
    || (jFornecedor.getSelectedIndex() < 0)
    || (txtPrecoCompra.getText().trim().isEmpty())
    || (txtPrecoVenda.getText().trim().isEmpty())) {
        
        JOptionPane.showMessageDialog(null, "Dados Inválidos");
        txtDescricao.requestFocus();
    } else {
        Produto cadastroP = new Produto();
        Estoque estoque = new Estoque();
        estoque.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

        cadastroP.setDescricao(txtDescricao.getText());
        cadastroP.setModelo(txtModelo.getText());
        cadastroP.setMarca(jMarca.getSelectedItem().toString());
        cadastroP.setCor(jCor.getSelectedItem().toString());
        cadastroP.setEstoque(estoque); 
        
        // Supondo que você tenha um método para obter o fornecedor selecionado
        Fornecedor fornecedorSelecionado = (Fornecedor) jFornecedor.getSelectedItem();
        cadastroP.setFornecedor(fornecedorSelecionado); // Atribui o fornecedor selecionado ao produto
        
        try {
            double precoCompra = Double.parseDouble(txtPrecoCompra.getText());
            double precoVenda = Double.parseDouble(txtPrecoVenda.getText());
            cadastroP.setPrecoCompra(precoCompra);
            cadastroP.setPrecoVenda(precoVenda);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um preço válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Encerrar execução se a conversão falhar
        }

        try {
            ProdutoDao cadastroPDao = new ProdutoDao();
            cadastroPDao.inserir(cadastroP); 
            
            // Atualiza a tabela após a inserção
            atualizaTabela(cadastroPDao);
            limparCampos();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }              
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void TabelaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaComprasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaComprasMouseClicked

    private void limparCampos()
    {
        this.txtId.setEnabled(true);
        this.txtId.setText("");
        this.txtDescricao.setText("");
        this.txtModelo.setText(null);
        this.txtQuantidade.setText(null);
        this.jCor.setSelectedIndex(-1);
        this.jMarca.setSelectedIndex(-1);
        this.jFornecedor.setSelectedIndex(-1);
        this.txtPrecoCompra.setText(null);
        this.txtPrecoVenda.setText(null);
    }
    
     private void limparTabela()
    {
        while(TabelaCompras.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) TabelaCompras.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
     
     private void atualizaTabela(ProdutoDao cadastroPDao)
    {
        

                try {
        limparTabela();

        ArrayList<Produto> listaCadastros = cadastroPDao.consultar(); // consulta todos os registros da tabela Produto
        
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaCompras.getModel();

        for (Produto cadastroP : listaCadastros) {
            String razaoSocial = "Não Disponível"; // Valor padrão caso o fornecedor seja nulo

            // Verifica se o fornecedor não é nulo antes de tentar acessar a razão social
            if (cadastroP.getFornecedor() != null) {
                razaoSocial = cadastroP.getFornecedor().getRazaoSocial();
            }

            // Adiciona em cada linha da tabela da tela o conteúdo de cada posição da listaProdutos
            modeloTabela.addRow(new String[]{
                Integer.toString(cadastroP.getIdProduto()),
                cadastroP.getDescricao(),
                cadastroP.getModelo(),
                razaoSocial, // Usando a variável que pode ser "Não Disponível"
                cadastroP.getCor(),
                cadastroP.getMarca(),
                String.valueOf(cadastroP.getEstoque().getQuantidade()),
                String.valueOf(cadastroP.getPrecoCompra()),
                String.valueOf(cadastroP.getPrecoVenda())
            });
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
    }
     
    }
     

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TabelaCompras;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jCor;
    private javax.swing.JComboBox<String> jFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jMarca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
