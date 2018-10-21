package lcd.server;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {
        try {
            MailServer server = new MailServer("localhost", 0);
            server.startServer();
            System.out.println("Server em execução.");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
