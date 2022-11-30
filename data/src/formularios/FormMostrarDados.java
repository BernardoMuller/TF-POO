package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormMostrarDados {
    GUI gui;
    private JPanel panel;
    private JTextArea textArea1;
    private JButton mostrarButton;
    private JButton voltarButton;

    private ArrayList<Transporte> todosTransportes;

    public FormMostrarDados(GUI gui, ConjuntoTransportes conjuntoTransportes) {
        this.gui = gui;
        todosTransportes=conjuntoTransportes.getTodosTransportes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
            if(todosTransportes.isEmpty())textArea1.setText("Lista Vazia");
            else {
                textArea1.setText("");
                for (Transporte t : todosTransportes) {
                    textArea1.append(t + "\n\n");
                }
            }
            }catch (Exception ex){textArea1.setText("Erro");}
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
