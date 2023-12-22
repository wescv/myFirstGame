package myGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    SpaceShip spaceShip = new SpaceShip();
    Destroyables[] destroyables = new Destroyables[40];
    MyKeyBoard kb = new MyKeyBoard(spaceShip,destroyables);
    Menu menu = new Menu();
    MyMouse mouse = new MyMouse(spaceShip,destroyables, menu,this);
    public void init() {
        menu.startButton();
        mouse.handler(STATE.MENU);
    }
    public void initGame(){
        Picture backGround = new Picture(0, 0, "/Fundo_resized.png");
        backGround.grow(-270, 0);
        backGround.translate(-270,0);
        backGround.draw();
        Sound.startMenuSong.stop();
        Sound.battleSong.loop();
        spaceShip.getPictureSpaceShip().draw();
        createDestroyables();
        kb.handler();
        mouse.handler(STATE.GAME);
    }

    private void createDestroyables() {
        int startx = 5;
        int starty = 20;

            for (int fila = 0; fila < destroyables.length / 10; fila++) {
                System.out.println(fila);
                for (int i = 10 * fila; i < 10 * (fila+1) ; i++) {
                    destroyables[i] = new Destroyables(startx, starty);
                    startx += 100;
                }
                starty += 100;
                startx = 5;
            }
    }
    public enum STATE {
        MENU,
        GAME;
    }
    public static STATE State = STATE.MENU;

}

