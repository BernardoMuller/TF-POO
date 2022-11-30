package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.entidades.EspacoPorto;
import src.subclasses.Subluz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FormCadEN_subluz {
    GUI gui;
    private JPanel panel;
    private JButton voltarButton;
    private JTextField nomeTextField;
    private JTextField epTextField;
    private JTextField vTextField;
    private JTextField combTextField;
    private JButton cadastrarButton;
    private JLabel mensagemFinal;

    public FormCadEN_subluz(GUI gui, ConjuntoPortos conjuntoPortos, ConjuntoEspaconaves conjuntoEspaconaves) {
        this.gui = gui;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(3);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String nome= nomeTextField.getText();
                EspacoPorto espacoPorto=conjuntoPortos.pesquisaPorID(parseInt(epTextField.getText()));
                double velocidade=parseDouble(vTextField.getText());
                if (velocidade<=0||velocidade>=0.3)throw new IllegalArgumentException("numero deve ser entre 0 e 0.3");
                int combustivel=parseInt(combTextField.getText());
                String sCombustivel="nada";
                switch (combustivel){
                    case (1): sCombustivel="nuclear";
                    break;
                    case(2): sCombustivel="ion";
                    break;
                    default: sCombustivel="nada";
                    break;
                }
                    if (espacoPorto==null){mensagemFinal.setText("Não há espaço-porto com esse id");
                    throw new Exception();}
                    if (sCombustivel.equals("nada")){mensagemFinal.setText("Digite 1 ou 2 no combustivel");
                    throw new Exception();}
                Subluz subluz=new Subluz(nome, espacoPorto, velocidade,sCombustivel);
                    if(!conjuntoEspaconaves.cadastraNave(subluz)){
                        mensagemFinal.setText("nome repetido");
                        throw new Exception();
                    };
                    conjuntoEspaconaves.adicionaESDisp(subluz);
                mensagemFinal.setText("concluido");
                }catch (IllegalArgumentException ex){mensagemFinal.setText(ex.getMessage());}
                catch (Exception ex){}
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
