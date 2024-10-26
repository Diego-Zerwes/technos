package modelo;

public class Compra {
    private int idCompra;
    private String dataCompra; // ainda será usado para armazenar a data da compra
    private int idFornecedor;
    private int idFormaPagamento;
    private int idCaixa;
    private int idRelatorio;

    public Compra() {
    }

    public Compra(int idCompra, String dataCompra, int idFornecedor, int idFormaPagamento, int idCaixa, int idRelatorio) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
        this.idFornecedor = idFornecedor;
        this.idFormaPagamento = idFormaPagamento;
        this.idCaixa = idCaixa;
        this.idRelatorio = idRelatorio;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

   
    
 
}
