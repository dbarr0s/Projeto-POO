package Utils;

import Artigos.Artigo;
import Utilizadores.Utilizador;
import Utilizadores.Venda;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import static Utilizadores.Venda.separarVendas;

public class Ui {
    private List<Venda> vendas;

    public static void printWelcome(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                                                  |");
        System.out.println("|               Bem-vindo ao Vintage               |");
        System.out.println("|              Faça login para começar             |");
        System.out.println("|                                                  |");
        System.out.println("----------------------------------------------------");
    }

    public static void loginSigninMenu(){
        System.out.println("----------------------------------------------------");
        System.out.println("|1-> Efetuar login                                 |");
        System.out.println("|2-> Crie nova conta                               |");
        System.out.println("----------------------------------------------------");
    }

    public static void emailPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|               Insira seu email                   |");
        System.out.println("----------------------------------------------------");
    }

    public static void passwordPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira sua password                 |");
        System.out.println("----------------------------------------------------");
    }

    public static void nomePrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                Insira seu Nome                   |");
        System.out.println("----------------------------------------------------");
    }

    public static void moradaPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                Insira a sua morada               |");
        System.out.println("----------------------------------------------------");
    }

    public static void nifPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                   Insira Nif                     |");
        System.out.println("----------------------------------------------------");
    }

    public static void printMainMenu(){
        System.out.println("----------------------------------------------------");
        System.out.println("|1-> Adicionar produto para venda                  |");
        System.out.println("|2-> Navegar produtos à venda (meus produtos)      |");
        System.out.println("|3-> Navegar produtos à venda                      |");
        System.out.println("|4-> Efetuar encomenda                             |");
        System.out.println("|5-> Verificar estado das minhas encomendas        |");
        System.out.println("|6-> Calcular lucros da vintage                    |");
        System.out.println("|7-> Ver que transportadora lucrou mais            |");
        System.out.println("|8-> Vendedor que mais facturou                    |");
        System.out.println("|9-> Encomendas emitidas por um vendedor           |");
        System.out.println("|q-> Sair                                          |");
        System.out.println("----------------------------------------------------");
    }

    public static void tipoProdutoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|1-> Mala                                          |");
        System.out.println("|2-> Sapatilhas                                    |");
        System.out.println("|3-> Tshirt                                        |");
        System.out.println("----------------------------------------------------");
    }

    public static void anoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                 Insira o ano                     |");
        System.out.println("----------------------------------------------------");
    }

    public static void precoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|               Insira um preço                    |");
        System.out.println("----------------------------------------------------");
    }

    public static void dimensaoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                Insira a dimensão                 |");
        System.out.println("----------------------------------------------------");
    }

    public static void materialPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira o material                   |");
        System.out.println("----------------------------------------------------");
    }

    public static void descricaoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|     Insira uma breve descrição do produto        |");
        System.out.println("----------------------------------------------------");
    }

    public static void tamanhoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira o tamanho                    |");
        System.out.println("----------------------------------------------------");
    }

    public static void corPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                 Insira a cor                     |");
        System.out.println("----------------------------------------------------");
    }

    public static void atacadoresPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|           Possuem atacadores/atilhos             |");
        System.out.println("|                  true or false                   |");
        System.out.println("----------------------------------------------------");
    }

    public static void padraoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                 Insira o padrão                  |");
        System.out.println("|             liso, riscas, palmeiras              |");
        System.out.println("----------------------------------------------------");
    }

    public static void usadoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                 O Produto é novo?                |");
        System.out.println("|             1 para novo; 2 para usado            |");
        System.out.println("----------------------------------------------------");
    }

    public static void estadoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|             Insira o estado do produto           |");
        System.out.println("|1<=0.8 -> novo de fábrica; 0.8<=0.6 -> pouco uso  |");
        System.out.println("|0.6<=0.4 -> Aceitável; 0.4<=0.2 -> Muito uso;     |");
        System.out.println("|0.2<=0 -> Muito desgastado                        |");
        System.out.println("----------------------------------------------------");
    }

    public static void donosPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira o número de donos            |");
        System.out.println("----------------------------------------------------");
    }

    public static void marcaPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira marca do produto             |");
        System.out.println("----------------------------------------------------");
    }

    public static void descontoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira desconto do produto          |");
        System.out.println("----------------------------------------------------");
    }

    public static void premiumPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|               O Produto é premium?               |");
        System.out.println("|                  true or false                   |");
        System.out.println("----------------------------------------------------");
    }

    public static void lancamentoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|          Quando foi o produto lançado?           |");
        System.out.println("|          Formato da data -> AAAA-MM-DD           |");
        System.out.println("----------------------------------------------------");
    }

    public static void printVendedorPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira o código do Vendedor         |");
        System.out.println("| l-> listar Vendedores e seus produtos            |");
        System.out.println("----------------------------------------------------");
    }

    public static void codUserPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Insira o código do Vendedor         |");
        System.out.println("----------------------------------------------------");
    }

    public static void printVendedorInvalidoPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|              Codigo de vendedor inválido         |");
        System.out.println("----------------------------------------------------");
    }

    public static void produtoEncomendaPrompt(){
        System.out.println("----------------------------------------------------");
        System.out.println("|            Insira o código dos produtos          |");
        System.out.println("|          Separados por ';' e sem espaços         |");
        System.out.println("----------------------------------------------------");
    }

    public static void transportadoraPrompt(){
        System.out.println("-------------------------------------------------------");
        System.out.println("|Escolha a transportadora que deseja efetuar encomenda|");
        System.out.println("-------------------------------------------------------");
    }
}
