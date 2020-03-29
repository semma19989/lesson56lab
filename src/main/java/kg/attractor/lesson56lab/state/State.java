package kg.attractor.lesson56lab.state;

public interface State {
    String getName();
    void heat(StateContext context);
}
