public class NumberCompliment {

    public static void main(String[] args) {
        System.out.println(findComplement(2147483647));
        System.out.println(findComplement2(2147483647)); // 0
        System.out.println(findComplement2(2147483646)); // 1
    }

    /** Approach -1 :: Find the decimal and flip the bits.
     *
     * LeetCode stats:
     * Runtime: 9 ms, faster than 7.23% of Java online submissions.
     * Memory Usage: 37.5 MB, less than 11.11% of Java online submissions.
     * */
    public static int findComplement(int num) {
        String binary = findBinaryForDecimal(num);
        System.out.println(binary);
        int compliment = findDecimalForBinaryCompliment(binary);
        return compliment;
    }

    public static String findBinaryForDecimal(int num) {
        if(num == 0) {
            return  "0";
        }
        String buffer = new String();
        while (num > 0) {
            int temp = num % 2;
            num = num / 2;
            buffer = temp + buffer;
        }
        return buffer;
    }

    public static int findDecimalForBinaryCompliment(String binary) {
        int decimal = 0;
        int power = binary.length() - 1;
        for(int index = 0; index < binary.length(); index++) {
            int temp = (binary.charAt(index) == '0') ? 1 : 0;
            decimal += temp * Math.pow(2, power);
            power--;
        }
        return decimal;
    }

    /** Approach - 2 :: Find the power of 2 that is just greater than element.
     * How does that helps us? Think....Think.... It says the number of bits.
     * So what next? Find max value i.e., 2^power - 1
     * Ex: 10 -> 1010
     * Our program finds power as 4. Max number with 4 bits is 15 i., 2^4 - 1.
     * Next return max - number i.e., 15 - 10 => 5
     *
     * LeetCode stats:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 36 MB, less than 11.11% of Java online submissions.
     * */
    public static int findComplement2(int num) {
        /** Base case */
        if(num == 0) {
            return 1;
        }
        int temp = num;
        int power = 0;
        while (temp > 0) {
            temp = temp / 2;
            power++;
        }
        int max = (int)Math.pow(2, power-1);
        max += max - 1;
        return  max - num;
    }
}

