public class Pessoa {
    // atributos
    private boolean estaVivo;

    // construtor
    public Pessoa(boolean estaVivo) {
        setVivo(estaVivo);
    }

    // setters e getters
    public void setVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public boolean getVivo() {
        return this.estaVivo;
    }
}
