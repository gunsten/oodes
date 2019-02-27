package model;

import model.Car;

import java.util.List;

public interface ReadableModel<T extends Locateable> {
    public List<? extends Locateable> get();
}
