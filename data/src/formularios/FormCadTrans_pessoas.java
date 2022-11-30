package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.EspacoPorto;
import src.subclasses.TransporteMaterial;
import src.subclasses.TransportePessoas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadTrans_pessoas {
    GUI gui;
    private JPanel panel;
    private JButton voltarButton;
    private JTextField idTextField;
    private JTextField epOTextField;
    private JTextField epDTextField;
    private JTextField pessoasTextField;
    private JButton cadastrarButton;
    private JLabel mensagemFinal;

    public FormCadTrans_pessoas(GUI gui, ConjuntoPortos conjuntoPortos, ConjuntoTransportes conjuntoTransportes) {
        this.gui = gui;
        epOTextField.setText("11");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(4);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    EspacoPorto espacoPortoO;

                    int id=Integer.parseInt(idTextField.getText());


                    int idEPO = Integer.parseInt(epOTextField.getText());
                    espacoPortoO = conjuntoPortos.pesquisaPorID(idEPO);

                    EspacoPorto espacoPortoD= conjuntoPortos.pesquisaPorID(Integer.parseInt(epDTextField.getText()));

                    int qtdPessoas=Integer.parseInt(pessoasTextField.getText());

                    System.out.println(id);
                    System.out.println(espacoPortoO);
                    System.out.println(espacoPortoD);
                    System.out.println(qtdPessoas);

                    if (espacoPortoO==null){mensagemFinal.setText("Não há espaço-porto com esse id (Espaço-porto origem)");
                        throw new IllegalArgumentException();}
                    if (espacoPortoD==null){mensagemFinal.setText("Não há espaço-porto com esse id (Espaço-porto destino)");
                        throw new IllegalArgumentException();}

                    TransportePessoas transportePessoas=new TransportePessoas(id,espacoPortoO,espacoPortoD,qtdPessoas);

                    if(!conjuntoTransportes.cadastraEspacoTransporte(transportePessoas)){
                        mensagemFinal.setText("id de transporte repetido");
                        throw new IllegalArgumentException();
                    }
                    mensagemFinal.setText("concluido");
                }catch (Exception ex){
                    mensagemFinal.setText("erro " + ex);
                }
            }

        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
