package libgdx.javagame.game;

import com.badlogic.gdx.Game;
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

        updateObjects();

        ScreenUtils.clear(Color.WHITE);

        mainStage.draw();
    }

    public abstract void updateObjects();

}
