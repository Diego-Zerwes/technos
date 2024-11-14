
package projeto.mensal.Telas;

import dao.ConexaoBanco;
import dao.FornecedorDao;
import dao.ProdutoDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
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
        jPanel2 = new javax.swing.JPanel();
        pizzaPanel = new javax.swing.JPanel();
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
                .addContainerGap(195, Short.MAX_VALUE)
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

        jPanel2.setLayout(new java.awt.BorderLayout());

        desktop.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout barPanelLayout = new javax.swing.GroupLayout(barPanel);
        barPanel.setLayout(barPanelLayout);
        barPanelLayout.setHorizontalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        barPanelLayout.setVerticalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pizzaPanelLayout = new javax.swing.GroupLayout(pizzaPanel);
        pizzaPanel.setLayout(pizzaPanelLayout);
        pizzaPanelLayout.setHorizontalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pizzaPanelLayout.createSequentialGroup()
                .addGap(0, 495, Short.MAX_VALUE)
                .addComponent(barPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pizzaPanelLayout.setVerticalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pizzaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pizzaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                
        
    }//GEN-LAST:event_jComprasActionPerformed
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
        new Thread(){
           @Override public void run(){
                try
                {

                    ArrayList<Integer> listaProduto = dashboard();
                   
                    DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
                barChartData.addValue(listaProduto.get(0), "totalProduto", "Núm Produto");
                barChartData.addValue(listaProduto.get(1), "TotalCompra", "Núm de Compra");

                JFreeChart barChart = ChartFactory.createBarChart(
                    "Ex Barras",         
                    "Dados",             
                    "Valores",              
                    barChartData,        
                    PlotOrientation.VERTICAL,   
                    true,                
                    true,                
                    false                
                );
                CategoryPlot barchrt = barChart.getCategoryPlot();
                barchrt.setRangeGridlinePaint(new Color(140,105,204));
                CategoryPlot barPlot = (CategoryPlot) barChart.getPlot();
                

                ChartPanel chartPanel = new ChartPanel(barChart);
                barPanel.removeAll();
                barPanel.add(chartPanel, BorderLayout.CENTER);
                barPanel.validate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
            }
              
        }   
        }.start();
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
            }
            PreparedStatement pstCompra = conexao.prepareStatement(sql);
            ResultSet rsCompra = pstCompra.executeQuery();
            if (rsCompra.next()) {
                ListarDashBoard.add(rsCompra.getInt("totalCompra"));
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRelatorio;
    private javax.swing.JButton jVendas;
    private javax.swing.JPanel pizzaPanel;
    // End of variables declaration//GEN-END:variables
}
