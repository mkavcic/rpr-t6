package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class MjestoRodjenja {
    private SimpleStringProperty mjesto=new SimpleStringProperty("");

    public String getMjesto() {
        return mjesto.get();
    }

    public SimpleStringProperty mjestoProperty() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto.set(mjesto);
    }

    public MjestoRodjenja(String mjesto) {
        this.mjesto = new SimpleStringProperty(mjesto);
    }
    public MjestoRodjenja() {
    }

    @Override
    public String toString(){
        return mjesto.get();
    }
}
