public class Sinistro {
    final private int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static int contador = 0;


    //Criador
    public Sinistro (String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = contador;
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        contador += 1;
    }

    //Setters e getters
    public int getId() {
        return id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    //Mostrador
    public String toString() {
        String texto = id + " " + data + " " + endereco + " " + seguradora.getNome() + " " + veiculo.getPlaca() + " ";
        if (cliente instanceof ClientePF) {
            ClientePF aux = (ClientePF) cliente;
            texto = texto + aux.getCPF();
        }
        else {
            ClientePJ aux = (ClientePJ) cliente;
            texto = texto + aux.getCNPJ();
        }
        return texto;
    }
}
