/**
 * A class that represents complex numbers
 */
public class Complex {
    public double real;
    public double imaginary;

    /**
     * Create a complex number
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Return the real part
     */
    public double getReal() {
        return real;
    }

    /**
     * Return the imaginary part
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * An impure function that negates this number
     */
    public void negate() {
        real *= -1;
        imaginary *= -1;
    }

    /**
     * A pure function that adds another complex number and returns
     * a new complex number
     */
    public Complex add(Complex other) {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }

    /**
     * A pure function that multiplies another complex number and returns
     * a new complex number
     */
    public Complex mul(Complex other) {
        return new Complex(real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real);
    }

    /**
     * Return a human readable string
     */
    public String toString() {
        String result = "";
        if (real != 0) {
            result += real;
        }
        if (imaginary != 0) {
            if (imaginary > 0 && real != 0) {
                result += "+";
            }
            result += (imaginary + "i");
        }
        return result;
    }

    /*
     * Return the nth in the sequence defined by
     *     z(0) = 4
     *     z(n) = z(n - 1) . i + (1 - i)
     */
    public static Complex zSequence(int n) {
        if (n == 0) {
            return new Complex(4, 0);
        } else {
            return zSequence(n - 1).mul(new Complex(1, 0)).add(new Complex(1, -1));
        }
    }

    /**
     * A small test program. You can add on to this to test your class.
     */
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        System.out.println(c1);               // Should be 3 + 4i

        Complex c2 = new Complex(5, 10);
        System.out.println(c1.add(c2));       // Should be 8 + 14i

        System.out.println(zSequence(13));    // Should be 17 - 13i
    }
}
