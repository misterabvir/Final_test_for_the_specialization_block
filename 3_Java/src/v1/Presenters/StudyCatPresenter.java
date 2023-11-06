package v1.presenters;

import java.util.List;

import v1.application.Services.StudyCatService;

public class StudyCatPresenter{

    private final StudyCatService service = new StudyCatService();
    public List<String> getAvailableCatNames() {
        return service.getAvailableCatNames();
    }

    public String learnCommandSit(String name) {
        return service.educateCatCommandSit(name);
    }

    public String learnCommandPounce(String name) {
        return service.educateCatCommandPounce(name);
    }

    public String learnCommandScratch(String name) {
        return service.educateCatCommandScratch(name);
    }

    public String learnCommandMeow(String name) {
        return service.educateCatCommandMeow(name);
    }

    public String learnCommandJump(String name) {
        return service.educateCatCommandJump(name);
    }
}
