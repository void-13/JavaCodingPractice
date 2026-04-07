/*
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindTheHighestAltitude {
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int largestAltitude(int[] gain) {
        if (gain==null || gain.length==0) {
            return 0;
        }

        int highest_altitude = 0;
        int sum = 0;

        for (int alt : gain) {
            sum += alt;
            highest_altitude = Math.max(highest_altitude, sum);
        }
        return highest_altitude;
    }

    public static void main(String[] args) {
        FindTheHighestAltitude findTheHighestAltitude = new FindTheHighestAltitude();
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(findTheHighestAltitude.largestAltitude(gain));
    }
}
