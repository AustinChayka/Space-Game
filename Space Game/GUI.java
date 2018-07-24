public class GUI {
    
    private boolean showing = false;
    
    public static int scoreCounter = 0;
    public static int maxHealth = 0;
    public static int currentHealthTarget = 0;
    public static float currentHealth = 0;
    public static int maxShield = 0;
    public static int currentShieldTarget = 0;
    private static float currentShield = 0;
    
    private int barWidth;
    private int barHeight = 10;
    
    public static int difficulty = 0;
    
    public GUI(Container c) {
        
        barWidth = c.getWidth() / 3;
        
    }
    
    public void update(Container c, float dt) {
        
        if(currentHealthTarget > maxHealth) maxHealth = currentHealthTarget;
        barWidth = (int)(c.getWidth() * (maxHealth / 45.0));
        
        if(Math.abs(currentHealth - currentHealthTarget) > .01) currentHealth += 
            Math.signum(currentHealthTarget - currentHealth) * dt * 4;
            
        if(Math.abs(currentShield - currentShieldTarget) > .01) currentShield += 
            Math.signum(currentShieldTarget - currentShield) * dt * 4;
        
    }
    
    public void render(Container c, Renderer r) {
        
        r.drawText("" + scoreCounter, 10, 0, 0xffffffff);
        
        r.fillRect((c.getWidth() - barWidth) / 2, c.getHeight() - 20, barWidth - 1, 
            barHeight, 0xff696969, 0);
        if(currentHealth > .01) r.fillRect((c.getWidth() - barWidth) / 2 + 
            (barWidth - (int)(barWidth * ((double)currentHealth / maxHealth))) / 2,
            c.getHeight() - 20, (int)(barWidth * ((double)currentHealth / maxHealth)), 
            barHeight, 0xffff0000, 0);
        if(currentShield > .01) r.fillRect((c.getWidth() - barWidth) / 2 + 
            (barWidth - (int)(barWidth * ((double)currentShield / maxShield))) / 2,
            c.getHeight() - 20, (int)(barWidth * ((double)currentShield / maxShield)), 
            barHeight, 0x690000ff, 0);
            
        //r.drawText("" + difficulty, c.getWidth() - r.getTextLength("" + difficulty), 0, 0xffff0000);
        
    }
    
    public void setShowing(boolean showing) {
        
        this.showing = showing;
        
    }
    
    public boolean isShowing() {
        
        return showing;
        
    }
    
}