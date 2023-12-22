package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Shot {

    private final Picture shotPicture;

    public Shot(int x, int y){
       shotPicture = new Picture(x,y,"/bullet.png");
       Sound.shoot.play();
       shotPicture.draw();
    }

    public Picture getShotPicture() {
        return shotPicture;
    }

}
