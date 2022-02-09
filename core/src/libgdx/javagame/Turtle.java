package libgdx.javagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Turtle extends BaseActor {
    public Turtle(float x, float y, Stage stage) {
        super(x, y, stage);
        loadAnimationFromFiles(new String[]{"turtle-1.png",
                                            "turtle-2.png",
                                            "turtle-3.png",
                                            "turtle-4.png",
                                            "turtle-5.png",
                                            "turtle-6.png"},
                               0.1f, true);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            System.out.println("Pressed!!!");
            moveBy(10, 10);
        }
    }
}
