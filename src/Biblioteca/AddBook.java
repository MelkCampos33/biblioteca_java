package Biblioteca;
import java.util.Scanner;

public class AddBook implements IOOperation{

    public void operacaoInterface(Database database_interface, User usuario_interface) {

        Scanner input = new Scanner(System.in); // leitor de variaveis

        Book livro = new Book(); // criando um novo livro


        // Registrando Livro

        System.out.println("\n");
        System.out.println(" ---------------  REGISTRO DE LIVROS --------------- ");

        System.out.println("Nome do livro: ");
        livro.setNome(input.next());

        System.out.println("Nome do autor: ");
        livro.setAutor(input.next());

       System.out.println("Editora de lançamento: ");
        livro.setEditora(input.next());

        System.out.println("Endereço de coleção de livros: ");
        livro.setLocalColeta(input.next());

        System.out.println("Copias disponiveis para venda: ");
        livro.setCopiasVenda(input.nextInt());



        System.out.println("Preço: ");
        livro.setPreco(input.nextDouble());

        System.out.println("Copias disponiveis para alugar: ");
        livro.setCopiasAluguel(input.nextInt());

        database_interface.AddBook(livro);

        System.out.println("Livro adicionado com sucesso a lista de registros!");
    }
}
