package server;

import basedados.BaseDados;
import source.Desafio;
import source.DesafioSemLocal;
import source.UserLocal;

public class Main {

    public static BaseDados bd;

    public static void main(String[] args) {
        bd = new BaseDados();
        bd.load();
        bd.add(new DesafioSemLocal(22, new UserLocal("user1", "User 1", 19), "Desafio 1", "", 3));
        Server server = new Server(40000);
        server.start();
    }
}
