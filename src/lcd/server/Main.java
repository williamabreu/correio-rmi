package lcd.server;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {
        try {
            MailServer server = new MailServer("localhost", 0);
            server.startServer();
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        System.out.println("Server em execução.");
    }

}
