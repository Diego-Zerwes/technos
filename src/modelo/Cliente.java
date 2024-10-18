
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpfCnpj;
    private String RgInscEst;
    private String sexo;
    private String tipoUsuario;

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cpfCnpj, String RgInscEst, String sexo, String tipoUsuario) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.RgInscEst = RgInscEst;
        this.sexo = sexo;
        this.tipoUsuario = tipoUsuario;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }    
   
}
