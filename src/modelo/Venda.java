/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author difoz
 */
public class Venda {
       private int idVenda;
       private int idCliente;
       private int idFormaPagamento;
       private int idTipoVenda;
       private int idRelatorio;
       private int idUsuario;
       private String dataVenda;

    public Venda() {
    }

    public Venda(int idVenda, int idCliente, int idFormaPagamento, int idTipoVenda, int idRelatorio, int idUsuario, String dataVenda) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idFormaPagamento = idFormaPagamento;
        this.idTipoVenda = idTipoVenda;
        this.idRelatorio = idRelatorio;
        this.idUsuario = idUsuario;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdTipoVenda() {
        return idTipoVenda;
    }

    public void setIdTipoVenda(int idTipoVenda) {
        this.idTipoVenda = idTipoVenda;
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
       
       
}
