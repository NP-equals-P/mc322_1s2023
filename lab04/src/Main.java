import java.util.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
    public static void main(String[] args) {
            Veiculo veiculo1 = new Veiculo("AAAA-0000", "fiat", "0", 2004);
            Veiculo veiculo2 = new Veiculo("BBBB-1111", "Ford", "1", 2003);
            ClientePF clienteFisico = new ClientePF("Matheus", "Casa", "267.855.960-25", "Masculino", "12/12/2004", "Basica", "15/07/2004", "Multi-bilionario");
            ClientePJ clienteJuridico = new ClientePJ("McDonalds", "Rua", "72.937.596/0001-61", "12/12/2000", 100);
            Seguradora seguradora = new Seguradora("Carros 2", "19 989898-9898", "carros@gmail.com", "Rua 2");
            listaSeguradoras.add(0, seguradora);
            clienteFisico.adicionarVeiculo(veiculo1);
            clienteJuridico.adicionarVeiculo(veiculo2);

            seguradora.cadastrarCliente(clienteFisico);
            seguradora.gerarSinistro();

            seguradora.cadastrarCliente(clienteJuridico);
            seguradora.gerarSinistro();

            System.out.println();
            seguradora.listarClientes("ClientePF");
            System.out.println();
            seguradora.listarClientes("ClientePJ");
            System.out.println();
            seguradora.visualizarSinistro("267.855.960-25");
            System.out.println();
            seguradora.listarSinistros();
            System.out.println();
            System.out.println(seguradora.calcularReceita());
            System.out.println();

            clienteFisico.setValorSeguro(clienteFisico.calculaScore());
            clienteJuridico.setValorSeguro(clienteJuridico.calculaScore());
            System.out.println(clienteFisico.getValorSeguro());
            System.out.println();
            System.out.println(clienteJuridico.getValorSeguro());

            MenuInterativo();
        }


    //Menu interativo. As escolhas saõ feitas com os números na esquerda de cada comando
    public static void MenuInterativo() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println();
            System.out.println("1 - Cadastro\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair");
            System.out.println();
            double acao = Double.parseDouble(sc.nextLine());
            System.out.println();

            for (MenuOperacoes operacao1 : MenuOperacoes.values()) {
                if (acao == operacao1.getOperacao()) {
                    if (acao == 1.0) {
                        while (true) {
                            System.out.println("1.1 - Cadastrar Cliente PF/PJ\n1.2 - Cadastrar Veiculo\n1.3 - Cadastrar Seguradora\n1.4 - Voltar");
                            System.out.println();
                            acao = Double.parseDouble(sc.nextLine());
                            executarOperacaoDetalhada(acao);
                            break;
                        }
                        break;
                    }
                    else if (acao == 2.0) {
                        while (true) {
                            System.out.println("2.1 - Listar Clientes\n2.2 - Listar Sinistros da Seguradora\n2.3 - Listar Sinistros por Cliente\n2.4 - Listar Veiculos por Cliente\n2.5 - Listar Veiculos por Seguradora\n2.6 - Voltar");
                            System.out.println();
                            acao = Double.parseDouble(sc.nextLine());
                            System.out.println();
                            executarOperacaoDetalhada(acao);
                            break;
                        }
                        break;
                    }
                    else if (acao == 3.0) {
                        while (true) {
                            System.out.println("3.1 - Exluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Voltar");
                            System.out.println();
                            acao = Double.parseDouble(sc.nextLine());
                            System.out.println();
                            executarOperacaoDetalhada(acao);
                            break;
                        }
                        break;
                    }
                    else if (acao == 4) {
                        listaSeguradoras.get(0).gerarSinistro();
                    }
                    else if (acao == 5) {
                        Cliente cliente1 = null;
                        Cliente cliente2 = null;
                        System.out.print("CPF/CNPJ do cliente receptor: ");
                        String codCliente1 = sc.nextLine();
                        System.out.print("CPF/CNPJ do cliente transferidor: ");
                        String codCliente2 = sc.nextLine();

                        for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                            if (cliente instanceof ClientePF) {
                                ClientePF aux = (ClientePF) cliente;
                                if (codCliente1.equals(aux.getCPF())) {
                                    cliente1 = aux;
                                }
                                else if (codCliente2.equals(aux.getCPF())) {
                                    cliente2 = aux;
                                }
                            }
                            else {
                                ClientePJ aux = (ClientePJ) cliente;
                                if (codCliente1.equals(aux.getCNPJ())) {
                                    cliente1 = aux;
                                }
                                else if (codCliente2.equals(aux.getCNPJ())) {
                                    cliente2 = aux;
                                }
                            }
                        }

                        listaSeguradoras.get(0).transferirSeguro(cliente1, cliente2);
                    }
                    else if (acao == 6) {
                        System.out.println("Receita: " + listaSeguradoras.get(0).calcularReceita());
                    }
                    else {
                        System.out.println("Adeus!");
                        flag = false;
                        break;

                    }
                }
            }
            
        }

    }

    //Opera todas as operacoes mais detalhadas do menu interativo
    public static boolean executarOperacaoDetalhada(double operacao) {
        Scanner sc = new Scanner(System.in);
        switch((int) (operacao*10)) {
        //Cadastra cliente CPF ou CNPJ
            case 11:
                System.out.print("CPF/CNPJ do cliente: ");
                String codigoCliente = sc.nextLine();
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("Endereco do cliente: ");
                String endereco = sc.nextLine();
                if (codigoCliente.length() == 14) {
                    if (Validacao.validaCPF(codigoCliente) == false) {
                        System.out.println("CPF invalido");
                        return true;
                    }
                    if (Validacao.validarNome(nome) == false) {
                        System.out.println("Nome invalido");
                        return true;
                    }
                    System.out.print("Genero do cliente: ");
                    String genero = sc.nextLine();
                    System.out.print("Data da licensa do cliente: ");
                    String dataLicensa = sc.nextLine();
                    System.out.print("Nivel de educacao do cliente: ");
                    String educacao = sc.nextLine();
                    System.out.print("Data de nascimento do cliente: ");
                    String dataNascimento = sc.nextLine();
                    if (Validacao.validarIdade(dataNascimento) == false) {
                        System.out.println("O cliente nao tem idade suficiente para dirigir");
                        return true;
                    }
                    System.out.print("Classe economica do cliente: ");
                    String classeEconomica = sc.nextLine();

                    ClientePF cliente = new ClientePF(nome, endereco, codigoCliente, genero, dataLicensa, educacao, dataNascimento, classeEconomica);
                    listaSeguradoras.get(0).cadastrarCliente(cliente);
                }
                else {
                    if (Validacao.validarCNPJ(codigoCliente) == false) {
                        System.out.println("CNPJ invalido");
                        return true;
                    }
                    System.out.print("Data de fundacao: ");
                    String dataFundacao = sc.nextLine();
                    System.out.print("Quantidade de funcionarios: ");
                    int qtdeFuncionarios = Integer.parseInt(sc.nextLine());

                    ClientePJ cliente = new ClientePJ(nome, endereco, codigoCliente, dataFundacao, qtdeFuncionarios);
                    listaSeguradoras.get(0).cadastrarCliente(cliente);
                }
                return true;


            //Cadastra veiculo
            case 12:
                System.out.print("Placa do veiculo: ");
                String placa = sc.nextLine();
                System.out.print("Marca do veiculo: ");
                String marca = sc.nextLine();
                System.out.print("Modelo do veiculo: ");
                String modelo = sc.nextLine();
                System.out.print("Ano de fabricacao: ");
                int anoFabricacao = Integer.parseInt(sc.nextLine());

                Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

                System.out.print("CPF/CNPJ do cliente: ");
                String codCliente = sc.nextLine();

                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    if (cliente instanceof ClientePF) {
                        ClientePF aux = (ClientePF) cliente;
                        if (aux.getCPF().equals(codCliente)) {
                            cliente.getListaVeiculos().add(veiculo);
                            return true;
                        }
                    }
                    else {
                        ClientePJ aux = (ClientePJ) cliente;
                        if (aux.getCNPJ().equals(codCliente)) {
                            cliente.getListaVeiculos().add(veiculo);
                            return true;
                        }
                    }
                }
            
            //Cadastra a seguradora
            case 13:
                System.out.print("Nome da seguradora: ");
                String nome1 = sc.nextLine();
                System.out.print("Telefone da seguradora: ");
                String telefone = sc.nextLine();
                System.out.print("Email da seguradora: ");
                String email = sc.nextLine();
                System.out.print("Endereco da seguradora: ");
                String endereco1 = sc.nextLine();

                Seguradora seguradora = new Seguradora(nome1, telefone, email, endereco1);

                listaSeguradoras.add(seguradora);
                return true;
            
            //Lista clientes (PF primeiro, depois PJ)
            case 21:
                System.out.println("Clientes PF");
                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    if (cliente instanceof ClientePF) {
                        ClientePF aux = (ClientePF) cliente;
                        System.out.println(aux.getCPF());
                    }
                }
                System.out.println();
                System.out.println("Clientes PJ");
                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    if (cliente instanceof ClientePJ) {
                        ClientePJ aux = (ClientePJ) cliente;
                        System.out.println(aux.getCNPJ());
                    }
                }
                return true;

            //Lista os sinistros da seguradora
            case 22:
                for (Sinistro sinistro : listaSeguradoras.get(0).getListaSinistros()) {
                    System.out.println("Codigo do sinistro: " + sinistro.getId() + " (" + sinistro.getCliente().getNome() + ")");
                }

                return true;

            //Lista os sinistros organizados entre os clientes                
            case 23:
                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    System.out.println("Cliente: " + cliente.getNome());
                    for (Sinistro sinistro : listaSeguradoras.get(0).getListaSinistros()) {
                        if (sinistro.getCliente().equals(cliente)) {
                            System.out.println(sinistro.getId());
                        }
                    }
                }
                return true;

                
            //Lista os veiculos organizados entre os clientes  
            case 24:
                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    System.out.println("Cliente: " + cliente.getNome());
                    for (Veiculo veiculo2 : cliente.getListaVeiculos()) {
                        System.out.println(veiculo2.getPlaca());
                    }
                }
                return true;

                
            //Lista todos os veiculos da seguradora
            case 25:
                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    for (Veiculo veiculo2 : cliente.getListaVeiculos()) {
                        System.out.println(veiculo2.getPlaca());
                    }
                }
                return true;

            //Exclui algum cliente
            case 31:
                System.out.print("CPF/CNPJ do cliente");
                String codCliente2 = sc.nextLine();
                for (Cliente cliente2 : listaSeguradoras.get(0).getListaClientes()) {
                    if (cliente2 instanceof ClientePF) {
                        ClientePF aux = (ClientePF) cliente2;
                        if (aux.getCPF() == codCliente2) {
                            listaSeguradoras.get(0).getListaClientes().remove(cliente2);
                            return true;
                        }
                    }
                    else {
                        ClientePJ aux = (ClientePJ) cliente2;
                        if (aux.getCNPJ() == codCliente2) {
                            listaSeguradoras.get(0).getListaClientes().remove(cliente2);
                            return true;
                        }
                    }
                }

            //Exclui algum veiculo
            case 32:
                System.out.print("Placa do carro: ");
                String placa2 = sc.nextLine();
                System.out.print("CPF/CNPJ do dono: ");
                String codCliente3 = sc.nextLine();

                for (Cliente cliente : listaSeguradoras.get(0).getListaClientes()) {
                    if (cliente instanceof ClientePF) {
                        ClientePF aux = (ClientePF) cliente;
                        if (aux.getCPF().equals(codCliente3)) {
                            for (Veiculo veiculo2 : aux.getListaVeiculos()) {
                                if (veiculo2.getPlaca().equals(placa2)) {
                                    aux.getListaVeiculos().remove(veiculo2);
                                    return true;
                                }
                            }
                        }
                    }
                    else {
                        ClientePJ aux = (ClientePJ) cliente;
                        if (aux.getCNPJ().equals(codCliente3)) {
                            for (Veiculo veiculo2 : aux.getListaVeiculos()) {
                                if (veiculo2.getPlaca().equals(placa2)) {
                                    aux.getListaVeiculos().remove(veiculo2);
                                    return true;
                                }
                            }
                        }
                    }
                }

            //Exclui algum sinistro
            case 33:
                System.out.print("Id do Sinistro: ");
                int idSinistro = Integer.parseInt(sc.nextLine());

                for (Sinistro sinistro : listaSeguradoras.get(0).getListaSinistros()) {
                    if (sinistro.getId() == idSinistro) {
                        listaSeguradoras.get(0).getListaSinistros().remove(sinistro);
                        return true;
                    }
                }

            //Volta no menu principal
            case 14:
            case 26:
            case 34:
                return false;

        }
        return false;
    }
}
