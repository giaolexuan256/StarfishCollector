package libgdx.javagame.game;

import libgdx.javagame.actors.objects.Rock;
import libgdx.javagame.actors.util.BaseActor;
import libgdx.javagame.actors.objects.Starfish;
import libgdx.javagame.actors.objects.Turtle;
import libgdx.javagame.actors.util.animation.NoAnimation;

public class StarfishCollector extends BaseGame {

    private BaseActor ocean;
    private Turtle turtle;
    private Starfish starfish;
    private Rock rock;

    @Override
    protected void initialize() {
        ocean = new BaseActor(0, 0, mainStage, NoAnimation.getInstance("water.jpg"));
        turtle = new Turtle(20, 20, mainStage);
        starfish = new Starfish(380, 380, mainStage);
        rock = new Rock(200, 200, mainStage);
    }

    @Override
    public void updateObjects() {

        turtle.preventOverlap(rock);

        if(turtle.overlaps(starfish)) {
            starfish.remove();
        }
    }

}
