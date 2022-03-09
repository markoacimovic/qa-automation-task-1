import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import util.BrowserClass;

public class SauceDemoStart {
    public static void main(String[] args) {

        if(args.length > 0){
            BrowserClass.BROWSER = args[0];
        }else {
            //here you can change browser m - mozzila, e - edge, c - chrome
            BrowserClass.BROWSER = "m";
        }
        Result result = JUnitCore.runClasses(SauceDemoTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests were successful " + result.wasSuccessful());
    }
}
