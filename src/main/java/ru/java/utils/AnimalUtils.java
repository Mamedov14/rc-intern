package ru.java.utils;

public interface AnimalUtils {
    String getDifference();

    String getAnimalByRoute(boolean route);

    boolean saveAnimal(String animal, String difference, boolean route);
}
