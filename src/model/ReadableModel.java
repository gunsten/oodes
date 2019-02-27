package model;

import model.Car;

import java.util.List;

public interface ReadableModel<T extends Car> {
    public List<T> get();
}
