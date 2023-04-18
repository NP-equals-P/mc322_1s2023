import java.util.ArrayList;

public class ClientePF extends Cliente {
    final private String cpf;
    private String genero;
    private String dataLicenca;
    private String educacao;
    private String dataNascimento;
    private String classeEconomica;

    //Construtor
    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cpf, String genero, String dataLicenca, String educacao, String dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
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

    //Confirma se o CPF do cliente é válido
    public boolean validarCPF(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        if (cpf.length() != 11) {
            return false;
        }

        long cpfNumerico = Long.parseLong(cpf);
        long divisor = 11111111111L;

        if (cpfNumerico % divisor == 0) {
            return false;
        }

        int contador = 0;

        for (int i = 0; i < 9; i += 1) {
			contador += (10 - i) * Character.getNumericValue(cpf.charAt(i));      
		}

		if (contador % 11 == 0 || contador % 11 == 1) {
            if (Character.getNumericValue(cpf.charAt(9)) != 0) {
                return false;
            }
        }
        else if (11 - (contador % 11) != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        int contador_2 = 0;

        
        for (int i = 0; i < 9; i += 1) {
            contador_2 += (10 - i) * Character.getNumericValue(cpf.charAt(i + 1));   
		}
        
		if (contador_2 % 11 == 0 || contador_2 % 11 == 1) {
            if (Character.getNumericValue(cpf.charAt(10)) != 0) {
                return false;
            }
        }
        else if (11 - (contador_2 % 11) != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        return true;
    }

    //Mostrador
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size() + " " + cpf + " " + genero + " " + dataLicenca + " " + educacao + " " + dataNascimento + " " + classeEconomica;
        return texto;
    }
}