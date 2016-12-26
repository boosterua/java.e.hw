package hw22.ptn_observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tonchief on 12/25/2016.
 */
public class PostOffice {
    private final List<Recipient> recipients;

    public PostOffice() {
        this.recipients = new LinkedList<>();
    }

    public void subscribe(Recipient s) {
        recipients.add(s);
    }

    public void unsubscribe(Recipient s) {
        recipients.remove(s);
    }

    public void shipToRecipient(Magazine m) {
        for (Recipient s : recipients) {
            s.receive(m);
        }
    }
}
