package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MjestoRodjenjaModel {
    private ObservableList<MjestoRodjenja> mjesta= FXCollections.observableArrayList();
    private ObjectProperty<MjestoRodjenja> trenutnoMjesto = new SimpleObjectProperty<>();


    public void setTrenutnoMjesto(MjestoRodjenja trenutnoMjesto) {
        this.trenutnoMjesto.set(trenutnoMjesto);
    }




    public MjestoRodjenja getTrenutnoMjesto() {
        return trenutnoMjesto.get();
    }

    public ObjectProperty<MjestoRodjenja> trenutnoMjestoProperty() {
        return trenutnoMjesto;
    }


    public ObservableList<MjestoRodjenja> getMjesta() {
        return mjesta;
    }

    void napuni(){
        mjesta.add(new MjestoRodjenja("Sarajevo"));
        mjesta.add(new MjestoRodjenja("Zenica"));
        mjesta.add(new MjestoRodjenja("Kakanj"));
        mjesta.add(new MjestoRodjenja("Visoko"));
    }
}
