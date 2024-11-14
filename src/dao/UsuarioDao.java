package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class UsuarioDao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public UsuarioDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }

    public boolean verificarCredencial(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE nome=? AND senha=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSenha());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Credencial verificada com sucesso!");
                return true;
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
        }
        return false;
    }

}
