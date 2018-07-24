 

public abstract class GameObject {
    
    protected String tag;
    protected float x, y;
    protected int width, height;
    protected boolean dead = false;
    
    public abstract void update(Container c, Level l, float dt);
    public abstract void render(Container c, Renderer r);
    
    public boolean collidesWith(GameObject go) {
        
        if(x < go.getX() + go.getWidth() && x + width > go.getX()
           && y - height < go.getY() && y > go.getY() - go.getHeight()) {
            
            return true;
            
        }
       
        return false;
        
    }
    
    public String getTag() {
        
        return tag;
        
    }
    
    public float getX() {
        
        return x;
        
    }
    
    public float getY() {
        
        return y;
        
    }
    
    public int getWidth() {
        
        return width;
        
    }
    
    public int getHeight() {
        
        return height;
        
    }
    
    public void setTag(String tag) {
        
        this.tag = tag;
        
    }
    
    public void setX(float x) {
        
        this.x = x;
        
    }
    
    public void setY(float y) {
        
        this.y = y;
        
    }
    
    public void setWidth(int width) {
        
        this.width = width;
        
    }
    
    public void setHeight(int height) {
        
        this.height = height;
        
    }
    
    public boolean isDead() {
        
        return dead;
        
    }
    
    public void setDead(boolean dead) {
        
        this.dead = dead;
        
    }
    
}