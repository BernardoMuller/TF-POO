package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.entidades.EspacoPorto;
import src.subclasses.FTL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class FormCadEN_FTL {
    GUI gui;
    private JPanel panel;
    private JButton voltarButton;
    private JTextField cargaMaxTextField;
    private JTextField vMaxTextField;
    private JTextField epTextField;
    private JTextField nomeTextField;
    private JButton cadastrarButton;
    private JLabel mensagemFinal;

    public FormCadEN_FTL(GUI gui, ConjuntoPortos conjuntoPortos, ConjuntoEspaconaves conjuntoEspaconaves) {
        this.gui = gui;
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeTextField.getText();
                    EspacoPorto espacoPorto = conjuntoPortos.pesquisaPorID(parseInt(epTextField.getText()));

                    double velocidadeMax = parseDouble(vMaxTextField.getText());

                    int cargaMax = parseInt(cargaMaxTextField.getText());

                    if (espacoPorto==null){mensagemFinal.setText("Não há espaço-porto com esse id");
                        throw new Exception();}
                    FTL ftl = new FTL(nome, espacoPorto, velocidadeMax, cargaMax);
                    if(!conjuntoEspaconaves.cadastraNave(ftl))throw new RuntimeException("nome repetido");
                    mensagemFinal.setText("cadastro concluido");
                }catch (RuntimeException ex){mensagemFinal.setText(ex.getMessage());}
                catch(Exception ex){mensagemFinal.setText("erro"+ex);}

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(3);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
