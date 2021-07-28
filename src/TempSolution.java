import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TempSolution {
    static class Solution {

        Map<String, List<String>> mapping = Map.of(
          "A", List.of("AA"),
          "a", List.of("aa"),
          "E", List.of("A"),
          "e", List.of("a"),
          "I", List.of("II", "E"),
          "i", List.of("ii", "e"),
          "H", List.of(""),
          "h", List.of("")
        );

        public List<String> solve(String input) {
            List<String> prev = null;

            for(int i = input.length() - 1;i >= 0;i--) {
                String currentCharacter = input.charAt(i) + "";
                // Without applying rule
                List<String> nextSetWithoutRulesApplied = concatCurrentStringToPrevResults(prev, currentCharacter);

                // With applying rule
                List<String> nextSetWithRulesApplied = concatMappingsToPrevResults(prev, mapping.getOrDefault(currentCharacter, new ArrayList<>()));

                prev = Stream.of(nextSetWithoutRulesApplied, nextSetWithRulesApplied).flatMap(List::stream).collect(Collectors.toList());;
            }
            return prev;
        }

        private List<String> concatCurrentStringToPrevResults(List<String> prev, String currentCharacter) {
            if(prev == null) {
                return Collections.singletonList(currentCharacter);
            }

            List<String> next = new ArrayList<>();
            for(String prevRes: prev) {
                next.add(currentCharacter + prevRes);
            }

            return next;
        }

        private List<String> concatMappingsToPrevResults(List<String> prev, List<String> mappings) {
            if(prev == null) {
                return mappings;
            }

            List<String> next = new ArrayList<>();
            for(String mapping : mappings) {
                for (String prevRes : prev) {
                    next.add(mapping + prevRes);
                }
            }

            return next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve("Alamedah"));
    }
}
