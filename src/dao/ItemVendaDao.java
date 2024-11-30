/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ItemVenda;


public class ItemVendaDao implements DaoGenerica<ItemVenda>{
    public ConexaoBanco conexao;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstCli = null;
    PreparedStatement pstCont = null;
    
    public ItemVendaDao() {
        this.conexao = new ConexaoBanco(); 
    }


    public boolean conectar() {
        return this.conexao.conectar(); 
    }
    

    public Connection getConnection() {
        return conexao.getConnection();  
    }

    public void fecharConexao() {
        this.conexao.fecharConexao(); 
    }
    
    @Override
    public void inserir(ItemVenda itemvenda) {
        String sql = "INSERT INTO itemvenda (idProduto, quantidade, precoVenda) VALUES (?, ?, ?)";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  
        pstmt.setString(1, itemvenda.getIdProduto());  
        pstmt.setString(2, itemvenda.getPrecoVenda());  
        pstmt.setInt(3, itemvenda.getQuantidade());  
 

        pstmt.executeUpdate();  
        System.out.println("compra inserida com sucesso!");  
    } catch (SQLException e) {  
        e.printStackTrace();   
    }  
    }
    
 
    public void adicionarItemVenda( String idProduto, int quantidade, double valorTotal) {
        boolean sucesso = false;
    String sql = "INSERT INTO itemvenda (idProduto, quantidade, precoVenda) VALUES (?, ?, ?)";

    // Abertura da conexão
    try (Connection conn = this.conexao.getConnection();  // Usa a conexão gerenciada pela classe ConexaoBanco
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Setando os parâmetros

        stmt.setString(1, idProduto);  // ID do produto
        stmt.setInt(2, quantidade);  // Quantidade comprada
        stmt.setDouble(3, valorTotal);  // Preço de venda

        // Executa a inserção
        stmt.executeUpdate();
        System.out.println("Compra inserida com sucesso!");

    } catch (SQLException e) {
        // Se ocorrer algum erro durante a execução, ele será exibido no console
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao adicionar item na tabela de vendas.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


    @Override
    public void alterar(ItemVenda objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ItemVenda> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ItemVenda> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
