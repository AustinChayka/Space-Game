import java.util.*;

public abstract class GameState {
    
    protected String stateName;
    
    protected ArrayList<Button> buttons = new ArrayList<Button>();
    
    protected boolean init = false;
    
    public abstract void init(Container c);
    public abstract void update(Container c, StateManager sm, float dt);
    public abstract void render(Container c, Renderer r);
    public abstract void exit();
    
    public String getStateName() {
        
        return stateName;
        
    }
    
    public Button getButton(String tag) {
        
        for(int i = 0; i < buttons.size(); i++) {
            
            if(buttons.get(i).getName().equals(tag)) {
                
                return buttons.get(i);
                
            }
            
        }
        
        return null;
        
    }
    
}