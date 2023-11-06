package v1.presenters;

import java.util.List;

import v1.application.Services.StudyHamsterService;

public class StudyHamsterPresenter {

    private final StudyHamsterService service = new StudyHamsterService();
    public List<String> getAvailableHamsterNames() {
        return service.getAvailableHamsterNames();
    }

    public String learnCommandHide(String name) {
        return service.educateHamsterCommandHide(name);
    }

    public String learnCommandRoll(String name) {
        return service.educateHamsterCommandRoll(name);
    }

    public String learnCommandSpin(String name) {
        return service.educateHamsterCommandSpin(name);
    }
}
