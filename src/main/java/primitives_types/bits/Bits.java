package primitives_types.bits;

public class Bits {
    private final int number;

    public Bits(int number) {
        this.number = number;
    }

    public int countNumberOfSetBits1() {
        int count = 0;
        int inputNumber = number;
        while (inputNumber != 0) {
            count += (inputNumber & 1);
            inputNumber >>>= 1;
        }
        return count;
    }

    public int countNumberOfSetBits2() {
        int count = 0;
        int inputNumber = number;
        while (inputNumber != 0) {
            inputNumber &= (inputNumber - 1);
            count++;
        }
        return count;
    }

    public int parity1() {
        int parity = 0;
        int inputNumber = number;
        while (inputNumber != 0) {
            parity ^= (inputNumber & 1);
            inputNumber >>>= 1;
        }
        return parity;
    }

    public int parity2() {
        int parity = 0;
        int inputNumber = number;
        while (inputNumber != 0) {
            parity ^= 1;
            inputNumber &= (inputNumber - 1);
        }
        return parity;
    }

    public int parity3() {
        long inputNumber = number;
        inputNumber ^= inputNumber >>> 32;
        inputNumber ^= inputNumber >>> 16;
        inputNumber ^= inputNumber >>> 8;
        inputNumber ^= inputNumber >>> 4;
        inputNumber ^= inputNumber >>> 2;
        inputNumber ^= inputNumber >>> 1;
        return (int) (inputNumber & 0x1);
    }

}
