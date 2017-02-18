package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Paivex on 2/17/2017.
 */
public class Thread {
    private LinkedList<Desafio> desafios;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag;

    public Thread(Socket socket) {
        try {
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
                        if (!e.getNome().contains(array[i + 1]))
                            flag = true; //se o array[i+1] nao estiver contido no nome de e, flag = false
                    } else if (array[i].equals("Dificuldade")) {
                        if (!e.getDificuldade().equals(array[i + 1])) flag = true;
                    } else if (array[i].equals("Distancia")) {

                    }
                }
                if (!flag) out.add(e);
            }
            send(out);
        }
    }
}
