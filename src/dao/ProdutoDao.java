
package dao;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
        this.conexao = new ConexaoBanco(); // Instancia a classe de conexão
    }

    // Método para conectar ao banco
    public boolean conectar() {
        return this.conexao.conectar(); // Usa o método conectar da classe ConexaoBanco
    }
    

    public Connection getConnection() {
        return conexao.getConnection();  // Retorna a conexão
    }

    // Método para fechar a conexão
    public void fecharConexao() {
        this.conexao.fecharConexao(); // Usa o método fecharConexao da classe ConexaoBanco
    }
    public void inserirProduto(Produto produto, Estoque estoque) throws SQLException {
     Connection conn = null;

    try {
        // Obtendo a conexão
        conn = this.getConnection();
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Erro de conexão com o banco de dados.");
        }

        conn.setAutoCommit(false);  // Desabilitar auto-commit para controle manual da transação

        // 1. Inserir o estoque
        String sqlEstoque = "INSERT INTO estoque (quantidade, dataEstoque) VALUES (?, ?)";
        try (PreparedStatement psEstoque = conn.prepareStatement(sqlEstoque, PreparedStatement.RETURN_GENERATED_KEYS)) {
            psEstoque.setInt(1, estoque.getQuantidade());
            psEstoque.setString(2, estoque.getDataEstoque());

            int rowsAffectedEstoque = psEstoque.executeUpdate();
            if (rowsAffectedEstoque == 0) {
                throw new SQLException("Nenhuma linha foi inserida na tabela estoque.");
            }

            // Recuperar o ID gerado para o estoque
            try (ResultSet rs = psEstoque.getGeneratedKeys()) {
                if (rs.next()) {
                    int idEstoque = rs.getInt(1);
                    estoque.setIdEstoque(idEstoque);  // Atribuir o idEstoque gerado ao objeto Estoque
                    System.out.println("ID do estoque gerado: " + idEstoque);
                } else {
                    throw new SQLException("Erro ao obter o ID do estoque.");
                }
            }
        }

        // 2. Inserir o produto com o idEstoque já atribuído
        String sqlProduto = "INSERT INTO produto (descricao, modelo, marca, cor, precoCompra, precoVenda, idEstoque) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement psProduto = conn.prepareStatement(sqlProduto, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Verificações de dados obrigatórios
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

            // Verificação de preço de compra e venda
            if (produto.getPrecoCompra() == null || produto.getPrecoCompra() <= 0) {
                throw new SQLException("Preço de compra inválido.");
            }
            psProduto.setDouble(5, produto.getPrecoCompra());

            if (produto.getPrecoVenda() == null || produto.getPrecoVenda() <= 0) {
                throw new SQLException("Preço de venda inválido.");
            }
            psProduto.setDouble(6, produto.getPrecoVenda());

            // Definir idEstoque para o produto
            psProduto.setInt(7, estoque.getIdEstoque());

            // Executar a inserção do produto
            int rowsAffectedProduto = psProduto.executeUpdate();
            if (rowsAffectedProduto == 0) {
                throw new SQLException("Nenhuma linha foi inserida na tabela produto.");
            }

            // Recuperar o ID gerado para o produto
            try (ResultSet rs = psProduto.getGeneratedKeys()) {
                if (rs.next()) {
                    int idProduto = rs.getInt(1);
                    produto.setIdProduto(idProduto);  // Atualiza o objeto Produto com o ID gerado
                    System.out.println("Produto inserido com sucesso, ID gerado: " + idProduto);
                } else {
                    throw new SQLException("Erro ao recuperar o ID do produto inserido.");
                }
            }
        }

        // Commit da transação se tudo ocorrer bem
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
        throw ex;  // Relança a exceção para o método chamador
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.setAutoCommit(true);  // Reativa o auto-commit
                conn.close();  // Fecha a conexão
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    
    public ArrayList<Produto> consultarProduto() {
         ArrayList<Produto> listaCadastros = new ArrayList<>();
    String sql = "SELECT p.idProduto, p.descricao, p.precoCompra, e.quantidade "
               + "FROM produto p "
               + "LEFT JOIN estoque e ON p.idProduto = e.idProduto"; // Usando LEFT JOIN para garantir todos os produtos

    try {
        if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultadoSentenca = sentenca.executeQuery();

            while(resultadoSentenca.next()) {
                Produto prod = new Produto();
                prod.setIdProduto(resultadoSentenca.getInt("idProduto"));
                prod.setDescricao(resultadoSentenca.getString("descricao"));
                prod.setPrecoVenda(resultadoSentenca.getDouble("precoCompra"));

                // Verifique se a quantidade foi retornada corretamente
                int quantidadeEstoque = resultadoSentenca.getInt("quantidade");
                Estoque estoque = new Estoque();
                estoque.setQuantidade(quantidadeEstoque); // Armazena a quantidade correta
                prod.setEstoque(estoque);

                listaCadastros.add(prod);
            }
        }
        return listaCadastros;
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao consultar produtos: " + ex.getMessage(), ex);
    }
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
