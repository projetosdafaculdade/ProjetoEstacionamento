package estacionamento.uteis;

public class Mensagem {

    public static String NENHUM_SERVICO_SELECIONADO = "Por favor, selecione um serviço para continuar!";

    public static String NENHUM_CLIENTE_SELECIONADO = "Por favor, selecione um cliente para continuar!";

    public static String NENHUM_VEICULO_SELECIONADO = "Por favor, selecione um veículo para continuar!";

    public static String VALOR_INVALIDO = "Por favor, digite um valor válido!";

    public static String FRACAO_INVALIDA = "Por favor, digite um valor de fração válido!";
    public static String CAMPO_VAZIO = "Por favor, preencha todos os campos!";

    public static String RETIRADA_VEICULO(String cliente, String veiculo) {
        return cliente + " retirou o veículo " + veiculo + " da oficina!";
    }
}
