public class ClientePF extends Cliente {
    final private String cpf;
    private String genero;
    private String dataLicenca;
    private String educacao;
    private String dataNascimento;
    private String classeEconomica;

    //Construtor
    public ClientePF(String nome, String endereco, String cpf, String genero, String dataLicenca, String educacao, String dataNascimento, String classeEconomica) {
        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    //Getters e setters
    public String getCPF() {
        return cpf;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setDataLicenca(String dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getDataLicenca() {
        return dataLicenca;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    //Calcula e devolve o valor do seguro do cliente
    @Override
    public double calculaScore() {
        int anoNascimento = Integer.parseInt(this.getDataNascimento().substring(6, 10));
        int idade = 2023 - anoNascimento;
        double fatorIdade;
        if (idade < 30) {
            fatorIdade = CalcSeguro.FATOR_18_30.getConstante();
        }
        else if (idade >= 30 & idade < 60) {
            fatorIdade = CalcSeguro.FATOR_30_60.getConstante();
        }
        else {
            fatorIdade = CalcSeguro.FATOR_60_90.getConstante();
        }

        return CalcSeguro.VALOR_BASE.getConstante() * this.getListaVeiculos().size() * fatorIdade;
    }

    //Mostrador
    @Override
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size() + " " + cpf + " " + genero + " " + dataLicenca + " " + educacao + " " + dataNascimento + " " + classeEconomica;
        return texto;
    }
}