package lcd.mail;

import lcd.security.SecurePassword;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable {

    private String username;
    private String passwordHash;
    private byte[] passwordSalt;
    private List<Message> messageList;

    public User(String username, String password) {
        this.username = username;
        this.passwordSalt = SecurePassword.genSalt();
        this.passwordHash = SecurePassword.genSecurePassword(password, passwordSalt);
        this.messageList = new LinkedList();
    }

    public int getMessagesNumber() {
        return messageList.size();
    }

    public Message getOneMessage() {
        if (messageList.isEmpty()) {
            return null;
        }
        else {
            return messageList.remove(0);
        }
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }

    public boolean checkUsername(User user) {
        return this.username.equals(user.username);
    }

    public boolean checkPassword(String password) {
        String passwordHash = SecurePassword.genSecurePassword(password, passwordSalt);
        return this.passwordHash.equals(passwordHash);
    }

}
