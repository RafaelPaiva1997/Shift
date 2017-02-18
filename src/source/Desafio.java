package source;

import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public abstract class Desafio {

    protected int id;
    protected User autor;
    protected String nome;
    protected String descricao;
    protected int dificuldade;
    protected LinkedList<User> usersCompletaram;
    protected LinkedList<Pedido> pedidos;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public abstract LinkedList<User> getUsersDesafiados();

    public abstract Local getLocal();
}
