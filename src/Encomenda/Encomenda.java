package Encomenda;

import Artigos.Artigo;
import Artigos.Mala;
import Artigos.Sapatilha;
import Artigos.Tshirt;
import Transportadora.Transportadora;
import Utilizadores.Utilizador;
import Vintage.Vintage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Encomenda {
    private String codVendedor;
    private String codCliente; 
    private int estado; //0 -> pendente da compra; 1 -> entregue finalizado//
    private ArrayList<Artigo> artigos;
    private int dimensao;
    private LocalDate data_enc;
    private String nome_transportadora;

    /*
    Construtores
     */


    public Encomenda(String codVendedor, String codCliente, int estado, ArrayList<Artigo> artigos, int dimensao, String nome_transportadora) {
        this.codCliente = codCliente;
        this.codVendedor = codVendedor;
        this.estado = estado;
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.data_enc = LocalDate.now();
        this.nome_transportadora = nome_transportadora;
    }

    public Encomenda(String codVendedor, String codCliente, int estado, ArrayList<Artigo> artigos, int dimensao, LocalDate data_enc, String nome_transportadora) {
        this.codVendedor = codVendedor;
        this.codCliente = codCliente;
        this.estado = estado;
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.data_enc = data_enc;
        this.nome_transportadora = nome_transportadora;
    }

    /*
    Funções de manipulação
     */

    public double preco_encomenda(){
        double preco_total = 0;
        for (Artigo a: artigos) {
            if(a instanceof Mala){
                preco_total += ((Mala) a).getPrecoFinal();
            } else if (a instanceof Sapatilha) {
                preco_total += ((Sapatilha) a).getPrecoFinal();
            } else if (a instanceof Tshirt) {
                preco_total += ((Tshirt) a).getPrecoFinal();
            }
        }
        return preco_total;
    }

    public boolean remove_artigo(String cod){
        for(Artigo a: artigos){
            if(cod.equals(a.getCod())){
                return this.artigos.remove(a);
            }
        }
        return false;
    }


    /*
    Getters e Setters
     */

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }

    public LocalDate getData_enc() {
        return data_enc;
    }

    public void setData_enc(LocalDate data_enc) {
        this.data_enc = data_enc;
    }

    public String getNome_transportadora() {
        return nome_transportadora;
    }

    public void setNome_transportadora(String nome_transportadora) {
        this.nome_transportadora = nome_transportadora;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente= codCliente;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor= codVendedor;
    }

/*
    TOSTRING
*/

    public String toString() 
    {
        return "Estado da Encomenda: " +
                this.estado +
                ";Artigos da encomenda: " +
                this.artigos +
                ";Dimensão de encomenda: " +
                this.dimensao +
                ";Data da encomenda: " +
                this.data_enc +
                ";Nome da transportadora: " +
                this.nome_transportadora +
                ";Preço final: " +
                this.preco_encomenda();
    }

/* 
    OUTROS MÉTODOS
*/
}