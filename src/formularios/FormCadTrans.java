package formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadTrans {
    GUI gui;
    private JButton pessoasButton;
    private JButton materialButton;
    private JButton voltarButton;
    private JPanel panel;

    public FormCadTrans(GUI gui) {
        this.gui=gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        pessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(13);
            }
        });
        materialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(14);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
