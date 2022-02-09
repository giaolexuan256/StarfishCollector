package libgdx.javagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseGame extends Game {

    protected Stage mainStage;

    @Override
    public void create() {
        mainStage = new Stage();
        initialize();
    }
    protected abstract void initialize();

    @Override
    public void render() {
        super.render();

        mainStage.act();

        ScreenUtils.clear(Color.WHITE);

        mainStage.draw();
    }

}
