package v2.domain.kinds;

import v2.domain.base.Entity;
import v2.domain.titles.Title;

import java.util.*;

public class Kind extends Entity<KindId> {
    private final KindName kindName;
    private final HashSet<Title> existsTitles;

    private Kind(KindId id, KindName kindName) {
        super(id);
        this.kindName = kindName;
        this.existsTitles = new HashSet<>();
    }

    public List<Title> getExistsTitles(){
        return existsTitles.stream().toList();
    }

    public void addNewTitle(Title title){
        existsTitles.add(title);
    }

    public String getName(){
        return kindName.toString();
    }
    public static Kind create(String kindName){
        return new Kind(new KindId(UUID.randomUUID()), new KindName(kindName));
    }

}
