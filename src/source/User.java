package source;

import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public abstract class User {

    protected int id;
    protected LinkedList<Pedido> pedidos;
    protected LinkedList<Desafio> desafiosCriados;
    protected LinkedList<Desafio> desafiosFeitos;
    protected LinkedList<Desafio> desafiosFavoritos;
    protected LinkedList<Local> locaisCriados;
    protected LinkedList<Local> locaisFavoritos;
}
