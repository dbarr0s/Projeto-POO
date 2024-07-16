package Utilizadores;
import Transportadora.Transportadora;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Artigos.Artigo;
import Encomenda.Encomenda;
import Vintage.Vintage;

public class Utilizador
{
    private final String codigo;                    //código dado pelo sistema para cada utilizador//
    private final String email;                     //email do utilizador para o login//
    private final String password;                  //password do utilizador//
    private final String nome;                      //nome do user//
    private final String morada;                    //morada do user//
    private final String numFiscal;                 //Nº fiscal do user//
    private ArrayList<Artigo>artParaVenda;    //Lista de artigos para a venda com o seu preço//
    private ArrayList<Artigo>artVendidos;     //Lista de artigos vendidos com o seu preço//
    private ArrayList<Artigo>artComprados;    //Lista de artigos comprados com o seu preço//

/* 
    CONSTRUTORES
*/

    public Utilizador(String codigo, String email, String password, String nome, String morada, String numFiscal, ArrayList<Artigo>artParaVenda, ArrayList<Artigo>artVendidos, ArrayList<Artigo>artComprados)
    {
        this.codigo = codigo;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        this.artParaVenda = artParaVenda;
        this.artVendidos = artVendidos;
        this.artComprados = artComprados;
    }

    public Utilizador(Utilizador u)
    {
        this.codigo = u.getCodigo();
        this.email = u.getEmail();
        this.password = u.getPass();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numFiscal = u.getNumFiscal();
        this.artParaVenda = u.getArtParaVenda();
        this.artVendidos = u.getArtVendidos();
        this.artComprados = u.getArtComprados();
    }

    public Utilizador(String codigo, String email, String password, String nome, String morada, String numFiscal) {
        this.codigo = codigo;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        this.artParaVenda = new ArrayList<>();
        this.artVendidos = new ArrayList<>();
        this.artComprados = new ArrayList<>();
    }

    /*
    GETTERS E SETTERS
*/

    public ArrayList<Artigo> getArtParaVenda() 
    {
        return this.artParaVenda;
    }


    public ArrayList<Artigo> getArtVendidos() 
    {
        return this.artVendidos;
    }


    public ArrayList<Artigo> getArtComprados() 
    {
        return this.artComprados;
    }


    public String getCodigo()
    {
        return this.codigo;
    }


    public String getEmail()
    {
        return this.email;
    }


    public String getPass()
    {
        return this.password;
    }


    public String getNome()
    {
        return this.nome;
    }


    public String getMorada()
    {
        return this.morada;
    }


    public String getNumFiscal()
    {
        return this.numFiscal;
    }


/*
    EQUALS, CLONE,TOSTRING
*/

    public void printProdutos(){
        System.out.println("----------------------------------------------------");
        System.out.println("|Artigos para Venda                                |");

        for (Artigo a: this.artParaVenda) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------------------");
        System.out.println("|Artigos Vendidos                                  |");
        for (Artigo a: this.artVendidos) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------------------");
        System.out.println("|Artigos Comprados                                 |");
        for (Artigo a: this.artComprados) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------------------");

    }

    public void printAvenda(){
        System.out.println("----------------------------------------------------");
        System.out.println(codigo);

        for (Artigo a: this.artParaVenda) {
            System.out.println(a);
        }
        System.out.println("----------------------------------------------------");

    }

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador: \n");
        sb.append("Email do login: \n");
        sb.append(this.email);
        sb.append("Password do utilizador: \n");
        sb.append(this.password);
        sb.append("Código do utilizador: \n");
        sb.append(this.codigo);
        sb.append("Nome do utilizador: \n");
        sb.append(this.nome);
        sb.append("Morada do utilizador: \n");
        sb.append(this.morada);
        sb.append("Nº Fiscal do utilizador: \n");
        sb.append(this.numFiscal);
        sb.append("Artigos para venda do utilizador: \n");
        sb.append(this.artParaVenda);
        sb.append("Artigos vendidos pelo utilizador: \n");
        sb.append(this.artVendidos);
        sb.append("Artigos comprados pelo utilizador: \n");
        sb.append(this.artComprados);
        return sb.toString();
    }

/*
 * MÉTODOS NECESSÁRIOS
*/
    public Artigo procuraArtigo(String cod){
        for(Artigo a : this.artParaVenda){
            if (a.getCod().equals(cod)) return a;
        }
        return null;
    }

    public String verificarUtilizador(String email, String pass)
    {
        if (this.email.equals(email) && this.password.equals(pass))
        {
            return this.codigo;
        }
        return null;
    }

    public void addParaVenda(Artigo a) 
    {
        this.artParaVenda.add(a);
    }

    public void removeParaVenda(Artigo a) 
    {
        this.artParaVenda.remove(a);
    }

    public void addVendidos(Artigo a) 
    {
        this.artVendidos.add(a);
    }

    public void removeVendidos(Artigo a) 
    {
        this.artVendidos.remove(a);
    }

    public void addComprados(Artigo a) 
    {
        this.artComprados.add(a);
    }

    public void removeComprados(Artigo a) 
    {
        this.artComprados.remove(a);
    }

    public void fazerEncomenda(List<Transportadora> transportadorasDisponiveis, Transportadora transportadoraEscolhida, int quantidadeArtigos, boolean isPremium) {
        if (isPremium) {
            //Se há transportadoras especializadas em artigos Premium disponíveis
            List<Transportadora> transportadorasEspecializadasPremium = transportadorasDisponiveis.stream()
                    .filter(t -> t.isEspecializadaPremium())
                    .collect(Collectors.toList());
            if (!transportadorasEspecializadasPremium.isEmpty()) {
                //Escolhe a primeira transportadora especializada em artigos Premium encontrada
                transportadoraEscolhida = transportadorasEspecializadasPremium.get(0);
            }
        }

        // Calcula o preço da expedição usando o método calcularPrecoExpedicaoTransportadora da transportadora escolhida
        double precoExpedicao = transportadoraEscolhida.calcularPrecoExpedicaoTransportadora(quantidadeArtigos, isPremium);
    }
    
    public double precoTotalDeVendas(List<Venda> vendas) {
        double total = 0.0;
        for (Venda venda : vendas) {
            total += venda.getValor();
        }
        return total;
    }

    /*
    public void adicionarArtigoParaVenda(String cod, String descricao, double preco) {
        Artigo novoArtigo = new Artigo(cod, descricao, preco);
        Venda novaVenda = new Venda(this, novoArtigo);
        UnicodeSet vendas = null;
        vendas.add((CharSequence) novaVenda);
    }
     */
}
