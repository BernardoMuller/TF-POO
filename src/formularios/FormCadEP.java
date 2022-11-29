package formularios;

import src.ConjuntoPortos;
import src.EspacoPorto;
import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FormCadEP {
    private GUI gui;

    private JPanel panel;
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JLabel mensagemFinalLabel;
    private JTextField idTextField;
    private JTextField nomeTextField;
    private JTextField coordXTextField;
    private JTextField coordYTextField;
    private JTextField coordZTextField;

    public FormCadEP(GUI gui) {
        this.gui=gui;

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = parseInt(idTextField.getText());
                    String nome = nomeTextField.getText();
                    double coordX = parseDouble(coordXTextField.getText());
                    double coordY = parseDouble(coordYTextField.getText());
                    double coordZ = parseDouble(coordZTextField.getText());

                    EspacoPorto espacoPorto = new EspacoPorto(id, nome, coordX, coordY, coordZ);
                    ConjuntoPortos.cadastraEspacoPorto(espacoPorto);
                }catch(Exception ex){mensagemFinalLabel.setText("erro"+ex);}
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
