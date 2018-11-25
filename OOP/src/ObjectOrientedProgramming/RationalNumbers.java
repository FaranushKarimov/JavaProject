package ObjectOrientedProgramming;

public class RationalNumbers {
    private int numerator;
    private int denumerator;

    /**
     * наибольший общий делитель а и b
     *
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель a и b
     */
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else
            return gcd(b % a, a);
    }

    public RationalNumbers() {
        this.numerator = 1;
        this.denumerator = 1;
    }

    public RationalNumbers(int numerator, int denumerator) {
        if (denumerator == 0) {
            throw new IllegalArgumentException("denumerator may not be zero");
        }
        this.numerator = numerator;
        this.denumerator = denumerator;
        if (numerator != 0) {
            int gcd = RationalNumbers.gcd(numerator, denumerator);
            this.numerator /= gcd;
            this.denumerator /= gcd;
        }
    }

    public String toString() {
        if (denumerator == 1 || numerator == 0)
            return "" + numerator;
        return numerator + "/" + denumerator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenumerator() {
        return this.denumerator;
    }

    public RationalNumbers times(RationalNumbers r) {
        return new RationalNumbers(this.numerator * r.numerator, this.denumerator * r.denumerator);
    }

    public static RationalNumbers product(RationalNumbers a, RationalNumbers b) {
        return new RationalNumbers(a.numerator * b.numerator, a.denumerator * b.denumerator);
    }

    public static void main(String[] args) {
        RationalNumbers r = new RationalNumbers(5, 7);
        System.out.println("r.getNumerator()=" + r.getNumerator());
        System.out.println("r.getDenumerator()=" + r.getDenumerator());
    }
}
