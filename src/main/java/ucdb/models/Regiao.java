package ucdb.models;

/**
 * Created by Junio on 30/08/2015.
 */
public class Regiao {

    private Long idRegiao;
    private String nome;

    public Regiao(){

    }


    public Long getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Long idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId(){
    	return Integer.parseInt(idRegiao.toString());
    }
}
