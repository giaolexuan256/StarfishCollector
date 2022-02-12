package libgdx.javagame.actors.util.physics;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import libgdx.javagame.actors.util.BaseActor;

/**
 * This class using Builder Pattern to generate new object.
 */
public class MovementHandler {

    private final BaseActor actor;
    private final Vector2 velocityVector;
    private final Vector2 accelerationVector;
    private float acceleration;
    private float maxSpeed;
    private float deceleration;

    public MovementHandler(float maxSpeed, float acceleration, float deceleration, BaseActor actor) {
        this.actor = actor;
        velocityVector = new Vector2();
        accelerationVector = new Vector2();
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
    }

    public Vector2 getVelocityVector() {
        return velocityVector;
    }

    public float getSpeed() {
        return velocityVector.len();
    }

    public void setSpeed(float speed) {
        if (velocityVector.len() == 0) velocityVector.set(speed, 0);
        else velocityVector.setLength(speed);
    }

    public float getMotionAngle() {
        return velocityVector.angleDeg();
    }

    public void setMotionAngle(float angle) {
        velocityVector.setAngleDeg(angle);
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void accelerateAtAngle(float angle) {
        accelerationVector.add(new Vector2(acceleration, 0).setAngleDeg(angle));
    }

    public void accelerateForward() {
        accelerateAtAngle(actor.getRotation());
    }

    public void setDeceleration(float deceleration) {
        this.deceleration = deceleration;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void applyPhysics(float deltaTime) {
        velocityVector.add(accelerationVector.x * deltaTime, accelerationVector.y * deltaTime);
        float speed = getSpeed();
        if (accelerationVector.len() == 0) speed -= deceleration * deltaTime;
        speed = MathUtils.clamp(speed, 0, maxSpeed);
        setSpeed(speed);
        actor.moveBy(velocityVector.x * deltaTime, velocityVector.y * deltaTime);
        accelerationVector.setZero();
    }
}
