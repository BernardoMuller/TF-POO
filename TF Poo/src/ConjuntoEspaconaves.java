package src;

import java.util.ArrayList;

public class ConjuntoEspaconaves {

    private ArrayList<Espaconave> garagem;

    public ConjuntoEspaconaves() {
        garagem= new ArrayList<>();
    }

    public boolean cadastraNave(Espaconave nave) {
        for (Espaconave jato : garagem) {
            if (jato.getNome().equalsIgnoreCase(nave.getNome())) {
                return false;
            }
        }
        garagem.add(nave);
        return true;
    }
}
