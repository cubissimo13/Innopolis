import observer.TokenObserverImpl;
import tokens.Token;
import tokens.TokenNumbers;
import tokens.TokenPuncts;
import tokens.TokenWords;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TokenaiserObservableImpl implements Observable {
    private Map<String, TokenObserverImpl> observers;
    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public TokenaiserObservableImpl() {
        observers = new HashMap<String, TokenObserverImpl>();
    }

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
                    notifyObserver(new TokenNumbers(begin, end, textToken));
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
                    notifyObserver(new TokenWords(begin, end, textToken));
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
                    notifyObserver(new TokenPuncts(begin, end, textToken));
                    begin = 0;
                    end = 0;
                    onPunct = false;
                    textToken = "";
                }
            }
        }
    }

    public void addObserver(TokenObserverImpl tokenObserver) {
        observers.put(tokenObserver.getName(), tokenObserver);
    }

    public void removeObserver(TokenObserverImpl tokenObserver) {
        String name = tokenObserver.getName();
        observers.remove(name);
        System.out.println("-----------Слушатель " + name + " был удален-------------");
    }

    public void notifyObserver(Token token) {

        Set<Map.Entry<String, TokenObserverImpl>> entries = observers.entrySet();

        for (Map.Entry<String, TokenObserverImpl> entity : entries) {
            TokenObserverImpl currentObserver = entity.getValue();
            currentObserver.handleToken(token);
        }
    }
}
