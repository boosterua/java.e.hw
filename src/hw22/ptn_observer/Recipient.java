package hw22.ptn_observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by tonchief on 12/24/2016.
 *
 */
public class Recipient {

    private final String name;
    private final List<Magazine> ownedMagazines;

    public Recipient(String name) {
        this.name = name;
        this.ownedMagazines = new ArrayList<>();
    }

    public void receive(Magazine m) {                                                                                                               //        Objects.requireNonNull(m);
        ownedMagazines.add(m);
    }

    public List<Magazine> getOwnedMagazines() {
        return new ArrayList<>(ownedMagazines);
    }
}


