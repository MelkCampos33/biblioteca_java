package Biblioteca;

import Biblioteca.Database;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner input;
    static Database database;

    public static void main(String[] args) {

         database = new Database();

              // Menu inicial do sistema
              System.out.println("\n");
              System.out.println("Seja bem vindo a E-Livroteca: Biblioteca Virtual Multidisciplinar!");

              int opcaoMenu;

             //  do {
                   System.out.println("\n"
                           + " 1. Entrar \n "
                           + "2. Novo Usuário \n"
                           + " 0. Sair do Programa");


                   input = new Scanner(System.in);
                   opcaoMenu = input.nextInt();

                   // opção de entrada de usuario ou criação de um novo

                   switch (opcaoMenu) {

                       case 1: login(); break;
                       case 2: newuser(); break;
                   }

                // enquanto o usuário não digitar o número "0" para sair do sistema
                // ele se mantera aberto
             //  } while (opcaoMenu != 0);
        }

    private static void login() {

        // recebendo e salvando as informações de telfone e email do usuario.

        System.out.println("Informe seu telefone: ");
        String telefone = input.next();

        System.out.println("Informe o e-mail: ");
        String email = input.next();

        // base de dados
        int databaseLogin = database.login(telefone, email);

        if(databaseLogin != -1) {

            User usuario = database.getUser(databaseLogin);
            usuario.menu(database, usuario);

            System.out.println("Seja Bem-Vindo " + usuario.getName() + "!");

         } else {
            System.out.println("Não há registro desse usuário!");
        }
    }

    // cadastrando novo usuáro
    private static void newuser() {

        System.out.println("Informe seu nome: ");
        String nome = input.next();

        System.out.println("Informe o número de telefone: ");
        String telefone = input.next();

        System.out.println("Entre com seu e-mail: ");
        String email = input.next();

        System.out.println(" 1. Admin \n 2. Normal User ");


        int opcao2 = input.nextInt();
        User usuario;

        if(opcao2 == 1) {
            usuario = new Admin(nome, email, telefone);

        } else {
            usuario = new NormalUser(nome, email, telefone);
        }

        database.AddUser(usuario);
        usuario.menu(database, usuario);
    }

}