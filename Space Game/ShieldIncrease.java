public class ShieldIncrease extends PowerUp {
    
    public ShieldIncrease(int range) {
        
        super(range);
        image = new Image("Res/Textures/ShieldIncrease.png");
        tag = "shieldIncrease";
        
    }
    
    @Override
    public void apply(Level l) {
        
        ((Player)l.getObject("player")).increaseMaxShield(3);
        
    }
    
}