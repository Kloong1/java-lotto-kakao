package util;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    public static <T> Set<T> getIntersectionFrom(Set<T> set1, Set<T> set2) {
        HashSet<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
}
