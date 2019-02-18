package superpermutation;

import java.util.ArrayList;
import java.util.List;

public class GenericPermutor<T> {
    public List<List<T>> getAllPermutations(List<T> list) {
        List<List<T>> result = new ArrayList<>();
        getPerm(list, result, 0);
        return result;
    }

    private void getPerm(List<T> list, List<List<T>> result, int counter) {
        if (counter == list.size()) {
            List<T> tempList = new ArrayList<>(list);
            result.add(tempList);
            return;
        }
        for (int i = counter; i < list.size(); i++) {
            swap(list, i, counter);
            getPerm(list, result, counter + 1);
            swap(list, i, counter);
        }
    }

    private void swap(List<T> list, int a, int b) {
        if (a >= list.size() || b >= list.size())
            throw new IllegalArgumentException("the indices should be less than size of list");
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
