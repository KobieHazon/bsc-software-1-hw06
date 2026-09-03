import il.ac.tau.cs.sw1.hw6.Polynomial;
import il.ac.tau.cs.sw1.hw6.SectionA;
import il.ac.tau.cs.sw1.hw6.SectionB;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RunHw6Checks {
    public static void main(String[] args) {
        testSectionA();
        testSectionB();
        testPolynomial();
        testRiddles();
        System.out.println("24 Java checks passed");
    }

    private static void testSectionA() {
        SectionA stack = new SectionA();
        assertEquals(true, stack.isEmpty(), "new stack empty");
        stack.push("one");
        stack.push("two");
        assertEquals("two", stack.top(), "stack top");
        assertEquals("two", stack.pop(), "stack pop");
        assertEquals("one", stack.pop(), "stack second pop");
        assertEquals(true, stack.isEmpty(), "stack empty after pops");
        expectIllegalArgument(new Runnable() {
            @Override
            public void run() {
                stack.push(null);
            }
        }, "null push rejected");
    }

    private static void testSectionB() {
        assertEquals(true, SectionB.contains(new int[] {1, 2, 3}, 2), "contains value");
        assertEquals(false, SectionB.contains(new int[] {1, 2, 3}, 4), "missing value");
        assertEquals(false, SectionB.contains(null, 1), "null array");
        assertEquals(1, SectionB.min(new int[] {1, 2, 3}), "sorted min");
        assertEquals(-2, SectionB.min2(new int[] {3, -2, 7}), "unsorted min");
        assertEquals(1, SectionB.roots(new int[] {1, 2}).length, "recovered roots placeholder");
        assertEquals("desserts", SectionB.reverse("stressed"), "reverse");
    }

    private static void testPolynomial() {
        Polynomial zero = new Polynomial();
        assertEquals(0, zero.getDegree(), "zero degree");
        assertEquals(0.0, zero.computePolynomial(4.0), "zero value");
        assertEquals(0, zero.getFirstDerivation().getDegree(), "zero derivative degree");

        Polynomial p = new Polynomial(new double[] {1.0, 2.0, 3.0});
        assertEquals(2, p.getDegree(), "degree");
        assertEquals(34.0, p.computePolynomial(3.0), "evaluate");
        assertEquals(0.0, p.getCoefficient(8), "missing coefficient");

        Polynomial doubled = p.multiply(2.0);
        assertEquals(4.0, doubled.getCoefficient(1), "multiply coefficient");
        Polynomial sum = p.adds(doubled);
        assertEquals(9.0, sum.getCoefficient(2), "sum coefficient");

        Polynomial derivative = sum.getFirstDerivation();
        assertEquals(1, derivative.getDegree(), "derivative degree");
        assertEquals(18.0, derivative.getCoefficient(1), "derivative coefficient");

        p.setCoefficient(4, 5.0);
        assertEquals(4, p.getDegree(), "expanded degree");
        assertEquals(5.0, p.getCoefficient(4), "expanded coefficient");
        p.setCoefficient(4, 0.0);
        assertEquals(2, p.getDegree(), "trimmed degree");
        assertEquals(true, new Polynomial(new double[] {-4.0, 0.0, 1.0}).isARoot(2.0), "root check");
    }

    private static void testRiddles() {
        assertEquals("B\nA1\n7\nA2\n", capture(new Runnable() {
            @Override
            public void run() {
                il.ac.tau.cs.sw1.riddle.a.B.main(new String[] {"7"});
            }
        }), "riddle a");
        assertEquals("one\n***\ntwo\n***\nthree\n", capture(new Runnable() {
            @Override
            public void run() {
                il.ac.tau.cs.sw1.riddle.b.C.main(new String[] {"one", "two", "three"});
            }
        }), "riddle b");
        assertEquals("001\n003\n005\n007\n008\n5\nsuccess!\n", capture(new Runnable() {
            @Override
            public void run() {
                il.ac.tau.cs.sw1.riddle.c.B.main(new String[0]);
            }
        }), "riddle c");
        assertEquals("210\n", capture(new Runnable() {
            @Override
            public void run() {
                il.ac.tau.cs.sw1.riddle.d.A.main(new String[0]);
            }
        }), "riddle d");
    }

    private static String capture(Runnable runnable) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return output.toString();
    }

    private static void expectIllegalArgument(Runnable runnable, String label) {
        try {
            runnable.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError(label + " expected IllegalArgumentException");
    }

    private static void assertEquals(Object expected, Object actual, String label) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }

    private static void assertEquals(double expected, double actual, String label) {
        if (Math.abs(expected - actual) > 1e-12) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }
}
