
package modelo;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpfCnpj;
    private String RgInscEst;

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cpfCnpj, String RgInscEst) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.RgInscEst = RgInscEst;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgInscEst() {
        return RgInscEst;
    }

    public void setRgInscEst(String RgInscEst) {
        this.RgInscEst = RgInscEst;
    }    
    
}
