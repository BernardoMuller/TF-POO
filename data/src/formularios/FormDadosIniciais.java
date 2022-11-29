package src.formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDadosIniciais {
    GUI gui;
    private JButton voltarButton;
    private JTextField nomeArquivoTextField;
    private JTextArea textArea1;
    private JButton okButton;
    private JLabel mensagemFinal;
    private JPanel panel;

    public FormDadosIniciais(GUI gui) {
        this.gui=gui;
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
