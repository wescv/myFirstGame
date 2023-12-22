
package myGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyBoard implements KeyboardHandler {

    SpaceShip spaceShip;
    Destroyables[] destroyables;
    Keyboard kb = new Keyboard(this);


    public MyKeyBoard(SpaceShip spaceShip, Destroyables[] destroyables){
        this.spaceShip = spaceShip;
        this.destroyables = destroyables;
    }
    public void handler() {
        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT -> spaceShip.getPictureSpaceShip().translate(35, 0);
            case KeyboardEvent.KEY_LEFT -> spaceShip.getPictureSpaceShip().translate(-35, 0);
            case KeyboardEvent.KEY_UP -> spaceShip.getPictureSpaceShip().translate(0, -35);
            case KeyboardEvent.KEY_DOWN -> spaceShip.getPictureSpaceShip().translate(0, 35);
            case KeyboardEvent.KEY_SPACE -> {
                Thread thread = new Thread(new Animator(spaceShip,destroyables));
                thread.start();
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
