
package modelo;


public class FormaDePagamento {
    private int idFormaPagamento;
    private String descricao;

    public FormaDePagamento() {
    }

    public FormaDePagamento(String descricao) {
        this.descricao = descricao;
    }

    public FormaDePagamento(int idFormaPagamento, String descricao) {
        this.idFormaPagamento = idFormaPagamento;
        this.descricao = descricao;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "FormaDePagamento{" + "descricao=" + descricao + '}';
        //return descricao;
    }  
    
}
