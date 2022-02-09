package libgdx.javagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class BaseActor extends Actor {

    private Animation<TextureRegion> animation;
    private float elapsedTime;

    public BaseActor(float x, float y, Stage stage) {
        setPosition(x, y);
        stage.addActor(this);
        animation = null;
        elapsedTime = 0;
    }

    protected void loadAnimationFromFiles(String[] fileNames, float frameDuration, boolean loop) {
        Array<TextureRegion> textureRegions = new Array<>(fileNames.length);
        for (String fileName : fileNames) {
            Texture texture = new Texture(Gdx.files.internal(fileName));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            textureRegions.add(new TextureRegion(texture));
        }

        Animation<TextureRegion> animation = new Animation<>(frameDuration, textureRegions);

        if (loop) animation.setPlayMode(Animation.PlayMode.LOOP);
        else animation.setPlayMode(Animation.PlayMode.NORMAL);
        if (this.animation == null) setAnimation(animation);

    }

    protected void loadTexture(String fileName) {
        loadAnimationFromFiles(new String[]{fileName}, 1, true);
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
        TextureRegion textureRegion = animation.getKeyFrame(0);
        float width = textureRegion.getRegionWidth();
        float height = textureRegion.getRegionHeight();
        setSize(width, height);
        setOrigin(width / 2.0f, height / 2.0f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        elapsedTime += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(animation.getKeyFrame(elapsedTime), getX(), getY());
    }
}
