package estacionamento.uteis;

import javax.swing.JTextField;

public class Atualizar {

    public String string(String campo) {
        return campo;
    }

    public static void jTextField(JTextField jTextField) {
        jTextField.transferFocus();
        jTextField.grabFocus();
    }
}
