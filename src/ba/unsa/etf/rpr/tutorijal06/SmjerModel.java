package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SmjerModel {
    private ObservableList<Smjer> smjerovi= FXCollections.observableArrayList();
    private ObjectProperty<Smjer> trenutniSmjer=new SimpleObjectProperty<>();

    public Smjer getTrenutniSmjer() {
        return trenutniSmjer.get();
    }

    public ObjectProperty<Smjer> trenutniSmjerProperty() {
        return trenutniSmjer;
    }

    public void setTrenutniSmjer(Smjer trenutniSmjer) {
        this.trenutniSmjer.set(trenutniSmjer);
    }

    public ObservableList<Smjer> getSmjerovi() {
        return smjerovi;
    }

    void napuniSmjer(){
        smjerovi.add(new Smjer("AIE"));
        smjerovi.add(new Smjer("RI"));
        smjerovi.add(new Smjer("EE"));
        smjerovi.add(new Smjer("TK"));
    }
}
