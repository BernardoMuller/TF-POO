package src;



import java.awt.*;
import javax.swing.*;

import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;
import src.formularios.*;

public class GUI extends JFrame {
private FormPrincipal formPrincipal;
private FormCadEP formCadEP;
private FormCadEN formCadEN;
private FormCadTrans formCadTrans;
private AltEstadoTrans altEstadoTrans;
private FormDadosIniciais formDadosIniciais;
private FormDesigTrans formDesigTrans;
private FormSalvarDados formSalvarDados;
private FormMostrarDados formMostrarDados;
private FormCarregarDados formCarregarDados;
private FormCadEN_FTL formCadEN_ftl;
private FormCadEN_subluz formCadEN_subluz;
private FormCadTrans_pessoas formCadTrans_pessoas;
private FormCadTrans_materiais formCadTrans_materiais;

private ConjuntoPortos conjuntoPortos=new ConjuntoPortos();
private ConjuntoEspaconaves conjuntoEspaconaves=new ConjuntoEspaconaves();
private ConjuntoTransportes conjuntoTransportes=new ConjuntoTransportes();

    public GUI() {
        super();
        setPreferredSize(new Dimension(800,800));
        conjuntoTransportes.setConj(conjuntoPortos);
        conjuntoEspaconaves.setCj(conjuntoPortos);
        formPrincipal=new FormPrincipal(this);
        formCadEP=new FormCadEP(this,conjuntoPortos);
        formCadEN=new FormCadEN(this);
        formCadTrans=new FormCadTrans(this);
        altEstadoTrans=new AltEstadoTrans(this,conjuntoTransportes);
        formDadosIniciais=new FormDadosIniciais(this,conjuntoPortos,conjuntoEspaconaves,conjuntoTransportes);
        formDesigTrans=new FormDesigTrans(this,conjuntoTransportes,conjuntoEspaconaves);
        formSalvarDados=new FormSalvarDados(this);
        formMostrarDados=new FormMostrarDados(this,conjuntoTransportes);
        formCarregarDados=new FormCarregarDados(this);
        formCadEN_ftl=new FormCadEN_FTL(this,conjuntoPortos,conjuntoEspaconaves);
        formCadEN_subluz=new FormCadEN_subluz(this,conjuntoPortos,conjuntoEspaconaves);
        formCadTrans_pessoas=new FormCadTrans_pessoas(this,conjuntoPortos,conjuntoTransportes);
        formCadTrans_materiais=new FormCadTrans_materiais(this,conjuntoPortos,conjuntoTransportes);
        setContentPane(formPrincipal.getPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1200,800);
        this.setTitle("Transportes Espaciais");
    }

    public void setPanel(int panel){
        switch (panel) {
            case(1):
                setContentPane(formPrincipal.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(2):
                setContentPane(formCadEP.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(3):
                setContentPane(formCadEN.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(4):
                setContentPane(formCadTrans.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(5):
                setContentPane(altEstadoTrans.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(6):

                setContentPane(formDadosIniciais.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(7):setContentPane(formDesigTrans.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(8):setContentPane(formSalvarDados.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(9):setContentPane(formCarregarDados.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(10):setContentPane(formMostrarDados.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(11):setContentPane(formCadEN_ftl.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(12):setContentPane(formCadEN_subluz.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(13):setContentPane(formCadTrans_pessoas.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
            case(14):setContentPane(formCadTrans_materiais.getPanel());
                this.pack();
                this.setSize(800,800);
                break;
        }

    }
}
