package libgdx.javagame.actor.animation;

public class ValueBasedAnimation extends AnimationController {
    public ValueBasedAnimation(String[] fileNames, float frameDuration, boolean loop) {
        animationLoader.loadAnimationFromFiles(fileNames, frameDuration, loop);
    }

    public ValueBasedAnimation(String fileName, float frameDuration, int rows, int columns, boolean loop) {
        animationLoader.loadAnimationFromSheet(fileName, frameDuration, rows, columns, loop);
    }
}
