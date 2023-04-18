import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Criando uma seguradora, um clientepf, um clientepj e adicionando-os na seguradora
        Seguradora seguradora1 = new Seguradora("Capina Segura", "(19)99999-5040", "capinasegura@mailcom", "Rua 2 perto do OXXO");
        ClientePF clientepf1 = new ClientePF("Matheus", "Rua", null, "608.662.460-70", "Masculino", "18/02/2023", "Ensino básico","15/07/2004" , "Multi bilhonário");
        ClientePJ clientepj1 = new ClientePJ("Google", "Marte", null, "17.632.785/0001-18", "14/09/1650");
        System.out.println(seguradora1.cadastrarCliente(clientepf1));
        System.out.println(seguradora1.cadastrarCliente(clientepj1));
        System.out.println();

        //Validando o CPF e CNPJ
        System.out.println(clientepf1.validarCPF(clientepf1.getCPF()));
        System.out.println(clientepj1.validarCNPJ(clientepj1.getCNPJ()));

        //Criando e adicionando uma lista de veículos em cada cliente
        ArrayList<Veiculo> listaVeiculos1 = new ArrayList<Veiculo>();
        ArrayList<Veiculo> listaVeiculos2 = new ArrayList<Veiculo>();
        Veiculo carro1 = new Veiculo("ABC-1234", "Toyota", "2", 2001);
        Veiculo carro2 = new Veiculo("DEF-5678", "Fiat", "3", 2002);
        listaVeiculos1.add(carro1);
        listaVeiculos2.add(carro2);
        clientepf1.setListaVeiculos(listaVeiculos1);
        clientepj1.setListaVeiculos(listaVeiculos2);
        System.out.println();

        //Gerando sinistro (necessita entradas do teclado)
        System.out.println(seguradora1.gerarSinistro());
        System.out.println();

        //Usando o toString de cada classe
        System.out.println(seguradora1.toString());
        System.out.println(clientepf1.toString());
        System.out.println(clientepj1.toString());
        System.out.println(clientepf1.getListaVeiculos().get(0).toString());
        System.out.println(seguradora1.getListaSinistros().get(0).toString());
        System.out.println();

        //Usando o listarClientes, tanto para Pf quanto para PJ
        seguradora1.listarClientes("ClientePF");
        seguradora1.listarClientes("ClientePj");
        System.out.println();
        
        //Usando o visualizarSinistro
        seguradora1.visualizarSinistro("608.662.460-70");
        
        //Usando o listarSinistros
        seguradora1.listarSinistros();
        System.out.println();
        
        //Removendo os clientes
        System.out.println(seguradora1.removerCliente("608.662.460-70"));
        System.out.println(seguradora1.removerCliente("17.632.785/0001-18"));
        System.out.println();

        //Método interativo para ver informações da seguradora
        while (true) {
            System.out.println("O que quer saber sobre a seguradora?");
            System.out.println("Nome?");
            System.out.println("Telefone?");
            System.out.println("Email?");
            System.out.println("Endereço?");
            System.out.println("Clientes?");
            System.out.println("Ocorrências?");
            String acao = sc.nextLine();
            if (acao.equals("Nome")) {
                System.out.println("Nosso nome é: " + seguradora1.getNome());
            }
            else if (acao.equals("Telefone")) {
                System.out.println("Nosso telefone é: " + seguradora1.getTelefone());
            }
            else if (acao.equals("Email")) {
                System.out.println("Nosso email é: " + seguradora1.getEmail());
            }
            else if (acao.equals("Endereço")) {
                System.out.println("Nosso endereço é: " + seguradora1.getEndereco());
            }
            else if (acao.equals("Clientes")) {
                System.out.println("Isso é informação confidencial ;)");
            }
            else if (acao.equals("Ocorrências")) {
                System.out.println("Isso é informação confidencial ;)");
            }
            else {
                System.out.println("Desculpa, não te entendi");
            }
            
            System.out.println("Deseja continuar (s/n)?");
            String aux = sc.nextLine();
            if (aux.equals("n")) {
                System.out.println("Até mais!");
                break;
            }
            System.out.println();
        }
    }
}
