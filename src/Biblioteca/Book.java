package Biblioteca;

public class Book {

    // Dados de registro de livros
    private String nome;
    private  String autor;
    private String editora;
    private String localColeta;
    private String status;
    private int copiasVenda;
    private double preco;
    private int copiasAluguel;

    // construtor
    public Book() {};

    public Book(String nome, String autor, String editora, String localColeta,
                int copiasVenda, double preco, int copiasAluguel) {

        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.localColeta = localColeta;
        this.copiasVenda = copiasVenda;
        this.preco = preco;
        this.copiasAluguel = copiasAluguel;
    }

    public String toString() {

        String textoInformativoLivros = "Nome do livro: " + nome +

                      "Autor: " + autor +
                      "Editora: " + editora +
                      "Endereço: " + localColeta +
                      "Copias para venda: " + String.valueOf(copiasVenda) +
                      "Preço: " + String.valueOf(preco) +
                      "Copias para alugar: " + String.valueOf(copiasAluguel);

        return textoInformativoLivros;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getLocalColeta() {
        return localColeta;
    }

    public void setLocalColeta(String localColeta) {
        this.localColeta = localColeta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCopiasVenda() {
        return copiasVenda;
    }

    public void setCopiasVenda(int copiasVenda) {
        this.copiasVenda = copiasVenda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCopiasAluguel() {
        return copiasAluguel;
    }

    public void setCopiasAluguel(int copiasAluguel) {
        this.copiasAluguel = copiasAluguel;
    }

    public String toString2() {

        String textoInformativoLivros = nome = "<N/>" + autor + "<N/>" + editora + "<N/>" + localColeta + "<N/>" +
        String.valueOf(copiasVenda) + "<N/>" + String.valueOf(preco) + "<N/>" + String.valueOf(copiasAluguel);

        return textoInformativoLivros;
    }
}
