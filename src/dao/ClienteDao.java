package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Contatos;
import modelo.Endereco;

public class ClienteDao {

    Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstCli = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public ClienteDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }

    public void cadastrarClientePf(Cliente cliente, Contatos contato, Endereco endereco) {
        String sqlEnd = "INSERT INTO endereco (cep, logradouro, cidade, estado, numero) VALUES (?, ?, ?, ?, ?)";
        String sqlCli = "INSERT INTO clientes (nomeRazaoSocial, cpfCnpj, rgIe, sexo, tipoCliente, idEndereco) VALUES (?, ? , ?, ?, ?, ?)";
        String sqlCon = "INSERT INTO contatos (telefone, celular, email, idCliente, idFornecedor) VALUES (?, ?, ?, ?, ?)";
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
                   
                    pstCli = conn.prepareStatement(sqlCli, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstCli.setString(1, cliente.getNomeRazaoSocial());
                    pstCli.setString(2, cliente.getCpfCnpj());
                    pstCli.setString(3, cliente.getRgInscEst());
                    pstCli.setString(4, cliente.getSexo());
                    pstCli.setString(5, cliente.getTipoCliente());
                    pstCli.setInt(6, idEnderecoGerado);
                    int cadastroCli = pstCli.executeUpdate();

                    if (cadastroCli > 0) {
                        ResultSet rsIdCli = pstCli.getGeneratedKeys();
                        if (rsIdCli.next()) {
                            int idCli = rsIdCli.getInt(1);
                            
                            pstCont = conn.prepareStatement(sqlCon);
                            pstCont.setString(1, contato.getTelefone());
                            pstCont.setString(2, contato.getCelular());
                            pstCont.setString(3, contato.getEmail());
                            pstCont.setInt(4, idCli);
                            pstCont.setInt(5, 0);
                            pstCont.executeUpdate();
                            
                            conn.commit();
                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        }
                    } else {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
                    }
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Erro ao obter ID do endereço!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro aqui????" + e.getMessage());
        }
    }

}
