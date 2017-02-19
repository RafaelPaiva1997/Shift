package source;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public class DesafioSemLocal extends Desafio  implements Serializable {

    public DesafioSemLocal() {
    }

    public DesafioSemLocal(int id, User autor, String nome, String descricao, int dificuldade) {
        super(id, autor, nome, descricao, dificuldade);
    }

    @Override
    public Local getLocal() {
        return null;
    }
}
