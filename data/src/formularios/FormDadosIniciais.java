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
import java.util.ArrayList;

public class FormDadosIniciais {
    GUI gui;
    private JButton voltarButton;
    private JTextField nomeArquivoTextField;
    private JTextArea textArea1;
    private JButton okButton;
    private JLabel mensagemFinal;
    private JPanel panel;
    private JTextField textField1;
    private ArrayList<EspacoPorto> listaEspacoporto;
    private ArrayList<Espaconave> listaEspaconave;
    private ArrayList<Transporte> listaTransporte;
    public FormDadosIniciais(GUI gui, ConjuntoPortos conjuntoPortos, ConjuntoEspaconaves conjuntoEspaconaves, ConjuntoTransportes conjuntoTransportes) {
        this.gui=gui;
        listaEspacoporto=conjuntoPortos.getPortos();
        listaEspaconave=conjuntoEspaconaves.getGaragem();
        listaTransporte=conjuntoTransportes.getTodosTransportes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo=textField1.getText();
                textArea1.setText("");
                switch (tipo){
                    case "espacoporto":
                        String nomearquivo= nomeArquivoTextField.getText()+".dat";
                        conjuntoPortos.leArquivoPorto(nomearquivo);
                        for (EspacoPorto ep:
                             listaEspacoporto) {
                            textArea1.append(ep + "\n\n");
                        }
                        break;
                    case "espaconave":
                        String nomearquivo2= nomeArquivoTextField.getText()+".dat";
                        conjuntoEspaconaves.leArquivo(nomearquivo2);
                        for (Espaconave es:
                                listaEspaconave) {
                            conjuntoEspaconaves.adicionaESDisp(es);
                            textArea1.append(es + "\n\n");
                        }
                    break;
                    case "transporte":
                        String nomearquivo3= nomeArquivoTextField.getText()+".dat";
                        conjuntoTransportes.leArquivoTransporte(nomearquivo3);
                        for (Transporte t:
                                listaTransporte) {
                            textArea1.append(t + "\n\n");
                        }
                        break;
                    default: textArea1.setText("não é um tipo válido");
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
