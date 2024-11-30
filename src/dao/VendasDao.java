/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Venda;

/**
 *
 * @author difoz
 */
public class VendasDao implements DaoGenerica<Venda>{
    public ConexaoBanco conexao;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstCli = null;
    PreparedStatement pstCont = null;
    
    public VendasDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    
    @Override
    public void inserir(Venda objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean inserirVenda(Venda venda) {
    boolean sucesso = false;
    String sql = "INSERT INTO venda (idCliente, idFormaPagamento, idTipoVenda, idRelatorio, dataVenda) VALUES (?, ?, ?, ?, NOW())"; 

    try {
        if(this.conexao.conectar()){
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 

        // Define os valores dos parâmetros
        sentenca.setInt(1, venda.getIdCliente());          
        sentenca.setInt(2, venda.getIdFormaPagamento());   
        sentenca.setInt(3, venda.getIdTipoVenda());        
        sentenca.setInt(4, venda.getIdRelatorio());        


        int linhasAfetadas = sentenca.executeUpdate();
        
        if (linhasAfetadas > 0) {
            sucesso = true;  
            System.out.println("Venda inserida com sucesso.");
        } else {
            System.out.println("Falha ao inserir venda.");
        }
        }
    } catch (Exception e) {
        System.out.println("Erro ao inserir a venda: " + e.getMessage());
        e.printStackTrace();
    }

    return sucesso;
}

    @Override
    public void alterar(Venda objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Venda> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Venda> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
