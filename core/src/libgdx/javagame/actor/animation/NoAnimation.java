package libgdx.javagame.actor.animation;

public class NoAnimation extends AnimationController {
    public NoAnimation(String fileName) {
        animationLoader.loadTexture(fileName);
    }
}
