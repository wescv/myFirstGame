package myGame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {

    SpaceShip spaceShip;
    Destroyables[] destroyables;
    Menu menu;
    Mouse mouse = new Mouse(this);
    Game.STATE gameState;

    Game game;
    public MyMouse(SpaceShip spaceShip, Destroyables[] destroyables, Menu menu, Game game){
        this.destroyables = destroyables;
        this.spaceShip = spaceShip;
        this.menu = menu;
        this.game = game;
    }

    public void handler(Game.STATE gameState){
        this.gameState = gameState;
        //MouseEvent click_1 = new MouseEvent(0,0, MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED && gameState == Game.STATE.GAME) {
            Thread thread = new Thread(new MouseAnimator(spaceShip, mouseEvent.getX(), mouseEvent.getY(),destroyables));
            thread.start();
        }else if(mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED && gameState == Game.STATE.MENU) {
            int xMin = menu.startPicture.getX() ;
            int xMax = menu.startPicture.getX() + menu.startPicture.getWidth();
            int yMin = menu.startPicture.getY() + menu.startPicture.getHeight();
            int yMax = menu.startPicture.getY() + menu.startPicture.getHeight()*2;
            System.out.println(xMax +" " + xMin +" " + yMax +" " + yMin);
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            System.out.println(mouseX + " " + mouseY);
            if(mouseX < xMax && mouseX > xMin && mouseY > yMin && mouseY < yMax ){
                System.out.println("true");
                game.initGame();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}