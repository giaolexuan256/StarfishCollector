package libgdx.javagame.actor.animation;

import com.badlogic.gdx.scenes.scene2d.Action;
import libgdx.javagame.actor.BaseActor;


public class ImageBasedAnimation extends AnimationController {

    private Action action;

    public ImageBasedAnimation(BaseActor actor, String fileName, Action action) {
        animationLoader.loadTexture(fileName);
        this.action = action;
        actor.addAction(action);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
