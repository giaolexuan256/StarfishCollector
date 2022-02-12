package libgdx.javagame.actors.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actors.util.BaseActor;
import libgdx.javagame.actors.util.animation.ImageBasedAnimation;
import libgdx.javagame.actors.util.physics.MovementHandler;

public class Turtle extends BaseActor {
    public Turtle(float x, float y, Stage stage) {
        super(x, y, stage, ImageBasedAnimation.getLoadedAnimationFromFiles(new String[]{"turtle-1.png",
                                                                                        "turtle-2.png",
                                                                                        "turtle-3.png",
                                                                                        "turtle-4.png",
                                                                                        "turtle-5.png",
                                                                                        "turtle-6.png"},
                                                                           0.1f, true));
        setMovementHandler(new MovementHandler(100, 400, 400, this));
        setColliderPolygon(8);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) getMovementHandler().accelerateAtAngle(0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) getMovementHandler().accelerateAtAngle(90);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) getMovementHandler().accelerateAtAngle(180);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) getMovementHandler().accelerateAtAngle(270);
        getMovementHandler().applyPhysics(delta);
    }
}
