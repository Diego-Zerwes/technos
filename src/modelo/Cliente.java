
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente {
    private int idCliente;
    private String nomeRazaoSocial;
    private String cpfCnpj;
    private String RgInscEst;
    private String sexo;
    private String tipoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeRazaoSocial, String cpfCnpj, String RgInscEst, String sexo, String tipoCliente) {
        this.idCliente = idCliente;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.cpfCnpj = cpfCnpj;
        this.RgInscEst = RgInscEst;
        this.sexo = sexo;
        this.tipoCliente = tipoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

   

    
   
}
