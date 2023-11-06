package v1.presenters;

import v1.application.Services.DetailAnimalService;

public class MainPresenter{
    private final DetailAnimalService service = new DetailAnimalService();

    public String getAnimalDetails(){
        return service.getAnimalDetail();
    }

    public String getAnimalStatistic(){
        return service.getAnimalStatistic();
    }
}
