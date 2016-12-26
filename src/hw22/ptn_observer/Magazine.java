package hw22.ptn_observer;

import java.util.Objects;

/**
 * Created by tonchief on 12/25/2016.
 */

public class Magazine {

        private final String name;

        public Magazine(String name) {
            Objects.requireNonNull(name);
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
