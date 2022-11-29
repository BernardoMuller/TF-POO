package src.formularios;

import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPrincipal {
    private GUI gui;
    private JButton carregarDadosButton;
    private JButton cadastrarEspaçonaveButton;
    private JButton designarTransportesButton;
    private JButton alterarEstadoDeTransporteButton;
    private JButton sairButton;
    private JPanel panel;
    private JButton cadastrarEspaçoPortoButton;
    private JButton cadastrarTransporteButton;
    private JButton carregarDadosIniciasButton;
    private JButton salvarDadosButton;
    private JButton consultarTodosTransportesButton;

    public FormPrincipal(GUI gui){
        this.gui=gui;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        cadastrarEspaçoPortoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(2);
            }
        });
        cadastrarEspaçonaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(3);
            }
        });
        cadastrarTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(4);
            }
        });
        alterarEstadoDeTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(5);
            }
        });
        carregarDadosIniciasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(6);
            }
        });
        designarTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(7);
            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(8);
            }
        });
        carregarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(9);
            }
        });
        consultarTodosTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(10);
            }
        });
    }

    public JPanel getPanel(){return panel;}
}
