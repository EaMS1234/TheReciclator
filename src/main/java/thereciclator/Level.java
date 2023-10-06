package thereciclator;

import java.util.concurrent.CompletableFuture;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Level {
    // Global parameters
    private static KeyCode key;
    
    // Get elements
    @FXML
    private ImageView playerSprite;
    @FXML
    private Pane playerContainer;
    
    // Creates player object
    @FXML
    static Player player;
    
    // Runs when loaded
    @FXML
    private void initialize() {
        // Initializes a new player
        this.player = new Player(playerContainer, playerSprite, 10);
        player.x = playerContainer.getLayoutX();
        player.y = playerContainer.getLayoutY();
        
        // Runs the function "loop" in the background
        CompletableFuture<Void> loopFuture = CompletableFuture.runAsync(() -> loop());
        
        // Make sure the player has the focus since the beginning
        playerContainer.requestFocus();
    }
    
    // Sets current keyboard input
    @FXML
    private void keyPress(KeyEvent event) {
        key = event.getCode();
        
        System.out.println(key);
    }
    
    @FXML
    private void keyRelease() {
        key = null;
    }
    
    // Target FPS
    private static final int fps = 30;
    
    private static void loop() {
        // Target frametime
        int frametime = (int) (1000 / fps);
        
        while (true) {
            try {
                // Current time at the beginning of the frame
                long startTime = System.currentTimeMillis();
                
                // Game loop code goes here 
                CompletableFuture<Void> input = CompletableFuture.runAsync(() -> player.input(key));
                player.animate(4, 8, fps, "/thereciclator/assets/buneco/buneco");
                
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
