import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<10;i++){
            list.add(i);
        }
        long total = list.stream().count();
        System.out.println(total);

        long count = list.stream().filter(element -> element>5).count();
        System.out.println(count);

        list.stream().filter(element ->{
            System.out.print(element);
            return element>5;
        });
        System.out.println(count);

        long newcount = list.stream().filter(element ->{
            System.out.print(element);
            return element>5;
        }).count();
        System.out.println();
        System.out.println(newcount);

        list.forEach(element -> System.out.print(element));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

        //collect
        List<String> stringList = Stream.of("aaa", "bbb", "abc").collect(Collectors.toList());



        //for
        List<String> collected = new ArrayList<>();
        for(String string : stringList){
            String upperCaseString = string.toUpperCase();
            collected.add(upperCaseString);
        }
        //map
        List<String> newCollected = stringList.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected.equals(newCollected));

        //for
        List<String> beginWithA = new ArrayList<>();
        for(String string : stringList){
            if(string.startsWith("a")){
                beginWithA.add(string);
            }
        }
        //filter
        List<String> newBeginWithA = stringList.stream().filter(string -> string.startsWith("a")).collect(Collectors.toList());
        System.out.println(beginWithA.equals(newBeginWithA));
    }
}
