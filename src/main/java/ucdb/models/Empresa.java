package ucdb.models;

/**
 * Created by Junio on 30/08/2015.
 */
public class Empresa {

    private Regiao regiao;
    private Categoria categoria;
    private Long id;
    private String nome;
    private String endereco;
    private Integer numero;
    private String telefone;
    private String atendimentoSegSex;
    private String atendimentoSabado;
    private String atendimentoDoming;
    private Bairro bairro;

    public Empresa(){

    }

    public Regiao getRegiao() { return regiao; }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return Integer.parseInt(id.toString());
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAtendimentoSegSex() {
        return atendimentoSegSex;
    }

    public void setAtendimentoSegSex(String atendimentoSegSex) { 
    	this.atendimentoSegSex = atendimentoSegSex; 
    }

    public String getAtendimentoSabado() { 
    	return atendimentoSabado; 
    }

    public String getAtendimentoDoming() { 
    	return atendimentoDoming; 
    }

    public void setAtendimentoSabado(String atendimentoSabado) { 
    	this.atendimentoSabado = atendimentoSabado; 
    }

    public void setAtendimentoDoming(String atendimentoDoming) { 
    	this.atendimentoDoming = atendimentoDoming; 
    }

    public Bairro getBairro() {
    	return bairro; 
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

}
