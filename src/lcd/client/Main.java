package lcd.client;

import lcd.mail.Mail;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Mail stub = (Mail) registry.lookup("Mail");
            ConsoleClient prompt = new ConsoleClient(stub);
            prompt.startConsole();
        }
        catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
