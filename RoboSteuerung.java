import javakarol.Roboter;
import javakarol.Welt;

/**
 * Die Klasse RoboAufgabe
 */
public class RoboSteuerung extends Thread
{
    // Attribute
    private Roboter robo;
    private Object lock;

    // Konstruktor
    public RoboSteuerung(Roboter robo_, Object lock_)
    {
        robo = robo_;
       lock = lock_;
    }

    // Methoden
    // Roboter läuft bis zur Wand und denkt manchmal nach
    public void run()
    {
        tanzen();
    }

    public void tanzen()
    {
        while(true)
        {
            if (!robo.IstWand())
            {
               sehrVorsichtigerSchritt();
            }
            robo.RechtsDrehen();
            robo.RechtsDrehen();
        }
    }

    public void vorsichtigerSchritt()
    {

        if(!robo.IstRoboter())
        {
            robo.Schritt();
        }
    }

    public void sehrVorsichtigerSchritt()
    {
        synchronized(lock){
            if(!robo.IstRoboter())
            {
                robo.Schritt();
            }
        }
    }
}
