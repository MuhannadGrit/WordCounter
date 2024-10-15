public class WordCounter {
    private int numberOfUniqueWords = 0;

    public void add(String sentence) {
        if(sentence != null && !sentence.trim().isEmpty()) {
            sentence = sentence.replaceAll("[.,?!_;:]","" );
            numberOfUniqueWords = sentence.trim().split("[.,?!_;:]+| +").length;
        }
    }

    public int getWordsAmount() {
        return numberOfUniqueWords;
    }
}
