package ch.heig.dai.lab.fileio.ansermgw;

public class Transformer {
    private static final char LINE_SEPARATOR = '\n';
    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Split a string at each with space to generate an array of word
     * @param source the string to be split
     * @return an array of word extracted from the source
     */
    private String[] splitBySpace(String source) {
        return source.split("\\s");
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replace("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        StringBuilder builder = new StringBuilder();

        for(String word : splitBySpace(source)) {
            if(!builder.isEmpty()) {
                builder.append(' ');
            }

            // uppercase first letter
            builder.append(word.substring(0, 1).toUpperCase());

            if(word.length() > 1) {
                // add the rest of the word
                builder.append(word.substring(1));
            }
        }


        return builder.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        StringBuilder builder = new StringBuilder();
        int wordCount = 0;

        for(String word : splitBySpace(source)) {
            // line count start at 1, this is why we do +1
            int lineNumber = wordCount / numWordsPerLine + 1;
            boolean isNewLine = wordCount % numWordsPerLine == 0;

            if(isNewLine) {
                // add line return except when it's the first line
                if(lineNumber != 1) {
                    builder.append(LINE_SEPARATOR);
                }

                // add line number at start of line
                builder.append(lineNumber).append(". ");
            } else {
                // add space between word
                builder.append(' ');
            }

            builder.append(word);
            ++wordCount;
        }

        if(!builder.isEmpty()) {
            builder.append(LINE_SEPARATOR);
        }

        return builder.toString();
    }
}   