package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SpaceShip {

    private final Picture pictureSpaceShip;

    private final int middleShip;

    public SpaceShip() {
        this.pictureSpaceShip = new Picture(600, 900, "spsf.png");
        pictureSpaceShip.grow(70, 70);
        middleShip = getPictureSpaceShip().getWidth()/2;
    }

    public void fire(Destroyables[] destroyables) {
        Shot shot = new Shot(this.pictureSpaceShip.getX() + this.getPictureSpaceShip().getWidth() / 2 - 10, this.pictureSpaceShip.getY() + 50);
        ColisionDetector colisionDetector = new ColisionDetector(destroyables, shot);

        for (int y = shot.getShotPicture().getY(); y > 10; y = y - 5) {
            shot.getShotPicture().translate(0, -5);
            if(colisionDetector.spaceShipCheckColision()){
                shot.getShotPicture().delete();
                return;
            }
            CustomSleep.sleep(10);
        }
        shot.getShotPicture().delete();
    }

    public void fire_mouse(double x, double y, Destroyables[] destroyables) {
        Shot shot = new Shot(this.pictureSpaceShip.getX() + middleShip - 10, this.pictureSpaceShip.getY() + 50);
        ColisionDetector colisionDetector = new ColisionDetector(destroyables, shot);

        double factor = ((y - this.pictureSpaceShip.getY()) + 50) / (x - (this.pictureSpaceShip.getX() + middleShip +10));
        double angle = Math.atan(factor);
        double vx = Math.cos(angle) * 700;
        if (x < this.pictureSpaceShip.getX() +middleShip - 10) {
            vx = -vx;
        }
        double vy = Math.abs(Math.sin(angle)) * 700;

        System.out.println("vx: "  + vx + "vy :" + vy);
        if (y < 900) {
            for (int row = this.pictureSpaceShip.getY(); row > 0; row -= (int) (Math.abs(vy) * 0.05)) {
                assert shot != null;
                shot.getShotPicture().translate(vx * 0.05, -(vy * 0.05));
                if(colisionDetector.spaceShipCheckColision()){
                    shot.getShotPicture().delete();
                    shot = null;
                }
                CustomSleep.sleep(50);
            }
            assert shot != null;
            shot.getShotPicture().delete();
        }
    }

    public Picture getPictureSpaceShip() {
        return pictureSpaceShip;
    }
}
