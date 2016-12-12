import observer.ObserverFirst;
import observer.ObserverSecond;
import observer.TokenObserverImpl;

public class Main {
    public static void main(String[] args) {
        TokenaiserObservableImpl tokenaiser = new TokenaiserObservableImpl();
        TokenObserverImpl tokenObserver1 = new ObserverFirst("First Listner");
        tokenaiser.addObserver(tokenObserver1);
        TokenObserverImpl tokenObserver2 = new ObserverSecond("Second Listner");
        tokenaiser.addObserver(tokenObserver2);
        tokenaiser.makeToken("1111 rfddf 2222 edfdfdf 3333 ???? !!!! \"#$% ");
        tokenaiser.removeObserver(tokenObserver2);
        tokenaiser.makeToken("1111 rfddf 2222 edfdfdf 3333 ???? !!!! ");
    }
}
