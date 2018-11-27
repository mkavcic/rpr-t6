package ba.unsa.etf.rpr.tutorijal06;

import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class MainTest {
    private TextField ime;
    private TextField prezime;
    private TextField jmbg;

    @Start
    public void start(Stage stage) throws Exception {
        MjestoRodjenjaModel modelMjestaRodjenja = new MjestoRodjenjaModel();
        SmjerModel modelSmjera = new SmjerModel();
        GodinaModel modelGodine = new GodinaModel();
        CiklusModel modelCiklusa = new CiklusModel();
        StatusModel modelStatusa = new StatusModel();
        modelMjestaRodjenja.napuni();
        modelSmjera.napuniSmjer();
        modelGodine.napuniGodine();
        modelCiklusa.napuniCikluse();
        modelStatusa.napuniStatuse();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("upis.fxml"));
        loader.setController(new Controller(modelMjestaRodjenja, modelSmjera, modelCiklusa, modelGodine, modelStatusa));
        Parent mainNode = loader.load();
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void imeTest(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("Mirna");
        assertEquals("Mirna", ime.getText());
    }

    @Test
    public void imeNeispravnoTest(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("M");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void prezimeTest(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("Kavčić");
        assertEquals("Kavčić", prezime.getText());
    }

    @Test
    public void prezimeNeispravnoTest(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("M");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno", prezime.getStyleClass().toString());
    }

    @Test
    public void jmbgTest(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("1504998177172");
        assertEquals("1504998177172", jmbg.getText());
        assertEquals("text-input text-field poljeIspravno", jmbg.getStyleClass().toString());
    }

}