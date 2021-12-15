package uet.oop.bomberman.entities.MovingEntity.Bomber.GameController;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.BitSet;

public class GameController {

    /**
     * Bitset which registers if any {@link KeyCode} keeps being pressed or if it is released.
     */
    private final BitSet keyboardBitSet = new BitSet();

    // -------------------------------------------------
    // default key codes
    // will vary when you let the user customize the key codes or when you add support for a 2nd player
    // -------------------------------------------------

    private final KeyCode upKey = KeyCode.UP;
    private final KeyCode downKey = KeyCode.DOWN;
    private final KeyCode leftKey = KeyCode.LEFT;
    private final KeyCode rightKey = KeyCode.RIGHT;
    private final KeyCode fireKey = KeyCode.SPACE;

    private final Scene scene;

    public GameController(Scene scene) {
        this.scene = scene;
    }

    public void addListeners() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    public void removeListeners() {
        scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    /**
     * "Key Pressed" handler for all input events: register pressed key in the bitset
     */
    private final EventHandler<KeyEvent> keyPressedEventHandler = event -> {
//        if (event.getCode().equals(fireKey)) {
//            keyboardBitSet.set(fireKey.ordinal(), true);
//        } else {
////            keyboardBitSet.set(upKey.ordinal(), false);
////            keyboardBitSet.set(downKey.ordinal(), false);
////            keyboardBitSet.set(rightKey.ordinal(), false);
////            keyboardBitSet.set(leftKey.ordinal(), false);
//            // register key down
//            keyboardBitSet.set(event.getCode().ordinal(), true);
//        }
        keyboardBitSet.set(event.getCode().ordinal(), true);

    };

    /**
     * "Key Released" handler for all input events: unregister released key in the bitset
     */
    private final EventHandler<KeyEvent> keyReleasedEventHandler = event -> {
        // register key up
        keyboardBitSet.set(event.getCode().ordinal(), false);
    };


    // -------------------------------------------------
    // Evaluate bitset of pressed keys and return the player input.
    // If direction and its opposite direction are pressed simultaneously, then the direction isn't handled.
    // -------------------------------------------------

    public boolean isMoveUp() {
        return keyboardBitSet.get(upKey.ordinal()) && !keyboardBitSet.get(downKey.ordinal());
    }

    public boolean isMoveDown() {
        return keyboardBitSet.get(downKey.ordinal()) && !keyboardBitSet.get(upKey.ordinal());
    }

    public boolean isMoveLeft() {
        return keyboardBitSet.get(leftKey.ordinal()) && !keyboardBitSet.get(rightKey.ordinal());
    }

    public boolean isMoveRight() {
        return keyboardBitSet.get(rightKey.ordinal()) && !keyboardBitSet.get(leftKey.ordinal());
    }

    public boolean isFireKey() {
        return keyboardBitSet.get(fireKey.ordinal());
    }



}

