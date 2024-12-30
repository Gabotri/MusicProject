package musicjava;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JPanel;

public class MusicJava extends Application {

    @Override
    public void start(Stage primaryStage) {
        SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);

        StackPane root = new StackPane();
        root.getChildren().add(swingNode);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("PlayerApp");
        primaryStage.setScene(scene);

        // Comportamento de fechamento no JavaFX
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0); // Encerra completamente a aplicação
        });

        primaryStage.show();
    }

    private void createSwingContent(SwingNode swingNode) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            NewJFrame frame = new NewJFrame();
            JPanel panel = (JPanel) frame.getContentPane();
            swingNode.setContent(panel);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
