package pt.rm.cupholder_sample;

/**
 * Fake model just for testing purposes.
 *
 * @author ricardomoutinho
 */

public class FakeModel {

    private int mNumber;

    public FakeModel(int number) {
        this.mNumber = number;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        this.mNumber = number;
    }

    public int increment() {
        return ++mNumber;
    }
}
