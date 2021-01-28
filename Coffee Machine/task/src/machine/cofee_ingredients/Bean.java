package machine.cofee_ingredients;

import java.util.Objects;

public class Bean extends Ingredient{
    public final static String KEY = "bean";
    private final String name = KEY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return Objects.equals(name, bean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
