package ucdb.models;

/**
 * Created by Junio on 03/10/2015.
 */
public class Bairro {

    private Long id;
    private String nome;

    public Bairro(){

    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId(){
        return Integer.parseInt(id.toString());
    }
}
