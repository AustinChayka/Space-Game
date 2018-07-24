public class FastEnemy extends Enemy {
        
    public FastEnemy(int x, int y) {
        
        super(x, y);
        tag = "fastEnemy";
        image = new ImageTile("Res/Textures/FastEnemy.png", 10, 20);
        width = image.getTileWidth();
        height = image.getTileHeight();
        speed = 350;
        health = 2;
        value = 3;
        
    }
    
    @Override
    public void shoot(Level l) { }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        super.update(c, l, dt);
        
        if(l.getObject("player") != null && l.getObject("player").getY() > y) {
            x += Math.signum(l.getObject("player").getX() - x) * speed / 3.0 * dt;
        }
        
    }
    
}