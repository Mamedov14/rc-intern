package ru.java.service;

import ru.java.repository.AnimalRepository;
import ru.java.repository.Repository;

public class AnimalServiceImpl implements AnimalService {

    private final Repository tree;

    public AnimalServiceImpl(String negativeAnimal, String positiveAnimal, String difference) {
        this.tree = new AnimalRepository(negativeAnimal, positiveAnimal, difference);
    }

    @Override
    public boolean isEnd(boolean route) {
        if (tree.hasNextDifference(route)) {
            tree.next(route);
            return false;
        }
        return true;
    }

    @Override
    public String getDifference() {
        return tree.getDifference();
    }

    @Override
    public String getAnimalByRoute(boolean route) {
        return tree.getAnimalByRoute(route);
    }

    @Override
    public boolean saveAnimal(String newAnimal, String difference, boolean route) {
        return tree.saveAnimal(newAnimal, difference, route);
    }

    @Override
    public void drop() {
        tree.drop();
    }
}
