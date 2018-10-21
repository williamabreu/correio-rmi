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

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messageList);
    }

    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }

    public boolean checkPassword(String password) {
        String passwordHash = SecurePassword.genSecurePassword(password, passwordSalt);
        return this.passwordHash.equals(passwordHash);
    }

}
