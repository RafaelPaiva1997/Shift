package source;

import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public class DesafioComLocal extends Desafio {

    private Local local;

    public DesafioComLocal(int id, User autor, String nome, String descricao, int dificuldade) {
        super(id, autor, nome, descricao, dificuldade);
    }

    @Override
    public Local getLocal() {
        return local;
    }
}
