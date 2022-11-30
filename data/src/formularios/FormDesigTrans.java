package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.Espaconave;
import src.entidades.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

public class FormDesigTrans {
    GUI gui;
    private JPanel panel;
    private JButton designarButton;
    private JTextArea textArea1;
    private JButton voltarButton;

    public FormDesigTrans(GUI gui, ConjuntoTransportes conjuntoTransportes, ConjuntoEspaconaves conjuntoEspaconaves) {
        this.gui = gui;
        designarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Queue<Espaconave> esDisp=conjuntoEspaconaves.getEspaconavesDisponiveis();
                Queue<Transporte> filaTrans=conjuntoTransportes.getTransportesPendentes();
                while (!filaTrans.isEmpty()||!esDisp.isEmpty()){
                    Transporte t=filaTrans.remove();
                    System.out.println(t);
                    Espaconave es=esDisp.remove();
                    System.out.println(es);
                    t.setNave(es);
                    t.setEstado("transportando");
                    textArea1.append(t+"\n\n");
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
