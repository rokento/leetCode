import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CircularGameLosers_2682 {
    public int[] circularGameLosers(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int temp = 1;
        list.add(temp);
        int number = (temp + (count * k)) % n == 0 ? n:(temp + (count * k)) % n;
        while (!list.contains(number)) {
            list.add(number);
            temp += (count * k);
            count++;
            number = (temp + (count * k)) % n == 0 ? n:(temp + (count * k)) % n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if (!list.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        CircularGameLosers_2682 c = new CircularGameLosers_2682();
        System.out.println(Arrays.toString(c.circularGameLosers(4, 1)));
    }
}
