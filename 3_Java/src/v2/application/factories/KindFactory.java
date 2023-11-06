package v2.application.factories;

import v2.domain.kinds.Kind;

import java.util.HashSet;

public class KindFactory {
    public static HashSet<Kind> getKinds() {
        HashSet<Kind> kinds = new HashSet<>();
        kinds.add(Kind.create("Pets"));
        kinds.add(Kind.create("Pack Animals"));
        return kinds;
    }

    private KindFactory() {
    }
}
