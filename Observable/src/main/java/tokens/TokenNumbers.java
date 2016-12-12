package tokens;

import tokens.Token;

public class TokenNumbers extends Token {
    private String value;

    public TokenNumbers(int begin, int end, String value) {
        super(begin, end);
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.value);
    }
}