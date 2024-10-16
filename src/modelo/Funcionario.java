package modelo;


public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String CPF;
    private String RG;
    private String tipoUsuario;

    public Funcionario(int idFuncionario, String nome, String CPF, String RG, String tipoUsuario) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}
