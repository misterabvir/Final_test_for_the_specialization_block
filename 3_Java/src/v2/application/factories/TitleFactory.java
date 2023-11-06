package v2.application.factories;

import v2.domain.kinds.Kind;
import v2.domain.titles.Title;

import java.util.HashSet;

public class TitleFactory {

    public static HashSet<Title> getTitles(HashSet<Kind> kinds) {
        HashSet<Title> titles = new HashSet<>();
        titles.add(Title.create("Dog", SearchService.getKindByName("Pets", kinds)));
        titles.add(Title.create("Cat", SearchService.getKindByName("Pets", kinds)));
        titles.add(Title.create("Hamster", SearchService.getKindByName("Pets", kinds)));
        titles.add(Title.create("Horse", SearchService.getKindByName("Pack Animals", kinds)));
        titles.add(Title.create("Camel", SearchService.getKindByName("Pack Animals", kinds)));
        titles.add(Title.create("Donkey", SearchService.getKindByName("Pack Animals", kinds)));
        return titles;
    }

    private TitleFactory() {
    }
}
