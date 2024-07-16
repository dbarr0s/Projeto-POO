package Utils;

import Vintage.Vintage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parser(String filePath, Vintage v, int type){
        List<String> linhas = lerFicheiro(filePath);
        int num=0;
        String[] linebreak;
        for (String linha : linhas) {
            if(num != 0){
                switch (type) {
                    case 0 -> v.add_user(linha);
                    case 1 -> v.add_transportadora(linha);
                    case 2 -> v.add_mala(linha);
                    case 3 -> v.add_sapatilha(linha);
                    case 4 -> v.add_tshirt(linha);
                    case 5 -> v.add_encomenda(linha);
                }
            }
            num++;
        }
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
