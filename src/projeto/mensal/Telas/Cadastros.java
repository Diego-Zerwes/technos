package projeto.mensal.Telas;

import br.com.parg.viacep.ViaCEP;
import dao.ClienteDao;
import dao.ConexaoBanco;
import dao.FornecedorDao;
import javax.swing.JOptionPane;
import java.sql.*;
import modelo.Cliente;
import modelo.Contatos;
import modelo.Endereco;
import modelo.Fornecedor;

public class Cadastros extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pstCli = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstFunc = null;
    PreparedStatement pstCon = null;
    PreparedStatement pstEnd = null;
    ResultSet rs = null;

    public Cadastros() {
        initComponents();
        ConexaoBanco conn = new ConexaoBanco();
        if (conn.conectar()) {
            conexao = conn.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
   
    public void cadastrarCliente() {
        Cliente cli = new Cliente();

        if (rbtCliPf.isSelected()) {
            cli.setNomeRazaoSocial(txtNome.getText());
            cli.setCpfCnpj(txtCpf.getText());
            cli.setRgInscEst(txtRg.getText());
            cli.setSexo(cboSex.getSelectedItem().toString());
            cli.setTipoCliente("pessoaFisica");
        } else if (rbtCliPj.isSelected()) {
            cli.setNomeRazaoSocial(txtNome.getText());
            cli.setCpfCnpj(txtCnpj.getText());
            cli.setRgInscEst(txtIE.getText());
            cli.setSexo(null);
            cli.setTipoCliente("pessoaJuridica");
        }

        Contatos cont = new Contatos();
        cont.setCelular(txtCel.getText());
        cont.setTelefone(txtTel.getText());
        cont.setEmail(txtEmail.getText());

        Endereco end = new Endereco();
        end.setCep(txtCep.getText());
        end.setLogradouro(txtLograd.getText());
        end.setCidade(txtCid.getText());
        end.setEstado(txtEst.getSelectedItem().toString());
        end.setNumero(txtNum.getText());

        ClienteDao cliDao = new ClienteDao();
        cliDao.cadastrarClientePf(cli, cont, end);
    }

    public void cadastrarFornecedor() {
        Fornecedor forn = new Fornecedor();

        forn.setRazaoSocial(txtNome.getText());
        forn.setCnpj(txtCnpj.getText());
        forn.setiE(txtIE.getText());

        Contatos cont = new Contatos();
        cont.setCelular(txtCel.getText());
        cont.setTelefone(txtTel.getText());
        cont.setEmail(txtEmail.getText());

        Endereco end = new Endereco();
        end.setCep(txtCep.getText());
        end.setLogradouro(txtLograd.getText());
        end.setCidade(txtCid.getText());
        end.setEstado(txtEst.getSelectedItem().toString());
        end.setNumero(txtNum.getText());

        FornecedorDao fornDao = new FornecedorDao();
        fornDao.cadastrarFornecedor(forn, cont, end);
    }

    public void limparCampos() {
        txtNome.setText("");
        txtIE.setText("");
        txtCnpj.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtCel.setText("");
        txtEmail.setText("");
        txtTel.setText("");
        txtCep.setText("");
        txtLograd.setText("");
        txtEst.setSelectedItem(null);
        txtCid.setText("");
        txtNum.setText("");
    }

    public void habilitarCamposCliPjForn() {
        cboSex.setEnabled(false);
        txtIE.setEnabled(true);
        txtCnpj.setEnabled(true);
        txtRg.setEnabled(false);
        txtCpf.setEnabled(false);
    }
    
    public void habilitarCamposCliPf() {
        cboSex.setEnabled(true);
        txtIE.setEnabled(false);
        txtCnpj.setEnabled(false);
        txtRg.setEnabled(true);
        txtCpf.setEnabled(true);
    }

    public void voltarTelaLogin() {
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCel = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtLograd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEst = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboSex = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        btnCad = new javax.swing.JButton();
        btnCanc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtIE = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        rbtCliPf = new javax.swing.JRadioButton();
        rbtForn = new javax.swing.JRadioButton();
        rbtCliPj = new javax.swing.JRadioButton();
        btnLimpCamp = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel5.setText("RG");

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Celular");

        try {
            txtCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Telefone");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("CEP");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
        });

        jLabel9.setText("Logradouro");

        txtCid.setEnabled(false);

        jLabel10.setText("Numero");

        jLabel12.setText("E-mail");

        jLabel13.setText("Cidade");

        txtLograd.setEnabled(false);
        txtLograd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome / Razão Social");

        jLabel14.setText("UF");

        txtEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        txtEst.setSelectedIndex(-1);
        txtEst.setEnabled(false);

        jLabel3.setText("Sexo");

        cboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", " " }));

        jLabel4.setText("CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnCanc.setText("Cancelar");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setText("I.E");

        try {
            txtIE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIE.setEnabled(false);

        jLabel15.setText("CNPJ");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setEnabled(false);

        buttonGroup1.add(rbtCliPf);
        rbtCliPf.setText("Cliente PF");
        rbtCliPf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbtCliPfFocusGained(evt);
            }
        });
        rbtCliPf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtCliPfMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtForn);
        rbtForn.setText("Fornecedor");
        rbtForn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtFornMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtCliPj);
        rbtCliPj.setText("Cliente PJ");
        rbtCliPj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtCliPjMouseClicked(evt);
            }
        });

        btnLimpCamp.setText("Limpar Campos");
        btnLimpCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpCampActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLimpCamp)
                                .addGap(37, 37, 37)
                                .addComponent(btnCad)
                                .addGap(32, 32, 32)
                                .addComponent(btnCanc))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCid, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEst, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtLograd, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtCliPf)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtCliPj)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtForn)))
                                .addGap(4, 4, 4)))
                        .addContainerGap(199, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtLograd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(txtCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtCliPf)
                    .addComponent(rbtForn)
                    .addComponent(rbtCliPj))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCad)
                    .addComponent(btnCanc)
                    .addComponent(btnLimpCamp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            ViaCEP viaCep = new ViaCEP();
            try {
                viaCep.buscar(txtCep.getText());
                txtCid.setText(viaCep.getLogradouro());
                txtLograd.setText(viaCep.getLocalidade());
                txtEst.setSelectedItem(viaCep.getUf());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!!\n" + e.getMessage());
            }

        }
    }//GEN-LAST:event_txtCepKeyPressed

    private void txtLogradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradActionPerformed

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // ao abrir o form marcar o radio button cliente pessoa física
        rbtCliPf.setSelected(true);
    }//GEN-LAST:event_formInternalFrameOpened

    private void rbtFornMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtFornMouseClicked
        // marcando o radio button como Fornecedor
        habilitarCamposCliPjForn();
    }//GEN-LAST:event_rbtFornMouseClicked

    private void rbtCliPfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtCliPfMouseClicked
        // marcando o radio button como cliente pessoa física
        habilitarCamposCliPf();
    }//GEN-LAST:event_rbtCliPfMouseClicked

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        // apertando o botão de cadastrar
        if (rbtCliPf.isSelected()) {
            cadastrarCliente();
            //voltarTelaLogin();
            limparCampos();
        } else if (rbtCliPj.isSelected()) {
            cadastrarCliente();
            //voltarTelaLogin();
            limparCampos();
        } else if(rbtForn.isSelected()) {
            cadastrarFornecedor();
            //voltarTelaLogin();
            limparCampos();
        }
    }//GEN-LAST:event_btnCadActionPerformed

    private void rbtCliPjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtCliPjMouseClicked
        // marcando o radio button como cliente pessoa jurídica
        habilitarCamposCliPjForn();
    }//GEN-LAST:event_rbtCliPjMouseClicked

    private void rbtCliPfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbtCliPfFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtCliPfFocusGained

    private void btnLimpCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpCampActionPerformed
        // limpar todos os campos
        limparCampos();
    }//GEN-LAST:event_btnLimpCampActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnLimpCamp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSex;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbtCliPf;
    private javax.swing.JRadioButton rbtCliPj;
    private javax.swing.JRadioButton rbtForn;
    private javax.swing.JFormattedTextField txtCel;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCid;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtEst;
    private javax.swing.JFormattedTextField txtIE;
    private javax.swing.JTextField txtLograd;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
