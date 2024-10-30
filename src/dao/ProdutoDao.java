
package dao;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import modelo.Produto;
import modelo.Estoque;
import modelo.Fornecedor;

/**
 *
 * @author difoz
 */
public class ProdutoDao implements DaoGenerica<Produto>{
    public ConexaoBanco conexao;
    
    public ProdutoDao()
    {
        this.conexao = new ConexaoBanco();
    }
    @Override
    public void inserir(Produto produto) {
        String sqlProduto = "INSERT INTO produto (descricao, modelo, marca, cor, precoCompra, precoVenda) VALUES (?, ?, ?, ?, ?, ?)";
    String sqlEstoque = "INSERT INTO estoque (idProduto, quantidade) VALUES (?, ?)";

    try {
        if (this.conexao.conectar()) {
            try (PreparedStatement stmtProduto = this.conexao.getConnection().prepareStatement(sqlProduto)) {
                stmtProduto.setString(1, produto.getDescricao());
                stmtProduto.setString(2, produto.getModelo());
                stmtProduto.setString(3, produto.getMarca());
                stmtProduto.setString(4, produto.getCor());
                stmtProduto.setDouble(5, produto.getPrecoCompra());
                stmtProduto.setDouble(6, produto.getPrecoVenda());

                stmtProduto.executeUpdate();
                System.out.println("Produto inserido com sucesso.");

                int novoIdProduto = 0;
                String sqlLastId = "SELECT LAST_INSERT_ID()"; // Para MySQL
                try (PreparedStatement stmtLastId = this.conexao.getConnection().prepareStatement(sqlLastId);
                     ResultSet rs = stmtLastId.executeQuery()) {
                    if (rs.next()) {
                        novoIdProduto = rs.getInt(1);
                        System.out.println("ID do Produto Gerado: " + novoIdProduto);
                    }
                }

                try (PreparedStatement stmtEstoque = this.conexao.getConnection().prepareStatement(sqlEstoque)) {
                    stmtEstoque.setInt(1, novoIdProduto); // Usando o novo idProduto
                    stmtEstoque.setInt(2, produto.getEstoque().getQuantidade()); // Defina a quantidade
                    
                    System.out.println("Quantidade a ser inserida no estoque: " + produto.getEstoque().getQuantidade());
                    
                    stmtEstoque.executeUpdate();
                    System.out.println("Quantidade inserida com sucesso na tabela estoque.");
                }
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Exibe a stack trace para facilitar a depuração
        throw new RuntimeException("Erro ao inserir produto: " + ex.getMessage());
    }
    }

    @Override
    public void alterar(Produto produto) {
     String sqlEstoque = "SELECT quantidade FROM estoque WHERE idProduto = ?";
    String sqlAlterarProduto = "UPDATE produto SET descricao = ?, modelo = ?, marca = ?, cor = ?, precoCompra = ?, precoVenda = ? WHERE idProduto = ?";

    try {
        if (this.conexao.conectar()) {
            PreparedStatement stmtEstoque = this.conexao.getConnection().prepareStatement(sqlEstoque);
            stmtEstoque.setInt(1, produto.getIdProduto());

            ResultSet rs = stmtEstoque.executeQuery();
            
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                System.out.println("Quantidade em estoque para idProduto " + produto.getIdProduto() + ": " + quantidade);
                
                PreparedStatement stmtAlterarProduto = this.conexao.getConnection().prepareStatement(sqlAlterarProduto);

                stmtAlterarProduto.setString(1, produto.getDescricao());
                stmtAlterarProduto.setString(2, produto.getModelo());
                stmtAlterarProduto.setString(3, produto.getMarca());
                stmtAlterarProduto.setString(4, produto.getCor());
                stmtAlterarProduto.setDouble(5, produto.getPrecoCompra());
                stmtAlterarProduto.setDouble(6, produto.getPrecoVenda());
                stmtAlterarProduto.setInt(7, produto.getIdProduto());

                stmtAlterarProduto.executeUpdate();
                stmtAlterarProduto.close();
            } else {
                System.out.println("Produto com idProduto " + produto.getIdProduto() + " não encontrado no estoque.");
            }

            rs.close();
            stmtEstoque.close();
            this.conexao.getConnection().close();
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
    String sql = "SELECT p.idProduto, p.descricao, p.modelo, p.marca, p.cor, "
               + "p.precoCompra, p.precoVenda, e.quantidade "
               + "FROM produto p "
               + "INNER JOIN estoque e ON p.idProduto = e.idProduto"; 

    
    ArrayList<Produto> listaProdutos = new ArrayList<>();

    try (Connection conn = this.conexao.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idProduto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setModelo(rs.getString("modelo"));
            produto.setMarca(rs.getString("marca"));
            produto.setCor(rs.getString("cor"));
            produto.setPrecoCompra(rs.getDouble("precoCompra"));
            produto.setPrecoVenda(rs.getDouble("precoVenda"));

            Estoque estoque = new Estoque();
            estoque.setQuantidade(rs.getInt("quantidade"));
            produto.setEstoque(estoque);  // Associação do estoque ao produto          

            listaProdutos.add(produto);
        }
    } catch (SQLException ex) {
        System.err.println("Erro ao consultar produtos: " + ex.getMessage());
        ex.printStackTrace(); 
    }

    return listaProdutos;
}
    
    public ArrayList<Produto> consultar(String str) {
        ArrayList<Produto> listaCadastrosStr = new ArrayList<Produto>();
        String sql = "SELECT c.idProduto, c.descricao, c.modelo, c.marca, c.cor, c.precoCompra, c.precoVenda, s.quantidade " +
                 "FROM produto AS c " +
                 "JOIN estoque AS s ON c.idProduto = s.idProduto " + // INNER JOIN com a tabela estoque
                 "WHERE UPPER(c.marca) LIKE UPPER(?) " +  // Corrigido para `LIKE` com UPPER
                 "ORDER BY s.quantidade";
        
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

                    Estoque estoque = new Estoque();
                estoque.setQuantidade(resultadoSentenca.getInt("quantidade"));
                
                prod.setEstoque(estoque);
                
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

    @Override
    public ArrayList<Produto> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
