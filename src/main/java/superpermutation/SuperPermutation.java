package superpermutation;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperPermutation {
    private Map<String, Map<String, Integer>> graph;

    public Map<String, Map<String, Integer>> constructGraph(int n) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        String str = getStringOfLength(n);
        List<String> perms = getAllPermutations(str);

        for (int i = 0; i < perms.size(); i++) {
            for (int j = 0; j < perms.size(); j++) {
                if (i != j) {
                    graph.putIfAbsent(perms.get(i), new HashMap<>());
                    graph.get(perms.get(i)).
                            put(perms.get(j), getWeight(perms.get(i), perms.get(j)));
                }
            }
        }

        return graph;
    }

    /**
     * assuming that a and b are of equal length
     * a directed edge from a to b
     *
     * @param a
     * @param b
     * @return
     */
    @VisibleForTesting
    int getWeight(String a, String b) {
        if (a.length() != b.length())
            throw new IllegalArgumentException("both the strings should be of equal length");
        return getCondensedString(a, b).length();
    }


    @VisibleForTesting
    String getCondensedString(String a, String b) {
        if (a == null || a.length() == 0) {
            if (b == null) return "";
            return b;
        }
        if (b == null || b.length() == 0) {
            if (a == null) return "";
            return a;
        }
        int m = a.length();
        int n = b.length();
        int maxMatching = 0;
        for (int i = 1; i <= Math.min(m, n); i++) {
            int j, k;
            for (j = 0, k = m - i; k < m && j < n; k++, j++) {
                if (b.charAt(j) != a.charAt(k)) {
                    break;
                }
            }
            if (k == m) {
                maxMatching = Math.max(maxMatching, j);
            }
        }
        return a + b.substring(maxMatching);
    }

    public List<String> getAllPermutations(String str) {
        List<String> list = new ArrayList<>();
        getPermutations(str.toCharArray(), list, 0);
        return list;
    }

    private void getPermutations(char[] carray, List<String> list, int counter) {
        if (counter == carray.length) {
            list.add(String.valueOf(carray));
            return;
        }
        for (int i = counter; i < carray.length; i++) {
            swap(carray, i, counter);
            getPermutations(carray, list, counter + 1);
            swap(carray, i, counter);
        }
    }

    private void swap(char[] carray, int a, int b) {
        char temp = carray[a];
        carray[a] = carray[b];
        carray[b] = temp;
    }

    /**
     * assuming len is less than 26
     *
     * @param len
     * @return a string of length n, with all the characters different
     */
    public String getStringOfLength(int len) {
        if (len > 26) {
            throw new IllegalArgumentException("len should not be greater than 26");
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            result.append((char) ('a' + i));
        }
        return result.toString();
    }

}
