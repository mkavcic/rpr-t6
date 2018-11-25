package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class Controller {
    private MjestoRodjenjaModel model1;
    public ComboBox<MjestoRodjenja> izborMjesta;

    public Controller(MjestoRodjenjaModel model) {
        this.model1 = model;
    }

    @FXML
    public void initialize(){
        izborMjesta.setItems(model1.getMjesta());
    }
}
