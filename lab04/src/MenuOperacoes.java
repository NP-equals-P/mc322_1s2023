public enum MenuOperacoes {
    ABRIR_MENU_CADASTRO (1.0),
    CADASTRAR_CLIENTE (1.1),
    CADASTRAR_VEICULO (1.2),
    CADASTRAR_SEGURADORA (1.3),

    ABRIR_MENU_LISTAR (2.0),
    LISTAR_CLIENTES_SEG (2.1),
    LISTAR_SINISTROS_SEG (2.2),
    LISTAR_SINISTROS_CLI (2.3),
    LISTAR_VEICULOS_SEG (2.4),
    LISTAR_VEICULOS_CLI (2.5),

    ABRIR_MENU_EXLUIR (3.0),
    EXCLUIR_CLIENTE (3.1),
    EXCLUIR_VEICULO (3.2),
    EXCLUIR_SINISTRO (3.3),

    GERAR_SINISTRO (4.0),
    TRANSFERIR_SEGURO (5.0),
    CALCULAR_RECEITA_SEGURADORA (6.0),
    VOLTAR (-1.0),
    SAIR (0.0);

    public final double operacao;

    MenuOperacoes (Double operacao) {
        this.operacao = operacao;
    }

    public double getOperacao() {
        return this.operacao;
    }
}
