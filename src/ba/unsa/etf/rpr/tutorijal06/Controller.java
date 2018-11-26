package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import java.awt.event.ActionEvent;

public class Controller {
    private SmjerModel model2;
    private MjestoRodjenjaModel model1;
    private CiklusModel model3;
    public ChoiceBox<Ciklus> izborCiklusa;
    public ComboBox<MjestoRodjenja> izborMjesta;
    public ChoiceBox<Smjer> izborSmjera;


    public Controller(MjestoRodjenjaModel model,SmjerModel model3, CiklusModel ciklusModel) {
        this.model1 = model;
        this.model2 = model3;
        this.model3=ciklusModel;
    }

    @FXML
    public void initialize(){
        izborMjesta.setItems(model1.getMjesta());
        izborSmjera.setItems(model2.getSmjerovi());
        izborCiklusa.setItems(model3.getCiklusi());
    }
}
