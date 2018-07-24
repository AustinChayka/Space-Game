public class Button {
    
    private int x, y, width, height;
    
    private ImageTile image;
    
    private boolean pressed, lastPressed;
    
    int tileX = 0;
    
    private String name;
    
    public Button(int x, int y, String path, int tW, int tH, String name) {
        
        image = new ImageTile(path,tW,tH);
        
        this.x = x;
        this.y = y;
        this.width = image.getTileWidth();
        this.height = image.getTileHeight();
        
        this.name = name;
        
    }
    
    public void update(Container c, float dt) {
        
        int mX = c.getInput().getMouseX();
        int mY = c.getInput().getMouseY();
        
        lastPressed = pressed;
        
        if(mX > x && mX < x + width && mY > y && mY < y + height) {
            
            tileX = 1;
            
            if(c.getInput().isButton(1)) {
            
                pressed = true;
                tileX = 2;
            
            } else {
            
                pressed = false;
                
            }
            
        } else {
         
            tileX = 0;
            pressed = false;
            
        }
        
    }
    
    public void render(Container c, Renderer r) {
        
        r.drawImageTile(image, x + r.getCamX(), y + r.getCamY(), tileX, 0);
        
    }
    
    public boolean isPressed() {
        
        return pressed && !lastPressed;
        
    }
    
    public boolean isDown() {
        
        return pressed;
        
    }
    
    public boolean isUp() {
        
        return !pressed && lastPressed;
        
    }
    
    public String getName() {
        
        return name;
        
    }
    
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    public void setY(int y) {
        
        this.y = y;
        
    }
    
}