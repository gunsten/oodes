import java.util.List;

public interface ReadableModel<T extends Car> {
    public List<T> get();
}
