package lcd.mail;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    private String usernameFrom;
    private String title;
    private String text;
    private Date date;

    public Message(String usernameFrom, String date, String title, String text) throws ParseException {
        this.usernameFrom = usernameFrom;
        this.title = title;
        this.text = text;
        this.date = dateFormatter.parse(date);
    }

    public String getUsernameFrom() {
        return usernameFrom;
    }

    @Override
    public String toString() {
        String out = "";

        out += "De:     " + usernameFrom               + "\n";
        out += "Data:   " + dateFormatter.format(date) + "\n";
        out += "Título: " + title                      + "\n";
        out += "Texto:  " + text;

        return out;
    }

}
