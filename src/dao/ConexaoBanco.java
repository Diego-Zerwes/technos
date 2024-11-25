
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Objeto
public class ConexaoBanco {   
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao; 
//Construtor
    public ConexaoBanco() {
        this.servidor = "200.195.171.124";
        this.banco = "grupo07_Vendas_Celular";
        this.usuario = "grupo07";
        this.senha = "Vu9EIaowZuJ3mBsP";
    }
    public boolean conectar(){
        try
        {
            System.out.println("Tentando conectar ao banco...");
            this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco,this.usuario,this.senha);
            System.out.println("Conexão bem-sucedida!");
            return true;
        }
        catch(SQLException ex){
             System.out.println("Erro ao conectar: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
    public Connection getConnection() {
        try {
        System.out.println("Tentando conectar ao banco...");
        this.conexao = DriverManager.getConnection(
            "jdbc:mysql://200.195.171.124:3306/grupo07_Vendas_Celular?useSSL=false&serverTimezone=UTC",
            "grupo07", 
            "Vu9EIaowZuJ3mBsP"
        );
        if (this.conexao != null) {
            System.out.println("Conexão estabelecida com o banco.");
        }
        return this.conexao;
    } catch (SQLException ex) {
        System.out.println("Erro ao conectar: " + ex.getMessage());
        return null;
    }
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void fecharConexao() {
       try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();  // Fecha a conexão com o banco
            }
        } catch (SQLException e) {
            // Se ocorrer um erro ao fechar a conexão, você pode exibir um erro ou log
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
    
   
    
}
