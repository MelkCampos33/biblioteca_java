package Biblioteca;

// --- adiministrador do sistema ---

import java.util.Scanner;

// A classe "admin" se extende (herda) a classe "User",
// assim podendo ter todas as suas propriedades e métodos
public class Admin extends User{

    public Admin(String nome) {
        super(nome);
        this.operacoes = new IOOperation[] {

            // funções das permitiçoes do cadastro como administrador
                new ViewBook(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }
    public Admin(String nome, String email, String telefone) {

        super(nome, email, telefone);
        this.operacoes = new IOOperation[] {
                new ViewBook(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }

    @Override
    public void menu(Database database, User usuario) {

        System.out.println("Opções do Administrador");

        System.out.println("1. Visualzar Livros");
        System.out.println("2. Adicionar Novo Livro");
        System.out.println("3. Deletar Livro");
        System.out.println("4. Pesquisar Título");
        System.out.println("5. Deletar Todos Registros Existentes");
        System.out.println("6. Visualizar Pedidos");
        System.out.println("7. Sair");

        // leitura de menu
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        this.operacoes[value - 1].operacaoInterface(database, usuario);
        input.close();
    }

    public String toString() {
        return nome + "<n/>" + email + "<n/>" + telefone + "<n/>" + "Admin";
    }
}
