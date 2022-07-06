import java.util.ArrayList;
import java.util.List;

public class LuhnAlgorithm {

    public static boolean luhnAlgorithm(String cardNum) {
        int cardLength = cardNum.length();
        int sum = 0;
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < cardLength; i++) {
            int currentNumber = Integer.parseInt(cardNum.substring(cardLength - i - 1, cardLength - i));
            if (i % 2 != 0) {
                if (currentNumber * 2 > 9) {
                    sum += currentNumber * 2 / 10;
                    sum += currentNumber * 2 % 10;
                } else {
                    sum += currentNumber * 2;
                }
                numList.add(currentNumber * 2);
            } else {
                sum += currentNumber;
                numList.add(currentNumber);
            }
        }
//        System.out.println(numList);
//        System.out.println(sum);

        if (sum % 10 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(luhnAlgorithm("1234567890123456"));
        System.out.println(luhnAlgorithm("4408041234567893"));
        System.out.println(luhnAlgorithm("38520000023237"));
        System.out.println(luhnAlgorithm("4222222222222"));
    }
}
