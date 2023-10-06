package thereciclator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Class that represents a moving character
public class Character {
    // Character Coordinates
    public double x = 0;
    public double y = 0;
    
    // Character elements
    private Pane container;
    private ImageView sprite;
    
    public Character(Pane container, ImageView sprite) {
        this.container = container;
        this.sprite = sprite;
    }
    
    // Moves the character around
    public void move(Vector2 vector) {
        this.x += vector.x;
        this.y += vector.y;
        
        // Changes onscreen position of element
        container.setLayoutX(x);
        container.setLayoutY(y);
    }
    
    public int currentFrame = 1;
    public int currentGameFrame = 1;
    public int frameSkip;
    
    public void animate(int frameCount, int animFPS, int gameFPS, String PATH) {
        // Defines the quantity of frames to be skipped
        frameSkip = gameFPS / animFPS;
        
        // If the animation is over, goes back to the first frame
        if (currentFrame > frameCount) {
            currentFrame = 1;
        }
        
        // Gets the path of the current frame
        String imageFile = PATH + currentFrame + ".png";
        
        // Updates the sprite's image
        Image newImage = new Image(getClass().getResourceAsStream(imageFile));
        sprite.setImage(newImage);
        
        // Checks if the frame must be skipped or not
        if (currentGameFrame == frameSkip) {
            currentFrame++;
            currentGameFrame = 0;
        } else {
            currentGameFrame++;
        }
    }
}
