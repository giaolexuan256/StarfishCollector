package libgdx.javagame.actors.objects;

import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actors.util.BaseActor;
import libgdx.javagame.actors.util.animation.AnimationController;
import libgdx.javagame.actors.util.animation.NoAnimation;

public class Rock extends BaseActor {

    public Rock(float x, float y, Stage stage) {
        super(x, y, stage, NoAnimation.getInstance("rock.png"));
        setColliderPolygon(8);
    }

}
