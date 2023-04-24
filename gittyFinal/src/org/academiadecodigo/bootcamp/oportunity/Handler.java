package org.academiadecodigo.bootcamp.oportunity;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {
    private final Player player;
    private final Keyboard keyboard;
    private final Game game;

    public Handler (Player player,Game game) {
        this.player = player;
        this.game=game;
        keyboard = new Keyboard (this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents () {
        // Keyboard RIGHT
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        // Keyboard LEFT
        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_SPACE);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);

        KeyboardEvent closeGame = new KeyboardEvent();
        closeGame.setKey(KeyboardEvent.KEY_Q);
        closeGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(closeGame);

    }

    public void keyPressed (KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT -> player.moveRight();
            case KeyboardEvent.KEY_LEFT -> player.moveLeft();
            case KeyboardEvent.KEY_SPACE -> game.setGameStart(true);
            case KeyboardEvent.KEY_Q -> System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
