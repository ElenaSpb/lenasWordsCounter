package services;

import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsCounterServiceTest {

    @Test
    public void testCountWord() {
        long res = WordsCounterService.countWord1("awe - pop, b, c, pop fgd. ! ? awe.","pop");
        assertEquals(2, res);
    }

    @Test
    public void testCountWords() {
        Map<String, Long> res = WordsCounterService.countWords("aa,a,bb,bb,c,aa,d,bb,b","aa,bb");
        assertEquals(2, res.size());
        assertEquals(2, res.get("aa").intValue());
        assertEquals(3, res.get("bb").intValue());
    }

    @Test
    public void testCountChar() {
        long res = WordsCounterService.countChar("a,,b,,c,d",",");
        assertEquals(5, res);
    }

    @Test
    public void testCountChars() {
        Map<String, Long> res = WordsCounterService.countChars("ad,a,b,d,c,d","a,d");
        assertEquals(2, res.size());
        assertEquals(2, res.get("a").intValue());
        assertEquals(3, res.get("d").intValue());
    }

    @Test
    public void testContWord(){
        int count = WordsCounterService.countWordWithTokenizer("qw qw , rt , kk. qw - Qw" , "qw");
        assertEquals( 3, count);
    }
}