import java.util.ArrayList;

public class Tokenaiser implements NativeTokenaiserImpl {
    private ArrayList<Token> tokens = new ArrayList<>();
    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public void makeToken(String newString) {
        char[] chars = newString.toCharArray();
        String textToken = "";
        boolean onDigit = false;
        boolean onChar = false;
        boolean onPunct = false;
        int begin = 0;
        int end = 0;

        for (int i=0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (!onDigit) {
                    onDigit = true;
                    begin = i;
                    textToken += chars[i];
                } else {
                    textToken += chars[i];
                    end = i;
                }
            } else {
                if (onDigit){
                    tokens.add( new TokenNumbers (begin, end, Integer.valueOf(textToken)) );
                    begin = 0;
                    end = 0;
                    onDigit = false;
                    textToken = "";
                }
            }

            if (Character.isLetter(chars[i])) {
                if (!onChar) {
                    onChar = true;
                    begin = i;
                    textToken += chars[i];
                } else {
                    textToken += chars[i];
                    end = i;
                }
            } else {
                if (onChar){
                    tokens.add(new TokenWords (begin, end, textToken));
                    begin = 0;
                    end = 0;
                    onChar = false;
                    textToken = "";
                }
            }

            if (PUNCT.contains(String.valueOf(chars[i]))) {
                if (!onPunct) {
                    onPunct = true;
                    begin = i;
                    textToken += chars[i];
                } else {
                    textToken += chars[i];
                    end = i;
                }
            } else {
                if (onPunct){
                    tokens.add(new TokenPunct (begin, end, textToken));
                    begin = 0;
                    end = 0;
                    onPunct = false;
                    textToken = "";
                }

            }
        }
    }

    public void printToken(){
        for (int i=0; i<tokens.size(); i++){
            System.out.println("token " + tokens.get(i).getValue() + " начало-" + tokens.get(i).getBegin()+" конец-" +tokens.get(i).getEnd());
        }
    }

}
