package Biblioteca;

import java.util.Scanner;

// classe para usuario comuns da bibliotexa
public class NormalUser extends User{

    public NormalUser(String nome) {

        super(nome);
        this.operacoes = new IOOperation[] {
          new ViewBook(),
          new Search(),
          new PlaceOrder(),
          new BorrowBook(),
          new CalculateFine(),
          new ReturnBook(),
          new Exit(),
        };
    }
    public NormalUser(String nome, String email, String telefone) {

        super(nome, email, telefone);
        this.operacoes = new IOOperation[] {
                new ViewBook(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit(),
        };
    }

    @Override
    public void menu(Database database, User usuario) {

        System.out.println("Opções do Usuário");

        System.out.println("1. Visualzar Livros");
        System.out.println("2. Pesquisar Título");
        System.out.println("3. Encomendar Livro");
        System.out.println("4. Pegar Livro Emprestado");
        System.out.println("5. Calcular Taxa");
        System.out.println("6. Devolução de Livros");
        System.out.println("7. Sair");

        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        this.operacoes[value - 1].operacaoInterface(database, usuario);
        input.close();
    }

    public String toString() {
        return nome + "<n/>" + email + "<n/>" + telefone + "<n/>" + "Normal";
    }
}
