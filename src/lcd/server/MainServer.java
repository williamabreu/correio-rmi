package server;

import mail.Message;
import mail.User;
import mail.Mail;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer implements Mail {    

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Cria e exporta um objeto remoto
            MainServer obj = new MainServer();
            Mail stub = (Mail) UnicastRemoteObject.exportObject(obj, 0);

            // Registra o objeto remoto com o registro Java RMI
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Mail", stub);

            System.out.println("Server Ready");
        }
        catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(User user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getMessage(String username, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMessagesNumber(String username, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendMessage(Message message, String password, String usernameDestiny) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
