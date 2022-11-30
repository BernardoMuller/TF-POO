package src.formularios;

import src.GUI;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;
import src.entidades.EspacoPorto;
import src.subclasses.TransporteMaterial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadTrans_materiais {
    GUI gui;
    private JPanel panel;
    private JButton voltaButton;
    private JTextField idTextField;
    private JTextField epOTextField;
    private JTextField epDTextField;
    private JTextField cargaTextField;
    private JTextField descTextField;
    private JButton cadastrarButton;
    private JLabel mensagemFinal;

    public FormCadTrans_materiais(GUI gui, ConjuntoPortos conjuntoPortos, ConjuntoTransportes conjuntoTransportes) {
        this.gui = gui;
        epOTextField.setText("11");
        voltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(4);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
            int id=Integer.parseInt(idTextField.getText());

            EspacoPorto espacoPortoO;


                        int idEPO = Integer.parseInt(epOTextField.getText());
                        espacoPortoO = conjuntoPortos.pesquisaPorID(idEPO);



            EspacoPorto espacoPortoD= conjuntoPortos.pesquisaPorID(Integer.parseInt(epDTextField.getText()));

            double carga=Double.parseDouble(cargaTextField.getText());

            String descricao= descTextField.getText();
                if (espacoPortoO==null){mensagemFinal.setText("Não há espaço-porto com esse id (Espaço-porto origem)");
                    throw new IllegalArgumentException();}
                if (espacoPortoD==null){mensagemFinal.setText("Não há espaço-porto com esse id (Espaço-porto destino)");
                    throw new IllegalArgumentException();}

            TransporteMaterial transporteMaterial=new TransporteMaterial(id,espacoPortoO,espacoPortoD,carga,descricao);

                if(!conjuntoTransportes.cadastraEspacoTransporte(transporteMaterial)) throw new IllegalArgumentException("id de transporte repetido");

            }catch (IllegalArgumentException ex){mensagemFinal.setText("erro"+ex.getMessage());}
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
