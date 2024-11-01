
package dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Compra;
import modelo.Estoque;
import modelo.Produto;

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

        pstmt.executeUpdate();  
        System.out.println("compra inserida com sucesso!");  
    } catch (SQLException e) {  
        e.printStackTrace();  
        throw e;  
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
        String sql = "SELECT p.idCompra, p.dataCompra, e.idFornecedor, c.idFormaPagamento, p.idCaixa "
           + "FROM compra p "
           + "INNER JOIN fornecedor e ON p.idFornecedor = e.idFornecedor "
           + "INNER JOIN formapagamento c ON p.idFormaPagamento = c.idFormaPagamento";

    
    ArrayList<Compra> listaCompras = new ArrayList<>();

    try (Connection conn = this.conexao.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Compra comp = new Compra();
            comp.setIdCompra(rs.getInt("idCompra"));
            comp.setDataCompra(rs.getString("dataCompra"));
            comp.setIdFornecedor(rs.getInt("idFornecedor"));
            comp.setIdFormaPagamento(rs.getInt("idFormaPagamento"));
            comp.setIdCaixa(rs.getInt("idCaixa"));
         
            listaCompras.add(comp);
        }
    } catch (SQLException ex) {
        System.err.println("Erro ao consultar produtos: " + ex.getMessage());
        ex.printStackTrace(); 
    }

    return listaCompras;
    }

    @Override
    public ArrayList<Compra> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Compra objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Compra> consultar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
