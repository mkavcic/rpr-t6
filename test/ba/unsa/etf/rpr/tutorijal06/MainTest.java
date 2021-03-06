package ba.unsa.etf.rpr.tutorijal06;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ENTER;
import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
    private TextField telefon;
    private TextField email;

    private ComboBox mjesto;

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

    @Test
    public void jmbgNeispravanTest(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("1514998177172");
        assertEquals("text-input text-field poljeNijeIspravno", jmbg.getStyleClass().toString());
    }

    @Test
    public void telefonTest(FxRobot robot) {
        telefon = robot.lookup("#telefon").queryAs(TextField.class);
        robot.clickOn(telefon);
        robot.write("062206266");
        assertEquals("062206266", telefon.getText());
        assertEquals("text-input text-field poljeIspravno", telefon.getStyleClass().toString());
    }

    @Test
    public void telefonNeispravanTest(FxRobot robot) {
        telefon = robot.lookup("#telefon").queryAs(TextField.class);
        robot.clickOn(telefon);
        robot.write("062.20--66");
        assertEquals("text-input text-field poljeNijeIspravno", telefon.getStyleClass().toString());
    }

    @Test
    public void emailTest(FxRobot robot) {
        email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn(email);
        robot.write("mirnakavcic@gmail.com");
        assertEquals("mirnakavcic@gmail.com", email.getText());
        assertEquals("text-input text-field poljeIspravno", email.getStyleClass().toString());
    }

    @Test
    public void emailNeispravanTest(FxRobot robot) {
        email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn(email);
        robot.write("mirna@");
        assertEquals("text-input text-field poljeNijeIspravno", email.getStyleClass().toString());
    }

}