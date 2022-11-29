package formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltEstadoTrans {
    GUI gui;
    private JButton voltarButton;
    private JTextField textField1;
    private JButton mostrarButton;
    private JTextField textField2;
    private JButton alterarButton;
    private JLabel mensagemFinal;
    private JPanel panel;

    public AltEstadoTrans(GUI gui) {
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
