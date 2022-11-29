package src.conjuntos;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.subclasses.FTL;
import src.subclasses.Subluz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConjuntoEspaconaves {

    private ArrayList<Espaconave> garagem;

    private ConjuntoPortos cj;

    public ConjuntoEspaconaves() {
        garagem= new ArrayList<>();
        cj= new ConjuntoPortos();
    }

    public boolean cadastraNave(Espaconave nave) {
        for (Espaconave jato : garagem) {
            if (jato.getNome().equalsIgnoreCase(nave.getNome())) {
                return false;
            }
        }
        garagem.add(nave);
        return true;
    }

    public boolean leArquivo(String nomeArquivo) {
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            String dados = null;
            br.readLine();
            while ((dados = br.readLine()) != null) {
                Scanner tec = new Scanner(dados).useDelimiter(";");

                String tipo = tec.next();
                String nome = tec.next();
                String EP = tec.next();
                String velocidade = tec.next();
                String combustivel_limite = tec.next();
                int id = Integer.parseInt(tipo);
                int idEP = Integer.parseInt(EP);
                double v = Double.parseDouble(velocidade);
                EspacoPorto ep = cj.pesquisaPorID(idEP);
                if(id==1){
                    Espaconave Sub = new Subluz(id , nome, ep, v, combustivel_limite);
                    cadastraNave(Sub);}

                if(id==2){
                    int limite = Integer.parseInt(combustivel_limite);
                    Espaconave FT = new FTL(id, nome, ep, v, limite);
                    cadastraNave(FT);}
            }

        }
        catch(NoSuchElementException e){
            System.out.println("");
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }





}