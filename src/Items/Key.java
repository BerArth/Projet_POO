package Items;

import java.util.Set;

public class Key extends Item {
    private final Set<Integer> keyParts;

    public Key(Set<Integer> keyParts, String description) {
        super("Key", 4, description);
        this.keyParts = keyParts;
    }

    public Set<Integer> getKeyParts() {
        return keyParts;
    }
}
