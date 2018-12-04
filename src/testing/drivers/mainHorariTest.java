package testing.drivers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

    public class mainHorariTest {
        public static void main(String[] args) {
            Result result = JUnitCore.runClasses(HorariTest.class);

            for(Failure failure: result.getFailures()){
                System.out.println(failure.toString());
            }

            if(result.wasSuccessful()) System.out.println("TOT OK!");
            else System.out.println("ALGUN TEST HA FALLAT");
        }
    }
