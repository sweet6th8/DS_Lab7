package lab7.set_student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p::test);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p.negate()::test);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		System.out.println("a");
		for (T obj : coll) {
			if (p.test(obj)) {
				System.out.println("a");
				result.add(obj);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
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

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
		Predicate<Integer> evenPredicate = new Even();
//
//		CollectionUtils.remove(numbers, evenPredicate);
//		System.out.println(numbers);
//		CollectionUtils.retain(numbers, evenPredicate);
//		System.out.println(numbers);
		System.out.println(CollectionUtils.collect(numbers, evenPredicate));
		System.out.println(CollectionUtils.find(numbers, evenPredicate));
	}
}
