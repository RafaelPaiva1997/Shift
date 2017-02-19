package server;

import source.Desafio;
import source.Pedido;
import source.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/17/2017.
 */
public class Client_Handler implements Runnable{

    private String input;
    private String[] inputArray;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag;

    @Override
    public void run() {
        scheduler();
    }

    public Client_Handler(Socket socket) {
        this.socket = socket;
    }

    private void scheduler() {
        System.out.println("Waiting");
        input = (String) receive();
        inputArray = input.split(" ");
        if (inputArray[0].equals("Search")) search();
        else if (inputArray[0].equals("Add")) add();
        else if (inputArray[0].equals("Pedido")) pedido();
        else if (inputArray[0].equals("Confirmar")) confirmar();
        //else if (inputArray[0].equals("Profile")) profile();
        //else if (inputArray[0].equals("Anuncios")) anuncios();
    }

    private void add() {
        if (inputArray[1].equals("Desafio")) {
            Desafio desafio = (Desafio) receive();
            Main.bd.add(desafio);
            int id = (int) receive();
            desafio.setAutor((User) Main.bd.get(id));
            int[] ids = (int[]) receive();
            for (User user : (User[]) Main.bd.get(ids)) user.getDesafiosContactos().add(desafio);
        }
    }

    private void pedido() {
        Pedido pedido = (Pedido) receive();
        pedido.getDesafiante().getPedidos().add(pedido);
    }

    private void confirmar() {
        Pedido pedido = (Pedido) receive();
        if (pedido.isDone()) {
            pedido.getDesafio().getUsersCompletaram().add(pedido.getDesafiado());
            pedido.getDesafiado().getDesafiosFeitos().add(pedido.getDesafio());
        }
        pedido.getDesafiante().getPedidos().remove(pedido);
    }

    private void search() {
        System.out.println(Arrays.toString(inputArray));
        if (inputArray.length == 1) {
            send(Main.bd.getDesafios());
        }
        else {
            LinkedList<Desafio> out = new LinkedList();
            for (Desafio e : Main.bd.getDesafios()) {
                flag = true;
                for (int i = 1; i < inputArray.length && flag; i += 2) {
                    if (inputArray[i].equals("Nome")) {
                        if (!e.getNome().toLowerCase().contains(inputArray[i + 1].toLowerCase())) flag = false;
                    } else if (inputArray[i].equals("Dificuldade")) {
                        if (!(e.getDificuldade() == Integer.parseInt(inputArray[i + 1]))) flag = false;
                    } else if (inputArray[i].equals("Id")) {
                        if (!(Integer.toString(e.getId()).contains(inputArray[i + 1]))) flag = false;
                    } else if (inputArray[i].equals("Autor")) {
                        if (!(e.getAutor().getUsarname().toLowerCase().contains(inputArray[i + 1].toLowerCase()))) flag = false;
                    } else if (inputArray[i].equals("Descricao")) {
                        if (!(e.getDescricao().toLowerCase().contains(inputArray[i + 1].toLowerCase()))) flag = false;
                    }
                }
                if (flag) out.add(e);
            }
            send(out);
        }
    }

    public void send(Object object) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receive() {
        Object out = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            out = ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return out;
    }
}
