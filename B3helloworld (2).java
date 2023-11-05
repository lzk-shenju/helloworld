package CTGU.3;

import java.util.List;

public class StringExtractorTest {
    public static void main(String[] args) {
        String sourceCode = "一般学习一门编程语言的时候，基本上第一个程序是输出\"Hello World!\"和\"Programming\"";
        StringExtractor extractor = new StringExtractor();
        List<String> extractedStrings = extractor.extractStrings(sourceCode);

        for (String extractedString : extractedStrings) {
            System.out.println(extractedString);
        }
    }
}
