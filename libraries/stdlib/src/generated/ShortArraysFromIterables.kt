package kotlin


//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//
// Generated from input file: src/kotlin/Iterables.kt
//


import java.util.*

/**
 * Returns *true* if all elements match the given *predicate*
 *
 * @includeFunctionBody ../../test/CollectionTest.kt all
 */
public inline fun ShortArray.all(predicate: (Short) -> Boolean) : Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/**
 * Returns *true* if any elements match the given *predicate*
 *
 * @includeFunctionBody ../../test/CollectionTest.kt any
 */
public inline fun ShortArray.any(predicate: (Short) -> Boolean) : Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/**
 * Appends the string from all the elements separated using the *separator* and using the given *prefix* and *postfix* if supplied
 *
 * If a collection could be huge you can specify a non-negative value of *limit* which will only show a subset of the collection then it will
 * a special *truncated* separator (which defaults to "..."
 *
 * @includeFunctionBody ../../test/CollectionTest.kt appendString
 */
public inline fun ShortArray.appendString(buffer: Appendable, separator: String = ", ", prefix: String = "", postfix: String = "", limit: Int = -1, truncated: String = "..."): Unit {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit) {
            val text = if (element == null) "null" else element.toString()
            buffer.append(text)
        } else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
}

/**
 * Returns the number of elements which match the given *predicate*
 *
 * @includeFunctionBody ../../test/CollectionTest.kt count
 */
public inline fun ShortArray.count(predicate: (Short) -> Boolean) : Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/**
 * Returns the first element which matches the given *predicate* or *null* if none matched
 *
 * @includeFunctionBody ../../test/CollectionTest.kt find
 */
public inline fun ShortArray.find(predicate: (Short) -> Boolean) : Short? {
    for (element in this) if (predicate(element)) return element
    return null
}

/**
 * Filters all elements which match the given predicate into the given list
 *
 * @includeFunctionBody ../../test/CollectionTest.kt filterIntoLinkedList
 */
public inline fun <C: MutableCollection<Short>> ShortArray.filterTo(result: C, predicate: (Short) -> Boolean) : C {
    for (element in this) if (predicate(element)) result.add(element)
    return result
}

/**
 * Partitions this collection into a pair of collection
 *
 * @includeFunctionBody ../../test/CollectionTest.kt partition
 */
public inline fun ShortArray.partition(predicate: (Short) -> Boolean) : Pair<List<Short>, List<Short>> {
    val first = ArrayList<Short>()
    val second = ArrayList<Short>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

/**
 * Returns a list containing all elements which do not match the given *predicate*
 *
 * @includeFunctionBody ../../test/CollectionTest.kt filterNotIntoLinkedList
 */
public inline fun <C: MutableCollection<Short>> ShortArray.filterNotTo(result: C, predicate: (Short) -> Boolean) : C {
    for (element in this) if (!predicate(element)) result.add(element)
    return result
}

/**
 * Filters all non-*null* elements into the given list
 *
 * @includeFunctionBody ../../test/CollectionTest.kt filterNotNullIntoLinkedList
 */
public inline fun <C: MutableCollection<Short>> ShortArray?.filterNotNullTo(result: C) : C {
    if (this != null) {
        for (element in this) if (element != null) result.add(element)
    }
    return result
}

/**
 * Returns the result of transforming each element to one or more values which are concatenated together into a single list
 *
 * @includeFunctionBody ../../test/CollectionTest.kt flatMap
 */
public inline fun <R> ShortArray.flatMapTo(result: MutableCollection<R>, transform: (Short) -> Collection<R>) : Collection<R> {
    for (element in this) {
        val list = transform(element)
        for (r in list) result.add(r)
    }
    return result
}

/**
 * Performs the given *operation* on each element
 *
 * @includeFunctionBody ../../test/CollectionTest.kt forEach
 */
public inline fun ShortArray.forEach(operation: (Short) -> Unit) : Unit = for (element in this) operation(element)

/**
 * Folds all elements from from left to right with the *initial* value to perform the operation on sequential pairs of elements
 *
 * @includeFunctionBody ../../test/CollectionTest.kt fold
 */
public inline fun <R> ShortArray.fold(initial: R, operation: (R, Short) -> R): R {
    var answer = initial
    for (element in this) answer = operation(answer, element)
    return answer
}

/**
 * Folds all elements from right to left with the *initial* value to perform the operation on sequential pairs of elements
 *
 * @includeFunctionBody ../../test/CollectionTest.kt foldRight
 */
public inline fun <R> ShortArray.foldRight(initial: R, operation: (Short, R) -> R): R = reverse().fold(initial, {x, y -> operation(y, x)})


/**
 * Applies binary operation to all elements of iterable, going from left to right.
 * Similar to fold function, but uses the first element as initial value
 *
 * @includeFunctionBody ../../test/CollectionTest.kt reduce
 */
public inline fun ShortArray.reduce(operation: (Short, Short) -> Short): Short {
    val iterator = this.iterator()
    if (!iterator.hasNext()) {
        throw UnsupportedOperationException("Empty iterable can't be reduced")
    }

    var result: Short = iterator.next() //compiler doesn't understand that result will initialized anyway
    while (iterator.hasNext()) {
        result = operation(result, iterator.next())
    }

    return result
}

/**
 * Applies binary operation to all elements of iterable, going from right to left.
 * Similar to foldRight function, but uses the last element as initial value
 *
 * @includeFunctionBody ../../test/CollectionTest.kt reduceRight
 */
public inline fun ShortArray.reduceRight(operation: (Short, Short) -> Short): Short = reverse().reduce { x, y -> operation(y, x) }


/**
 * Groups the elements in the collection into a new [[Map]] using the supplied *toKey* function to calculate the key to group the elements by
 *
 * @includeFunctionBody ../../test/CollectionTest.kt groupBy
 */
public inline fun <K> ShortArray.groupBy(toKey: (Short) -> K) : Map<K, MutableList<Short>> = groupByTo<K>(HashMap<K, MutableList<Short>>(), toKey)

/**
 * Groups the elements in the collection into the given [[Map]] using the supplied *toKey* function to calculate the key to group the elements by
 *
 * @includeFunctionBody ../../test/CollectionTest.kt groupBy
 */
public inline fun <K> ShortArray.groupByTo(result: MutableMap<K, MutableList<Short>>, toKey: (Short) -> K) : Map<K, MutableList<Short>> {
    for (element in this) {
        val key = toKey(element)
        val list = result.getOrPut(key) { ArrayList<Short>() }
        list.add(element)
    }
    return result
}

/**
 * Creates a string from all the elements separated using the *separator* and using the given *prefix* and *postfix* if supplied.
 *
 * If a collection could be huge you can specify a non-negative value of *limit* which will only show a subset of the collection then it will
 * a special *truncated* separator (which defaults to "..."
 *
 * @includeFunctionBody ../../test/CollectionTest.kt makeString
 */
public inline fun ShortArray.makeString(separator: String = ", ", prefix: String = "", postfix: String = "", limit: Int = -1, truncated: String = "..."): String {
    val buffer = StringBuilder()
    appendString(buffer, separator, prefix, postfix, limit, truncated)
    return buffer.toString()
}

/** Returns a list containing the everything but the first elements that satisfy the given *predicate* */
public inline fun <L: MutableList<Short>> ShortArray.dropWhileTo(result: L, predicate: (Short) -> Boolean) : L {
    var start = true
    for (element in this) {
        if (start && predicate(element)) {
            // ignore
        } else {
            start = false
            result.add(element)
        }
    }
    return result
}

/** Returns a list containing the first elements that satisfy the given *predicate* */
public inline fun <C: MutableCollection<Short>> ShortArray.takeWhileTo(result: C, predicate: (Short) -> Boolean) : C {
    for (element in this) if (predicate(element)) result.add(element) else break
    return result
}

/** Copies all elements into the given collection */
public inline fun <C: MutableCollection<Short>> ShortArray.toCollection(result: C) : C {
    for (element in this) result.add(element)
    return result
}

/**
 * Reverses the order the elements into a list
 *
 * @includeFunctionBody ../../test/CollectionTest.kt reverse
 */
public inline fun ShortArray.reverse() : List<Short> {
    val list = toCollection(ArrayList<Short>())
    Collections.reverse(list)
    return list
}

/** Copies all elements into a [[LinkedList]]  */
public inline fun ShortArray.toLinkedList() : LinkedList<Short> = toCollection(LinkedList<Short>())

/** Copies all elements into a [[List]] */
public inline fun ShortArray.toList() : List<Short> = toCollection(ArrayList<Short>())

/** Copies all elements into a [[List] */
public inline fun ShortArray.toCollection() : Collection<Short> = toCollection(ArrayList<Short>())

/** Copies all elements into a [[Set]] */
public inline fun ShortArray.toSet() : Set<Short> = toCollection(HashSet<Short>())

/**
  TODO figure out necessary variance/generics ninja stuff... :)
public inline fun  ShortArray.toSortedList(transform: fun(Short) : java.lang.Comparable<*>) : List<Short> {
    val answer = this.toList()
    answer.sort(transform)
    return answer
}
*/
