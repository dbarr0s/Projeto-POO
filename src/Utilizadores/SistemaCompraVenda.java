package Utilizadores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.*;
//import org.junit.*;
//import org.junit.Before;
//import org.junit.After;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class SistemaCompraVenda {
    private List<Utilizadores.Compra> compras;
    private List<Venda> vendas;
    private String dataInicial;
    private String dataFinal;

    public SistemaCompraVenda() throws ParseException {
    }

//    @Before
    public void setUp() {
        // Inicialização do sistema de compras e vendas
        // Este método é executado antes de cada teste
        compras = new ArrayList<>();
        vendas = new ArrayList<>();
    }

//    @After
    public void tearDown() {
        // Limpeza do sistema de compras e vendas
        // Este método é executado após cada teste
        compras = null;
        vendas = null;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date dataInicialDate = dateFormat.parse(dataInicial);
    Date dataFinalDate = dateFormat.parse(dataFinal);

    //--------------------------------------------------------------Outros métodos--------------------------------------------------------------------------\\

    public List<Utilizador> maioresCompradores(Date dataInicial, Date dataFinal, int quantidade) {
        Map<Utilizador, Double> mapaCompras = new HashMap<>();
        for (Utilizadores.Compra compra : compras) {
            if (compra.getData().after(dataInicialDate) && compra.getData().before(dataFinalDate)) {
                Utilizador comprador = compra.getComprador();
                double valorCompra = compra.getValor();
                double valorAcumulado = mapaCompras.getOrDefault(comprador, 0.0);
                mapaCompras.put(comprador, valorAcumulado + valorCompra);
            }
        }
        List<Utilizador> maioresCompradores = new ArrayList<>(mapaCompras.keySet());
        maioresCompradores.sort((u1, u2) -> mapaCompras.get(u2).compareTo(mapaCompras.get(u1)));
        return maioresCompradores.subList(0, Math.min(quantidade, maioresCompradores.size()));
    }

    public List<Utilizador> maioresVendedores(Date dataInicial, Date dataFinal, int quantidade) {
        Map<Utilizador, Double> mapaVendas = new HashMap<>();
        for (Venda venda : vendas) {
            if (venda.getData().after(dataInicial) && venda.getData().before(dataFinal)) {
                Utilizador vendedor = venda.getVendedor();
                double valorVenda = venda.getValor();
                double valorAcumulado = mapaVendas.getOrDefault(vendedor, 0.0);
                mapaVendas.put(vendedor, valorAcumulado + valorVenda);
            }
        }
        List<Utilizador> maioresVendedores = new ArrayList<>(mapaVendas.keySet());
        maioresVendedores.sort((u1, u2) -> mapaVendas.get(u2).compareTo(mapaVendas.get(u1)));
        return maioresVendedores.subList(0, Math.min(quantidade, maioresVendedores.size()));
    }
}