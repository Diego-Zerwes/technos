/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class ItemVenda {
    private int idVenda;
    private String idProduto;
    private String precoVenda;
    private int quantidade;

    public ItemVenda() {
    }

    public ItemVenda(int idVenda, String idProduto, String precoVenda, int quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }
    
    

    public ItemVenda(String idProduto, String precoVenda, int quantidade) {
        this.idProduto = idProduto;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    
}
