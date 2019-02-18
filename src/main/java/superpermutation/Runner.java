package superpermutation;

import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        final int n = 3;
        SuperPermutation superPermutation = new SuperPermutation();
        Map<String, Map<String, Integer>> graph = superPermutation.constructGraph(n);

        String s = superPermutation.getStringOfLength(n);
        List<String> perms = superPermutation.getAllPermutations(s);

        List<List<String>> superPerms = new GenericPermutor<String>().getAllPermutations(perms);

        String answer = getConcatenated(perms);
        for (List<String> cl : superPerms) {
            String tempAnswer = "";
            for (String cs : cl)
                tempAnswer = superPermutation.getCondensedString(tempAnswer, cs);
            answer = tempAnswer.length() < answer.length() ? tempAnswer : answer;
        }
        System.out.println(answer);
    }

    private static String getConcatenated(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
