package Artigos;
import java.time.LocalDate;

public class Sapatilha extends Artigo{
    private int tamanho;
    private boolean atacadores;
    private String cor;
    private LocalDate lancamento;

    /*
    Construtores
     */

    public Sapatilha(Artigo a, int tamanho, boolean atacadores, String cor, LocalDate lancamento) {
        super(a);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.lancamento = lancamento;
    }


    /*
    Funções de manipulação de uma sapatilha
     */
    /*
    Falta tratar de tamanhos acima do 45
     */
    public double getPrecoFinal() {
        double precoBase = super.getPreco();
        int anos = LocalDate.now().getYear() - this.getLancamento().getYear();
        double desconto = (double) (super.getDesconto()*anos)/100;
        double precoFinal = precoBase;
        if (super.getPremium()){
            precoFinal = precoFinal + (precoFinal *(1/super.getEstado()) * desconto);
        } else {
            precoFinal = precoFinal - (precoFinal *(1/super.getEstado()) * desconto);
        }

        return precoFinal;

    }

    /*
    Getters and Setters
     */
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isAtacadores() {
        return atacadores;
    }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
        sb.append("€;Tamanho: ");
        sb.append(this.tamanho);
        if(this.atacadores) sb.append(";Tem Atacadores");
        else sb.append(";Não Tem Atacadores");
        sb.append(";Cor: ");
        sb.append(this.cor);
        sb.append(";Lancamento: ");
        sb.append(this.lancamento);
        sb.append("\n");


        return sb.toString();
    }
}
