/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import dao.ConexaoBanco;
import dao.DaoGenerica;

/**
 *
 * @author diegozerwesfeitosa
 */
public class Cadpf {
    private int idcliente;
    private String nome;
    private String CPF;
    private String RG;
    private String endereco;
    private String telefone;
    private String email;
    
    public Cadpf(){
    }

    public Cadpf(String nome, String CPF, String RG, String endereco, String telefone, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Cadpf(int idcliente, String nome, String CPF, String RG, String endereco, String telefone, String email) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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
