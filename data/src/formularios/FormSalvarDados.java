package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.EspacoPorto;
import src.entidades.Espaconave;
import src.entidades.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormSalvarDados {
    GUI gui;
    private JButton voltarButton;
    private JTextField textField1;
    private JLabel mensagemFinal;
    private JPanel panel;
    private JButton salvarButton;

    public FormSalvarDados(GUI gui, ConjuntoEspaconaves conjuntoEspaconaves, ConjuntoTransportes conjuntoTransportes, ConjuntoPortos conjuntoPortos) {
        this.gui = gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArquivo = textField1.getText()+".csv";
                Path path = Paths.get(nomeArquivo);
                try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));){
                    pw.println("EspacoPortos");
                    for(EspacoPorto porto : conjuntoPortos.getPortos()){
                        pw.println(porto.geraResumo());
                    }
                    pw.println("/");
                    pw.println("EspacoNaves");
                    for(Espaconave espaco: conjuntoEspaconaves.getGaragem()){
                        pw.println(espaco.geraResumo());
                    }
                    pw.println("/");
                    pw.println("Transportes");
                    for(Transporte transp: conjuntoTransportes.getTodosTransportes()){
                        pw.println(transp.geraResumo());
                    }
                }
                catch(Exception kl){System.out.println("Erro encontrado" + kl);}

            }
            });
        }


    public JPanel getPanel() {
        return panel;
    }
}
