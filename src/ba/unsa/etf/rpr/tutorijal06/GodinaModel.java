package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GodinaModel {
    private ObservableList<Godina> godine= FXCollections.observableArrayList();
    private ObjectProperty<Godina> trenutnaGodina=new SimpleObjectProperty<>();

    public Godina getTrenutnaGodina() {
        return trenutnaGodina.get();
    }

    public ObjectProperty<Godina> trenutnaGodinaProperty() {
        return trenutnaGodina;
    }

    public void setTrenutnaGodina(Godina trenutnaGodina) {
        this.trenutnaGodina.set(trenutnaGodina);
    }

    public ObservableList<Godina> getGodine() {
        return godine;
    }
    void napuniGodine(){
        godine.add(new Godina("Prva"));
        godine.add(new Godina("Druga"));
        godine.add(new Godina("Treća"));
    }
}
