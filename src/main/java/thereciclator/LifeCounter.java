package thereciclator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LifeCounter {
    private ImageView sprite1;
    private ImageView sprite2;
    private ImageView sprite3;
    
    private Image emptyHeart;
    private Image halfHeart;
    private Image fullHeart;
    
    public LifeCounter(ImageView sprite1, ImageView sprite2, ImageView sprite3) {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        
        this.emptyHeart = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao1.png"));
        this.halfHeart = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao2.png"));
        this.fullHeart = new Image(getClass().getResourceAsStream("/thereciclator/assets/interface/vida/coracao3.png"));
    }
    
    public void updateLife(int hp) {
        switch (hp) {
            case 0:
                sprite1.setImage(emptyHeart);
                sprite2.setImage(emptyHeart);
                sprite3.setImage(emptyHeart);
                break;
            
            case 1:
                sprite1.setImage(halfHeart);
                sprite2.setImage(emptyHeart);
                sprite3.setImage(emptyHeart);
                break;
            
            case 2:
                sprite1.setImage(fullHeart);
                sprite2.setImage(emptyHeart);
                sprite3.setImage(emptyHeart);
                break;
                
            case 3:
                sprite1.setImage(fullHeart);
                sprite2.setImage(halfHeart);
                sprite3.setImage(emptyHeart);
                break;
                
            case 4:
                sprite1.setImage(fullHeart);
                sprite2.setImage(fullHeart);
                sprite3.setImage(emptyHeart);
                break;
                
            case 5:
                sprite1.setImage(fullHeart);
                sprite2.setImage(fullHeart);
                sprite3.setImage(halfHeart);
                break;
                
            case 6:
                sprite1.setImage(fullHeart);
                sprite2.setImage(fullHeart);
                sprite3.setImage(fullHeart);
                break;
        }
    }
}
