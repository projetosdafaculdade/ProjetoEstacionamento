package estacionamento.uteis;

import java.sql.Time;

public class Validacao {

    /**
     * Método para verificar se campo está vazio
     * <br>Retorna true para vazio
     * <br>Retorna false ao contrário!
     *
     * @param obj
     * @return boolean
     */
    public boolean campoVazio(String campo) {
        if (campo.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar se campo está vazio
     * <br>Retorna true para vazio
     * <br>Retorna false ao contrário!
     * <br> valor -1.0 é considerado vazio!
     *
     * @param obj
     * @return boolean
     *
     */
    public boolean campoVazio(double campo) {
        if (campo == -1.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar se campo está vazio
     * <br>Retorna true para vazio
     * <br>Retorna false ao contrário!
     * <br> valor -1.0 é considerado vazio!
     *
     * @param obj
     * @return boolean
     *
     */
    public boolean campoVazio(Integer campo) {
        if (campo == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean horaSaida(Time entrada, Time saida) {
        if (saida.getHours() < entrada.getHours()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean valorPago(double valorConta, double valorPago) {
        if (valorPago < valorConta) {
            return true;
        } else {
            return false;
        }
    }
}
