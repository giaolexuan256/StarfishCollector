package libgdx.javagame;

public class StarfishCollector extends BaseGame {

    private Turtle turtle;
    private BaseActor ocean;

    @Override
    protected void initialize() {
        ocean = new BaseActor(0, 0, mainStage);
        ocean.loadTexture("water.jpg");
        turtle = new Turtle(20, 20, mainStage);
    }

}
