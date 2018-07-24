import java.util.*;

public abstract class Level extends GameState {
    
    protected static final int TS = 16;
    
    protected int levelWidth, levelHeight;
    protected ArrayList<GameObject> objects = new ArrayList<GameObject>();
    protected ArrayList<Particle> particles = new ArrayList<Particle>();
    
    protected Camera camera;
    
    protected Image level;
    protected Image subLevel;
            
    protected boolean init = false;
    
    protected float difficulty = 0;
            
    public GameObject getObject(String tag) {
        
        for(int i = 0; i < objects.size(); i++) {
            
            if(objects.get(i).getTag().equals(tag)) {
                
                return objects.get(i);
                
            }
            
        }
        
        return null;
        
    }
    
    public int getLevelWidth() {
        
        return levelWidth;
        
    }
    
    public int getLevelHeight() {
        
        return levelHeight;
        
    }
    
    public ArrayList<GameObject> getObjects() {
        
        return objects;
        
    }
    
    public void addObject(GameObject go) {
        
        objects.add(go);
        
    }
    
    public void addParticle(Particle p) {
        
        particles.add(p);
        
    }
    
    public Enemy generateEnemy(int range, int xRange) {
        
        int randNum = (int)Math.round(Math.pow(10, (Math.random() * (range - 1)) / (range + 1))) - 1;
        
        switch(randNum) {
                            
            case 1:
                return new FastEnemy((int)(Math.random() * xRange), -30);
            case 2:
                return new ZigZagEnemy((int)(Math.random() * xRange), -30);
            case 3:
                return new DoubleEnemy((int)(Math.random() * xRange), -30);
            
        }
        
        return new Enemy((int)(Math.random() * xRange), -30);
        
    }
    
    public PowerUp generatePowerUp(int range) {
        
        int randNum = (int)(Math.random() * 3);
        
        switch(randNum) {
            
            case 1: 
                return new ShieldIncrease(range);
            case 2:
                return new MoreShots(range);
            
        }
        
        return new HealthPickup(range);
        
    }
        
}