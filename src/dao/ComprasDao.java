
package dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Compra;

public class ComprasDao implements DaoGenerica<Compra>{
Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public ComprasDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    

 
public void inserirCompra(Compra compra) throws SQLException {  
    // Formatação da data  
    Timestamp dataCompraFormatada = new Timestamp(System.currentTimeMillis()); 
    String sql = "INSERT INTO compra (dataCompra, idFornecedor, idFormaPagamento, idCaixa, idRelatorio) VALUES (?, ?, ?, ?, ?)";  

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  
        pstmt.setTimestamp(1, dataCompraFormatada);  
        pstmt.setInt(2, compra.getIdFornecedor());  
        pstmt.setInt(3, compra.getIdFormaPagamento());  
        pstmt.setInt(4, compra.getIdCaixa());  
        pstmt.setInt(5, compra.getIdRelatorio());  

        // Executa a inserção no banco de dados  
        pstmt.executeUpdate();  
        System.out.println("compra inserida com sucesso!");  
    } catch (SQLException e) {  
        // Trate a exceção se ocorrer um erro de SQL  
        e.printStackTrace();  
        throw e; // Lançar novamente a exceção para tratamento externo, se necessário  
    }  
}  



    @Override
    public void alterar(Compra objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compra> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compra> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Compra objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
