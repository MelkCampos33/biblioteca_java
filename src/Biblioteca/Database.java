package Biblioteca;

// banco de dados onde sera salvo as informações de usuario e livros registrados

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {


    // Lista de array que ira salvas os nomes de usuarios no sistema
    private ArrayList<User> usuarios = new ArrayList<User>();
    private ArrayList<String> nomeUsuarios = new ArrayList<String>();



    // Arrays de salvamento de informações sobre os livros cadastrados
    private ArrayList<Book> livros = new ArrayList<Book>();
    private ArrayList<String> nomeLivros = new ArrayList<String>();


    private File arquivosUsuario = new File("D:\\Library Management System\\Data\\Users");
    private File arquivosLivro = new File("D:\\Library Management System\\Data\\Books");

    private File pastaArquivos = new File("D:\\Library Management System\\Data");

    public Database() {

        if(!pastaArquivos.exists()) {
            pastaArquivos.mkdirs();
        }

        if(!arquivosUsuario.exists()) {

            try {
                arquivosUsuario.createNewFile();
            } catch (Exception event) {}
        }

        if(!arquivosLivro.exists()) {

            try {
                arquivosLivro.createNewFile();
            } catch (Exception event) {}
        }

      //getUsers();
    }

    // --------------------------------------------------- Construtores do usuario, login e livros --------------------------------------------------------------

    public void AddUser(User adicionarUsuario) {

        usuarios.add(adicionarUsuario);
        nomeUsuarios.add(adicionarUsuario.getName());
        saveUsers();
    }

    public int login(String telefone, String email) {

        int value = -1;

        for(User adicionarUsuario : usuarios) {

            // verificação se o telefone e email de usuario para entrar na conta
            if (adicionarUsuario.getPhoneNumber().matches(telefone) && adicionarUsuario.getEmail().matches(email)) {
                value = usuarios.indexOf(adicionarUsuario);
                break;
            }
        }

        return value;
    }

    public User getUser(int value) {
        return usuarios.get(value);
    }

    public void AddBook(Book novoLivro) {

        livros.add(novoLivro);
        nomeLivros.add(novoLivro.getNome());
        saveBooks();
    }

    private void getUsers() {

        String firstText = "";

        try {
            BufferedReader bufferedReader_1 = new BufferedReader(new FileReader(arquivosUsuario));
            String firstString;

            while ((firstString = bufferedReader_1.readLine()) != null) {
                firstText = firstText + firstString;
            }

                bufferedReader_1.close();

            } catch (Exception event) {
                System.err.println(event.toString());
        }


        // verificação de informaçao de usuario (normal e adm
        //
        // )

        if(!firstText.matches("") || !firstText.isEmpty()) {

            String[] a_1 = firstText.split("<NewUser/>"); // passando a String para array

            for(String s : a_1) {
                String[] a_2 = s.split("<N/>");

                if(a_2[3].matches("Admin")) {

                    User usuario = new Admin(a_2[0], a_2[1], a_2[2]);
                    usuarios.add(usuario);
                    nomeUsuarios.add(usuario.getName());

                } else {

                    User usuario = new NormalUser(a_2[0], a_2[1], a_2[2]);
                    usuarios.add(usuario);
                    nomeUsuarios.add(usuario.getName());

                }
            }
        }
    }

    private void saveUsers() {

        String firstText = "";

        for(User usuario : usuarios) {
            firstText = firstText + usuario.toString() + "<NewUser/> \n";
        }

        try {
            PrintWriter printwriterValue = new PrintWriter(arquivosUsuario);
            printwriterValue.print(firstText);
            printwriterValue.close();

            System.err.println("Dados Salvos!");

        } catch (Exception event) {

            System.err.println(event.toString());
        }
    }

    private void saveBooks() {

        String firstText = "";

        for(Book livro : livros) {

            firstText = firstText + livro.toString2() + "<NewBook/> \n";
        }

        try {
            PrintWriter printwriterValue = new PrintWriter(arquivosLivro);
            printwriterValue.print(firstText);
            printwriterValue.close();

            System.err.println("Dados Salvos!");

        } catch (Exception event) {

            System.err.println(event.toString());
        }
    }

    private void getBooks() {

        String firstText = "";

        try {
            BufferedReader bufferedReader_1 = new BufferedReader(new FileReader(arquivosLivro));
            String firstString;

            while ((firstString = bufferedReader_1.readLine()) != null) {
                firstText = firstText + firstString;
            }

            bufferedReader_1.close();

        } catch (Exception event) {
            System.err.println(event.toString());
        }

        if(!firstText.matches("") || !firstText.isEmpty()) {
                String[] value1 = firstText.split("<NewBook>");

                for(String stringValue : value1) {
                    Book livro = parseBook(stringValue);
                    livros.add(livro);
                    nomeLivros.add(livro.getNome());
                }
            }
        }

        public Book parseBook(String stringValue) {

            // transformando a string em um array
            String[] value = stringValue.split("<N/>");

            Book livro = new Book();

            livro.setNome(value[0]);
            livro.setAutor(value[1]);
            livro.setEditora(value[2]);
            livro.setLocalColeta(value[3]);

            livro.setCopiasVenda(Integer.parseInt(value[4]));
            livro.setPreco(Double.parseDouble(value[5]));
            livro.setCopiasAluguel(Integer.parseInt(value[6]));

            return livro;
        }
    }







