package thereciclator;

import java.util.concurrent.CompletableFuture;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

public class Level {
    // Get elements
    @FXML private ImageView playerSprite;
    @FXML private Pane playerContainer;
    
    // Creates player object
    @FXML static Player player;
    
    // Runs when loaded
    @FXML
    private void initialize() {
        // Initializes a new player
        this.player = new Player(playerContainer, playerSprite);
        
        // Runs the function "loop" in the background
        CompletableFuture<Void> loopFuture = CompletableFuture.runAsync(() -> loop());
    }
    
    // Target FPS
    private static final int fps = 60;
    
    private static void loop() {
        // Target frametime
        int frametime = (int) (1000 / fps);
        
        while (true) {
            try {
                // Current time at the beginning of the frame
                long startTime = System.currentTimeMillis();
                
                // Game loop code goes here 
                player.input();
                
                // Elapsed  time at the end of the frame.
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < frametime) {
                    // Waits until the completion of the frame
                    Thread.sleep((frametime - elapsedTime));
                }
                
            } catch (InterruptedException ex) {
            }
        }
    }
}
