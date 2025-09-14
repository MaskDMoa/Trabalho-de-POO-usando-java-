package Comprador;
import PC.Computador;

public class ProcessarPedido {

    private Computador[] computadores;

    public ProcessarPedido(Computador[] computadores) {
        this.computadores = computadores;
        System.out.println("Pedido enviado...");
    }
}