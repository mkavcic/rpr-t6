package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller {
    private SmjerModel model2;
    private MjestoRodjenjaModel model1;
    private CiklusModel model3;
    private GodinaModel model4;
    private StatusModel model5;
    public ChoiceBox<Ciklus> izborCiklusa;
    public ComboBox<MjestoRodjenja> izborMjesta;
    public ChoiceBox<Smjer> izborSmjera;
    public ChoiceBox<Godina> izborGodine;
    public ChoiceBox<Status> izborStatusa;

    public TextField ime;
    public TextField prezime;
    public TextField indeks;
    public TextField jmbg;


    public Controller(MjestoRodjenjaModel model, SmjerModel model3, CiklusModel ciklusModel, GodinaModel godinaModel, StatusModel statusModel) {
        this.model1 = model;
        this.model2 = model3;
        this.model3=ciklusModel;
        this.model4=godinaModel;
        this.model5=statusModel;
    }

    private boolean validnoImePrezime(String n){
        if(n==null) return false;
        if(n.length()<2 || n.length()>20) return false;
        for(int i=0; i<n.length(); i++){
            if((n.charAt(i)<'A' || n.charAt(i)>'Ž') && (n.charAt(i)<'a' || n.charAt(i)>'ž')) return false;
        }
        return true;
    }

    private boolean validanIndeks(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9') || n==null || n.charAt(0) == '0') return false;
        }
        if(n.length() != 5) return false;
        return true;
    }

    @FXML
    public void initialize(){
        izborMjesta.setItems(model1.getMjesta());
        izborSmjera.setItems(model2.getSmjerovi());
        izborCiklusa.setItems(model3.getCiklusi());
        izborGodine.setItems(model4.getGodine());
        izborStatusa.setItems(model5.getStatusi());

        ime.getStyleClass().add("poljeNijeIspravno");
        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        indeks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indeks.getStyleClass().removeAll("poljeNijeIspravno");
                    indeks.getStyleClass().add("poljeIspravno");
                } else {
                    indeks.getStyleClass().removeAll("poljeIspravno");
                    indeks.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

    }

}
