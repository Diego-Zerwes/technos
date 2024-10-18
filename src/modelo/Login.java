
package modelo;


public class Login {
    private String senha;
    private int idFuncionario;
    private int idLogin;

    public Login(String senha, int idFuncionario, int idLogin) {
        this.senha = senha;
        this.idFuncionario = idFuncionario;
        this.idLogin = idLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    @Override
    public String toString() {
        return "Login{" + "senha=" + senha + ", idFuncionario=" + idFuncionario + ", idLogin=" + idLogin + '}';
    }    
    
}
