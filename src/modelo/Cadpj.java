/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import dao.ConexaoBanco;
import dao.DaoGenerica;

/**
 *
 * @author scream
 */
public class Cadpj {
    private int idclientepj;
    private String nomefantasia;
    private String razaosocial;
    private String CNPJ;
    private String IE;
    private String endereco;
    private String telefone;
    private String email;

    public Cadpj() {
    }

    public Cadpj(String nomefantasia, String razaosocial, String CNPJ, String IE, String endereco, String telefone, String email) {
        this.nomefantasia = nomefantasia;
        this.razaosocial = razaosocial;
        this.CNPJ = CNPJ;
        this.IE = IE;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Cadpj(int idclientepj, String nomefantasia, String razaosocial, String CNPJ, String IE, String endereco, String telefone, String email) {
        this.idclientepj = idclientepj;
        this.nomefantasia = nomefantasia;
        this.razaosocial = razaosocial;
        this.CNPJ = CNPJ;
        this.IE = IE;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdclientepj() {
        return idclientepj;
    }

    public void setIdclientepj(int idclientepj) {
        this.idclientepj = idclientepj;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}
