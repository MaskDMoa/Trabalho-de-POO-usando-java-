package Comprador;

public class Cliente {

    private String nome;
    private String cpf;
    private float preco = 0;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setPreco(float preco) {
        this.preco += preco;
    }

    public float calculaTotalCompra(){
        return this.preco;
    }
}
