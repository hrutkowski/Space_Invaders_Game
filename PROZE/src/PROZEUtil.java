/**
 * Some common utilities for PRM2T lectures.
 * @author kmi
 * @version 2.0
 */
public class PROZEUtil {

    /**
     * No instances for this class!
     */
    private PROZEUtil() {
    }

    /**
     * Writes a formatted string to {@code System.out} stream using the specified format string and arguments.
     *
     * @param format <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html#syntax">
     * Format string syntax</a>
     * @param args argument to be written.
     */
    public static void pr(String format, Object... args) {
        System.out.format(format, args);
    }

    /**
     * Writes a formatted string to {@code System.out} stream using the specified format string and arguments with
     * the following new line character.
     *
     * @param format <a href="https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Formatter.html#syntax">
     * Format string syntax</a>
     * @param args argument to be written.
     */
    public static void prn(String format, Object... args) {
        pr(format + "%n", args);
    }

    /**
     * Makes current thread sleeping for timeToSleep milliseconds. No exceptions thrown.
     */
    public static void sleep(long timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException ignore) {
        }
    }

    /**
     * Short class' test.
     * @param args not used.
     */
    public static void main(String[] args) {
        pr("");
        pr("1 ");
        pr("test format ");
        pr("%d ", 33);
        prn("%d", 12);
        prn("%d", 21);
        sleep(3000);
    }
}
