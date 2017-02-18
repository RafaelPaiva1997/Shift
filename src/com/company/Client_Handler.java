package com.company;

import source.Desafio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/17/2017.
 */
public class Client_Handler implements Runnable{
    private LinkedList<Desafio> desafios;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag;

    @Override
    public void run() {

    }

    public Client_Handler(Socket socket) {
        try {
            this.socket = socket;
            System.out.print("client arrived = " + socket.getInetAddress());

            ois = new ObjectInputStream(socket.getInputStream());

            String as = (String) ois.readObject();

            //"search Nome paiva Dificuldade 3 Distancia 5"

            String[] array = as.split(" ");

            if(array[0].equals("search")) search(array);
            //else if(array[0].equals("profile")) profile();
            //else if(array[0].equals("anuncios")) anuncios();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void search(String[] array) {
        if (array.length == 1) {
            send(desafios);
        }
        else {
            LinkedList<Desafio> out = new LinkedList();
            for (Desafio e : desafios) {
                flag = false;
                for (int i = 1; i < array.length && !flag; i += 2) {
                    if (array[i].equals("Nome")) {
                        if (!e.getNome().toLowerCase().contains(array[i + 1].toLowerCase())) flag = true;
                    } else if (array[i].equals("Dificuldade")) {
                        if (!(e.getDificuldade() == Integer.parseInt(array[i + 1]))) flag = true;
                    } else if (array[i].equals("Distancia")) {

                    }
                }
                if (!flag) out.add(e);
            }
            send(out);
        }
    }

    public void send(Object object) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receive() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
