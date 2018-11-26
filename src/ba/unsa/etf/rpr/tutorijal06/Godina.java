package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class Godina {
    private SimpleStringProperty godina= new SimpleStringProperty("");

    public String getGodina() {
        return godina.get();
    }

    public SimpleStringProperty godinaProperty() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina.set(godina);
    }

    public Godina(String godina) {
        this.godina =new SimpleStringProperty(godina);
    }
    @Override
    public String toString(){
        return godina.get();
    }
}
