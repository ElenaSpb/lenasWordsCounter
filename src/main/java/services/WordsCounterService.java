package services;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class WordsCounterService {

    public static long countWord1(String text, String word){
        long wordsCount = Arrays.stream(text.split("[ ?!-,\\.]"))
                .filter(w -> w.length() > 0 && w.equals(word))
                .count();
        return wordsCount;
    }

    public static Map<String, Long> countWords(String text, String words){
        Objects.requireNonNull(text);
        List<String> listWords = Arrays.asList(words.split(","));
        Map<String, Long> mapWordCount = new HashMap<>();
        for(String word: listWords)
            mapWordCount.put(word, countWord1(text, word));
        return mapWordCount;
    }

    public static Map<String, Long> countChars(String text, String chars){
        Objects.requireNonNull(text);
        List<String> listChars = Arrays.asList(chars.split(","));
        Map<String, Long> mapCharCount = new HashMap<>();
        for(String oneChar: listChars)
            mapCharCount.put(oneChar, countChar(text, oneChar));
        return mapCharCount;
    }

    public static long countChar(String text, String oneChar){
        long count = StringUtils.countMatches(text, oneChar);
        return count;
    }

    @Deprecated
    public static int countWordWithTokenizer(String text, String word){
        Objects.requireNonNull(text);
        StringTokenizer tokenizer = new StringTokenizer(text);
        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equals(word))
                count++;
        }
        return count;
    }
}
