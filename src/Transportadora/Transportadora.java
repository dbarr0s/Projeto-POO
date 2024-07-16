package Transportadora;

public class Transportadora {

    private String nome;
    private double valorBasePequeno;
    private double valorBaseMedio;
    private double valorBaseGrande;
    private double impostoMultiplicador;
    private boolean isEspecializada;
    private boolean isEspecializadaPremium;

    //--------------------------------------------------------------Construtores--------------------------------------------------------------------------\\

    public Transportadora(String nome, double valorBasePequeno, double valorBaseMedio, double valorBaseGrande, double impostoMultiplicador, boolean isEspecializada, boolean isEspecializadaPremium) {
        this.nome = nome;
        this.valorBasePequeno = valorBasePequeno;
        this.valorBaseMedio = valorBaseMedio;
        this.valorBaseGrande = valorBaseGrande;
        this.impostoMultiplicador = impostoMultiplicador;
        this.isEspecializada = isEspecializada;
        this.isEspecializadaPremium = isEspecializadaPremium;
    }

    //--------------------------------------------------------------Getters e Setters--------------------------------------------------------------------------\\

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorBasePequeno() {
        return valorBasePequeno;
    }

    public void getValorBasePequeno(double valorBasePequeno) {
        this.valorBasePequeno = valorBasePequeno;
    }

    public double getValorBaseMedio() {
        return valorBaseMedio;
    }

    public void setValorBaseMedio(double valorBaseMedio) {
        this.valorBaseMedio = valorBaseMedio;
    }

    public double getValorBaseGrande() {
        return valorBaseGrande;
    }

    public void setValorBaseGrande(double valorBaseGrande) {
        this.valorBaseGrande = valorBaseGrande;
    }

    public double getImpostoMultiplicador() {
        return impostoMultiplicador;
    }

    public void setImpostoMultiplicador(double impostoMultiplicador) {
        this.impostoMultiplicador = impostoMultiplicador;
    }

    public boolean isEspecializada() {
        return isEspecializada;
    }

    public void setIsEspecializada(boolean isEspecializada) {
        this.isEspecializada = isEspecializada;
    }

    public boolean isEspecializadaPremium() {
        return isEspecializadaPremium;
    }

    public void isEspecializadaPremium(boolean isEspecializadaPremium) {
        this.isEspecializadaPremium = isEspecializadaPremium;
    }


    //--------------------------------------------------------------Outros métodos--------------------------------------------------------------------------\\

    public double calcularPrecoExpedicaoTransportadora(int quantidadeArtigos, boolean isPremium) {
        double valorBase;
        if (quantidadeArtigos == 1) {
            valorBase = valorBasePequeno;
        } else if (quantidadeArtigos <= 5) {
            valorBase = valorBaseMedio;
        } else {
            valorBase = valorBaseGrande;
        }
        double margemLucro = isEspecializada && isPremium ? 1.5 : 1.0;
        double imposto = valorBase * impostoMultiplicador;
        return (valorBase * margemLucro * (1 + imposto)) * 0.9;
    }

    public String toString() {
        return "Transportadora{" + nome + '\'' +
                ", valorBasePequeno=" + valorBasePequeno +
                ", valorBaseMedio=" + valorBaseMedio +
                ", valorBaseGrande=" + valorBaseGrande +
                ", impostoMultiplicador=" + impostoMultiplicador +
                '}';
    }
}
