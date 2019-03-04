package model;

import model.Car;
import view.ModelObserver;

import java.util.List;

public interface ObservableModel<T extends Locateable> {
    List<? extends Locateable> get();
    void addObserver(ModelObserver obs);
}
