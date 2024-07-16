import Artigos.Artigo;
import Encomenda.Encomenda;
import Transportadora.Transportadora;
import Utilizadores.Utilizador;
import Utils.Parser;
import Utils.Ui;
import Vintage.Vintage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length < 6){
            System.out.println("path/user.csv path/transportadora.csv path/mala.csv path/sapatilhas.csv path/tshirts.csv path/encomenda.csv");
        }
        else {
            Vintage v = new Vintage();
            Parser.parser(args[0],v,0);
            Parser.parser(args[1],v,1);
            Parser.parser(args[2],v,2);
            Parser.parser(args[3],v,3);
            Parser.parser(args[4],v,4);
            Parser.parser(args[5],v,5);

            Scanner in = new Scanner(System.in);

            Ui.printWelcome();
            Ui.loginSigninMenu();
            String tag = in.nextLine();
            String cod_user = null;
            while (!tag.equals("q") && cod_user==null){
                if(tag.equals("1")){ // login
                    Ui.emailPrompt();
                    String email = in.nextLine();
                    Ui.passwordPrompt();
                    String password = in.nextLine();
                    cod_user = v.login(email,password);
                    System.out.println(cod_user);
                }
                else{ // create user
                    Ui.emailPrompt();
                    String email = in.nextLine();
                    Ui.passwordPrompt();
                    String password = in.nextLine();
                    Ui.nomePrompt();
                    String nome = in.nextLine();
                    Ui.moradaPrompt();
                    String morada = in.nextLine();
                    Ui.nifPrompt();
                    String nif = in.nextLine();
                    cod_user =  v.create_user(email, password, nome, morada, nif);
                    System.out.println(cod_user);

                }
                if(cod_user==null){
                    Ui.loginSigninMenu();
                    tag = in.nextLine();
                }


            }


            ArrayList<Utilizador> users = v.getUsers();


            // Main Menu
            Ui.printMainMenu();
            tag = in.nextLine();
            while(!tag.equals("q")){
                switch(tag){
                    case "1":// Adicionar Produto
                        Ui.usadoPrompt();
                        String usado = in.nextLine();
                        Ui.estadoPrompt();
                        String estado = in.nextLine();
                        Ui.donosPrompt();
                        String donos = in.nextLine();
                        Ui.descricaoPrompt();
                        String descricao = in.nextLine();
                        Ui.marcaPrompt();
                        String marca = in.nextLine();
                        Ui.precoPrompt();
                        String preco = in.nextLine();
                        Ui.descontoPrompt();
                        String desconto = in.nextLine();
                        Ui.premiumPrompt();
                        String premium = in.nextLine();
                        Ui.tipoProdutoPrompt();
                        tag = in.nextLine();
                        Artigo artigo = v.create_artigo(Boolean.parseBoolean(usado),Double.parseDouble(estado),Integer.parseInt(donos),descricao,marca,Double.parseDouble(preco),Integer.parseInt(desconto),Boolean.parseBoolean(premium),tag);
                        if(tag.equals("1")){
                            Ui.anoPrompt();
                            String anoM = in.nextLine();
                            Ui.dimensaoPrompt();
                            String dimensao = in.nextLine();
                            Ui.materialPrompt();
                            String material = in.nextLine();
                            Ui.lancamentoPrompt();
                            String lancamento = in.nextLine();
                            v.create_mala(artigo,anoM,dimensao,material,lancamento,cod_user);
                        }
                        if(tag.equals("2")){
                            Ui.tamanhoPrompt();
                            String tamanho = in.nextLine();
                            Ui.lancamentoPrompt();
                            String lancamentoS = in.nextLine();
                            Ui.corPrompt();
                            String cor = in.nextLine();
                            Ui.atacadoresPrompt();
                            String atacadores = in.nextLine();
                            v.create_sapatilha(artigo,tamanho,atacadores,cor,lancamentoS,cod_user);
                        }
                        if(tag.equals("3")) {
                            Ui.tamanhoPrompt();
                            String tamanhoT = in.nextLine();
                            Ui.padraoPrompt();
                            String padrao = in.nextLine();
                            v.create_tshirt(artigo,tamanhoT,padrao,cod_user);
                        }
                        break;

                    case "2": // Navegar meus produtos a venda
                        boolean found = false;
                        for (Utilizador u:
                             users) {
                            if(cod_user.equals(u.getCodigo())){
                                u.printProdutos();
                                found = true;
                                break;
                            }
                        }
                        if(!found) System.out.println("404 User not found");
                        break;
                    case "3": // Navegar todos os produtos a venda
                        for (Utilizador u:
                                users){
                            u.printAvenda();
                        }
                        break;
                    case "4": // Efetuar encomenda
                        Ui.printVendedorPrompt();
                        tag = in.nextLine();
                        Utilizador vendedor = null;
                        if(tag.equals("l") || tag.equals("L")) {
                            for (Utilizador u:
                                    users){
                                System.out.println("----------------------------------------------------");
                                System.out.println(u.getCodigo());
                                u.printAvenda();
                                System.out.println("----------------------------------------------------");
                            }
                        }
                        else {
                            for(Utilizador u: users){
                                if(u.getCodigo().equals(tag)) {
                                    vendedor = u;
                                    break;
                                }
                            }
                            if (vendedor != null){
                                vendedor.printAvenda();
                                Ui.produtoEncomendaPrompt();
                                tag = in.nextLine();
                                boolean prem = false;
                                String[] produtos = tag.split(";");
                                ArrayList<Artigo> comprados = new ArrayList<>();
                                for(String produto : produtos){
                                    for(Artigo a : vendedor.getArtParaVenda()){
                                        if(produto.equals(a.getCod())){
                                            comprados.add(a);
                                            if(a.getPremium()) prem = true;
                                        }
                                    }

                                }
                                Ui.transportadoraPrompt();
                                for(Transportadora t:v.getTransportadoras()){
                                    if(prem){
                                        if(t.isEspecializadaPremium()){
                                            System.out.println(t);
                                        }
                                    }
                                    else {
                                        System.out.println(t);
                                    }
                                }

                                tag = in.nextLine();

                                System.out.println("Encomenda:" + v.createEncomenda(vendedor.getCodigo(),cod_user,comprados,tag));


                            } else {
                                Ui.printVendedorInvalidoPrompt();
                            }

                        }
                        break;
                    case "5": // Verificar estado das encomendas
                        for(Encomenda e : v.getEncomendas()){
                            if(cod_user.equals(e.getCodCliente())){
                                System.out.println(e);
                            }
                        }
                        break;
                    case "6": // Calcula lucros do vintage
                        System.out.println("----------------------------------------------------");
                        System.out.println("| Lucros totais = ");
                        System.out.println(v.profitVintage());
                        System.out.println(" |");
                        System.out.println("----------------------------------------------------");
                        break;
                    case "7": // Transp que mais faturou
                        System.out.println("----------------------------------------------------");
                        System.out.println("| "+"Foi a transportadora: " + v.transpMaisFaturou()+" |");
                        System.out.println("----------------------------------------------------");
                        break;
                    case "8": // Vendedor que mais faturou
                        System.out.println("----------------------------------------------------");
                        System.out.println("| "+"Foi o vendedor: " + v.vendedorMaisFaturou().getNome()+ " " + v.vendedorMaisFaturou().getCodigo() + " |");
                        System.out.println("----------------------------------------------------");
                    break;
                    case "9": // Encomendas de um vendedor
                        Ui.codUserPrompt();
                        tag = in.nextLine();
                        String codUser = null;

                        for (Utilizador u: users)
                        {
                            if (u.getCodigo().equals(tag)) {
                                codUser = tag;
                                break;
                            }
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.println("| "+"Encomendas: " + v.encomendasUser(codUser)+" |");
                        System.out.println("----------------------------------------------------");
                    break;
                    }



                Ui.printMainMenu();
                tag = in.nextLine();
            }


        }

    }
}
