
package projeto.mensal.Telas;

import dao.ConexaoBanco;
import dao.FornecedorDao;
import dao.ProdutoDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.SwingUtilities;
import modelo.Produto;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import projeto.mensal.Telas.Compras;
import projeto.mensal.Telas.Compras;



public class Menus extends javax.swing.JFrame {
private Compras telaCompras; 

    Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;
    
    //ConexaoBanco conexao = null;
    private Connection conexao;
    
    
   
    public Menus() {
        initComponents();
        ConexaoBanco con = new ConexaoBanco();
        if(con.conectar()){
            conexao = con.getConnection();
            atualizaDash();
        }else{
            JOptionPane.showMessageDialog(null, "Conexao com o Banco falhou");
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCadastro = new javax.swing.JButton();
        jCompras = new javax.swing.JButton();
        jVendas = new javax.swing.JButton();
        jRelatorio = new javax.swing.JButton();
        jLogoff = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        barPanel = new javax.swing.JPanel();

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
        jCompras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComprasFocusGained(evt);
            }
        });
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

        jLogoff.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLogoff.setText("Logoff");
        jLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(btnCadastro)
                .addGap(18, 18, 18)
                .addComponent(jCompras)
                .addGap(18, 18, 18)
                .addComponent(jVendas)
                .addGap(18, 18, 18)
                .addComponent(jRelatorio)
                .addGap(241, 241, 241)
                .addComponent(jLogoff)
                .addGap(83, 83, 83))
        );

        desktop.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout barPanelLayout = new javax.swing.GroupLayout(barPanel);
        barPanel.setLayout(barPanelLayout);
        barPanelLayout.setHorizontalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        barPanelLayout.setVerticalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 662, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        barPanel.setVisible(false);
    desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER);
    } else {
        tela.setVisible(false);
        barPanel.setVisible(true);
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
        barPanel.setVisible(false);
            desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER);

        
    } else {
        tela1.setVisible(false);
        barPanel.setVisible(true);
        desktop.remove(desktop);
        desktop.repaint();
    }
                
        
    }//GEN-LAST:event_jComprasActionPerformed
      private Relatorio tela3;
    private void jRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioActionPerformed
        if (tela3 == null || !tela3.isVisible()) {
        tela3 = new Relatorio(); // Cria a tela se não existir ou não estiver visível
        desktop.add(tela3);
        tela3.setVisible(true);
        barPanel.setVisible(false);
            desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER);
    } else {
        tela3.setVisible(false);
        barPanel.setVisible(true);
        desktop.remove(desktop);
        desktop.repaint();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jRelatorioActionPerformed

    private void jVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVendasActionPerformed

    private void jLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoffActionPerformed
    dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLogoffActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void jComprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComprasFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComprasFocusGained
    private void atualizaDash()
    {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            try {
                ArrayList<Integer> listaProduto = dashboard();
                
                // Verifica se os dados são válidos
                if (listaProduto.size() != 2) {
                    throw new Exception("Os dados retornados são inválidos.");
                }

                System.out.println("Dados: TotalProduto = " + listaProduto.get(0) + ", TotalCompra = " + listaProduto.get(1));

                // Cria o dataset do gráfico
                DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
                barChartData.addValue(listaProduto.get(0), "totalProduto", "Núm Produto");
                barChartData.addValue(listaProduto.get(1), "TotalCompra", "Núm de Compra");

                // Cria o gráfico de barras
                JFreeChart barChart = ChartFactory.createBarChart(
                        "Ex Barras",         // Título do gráfico
                        "Dados",             // Eixo X
                        "Valores",           // Eixo Y
                        barChartData,        // Dados do gráfico
                        PlotOrientation.VERTICAL,  // Orientação do gráfico
                        true,                // Exibe a legenda
                        true,                // Exibe dicas de ferramenta
                        false                // Não usa URL para links
                );
                    System.out.println("Gráfico gerado com sucesso!");
                   // desktop.add(barPanel);
                    //desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER);
                    
                // Personaliza o gráfico
                CategoryPlot barchrt = barChart.getCategoryPlot();
                barchrt.setRangeGridlinePaint(new Color(140, 105, 204));

                // Cria o painel para exibir o gráfico
                ChartPanel chartPanel = new ChartPanel(barChart);

                // Atualiza o painel com a nova visualização do gráfico
                barPanel.setLayout(new BorderLayout());
                barPanel.setPreferredSize(new Dimension(500, 300));
                SwingUtilities.invokeLater(() -> {
                    barPanel.removeAll();
                    barPanel.add(chartPanel, BorderLayout.CENTER);
                    barPanel.revalidate();  // Revalida o layout do painel
                    barPanel.repaint();     // Repinta o painel
                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }, 0, 5, TimeUnit.SECONDS); 
                }
    
    public ArrayList<Integer> dashboard() {
         ArrayList<Integer> ListarDashBoard = new ArrayList<>();
        String sql = "SELECT distinct(select count(*) FROM produto) AS totalProduto, "+
                    "(select count(*) FROM compra) as totalCompra";
        
        try
        {
            
             PreparedStatement psProduto = conexao.prepareStatement(sql);
        ResultSet rsProduto = psProduto.executeQuery();
        if (rsProduto.next()) {
            ListarDashBoard.add(rsProduto.getInt("totalProduto"));
            ListarDashBoard.add(rsProduto.getInt("totalCompra"));
        }

            
            
        }
        catch(Exception ex)
        {
           throw new RuntimeException(ex);
        }
        return ListarDashBoard;
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
    private javax.swing.JPanel barPanel;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jCompras;
    private javax.swing.JButton jLogoff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRelatorio;
    private javax.swing.JButton jVendas;
    // End of variables declaration//GEN-END:variables
}
