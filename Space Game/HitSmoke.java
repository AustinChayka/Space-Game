public class HitSmoke extends Particle {
    
    public HitSmoke(int x, int y, int dir) {
                
        super(1, 200, 255, 100, 100, x, y, (int)(Math.random() * 100 - 50), 
            (Math.random() * 100 + 20) * dir);
        
        tag = "smoke";
        
    }
    
    public HitSmoke(int x, int y, double xVol, double yVol) {
                
        super(1, 200, 255, 100, 100, x, y, xVol, yVol);
        
        tag = "smoke";
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        super.update(c, l, dt);
        
        yVol += 150 * dt;
        if(Math.abs(xVol) > 0.1) xVol -= Math.signum(xVol) * dt;
        size += dt * 4;
        alpha -= 100 * dt;
        green += 30 * dt;
        blue += 30 * dt;
        x += xVol * dt;
        y += yVol * dt;
        
    }
    
}