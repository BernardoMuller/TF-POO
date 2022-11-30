package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.Transporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltEstadoTrans {
    GUI gui;
    private JButton voltarButton;
    private JTextField textField1;
    private JButton mostrarButton;
    private JTextField textField2;
    private JButton alterarButton;
    private JLabel mensagemFinal;
    private JPanel panel;
    private JTextArea textArea1;

    public AltEstadoTrans(GUI gui, ConjuntoTransportes conjuntoTransportes) {
        this.gui=gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(textField1.getText());

                Transporte t=conjuntoTransportes.pesquisaID(id);

               textArea1.setText(t+"");
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(textField1.getText());

                Transporte t=conjuntoTransportes.pesquisaID(id);
                String estado=t.getEstado();
                if(estado.equalsIgnoreCase("cancelado"))mensagemFinal.setText("nao é possivel alterar o estado");
                else if (estado.equalsIgnoreCase("finalizado")) {
                    mensagemFinal.setText("nao é possivel alterar o estado");
                }else {
                    int muda=Integer.parseInt(textField2.getText());
                    switch (muda){
                        case 1: t.setEstado("pendente");
                        break;
                        case 2:t.setEstado("transportando");
                        break;
                        case 3:t.setEstado("cancelado");
                        break;
                        case 4:t.setEstado("finalizado");
                        break;
                        default:mensagemFinal.setText("não é um tipo valido");
                        break;
                    }
                    }
                textArea1.setText(t+"");

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
