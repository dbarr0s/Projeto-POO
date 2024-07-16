package Artigos;
public class Artigo {
    private String cod; // codigo alfanumérico
    private boolean usado; // 0 -> usado; 1 -> não usado
    private double estado; // 1 -> novo de fábrica; 0.8 -> pouco uso; 0.6 -> Aceitável; 0.4 -> Muito uso; 0.2 -> Muito desgastado
    private int donos; // número total de donos
    private String descricao; // descrição do produto
    private String marca; // Marca do produto
    private double preco; // Preço base do produto
    private int desconto; // desconto em %, para produtos luxo serve de quanto overpay se deve dar
    private boolean isPremium; // saber se o artigo é premium ou não

    /*
    Construtores
     */


    public Artigo(String cod, boolean usado, double estado, int donos, String descricao, String marca, double preco, int desconto, boolean isPremium) {
        this.cod = cod;
        this.usado = usado;
        this.estado = estado;
        this.donos = donos;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
        this.desconto = desconto;
        this.isPremium = isPremium;
    }

    public Artigo(Artigo a) {
        this.cod = a.getCod();
        this.usado = a.isUsado();
        this.estado = a.getEstado();
        this.donos = a.getDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.preco = a.getPreco();
        this.desconto = a.getDesconto();
        this.isPremium = a.getPremium();
    }

    public Artigo(String cod) {
        this.cod = cod;
        this.usado = false;
        this.estado = 0;
        this.donos = 0;
        this.descricao = "";
        this.marca = "";
        this.preco = 0;
        this.desconto = 0;
        this.isPremium = false;
    }

    /*
    Funções de manipulação de um artigo
     */



    /*
    Getters and Setters
     */

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public double getEstado() {
        return estado;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }

    public int getDonos() {
        return donos;
    }

    public void setDonos(int donos) {
        this.donos = donos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public boolean getPremium() {
        return this.isPremium;
    }

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }


    /*
    EQUALS, CLONE,TOSTRING
*/

    // fazer toString e toStringDetailed

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cod);
        if (this.usado) {
            sb.append(";Usado;");
            sb.append("Estado do artigo: ");
            sb.append(this.estado);
        }
        else sb.append(";Novo;");

        sb.append(";Donos: \n");
        sb.append(this.donos);

        sb.append(";");
        sb.append(this.descricao);
        sb.append(";Marca: ");
        sb.append(this.marca);
        if(this.isPremium) sb.append(";Premium");
        sb.append(";");

        return sb.toString();
    }
}
