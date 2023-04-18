import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String endereco;
    protected ArrayList<Veiculo> listaVeiculos;

    //Criador
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
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

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    //Mostrador
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size();
        return texto;
    }
}