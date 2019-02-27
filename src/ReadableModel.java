import java.util.List;

public interface ReadableModel<T extends Locateable> {
    public List<T> get();
}
