
package modelo;

public class Fornecedor {
    private int idFornecedor;
    private String razaoSocial;
    private String cnpj;
    private String iE;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String razaoSocial, String cnpj, String iE) {
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.iE = iE;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getiE() {
        return iE;
    }

    public void setiE(String iE) {
        this.iE = iE;
    }    
    
}
