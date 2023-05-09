public class Validacao {
    //Confirma se o CPF do cliente é valido
    public static boolean validaCPF(String cpf) {
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

    //Confirma se o CNPJ do cliente é válido
    public static boolean validarCNPJ(String cnpj) {
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

    //Confirma se o nome de uma PF é válido
    public static boolean validarNome(String nome) {
        for (int i = 0; i < nome.length(); i += 1) {
            if (Character.isLetter(nome.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    //Confirma se a idade de uma PF é válida
    public static boolean validarIdade(String dataNascimento) {
        int anoNascimento = Integer.parseInt(dataNascimento.substring(6, 10));
        int idade = 2023 - anoNascimento;

        if (idade < 18) {
            return false;
        }

        return true;
    }

}
