package challenge4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class challenge4 {
    private fibonacciHandler fibCalculator;

    @Test
    public void checkFibonacci() {
        fibCalculator = new fibonacciHandler();
        System.out.println(fibCalculator.calculate(3));
        Assert.assertEquals(fibCalculator.calculate(3), "2 two");
        System.out.println(fibCalculator.calculate(34));
        Assert.assertEquals(fibCalculator.calculate(34), "5702887 five million seven hundred two thousand eight hundred eighty seven");
        System.out.println(fibCalculator.calculate(62));
        Assert.assertEquals(fibCalculator.calculate(62), "4052739537881 four trillion fifty two billion seven hundred thirty nine million five hundred thirty seven thousand eight hundred eighty one");
    }
}
