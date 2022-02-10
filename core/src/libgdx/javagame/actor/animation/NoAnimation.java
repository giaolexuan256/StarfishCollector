package libgdx.javagame.actor.animation;

import libgdx.javagame.actor.BaseActor;

public class NoAnimation extends AnimationController {
    private NoAnimation(String fileName) {
        animationLoader.loadTexture(fileName);
    }
    public static NoAnimation getInstance(String fileName) {
        return new NoAnimation(fileName);
    }
}
