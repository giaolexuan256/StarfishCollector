package libgdx.javagame.actors.util.physics;

import com.badlogic.gdx.math.Polygon;
import libgdx.javagame.actors.util.BaseActor;

public class BoxCollider {
    private BaseActor actor;
    private Polygon collider;

    public BoxCollider(BaseActor actor) {
        this.actor = actor;
    }

    protected Polygon getColliderPolygon() {
        collider.setPosition(actor.getX(), actor.getY());
        collider.setOrigin(actor.getOriginX(), actor.getOriginY());
        collider.setRotation(actor.getRotation());
        collider.setScale(actor.getScaleX(), actor.getScaleY());
        return collider;
    }

    protected void setColliderPolygon(int numberOfSides) {
        float[] vertices = new float[2 * numberOfSides];
        for (int i = 0; i < numberOfSides; i++) {
            float angle = i * 6.28f / numberOfSides;
            vertices[2 * i] = (float) (Math.cos(angle) + 1) * actor.getWidth() / 2;
            vertices[2 * i + 1] = (float) (Math.sin(angle) + 1) * actor.getHeight() / 2;
        }
        collider = new Polygon(vertices);
    }
}
