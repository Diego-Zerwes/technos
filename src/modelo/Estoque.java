
package modelo;


public class Estoque {
    private int idEstoque;
    private int idProduto;
    private int quantidade;
    private String dataEstoque;

    public Estoque() {
    }

    public Estoque(int quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque(int idEstoque, int idProduto, int quantidade) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataEstoque() {
        return dataEstoque;
    }

    public void setDataEstoque(String dataEstoque) {
        this.dataEstoque = dataEstoque;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }
    
    
    
}
