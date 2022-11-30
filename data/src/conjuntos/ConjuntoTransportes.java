package src.conjuntos;

import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.entidades.Transporte;
import src.subclasses.TransporteMaterial;
import src.subclasses.TransportePessoas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConjuntoTransportes {
private  ArrayList<Transporte> todosTransportes;
private  Queue<Transporte> transportesPendentes;

private ConjuntoPortos conj;

    public void setConj(ConjuntoPortos conj) {
        this.conj = conj;
    }

    public ConjuntoTransportes(){
    transportesPendentes = new LinkedList<>();
    todosTransportes = new ArrayList<>();
}

public boolean cadastraEspacoTransporte(Transporte transporte){
    for(Transporte transporte1 : transportesPendentes){
        if(transporte1.getIdentificador()==transporte.getIdentificador()){
            return false;
        }
    }
    transportesPendentes.add(transporte); todosTransportes.add(transporte); return true;
    }

    public void leArquivoTransporte(String paths){
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


                    ArrayList<EspacoPorto> list = conj.getPortos();
                    EspacoPorto origem1 = null;
                    EspacoPorto destino1 = null;

                    for(EspacoPorto porto : list){
                        if(porto.getNumero()==origem){origem1=porto;}
                        if(porto.getNumero()==destino){destino1=porto;}
                    }
                    if(origem1==null || destino1==null){}

                    TransportePessoas tp = new TransportePessoas(identificador,origem1,destino1,quantidadePessoas);
                    cadastraEspacoTransporte(tp);
                }
                else if(classificacao ==2){
                        int identificador = Integer.parseInt(fcParts[1]);
                        int origem = Integer.parseInt(fcParts[2]);
                        int destino = Integer.parseInt(fcParts[3]);
                        double quantidadeCarga = Double.parseDouble(fcParts[4]);
                        String desc = fcParts[5];
                    ConjuntoPortos conj = new ConjuntoPortos();
                    ArrayList<EspacoPorto> list = conj.getPortos();
                    EspacoPorto origem1 = null;
                    EspacoPorto destino1 = null;

                    for(EspacoPorto porto : list){
                        if(porto.getNumero()==origem){origem1=porto;}
                        if(porto.getNumero()==destino){destino1=porto;}
                    }
                    if(origem1==null || destino1==null){}

                    TransporteMaterial tm = new TransporteMaterial(identificador,origem1,destino1,quantidadeCarga,desc);
                    cadastraEspacoTransporte(tm);
                }

            }
            System.out.println("Leitura realizada com sucesso!");
        }catch(Exception e){
            System.out.println("Erro encontrado: " + e);
        }

    }

    public void alteraEstadoTransporte(int id){
        String status = "";
        int filaHas = 0;
        Scanner in = new Scanner(System.in);
        Transporte transp = null;
        for(Transporte transporte : transportesPendentes){
            if(transporte.getIdentificador()==id){transp=transporte;filaHas=1;break;}
        }
        if(filaHas==0){
        for(Transporte transporte : todosTransportes ){
            if(transporte.getIdentificador()==id){transp=transporte;break;}
        }}
        if(transp.getEstado().equalsIgnoreCase("Cancelado") || transp.getEstado().equalsIgnoreCase("Finalizado")){System.out.println("O estado deste transporte não pode ser alterado"); return;}

        System.out.println("Escolha qual estado deseja colocar");
        int escolha = 0;
        try{
            while(escolha<1 || escolha>4){
                System.out.println("1-Pendente\n2-Transportando\n3-Cancelado\n4-Finalizado");
                escolha = in.nextInt();
            }

            switch(escolha){
                case 1: status = "Pendente";break;
                case 2: status = "Transportando";break;
                case 3: status = "Cancelado";break;
                case 4: status = "Finalizado";break;
                default: break;
            }



        }catch(InputMismatchException e){System.out.println("Insira um numero valido"); escolha = 0;}

        transp.setEstado(status);
        if(filaHas==1 && !status.equalsIgnoreCase("pendente")){transportesPendentes.remove(transp);}
    }

    public void designarTransporte(int id, Espaconave espaconave){
    Transporte tp = null;
        for(Transporte transporte : transportesPendentes){
            if(transporte.getIdentificador() == id){tp=transporte;}
        }
        tp.setEspaconave(espaconave);

    }

    public void salvarDadosTransportes(String nomeArquivo){
        nomeArquivo = nomeArquivo+".csv";
        Path path = Paths.get(nomeArquivo);
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));){
            pw.println("tipo;identificador;origem;destino;quantidade_carga;descricao");
            for (Transporte transporte : todosTransportes){
                pw.println(transporte.geraResumo());
            }
        }
        catch(Exception e){System.out.println("Erro encontrado: " + e);}
    }

    public Transporte pesquisaID(int id){
        for(Transporte t: todosTransportes){
            if(t.getIdentificador()==id)return t;
        }
        return null;
    }
    public ArrayList<Transporte> getTodosTransportes() {
        return todosTransportes;
    }

    public Queue<Transporte> getTransportesPendentes() {
        return transportesPendentes;
    }
}
