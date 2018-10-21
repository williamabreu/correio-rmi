package lcd.main;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Esperado parâmetro: 'server' ou 'client'.");
        }
        else {
            if (args[0].equals("server")) {
                // run server
                lcd.server.Main.main(null);
            }
            else if (args[0].equals("client")) {
                // run client
                lcd.client.Main.main(null);
            }
            else {
                System.err.println("Esperado parâmetro: 'server' ou 'client'.");
            }
        }
    }

}
