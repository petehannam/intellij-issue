package lgbt.switchboard;

import io.micronaut.runtime.Micronaut;

public class Application {

    static {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}