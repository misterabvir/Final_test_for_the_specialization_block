package v1.presenters;

import java.util.List;

import v1.application.Services.StudyCamelService;

public class StudyCamelPresenter{

    private final StudyCamelService service = new StudyCamelService();
    public List<String> getAvailableCamelNames() {
        return service.getAvailableCamelNames();
    }

    public String learnCommandWalk(String name) {
        return service.educateCamelCommandWalk(name);
    }

    public String learnCommandCarryLoad(String name) {
        return service.educateCamelCommandCarryLoad(name);
    }

    public String learnCommandSit(String name) {
        return service.educateCamelCommandSit(name);
    }

    public String learnCommandRun(String name) {
        return service.educateCamelCommandRun(name);
    }
}
