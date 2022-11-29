package formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMostrarDados {
    GUI gui;
    private JPanel panel;
    private JTextArea textArea1;
    private JButton mostrarButton;
    private JButton voltarButton;

    public FormMostrarDados(GUI gui) {
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
