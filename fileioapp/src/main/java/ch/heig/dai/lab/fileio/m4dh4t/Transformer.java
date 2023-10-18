package ch.heig.dai.lab.fileio.m4dh4t;

public class Transformer {

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
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replaceAll("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        String[] words = source.split("\\s");
        StringBuilder capitalizedSource = new StringBuilder();

        for (String w: words) {
            String firstLetter = w.substring(0,1);
            capitalizedSource.append(firstLetter.toUpperCase());

            if (w.length() == 1) {
                capitalizedSource.append(" ");
                continue;
            }

            String lastLetters = w.substring(1);
            capitalizedSource.append(lastLetters).append(" ");
        }

        return capitalizedSource.toString().trim();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        String[] words = source.split("\\s");
        StringBuilder wrappedSource = new StringBuilder();

        int wordCounter = 0;
        int lineCounter = 1;

        for (String w: words) {
            if (wordCounter == 0) {
                wrappedSource.append(lineCounter).append(".");
            }

            ++wordCounter;
            wrappedSource.append(" ").append(w);

            if (wordCounter == numWordsPerLine) {
                wrappedSource.append("\n");
                wordCounter = 0;
                ++lineCounter;
            }
        }

        wrappedSource.append("\n");
        return wrappedSource.toString();
    }
}   