package ba.unsa.etf.rpr.tutorijal06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MjestoRodjenjaModel model1=new MjestoRodjenjaModel();
        model1.napuni();
        SmjerModel model2=new SmjerModel();
        model2.napuniSmjer();
        CiklusModel ciklusModel=new CiklusModel();
        ciklusModel.napuniCikluse();
        GodinaModel godinaModel=new GodinaModel();
        godinaModel.napuniGodine();

        FXMLLoader loader = new FXMLLoader((getClass().getResource("upis.fxml")));
        loader.setController(new Controller(model1, model2, ciklusModel, godinaModel));
        Parent root = loader.load();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Upis studenta");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
