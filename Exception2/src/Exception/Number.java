package Exception;

public class Number {
    public static int getNumber(int n) throws IntervalException {
        if((n<0) || (n>100)) throw new
                IntervalException("Число не попадает в заданный интервал!",n);
        return n;
    }
}
