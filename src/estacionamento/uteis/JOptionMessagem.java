
package estacionamento.uteis;

import javax.swing.JOptionPane;

public class JOptionMessagem {

    public static void dialog(String titulo, String mesagem){
        JOptionPane.showMessageDialog(null, mesagem, titulo, JOptionPane.DEFAULT_OPTION);
    }
    
}
