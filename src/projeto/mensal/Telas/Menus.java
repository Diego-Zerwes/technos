
package projeto.mensal.Telas;

import dao.FornecedorDao;
import dao.ProdutoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;


public class Menus extends javax.swing.JFrame {
private Compras telaCompras; 
   
    public Menus() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCadastro = new javax.swing.JButton();
        jCompras = new javax.swing.JButton();
        jVendas = new javax.swing.JButton();
        jRelatorio = new javax.swing.JButton();
        jFinanceiro = new javax.swing.JButton();
        jCaixa = new javax.swing.JButton();
        jLogoff = new javax.swing.JButton();
        jEstoque = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnCadastro.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnCadastro.setText("Cadastro");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        jCompras.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jCompras.setText("Compras");
        jCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComprasActionPerformed(evt);
            }
        });

        jVendas.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jVendas.setText("Vendas");
        jVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVendasActionPerformed(evt);
            }
        });

        jRelatorio.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jRelatorio.setText("Relatorio");
        jRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRelatorioActionPerformed(evt);
            }
        });

        jFinanceiro.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jFinanceiro.setText("Financeiro");
        jFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFinanceiroActionPerformed(evt);
            }
        });

        jCaixa.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jCaixa.setText("Caixa");

        jLogoff.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLogoff.setText("Logoff");
        jLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoffActionPerformed(evt);
            }
        });

        jEstoque.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jEstoque.setText("Estoque");
        jEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(btnCadastro)
                .addGap(27, 27, 27)
                .addComponent(jFinanceiro)
                .addGap(29, 29, 29)
                .addComponent(jEstoque)
                .addGap(27, 27, 27)
                .addComponent(jCompras)
                .addGap(29, 29, 29)
                .addComponent(jVendas)
                .addGap(31, 31, 31)
                .addComponent(jCaixa)
                .addGap(33, 33, 33)
                .addComponent(jRelatorio)
                .addGap(32, 32, 32)
                .addComponent(jLogoff)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1051, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private Cadastros tela;
    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        
        if (tela == null || !tela.isVisible()) {
        tela = new Cadastros(); // Cria a tela se não existir ou não estiver visível
        desktop.add(tela);
        tela.setVisible(true);
    } else {
        tela.setVisible(false);
        desktop.remove(desktop);
        desktop.repaint();
    }
    // TODO add your handling code here:
    
    }//GEN-LAST:event_btnCadastroActionPerformed
    private Compras tela1;
    private void jComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComprasActionPerformed
        if (tela1 == null || !tela1.isVisible()) {
        tela1 = new Compras(); // Cria a tela se não existir ou não estiver visível
        desktop.add(tela1);
        tela1.setVisible(true);
    } else {
        tela1.setVisible(false);
        desktop.remove(desktop);
        desktop.repaint();
    }
                // TODO add your handling code here:
        
    }//GEN-LAST:event_jComprasActionPerformed
    private Estoque tela2;
    private void jEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEstoqueActionPerformed
        if (tela2 == null || !tela2.isVisible()) {
        tela2 = new Estoque(); // Cria a tela se não existir ou não estiver visível
        desktop.add(tela2);
        tela2.setVisible(true);
    } else {
        tela2.setVisible(false);
        desktop.remove(desktop);
        desktop.repaint();
    }      
    }//GEN-LAST:event_jEstoqueActionPerformed
    private Relatorio tela3;
    private void jRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioActionPerformed
        if (tela3 == null || !tela3.isVisible()) {
        tela3 = new Relatorio(); // Cria a tela se não existir ou não estiver visível
        desktop.add(tela3);
        tela3.setVisible(true);
    } else {
        tela3.setVisible(false);
        desktop.remove(desktop);
        desktop.repaint();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jRelatorioActionPerformed

    private void jVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVendasActionPerformed

    private void jFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFinanceiroActionPerformed

    private void jLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoffActionPerformed
    dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLogoffActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
         ProdutoDao cadastroProdutos = new ProdutoDao();
         atualizaTabela(cadastroProdutos);

    }//GEN-LAST:event_formWindowOpened
    
    private void atualizaTabela(ProdutoDao cadastroPDao)
    {
        

               try {
        limparTabela();

        ArrayList<Produto> listaCadastros = cadastroPDao.consultar();
        System.out.println("Produtos consultados: " + listaCadastros.size()); // Log para depuração
        
        DefaultTableModel modeloTabela = (DefaultTableModel) this.telaCompras.TabelaCompras.getModel();

        for (Produto cadastroP : listaCadastros) {
            String razaoSocial = "Não Disponível"; // Valor padrão caso o fornecedor seja nulo

            if (cadastroP.getFornecedor() != null) {
                razaoSocial = cadastroP.getFornecedor().getRazaoSocial();
            }

            modeloTabela.addRow(new String[]{
                Integer.toString(cadastroP.getIdProduto()),
                cadastroP.getDescricao(),
                cadastroP.getModelo(),
                razaoSocial,
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
        
        private void limparTabela()
    {
        while(this.telaCompras.TabelaCompras.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) this.telaCompras.TabelaCompras.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
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
            java.util.logging.Logger.getLogger(Menus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jCaixa;
    private javax.swing.JButton jCompras;
    private javax.swing.JButton jEstoque;
    private javax.swing.JButton jFinanceiro;
    private javax.swing.JButton jLogoff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRelatorio;
    private javax.swing.JButton jVendas;
    // End of variables declaration//GEN-END:variables
}
