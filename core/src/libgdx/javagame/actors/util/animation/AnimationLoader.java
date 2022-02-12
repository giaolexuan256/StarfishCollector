package libgdx.javagame.actors.util.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationLoader {

    private final AnimationController animationController;

    public AnimationLoader(AnimationController actorAnimation) {
        this.animationController = actorAnimation;
    }

    public void loadAnimationFromFiles(String[] fileNames, float frameDuration, boolean loop) {
        Array<TextureRegion> textureRegions = new Array<>(fileNames.length);
        for (String fileName : fileNames) {
            Texture texture = new Texture(Gdx.files.internal(fileName));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            textureRegions.add(new TextureRegion(texture));
        }

        Animation<TextureRegion> animation = new Animation<>(frameDuration, textureRegions);

        if (loop) animation.setPlayMode(Animation.PlayMode.LOOP);
        else animation.setPlayMode(Animation.PlayMode.NORMAL);

        if (animationController.getAnimation() == null) animationController.setAnimation(animation);
    }

    public void loadAnimationFromSheet(String fileName, float frameDuration, int rows, int columns, boolean loop) {
        Texture texture = new Texture(Gdx.files.internal(fileName), true);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        int frameWidth = texture.getWidth() / columns;
        int frameHeight = texture.getHeight() / rows;

        TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);

        Array<TextureRegion> textureArray = new Array<>();

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                textureArray.add(temp[r][c]);

        Animation<TextureRegion> animation = new Animation<>(frameDuration, textureArray);

        if (loop) animation.setPlayMode(Animation.PlayMode.LOOP);
        else animation.setPlayMode(Animation.PlayMode.NORMAL);

        if (animationController.getAnimation() == null) animationController.setAnimation(animation);

    }

    public void loadTexture(String fileName) {
        loadAnimationFromFiles(new String[]{fileName}, 1, true);
    }
}
