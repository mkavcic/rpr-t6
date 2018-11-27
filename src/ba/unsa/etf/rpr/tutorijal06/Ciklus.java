package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class Ciklus {
    private SimpleStringProperty ciklus = new SimpleStringProperty("");

    public String getCiklus() {
        return ciklus.get();
    }

    public SimpleStringProperty ciklusProperty() {
        return ciklus;
    }

    public void setCiklus(String ciklus) {
        this.ciklus.set(ciklus);
    }

    public Ciklus(String ciklus) {
        this.ciklus = new SimpleStringProperty(ciklus);
    }

    @Override
    public String toString() {
        return ciklus.get();
    }
}
