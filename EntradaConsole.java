import java.util.Scanner;

public class EntradaConsole {
    // atributos
    private Scanner scanner = new Scanner(System.in);
    private int opcao;

    // construtores
    public EntradaConsole() {

    }

    // métodos
    public int lerOpcao() {
        System.out.print("\n");
        System.out.println("1- Iniciar simulacao");
        System.out.println("2- ");

        return opcao;
    }
}
