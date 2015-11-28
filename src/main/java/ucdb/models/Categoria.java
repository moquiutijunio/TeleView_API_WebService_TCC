package ucdb.models;

/**
 * Created by Junio on 30/08/2015.
 */
public class Categoria {

    private Long id;
    private String nome;

    public Categoria(){

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
