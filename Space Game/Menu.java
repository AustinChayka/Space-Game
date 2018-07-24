import java.awt.event.*;
import java.util.*;

public class Menu extends GameState {
    
    private boolean init = false;
    
    private ImageTile playerImage = new ImageTile("Res/Textures/Player.png", 20, 40);
    private float tile = 0;
    
    public Menu() {
        
        this.stateName = "menu";
        buttons.add(new Button(0, 300, "Res/Textures/Buttons/StartButton.png", 100, 70, "startButton"));
                
    }
    
    @Override
    public void init(Container c) {
        
        if(!init) {
            getButton("startButton").setX((c.getWidth() - 100) / 2);
            init = true;
        }
        
    }
    
    @Override
    public void update(Container c, StateManager sm, float dt) {
        
        for(Button b : buttons) {
            b.update(c, dt);
            if(b.getName().equals("startButton") && b.isUp()) sm.changeState("mainLevel", c);
        }
        
        tile += dt * 4;
        if(tile >= 3) tile = 0;
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        r.drawText("Generic", (c.getWidth() - r.getTextLength("Generic")) / 2,
            70, 0xffffff00);
        r.drawText("space game", (c.getWidth() - r.getTextLength("space game")) / 2,
            100, 0xffffff00);
            
        r.drawImageTile(playerImage, (c.getWidth() - playerImage.getTileWidth()) / 2,
            225, (int)tile, 0);
            
        for(Button b : buttons) b.render(c, r);
        
    }
    
    @Override
    public void exit() {
        
        
        
    }
        
}