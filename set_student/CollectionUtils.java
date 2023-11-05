package lab7.set_student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CollectionUtils {
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p::test);
	}

	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p.negate()::test);
	}

	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		for (T obj : coll) {
			if (p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T obj : coll) {
			if (p.test(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

}