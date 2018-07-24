public class Star extends GameObject {
    
    private int size;
    private double x, y;
    
    public Star(int range) {
        
        tag = "star";
        size = (int)(Math.random() * 3 + 1);
        x = (int)(Math.random() * range);
        y = -size;
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        y += size * 35 * dt;
        if(y > c.getHeight()) dead = true;
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        r.fillRect((int)x, (int)y, size, size, ((int)(175 * (size / 3.0)) << 24 | 255 << 16 | 
                255 << 8 | 255), 0);
        
    }
    
}