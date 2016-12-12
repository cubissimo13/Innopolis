public abstract class Token {
    private int begin;
    private int end;

    public Token(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public abstract String getValue();

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
