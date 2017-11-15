package Xuli;

/**
 * Created by DELL on 11/7/2017.
 */
public class Variable {
    String name;
    String type;

    public Variable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
