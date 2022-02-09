package libgdx.javagame;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseActor extends Actor {
    public BaseActor(float x, float y, Stage stage) {
        setPosition(x, y);
        stage.addActor(this);
    }
}
