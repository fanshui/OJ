package basic;

import java.math.BigDecimal;

public class BigMathComp {

    public static void main(String[] args) {

        System.out.println("==double 0.1==");
        double zerodoanone = 1 - 0.9;
        double o1 = 0.1;
        System.out.println("o1 = 0.1 :  o1 = " + o1);
        System.out.println("zerodoanone = 1 - 0.9 : zerodoanone = " + zerodoanone);

        System.out.println("==bigdecimal 0.1==");
        BigDecimal zerodoanone2 = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(0.9));
        System.out.println("zerodoanone2 = BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.9)) :  zerodoanone2 = " + zerodoanone2);

        BigDecimal big = new BigDecimal("1.0");
        BigDecimal big2 = new BigDecimal("0.9");
        BigDecimal big3 = big.subtract(big2);
        System.out.println(big3);


    }

}
