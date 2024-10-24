
package modelo;

/**
 *
 * @author difoz
 */
public class Compra {
    private int idCompra;
    private String dataCompra;
    private int idUsuario;
    private int idFornecedor;
    private int idFormaPagamento;
    private int idCaixa;
    private int idRelatorio;

    public Compra() {
    }
    
    

    public Compra(String dataCompra, int idUsuario, int idFornecedor, int idFormaPagamento, int idCaixa, int idRelatorio) {
        this.dataCompra = dataCompra;
        this.idUsuario = idUsuario;
        this.idFornecedor = idFornecedor;
        this.idFormaPagamento = idFormaPagamento;
        this.idCaixa = idCaixa;
        this.idRelatorio = idRelatorio;
    }

    public Compra(int idCompra, String dataCompra, int idUsuario, int idFornecedor, int idFormaPagamento, int idCaixa, int idRelatorio) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
