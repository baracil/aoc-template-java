package fpc.aoc.common;

import lombok.NonNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Tools {

  public static long longProduct(long l1, long l2) {
    return l1 * l2;
  }

  public static @NonNull String reverse(@NonNull String string) {
    return new StringBuilder(string).reverse().toString();
  }

  public static <T> T TODO() {
    throw new AOCException("TO IMPLEMENT");
  }

  public static int sumUpTo(int value) {
    return value * (value + 1) / 2;
  }


  public static <E> @NonNull E getOneElement(@NonNull Collection<E> collection) {
    return collection.iterator().next();
  }

  @SuppressWarnings("unchecked")
  public static <E> E[] createArray(@NonNull Class<E> elementType, int size) {
    return (E[]) Array.newInstance(elementType, size);
  }

  public static <T> @NonNull List<T> replaceAt(@NonNull List<T> source, int index, @NonNull Function<? super T, ? extends T> transformer) {
    final List<T> result = new ArrayList<>(source.size());

    if (index > 0) {
      result.addAll(source.subList(0, index));
    }

    final var newValue = transformer.apply(source.get(index));
    result.add(newValue);

    if (index < source.size() - 1) {
      result.addAll(source.subList(index + 1, source.size()));
    }

    return result;
  }


  @NonNull
  public static <K, V> Collector<V, ?, Map<K, V>> toImmutableMap(@NonNull Function<? super V, ? extends K> keyGetter) {
    return Collectors.toMap(keyGetter, v -> v);
  }

  public static <K, V> @NonNull Collector<Pair<K, V>, ?, Map<K, V>> pairsToImmutableMap() {
    return Collectors.toMap(Pair::first, Pair::second);
  }

  @NonNull
  public static Optional<Integer> parseInteger(@NonNull String integer) {
    try {
      return Optional.of(Integer.parseInt(integer));
    } catch (NumberFormatException nfe) {
      return Optional.empty();
    }
  }

  @NonNull
  public static <K, V> Map<K, V> removeKey(@NonNull Map<K, V> target, @NonNull K key) {
    if (!target.containsKey(key)) {
      return target;
    }
    return target.entrySet().stream().filter(e -> !e.getKey().equals(key)).collect(Collectors.toMap(
      Map.Entry::getKey,
      Map.Entry::getValue));
  }

  @NonNull
  public static <K, V> Map<K, V> addValue(@NonNull Map<K, V> target, @NonNull K key, @NonNull V value) {
    if (value.equals(target.get(key))) {
      return target;
    }

    final Map<K, V> result = new HashMap<>(target);
    result.put(key, value);
    return result;
  }

  @NonNull
  public static <K> Set<K> addValue(@NonNull Set<K> target, @NonNull K value) {
    if (target.contains(value)) {
      return target;
    }
    final var result = new HashSet<K>(target);
    result.add(value);
    return result;
  }

  @NonNull
  public static <V> List<V> addValue(@NonNull List<V> target, @NonNull V value) {
    final var list = new ArrayList<V>(target.size() + 1);
    list.addAll(target);
    list.add(value);
    return list;
  }

  @SafeVarargs
  @NonNull
  public static <V> List<V> addValues(@NonNull List<V> target, @NonNull V... values) {
    final var result = new ArrayList<V>(target.size() + values.length);
    result.addAll(target);
    result.addAll(Arrays.asList(values));
    return result;
  }

  @NonNull
  public static <K, A, B> Map<K, B> mapValues(@NonNull Map<K, A> input, @NonNull Function<? super A, ? extends B> mapper) {
    return input.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> mapper.apply(e.getValue())));
  }

  @NonNull
  public static <A, B> List<B> map(@NonNull Collection<A> input, @NonNull Function<? super A, ? extends B> mapper) {
    return input.stream().<B>map(mapper).toList();
  }

  @NonNull
  public static <T> List<T> mergeLists(@NonNull List<T> firstPart, @NonNull List<T> secondPart) {
    final var result = new ArrayList<T>(firstPart.size() + secondPart.size());
    result.addAll(firstPart);
    result.addAll(secondPart);
    return result;
  }

  @NonNull
  public static <T> Map<T, Integer> mapSmallestIndexInList(@NonNull List<T> values) {
    final Map<T, Integer> map = new HashMap<>();
    for (int i = 0; i < values.size(); i++) {
      final T value = values.get(i);
      map.merge(value, i, Math::min);
    }
    return map;
  }

  @NonNull
  public static List<String> convertToAscii(@NonNull String str) {
    return str.chars().mapToObj(Long::toString).toList();
  }

  public static int mod(int value, int base) {
    final int m = value % base;
    return m < 0 ? m + base : m;
  }

  public static int sqrt(int value) {
    return (int) Math.round(Math.sqrt(value));
  }

  public static <E extends Enum<E>> @NonNull Collector<E, ?, EnumSet<E>> enumSetCollector(@NonNull Class<E> enumType) {
    return Collector.of(
      () -> EnumSet.noneOf(enumType),
      AbstractCollection::add,
      (e1, e2) -> {
        e1.addAll(e2);
        return e1;
      },
      Collector.Characteristics.IDENTITY_FINISH,
      Collector.Characteristics.UNORDERED
    );
  }
}
