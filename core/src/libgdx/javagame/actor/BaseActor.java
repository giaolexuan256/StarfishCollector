package libgdx.javagame.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actor.animation.AnimationController;

public class BaseActor extends Actor {
    private AnimationController animationBehavior;
    private float elapsedTime;

    private Vector2 velocityVec;

    public BaseActor(float x, float y, Stage stage, AnimationController animationBehavior) {
        setPosition(x, y);
        stage.addActor(this);
        this.animationBehavior = animationBehavior;
        elapsedTime = 0;
        velocityVec = new Vector2();
    }

    public float getSpeed() {
        return velocityVec.len();
    }

    public void setSpeed(float speed) {
        if (velocityVec.len() == 0) velocityVec.set(speed, 0);
    }

    public float getMotionAngle() {
        return velocityVec.angleDeg();
    }

    public void setMotionAngle(float angle) {
        velocityVec.setAngleDeg(angle);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        elapsedTime += delta;

        moveBy(velocityVec.x * delta, velocityVec.y * delta);

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
}
