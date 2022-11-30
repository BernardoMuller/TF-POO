package src;

import src.conjuntos.ConjuntoEspaconaves;
import src.conjuntos.ConjuntoPortos;
import src.conjuntos.ConjuntoTransportes;

public class ACMESpace {

 public void executa(){
     System.out.println("Teste");
 }
 private static ConjuntoPortos conjuntoPortos = new ConjuntoPortos();
 private static ConjuntoTransportes conjuntoTransportes = new ConjuntoTransportes();
 private static ConjuntoEspaconaves conjuntoEspaconaves = new ConjuntoEspaconaves();


 public static boolean carregaDadosIniciais(){
     try{
        conjuntoPortos.leArquivoPorto("TESTE-espacoportos.dat");
        conjuntoTransportes.leArquivoTransporte("TESTE-transportes.dat");
        conjuntoEspaconaves.leArquivo("TESTE-espaconaves.dat");
        return true;
     }catch(Exception e){System.out.println(e); return false;}

 }







}
