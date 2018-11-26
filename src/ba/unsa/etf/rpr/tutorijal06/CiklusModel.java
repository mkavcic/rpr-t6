package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CiklusModel {
    private ObservableList<Ciklus> ciklusi = FXCollections.observableArrayList();
    private ObjectProperty<Ciklus> trenutniCiklus = new SimpleObjectProperty<>();

    public Ciklus getTrenutniCiklus() {
        return trenutniCiklus.get();
    }

    public ObjectProperty<Ciklus> trenutniCiklusProperty() {
        return trenutniCiklus;
    }

    public void setTrenutniCiklus(Ciklus trenutniCiklus) {
        this.trenutniCiklus.set(trenutniCiklus);
    }

    public ObservableList<Ciklus> getCiklusi() {
        return ciklusi;
    }

    void napuniCikluse(){
        ciklusi.add(new Ciklus("Prvi ciklus"));
        ciklusi.add(new Ciklus("Drugi ciklus"));
        ciklusi.add(new Ciklus("Treći ciklus"));
    }
}
