import java.util.List;
import java.util.ArrayList;

interface Observer {
    void update(String message);
}
interface Publisher{
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String msg);
}
	
class User implements Observer {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Channel implements Publisher{
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Channel channel = new Channel();

        Observer u1 = new User("Gayathri");
        Observer u2 = new User("Rahul");

        channel.subscribe(u1);
        channel.subscribe(u2);

        channel.notifyObservers("New video uploaded!");
    }
}
