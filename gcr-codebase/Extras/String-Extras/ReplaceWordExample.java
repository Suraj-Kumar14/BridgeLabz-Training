public class ReplaceWordExample 
{
    // Method to replace a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) 
	{
        String sentence = "Java is easy to learn";
        String oldWord = "easy";
        String newWord = "powerful";

        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Original Sentence: " + sentence);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }
}
