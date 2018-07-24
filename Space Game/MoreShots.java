public class MoreShots extends PowerUp {
    
    public MoreShots(int range) {
        
        super(range);
        image = new Image("Res/Textures/MoreShots.png");
        tag = "moreShots";
        
    }
    
    @Override
    public void apply(Level l) {
        
        ((Player)l.getObject("player")).addShot(1);
        
    }
    
}