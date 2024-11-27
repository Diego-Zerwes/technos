
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
    public void inserirProduto(Produto produto) throws SQLException {
     Connection conn = null;

    try {
        // Obtendo a conexão
        conn = this.getConnection();
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Erro de conexão com o banco de dados.");
        }

        conn.setAutoCommit(false);  // Desabilitar auto-commit para controle manual da transação
        
        String sqlProduto = "INSERT INTO produto (descricao, modelo, marca, cor, precoCompra, precoVenda, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            psProduto.setInt(7, produto.getEstoque());

            // Definir idEstoque para o produto

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
    String sqlAlterarProduto = "UPDATE produto SET descricao = ?, modelo = ?, marca = ?, cor = ?, precoCompra = ?, precoVenda = ?, quantidade = ? WHERE idProduto = ?";

    try {
        if (this.conexao.conectar()) {
            
            if (rs.next()) {
               // int quantidade = rs.getInt("quantidade");
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
   String sql = "SELECT * FROM produtos";  // Exemplo de SQL para consultar todos os produtos
    ArrayList<Produto> produtos = new ArrayList<>();
    
    // Usando a conexão obtida da classe ConexaoBanco
    try {
        // Inicialize a variável conn usando o método getConnection da classe ConexaoBanco
        conn = this.conexao.getConnection();  // Usando a conexão que foi configurada

        if (conn != null) {
            // Prepare o statement com a conexão
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            // Iterando sobre o ResultSet e criando os objetos Produto
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produtos.add(produto);
            }
            
            rs.close();
            pst.close();
        }

    } catch (SQLException ex) {
        Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Aqui você pode garantir que a conexão seja fechada corretamente após o uso
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
                 "WHERE UPPER(c.marca) LIKE UPPER(?) " +  // Corrigido para `LIKE` com UPPER
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
                
                //prod.setEstoque(estoque);
                
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
    String sql = "SELECT p.idProduto, p.descricao, p.precoCompra, p.quantidade "
               + "FROM produto p "; // Usando LEFT JOIN para garantir todos os produtos

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
                prod.setEstoque(resultadoSentenca.getInt("quantidade")); // Armazena a quantidade correta
                //prod.setEstoque(estoque);

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
    
    
    public int consultarQuantidadePorId(int idProduto) throws SQLException {
    if (this.conn == null) {
        throw new SQLException("Conexão não estabelecida.");
    }
    
    String sql = "SELECT quantidade FROM estoque WHERE id_produto = ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, idProduto);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("quantidade");
            }
            return -1;  // Produto não encontrado
        }
    }
}
     public int consultarQuantidadeEstoque(int idProduto) {
        String sql = "SELECT quantidade FROM produto WHERE idProduto = ?";
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
    String sql = "UPDATE produto SET quantidade = ? WHERE idProduto = ?"; // Atualizando a quantidade do estoque

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
    

    }
    
    

