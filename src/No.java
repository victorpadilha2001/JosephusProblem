
public class No {

	Object conteudo;
	No proximo;
	No anterior;
	long id;
	
	public No(Object conteudo) {
		setConteudo(conteudo);
		setProximo(null);
		setAnterior(null);
		setId(0);		
	}
	
	public No(Object conteudo, long id) {
		setConteudo(conteudo);
		setProximo(null);
		setAnterior(null);
		setId(0);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Object getConteudo() {
		return conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}	
}
