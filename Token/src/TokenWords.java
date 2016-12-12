public class TokenWords extends Token{
    private String word;

    public TokenWords(int begin, int end, String word) {
        super(begin, end);
        this.word = word;
    }

    @Override
    public String getValue() {
        return this.word;
    }
}
