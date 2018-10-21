package mail;

import java.util.List;
import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private List<Message> messageList;

}
