
package dao;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.FormaDePagamento;
import modelo.Fornecedor;

public class FormaDePagamentoDao implements DaoGenerica<FormaDePagamento>{
    java.sql.Connection conn = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstForn = null;
    PreparedStatement pstCont = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public FormaDePagamentoDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    @Override
    public void inserir(FormaDePagamento forma) {
    String sql = "INSERT INTO formapagamento (idFormaPagamento, descricao) VALUES (?,?)"; 
    
     try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1,forma.getDescricao()); //subsitui a primeira ocorrência da interrogação pelo atributo nome               
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(FormaDePagamento objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<FormaDePagamento> consultar() {
    String sql = "SELECT * FROM formapagamento"; // Verifique se o nome da tabela está correto
    ArrayList<FormaDePagamento> listaForma = new ArrayList<>();

    try (PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
            
        while (rs.next()) {
            FormaDePagamento forma = new FormaDePagamento();
            forma.setIdFormaPagamento(rs.getInt("idFormaPagamento")); 
            forma.setDescricao(rs.getString("descricao")); 
            
            listaForma.add(forma);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar formaDePagamento: " + e.getMessage());
    }

    return listaForma;    
    }

    @Override
    public ArrayList<FormaDePagamento> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
