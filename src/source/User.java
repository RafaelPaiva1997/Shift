package source;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public abstract class User {

    protected int id;
    protected LinkedList<User> contactos;
    protected LinkedList<Pedido> pedidos;
    protected LinkedList<Desafio> desafiosContactos;
    protected LinkedList<Desafio> desafiosCriados;
    protected LinkedList<Desafio> desafiosFeitos;
    protected LinkedList<Desafio> desafiosFavoritos;
    protected LinkedList<Local> locaisCriados;
    protected LinkedList<Local> locaisFavoritos;

    public int getId() {
        return id;
    }

    public LinkedList<User> getContactos() {
        return contactos;
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public LinkedList<Desafio> getDesafiosContactos() {
        return desafiosContactos;
    }

    public LinkedList<Desafio> getDesafiosCriados() {
        return desafiosCriados;
    }

    public LinkedList<Desafio> getDesafiosFeitos() {
        return desafiosFeitos;
    }

    public LinkedList<Desafio> getDesafiosFavoritos() {
        return desafiosFavoritos;
    }

    public LinkedList<Local> getLocaisCriados() {
        return locaisCriados;
    }

    public LinkedList<Local> getLocaisFavoritos() {
        return locaisFavoritos;
    }
}
