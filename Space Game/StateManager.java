import java.util.*;
import java.awt.*;

public class StateManager {
        
    private GameState previousState;
    
    private GameState currentState;
        
    public ArrayList<GameState> states = new ArrayList<GameState>();
    
    public StateManager() {
                
        states.add(new Menu()); 
        states.add(new MainLevel());
        states.add(new GameOverScreen());        
        states.add(new Pause());
                        
    }
    
    public void begin(Container c) {
     
        changeState("menu", c); 
                
    }
    
    public static void main(String[] args) {
        
        Container c = new Container(new StateManager(), (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2, 2f, "Space");
        c.start();
                
    }
    
    public void init(Container c) {
        
        
        
    }
    
    public void update(Container c, float dt) {
        
        currentState.update(c, this, dt);
        
    }
    
    public void render(Container c, Renderer r) {
        
        currentState.render(c, r);
        
    }
      
    public void changeState(String stateName, Container c) {
        
        previousState = currentState;
        currentState = getState(stateName);
        currentState.init(c);
        
    }
        
    public void changeState(GameState newState, Container c) {
        
        previousState = currentState;
        currentState = newState;
        currentState.init(c);
        
    }
    
    public GameState getState(String stateName) {
        
        for(GameState state: states) {
            
            if(state.getStateName().equals(stateName)) {
                
                return state;
                
            }
            
        }
        
        return null;
        
    }
    
    public GameState getPreviousState() {
        
        return previousState;
        
    }
    
}