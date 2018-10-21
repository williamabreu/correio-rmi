package lcd.server;

import lcd.mail.Mail;
import lcd.mail.Message;
import lcd.mail.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class MailServer implements Mail {

    private String host;
    private int port;
    private List<User> users;

    public MailServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.users = new LinkedList();
    }

    public void startServer() throws RemoteException {
        // rmiregistry tem que estar executando antes de invocar
        System.setProperty("java.rmi.server.hostname", host);

        // Cria e exporta um objeto remoto
        Mail stub = (Mail) UnicastRemoteObject.exportObject(this, port);

        // Registra o objeto remoto com o registro Java RMI
        Registry registry = LocateRegistry.getRegistry();
        registry.rebind("Mail", stub);
    }

    private User auth(String username, String password) {
        User user = null;
        for (User usr : users) {
            if (usr.checkUsername(username)) {
                if (usr.checkPassword(password)) {
                    user = usr;
                }
                break;
            }
        }

        return user;
    }

    @Override
    public boolean registerUser(User user) throws RemoteException {
        for (User usr : users) {
            if (usr.checkUsername(user)) {
                // nome de usuário já existe, impossível cadastrar
                return false;
            }
        }

        users.add(user);
        return true;
    }

    @Override
    public Message getMessage(String username, String password) throws RemoteException {
        User user = auth(username, password);
        if (user != null) {
            return user.getOneMessage();
        }
        else {
            return null;
        }
    }

    @Override
    public int getMessagesNumber(String username, String password) throws RemoteException {
        User user = auth(username, password);
        if (user != null) {
            return user.getMessagesNumber();
        }
        else {
            return -1;
        }
    }

    @Override
    public boolean sendMessage(Message message, String password, String usernameDestiny) throws RemoteException {
        boolean response = false;
        User user = auth(message.getUsernameFrom(), password);
        if (user != null) {
            User destiny = null;
            for (User usr : users) {
                if (usr.checkUsername(usernameDestiny)) {
                    destiny = usr;
                }
            }
            if (destiny != null) {
                destiny.addMessage(message);
                response = true;
            }
        }

        return response;
    }
}
