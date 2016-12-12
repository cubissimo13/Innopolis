package observer;

import tokens.Token;

public class ObserverSecond extends TokenObserverImpl {

    public ObserverSecond(String name) {
        super(name);
    }

    @Override
    public void handleToken(Token token) {
        System.out.println(this.getName() + " получил токен - "+ token.getValue());
    }
}
