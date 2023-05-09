import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String endereco;
    protected ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    protected double valorSeguro;

    //Criador
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    //Getters e setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    //Adiciona um veiculo a lista de veiculos
    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    //Transfere a lista de veiculos desse cliente para um outro
    public void transferirVeiculos(Cliente cliente) {
        this.getListaVeiculos().addAll(cliente.getListaVeiculos());
        cliente.getListaVeiculos().removeAll(cliente.getListaVeiculos());
    }

    //Calcula e devolve o valor do seguro do cliente
    public double calculaScore() {
        return -1;
    }

    //Mostrador
    @Override
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size();
        return texto;
    }
}