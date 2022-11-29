package formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadEN {
    GUI gui;
    private JButton subluzButton;
    private JButton FTLButton;
    private JButton voltarButton;
    private JPanel panel;

    public FormCadEN(GUI gui) {
        this.gui=gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        FTLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(11);
            }
        });
        subluzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(12);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
