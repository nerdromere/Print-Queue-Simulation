package AlphaPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *******************************************************************************
 * File name        SplashScreen.java 
 * <br>Description      This is the splashscreen for project 3 
 * <br>Created on       1/26/2018 macOS Sierra, Version 10.12.1, NetBeans 8.2, 
 *                  jdk 1.8.0_144
 * @author          Illarion Eremenko
 * @version         1.0.4
 * <pre> 
 *   project:       Project #3, Print Queue Simulation
 *   platform:      JDK 1.8.0_141
 *   IDE:           Netbeans 8.2 
 *   course:        CS142,
 *   hours:         2 minutes 
 * </pre> 
 * @see              java.awt.BorderLayout
 * @see              java.awt.Color
 * @see              java.awt.Dimension
 * @see              java.awt.Toolkit
 * @see              java.lang.Thread
 * @see              javax.swing.ImageIcon
 * @see              javax.swing.JLabel
 * @see              javax.swing.JProgressBar
 * @see              javax.swing.JWindow
 *****************************************************************************
 */
public class SplashScreen extends JWindow{
    private ImageIcon myIcon;
    private JLabel myLabel;
    private JProgressBar bar;
    private static int WIDTH;
    private static int HEIGHT;
    static{
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/HelperFiles/printer.png"));
        WIDTH = image.getIconWidth();
        HEIGHT = image.getIconHeight();
    }
    private final int WIDTHBAR = WIDTH;
    private final int HEIGHTBAR = 30;
    /**
     * Default constructor which builds the splashscreen.
     */
    public SplashScreen() {
        super();
        this.setBounds(0, 0, WIDTH, HEIGHT + HEIGHTBAR);
        this.setSize(WIDTH, HEIGHT + HEIGHTBAR);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        myLabel = new JLabel();
        myIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/HelperFiles/printer.png"));
        myLabel.setIcon(myIcon);
        this.add(myLabel, BorderLayout.NORTH);
        
        bar = new JProgressBar();
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setStringPainted(true);
        bar.setForeground(Color.LIGHT_GRAY);
        //bar.setBounds(0, 0, 650, 30);
        bar.setPreferredSize(new Dimension(WIDTHBAR, HEIGHTBAR));
        this.add(bar, BorderLayout.SOUTH);
        
        this.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                int time = 101;
                int i = 0;
                while (i <= 100) {
                    bar.setValue(i);
                    try {
                        sleep(time);
                        time -= 1;
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    i++;
                }
            }
        };
        t.start();
    }
}
