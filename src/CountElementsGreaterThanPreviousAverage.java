import java.util.List;

/*
Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. Skip the first element.
https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-elements-greater-than-previous-average/problem?isFullScreen=true
 */
public class CountElementsGreaterThanPreviousAverage {

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if ((responseTimes == null) || (responseTimes.size() <= 1)) {
            return 0;
        }
        long sum = responseTimes.get(0);
        int count = 0;
        double avg;

        for (int i = 1; i < responseTimes.size(); i++) {
            avg = (double) sum /i;

            if (responseTimes.get(i) > avg) {
                count++;
            }

            sum += responseTimes.get(i);
        }
        return count;
    }
}
