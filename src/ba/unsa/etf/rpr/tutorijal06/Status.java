package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class Status {
    private SimpleStringProperty status = new SimpleStringProperty();

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public Status(String status) {
        this.status = new SimpleStringProperty(status);
    }

    @Override
    public String toString() {
        return status.get();
    }
}
