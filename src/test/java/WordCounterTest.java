import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {
    WordCounter counter = null;

    @BeforeEach
    public void setUp() {
        counter = new WordCounter();
    }

    @Test
    public void nullString(){
        counter.add(null);
        assertEquals(0, counter.getWordsAmount());
    }

    @Test
    public void emptyStringReturnsZeroWords(){
        counter.add("");
        assertEquals(0, counter.getWordsAmount());
    }

    @Test
    public void oneWordReturnsOneWord(){
        counter.add("one");
        assertEquals(1, counter.getWordsAmount());
    }

    @Test
    public void twoWordsReturnsTwoWords(){
        counter.add("Hello World");
        assertEquals(2, counter.getWordsAmount());
    }

    @Test
    public void manySpaces(){
        counter.add("     Hello         World       ");
        assertEquals(2, counter.getWordsAmount());
    }

    @Test
    public void emptyWithManySpacesReturnsZeroWords(){
        counter.add("     ");
        assertEquals(0, counter.getWordsAmount());
    }

    @Test
    public void manyWords(){
        counter.add("Hello World new new");
        assertEquals(4, counter.getWordsAmount());
    }

    @Test
    public void manyWordsWithManySpaces(){
        counter.add("Hello World    new    new");
        assertEquals(4, counter.getWordsAmount());
    }

    @Test
    public void stringWithSymbols(){
        counter.add("Hello ..? World, helo ..");
        assertEquals(3, counter.getWordsAmount());
    }

    @Test
    public void stringWithSingleSymbol(){
        counter.add("Hello ? World, helo .");
        assertEquals(3, counter.getWordsAmount());
    }

    @Test
    public void stringWithSymbolInsideTheWord(){
        counter.add("Hello ? Wor?ld, helo .");
        assertEquals(3, counter.getWordsAmount());
    }
}