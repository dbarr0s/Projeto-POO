package Artigos;
public class Tshirt extends Artigo{
    private String tamanho; // S; M; L; XL;
    private String padrao; // LISA; RISCAS; PALMEIRAS;

    /*
    Construtores
     */

    public Tshirt(Artigo a, String tamanho, String padrao) {
        super(a);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    /*
    Funções de manipulação de uma tshirt
     */


    public int getPadraoInt() {
        return switch (this.getPadrao()) {
            case "LISA" -> 0;
            case "RISCAS" -> 1;
            case "PALMEIRAS" -> 2;
            default -> -1;
        };
    }

    public double getPrecoFinal() {
        double precoFinal = super.getPreco();
        if (this.getPadraoInt()>0 && super.isUsado()){
            precoFinal /= 2;
        }
        return precoFinal;
    }

    /*
    Getters and Setters
     */

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        Double preco = this.getPrecoFinal();
        sb.append(super.toString());
        sb.append("Preco: ");
        sb.append(preco);
        sb.append("€;Tamanho: ");
        sb.append(this.tamanho);
        sb.append(";Padrao: ");
        sb.append(this.padrao);
        sb.append("\n");


        return sb.toString();
    }
}
