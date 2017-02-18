package source;

import java.util.LinkedList;

/**
 * Created by Paivex on 2/18/2017.
 */
public class DesafioPrivado extends Desafio {

    private LinkedList<User> usersDesafiados;

    @Override
    public LinkedList<User> getUsersDesafiados() {
        return usersDesafiados;
    }

    @Override
    public Local getLocal() {
        return null;
    }
}
