import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String message1 = "любой текст номер 1\n" +
                "текста может быть много\n" +
                "текст с, запятыми\n" +
                "тест с двоеточием:\n";
        String message2 = "some text\n" +
                "there can be a lot of text\n" +
                "text with, commas\n" +
                "colon test:";

        SortedSet<String> words = new TreeSet<>();
        words.addAll(conversionToDictionary(message1));
        words.addAll(conversionToDictionary(message2));
        words.forEach(System.out::println);
    }

    public static List<String> conversionToDictionary(String message){
        return Arrays.stream(message.split("\\s"))
                .map((s) -> s.replaceAll("\\p{Punct}", ""))
                .distinct()
                .sorted()       //можно и без сортировки, т.к. отсортируется при добавлении в SortedSet
                .collect(Collectors.toList());
    }
}




















