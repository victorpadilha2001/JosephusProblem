import java.util.Random;
import java.util.random.*;


public class ListaDLC {
	private No inicio;
	private No fim;
	
	int tamanho;
	private Random r = new Random(System.currentTimeMillis());
	
	
	public ListaDLC() {
		setInicio(null);
		setFim(null);
		setTamanho(0);
	}


	public No getInicio() {
		return inicio;
	}


	public void setInicio(No inicio) {
		this.inicio = inicio;
	}


	public No getFim() {
		return fim;
	}


	public void setFim(No fim) {
		this.fim = fim;
	}


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public boolean estaVazia() {
		boolean vazia = false;
		if(getInicio()==null) {
			vazia = true;
		}
		return vazia;
	}
	
	public void inserirInicio(Object elemento) {
		No novo = new No(elemento, r.nextLong());
		if(estaVazia()==true) {
			setFim(novo);
		}else {
			getInicio().setAnterior(novo);
		}
		novo.setProximo(getInicio());
		setInicio(novo);
		getFim().setProximo(getInicio());
		getInicio().setAnterior(getFim());
		setTamanho(getTamanho()+1);
	}
	
	public void inserirFim(Object elemento) {
		No novo = new No(elemento, r.nextLong());  

        if( estaVazia() ) {
            setInicio(novo);
        } else {
            getFim().setProximo(novo); //1
            novo.setAnterior(getFim()); //2
        }
        setFim(novo); //3
        getFim().setProximo(getInicio()); // 4
        getInicio().setAnterior(getFim()); //5
		setTamanho(getTamanho()+1);
	}
	
	public No removerInicio() {
        No temp = null;
        if(getInicio() != null && getFim() != null) {
            temp = getInicio();

            if (getInicio() == getFim()) {
                setInicio(null);
                setFim(null);
            } else {
                getFim().setProximo(getInicio().getProximo());
                getInicio().getProximo().setAnterior(getFim()); 
                setInicio(getInicio().getProximo());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        setTamanho(getTamanho()-1);
        return temp;
    }

    public No removerFim() {
        No temp = null;
        if(getFim() != null && getInicio() != null) {
            temp = getFim();

            if(getFim() == getInicio()) {
                setFim(null);
                setInicio(null); 
            }
            else {
                getInicio().setAnterior(getFim().getAnterior());
                setFim(getFim().getAnterior());
                getFim().setProximo(getInicio());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        
        setTamanho(getTamanho()-1);
        return temp;
    }


    public boolean inserirApos(long key, Object elem) {
        No noAtual = getInicio(); 

        while((Long)noAtual.getId() != key) {
            if(noAtual == getFim()) {
                return false; 
            }
            noAtual = noAtual.getProximo(); 
        }
        No novoNo = new No(elem, r.nextLong());

        if(noAtual==getFim()) {
            novoNo.setProximo(getInicio()); 
            setFim(novoNo); 
        }
        else {
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(noAtual);
        noAtual.setProximo(novoNo); 
       
        setTamanho(getTamanho()+1);
        return true; 
    }


    public No remover(long chave) {
        No noAtual = null;
        if(getInicio() != null) {
            noAtual = getInicio();

            while((Long)noAtual.getId() != chave) {
                if(noAtual == getFim()) {
                    return null;                 
                }
                noAtual = noAtual.getProximo(); 
            }

            if(noAtual == getInicio()) {
                noAtual = removerInicio();
            } else if (noAtual == getFim()) {
                noAtual = removerFim();
            }
            else {
                noAtual.getAnterior().setProximo(noAtual.getProximo());
                noAtual.getProximo().setAnterior(noAtual.getAnterior());
            }
            noAtual.setAnterior(null);
            noAtual.setProximo(null);

        }
      
        setTamanho(getTamanho()-1);
        return noAtual;
    }


    public String toString() {
        String s = "[ ";
        No noAtual = getInicio();  // inicia do inicio
        if(noAtual != null) {
            do {   
                s = s + noAtual.toString() + " ";  
                noAtual = noAtual.getProximo();   
            } while(noAtual != getInicio());
        }
        s = s + "]";
        return s;
    }


    public String toStringDoFim() {
        String s = "[ ";
        No noAtual = getFim();  // inicia no fim

        if(noAtual != null) {
            do {
                s = s + noAtual.toString() + " "; 
                noAtual = noAtual.getAnterior(); 
            }while(noAtual != getFim());
        }
        s = s + "]";
        return s;
    }

    public void limparLista() {

        No temp = getInicio();

        while (temp != getFim()) {
            removerFim();
        }

        setInicio(null);
        setFim(null);

    }
	
	
}
