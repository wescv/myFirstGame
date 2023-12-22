package myGame;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    Picture startPicture;


    public void startButton() {

        if (Game.State == Game.STATE.MENU) {
            Sound.startMenuSong.loop();
            Picture picture = new Picture(0, 0, "/Fundo_resized.png");
            picture.grow(-270, 0);
            picture.translate(-270,0);
            Picture logoSpaceInvaders = new Picture(400, 30, "/space invaders_resized.png");
            this.startPicture = new Picture(600, 370, "/Start Button_resized.png");
            startPicture.grow(20, 0);
            Picture soundButton = new Picture(635, 440, "sound_resized.png");
            soundButton.grow(20, 0);
            Picture exitGameButton = new Picture(600, 510, "Exit Button_resized.png");
            exitGameButton.grow(20, 0);
            Picture alien1 = new Picture(150, 300, "/alien.png");
            alien1.grow(20, 0);
            Picture alien2 = new Picture(900, 300, "/alien.png");
            alien2.grow(20, 0);
            picture.draw();
            logoSpaceInvaders.draw();
            startPicture.draw();
            alien1.draw();
            alien2.draw();
            soundButton.draw();
            exitGameButton.draw();

        }
    }
}
