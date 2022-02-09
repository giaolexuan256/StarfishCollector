package libgdx.javagame.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import libgdx.javagame.actor.animation.ValueBasedAnimation;

public class Turtle extends BaseActor {
    public Turtle(float x, float y, Stage stage) {
        super(x, y, stage, null);
        String[] filesName = new String[]{"turtle-1.png",
                                          "turtle-2.png",
                                          "turtle-3.png",
                                          "turtle-4.png",
                                          "turtle-5.png",
                                          "turtle-6.png"};
        setAnimationBehavior(new ValueBasedAnimation(filesName, 0.1f, true));
        setSpeed(100);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) setMotionAngle(0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) setMotionAngle(90);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) setMotionAngle(180);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) setMotionAngle(270);
//        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
    }
}
