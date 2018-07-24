import java.awt.*;

public class Container implements Runnable {
    
    private String version = "v1.5a";
    
    private Thread thread;
    private Frame mainFrame;
    private Renderer renderer;
    private Input input;
    private StateManager game;
    private GUI gui;
    
    private Boolean running  = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    
    private int width = 0, height = 0;
    private float scale = 1f;
    private String title;
    
    private int speed = 2;
        
    public Container(StateManager sm, int w, int h, float sc, String t) {
        
        width = w;
        height = h;
        game = sm;
        game.begin(this);
        scale = sc;
        title = t;
        
    }
    
    public void start() {
        
        mainFrame = new Frame(this);
        renderer = new Renderer(this);
        input = new Input(this);
        gui = new GUI(this);
        
        thread = new Thread(this);
        thread.run();
        
    }
    
    public void run() {
        
        running = true;
        
        boolean render = false;
        double firstTime = 0, lastTime = System.nanoTime() / 1000000000.0, 
            passedTime = 0, unprocessedTime = 0;
            
        double frameTime = 0;
        int fps = 0, frames = 0;
        
        game.init(this);
                
        while(running) {
            
            //render = false;
            
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            
            unprocessedTime += passedTime;
            frameTime += passedTime;
            
            while(unprocessedTime >= UPDATE_CAP) {
                
                unprocessedTime -= UPDATE_CAP;
                render = true;
                
                game.update(this, (float)UPDATE_CAP);
                gui.update(this, (float)UPDATE_CAP);
                
                input.update();
                                
                if(frameTime >= 1.0) {
                    
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    
                }
                
            }
            
            if(render) {
                
                renderer.clear();
                
                game.render(this, renderer);
                renderer.process();
                if(gui.isShowing()) gui.render(this, renderer);
                
                mainFrame.setTitle("Space Game || " + fps);
                
                /*renderer.drawText("" + fps, renderer.getCamX(), 
                    renderer.getCamY(), 0xff00ffff);*/
                
                mainFrame.update();
                frames++;
                                
            } else {
                
                try {
                    
                    Thread.sleep(1);
                    
                } catch(Exception e) {
                    
                    e.printStackTrace();
                    
                }
                
            }
            
        }
        
    }
    
    public int getWidth() {
        
        return width;
        
    }
    
    public int getHeight() {
        
        return height;
        
    }
    
    public float getScale() {
        
        return scale;
        
    }
    
    public String getTitle() {
        
        return title;
        
    }
    
    public Frame getFrame() {
        
        return mainFrame;
        
    }
    
    public Input getInput() {
        
        return input;
        
    }
    
    public Renderer getRenderer() {
        
        return renderer;
        
    }
    
    public StateManager getGame() {
        
        return game;
        
    }
    
    public GUI getGUI() {
        
        return gui;
        
    }
    
}