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
                try {
                    Queue<Espaconave> esDisp = conjuntoEspaconaves.getEspaconavesDisponiveis();
                    Queue<Transporte> filaTrans = conjuntoTransportes.getTransportesPendentes();
                    while (!filaTrans.isEmpty() || !esDisp.isEmpty()) {
                        Transporte t = filaTrans.remove();
                        Espaconave es = esDisp.remove();
                        t.setNave(es);
                        t.setEstado("transportando");
                        textArea1.append(t + "\n\n");
                    }
                }catch(Exception erc){System.out.println(erc);}}
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
