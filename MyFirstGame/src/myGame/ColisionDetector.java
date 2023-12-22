package myGame;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ColisionDetector {

    private Destroyables[] destroyables;
    private Shot shot;
    Map <Shot, Destroyables[]> colisionMap = new HashMap<>();
    public ColisionDetector(Destroyables[] destroyables, Shot shot){
        this.destroyables = destroyables;
        this.shot = shot;
        add();
    }

    public void add(){
        colisionMap.put(this.shot,this.destroyables);
    }

    public boolean spaceShipCheckColision() {

        Rectangle shotColision = new Rectangle(shot.getShotPicture().getX(), shot.getShotPicture().getY(), shot.getShotPicture().getWidth(), shot.getShotPicture().getHeight());
        for(int i = 0; i < colisionMap.get(shot).length; i++) {
            Destroyables destroyable = colisionMap.get(shot)[i];
            if(destroyable.isDestroyed()){
               continue;
            }
            Rectangle destroyableColision = new Rectangle(destroyable.getPicDestroyable1().getX()-90, destroyable.getPicDestroyable1().getY()-90, 80, 80);
            if (shotColision.intersects(destroyableColision)){
                Sound.destroyedShipExplosion.play();
                destroyable.setDestroyed(true);
                destroyableColision.translate(0,0);
                destroyable.getPicDestroyable1().translate(0,0);
                destroyable.getPicDestroyable1().delete();

                return true;
            }
        }
        return false;
    }


}
