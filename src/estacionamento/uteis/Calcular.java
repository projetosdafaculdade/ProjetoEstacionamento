package estacionamento.uteis;

public class Calcular {

    public static long MinutosEmMilisegundos(int minutos) {
        return (minutos * 60000);
    }

    public static long HorasEmMilisegundos(int horas) {
        return (horas * 3600000);
    }

    public static int milisegundosEmMinutos(long milisegundos) {
        return ((int)(milisegundos / 60000));
    }

}
