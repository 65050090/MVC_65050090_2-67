import java.util.*;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public List<String[]> getPetList() {
        return model.loadPets();
    }
}
