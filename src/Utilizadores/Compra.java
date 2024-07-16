package Utilizadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private Utilizador comprador;
    private Utilizador vendedor;
    private double valor;
    private Date data;

    //--------------------------------------------------------------Construtores--------------------------------------------------------------------------\\

    public Compra(Utilizador comprador, Utilizador vendedor, double valor, Date data) {
        this.comprador = comprador;
        this.vendedor = vendedor;
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

    public static List<Compra> separarCompras(List<Compra> compras, Utilizador comprador) {
        List<Compra> comprasDoComprador = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getComprador().equals(comprador)) {
                comprasDoComprador.add(compra);
            }
        }
        return comprasDoComprador;
    }
}