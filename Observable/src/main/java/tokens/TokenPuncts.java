package tokens;

import tokens.Token;

public class TokenPuncts extends Token {
    private String punct;

    public TokenPuncts(int begin, int end, String punct) {
        super(begin, end);
        this.punct = punct;
    }

    @Override
    public String getValue() {
        return this.punct;
    }
}

