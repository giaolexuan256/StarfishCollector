package libgdx.javagame.actor.animation;

public class ValueBasedAnimation extends AnimationController {

    private ValueBasedAnimation(String fileName) {
        animationLoader.loadTexture(fileName);
    }

    public static ValueBasedAnimation getInstance(String fileName) {
        return new ValueBasedAnimation(fileName);
    }
}
