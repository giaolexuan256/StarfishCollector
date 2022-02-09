package libgdx.javagame.actor.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class AnimationController {
    protected Animation<TextureRegion> animation;
    protected AnimationLoader animationLoader;

    public AnimationController() {
        animationLoader = new AnimationLoader(this);
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    public AnimationLoader getAnimationLoader() {
        return animationLoader;
    }
}
