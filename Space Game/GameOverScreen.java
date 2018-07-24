public class GameOverScreen extends GameState {
    
    public GameOverScreen() {
        
        stateName = "gameOver";
        buttons.add(new Button(0, 310, "Res/Textures/Buttons/ExitButton.png", 30, 30, "exitButton"));
        
    }
    
    @Override
    public void init(Container c) {
        
        c.getGUI().setShowing(false);
        if(!init) {
            getButton("exitButton").setX((c.getWidth() - 30) / 2);
            init = true;
        }
        
    }
    
    @Override
    public void update(Container c, StateManager sm, float dt) {
        
        for(Button b : buttons) {
            b.update(c, dt);
            if(b.getName().equals("exitButton") && b.isUp()) c.getFrame().close();
        }
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        c.getGame().getState("mainLevel").render(c, r);
        r.fillRect(0, 0, c.getWidth(), c.getHeight(), 0x69696969, 0);
        r.drawText("Game", (c.getWidth() - r.getTextLength("Game")) / 2, 70, 0xffff0000);
        r.drawText("Over", (c.getWidth() - r.getTextLength("Over")) / 2, 100, 0xffff0000);
        
        r.drawText("Score:" + GUI.scoreCounter, (c.getWidth() - 
            r.getTextLength("Score:" + GUI.scoreCounter)) / 2, 250, 0xffffff00);
            
        for(Button b : buttons) b.render(c, r);
        
    }
    
    @Override
    public void exit() {
        
        
        
    }
    
}