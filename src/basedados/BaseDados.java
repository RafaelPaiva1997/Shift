package basedados;

import source.Desafio;
import source.Local;
import source.User;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/19/2017.
 */
public class BaseDados {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private LinkedList<Desafio> desafios;
    private LinkedList<User> users;
    private LinkedList<Local> locais;

    public BaseDados() {
        desafios = new LinkedList<>();
        users = new LinkedList<>();
        locais = new LinkedList<>();
    }

    public void load() {
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("basedados.ser")));
            desafios = new LinkedList<>((Collection) ois.readObject());
            users = new LinkedList<>((Collection) ois.readObject());
            locais = new LinkedList<>((Collection) ois.readObject());
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("basedados.ser")));
            oos.writeObject(desafios);
            oos.writeObject(users);
            oos.writeObject(locais);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Desafio e) {
        boolean flag = !desafios.contains(e);
        if (flag) {
             desafios.add(e);
        }
        return flag;
    }

    public boolean add(User e) {
        boolean flag = !users.contains(e);
        if (flag) {
             users.add(e);
        }
        return flag;
    }

    public boolean add(Local e) {
        boolean flag = !locais.contains(e);
        if (flag) {
             locais.add(e);
        }
        return flag;
    }

    public boolean remove(Desafio e) {
        return desafios.remove(e);
    }

    public boolean remove(User e) {
        return users.remove(e);
    }

    public boolean remove(Local e) {
        return locais.remove(e);
    }

    public LinkedList<Desafio> getDesafios() {
        return desafios;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public LinkedList<Local> getLocais() {
        return locais;
    }
}
