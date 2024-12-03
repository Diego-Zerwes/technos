
package projeto.mensal.Telas;

import dao.ConexaoBanco;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartPanel;





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
        pizzaPanel = new javax.swing.JPanel();
        barPanel = new javax.swing.JPanel();
        jDados = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDadosValor = new javax.swing.JLabel();
        jValoresForn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMarca = new javax.swing.JLabel();
        jMarcaMenos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDia = new javax.swing.JLabel();
        jMes = new javax.swing.JLabel();
        jAno = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSamsung = new javax.swing.JLabel();
        jIphone1 = new javax.swing.JLabel();
        jXiaomi = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPrazo = new javax.swing.JLabel();
        jAtacado = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();

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
                .addContainerGap(233, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pizzaPanelLayout = new javax.swing.GroupLayout(pizzaPanel);
        pizzaPanel.setLayout(pizzaPanelLayout);
        pizzaPanelLayout.setHorizontalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        pizzaPanelLayout.setVerticalGroup(
            pizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout barPanelLayout = new javax.swing.GroupLayout(barPanel);
        barPanel.setLayout(barPanelLayout);
        barPanelLayout.setHorizontalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        barPanelLayout.setVerticalGroup(
            barPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jDados.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero de Clientes Cadastrados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jDadosValor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jDadosValor.setForeground(new java.awt.Color(255, 255, 255));
        jDadosValor.setText("000000");

        jValoresForn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jValoresForn.setForeground(new java.awt.Color(255, 255, 255));
        jValoresForn.setText("jLabel2");

        javax.swing.GroupLayout jDadosLayout = new javax.swing.GroupLayout(jDados);
        jDados.setLayout(jDadosLayout);
        jDadosLayout.setHorizontalGroup(
            jDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDadosLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jDadosLayout.createSequentialGroup()
                        .addGroup(jDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jValoresForn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDadosValor, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDadosLayout.setVerticalGroup(
            jDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDadosValor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValoresForn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca Mais Vendida");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jMarca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMarca.setForeground(new java.awt.Color(255, 255, 255));
        jMarca.setText("jLabel3");

        jMarcaMenos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMarcaMenos.setForeground(new java.awt.Color(255, 255, 255));
        jMarcaMenos.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMarca)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMarcaMenos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jMarca)
                .addGap(18, 18, 18)
                .addComponent(jMarcaMenos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(137, 137, 137))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jDia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jDia.setForeground(new java.awt.Color(255, 255, 255));
        jDia.setText("jLabel4");

        jMes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMes.setForeground(new java.awt.Color(255, 255, 255));
        jMes.setText("jLabel5");

        jAno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jAno.setForeground(new java.awt.Color(255, 255, 255));
        jAno.setText("jLabel6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDia)
                            .addComponent(jMes)
                            .addComponent(jAno))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAno)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantidade de Estoque por Marca");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSamsung.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jSamsung.setForeground(new java.awt.Color(255, 255, 255));
        jSamsung.setText("jLabel5");

        jIphone1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jIphone1.setForeground(new java.awt.Color(255, 255, 255));
        jIphone1.setText("jLabel5");

        jXiaomi.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jXiaomi.setForeground(new java.awt.Color(255, 255, 255));
        jXiaomi.setText("jLabel5");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSamsung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jIphone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXiaomi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jIphone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSamsung)
                .addGap(45, 45, 45))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(jXiaomi)
                    .addGap(98, 98, 98)))
        );

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo Venda");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPrazo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPrazo.setForeground(new java.awt.Color(255, 255, 255));
        jPrazo.setText("jLabel6");

        jAtacado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jAtacado.setForeground(new java.awt.Color(255, 255, 255));
        jAtacado.setText("jLabel7");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPrazo)
                            .addComponent(jAtacado))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPrazo)
                .addGap(57, 57, 57)
                .addComponent(jAtacado)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado com Mais Cadastro");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(68, 68, 68))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jEstado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jEstado.setForeground(new java.awt.Color(255, 255, 255));
        jEstado.setText("jLabel7");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jEstado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jEstado)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        desktop.setLayer(pizzaPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(barPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jDados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addComponent(pizzaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(barPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pizzaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(barPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private Cadastros tela;
    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        
         if (tela == null || !tela.isVisible()) {
        tela = new Cadastros(); 
        desktop.add(tela);
        tela.setVisible(true);
        barPanel.setVisible(false);  
    } else {
        tela.setVisible(false);
        barPanel.setVisible(true);  
        desktop.remove(tela);
        desktop.repaint();
    }
    }//GEN-LAST:event_btnCadastroActionPerformed
    private Compras tela1;
    private void jComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComprasActionPerformed
       if (tela1 == null || !tela1.isVisible()) {
        tela1 = new Compras(); 
        desktop.add(tela1);
        tela1.setVisible(true);
        barPanel.setVisible(false);
        desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER); 
    } else {
        tela1.setVisible(false);
        barPanel.setVisible(true);
        desktop.remove(tela1);
        desktop.repaint();
    }
                
        
    }//GEN-LAST:event_jComprasActionPerformed
      private Relatorio tela3;
    private void jRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRelatorioActionPerformed
        if (tela3 == null || !tela3.isVisible()) {
        tela3 = new Relatorio(); 
        desktop.add(tela3);
        tela3.setVisible(true);
        barPanel.setVisible(false);
        desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER); 
    } else {
        tela3.setVisible(false);
        barPanel.setVisible(true);
        desktop.remove(tela3);
        desktop.repaint();
    }
    }//GEN-LAST:event_jRelatorioActionPerformed
    private Vendas tela4;
    private void jVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVendasActionPerformed
         if (tela4 == null || !tela4.isVisible()) {
        tela4 = new Vendas(); 
        desktop.add(tela4);
        tela4.setVisible(true);
        barPanel.setVisible(false);
        desktop.setLayer(barPanel, javax.swing.JLayeredPane.PALETTE_LAYER); 
        tela4.setVisible(false);
        barPanel.setVisible(true);
        desktop.remove(tela4);
        desktop.repaint();
    }
    }//GEN-LAST:event_jVendasActionPerformed

    private void jLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoffActionPerformed
           // TODO add your handling code here:
    System.exit(0);
    }//GEN-LAST:event_jLogoffActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void jComprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComprasFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComprasFocusGained
    private void atualizaDash() {
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            try {
                ArrayList<Integer> listaProduto = dashboard();
             
                if (listaProduto.size() != 7) {
                    throw new Exception("Os dados retornados são inválidos.");
                }
                
                System.out.println("Dados: TotalProduto = " + listaProduto.get(0) + ", TotalCompra = " + listaProduto.get(1));
                
                int vendasDia = buscarVendasDia();
                int vendasMes = buscarVendasMes();
                int vendasAno = buscarVendasAno();
                
                int quantidadeXiaomi = buscarQuantidadePorMarca("XIAOMI");
                int quantidadeIphone = buscarQuantidadePorMarca("IPHONE");
                int quantidadeSamsung = buscarQuantidadePorMarca("SAMSUNG");
                
                String estadoMaisCadastrado = buscarEstadoMaisCadastrado();
               
                String marcaMaisVendida = buscarMarcaMaisVendida();
                System.out.println("Marca mais vendida: " + marcaMaisVendida);
                
                String marcaMenosVendida = buscarMarcaMenosVendida();
                System.out.println("Marca menos vendida: " + marcaMenosVendida);

                DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
                barChartData.addValue(listaProduto.get(0), "totalProduto", "Núm Produto");
                barChartData.addValue(listaProduto.get(1), "TotalCompra", "Núm de Compra");

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

                CategoryPlot barchrt = barChart.getCategoryPlot();
                barchrt.setRangeGridlinePaint(new Color(140, 105, 204));

                ChartPanel barChartPanel = new ChartPanel(barChart);

                DefaultPieDataset pieDataset = new DefaultPieDataset();
                pieDataset.setValue("Dinheiro", listaProduto.get(2));  
                pieDataset.setValue("Crédito", listaProduto.get(3));   
                pieDataset.setValue("Débito", listaProduto.get(4));    

                JFreeChart pieChart = ChartFactory.createPieChart(
                        "Forma de Pagamento",   // Título do gráfico
                        pieDataset,             // Dados do gráfico
                        true,                    // Exibe a legenda
                        true,                    // Exibe dicas de ferramenta
                        false                    // Não usa URL para links
                );
                ChartPanel pieChartPanel = new ChartPanel(pieChart);
                // Personaliza o gráfico de pizza
                PiePlot piePlot = (PiePlot) pieChart.getPlot();
                piePlot.setSectionPaint("Dinheiro", new Color(140, 105, 204));  
                piePlot.setSectionPaint("Crédito", new Color(102, 205, 170));   
                piePlot.setSectionPaint("Débito", new Color(255, 165, 0));      
                piePlot.setBackgroundPaint(Color.WHITE);  


                SwingUtilities.invokeLater(() -> {
                    barPanel.setLayout(new BorderLayout());
                    barPanel.setPreferredSize(new Dimension(500, 300));
                    barPanel.removeAll();
                    barPanel.add(barChartPanel, BorderLayout.CENTER);
                    barPanel.revalidate();
                    barPanel.repaint();

                    pizzaPanel.setLayout(new BorderLayout());
                    pizzaPanel.setPreferredSize(new Dimension(500, 300));
                    pizzaPanel.removeAll();
                    pizzaPanel.add(pieChartPanel, BorderLayout.CENTER);
                    pizzaPanel.revalidate();
                    pizzaPanel.repaint();
                    
                    jDadosValor.setText("Total de Clientes: " + listaProduto.get(5)); 
                    
                    jValoresForn.setText("Total Fornecedor: " + listaProduto.get(6));
                    
                    jMarca.setText("Marca Mais Vendida: " + marcaMaisVendida);  
                    jMarcaMenos.setText("Marca Menos Vendida: " + marcaMenosVendida);  
                    
                    jDia.setText("Vendas no dia: " + vendasDia);
                    jMes.setText("Vendas no mês: " + vendasMes);
                    jAno.setText("Vendas no ano: " + vendasAno);

                    jXiaomi.setText("Xiaomi: " + quantidadeXiaomi);
                    jIphone1.setText("Iphone: " + quantidadeIphone);
                    jSamsung.setText("Samsung: " + quantidadeSamsung);
                    
                    jEstado.setText("Estado:" + estadoMaisCadastrado);  
                    
                    atualizarTotaisVendas();
                });

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }, 0, 5, TimeUnit.SECONDS);
}



    
    public ArrayList<Integer> dashboard() {
         ArrayList<Integer> ListarDashBoard = new ArrayList<>();
        String sql = "SELECT " +
                 "(SELECT COUNT(*) FROM produto) AS totalProduto, " +
                 "(SELECT COUNT(*) FROM compra) AS totalCompra, " +
                 "(SELECT COUNT(*) FROM compra c JOIN formapagamento f ON c.idFormaPagamento = f.idFormaPagamento WHERE f.descricao = 'dinheiro') AS totalDinheiro, " +
                 "(SELECT COUNT(*) FROM compra c JOIN formapagamento f ON c.idFormaPagamento = f.idFormaPagamento WHERE f.descricao = 'credito') AS totalCredito, " +
                 "(SELECT COUNT(*) FROM compra c JOIN formapagamento f ON c.idFormaPagamento = f.idFormaPagamento WHERE f.descricao = 'debito') AS totalDebito, " +
                 "(SELECT COUNT(*) FROM venda) AS totalVenda, "+
                 "(SELECT COUNT(*) FROM clientes) AS totalCliente, " +
                 "(SELECT COUNT(*) FROM fornecedores) AS totalFornecedores " ;
    try {
        PreparedStatement psProduto = conexao.prepareStatement(sql);
        ResultSet rsProduto = psProduto.executeQuery();

        if (rsProduto.next()) {
            
            System.out.println("TotalProduto: " + rsProduto.getInt("totalProduto"));
            System.out.println("TotalCompra: " + rsProduto.getInt("totalCompra"));
            System.out.println("TotalDinheiro: " + rsProduto.getInt("totalDinheiro"));
            System.out.println("TotalCredito: " + rsProduto.getInt("totalCredito"));
            System.out.println("TotalDebito: " + rsProduto.getInt("totalDebito"));
            System.out.println("TotalVenda: " + rsProduto.getInt("totalVenda"));
            System.out.println("TotalCliente: " + rsProduto.getInt("totalCliente"));
            
            ListarDashBoard.add(rsProduto.getInt("totalProduto"));
            ListarDashBoard.add(rsProduto.getInt("totalCompra"));
            ListarDashBoard.add(rsProduto.getInt("totalDinheiro"));
            ListarDashBoard.add(rsProduto.getInt("totalCredito"));
            ListarDashBoard.add(rsProduto.getInt("totalDebito"));
            ListarDashBoard.add(rsProduto.getInt("totalVenda"));
            ListarDashBoard.add(rsProduto.getInt("totalFornecedores"));



        }
            
        }
        catch(Exception ex)
        {
           throw new RuntimeException(ex);
        }
        return ListarDashBoard;
    }
    
   public String buscarMarcaMaisVendida() {
    String marcaMaisVendida = "";  

    String sql = "SELECT p.marca " +
                 "FROM produto p " +
                 "JOIN itemvenda iv ON iv.idProduto = p.idProduto " +
                 "GROUP BY p.marca " +
                 "ORDER BY SUM(iv.quantidade) DESC " +
                 "LIMIT 1";  

    try (PreparedStatement ps = conexao.prepareStatement(sql);
         ResultSet rsProduto = ps.executeQuery()) {  

        if (rsProduto.next()) {
            marcaMaisVendida = rsProduto.getString("marca");  
        } else {
            System.out.println("Nenhuma marca foi encontrada!");
            marcaMaisVendida = "Nenhuma marca encontrada";  
        }

    } catch (Exception e) {
        e.printStackTrace();  
        throw new RuntimeException("Erro ao executar a consulta: " + e.getMessage(), e);  
    }

    return marcaMaisVendida;  
}
   
            public String buscarMarcaMenosVendida() {
             String marcaMenosVendida = "";  

             String sql = "SELECT p.marca " +
                          "FROM produto p " +
                          "LEFT JOIN itemvenda iv ON iv.idProduto = p.idProduto " +
                          "GROUP BY p.marca " +
                          "ORDER BY SUM(IFNULL(iv.quantidade, 0)) ASC " +  
                          "LIMIT 1";  

             try (PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rsProduto = ps.executeQuery()) {  

                 if (rsProduto.next()) {
                     marcaMenosVendida = rsProduto.getString("marca");  
                 } else {
                     System.out.println("Nenhuma marca foi encontrada!");
                     marcaMenosVendida = "Nenhuma marca encontrada";  
                 }

             } catch (Exception e) {
                 e.printStackTrace();  
                 throw new RuntimeException("Erro ao executar a consulta: " + e.getMessage(), e);  
             }

             return marcaMenosVendida;  
         }

            public int buscarVendasDia() {
             String sql = "SELECT COUNT(*) AS vendasDia FROM venda WHERE DATE(dataVenda) = CURDATE()";
             try (PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) {
                     return rs.getInt("vendasDia");
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 throw new RuntimeException("Erro ao consultar vendas por dia: " + e.getMessage(), e);
             }
             return 0;  
         }

         public int buscarVendasMes() {
             String sql = "SELECT COUNT(*) AS vendasMes FROM venda WHERE YEAR(dataVenda) = YEAR(CURDATE()) AND MONTH(dataVenda) = MONTH(CURDATE())";
             try (PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) {
                     return rs.getInt("vendasMes");
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 throw new RuntimeException("Erro ao consultar vendas por mês: " + e.getMessage(), e);
             }
             return 0;  
         }

         public int buscarVendasAno() {
             String sql = "SELECT COUNT(*) AS vendasAno FROM venda WHERE YEAR(dataVenda) = YEAR(CURDATE())";
             try (PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) {
                     return rs.getInt("vendasAno");
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 throw new RuntimeException("Erro ao consultar vendas por ano: " + e.getMessage(), e);
             }
             return 0;  
         }

         public int buscarQuantidadePorMarca(String marca) {
        String sql = "SELECT SUM(p.quantidade) AS totalProdutos " +
                 "FROM produto p " +
                 "WHERE p.marca = ?";  
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, marca);  
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("totalProdutos");  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar a quantidade de produtos da marca " + marca + ": " + e.getMessage(), e);
        }
        return 0;  
}
         
         public void atualizarTotaisVendas() {
    String sql = "SELECT idTipoVenda, SUM(idTipoVenda) AS totalQuantidade " +
                 "FROM venda " +
                 "WHERE idTipoVenda IN (1, 2) " +  
                 "GROUP BY idTipoVenda";
            int totalPrazo = 0;
            int totalAvista = 0;
    

    try (PreparedStatement ps = conexao.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
           
            int idTipoVenda = rs.getInt("idTipoVenda");
            int totalQuantidade = rs.getInt("totalQuantidade");
             
            if (idTipoVenda == 1) {
                totalPrazo = totalQuantidade;
            } 
            else if (idTipoVenda == 2) {
                totalAvista = totalQuantidade;
            }
        }
        jPrazo.setText("Á PRAZO: " + totalPrazo);
        jAtacado.setText("ATACADO: " + totalAvista);
        // Atualiza os JLabels com os totais
       // SwingUtilities.invokeLater(() -> {
        //    ;
       // });

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao obter os totais de venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
         
         public String buscarEstadoMaisCadastrado() {
    String estadoMaisCadastrado = ""; 

    String sql = "SELECT estado, COUNT(*) AS total " +
                 "FROM endereco " +
                 "GROUP BY estado " +
                 "ORDER BY total DESC " +
                 "LIMIT 1"; 

    try (PreparedStatement ps = conexao.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            estadoMaisCadastrado = rs.getString("estado"); 
        } else {
            estadoMaisCadastrado = "Nenhum estado encontrado"; 
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        throw new RuntimeException("Erro ao buscar o estado mais cadastrado: " + e.getMessage(), e);
    }

    return estadoMaisCadastrado; 
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
    private javax.swing.JLabel jAno;
    private javax.swing.JLabel jAtacado;
    private javax.swing.JButton jCompras;
    private javax.swing.JPanel jDados;
    public javax.swing.JLabel jDadosValor;
    private javax.swing.JLabel jDia;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jIphone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLogoff;
    private javax.swing.JLabel jMarca;
    private javax.swing.JLabel jMarcaMenos;
    private javax.swing.JLabel jMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jPrazo;
    private javax.swing.JButton jRelatorio;
    private javax.swing.JLabel jSamsung;
    private javax.swing.JLabel jValoresForn;
    private javax.swing.JButton jVendas;
    private javax.swing.JLabel jXiaomi;
    private javax.swing.JPanel pizzaPanel;
    // End of variables declaration//GEN-END:variables
}
