package libgdx.javagame.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actor.animation.AnimationController;
import libgdx.javagame.actor.physics.MovementHandler;

public class BaseActor extends Actor {
    private AnimationController animationBehavior;
    private float elapsedTime;
    private final MovementHandler movementHandler;



    public BaseActor(float x, float y, Stage stage, AnimationController animationBehavior) {
        setPosition(x, y);
        stage.addActor(this);
        this.animationBehavior = animationBehavior;
        elapsedTime = 0;
        movementHandler = new MovementHandler(this);
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
        batch.draw(animationBehavior.getAnimation().getKeyFrame(elapsedTime), getX(), getY());
    }

    public AnimationController getAnimationBehavior() {
        return animationBehavior;
    }

    public void setAnimationBehavior(AnimationController animationBehavior) {
        this.animationBehavior = animationBehavior;
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }
}
