public class ZigZagEnemy extends Enemy {
    
    private int xDir = 1;
    private int startX;
    
    public ZigZagEnemy(int x, int y) {
        
        super(x, y);
        startX = x;
        speed = 50;
        image = new ImageTile("Res/Textures/ZigZagEnemy.png", 20, 40);
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        tile += dt * 2;
        super.update(c, l, dt);
        if(x < 0 || x > c.getWidth() - width || x < startX  - 150 || x > startX + 150 - width) 
            xDir *= -1;
        x += dt * xDir * speed * 2;
        
    }
    
}