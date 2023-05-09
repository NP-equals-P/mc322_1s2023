public class ClientePJ extends Cliente {
    final private String cnpj;
    private String dataFundacao;
    private int qtdeFuncionarios;

    //Construtor
    public ClientePJ(String nome, String endereco, String cnpj, String dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //Getters e setters
    public String getCNPJ() {
        return cnpj;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getDaraFundacao() {
        return dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    //Calcula e devolve o valor do seguro do cliente
    @Override
    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getConstante() * (1 + (this.getQtdeFuncionarios()/100)) * this.getListaVeiculos().size();
    }

    //Mostrador
    @Override
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size() + " " + cnpj + " " + dataFundacao;
        return texto;
    }
}
