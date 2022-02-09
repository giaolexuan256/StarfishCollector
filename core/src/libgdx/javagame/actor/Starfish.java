package libgdx.javagame.actor;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import libgdx.javagame.actor.animation.ImageBasedAnimation;

public class Starfish extends BaseActor {

    public Starfish(float x, float y, Stage stage) {
        super(x, y, stage, null);
        Action spin = Actions.forever(Actions.rotateBy(90, 0.1f));
        setAnimationBehavior(new ImageBasedAnimation(this, "starfish.png", spin));
    }
}
