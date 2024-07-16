package Utilizadores;
import Artigos.Artigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Utilizador comprador;
    private Utilizador vendedor;
    private Artigo artigo;
    private double valor;
    private Date data;

    //--------------------------------------------------------------Construtores--------------------------------------------------------------------------\\

    public Venda(Utilizador comprador, Utilizador vendedor, Artigo artigo, double valor, Date data) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.artigo = artigo;
        this.valor = valor;
        this.data = data;
    }

    //--------------------------------------------------------------Getters e Setters--------------------------------------------------------------------------\\

    public Utilizador getComprador() {
        return comprador;
    }

    public Utilizador getVendedor() {
        return vendedor;
    }

    public double getValor() {
        return valor;
    }

    public Date getData(){return data;}

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public void setComprador(Utilizador comprador) {
        this.comprador = comprador;
    }

    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(Date data){this.data = data;}

    //--------------------------------------------------------------Outros métodos--------------------------------------------------------------------------\\

    public static List<Venda> separarVendas(List<Venda> vendas, Utilizador vendedor) {
        List<Venda> vendasDoVendedor = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getVendedor().equals(vendedor)) {
                vendasDoVendedor.add(venda);
            }
        }
        return vendasDoVendedor;
    }
}