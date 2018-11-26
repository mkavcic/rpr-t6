package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class Smjer {
    private SimpleStringProperty smjer=new SimpleStringProperty("");

    public String getSmjer() {
        return smjer.get();
    }

    public SimpleStringProperty smjerProperty() {
        return smjer;
    }

    public void setSmjer(String smjer) {
        this.smjer.set(smjer);
    }

    public Smjer(String smjer) {
        this.smjer =new SimpleStringProperty(smjer);
    }

    @Override
    public String toString() {
        return smjer.get();
    }
}
