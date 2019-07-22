package challenge4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class challenge4 {
    private fibonacciHandler fibCalculator;
    @Test
    public void checkFibonacci(){
        fibCalculator = new fibonacciHandler();
        Assert.assertEquals(fibCalculator.calculate(3,0,0), "2 two");
        Assert.assertEquals(fibCalculator.calculate(34,0,0), "5702887 five million seven hundred two thousand eight hundred eighty seven");
        Assert.assertEquals(fibCalculator.calculate(62,0,0), "4052739537881 four trillion fifty two billion seven hundred thirty nine million five hundred thirty seven thousand eight hundred eighty one");
        System.out.println(fibCalculator.calculate(3,0,0));
        System.out.println(fibCalculator.calculate(4,0,0));
        System.out.println(fibCalculator.calculate(5,0,0));
        System.out.println(fibCalculator.calculate(6,0,0));
        System.out.println(fibCalculator.calculate(7,0,0));
        System.out.println(fibCalculator.calculate(8,0,0));
        System.out.println(fibCalculator.calculate(9,0,0));
        System.out.println(fibCalculator.calculate(10,0,0));
        System.out.println(fibCalculator.calculate(11,0,0));
        System.out.println(fibCalculator.calculate(12,0,0));
        System.out.println(fibCalculator.calculate(13,0,0));
        System.out.println(fibCalculator.calculate(14,0,0));
        System.out.println(fibCalculator.calculate(15,0,0));
        System.out.println(fibCalculator.calculate(16,0,0));
        System.out.println(fibCalculator.calculate(17,0,0));
        System.out.println(fibCalculator.calculate(18,0,0));
        System.out.println(fibCalculator.calculate(19,0,0));
        System.out.println(fibCalculator.calculate(20,0,0));
        System.out.println(fibCalculator.calculate(21,0,0));
        System.out.println(fibCalculator.calculate(22,0,0));
        System.out.println(fibCalculator.calculate(23,0,0));
        System.out.println(fibCalculator.calculate(24,0,0));
        System.out.println(fibCalculator.calculate(25,0,0));
        System.out.println(fibCalculator.calculate(26,0,0));
        System.out.println(fibCalculator.calculate(27,0,0));
        System.out.println(fibCalculator.calculate(28,0,0));
        System.out.println(fibCalculator.calculate(29,0,0));
        System.out.println(fibCalculator.calculate(30,0,0));
        System.out.println(fibCalculator.calculate(31,0,0));
        System.out.println(fibCalculator.calculate(32,0,0));
        System.out.println(fibCalculator.calculate(33,0,0));
        System.out.println(fibCalculator.calculate(34,0,0));
        System.out.println(fibCalculator.calculate(35,0,0));
        System.out.println(fibCalculator.calculate(36,0,0));
        System.out.println(fibCalculator.calculate(37,0,0));
        System.out.println(fibCalculator.calculate(38,0,0));
        System.out.println(fibCalculator.calculate(62,0,0));
    }
}
