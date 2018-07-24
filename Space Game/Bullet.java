public class Bullet extends GameObject {
    
    private float speed = 400, yDir, xDir = 0;
    private int damage = 1;
    
    public Bullet(int x, int y, int dir) {
        
        this.x = x;
        this.y = y;
        width = 1;
        height = 2;
        yDir = dir;
        if(yDir == 1) speed = 350;
        
    }
    
    public Bullet(int x, int y, int dir, float xDir) {
        
        this.x = x;
        this.y = y;
        width = 1;
        height = 2;
        yDir = dir;
        if(yDir == 1) speed = 350;
        this.xDir = xDir;
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        if(y < 0 || y + height > c.getHeight()) dead = true;
        y += yDir * speed * dt;
        x += xDir * speed * dt;
        
        for(GameObject go : l.getObjects()) if(go instanceof Damageable && this.collidesWith(go)) {
            
            if(!(go instanceof Player && yDir == -1 || go instanceof Enemy && yDir == 1)) {
                if(yDir == -1) for(int i = 0; i < 2; i++) l.addParticle(new HitSmoke((int)x, 
                    (int)y, (int)Math.signum(yDir)));
                ((Damageable)go).dealDamage(1);
                dead = true;
            }
            
        }
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        if(yDir == 1) r.fillRect((int)x, (int)y, width, height, 0xffff0000, 0);
        else r.fillRect((int)x, (int)y, width, height, 0xff0000ff, 0);
        
    }
    
    public int getDir() {
        
        return (int)Math.signum(yDir);
        
    }
    
}