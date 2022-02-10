package libgdx.javagame.actor.animation;

import libgdx.javagame.actor.BaseActor;

public class ImageBasedAnimation extends AnimationController {
    private ImageBasedAnimation(String[] fileNames, float frameDuration, boolean loop) {
        animationLoader.loadAnimationFromFiles(fileNames, frameDuration, loop);
    }

    private ImageBasedAnimation(String fileName, float frameDuration, int rows, int columns, boolean loop) {
        animationLoader.loadAnimationFromSheet(fileName, frameDuration, rows, columns, loop);
    }

    public static ImageBasedAnimation getLoadedAnimationFromFiles(String[] fileNames, float frameDuration,
                                                                  boolean loop) {
        return new ImageBasedAnimation(fileNames, frameDuration, loop);
    }

    public static ImageBasedAnimation getLoadedAnimationFromSheet(String fileName, float frameDuration, int rows,
                                                                  int columns, boolean loop) {
        return new ImageBasedAnimation(fileName, frameDuration, rows, columns, loop);
    }
}
