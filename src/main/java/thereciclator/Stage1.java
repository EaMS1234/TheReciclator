package thereciclator;

import java.util.concurrent.CompletableFuture;
import java.io.IOException;
import javafx.fxml.FXML;

public class Stage1 {
    private static int fps = 60;  // Target FPS
    
    @FXML
    private void switchToSecondary() throws IOException {
        System.out.println("Coisa boa, coisa boa");
    }
    
    @FXML
    private void initialize() {
        // Runs when loaded
        System.out.println("AQUI");
        
        // Runs the function "loop"
        CompletableFuture<Void> loopFuture = CompletableFuture.runAsync(() -> loop());
    }
    
    private static void loop() {
        int frametime = (int) (1000 / fps);  // Target frametime
        
        int currentframe = 0;
        
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
                ex.printStackTrace();
            }
        }
    }
}
