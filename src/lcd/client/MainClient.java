package client;

import mail.Mail;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainClient {

    public static void main(String[] args) {
	    String host = "localhost";

	    try {
            Registry registry = LocateRegistry.getRegistry(host);
            Mail stub = (Mail) registry.lookup("Mail");

//            String response = stub.sayHello();
//            System.out.println("response: " + response);
        }
        catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
