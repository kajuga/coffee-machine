package machine.cofee_ingredients;

import java.util.Objects;

public class Water extends Ingredient {
    public final static String KEY = "water";
    private final String name = KEY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Water water = (Water) o;
        return Objects.equals(name, water.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
