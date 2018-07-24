public class HealthPickup extends PowerUp{
    
    public HealthPickup(int range) {
        
        super(range);
        image = new Image("Res/Textures/HealthPowerUp.png");
        tag = "healthPowerUp";
        
    }
    
    @Override
    public void apply(Level l) {
        
        ((Damageable)(l.getObject("player"))).heal(3);
        
    }
    
}