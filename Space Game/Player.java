import java.awt.event.*;
import java.util.*;

public class Player extends GameObject implements Damageable {
    
    private int health;
    private int maxShield;
    private int shield;
    
    private float speed = 200;
    
    private float bulletDelay = 0.1f;
    private float delay = bulletDelay;
    
    private float shieldRegen = .8f;
    private float regen = shieldRegen;
    
    private ImageTile image = new ImageTile("Res/Textures/Player.png", 20, 40);
    
    private float tile = 0;
    
    private int shots = 1;
    
    public Player(int x, int y, int health, int shield) {   
         
        this.tag = "player";
        this.x = x;
        this.y = y;    
        this.width = image.getTileWidth();
        this.height = image.getTileHeight();  
        this.health = health;
        GUI.maxHealth = health;
        GUI.currentHealthTarget = health;
        maxShield = shield;
        this.shield = maxShield;
        GUI.maxShield = shield;
        GUI.currentShieldTarget = shield;

    }

    @Override
    public void update(Container c, Level l, float dt) {
        
        if(health <= 0) c.getGame().changeState("gameOver", c);
        
        if(delay > 0) delay -= dt;
        
        if(delay <= 0 && c.getInput().isKey(KeyEvent.VK_SPACE)) {
                        
            shoot(l);
            delay = bulletDelay;
            
        }

        if(c.getInput().isKey(KeyEvent.VK_A)) {
            
            if(x > 0) x -= speed * dt;
            if(tile == 0) tile = 1;
            tile += dt * 3 * speed / 150;
            if(tile >= 3) tile = 1;
            
        } else if(c.getInput().isKey(KeyEvent.VK_D)) {
            
            if(x + width < c.getWidth()) x += speed * dt;
            if(tile == 0) tile = 1;
            tile += dt * 3 * speed / 150;
            if(tile >= 3) tile = 1;
            
        } else tile = 0;
        
        if(regen > 0) regen -= dt;
        else {
            if(shield < maxShield) {
                shield += 1;
                GUI.currentShieldTarget = shield;
            }
            regen = shieldRegen;
        }

    }

    @Override
    public void render(Container c, Renderer r) {

        r.drawImageTile(image, (int)x, (int)y, (int)tile, 0);

    }
    
    @Override
    public void dealDamage(int damage) {
        
        regen = shieldRegen * 2;
        if(shield > damage) shield -= damage;
        else {
            damage -= shield;
            shield = 0;
            if(health > damage) health -= damage;
            else health = 0;
            GUI.currentHealthTarget = health;
        }
        GUI.currentShieldTarget = shield;
        
    }

    public void setX(float x) {

        this.x = x;

    }

    public void setY(float y) {

        this.y = y;

    }
    
    @Override
    public void heal(int h) {
        
        health += h;
        GUI.currentHealthTarget = health;
        
    }
    
    public void increaseMaxShield(int s) {
        
        maxShield += s;
        GUI.maxShield = maxShield;
        
    }
    
    public void shoot(Level l) {
        
        int newShots = shots;
        float spread = 3f;
        if(shots % 2 == 0) {
            newShots++;
            spread = 9;
        }
            
        for(int i = 0; i < newShots; i++) { 
            if(shots % 2 == 1 || i != (int)Math.round(shots / 2)) l.addObject(new Bullet((int)(x + (i + 1) * (width / 
                (newShots + 1))), (int)y, -1, (-newShots / 2 + i) / (spread * newShots)));
        }
        
    }
    
    public void addShot(int s) {
        
        shots += s;
        
    }

}