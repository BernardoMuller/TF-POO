package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.subclasses.FTL;
import src.subclasses.Subluz;
import src.subclasses.TransporteMaterial;
import src.subclasses.TransportePessoas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FormCarregarDados {
    GUI gui;
    private JButton voltarButton;
    private JTextField nomeArquivo;
    private JPanel panel;
    private JButton carregarButton;

    public FormCarregarDados(GUI gui, ConjuntoEspaconaves conjuntoEspaconaves, ConjuntoTransportes conjuntoTransportes, ConjuntoPortos conjuntoPortos) {
        this.gui = gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path2 = nomeArquivo.getText() + ".csv";
                try(BufferedReader br = new BufferedReader(new FileReader(path2))){
                    String fileContent;
                    br.readLine();
                    for(String linha; !Objects.equals(linha = br.readLine(), "/");){
                        fileContent = linha;
                        String [] fcParts = fileContent.split(";");
                        int idPorto = Integer.parseInt(fcParts[0]);
                        String nomePorto = fcParts[1];
                        double coordX = Double.parseDouble(fcParts[2]);
                        double coordY = Double.parseDouble(fcParts[3]);
                        double coordZ = Double.parseDouble(fcParts[4]);
                        EspacoPorto separator = new EspacoPorto(idPorto,nomePorto,coordX,coordY,coordZ);
                        conjuntoPortos.cadastraEspacoPorto2(separator);
                    }
                    br.readLine();
                    for(String linha; !Objects.equals(linha = br.readLine(), "/");){
                        Scanner tec = new Scanner(linha).useDelimiter(";");

                        String tipo = tec.next();
                        String nome = tec.next();
                        String EP = tec.next();
                        String velocidade = tec.next();
                        String combustivel_limite = tec.next();
                        int id = Integer.parseInt(tipo);
                        int idEP = Integer.parseInt(EP);
                        double v = Double.parseDouble(velocidade);
                        EspacoPorto ep = conjuntoPortos.pesquisaPorID(idEP);
                        if(id==1){
                            Espaconave Sub = new Subluz(nome, ep, v, combustivel_limite);
                            conjuntoEspaconaves.cadastraNave(Sub);
                            conjuntoEspaconaves.adicionaESDisp(Sub);
                            System.out.println(conjuntoEspaconaves.getEspaconavesDisponiveis());
                        }

                        if(id==2){
                            int limite = Integer.parseInt(combustivel_limite);
                            Espaconave FT = new FTL(nome, ep, v, limite);
                            conjuntoEspaconaves.cadastraNave(FT);
                            conjuntoEspaconaves.adicionaESDisp(FT);

                            System.out.println(conjuntoEspaconaves.getEspaconavesDisponiveis());
                        }

                    }
                    br.readLine();
                    for(String linha;(linha = br.readLine()) != null;){
                        fileContent = linha;
                        String [] fcParts = fileContent.split(";");
                        int classificacao = Integer.parseInt(fcParts[0]);
                        if(classificacao == 1){
                            int identificador = Integer.parseInt(fcParts[1]);
                            int origem = Integer.parseInt(fcParts[2]);
                            int destino = Integer.parseInt(fcParts[3]);
                            int quantidadePessoas = Integer.parseInt(fcParts[4]);


                            ArrayList<EspacoPorto> list = conjuntoPortos.getPortos();
                            EspacoPorto origem1 = null;
                            EspacoPorto destino1 = null;

                            for(EspacoPorto porto : list){
                                if(porto.getNumero()==origem){origem1=porto;}
                                if(porto.getNumero()==destino){destino1=porto;}
                            }
                            if(origem1==null || destino1==null){}

                            TransportePessoas tp = new TransportePessoas(identificador,origem1,destino1,quantidadePessoas);
                            conjuntoTransportes.cadastraEspacoTransporte(tp);
                        }
                        else if(classificacao ==2){
                            int identificador = Integer.parseInt(fcParts[1]);
                            int origem = Integer.parseInt(fcParts[2]);
                            int destino = Integer.parseInt(fcParts[3]);
                            double quantidadeCarga = Double.parseDouble(fcParts[4]);
                            String desc = fcParts[5];
                            ArrayList<EspacoPorto> list = conjuntoPortos.getPortos();
                            EspacoPorto origem1 = null;
                            EspacoPorto destino1 = null;

                            for(EspacoPorto porto : list){
                                if(porto.getNumero()==origem){origem1=porto;}
                                if(porto.getNumero()==destino){destino1=porto;}
                            }
                            if(origem1==null || destino1==null){}

                            TransporteMaterial tm = new TransporteMaterial(identificador,origem1,destino1,quantidadeCarga,desc);
                            conjuntoTransportes.cadastraEspacoTransporte(tm);

                    }}

            }catch(Exception excp){System.out.println(excp);}
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
