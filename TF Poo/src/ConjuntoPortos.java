package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class ConjuntoPortos {
    private static LinkedList<EspacoPorto> portos = new LinkedList<>();

    public ConjuntoPortos(){}

    public static void cadastraEspacoPorto(EspacoPorto porto){
        int countRepetido = 0;
        if(portos.size()==0){portos.add(porto);}
        else{
            for(int i = 0; i<portos.size(); i++){
                if(portos.get(i).getNumero() == porto.getNumero()){
                    countRepetido++;
                }
            }
            if(countRepetido==0){ portos.add(porto);}
        }
    }
    public static void leArquivoPorto(String paths){
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
                portos.add(separator);
            }
            System.out.println("Leitura realizada com sucesso!");
        }catch(Exception e){
            System.out.println("Erro encontrado: " + e);
        }

    }


}
