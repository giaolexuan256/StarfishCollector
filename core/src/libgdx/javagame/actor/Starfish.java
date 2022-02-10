package libgdx.javagame.actor;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import libgdx.javagame.actor.animation.ValueBasedAnimation;

public class Starfish extends BaseActor {

    public Starfish(float x, float y, Stage stage) {
        super(x, y, stage, ValueBasedAnimation.getInstance("starfish.png"));
        addAction(Actions.forever(Actions.rotateBy(90, 1)));
    }
}
