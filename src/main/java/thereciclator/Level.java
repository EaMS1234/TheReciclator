package thereciclator;

import java.util.concurrent.CompletableFuture;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Level {
    // Global parameters
    private static KeyCode key;
    
    // Get elements
    @FXML private Pane stageContainer;
    @FXML private ImageView playerSprite;
    @FXML private Pane playerContainer;
    @FXML private ImageView enemySprite;
    @FXML private Pane enemyContainer;
    @FXML private ImageView life1;
    @FXML private ImageView life2;
    @FXML private ImageView life3;
    
    // Creates player object
    Player player;
    
    // Crteates enemy object
    Enemy[] enemies = new Enemy[1];
    
    // Creates a new bullet
    Bullet[] bullets = new Bullet[1];
    
    // Life Counter
    LifeCounter life;
    
    // Runs when loaded
    @FXML
    private void initialize() {
        // Initializes a new player
        this.player = new Player(playerContainer, playerSprite, 10);
        player.canBeOffScreen = true;
        player.hp = 4;
        
        // Initializes a new life counter
        this.life =  new LifeCounter(life1, life2, life3);
        
        // Initializes a new enemy
        enemies[0] = new Enemy(enemyContainer, enemySprite, "sine", "organico");
        
        // Runs the function "loop" in the background
        CompletableFuture.runAsync(() -> loop());
        
        // Make sure the player has the focus since the beginning
        playerContainer.requestFocus();
    }
    
    // Sets current keyboard input
    @FXML
    private void keyPress(KeyEvent event) {
        key = event.getCode();
    }
    
    @FXML
    private void keyRelease() {
        key = null;
    }
    
    private void shoot(String type, Pane shooter) {
        int shots = bullets.length;
        String imagePath = "/thereciclator/assets/munições/" + type + ".png";
        
        if (shots <= 2) {
            // Extends the "bullet" array
            Bullet[] newArray = new Bullet[shots + 1];
            System.arraycopy(bullets, 0, newArray, 0, shots);
            bullets = newArray;
        }
        
        Pane bulletContainer = new Pane();
        
        Image bulletImage = new Image(getClass().getResourceAsStream(imagePath));
        ImageView bulletSprite = new ImageView();
        bulletSprite.setImage(bulletImage);
    
        bulletContainer.getChildren().add(bulletSprite);
        stageContainer.getChildren().add(bulletContainer);
        
        bulletContainer.setLayoutX(shooter.getLayoutX());
        bulletContainer.setLayoutY(shooter.getLayoutY());
        
        bullets[shots + 1] = new Bullet(bulletContainer, bulletSprite, 10);
    }
    
    // Target FPS
    private static final int fps = 60;
    
    private void loop() {
        // Target frametime
        int frametime = (int) (1000 / fps);
        
        while (true) {
            try {
                // Current time at the beginning of the frame
                long startTime = System.currentTimeMillis();
                
                // Game loop code goes here 
                CompletableFuture.runAsync(() -> player.input(key));
                CompletableFuture.runAsync(() -> {
                    if (KeyCode.SPACE == key) shoot("municaoFeijao", playerContainer);
                });
                life.updateLife(player.hp);
                
                // Runs for all enemy on screen
                for (Enemy enemy : enemies) {
                    if (enemy.container != null) {
                        enemy.pattern();
                        
                        switch (enemy.type) {
                            case "metal":
                                enemy.animate(2, 4, fps, "/thereciclator/assets/inimigos/inimigosMetal/lataSkol");
                                break;
                            
                            case "vidro":
                                enemy.animate(2, 4, fps, "/thereciclator/assets/inimigos/inimigosVidro/garrafaCoca");
                                break;
                            
                            case "plastico":
                                enemy.animate(2, 4, fps, "/thereciclator/assets/inimigos/inimigosPlastico/GarrafaDolly");
                                break;
                            
                            case "organico":
                                enemy.animate(2, 4, fps, "/thereciclator/assets/inimigos/inimigosOrganico/peixeOsso");
                                break;
                            
                            case "papel":
                                enemy.animate(2, 4, fps, "/thereciclator/assets/inimigos/inimigosPapel/LixoPapel");
                                break;
                        }
                        
                        // Removes the enemies container and sprite
                        if (enemy.deletable) {
                            enemy.sprite.setImage(null);
                            enemy.sprite = null;
                            enemy.container = null;
                        }   
                    }
                }
                
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