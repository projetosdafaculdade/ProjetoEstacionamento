package estacionamento.uteis;

public class Validacao {

    /**
     * Método para verificar se campo está vazio
     * <br>Retorna true para vazio
     * <br>Retorna false ao contrário!
     *
     * @param campo
     * @return boolean
     */
    public static boolean campoVazio(String campo) {
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
     * @param campo
     * @return boolean
     *
     */
    public static boolean campoVazio(double campo) {
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
     * @param campo
     * @return boolean
     *
     */
    public static boolean campoVazio(Integer campo) {
        if (campo == -1) {
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
     * @param campo
     * @return boolean
     *
     */
    public static boolean campoNumericoVazio(String campo) {
        return campo.replaceAll("[^0-9]", "").length() <= 0;

    }
}
