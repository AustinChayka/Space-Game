public abstract class Particle extends GameObject {
    
    protected float alpha, red, green, blue, x, y, size;
    protected double xVol, yVol;
        
    public Particle(int size, int alpha, int red, int green, int blue, int x, int y,
        double xVol, double yVol) {
        
        this.size = size;
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.x = x;
        this.y = y;
        this.xVol = xVol;
        this.yVol = yVol;
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        if(alpha <= 0 || x < 0 && xVol <= 0 || y < 0 && yVol <= 0 || x > c.getWidth() && xVol >= 0 || 
            y > c.getHeight() && y >= 0) dead = true;
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        r.fillRect((int)x, (int)y, (int)size, (int)size, (int)((int)alpha << 24 | (int)red << 16 | 
                (int)green << 8 | (int)blue), 0);
        
    }
    
}