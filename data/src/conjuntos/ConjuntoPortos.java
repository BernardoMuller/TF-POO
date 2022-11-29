package src.conjuntos;

import src.entidades.EspacoPorto;
import src.entidades.Transporte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ConjuntoPortos {
    private ArrayList<EspacoPorto> portos;

    public ConjuntoPortos(){
        portos = new ArrayList<>();
    }

    public boolean cadastraEspacoPorto(EspacoPorto porto){
        int countRepetido = 0;
        if(portos.size()==0){portos.add(porto);}
        else{
            for(int i = 0; i<portos.size(); i++){
                if(portos.get(i).getNumero() == porto.getNumero()){
                    countRepetido++;
                }
            }
            if(countRepetido==0){ portos.add(porto); return true;}
        }
        return false;
    }
    public void leArquivoPorto(String paths){
        Path path = Paths.get(paths);
        try(BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)))){
            String fileContent;
            br.readLine();
            for(String linha ; (linha = br.readLine()) != null;){
                fileContent = linha;
                String [] fcParts = fileContent.split(";");
                int idPorto = Integer.parseInt(fcParts[0]);
                String nomePorto = fcParts[1];
                double coordX = Double.parseDouble(fcParts[2]);
                double coordY = Double.parseDouble(fcParts[3]);
                double coordZ = Double.parseDouble(fcParts[4]);
                EspacoPorto separator = new EspacoPorto(idPorto,nomePorto,coordX,coordY,coordZ);
               cadastraEspacoPorto(separator);
            }
            System.out.println("Leitura realizada com sucesso!");
        }catch(Exception e){
            System.out.println("Erro encontrado: " + e);
        }

    }
    public ArrayList<EspacoPorto> getPortos() {
        return portos;
    }

    public EspacoPorto pesquisaPorID(int ID) {
        for (EspacoPorto EP : portos) {
            if (EP.getNumero() == ID) {
                return EP;
            }
        }
     return null;
    }

    public void salvarDadosPortos(String nomeArquivo){
        nomeArquivo = nomeArquivo+".csv";
        Path path = Paths.get(nomeArquivo);
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));){
            pw.println("numero;nome;x;y;z");
            for (EspacoPorto porto : portos){
                pw.println(porto.geraResumo());
            }
        }
        catch(Exception e){System.out.println("Erro encontrado: " + e);}
    }
}
