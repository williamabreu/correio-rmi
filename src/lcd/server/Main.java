package lcd.server;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        
        try {
            MailServer server = new MailServer(host, port);
            server.startServer();
            System.out.println("Server em execução.");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
