import javakarol.Roboter;
import javakarol.Welt;
/**
 * Die Klasse Wettlauf
 */
public class Main
{
    public static void main(String[] args)
    {

        Welt welt;
        Roboter robo1, robo2;
        Object lock = new Object();
        welt = new Welt(3,1,6);
        robo1 = new Roboter(1,1,'O',welt);
        robo2 = new Roboter(3,1,'W',welt);

        RoboSteuerung r1 = new RoboSteuerung(robo1,lock);
        RoboSteuerung r2 = new RoboSteuerung(robo2, lock);

        r1.start();
        r2.start();
    }

}
