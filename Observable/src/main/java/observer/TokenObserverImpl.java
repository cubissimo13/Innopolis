package observer;

import observer.Observer;
import tokens.Token;

public class TokenObserverImpl implements Observer {
    private String name;

    public TokenObserverImpl(String name) {
        this.name = name;
    }

    public void handleToken(Token token) {
    }

    public String getName() {
        return this.name;
    }
}
