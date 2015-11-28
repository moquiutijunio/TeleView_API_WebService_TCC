package ucdb.Util;

import java.util.ArrayList;
import java.util.List;

import ucdb.models.Categoria;


public class GerenciadorCategoria {
	private static List<Categoria> categorias =  new ArrayList<Categoria>(); 
	
	public void salvar(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public void excluir (int posicao){
		categorias.remove(posicao);
	}
	
	public List<Categoria> getCategoria() {
		return categorias;
	}
}
