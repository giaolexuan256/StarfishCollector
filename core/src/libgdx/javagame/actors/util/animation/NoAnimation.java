package libgdx.javagame.actors.util.animation;

public class NoAnimation extends AnimationController {
    private NoAnimation(String fileName) {
        animationLoader.loadTexture(fileName);
    }
    public static NoAnimation getInstance(String fileName) {
        return new NoAnimation(fileName);
    }
}
