import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max_element = Integer.MIN_VALUE;
        int sum;

        if (candies == null || candies.length == 0) {
            return  result;
        }

        for (int j : candies) {
            max_element = Math.max(max_element, j);
        }

        for (int candy : candies) {
            sum = candy + extraCandies;
            if (sum >= max_element) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies obj = new KidsWithTheGreatestNumberOfCandies();
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> result = obj.kidsWithCandies(candies, extraCandies);
        System.out.println(result.toString());
    }
}
