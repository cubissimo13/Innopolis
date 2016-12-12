import observer.TokenObserverImpl;
import tokens.Token;

public interface Observable {
    void addObserver(TokenObserverImpl tokenObserver);
    void removeObserver(TokenObserverImpl tokenObserver);
    void notifyObserver(Token token);
}
