package estacionamento.uteis;

public class Mensagem {

    public static String NENHUM_SERVICO_SELECIONADO = "Por favor, selecione um serviço para continuar!";

    public static String NENHUM_CLIENTE_SELECIONADO = "Por favor, selecione um cliente para continuar!";

    public static String NENHUM_VEICULO_SELECIONADO = "Por favor, selecione um veículo para continuar!";

    public static String VALOR_INVALIDO = "Por favor, digite um valor válido!";

    public static String FRACAO_INVALIDA = "Por favor, digite um valor de fração válido!";

    public static String NENHUMA_ENTRADA_NA_OFICINA_SELECIONADA = "Por favor, selecione uma entrada na oficina para continuar!";

    public static String CAMPO_VAZIO = "Por favor, preencha todos os campos!";

    public static String VALOR_SERVICO(int horas) {
        return "O valor do serviço de " + horas +" horas é:";
    }

    public static String VALOR_SERVICO_FRACAO(int horas, int fracao) {
        return "<html> O valor do serviço de " + horas + " horas<br> e com fração de "+fracao+" minutos é:</html>";
    }
    public static String VALOR_MENOR(double valorServico, double valorPago) {
        return "Valor pago é insuficiente, falta: R$ "+(valorServico-valorPago)+" !";
    }

    public static String RETIRADA_VEICULO(String cliente, String veiculo,double troco) {
        return cliente + " retirou o veículo " + veiculo + " da oficina!"
                + "\nValor do troco: R$ "+troco;
    }
}
