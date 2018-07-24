import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainLevel extends Level {
    
    private float starDelay = 0.02f;
    private float delay = starDelay;
    
    private float enemyDelay = 0.9f;
    private float spawn = enemyDelay;
    
    private float powerUpDelay = 10f;
    private float powerUpSpawn = powerUpDelay;
    
    public MainLevel() {
        
        stateName = "mainLevel";
        objects.add(new Player(0, 0, 5, 5));
        buttons.add(new Button(0, 15, "Res/Textures/Buttons/PauseButton.png", 30, 30, "pauseButton"));
        
    }
    
    @Override
    public void init(Container c) {
        
        c.getGUI().setShowing(true);
        if(!init) {
            getObject("player").setX(c.getWidth() / 2);
            getObject("player").setY(c.getHeight() - getObject("player").getHeight() - 30);
            getButton("pauseButton").setX(c.getWidth() - 45);
            init = true;
        }
        
    }
    
    @Override
    public void update(Container c, StateManager sm, float dt) {
                
        for(Button b : buttons) {
            b.update(c, dt);
            if(b.getName().equals("pauseButton") && b.isUp()) sm.changeState("pause", c);
        }
        
        if(c.getInput().isKeyDown(KeyEvent.VK_ESCAPE)) sm.changeState("pause", c);
        
        if(difficulty < 4) difficulty += dt / 12;
        GUI.difficulty = (int)difficulty;
        
        enemyDelay -= dt / 200;
        
        if(delay <= 0) {
            objects.add(0, new Star(c.getWidth()));
            delay = starDelay;
        }
        else delay -= dt;
                
        if(spawn <= 0) {
            objects.add(generateEnemy((int)difficulty, c.getWidth()));
            spawn = enemyDelay;
        }
        else spawn -= dt;
        
        if(powerUpSpawn <= 0) {
            if(Math.random() * 2 > 1) objects.add(generatePowerUp(c.getWidth()));
            powerUpSpawn = powerUpDelay;
        }
        else powerUpSpawn -= dt;
        
        for(int i = 0; i < objects.size(); i++) {
            
            objects.get(i).update(c, this, dt);
            if(objects.get(i).isDead()) {
                
                objects.remove(i);
                i--;
                
            }
                                    
        }
        
        for(int i = 0; i < particles.size(); i++) {
            
            particles.get(i).update(c, this, dt);
            if(particles.get(i).isDead()) {
                
                particles.remove(i);
                i--;
                
            }
                                    
        }
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        for(GameObject go : objects) go.render(c, r);
        for(Particle go : particles) go.render(c, r);
        for(Button b : buttons) b.render(c, r);
        
    }
    
    @Override
    public void exit() {
        
       
        
    }
    
}