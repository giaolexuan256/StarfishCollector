package libgdx.javagame.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actor.animation.AnimationController;
import libgdx.javagame.actor.physics.MovementHandler;

public class BaseActor extends Actor {
    private final AnimationController animationController;
    private float elapsedTime;
    private final MovementHandler movementHandler;


    public BaseActor(float x, float y, Stage stage, AnimationController animationController) {
        setPosition(x, y);
        stage.addActor(this);
        this.animationController = animationController;
        elapsedTime = 0;
        movementHandler = new MovementHandler(this);
        setPropertiesAccordingToAnimation();
    }

    private void setPropertiesAccordingToAnimation() {
        TextureRegion textureRegion = animationController.getAnimation().getKeyFrame(0);
        float width = textureRegion.getRegionWidth();
        float height = textureRegion.getRegionHeight();
        setSize(width, height);
        setOrigin(width / 2, height / 2);
    }


    @Override
    public void act(float delta) {
        super.act(delta);

        elapsedTime += delta;

        moveBy(movementHandler.getVelocityVector().x * delta, movementHandler.getVelocityVector().y * delta);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(animationController.getAnimation().getKeyFrame(elapsedTime), getX(), getY(), getOriginX(),
                   getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }
}
