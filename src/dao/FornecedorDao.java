package dao;

import dao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Contatos;
import modelo.Endereco;
import modelo.Fornecedor;

public class FornecedorDao {

    Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public FornecedorDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    

    public void cadastrarFornecedor(Fornecedor fornecedor, Contatos contato, Endereco endereco) {
        String sqlEnd = "INSERT INTO endereco (cep, logradouro, cidade, estado, numero) VALUES (?, ?, ?, ?, ?)";
        String sqlCli = "INSERT INTO fornecedores (razaoSocial, cnpj, ie, idEndereco) VALUES (?, ? , ?, ?)";
        String sqlCon = "INSERT INTO contatos (telefone, celular, email, idFornecedor) VALUES (?, ?, ?, ?)";
        try {
            conn.setAutoCommit(false);

            pstEnd = conn.prepareStatement(sqlEnd, PreparedStatement.RETURN_GENERATED_KEYS);
            pstEnd.setString(1, endereco.getCep());
            pstEnd.setString(2, endereco.getLogradouro());
            pstEnd.setString(3, endereco.getCidade());
            pstEnd.setString(4, endereco.getEstado());
            pstEnd.setString(5, endereco.getNumero());

            int cadastroEnd = pstEnd.executeUpdate();
            if (cadastroEnd > 0) {
                ResultSet rsEnd = pstEnd.getGeneratedKeys();
                if (rsEnd.next()) {
                    int idEnderecoGerado = rsEnd.getInt(1);

                    pstForn = conn.prepareStatement(sqlCli, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstForn.setString(1, fornecedor.getRazaoSocial());
                    pstForn.setString(2, fornecedor.getCnpj());
                    pstForn.setString(3, fornecedor.getiE());
                    pstForn.setInt(4, idEnderecoGerado);
                    int cadastroForn = pstForn.executeUpdate();

                    if (cadastroForn > 0) {
                        ResultSet rsForn = pstForn.getGeneratedKeys();
                        if (rsForn.next()) {
                            int idForn = rsForn.getInt(1);

                            pstCont = conn.prepareStatement(sqlCon);
                            pstCont.setString(1, contato.getTelefone());
                            pstCont.setString(2, contato.getCelular());
                            pstCont.setString(3, contato.getEmail());
                            pstCont.setInt(4, idForn);
                            pstCont.executeUpdate();

                            conn.commit();
                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        }
                    } else {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor!");
                    }
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Erro ao obter ID do endereço!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço!");
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback(); // Reverte a transação se ocorrer um erro
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar reverter a transação: " + ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    public ArrayList<Fornecedor> consultar() {
    String sql = "SELECT * FROM fornecedores"; // Verifique se o nome da tabela está correto
    ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();

    try (PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
            
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(rs.getInt("idFornecedor")); 
            fornecedor.setRazaoSocial(rs.getString("razaoSocial")); 
            
            listaFornecedores.add(fornecedor);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar fornecedores: " + e.getMessage());
    }

    return listaFornecedores;
}
    
    public Fornecedor buscarFornecedorPorRazaoSocial(String razaoSocial) throws Exception {
    Fornecedor fornecedor = null;
    String sql = "SELECT * FROM fornecedores WHERE razaoSocial = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, razaoSocial);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
            fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
            // Preencha os demais campos necessários
        }
    }
    return fornecedor;
}
}
       

