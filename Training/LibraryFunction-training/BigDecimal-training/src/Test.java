import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {


        BigDecimal init = null;

        init = new BigDecimal("2147383647481");
        System.out.println("init:"+init);

        BigDecimal divide = new BigDecimal(-10000);
        System.out.println(init+" ÷ "+divide+" = "+(init=init.divide(divide)));

        BigDecimal multiple = new BigDecimal(8080);
        System.out.println(init+" x "+multiple+" = "+(init=init.multiply(multiple)));

        BigDecimal add = new BigDecimal(Integer.MIN_VALUE);
        System.out.println(init+" + "+add+" = "+(init=init.add(add)));

        BigDecimal reduce = new BigDecimal(Long.MAX_VALUE);
        System.out.println(init+" - "+reduce+" = "+(init=init.subtract(reduce)));




        /*保留20位，往0舍入*/
        System.out.println(init.round(new MathContext(20, RoundingMode.UP))); //往零舍入
        System.out.println(init.round(new MathContext(20,RoundingMode.DOWN)));  //往0远离
        System.out.println(init.round(new MathContext(20,RoundingMode.FLOOR)));  //往负无穷处舍入
        System.out.println(init.round(new MathContext(20,RoundingMode.CEILING)));  //往无穷处舍入
        System.out.println(init.round(new MathContext(20,RoundingMode.HALF_EVEN)));  //向最接近数字的方向舍入

    }
}
