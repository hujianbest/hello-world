package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reversal {
    public static void main(String[] args) {
        String str = "How do you do";
        String reversed = Arrays.stream(str.split(" ")).map(word->{
            return new StringBuilder(word).reverse().toString();
        }).collect(Collectors.joining(" "));
        System.out.println(reversed);
    }
}
