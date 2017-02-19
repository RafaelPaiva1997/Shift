package source;


import java.io.Serializable;

/**
 * Created by Paivex on 2/18/2017.
 */
public class UserLocal extends User implements Serializable {

    private String usarname;
    private String name;
    private int idade;

    public UserLocal(String usarname, String name, int idade) {
        this.usarname = usarname;
        this.name = name;
        this.idade = idade;
    }

    @Override
    public String getUsarname() {
        return usarname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIdade() {
        return idade;
    }
}
