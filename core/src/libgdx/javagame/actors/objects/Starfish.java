package libgdx.javagame.actors.objects;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import libgdx.javagame.actors.util.BaseActor;
import libgdx.javagame.actors.util.animation.ValueBasedAnimation;

public class Starfish extends BaseActor {

    public Starfish(float x, float y, Stage stage) {
        super(x, y, stage, ValueBasedAnimation.getInstance("starfish.png"));
        addAction(Actions.forever(Actions.rotateBy(90, 1)));
        setColliderPolygon(4);
    }
}
