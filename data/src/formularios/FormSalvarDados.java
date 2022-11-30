package src.formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormSalvarDados {
    GUI gui;
    private JButton voltarButton;
    private JTextField textField1;
    private JLabel mensagemFinal;
    private JPanel panel;
    private JButton salvarButton;

    public FormSalvarDados(GUI gui) {
        this.gui = gui;
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
