
package projeto.mensal.Telas;

import com.mysql.cj.xdevapi.Statement;
//import com.sun.jdi.connect.spi.Connection;
import dao.ComprasDao;
import dao.ConexaoBanco;
import dao.FormaDePagamentoDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Produto;
import modelo.Estoque;
import modelo.FormaDePagamento;
import modelo.Fornecedor;
import java.sql.Timestamp;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author diegozerwesfeitosa
 */
public class Compras extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public Compras() {
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
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jFornecedor = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jFormaDePagamento = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Modelo", "Cor", "Marca", "Quantidade", "Preço de Compra", "Preço de venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        }

        jLabel10.setText("Fornecedor");

        jLabel11.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFornecedorMouseClicked(evt);
            }
        });
        jFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFornecedorActionPerformed(evt);
            }
        });

        jLabel12.setText("Forma de Pagamento");

        jFormaDePagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormaDePagamentoMouseClicked(evt);
            }
        });
        jFormaDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormaDePagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(229, 229, 229)
                                        .addComponent(btnCadastrar)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(111, 111, 111)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(57, 57, 57)
                                                .addComponent(jFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnCadastrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
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
    if ((txtDescricao.getText().trim().isEmpty()) ||
        (txtModelo.getText().trim().isEmpty()) ||
        (txtQuantidade.getText().trim().isEmpty()) ||
        (jCor.getSelectedIndex() < 0) ||
        (jMarca.getSelectedIndex() < 0) ||
        (txtPrecoCompra.getText().trim().isEmpty()) ||
        (txtPrecoVenda.getText().trim().isEmpty())) {

        JOptionPane.showMessageDialog(null, "Dados Inválidos");
        txtDescricao.requestFocus();
    } else {
        try {
            double precoCompra = 0.0;
            double precoVenda = 0.0;

            try {
                precoCompra = Double.parseDouble(txtPrecoCompra.getText().trim());
                precoVenda = Double.parseDouble(txtPrecoVenda.getText().trim());

                if (precoCompra <= 0 || precoVenda <= 0) {
                    JOptionPane.showMessageDialog(null, "Os preços devem ser maiores que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;  
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Preço de compra ou venda inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;  
            }

            System.out.println("Preços válidos: Preço Compra = " + precoCompra + ", Preço Venda = " + precoVenda);

            Produto cadastroP = new Produto();
            
            Timestamp timestampAtual2 = new Timestamp(System.currentTimeMillis());

            cadastroP.setDescricao(txtDescricao.getText().trim());
            cadastroP.setModelo(txtModelo.getText().trim());
            cadastroP.setMarca(jMarca.getSelectedItem().toString().trim());
            cadastroP.setCor(jCor.getSelectedItem().toString().trim());
            cadastroP.setPrecoCompra(precoCompra);  // Atribuindo o valor de precoCompra
            cadastroP.setPrecoVenda(precoVenda);  // Atribuindo o valor de precoVenda
            cadastroP.setEstoque(Integer.parseInt(txtQuantidade.getText().trim()));

            Compra comprasP = new Compra();
            String razaoSocialSelecionada = (String) jFornecedor.getSelectedItem();
            FornecedorDao fornecedorDao = new FornecedorDao();

            Fornecedor fornecedorSelecionado;
            try {
                fornecedorSelecionado = fornecedorDao.buscarFornecedorPorRazaoSocial(razaoSocialSelecionada);
                if (fornecedorSelecionado != null) {
                    comprasP.setIdFornecedor(fornecedorSelecionado.getIdFornecedor());
                } else {
                    JOptionPane.showMessageDialog(null, "Fornecedor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }

            String descricaoFormaSelecionada = (String) jFormaDePagamento.getSelectedItem();
            FormaDePagamentoDao formapagamentoDao = new FormaDePagamentoDao();
            FormaDePagamento formaPagamentoSelecionada;
            try {
                formaPagamentoSelecionada = formapagamentoDao.buscarFormaDePagamento(descricaoFormaSelecionada);
                if (formaPagamentoSelecionada != null) {
                    comprasP.setIdFormaPagamento(formaPagamentoSelecionada.getIdFormaPagamento());
                } else {
                    JOptionPane.showMessageDialog(null, "Forma de pagamento não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }

            Timestamp timestampAtual = new Timestamp(System.currentTimeMillis());
            comprasP.setDataCompra(timestampAtual.toString());

            ComprasDao compraDao = new ComprasDao();
            try {
                compraDao.inserirCompra(comprasP);
                JOptionPane.showMessageDialog(null, "Compra registrada com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao registrar a compra: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

            ProdutoDao produtoDao = new ProdutoDao();
            try {
                produtoDao.inserirProduto(cadastroP);  
                JOptionPane.showMessageDialog(null, "Produto e Estoque inseridos com sucesso.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir produto e estoque: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            e.printStackTrace();  
            JOptionPane.showMessageDialog(null, "Erro ao processar o cadastro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void TabelaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaComprasMouseClicked
        if((TabelaCompras.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)){
           txtId.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),0).toString());
           txtDescricao.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),1).toString());
           txtModelo.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),2).toString());
           jCor.setSelectedItem(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(), 3).toString());
           jMarca.setSelectedItem(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(), 4).toString());
           txtQuantidade.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),5).toString());
           txtPrecoCompra.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),6).toString());
           txtPrecoVenda.setText(TabelaCompras.getValueAt(TabelaCompras.getSelectedRow(),7).toString());
           vInsUpdate = 1;
           //TabelaCompras.setEnabled(false);
           btnCadastrar.setText("Alterar");
           txtId.setEnabled(false);
        }   
    }//GEN-LAST:event_TabelaComprasMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded

    }//GEN-LAST:event_formComponentAdded

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
       
    }//GEN-LAST:event_formAncestorAdded

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        FormaDePagamentoDao formadepagamentoDao = new FormaDePagamentoDao();
         atualizaForma(formadepagamentoDao);
         FornecedorDao fornecedorDao = new FornecedorDao();
         atualizaFornecedor(fornecedorDao);
         conectarEBuscarProdutos();
        
    }//GEN-LAST:event_formComponentShown

    private void jFormaDePagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormaDePagamentoMouseClicked
       
    }//GEN-LAST:event_jFormaDePagamentoMouseClicked

    private void jFormaDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormaDePagamentoActionPerformed

    }//GEN-LAST:event_jFormaDePagamentoActionPerformed

    private void jFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFornecedorActionPerformed

    }//GEN-LAST:event_jFornecedorActionPerformed

    private void jFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFornecedorMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jFornecedorMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        ProdutoDao prod = new ProdutoDao();
        buscarNome(prod);
    }//GEN-LAST:event_txtBuscarKeyPressed

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
        this.jFormaDePagamento.setSelectedIndex(-1);
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
     
    public void atualizaTabela(ArrayList<Produto> listaProdutos) {
    try {
        limparTabela();  

        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaCompras.getModel();

        for (Produto cadastroP : listaProdutos) {
            String razaoSocial = "Não Disponível"; 
            if (cadastroP.getFornecedor() != null) {
                razaoSocial = cadastroP.getFornecedor().getRazaoSocial();
            }

            modeloTabela.addRow(new String[]{
                Integer.toString(cadastroP.getIdProduto()),
                cadastroP.getDescricao(),
                cadastroP.getModelo(),
                cadastroP.getCor(),
                cadastroP.getMarca(),
                String.valueOf(cadastroP.getEstoque()),
                String.valueOf(cadastroP.getPrecoCompra()),
                String.valueOf(cadastroP.getPrecoVenda())
            });
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
    }
}
     
public void atualizaFornecedor(FornecedorDao fornecedorDao) {
    try {
        ArrayList<Fornecedor> listarFornecedores = fornecedorDao.consultar(); 

        jFornecedor.removeAllItems(); 

        for (Fornecedor fornecedor : listarFornecedores) {
            jFornecedor.addItem(fornecedor.getRazaoSocial()); 
        }

        jFornecedor.setSelectedIndex(-1); 
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
    }
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
                        jFormaDePagamento.addItem(forma.getDescricao());
                    }
                    jFormaDePagamento.setSelectedIndex(-1);
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

private void buscarNome(ProdutoDao prodDao)
    {
     
     
            try
            {

                limparTabela();

                ArrayList<Produto> listaCadastrosStr;
                listaCadastrosStr = prodDao.consultar(txtBuscar.getText()); 

                DefaultTableModel modeloTabela = (DefaultTableModel) TabelaCompras.getModel();

                for(Produto cadastroP : listaCadastrosStr)
                {
                    modeloTabela.addRow(new String[]{
                Integer.toString(cadastroP.getIdProduto()), 
                cadastroP.getDescricao(), 
                cadastroP.getModelo(), 
                cadastroP.getCor(),
                cadastroP.getMarca(),
                String.valueOf(cadastroP.getEstoque()), 
                String.valueOf(cadastroP.getPrecoCompra()),            
                String.valueOf(cadastroP.getPrecoVenda())});
                }

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
            }
      
    }
   
    private void conectarEBuscarProdutos() {
    ProdutoDao cadastroPDao = new ProdutoDao();
    
    if(cadastroPDao.conexao.conectar()) {
        try {
            ArrayList<Produto> listaProdutos = cadastroPDao.consultar();
            atualizaTabela(listaProdutos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
             
        }
    } else {
        JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TabelaCompras;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jCor;
    private javax.swing.JComboBox<String> jFormaDePagamento;
    private javax.swing.JComboBox<String> jFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
