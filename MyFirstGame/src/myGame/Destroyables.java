package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Destroyables {
    private final Picture picDestroyable1;
    private boolean destroyed = false;

    public Destroyables(int x, int y){
        picDestroyable1 = new Picture(x,y,"d1.png");
        picDestroyable1.grow(-300,-300);
        picDestroyable1.draw();

    }

    public void fire() {
        Shot shot = new Shot(this.picDestroyable1.getX() + 3, this.picDestroyable1.getY());
        for (int y = shot.getShotPicture().getY(); y < 190; y = y + 10) {
            shot.getShotPicture().translate(0, 10);
            CustomSleep.sleep(50);
        }
        //how to delete an object
        shot.getShotPicture().delete();

    }

    public Picture getPicDestroyable1() {
        return picDestroyable1;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    /*public boolean DestroyableCheckColision() {
        Rectangle shotColision = new Rectangle(shot.getShotPicture().getX(), shot.getShotPicture().getY(), shot.getShotPicture().getWidth(), shot.getShotPicture().getHeight());
        Rectangle spaceShipColision = new Rectangle(, , pictureSpaceShip.getWidth(), pictureSpaceShip.getHeight());

        if(shotColision.intersects(spaceShipColision)) {
            System.out.println("mmm");
            return true;
        } else {
            return false;
        }
    }*/

}
