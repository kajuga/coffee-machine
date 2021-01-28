package machine.cofee_ingredients;

import java.util.Objects;

public class Milk extends Ingredient {
    public final static String KEY = "milk";
    private final String name = KEY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milk milk = (Milk) o;
        return Objects.equals(name, milk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
