package mail;

import java.util.Date;
import java.io.Serializable;


public class Message implements Serializable {

    private String usernameFrom;
    private String title;
    private String text;
    private Date date;
}
