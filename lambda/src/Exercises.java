import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises {

    //编写一个求和函数
    public static int add(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, element) -> acc + element);
    }

    //编写一个函数，获取列表中对象的部分信息
    public static <T> List<T> getXXX(List<T> xList){
        return xList.stream()
                .flatMap(x->Stream.of(x.getA(), x.getB()))
                .collect(Collectors.toList());
    }

    //编写一个函数，返回列表中满足某条件的对象列表
    public static <T> List<T> getSubList(List<T> xList){
        return xList.stream()
                .filter(x -> x.condition > 0)
                .collect(Collectors.toList());
    }

    //将外部迭代转化为内部迭代
    public static int count(List<Integer> integers){
        int total = 0;
        for(int i : integers){
            total +=i;
        }
        return total;
    }

    public static int count2(List<Artist> artists){
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();
    }

    //计算一个字符串中小写字母个个数
    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(character -> Character.isLowerCase(character))
                .count();
    }

    public static int countLowercaseLetters2(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    //在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回Optional对象
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(character -> Exercises.countLowercaseLetters(character)));
    }

    public static Optional<String> mostLowercaseString2(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(Exercises::countLowercaseLetters));
    }

    //只用reduce和Lambda表达式实现Stream.map
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    //只用reduce和Lambda表达式实现Stream.filter
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        // We are copying data from acc to new list instance. It is very inefficient,
                        // but contract of Stream.reduce method requires that accumulator function does
                        // not mutate its arguments.
                        // Stream.collect method could be used to implement more efficient mutable reduction,
                        // but this exercise asks to use reduce method explicitly.
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                },
                Exercises::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }
}
