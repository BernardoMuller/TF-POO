package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class ConjuntoTransportes {
private static LinkedList<Transporte> transportes = new LinkedList<>();

    public static void cadastraEspacoTransporte(Transporte transporte){
        int countRepetido = 0;
        if(transportes.size()==0){transportes.add(transporte);}
        else{
            for(int i = 0; i<transportes.size(); i++){
                if(transportes.get(i).getIdentificador() == transporte.getIdentificador()){
                    countRepetido++;
                }
            }
            if(countRepetido==0){ transportes.add(transporte);}
        }
    }

    public static void leArquivoTransporte(String paths){
        Path path = Paths.get(paths);
        try(BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)))){
            String fileContent;
            br.readLine();
            for(String linha ; (linha = br.readLine()) != null;){
                fileContent = linha;
                String [] fcParts = fileContent.split(";");
                int classificacao = Integer.parseInt(fcParts[0]);
                if(classificacao == 1){
                    int identificador = Integer.parseInt(fcParts[1]);
                    int origem = Integer.parseInt(fcParts[2]);
                    int destino = Integer.parseInt(fcParts[3]);
                    int quantidadePessoas = Integer.parseInt(fcParts[4]);

                    ConjuntoPortos conj = new ConjuntoPortos();
                    LinkedList<EspacoPorto> list = conj.getPortos();
                    EspacoPorto origem1 = null;
                    EspacoPorto destino1 = null;

                    for(EspacoPorto porto : list){
                        if(porto.getNumero()==origem){origem1=porto;}
                        if(porto.getNumero()==destino){destino1=porto;}
                    }
                    if(origem1==null || destino1==null){}

                    TransportePessoas tp = new TransportePessoas(identificador,origem1,destino1,quantidadePessoas);
                    transportes.add(tp);
                }
                else if(classificacao ==2){
                        int identificador = Integer.parseInt(fcParts[1]);
                        int origem = Integer.parseInt(fcParts[2]);
                        int destino = Integer.parseInt(fcParts[3]);
                        int quantidadeCarga = Integer.parseInt(fcParts[4]);
                        String desc = fcParts[5];
                    ConjuntoPortos conj = new ConjuntoPortos();
                    LinkedList<EspacoPorto> list = conj.getPortos();
                    EspacoPorto origem1 = null;
                    EspacoPorto destino1 = null;

                    for(EspacoPorto porto : list){
                        if(porto.getNumero()==origem){origem1=porto;}
                        if(porto.getNumero()==destino){destino1=porto;}
                    }
                    if(origem1==null || destino1==null){}

                    TransporteMaterial tm = new TransporteMaterial(identificador,origem1,destino1,quantidadeCarga,desc);
                    transportes.add(tm);
                }

            }
            System.out.println("Leitura realizada com sucesso!");
        }catch(Exception e){
            System.out.println("Erro encontrado: " + e);
        }

    }



}
