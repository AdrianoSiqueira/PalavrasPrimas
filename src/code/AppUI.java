package code;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppUI extends Application {

    private Label labelResultado;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        App app = new App();
        Dados dados = new Dados();

        TextField fieldPalavra = new TextField();
        fieldPalavra.setTooltip(new Tooltip("Digite uma palavra"));
        fieldPalavra.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                String palavrasPermitidas = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                if (!palavrasPermitidas.contains(String.valueOf(newValue.toCharArray()[newValue.length() - 1]))) {
                    labelResultado.setText("");
                    fieldPalavra.setText(oldValue);
                }
            } catch (Exception ignored) {
            }
        });
        fieldPalavra.setOnAction(event -> {
            String palavra = fieldPalavra.getText();
            fieldPalavra.clear();
            if (!palavra.isEmpty()) {
                app.iniciarDados(palavra, dados);
                labelResultado.setText(dados.formatarResultado());
            }
        });

        labelResultado = new Label();

        StackPane paneResultado = new StackPane(labelResultado);
        paneResultado.getStyleClass().add("pane-resultado");

        GridPane.setConstraints(fieldPalavra, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.NEVER);
        GridPane.setConstraints(paneResultado, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.NEVER);

        GridPane paneFundo = new GridPane();
        paneFundo.getChildren().addAll(fieldPalavra, paneResultado);

        Scene scene = new Scene(paneFundo);
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().addAll("/css/LabelStyle.css", "/css/PaneResultadoStyle.css", "/css/RootStyle.css", "/css/TextFieldStyle.css", "/css/TooltipStyle.css");

        stage.setTitle("Palavras Primas");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}