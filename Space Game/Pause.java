import java.awt.event.*;

public class Pause extends GameState {
    
    public Pause() {
        
        stateName = "pause";
        buttons.add(new Button(0, 220, 
            "Res/Textures/Buttons/ResumeButton.png", 30, 30, "resumeButton"));
        buttons.add(new Button(0, 220,
            "Res/Textures/Buttons/ExitButton.png", 30, 30, "exitButton"));
        
    }
    
    @Override
    public void init(Container c) {
        
        if(!init) {
            getButton("resumeButton").setX((c.getWidth() - 75) / 2);
            getButton("exitButton").setX(c.getWidth() / 2);
            init = true;
        }
       
    }
    
    
    @Override
    public void update(Container c, StateManager sm, float dt) {
        
        for(Button b : buttons) {
            b.update(c, dt);
            if(b.getName().equals("resumeButton") && b.isUp()) sm.changeState("mainLevel", c);
            else if(b.getName().equals("exitButton") && b.isUp()) c.getFrame().close();
        }
        if(c.getInput().isKeyDown(KeyEvent.VK_ESCAPE)) sm.changeState("mainLevel", c);
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        c.getGame().getState("mainLevel").render(c, r);
        r.fillRect(0, 0, c.getWidth(), c.getHeight(), 0x69696969, 0);
        r.drawText("Paused", (c.getWidth() - r.getTextLength("Paused")) / 2, 150, 0xffffff00);
        for(Button b : buttons) b.render(c, r);
        
    }
    
    @Override
    public void exit() {
        
        
        
    }
    
}