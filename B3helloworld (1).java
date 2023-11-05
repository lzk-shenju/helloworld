package CTGU.3;
import java.util.ArrayList;
import java.util.List;


enum StringExtractorState {
    INITIAL,              // 初始状态
    READING_TEXT,         // 读取文本状态
    ESCAPE_SEQUENCE,      // 反斜杠状态
    READING_QUOTE,        // 读取结束状态
}

public class StringExtractor {
    private StringExtractorState currentState;
    private StringBuilder currentString;
    private List<String> extractedStrings;

    public StringExtractor() {
        currentState = StringExtractorState.INITIAL;
        currentString = new StringBuilder();
        extractedStrings = new ArrayList<>();
    }

    public List<String> extractStrings(String sourceCode) {
        for (char character : sourceCode.toCharArray()) {
            processCharacter(character);
        }
        return extractedStrings;
    }

    private void processCharacter(char character) {
        switch (currentState) {
            case INITIAL:
                if (character == '"') {
                    currentState = StringExtractorState.READING_TEXT;
                } else {
                    currentState = StringExtractorState.INITIAL;
                }
                break;
            case READING_TEXT:
                if (character == '"') {
                    currentState = StringExtractorState.READING_QUOTE;
                } else if (character == '\\') {
                    currentState = StringExtractorState.ESCAPE_SEQUENCE;
                } else {
                    currentState = StringExtractorState.READING_TEXT;
                }
                break;
            case ESCAPE_SEQUENCE:
                currentState = StringExtractorState.READING_TEXT;
                break;
            case READING_QUOTE:
                if (character == '"') {
                    extractedStrings.add(currentString.toString());
                    currentString.setLength(0);
                    currentState = StringExtractorState.INITIAL;
                } else {
                    currentState = StringExtractorState.READING_TEXT;
                }
                break;
        }

        // 输出状态
        System.out.println("Current State: " + currentState);
    }
}
