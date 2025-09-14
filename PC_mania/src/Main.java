import Comprador.ProcessarPedido;
import PC.Computador;
import PC.MemoriaUSB;
import Comprador.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner para ler a variavel de compra
        Scanner sc = new Scanner(System.in);

        MemoriaUSB memoria1 = new MemoriaUSB();
        MemoriaUSB memoria2 = new MemoriaUSB();
        MemoriaUSB memoria3 = new MemoriaUSB();

        // Array com 4 computadores disponivel para venda
        Computador[] computador = new Computador[4];
        // Array para guardar ate 4 compras
        Computador[] comprado = new Computador[4];

        // Cria Cliente
        Cliente cliente = new Cliente("Hiago", "000.000.000-00");

        memoria1.setNome("Pen-drive");
        memoria2.setNome("Pen-drive");
        memoria3.setNome("HD Externo");

        memoria1.setCapacidade(16);
        memoria2.setCapacidade(32);
        memoria3.setCapacidade(1);


        for(int i = 0; i < computador.length; i++){
            computador[i] = new Computador();
        }

        // Definições dos computadores
        // A posição 0 não esta sendo usado, começa no indice 1
        computador[1].setMarca("Apple");
        computador[1].setPreco(2026);
        computador[1].setSistemaOperacional("MacOS Sequoia", 64);
        computador[1].addMemoriaUSB(memoria1);
        computador[1].addHardware("Pentium Core i3", 2200, 0);
        computador[1].addHardware("Memória RAM", 8, 1);
        computador[1].addHardware("HD", 500, 2);

        computador[2].setMarca("Samsung");
        computador[2].setPreco(2026+1234);
        computador[2].setSistemaOperacional("Windows 8", 64);
        computador[2].addMemoriaUSB(memoria2);
        computador[2].addHardware("Pentium Core i5", 3370, 0);
        computador[2].addHardware("Memória RAM", 16, 1);
        computador[2].addHardware("HD", 1, 2);

        computador[3].setMarca("Dell");
        computador[3].setPreco(2026+5678);
        computador[3].setSistemaOperacional("Windows 10", 64);
        computador[3].addMemoriaUSB(memoria3);
        computador[3].addHardware("Pentium Core i7", 4500, 0);
        computador[3].addHardware("Memória RAM", 21, 1);
        computador[3].addHardware("HD", 2, 2);

        // Exibe os computadores a venda, o for pula o indice 0
        for (int i = 1; i < computador.length; i++) {
            Computador comp = computador[i];
            if (comp != null) {
                System.out.println("============================================");
                System.out.println("Modelo: " + comp.getMarca());
                System.out.println("Valor: R$"+ comp.getPreco());
            }
        }

        System.out.println("============================================");

        // Variavel para guardar qual compuatdor foi selecionado
        int compra;

        System.out.println("Digite qual computador que você deseja comprar: ");

        // Indice para a array 'comprado'
        int c = 0;

        // Leitura de numeros ata a pessoa digitar 0
        do{

            compra = sc.nextInt();

            // Switch para saber qual PC foi comprado
            // e adiciona na array comprado
            if(compra >= 0 && compra <= comprado.length) {
                switch (compra) {
                    case 1:
                            comprado[c] = computador[1];
                            c++;
                        break;
                    case 2:
                            comprado[c] = computador[2];
                            c++;
                        break;
                    case 3:
                            comprado[c] = computador[3];
                            c++;
                        break;
                    default:
                        break;
                }
            }
        }while(compra != 0);

        System.out.println("===========================================");

        // Percorre e exibe quais foram os computadores comprados
        for(int i = 0; i < c+1; i++){
            if (comprado[i] != null) {
                System.out.println();
                comprado[i].mostraPCConfigs();
                cliente.setPreco(comprado[i].getPreco());
            }
        }

        System.out.println("==========================================");

        System.out.println("O preço total que você pagara é de " + cliente.calculaTotalCompra() + "R$");

        System.out.println("==========================================");

        System.out.println("Deseja comfirma a compra? (Y/N)");
        String comfirmacao = sc.next();

        if(comfirmacao.equals("Y")){
            Computador[] pedidoFinal = new Computador[c];
            for (int i = 0; i < c; i++) {
                pedidoFinal[i] = comprado[i];
            }
            ProcessarPedido pedido = new ProcessarPedido(pedidoFinal);
        }else{
            System.out.print("Obrigado por usar o programa! ");
        }

        sc.close();
    }
}