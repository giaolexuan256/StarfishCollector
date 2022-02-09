package libgdx.javagame;

import libgdx.javagame.actor.BaseActor;
import libgdx.javagame.actor.Turtle;
import libgdx.javagame.actor.animation.NoAnimation;

public class StarfishCollector extends BaseGame {

    private BaseActor ocean;
    private Turtle turtle;

    @Override
    protected void initialize() {
        ocean = new BaseActor(0, 0, mainStage, new NoAnimation("water.jpg"));
        turtle = new Turtle(20, 20, mainStage);
    }

    @Override
    public void updateObjects() {

    }

}
