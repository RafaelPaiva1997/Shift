package source;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public abstract class Desafio implements Serializable {

    protected int id;
    protected User autor;
    protected String nome;
    protected String descricao;
    protected int dificuldade;
    protected LinkedList<User> usersDesafiados;
    protected LinkedList<User> usersCompletaram;
    protected LinkedList<Pedido> pedidos;

    public Desafio() {
    }

    public Desafio(int id, User autor, String nome, String descricao, int dificuldade) {
        this.id = id;
        this.autor = autor;
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        usersCompletaram = new LinkedList<>();
        pedidos = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public User getAutor() {
        return autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LinkedList<User> getUsersDesafiados() {
        return usersDesafiados;
    }

    public LinkedList<User> getUsersCompletaram() {
        return usersCompletaram;
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public abstract Local getLocal();

    public void setId(int id) {
        this.id = id;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}
