package Vintage;

import Artigos.Mala;
import Artigos.Sapatilha;
import Artigos.Tshirt;
import Encomenda.Encomenda;
import Transportadora.Transportadora;
import Utilizadores.Utilizador;

import java.time.LocalDate;
import java.util.ArrayList;

import Artigos.Artigo;

public class Vintage {
    ArrayList<Utilizador> users;
    ArrayList<Transportadora> transportadoras;
    ArrayList<Encomenda> encomendas;
    ArrayList<Artigo> artigos;
    int usersNum;
    int transNum;
    int encNum;
    int artNum;

    public Vintage() {
        this.users = new ArrayList<>();
        this.encomendas = new ArrayList<>();
        this.transportadoras = new ArrayList<>();
        this.artigos = new ArrayList<>();
        this.usersNum = 0;
        this.transNum = 0;
        this.encNum = 0;
        this.artNum = 0;

    }

    public String login(String email, String password){
        String cod;
        for(Utilizador u: users){
            cod = u.verificarUtilizador(email,password);
            if(cod != null) return cod;
        }
        return null;
    }

    public void add_user(String linha)
    {
        String[] elementos = linha.split(";");

        String codigo = elementos[0];
        String email = elementos[1];
        String password = elementos[2];
        String nome = elementos[3];
        String morada = elementos[4];
        String numFiscal = elementos[5];

        String cod = codigo.substring(1);
        usersNum = Integer.parseInt(cod);

        Utilizador user = new Utilizador(codigo, email, password, nome, morada, numFiscal);
        users.add(user);
    }

    public String create_user(String email, String password, String nome, String morada, String numFiscal){

        String formato = "U%06d";
        String codFormatado = String.format(formato, usersNum);

        Utilizador user = new Utilizador(codFormatado, email, password, nome, morada, numFiscal);
        users.add(user);
        return codFormatado;
    }

    public void add_transportadora(String linha)
    {
        String[] elementos = linha.split(";");

        String nome = elementos[0];
        double valorBasePequeno = Double.parseDouble(elementos[1]);
        double valorBaseMedio = Double.parseDouble(elementos[2]);
        double valorBaseGrande = Double.parseDouble(elementos[3]);
        double impostoMultiplicador = Double.parseDouble(elementos[4]);
        boolean isEspecializada = Boolean.parseBoolean(elementos[5]);
        boolean isEspecializadaPremium = Boolean.parseBoolean(elementos[6]);

        Transportadora transporte = new Transportadora(nome, valorBasePequeno, valorBaseMedio, valorBaseGrande, impostoMultiplicador, isEspecializada, isEspecializadaPremium);
        transportadoras.add(transporte);
    }

    public Artigo create_artigo(boolean usado, double estado, int donos, String descricao, String marca, double preco, int desconto, boolean isPremium, String type){
        String formato;
        switch (type){
            case "1"-> formato = "M%06d";
            case "2"-> formato = "S%06d";
            default-> formato = "T%06d";

        }
        String codFormatado = String.format(formato, artNum);
        return new Artigo(codFormatado,usado, estado, donos, descricao, marca, preco, desconto, isPremium);
    }


    public void add_mala(String linha)
    {
        String[] elementos = linha.split(";");

        String cod = elementos[0];
        String cod_user = elementos[1];
        boolean usado = Boolean.parseBoolean(elementos[2]);
        double estado = Double.parseDouble(elementos[3]);
        int donos = Integer.parseInt(elementos[4]);
        String descricao = elementos[5];
        String marca = elementos[6];
        int ano = Integer.parseInt(elementos[7]);
        int dimensao = Integer.parseInt(elementos[8]);
        double material = Double.parseDouble(elementos[9]);
        LocalDate lancamento = LocalDate.parse(elementos[10]);

        double preco = Double.parseDouble(elementos[11]);
        int desconto = Integer.parseInt(elementos[12]);
        boolean isPremium = Boolean.parseBoolean(elementos[13]);
        int estadoc = Integer.parseInt(elementos[14]);

        //0 -> lista de comprados; 1 -> lista de Vendidos; 2 -> lista para Venda//

        Artigo artigo = new Artigo(cod, usado, estado, donos, descricao, marca, preco, desconto, isPremium);
        Mala mala = new Mala(artigo,ano,dimensao,material,lancamento);
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())){
                if(estadoc == 0){
                    u.addComprados(mala);
                } else if (estadoc == 1) {
                    u.addVendidos(mala);
                } else if (estadoc == 2) {
                    u.addParaVenda(mala);
                    artigos.add(mala);
                }
            }
        }

        artNum++;
    }

    public void create_mala(Artigo artigo,String ano, String dimensao, String material, String lancamento, String cod_user)
    {
        Mala mala = new Mala(artigo,Integer.parseInt(ano),Integer.parseInt(dimensao),Double.parseDouble(material),LocalDate.parse(lancamento));
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())) {
                u.addParaVenda(mala);
            }
        }
        artNum++;

    }

    public void add_sapatilha(String linha)
    {
        String[] elementos = linha.split(";");

        String cod = elementos[0];
        String cod_user = elementos[1];
        boolean usado = Boolean.parseBoolean(elementos[2]);
        double estado = Double.parseDouble(elementos[3]);
        int donos = Integer.parseInt(elementos[4]);
        String descricao = elementos[5];
        String marca = elementos[6];
        int tamanho = Integer.parseInt(elementos[7]);
        boolean atacadores = Boolean.parseBoolean(elementos[8]);
        String cor = elementos[9];
        LocalDate lancamento = LocalDate.parse(elementos[10]);

        double preco = Double.parseDouble(elementos[11]);
        int desconto = Integer.parseInt(elementos[12]);
        boolean isPremium = Boolean.parseBoolean(elementos[13]);
        int estadoc = Integer.parseInt(elementos[14]);

        //0 -> lista de comprados; 1 -> lista de Vendidos; 2 -> lista para Venda//

        Artigo artigo = new Artigo(cod, usado, estado, donos, descricao, marca, preco, desconto, isPremium);
        Sapatilha sapatilha = new Sapatilha(artigo,tamanho,atacadores,cor,lancamento);
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())){
                if(estadoc == 0){
                    u.addComprados(sapatilha);
                } else if (estadoc == 1) {
                    u.addVendidos(sapatilha);
                } else if (estadoc == 2) {
                    u.addParaVenda(sapatilha);
                    artigos.add(sapatilha);
                }
            }
        }
        artNum++;
    }

    public void create_sapatilha(Artigo artigo, String tamanho, String atacadores, String cor, String lancamentoS, String cod_user)
    {
        Sapatilha sapatilha = new Sapatilha(artigo,Integer.parseInt(tamanho),Boolean.parseBoolean(atacadores),cor,LocalDate.parse(lancamentoS));
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())) {
                u.addParaVenda(sapatilha);
            }
        }
        artNum++;

    }

    public void add_tshirt(String linha)
    {
        String[] elementos = linha.split(";");

        String cod_user = elementos[0];
        String cod = elementos[1];
        boolean usado = Boolean.parseBoolean(elementos[2]);
        double estado = Double.parseDouble(elementos[3]);
        int donos = Integer.parseInt(elementos[4]);
        String descricao = elementos[5];
        String marca = elementos[6];
        String tamanho = elementos[7];
        String padrao = elementos[8];
        double preco = Double.parseDouble(elementos[9]);
        int desconto = Integer.parseInt(elementos[10]);
        boolean isPremium = Boolean.parseBoolean(elementos[11]);
        int estadoc = Integer.parseInt(elementos[12]);

        //0 -> lista de comprados; 1 -> lista de Vendidos; 2 -> lista para Venda//

        Artigo artigo = new Artigo(cod, usado, estado, donos, descricao, marca, preco, desconto, isPremium);
        Tshirt tshirt = new Tshirt(artigo,tamanho,padrao);
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())){
                if(estadoc == 0){
                    u.addComprados(tshirt);
                } else if (estadoc == 1) {
                    u.addVendidos(tshirt);
                } else if (estadoc == 2) {
                    u.addParaVenda(tshirt);
                    artigos.add(tshirt);
                }
            }
        }
        artNum++;
    }

    public void create_tshirt(Artigo artigo, String tamanho, String padrao, String cod_user)
    {
        Tshirt tshirt = new Tshirt(artigo,tamanho,padrao);
        for(Utilizador u: users){
            if(cod_user.equals(u.getCodigo())) {
                u.addParaVenda(tshirt);
            }
        }
        artNum++;
    }

    public void add_encomenda(String linha)
    {
        String[] elementos = linha.split(";");
        
        String codVendedor = elementos[0];
        String codCliente = elementos[1];
        int estado = Integer.parseInt(elementos[2]);
        int dimensao = Integer.parseInt(elementos[3]);
        LocalDate data_enc = LocalDate.parse(elementos[4]);
        String nome_transportadora = elementos[5];
        ArrayList<Artigo> artigos = new ArrayList<>();

        Encomenda enc = new Encomenda(codVendedor, codCliente, estado, artigos, dimensao, data_enc, nome_transportadora);
        encomendas.add(enc);
    }

    public String transpMaisFaturou()
    {
        double totalTransportadora = 0;
        double maiorValor = 0;
        Transportadora transportadora = null;
        int quantidadeArtigos = 0;



        for (Transportadora t : this.transportadoras)
        {
            for(Encomenda e : this.encomendas){
                if(e.getNome_transportadora().equals(t.getNome())) quantidadeArtigos++;
            }
            totalTransportadora = t.calcularPrecoExpedicaoTransportadora(quantidadeArtigos, t.isEspecializadaPremium());
            if(totalTransportadora > maiorValor)
            {
                maiorValor = totalTransportadora;
                transportadora = t;
            }
            quantidadeArtigos = 0;
        }

        return transportadora.getNome();
    }

    public double profitVintage(){
        double profit = 0;
        for(Encomenda e:this.encomendas){
            profit += e.preco_encomenda()*0.05;
        }
        return profit;
    }

    public Utilizador vendedorMaisFaturou()
    {
        double totalVendedor = 0;
        double maiorValor = 0;
        Utilizador vendedor = null;
        
        for (Utilizador u : getUsers())
        {
            for (Artigo a : artigos)
            {
                totalVendedor += a.getPreco();
            }
            
            if(totalVendedor > maiorValor)
            {
                maiorValor = totalVendedor;
                vendedor = u;
            } 
        }

        return vendedor;
    }

    public ArrayList<Encomenda> encomendasUser(String codVendedor)
    {
        ArrayList<Encomenda> encomendasUser = new ArrayList<>();

        for (Encomenda a : getEncomendas())
        {
            for (Utilizador u : getUsers())
            {
                if (u.getCodigo().equals(codVendedor))
                {
                    encomendasUser.add(a);
                }
            }
        }
        return encomendasUser;
    }

    public Encomenda createEncomenda(String codVendedor, String codCliente, ArrayList<Artigo> artigos, String nome_transportadora){

        Encomenda e = new Encomenda(codVendedor, codCliente, 0, artigos, artigos.size(), nome_transportadora);
        encomendas.add(e);

        return e;
    }

    public ArrayList<Utilizador> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Utilizador> users) {
        this.users = users;
    }

    public ArrayList<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(ArrayList<Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }



/*
    EQUALS, CLONE,TOSTRING
*/

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Vintage: \n");
        sb.append("Lista de Utilizadores: \n");
        for(Utilizador u: this.users){
            sb.append(u.getNome());
            sb.append(";");
            sb.append(u.getCodigo());
            sb.append("\n");
        }
        return sb.toString();
    }
}