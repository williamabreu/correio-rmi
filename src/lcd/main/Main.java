package lcd.main;

public class Main {
    
    private static void printUsage() {
        System.err.println("Uso: < server | client > <host> <port>");
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
        }
        else {
            String[] hostport = {args[1], args[2]};
            if (args[0].equals("server")) {
                // run server
                lcd.server.Main.main(hostport);
            }
            else if (args[0].equals("client")) {
                // run client
                lcd.client.Main.main(hostport);
            }
            else {
                printUsage();
            }
        }
    }

}
