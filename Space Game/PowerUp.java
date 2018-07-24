public abstract class PowerUp extends GameObject {
    
    private float speed = 100;
    protected Image image;
    
    public PowerUp(int range) {
        
        x = (float)(Math.random() * (range - 30));
        width = 20;
        height = 20;
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        y += dt * speed;
        if(collidesWith(l.getObject("player"))) {
            
            apply(l);
            dead = true;
            
        }
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        r.drawImage(image, (int)x, (int)y);
        
    }
    
    protected abstract void apply(Level l);
    
}