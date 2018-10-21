package lcd.client;

import lcd.mail.Mail;
import lcd.mail.Message;
import lcd.mail.User;

import java.io.Console;
import java.rmi.RemoteException;
import java.text.ParseException;

public class ConsoleClient {

    private static final String[] avaliableCommands = {
            "EXIT",
            "LIST",
            "registerUser",
            "getMessage",
            "getMessagesNumber",
            "sendMessage"
    };

    private Console console;
    private Mail server;

    public ConsoleClient(Mail server) {
        this.console = System.console();
        this.server = server;
    }

    public void startConsole() {
        String command = "";
        boolean checkcmd;

        while (command.equals("EXIT")) {
            console.printf(">>> ");
            command = console.readLine();

            checkcmd = false;
            for (String cmd : avaliableCommands) {
                if (cmd.equals(command)) {
                    checkcmd = true;
                    break;
                }
            }

            if (checkcmd) {
                switch (command) {
                    case "EXIT":
                        continue;
                    case "LIST":
                        execList();
                        break;
                    case "registerUser":
                        execRegisterUser();
                        break;
                    case "getMessage":
                        execGetMessage();
                        break;
                    case "getMessagesNumber":
                        execGetMessagesNumber();
                        break;
                    case "sendMessage":
                        execSendMessage();
                        break;
                }
            }
            else {
                console.printf("Commando inválido.\n");
            }
        }

    }

    private void execList() {
        for (String cmd : avaliableCommands) {
            console.printf("%s\n", cmd);
        }
    }

    private void execRegisterUser() {
        String username = console.readLine("username: ");
        String password = new String(console.readPassword("password: "));

        try {
            server.registerUser(new User(username, password));
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void execGetMessage() {
        String username = console.readLine("username: ");
        String password = new String(console.readPassword("password: "));
        Message msg = null;

        try {
            msg = server.getMessage(username, password);
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        if (msg != null) {
            console.printf("%s\n", msg);
        }
    }

    private void execGetMessagesNumber() {
        String username = console.readLine("username: ");
        String password = new String(console.readPassword("password: "));
        int num = -1;

        try {
            num = server.getMessagesNumber(username, password);
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        if (num >= 0) {
            console.printf("%d", num);
        }
    }

    private void execSendMessage() {
        String usernameFrom = console.readLine("username: ");
        String password = new String(console.readPassword("password: "));
        String date = console.readLine("data: ");
        String title = console.readLine("título: ");
        String text = console.readLine("texto: ");

        try {
            Message msg = new Message(usernameFrom, date, title, text);
            server.sendMessage(msg, password, usernameFrom);
        }
        catch (ParseException | RemoteException e) {
            e.printStackTrace();
        }
    }

}
