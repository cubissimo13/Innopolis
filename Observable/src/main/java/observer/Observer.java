package observer;

import tokens.Token;

public interface Observer {
    void handleToken (Token token);
}
