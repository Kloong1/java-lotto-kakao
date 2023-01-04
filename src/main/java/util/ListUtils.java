package util;

import java.util.List;

public class ListUtils {

    public static <T> boolean hasDuplicates(List<T> list) {
        long distinctCount = list.stream()
                .distinct()
                .count();
        return distinctCount < list.size();
    }
}
