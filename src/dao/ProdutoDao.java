
package dao;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Produto;
import modelo.Estoque;
import modelo.Fornecedor;

/**
 *
 * @author difoz
 */
public class ProdutoDao implements DaoGenerica<Produto>{
    public ConexaoBanco conexao;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pstEnd = null;
    PreparedStatement pstCli = null;
    PreparedStatement pstCont = null;
    
    public ProdutoDao() {
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
    public void inserirProduto(Produto produto) throws SQLException {
     Connection conn = null;

    try {
        conn = this.getConnection();
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Erro de conexão com o banco de dados.");
        }

        conn.setAutoCommit(false);  
        
        String sqlProduto = "INSERT INTO produto (descricao, modelo, marca, cor, precoCompra, precoVenda, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement psProduto = conn.prepareStatement(sqlProduto, PreparedStatement.RETURN_GENERATED_KEYS)) {

            if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
                throw new SQLException("A descrição do produto não pode ser nula ou vazia.");
            }
            psProduto.setString(1, produto.getDescricao());

            if (produto.getModelo() == null || produto.getModelo().trim().isEmpty()) {
                throw new SQLException("O modelo do produto não pode ser nulo ou vazio.");
            }
            psProduto.setString(2, produto.getModelo());

            if (produto.getMarca() == null || produto.getMarca().trim().isEmpty()) {
                throw new SQLException("A marca do produto não pode ser nula ou vazia.");
            }
            psProduto.setString(3, produto.getMarca());

            if (produto.getCor() == null || produto.getCor().trim().isEmpty()) {
                throw new SQLException("A cor do produto não pode ser nula ou vazia.");
            }
            psProduto.setString(4, produto.getCor());

            if (produto.getPrecoCompra() == null || produto.getPrecoCompra() <= 0) {
                throw new SQLException("Preço de compra inválido.");
            }
            psProduto.setDouble(5, produto.getPrecoCompra());

            if (produto.getPrecoVenda() == null || produto.getPrecoVenda() <= 0) {
                throw new SQLException("Preço de venda inválido.");
            }
            psProduto.setDouble(6, produto.getPrecoVenda());
            psProduto.setInt(7, produto.getEstoque());


            int rowsAffectedProduto = psProduto.executeUpdate();
            if (rowsAffectedProduto == 0) {
                throw new SQLException("Nenhuma linha foi inserida na tabela produto.");
            }

            try (ResultSet rs = psProduto.getGeneratedKeys()) {
                if (rs.next()) {
                    int idProduto = rs.getInt(1);
                    produto.setIdProduto(idProduto); 
                    System.out.println("Produto inserido com sucesso, ID gerado: " + idProduto);
                } else {
                    throw new SQLException("Erro ao recuperar o ID do produto inserido.");
                }
            }
        }

        conn.commit();
        System.out.println("Produto e Estoque inseridos com sucesso.");

    } catch (SQLException ex) {
        if (conn != null) {
            try {
                conn.rollback();  // Rollback em caso de erro
                System.out.println("Transação revertida.");
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        throw ex;  
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.setAutoCommit(true);  
                conn.close();  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    @Override
    public void alterar(Produto produto) {
    String sqlAlterarProduto = "UPDATE produto SET descricao = ?, modelo = ?, marca = ?, cor = ?, precoCompra = ?, precoVenda = ?, quantidade = ? WHERE idProduto = ?";

    try {
        if (this.conexao.conectar()) {
            
            if (rs.next()) {
                System.out.println("Quantidade em estoque para idProduto " + produto.getIdProduto());
                
                PreparedStatement stmtAlterarProduto = this.conexao.getConnection().prepareStatement(sqlAlterarProduto);

                stmtAlterarProduto.setString(1, produto.getDescricao());
                stmtAlterarProduto.setString(2, produto.getModelo());
                stmtAlterarProduto.setString(3, produto.getMarca());
                stmtAlterarProduto.setString(4, produto.getCor());
                stmtAlterarProduto.setDouble(5, produto.getPrecoCompra());
                stmtAlterarProduto.setDouble(6, produto.getPrecoVenda());
                stmtAlterarProduto.setInt(7, produto.getIdProduto());
                stmtAlterarProduto.setInt(8, produto.getEstoque());

                stmtAlterarProduto.executeUpdate();
                stmtAlterarProduto.close();
            } else {
                System.out.println("Produto com idProduto " + produto.getIdProduto() + " não encontrado no estoque.");
            }

            rs.close();
           
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Produto> consultar() {
   String sql = "SELECT * FROM produto";  
    ArrayList<Produto> produtos = new ArrayList<>();
    
    try {
        conn = this.conexao.getConnection();  

        if (conn != null) {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produto.setEstoque(rs.getInt("quantidade"));

                produtos.add(produto);
            }
            
            rs.close();
            pst.close();
        }

    } catch (SQLException ex) {
        Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Fecha a conexão
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return produtos;
    }

    
    public ArrayList<Produto> consultar(String str) {
        ArrayList<Produto> listaCadastrosStr = new ArrayList<Produto>();
        String sql = "SELECT c.idProduto, c.descricao, c.modelo, c.marca, c.cor, c.precoCompra, c.precoVenda, c.quantidade " +
                 "FROM produto AS c " +
                 "WHERE UPPER(c.marca) LIKE UPPER(?) " +  
                 "ORDER BY c.quantidade";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1, "%"+str+"%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while(resultadoSentenca.next()) 
                {
                    Produto prod = new Produto();
                    prod.setIdProduto(resultadoSentenca.getInt("idProduto"));
                    prod.setDescricao(resultadoSentenca.getString("descricao"));
                    prod.setModelo(resultadoSentenca.getString("modelo"));
                    prod.setMarca(resultadoSentenca.getString("marca"));
                    prod.setCor(resultadoSentenca.getString("cor"));
                    prod.setPrecoCompra(resultadoSentenca.getDouble("precoCompra"));
                    prod.setPrecoVenda(resultadoSentenca.getDouble("precoVenda"));


                prod.setEstoque(resultadoSentenca.getInt("quantidade"));
                                
                    listaCadastrosStr.add(prod);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastrosStr;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } 
    }
    
    
    
    public int consultarQuantidadeEstoque(int idProduto) {
        int quantidadeEmEstoque = 0;
        String sql = "SELECT quantidade FROM produto WHERE idProduto = ?";

        try (Connection conn = this.conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    quantidadeEmEstoque = rs.getInt("quantidade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidadeEmEstoque;
    }
    
    
    public boolean atualizarQuantidadeEstoque(int idProduto, int novaQuantidade) {
        boolean sucesso = false;
        String sql = "UPDATE produto SET quantidade = ? WHERE idProduto = ?";

        try {
            if(this.conexao.conectar()){
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 

            sentenca.setInt(1, novaQuantidade); // Define a nova quantidade de estoque
            sentenca.setInt(2, idProduto); // Define o ID do produto a ser atualizado
            
            int linhasAfetadas = sentenca.executeUpdate();
            if (linhasAfetadas > 0) {
                sucesso = true; // Se a atualização afetar pelo menos uma linha, o sucesso é verdadeiro
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    
    
    @Override
    public ArrayList<Produto> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Produto objt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    }
    
    

