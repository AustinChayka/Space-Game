import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class Frame {
    
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private Graphics g;
    private BufferStrategy bs;
    
    public Frame(Container c) {
        
        image  = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension d = new Dimension((int)(c.getWidth() * c.getScale()), (int)(c.getHeight() * c.getScale())); //fix
        canvas.setPreferredSize(d);
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);
        
        frame = new JFrame(c.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("Res/Textures/Icon.png").getImage());
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setAlwaysOnTop(true);
        frame.toFront();
        frame.requestFocus();
        
        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
        
    }
       
    public Canvas getCanvas() {
        
        return canvas;
        
    }
    
    public BufferedImage getImage() {
        
        return image;
        
    }
    
    public JFrame getFrame() {
        
        return frame;
        
    }
    
    public void update() {
        
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
        
    }
    
    public void setTitle(String newTitle) {
        
        frame.setTitle(newTitle);
        
    }
    
    public void close() {
        
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        
    }
           
}