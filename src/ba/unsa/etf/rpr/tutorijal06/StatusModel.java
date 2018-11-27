package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StatusModel {
    private ObservableList<Status> statusi = FXCollections.observableArrayList();
    private ObjectProperty<Status> trenutniStatus = new SimpleObjectProperty<>();

    public Status getTrenutniStatus() {
        return trenutniStatus.get();
    }

    public ObjectProperty<Status> trenutniStatusProperty() {
        return trenutniStatus;
    }

    public void setTrenutniStatus(Status trenutniStatus) {
        this.trenutniStatus.set(trenutniStatus);
    }

    public ObservableList<Status> getStatusi() {
        return statusi;
    }

    void napuniStatuse() {
        statusi.add(new Status("Redovan"));
        statusi.add(new Status("Redovan samofinansirajući"));
    }
}
