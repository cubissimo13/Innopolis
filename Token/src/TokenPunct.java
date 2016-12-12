
public class TokenPunct extends Token {
    private String punct;

    public TokenPunct(int begin, int end, String punct) {
        super(begin, end);
        this.punct = punct;
    }

    @Override
    public String getValue() {
        return this.punct;
    }
}
