package thereciclator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// Class that represents a moving character
public class Character {
    // Character Coordinates
    public double x = 0;
    public double y = 0;
    
    // Other properties
    public boolean canBeOffScreen = false;
    public boolean deletable = false;
    
    public int hp = 10;
    
    // Character elements
    public Pane container;
    public ImageView sprite;
    
    public Character(Pane container, ImageView sprite) {
        this.container = container;
        this.sprite = sprite;
        
        // Sets the container's position as default location
        this.x = container.getLayoutX();
        this.y = container.getLayoutY();
    }
    
    // Moves the character around
    public void move(Vector2 vector) {       
        this.x += vector.x;
        this.y += vector.y;
        
        // Changes onscreen position of element
        container.setLayoutX(x);
        container.setLayoutY(y);
        
        // checks if the object is out of the screen
        if (container.getLayoutX() < -512 || container.getLayoutX() > 1792 || container.getLayoutY() < -512 || container.getLayoutY() > 1232) {            
            if (canBeOffScreen == false && container.getParent() != null) {
                deletable = true;
            }
        }
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
