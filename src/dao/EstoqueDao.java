
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Estoque;


public class EstoqueDao implements DaoGenerica<Estoque>{

    private ConexaoBanco conexao;
    Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;
    public EstoqueDao()
    {
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public void inserir(Estoque estoque) {
       // String sql = "INSERT INTO estoque (quantidade) VALUES (?) ";
        
       // try
      //  {
          //  if(this.conexao.conectar())
          //  {
         //       PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
          //      sentenca.setInt(1,estoque.getQuantidade()); 
          //      sentenca.execute(); 
          //      sentenca.close(); 
          //      this.conexao.getConnection().close(); 
        //    }
       // }
       // catch(SQLException ex)
        //{
       //    throw new RuntimeException(ex);
       // }
    }

    @Override
    public void alterar(Estoque objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Estoque> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int consultarQuantidadePorId(int idEstoque) {
    String sql = "SELECT quantidade FROM estoque WHERE idEstoque = ?";
    int quantidade = 0;

    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, idEstoque);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            quantidade = rs.getInt("quantidade");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return quantidade;
}
     public int consultarQuantidadeEstoque(int idProduto) {
        String sql = "SELECT quantidade FROM estoque WHERE idProduto = ?";
        int quantidade = 0;
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idProduto);  // Atribui o ID do produto para a consulta
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantidade;
    }
    
    public boolean atualizarQuantidadeEstoque(int idProduto, int novaQuantidade) {
    String sql = "UPDATE estoque SET quantidade = ? WHERE idProduto = ?"; // Atualizando a quantidade do estoque

    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, novaQuantidade); // Nova quantidade após a compra
        pst.setInt(2, idProduto); // ID do produto para o qual atualizar o estoque
        int rowsAffected = pst.executeUpdate();

        return rowsAffected > 0; // Retorna true se a atualização for bem-sucedida
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Caso ocorra algum erro
    }
}
    @Override
    public ArrayList<Estoque> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
