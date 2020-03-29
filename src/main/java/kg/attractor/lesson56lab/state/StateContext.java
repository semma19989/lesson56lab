package kg.attractor.lesson56lab.state;

public class StateContext {
    private String name = "New";
    private State state = new SolidState();

    public void heat() {
        state.heat(this);
    }

    public void setState(State state) {
        setName(state.getName());
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}