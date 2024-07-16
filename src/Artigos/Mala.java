package Artigos;
import java.time.LocalDate;

public class Mala extends Artigo{

    private int ano; /* ano da colecao */
    private int dimensao; /* Em litros -> 2l mais pequena; 60l -> maior*/
    private double material; /* qualidade do material de 0 a 1 */
    private LocalDate lancamento;

    /*
    Construtores
     */

    public Mala(Artigo a, int ano, int dimensao, double material, LocalDate lancamento) {
        super(a);
        this.ano = ano;
        this.dimensao = dimensao;
        this.material = material;
        this.lancamento = lancamento;
    }



    /*
    Funções de manipulação de uma mala
     */

    public double getPrecoFinal() {
        double precoBase = super.getPreco();
        int anos = LocalDate.now().getYear() - this.getLancamento().getYear();
        double desconto = (double) (super.getDesconto() * anos) / 100;
        double precoFinal = precoBase - (precoBase * desconto);
        if (super.getPremium()) {
            precoFinal = precoFinal + (precoFinal * 0.05);
        }
        return precoFinal;
    }

    /*
    Getters and Setters
     */

     public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public double getMaterial() {
        return material;
    }

    public void setMaterial(double material) {
        this.material = material;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        Double preco = this.getPrecoFinal();
        sb.append(super.toString());
        sb.append("Preco: ");
        sb.append(preco);
        sb.append("€;Ano colecao: ");
        sb.append(this.ano);
        sb.append(";Dimensao: ");
        sb.append(this.dimensao);
        sb.append(";Material: ");
        sb.append(this.material);
        sb.append(";Lancamento: ");
        sb.append(this.lancamento);
        sb.append("\n");


        return sb.toString();
    }
}
