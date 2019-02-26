package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/18.
 */
public class InverseWordsTest {
    @Test
    public void inverseWords() throws Exception {

        InverseWords iw = new InverseWords();
        String sentence1 = "I am a man.";
        String sentence2 = " I am a man.";
        String sentence3 = "  I am a man.";
        String sentence4 = " I am  a man.";
        String sentence5 = "I am a man. ";
        iw.inverseWords(sentence1);
        iw.inverseWords(sentence2);
        iw.inverseWords(sentence3);
        iw.inverseWords(sentence4);
        iw.inverseWords(sentence5);


    }

}