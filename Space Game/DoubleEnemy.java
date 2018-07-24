public class DoubleEnemy extends Enemy {
    
    private int shots = 0;
    
    public DoubleEnemy(int x, int y) {
        
        super(x, y);
        tag = "doubleEnemy";
        shootDelay = 0.1f;
        image = new ImageTile("Res/Textures/DoubleEnemy.png", 20, 40);
        speed = 100;
        value = 5;
        
    }
    
    @Override
    public void shoot(Level l) {
        
        l.addObject(new Bullet((int)(x), (int)y + height, 1));
        l.addObject(new Bullet((int)(x + width - 2), (int)y + height, 1));
        shots++;
        if(shots == 3) {
            delay = .75f;
            shots = 0;
        }
        
    }
    
}