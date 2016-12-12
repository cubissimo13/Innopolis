public class TokenNumbers extends Token{
    private int value;

    public TokenNumbers(int begin, int end, int value) {
        super(begin, end);
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.value);
    }
}
