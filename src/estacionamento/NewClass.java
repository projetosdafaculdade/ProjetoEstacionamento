package estacionamento;

import static sun.util.calendar.CalendarUtils.mod;

public class NewClass {

    public static void main(String[] args) {
        long dez = 6000;
        long tres = 4000;
        int dezInt = (int) (dez / 1000);
        int tresInt = (int) (tres / 1000);
        
        System.out.println(mod(dez, tres));
        System.out.println((int) dez / tres);
    }

    public NewClass() {
    }

}
