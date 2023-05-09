public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    //Criador
    public Veiculo (String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    //Setters e getters
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    //Mostrador
    @Override
    public String toString() {
        String texto = placa + " " + marca + " " + modelo + " " + anoFabricacao;
        return texto;
    }
}
