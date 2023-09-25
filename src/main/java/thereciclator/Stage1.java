package thereciclator;

import java.util.concurrent.CompletableFuture;
import javafx.fxml.FXML;

public class Stage1 {
    private static final int fps = 60;  // Target FPS
    
    @FXML
    private void initialize() {
        // Runs when loaded
        
        // Runs the function "loop"
        CompletableFuture<Void> loopFuture = CompletableFuture.runAsync(() -> loop());
    }
    
    private static void loop() {
        int frametime = (int) (1000 / fps);  // Target frametime
        
        while (true) {
            try {
                // Current time at the beginning of the frame
                long startTime = System.currentTimeMillis();
                
                // Game loop code goes here
                
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
