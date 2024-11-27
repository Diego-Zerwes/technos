
package modelo;

public class Produto {
    private int idProduto;
    private String descricao;
    private int estoque;
    private String modelo;
    private String marca;
    private String Cor;
    private Double precoCompra;
    private Double precoVenda;
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(String descricao, String modelo, int estoque, String marca, String Cor, Double precoCompra, Double precoVenda) {
        this.descricao = descricao;
        this.modelo = modelo;
        this.marca = marca;
        this.Cor = Cor;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public Produto(int idProduto, String descricao, String modelo, int estoque, String marca, String Cor, Double precoCompra, Double precoVenda) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.modelo = modelo;
        this.marca = marca;
        this.Cor = Cor;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    
}
