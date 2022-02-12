package libgdx.javagame.actors.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actors.util.animation.AnimationController;
import libgdx.javagame.actors.util.physics.MovementHandler;

public class BaseActor extends Actor {
    private final AnimationController animationController;
    private float elapsedTime;
    /**
     * Default movement is freeze. If you want to set new movement, using setMovement() method to generate new
     * style of movement.
     */
    private MovementHandler movementHandler;

    private Polygon collider;

    public BaseActor(float x, float y, Stage stage, AnimationController animationController) {
        setPosition(x, y);
        stage.addActor(this);
        this.animationController = animationController;
        elapsedTime = 0;
        movementHandler = null;
        setPropertiesAccordingToTexture();
    }

    public void preventOverlap(BaseActor other) {
        Intersector.MinimumTranslationVector minimumTranslationVector = new Intersector.MinimumTranslationVector();
        boolean overlap = Intersector.overlapConvexPolygons(this.getColliderPolygon(), other.getColliderPolygon(),
                                                            minimumTranslationVector);
        if (overlap) {
            moveBy(minimumTranslationVector.normal.x * minimumTranslationVector.depth,
                   minimumTranslationVector.normal.y * minimumTranslationVector.depth);
        }

    }

    protected Polygon getColliderPolygon() {
        collider.setPosition(getX(), getY());
        collider.setOrigin(getOriginX(), getOriginY());
        collider.setRotation(getRotation());
        collider.setScale(getScaleX(), getScaleY());
        return collider;
    }

    protected void setColliderPolygon(int numberOfSides) {
        float[] vertices = new float[2 * numberOfSides];
        for (int i = 0; i < numberOfSides; i++) {
            float angle = i * 6.28f / numberOfSides;
            vertices[2 * i] = (float) (Math.cos(angle) + 1) * getWidth() / 2;
            vertices[2 * i + 1] = (float) (Math.sin(angle) + 1) * getHeight() / 2;
        }
        collider = new Polygon(vertices);
    }

    public boolean overlaps(BaseActor other) {
        return Intersector.overlapConvexPolygons(this.getColliderPolygon(), other.getColliderPolygon());
    }

    private void setPropertiesAccordingToTexture() {
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

    /**
     * @param movementHandler new movement style
     */
    public void setMovementHandler(MovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }
}
