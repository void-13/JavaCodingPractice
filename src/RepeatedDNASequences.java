import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10)
        {
            return new ArrayList<>();
        }

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        int left = 0;
        for (int right = 10; right<=s.length(); right++) {
            String dna = s.substring(left, right);

            if (seen.contains(dna)) {
                repeated.add(dna);
            } else {
                seen.add(dna);
            }
            left++;
        }
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        RepeatedDNASequences dnaSequences = new RepeatedDNASequences();
        List<String> result = dnaSequences.findRepeatedDnaSequences("AAAA");

        System.out.println(result);
    }
}
