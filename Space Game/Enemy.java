public class Enemy extends GameObject implements Damageable {
    
    protected int health = 3;
    
    protected float speed = 150;
    
    protected float shootDelay = 1;
    protected float delay = (float)(Math.random());
    
    protected int value = 1;
    
    protected ImageTile image = new ImageTile("Res/Textures/Enemy.png", 20, 40);
    protected float tile = (float)Math.random();
    
    public Enemy(int x, int y) {
        
        tag = "enemy";
        this.x = x;
        this.y = y;
        width = image.getTileWidth();
        height = image.getTileHeight();
        
    }
    
    @Override
    public void update(Container c, Level l, float dt) {
        
        tile += dt * 3.7 * speed / 150;
        if(tile >= 3) tile = 0;
        
        if(health <= 0) {
            dead = true;
            for(int i = 0; i < 8; i++) l.addParticle(new HitSmoke((int)x + width/ 2, 
                    (int)y + height / 2, Math.random() * 100 - 50, Math.random() * 100 - 50));
            GUI.scoreCounter += value;
        }
        
        y += dt * speed;
        
        if(y >= c.getHeight()) dead = true;
        
        if(delay > 0) delay -= dt;
        else {
            
            delay = shootDelay;
            shoot(l);
            
        }
        
        for(GameObject go : l.getObjects()) if(go instanceof Player && this.collidesWith(go)) {
            dead = true;
            ((Damageable)go).dealDamage(health * 2);
        }
        
    }
    
    public void shoot(Level l) {
        
        l.addObject(new Bullet((int)(x + width / 2), (int)y + height, 1));
        
    }
    
    @Override
    public void render(Container c, Renderer r) {
        
        r.drawImageTile(image, (int)x, (int)y, (int)tile, 0);
        
    }
    
    @Override
    public void dealDamage(int damage) {
        
        if(health > damage) health -= damage;
        else health = 0;
        
    }
    
    @Override
    public void heal(int h) {
        
        health += h;
        
    }
    
}