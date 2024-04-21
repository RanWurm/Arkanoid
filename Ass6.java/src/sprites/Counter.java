package sprites;
/**
 * @author Ran Wurmbrand
 * @version 1
 * @since 01.09.2022
 */
public class Counter {
    private int count;
    /**
     * constructor.
     * initialize the count member to 0
     */
    public Counter() {
        this.count = 0;
    }
    /**
     * increase.
     * add number to current count.
     * @param number number that we increase the count on.
     */
    public void increase(int number) {
        this.count += number;
    }
    /**
     * decrease.
     * subtract number from current count.
     * @param number the number we decrease the count on;
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * getValue.
     * get current count.
     * @return the count member,which is the current value.
     */
    public int getValue() {
        return this.count;
    }
}