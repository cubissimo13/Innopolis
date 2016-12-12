package observer;

import tokens.Token;
import tokens.TokenNumbers;
import tokens.TokenPuncts;
import tokens.TokenWords;

public class ObserverFirst extends TokenObserverImpl {

    public ObserverFirst(String name) {
        super(name);
    }

    @Override
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(TokenNumbers.class.getName())) {
            System.out.println(this.getName() + " получил цфировой токен - " + token.getValue());
        }
        if (token.getClass().getName().equals(TokenWords.class.getName())) {
            System.out.println(this.getName() + " получил буквенный токен - " + token.getValue());
        }
        if (token.getClass().getName().equals(TokenPuncts.class.getName())) {
            System.out.println(this.getName() + " получил пунктуационный токен - " + token.getValue());
        }

    }
}
