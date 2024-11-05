package dao;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import dao.ConexaoBanco;

public class RelatoriosDAO {
   ConexaoBanco conexao = null;
    Connection conn = null;

    public RelatoriosDAO() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    
    

    public DefaultTableModel buscarCompras(String dataInicio, String dataFim) {
        String sql = "SELECT * FROM Compras WHERE dataCompra BETWEEN ? AND ?";
        return buscarDados(sql, dataInicio, dataFim);
    }

    public DefaultTableModel buscarVendas(String dataInicio, String dataFim) {
        String sql = "SELECT * FROM Vendas WHERE dataVenda BETWEEN ? AND ?";
        return buscarDados(sql, dataInicio, dataFim);
    }

    public DefaultTableModel buscarFornecedores(String dataInicio, String dataFim) {
        String sql = "SELECT * FROM Fornecedores WHERE dataFornecimento BETWEEN ? AND ?";
        return buscarDados(sql, dataInicio, dataFim);
    }

    public DefaultTableModel buscarEstoque(String dataInicio, String dataFim) {
        String sql = "SELECT * FROM Estoque WHERE dataEstoque BETWEEN ? AND ?";
        return buscarDados(sql, dataInicio, dataFim);
    }

    private DefaultTableModel buscarDados(String sql, String dataInicio, String dataFim) {
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, dataInicio); // Define a data inicial como String
            pst.setString(2, dataFim); // Define a data final como String
            try (ResultSet rs = pst.executeQuery()) {
                return (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados: " + e.getMessage());
            return new DefaultTableModel();
        }
    }
}
