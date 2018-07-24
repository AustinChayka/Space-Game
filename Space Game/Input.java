import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    
    Container c;
    
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];
    
    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];
    
    private int mouseX, mouseY;
    
    private int scroll;
    
    public Input(Container c) {
        
        this.c = c;
        
        mouseX = 0;
        mouseY = 0;
        scroll = 0;
        
        c.getFrame().getCanvas().addKeyListener(this);
        c.getFrame().getCanvas().addMouseListener(this);
        c.getFrame().getCanvas().addMouseMotionListener(this);
        c.getFrame().getCanvas().addMouseWheelListener(this);
        
    }
    
    public void update() {
        
        for(int i = 0; i < NUM_KEYS; i++) {
            
            keysLast[i] = keys[i];
            
        }
        
        for(int i = 0; i < NUM_BUTTONS; i++) {
            
            buttonsLast[i] = buttons[i];
            
        }
        
    }
    
    public boolean isKey(int keyCode) {
        
        return keys[keyCode];
        
    }
    
    public boolean isKeyUp(int keyCode) {
        
        return !keys[keyCode] && keysLast[keyCode];
        
    }
    
    public boolean isKeyDown(int keyCode) {
        
        return keys[keyCode] && !keysLast[keyCode];
        
    }
    
    public boolean isButton(int buttonCode) {
        
        return buttons[buttonCode];
        
    }
    
    public boolean isButtonUp(int buttonCode) {
        
        return !buttons[buttonCode] && buttonsLast[buttonCode];
        
    }
    
    public boolean isButtonDown(int buttonCode) {
        
        return buttons[buttonCode] && !buttonsLast[buttonCode];
        
    }
    
    @Override
    public void keyTyped(KeyEvent k) { }
    
    @Override
    public void keyPressed(KeyEvent k) {
        
        keys[k.getKeyCode()] = true;
        
    }
    
    @Override
    public void keyReleased(KeyEvent k) {
        
        keys[k.getKeyCode()] = false;
        
    }
       
    @Override
    public void mouseExited(MouseEvent m) { }
    
    @Override
    public void mouseEntered(MouseEvent m) { }
    
    @Override
    public void mouseReleased(MouseEvent m) {
        
        buttons[m.getButton()] = false;
        
    }
    
    @Override
    public void mousePressed(MouseEvent m) {
        
        buttons[m.getButton()] = true;
        
    }
    
    @Override
    public void mouseClicked(MouseEvent m) { }
    
    @Override
    public void mouseMoved(MouseEvent m) {
        
        mouseX = (int)(m.getX() / c.getScale());
        mouseY = (int)(m.getY() / c.getScale());
        
    }
    
    @Override
    public void mouseDragged(MouseEvent m) {
        
        mouseX = (int)(m.getX() / c.getScale());
        mouseY = (int)(m.getY() / c.getScale());
        
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent m) {
        
        scroll = m.getWheelRotation();
        
    }
    
    public int getMouseX() {
        
        return mouseX;
        
    }
    
    public int getMouseY() {
        
        return mouseY;
        
    }
    
    public int getScroll() {
        
        return scroll;
        
    }
    
}