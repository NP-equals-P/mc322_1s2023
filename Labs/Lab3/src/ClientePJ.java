import java.util.ArrayList;

public class ClientePJ extends Cliente {
    final private String cnpj;
    private String dataFundacao;

    //Construtor
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj, String dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
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

    //Confirma se o CNPJ do cliente é válido
    public boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");

        if (cnpj.length() != 14) {
            return false;
        }

        long cpfNumerico = Long.parseLong(cnpj);
        long divisor = 11111111111111L;

        if (cpfNumerico % divisor == 0) {
            return false;
        }

        int contador = 0;

        for (int i = 0; i < 12; i += 1) {
            contador += (((11 - i) % 8) + 2) * Character.getNumericValue(cnpj.charAt(i));
        }

        int num = contador % 11;
        if (num < 2 && Character.getNumericValue(cnpj.charAt(12)) != 0) {
            return false;
        }
        else {
            if (11 - num != Character.getNumericValue(cnpj.charAt(12))) {
                return false;
            }
        }

        int contador2 = 0;

        
        for (int i = 0; i < 13; i += 1) {
            contador2 += (((12 - i) % 8) + 2) * Character.getNumericValue(cnpj.charAt(i));
        }

        int num2 = contador2 % 11;
        if (num2 < 2 && Character.getNumericValue(cnpj.charAt(13)) != 0) {
            return false;
        }
        else {
            if (11 - num2 != Character.getNumericValue(cnpj.charAt(13))) {
                return false;
            }
        }
        return true;
    }

    //Mostrador
    public String toString() {
        String texto = nome + " " + endereco + " " + listaVeiculos.size() + " " + cnpj + " " + dataFundacao;
        return texto;
    }
}
