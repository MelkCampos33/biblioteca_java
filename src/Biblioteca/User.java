package Biblioteca;

// declarando os dados que seram exigidos tanto par ao usuario quando o administrador
// a classe USER sera usada como base de extensao para outras classes

public abstract class User {

    protected String nome;
    protected String email;
    protected String telefone;
    protected IOOperation[] operacoes;

    public User() {}

    public User(String nome) {
        this.nome = nome;
    }

    public  User(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public String getName() { return nome; }

    public String getEmail() { return email; }

    public String getPhoneNumber() { return telefone; }

    abstract public String toString();

    abstract public void menu(Database database, User usuario);

}
