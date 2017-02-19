package source;

import java.io.Serializable;

/**
 * Created by Paivex on 2/18/2017.
 */
public class Pedido implements Serializable {

    private Desafio desafio;
    private User desafiante;
    private User desafiado;
    private boolean done;

    public Pedido() {
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public User getDesafiante() {
        return desafiante;
    }

    public User getDesafiado() {
        return desafiado;
    }

    public boolean isDone() {
        return done;
    }
}
