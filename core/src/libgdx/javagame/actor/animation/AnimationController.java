package libgdx.javagame.actor.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import libgdx.javagame.actor.BaseActor;

public abstract class AnimationController {
    protected Animation<TextureRegion> animation;
    protected Action action;
    protected AnimationLoader animationLoader;

    public AnimationController() {
        animationLoader = new AnimationLoader(this);
        action = null;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }
}
