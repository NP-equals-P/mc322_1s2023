import java.util.ArrayList;
import java.util.*;

public class Seguradora  {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();

    //Criador
    public Seguradora (String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //Setters e getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    //Adiciona um novo cliente. Se ele já existir devolve false
    public boolean cadastrarCliente(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            ClientePF aux = (ClientePF) cliente;
            String cod_cliente = aux.getCPF();
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePF) {
                    ClientePF aux_2 = (ClientePF) listaClientes.get(i);
                    if (aux_2.getCPF().equals(cod_cliente)) {
                        return false;
                    }
                }
            }
        }
        else {
            ClientePJ aux = (ClientePJ) cliente;
            String cod_cliente = aux.getCNPJ();
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePJ) {
                    ClientePJ aux_2 = (ClientePJ) listaClientes.get(i);
                    if (aux_2.getCNPJ().equals(cod_cliente)) {
                        return false;
                    }
                }
            }
        }

        listaClientes.add(listaClientes.size(), cliente);
        return true;
    }

    //Remove um cliente. Se ele não existir devolve false
    public boolean removerCliente(String cod_cliente) {
        String new_cod = cod_cliente.replace(".", "");
        new_cod = new_cod.replace("-", "");
        new_cod = new_cod.replace("/", "");
        
        if (new_cod.length() == 11) {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePF) {
                    ClientePF aux = (ClientePF) listaClientes.get(i);
                    if (cod_cliente.equals(aux.getCPF())) {
                        listaClientes.remove(i);
                        return true;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePJ) {
                    ClientePJ aux = (ClientePJ) listaClientes.get(i);
                    if (cod_cliente.equals(aux.getCNPJ())) {
                        listaClientes.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Mostra todos os clientes de um certo tipo
    public void listarClientes(String tipoCliente) {
        if (tipoCliente == "ClientePF") {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePF) {
                    System.out.println(listaClientes.get(i).getNome());
                }
            }
        }
        else {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePJ) {
                    System.out.println(listaClientes.get(i).getNome());
                }
            }
        }
    }

    //Adiciona um novo sinistro. Se o cliente associado não estiver cadastrado ou a placa do carro não for do cliente devolve false
    public boolean gerarSinistro() {
        boolean flag = false;
        boolean flag2 = false;
        Cliente cliente;
        Scanner sc = new Scanner(System.in);
        System.out.print("CPF/CNPJ do cliente: ");
        String cod_cliente = sc.nextLine();
        cod_cliente = cod_cliente.replace("\n", "");
        String new_cod = cod_cliente.replace(".", "");
        new_cod = new_cod.replace("-", "");
        new_cod = new_cod.replace("/", "");
        cliente = null;

        if (new_cod.length() == 11) {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePF) {
                    ClientePF aux = (ClientePF) listaClientes.get(i);
                    if (aux.getCPF().equals(cod_cliente)) {
                        cliente = listaClientes.get(i);
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                sc.close();
                return false;
            }
        }
        else {
            for (int i = 0; i < listaClientes.size(); i += 1) {
                if (listaClientes.get(i) instanceof ClientePJ) {
                    ClientePJ aux = (ClientePJ) listaClientes.get(i);
                    if (aux.getCNPJ().equals(cod_cliente)) {
                        cliente = listaClientes.get(i);
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                sc.close();
                return false;
            }
        }

        System.out.print("Placa do carro: ");
        String placa = sc.nextLine();
        Veiculo veiculo = null;

        for (int i = 0; i < cliente.listaVeiculos.size(); i += 1) {
            if (placa.equals(cliente.listaVeiculos.get(i).getPlaca())) {
                flag2 = true;
                veiculo = cliente.listaVeiculos.get(i);
                break;
            }
        }
        if (flag2 == false) {
            sc.close();
            return false;
        }

        System.out.print("Data do sinistro: ");
        String data = sc.nextLine();
        System.out.print("Endereço do sinistro: ");
        String endereco = sc.nextLine();

        Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        listaSinistros.add(listaSinistros.size(), sinistro);

        return true;
    }

    //Mostra os sinistros de um determinado cliente. Se não houver algum devolve false
    public boolean visualizarSinistro(String cod_cliente) {
        String new_cod = cod_cliente.replace(".", "");
        new_cod = new_cod.replace("-", "");
        new_cod = new_cod.replace("/", "");
        int flag = 0;


        if (new_cod.length() == 11) {
            for (int i = 0; i < listaSinistros.size(); i += 1) {
                if (listaSinistros.get(i).getCliente() instanceof ClientePF) {
                    ClientePF aux = (ClientePF) listaSinistros.get(i).getCliente();
                    if (cod_cliente.equals(aux.getCPF())) {
                        System.out.println("Id: " + listaSinistros.get(i).getId());
                        System.out.println("Data: " + listaSinistros.get(i).getData());
                        System.out.println("Endereço: " + listaSinistros.get(i).getEndereco());
                        System.out.println("Veículo: " + listaSinistros.get(i).getVeiculo());
                        System.out.println();
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                return true;
            }
            return false;
        }
        else {
            for (int i = 0; i < listaSinistros.size(); i += 1) {
                if (listaSinistros.get(i).getCliente() instanceof ClientePJ) {
                    ClientePJ aux = (ClientePJ) listaSinistros.get(i).getCliente();
                    if (cod_cliente.equals(aux.getCNPJ())) {
                        System.out.println("Id: " + listaSinistros.get(i).getId());
                        System.out.println("Data: " + listaSinistros.get(i).getData());
                        System.out.println("Endereço: " + listaSinistros.get(i).getEndereco());
                        System.out.println("Veículo: " + listaSinistros.get(i).getVeiculo());
                        System.out.println();
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                return true;
            }
            return false;
        }
        
    }

    //Mostra o código de todos os sinistros
    public void listarSinistros() {
        for (int i = 0; i < listaSinistros.size(); i+= 1) {
            System.out.println(listaSinistros.get(i).getId());
        }
    }

    //Calcula o valor do seguro de um específico cliente
    public double calcularPrecoSeguroCliente(Cliente cliente) {
        return cliente.calculaScore();
    }

    //Tranfere os veiculos e o seguro de um cliente1 para outro cliente2
    public void transferirSeguro(Cliente cliente1, Cliente cliente2) {
        cliente1.transferirVeiculos(cliente2);
        cliente1.setValorSeguro(cliente1.calculaScore());
        cliente2.setValorSeguro(cliente2.calculaScore());
    }

    //Calcula o valor de todos os seguros de todos os cliente juntos
    public double calcularReceita() {
        int receitaTotal = 0;

        for (int i = 0; i < this.getListaClientes().size(); i += 1) {
            System.out.println(this.getListaClientes().get(i).calculaScore());
            receitaTotal += this.getListaClientes().get(i).calculaScore();
        }

        return receitaTotal;
    }

    //Mostrador
    public String toString() {
        String texto = nome + " " + telefone + " " + email + " " + endereco + " " + listaClientes.size() + " " + listaSinistros.size();
        return texto;
    }
}
