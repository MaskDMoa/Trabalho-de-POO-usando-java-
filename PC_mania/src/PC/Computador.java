package PC;

public class Computador {

    private String marca;
    private float preco;
    private MemoriaUSB memoriaUSB;
    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;

    public Computador(){
        this.hardwares = new HardwareBasico[3];
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return this.preco;
    }

    public void addHardware(String nome, float capacidade, int index) {
        if(index >= 0 && index < hardwares.length) {
            hardwares[index] = new HardwareBasico(nome, capacidade);
        }
    }


    public void setSistemaOperacional(String nome, int tipo){
        sistemaOperacional = new SistemaOperacional();

        sistemaOperacional.setNome(nome);
        sistemaOperacional.setTipo(tipo);
    }

    public void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: " + this.preco);
        System.out.println("Hardwares: ");
        for (int i = 0; i < hardwares.length; i++)
        {
         if(hardwares[i].getNome().equals("Memória RAM") || hardwares[i].getNome().equals("HD"))
         {
             if(hardwares[i].getCapacidade()>100) {
                 System.out.println(hardwares[i].getNome() + " com " + hardwares[i].getCapacidade() + "Gb");
             }else{
                 System.out.println(hardwares[i].getNome() + " com " + hardwares[i].getCapacidade() + "Tb");
             }
         }else{
             System.out.println(hardwares[i].getNome() + " (" + hardwares[i].getCapacidade() + " Mhz)");
         }
        }
        System.out.println("Sistema Operacional: " + this.sistemaOperacional.getNome() + " (" + this.sistemaOperacional.getTipo() + " bits)");
        System.out.println("Acompanha um " + this.memoriaUSB.getNome() + " de " + this.memoriaUSB.getCapacidade());

    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoriaUSB = musb;
    }

}
