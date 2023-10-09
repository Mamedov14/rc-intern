package ru.java.repository;

import ru.java.tree.Node;

import java.util.HashSet;
import java.util.Set;

public class AnimalRepository implements Repository {

    private final Node rootNode;
    private Node currentNode;
    private final Set<String> passedDifferences;

    public AnimalRepository(String negativeAnimal, String positiveAnimal, String difference) {
        rootNode = new Node();
        rootNode.setValue(difference);
        rootNode.setNegative(new Node(negativeAnimal));
        rootNode.setPositive(new Node(positiveAnimal));
        currentNode = rootNode;
        passedDifferences = new HashSet<>();
    }

    @Override
    public String getDifference() {
        passedDifferences.add(currentNode.getValue());
        return currentNode.getValue();
    }

    @Override
    public String getAnimalByRoute(boolean route) {
        if (route) {
            return currentNode.getPositive().getValue();
        } else {
            return currentNode.getNegative().getValue();
        }
    }

    @Override
    public boolean saveAnimal(String animal, String difference, boolean route) {
        if (isNewDifference(difference)) {
            Node newNode = new Node();
            newNode.setValue(difference);
            newNode.setPositive(new Node(animal));
            if (route) {
                newNode.setNegative(currentNode.getPositive());
                currentNode.setPositive(newNode);
            } else {
                newNode.setNegative(currentNode.getNegative());
                currentNode.setNegative(newNode);
            }
            passedDifferences.clear();
            drop();
            return true;
        } else return false;
    }

    @Override
    public boolean hasNextDifference(boolean route) {
        if (route) {
            return currentNode.getPositive().getPositive() != null;
        } else {
            return currentNode.getNegative().getPositive() != null;
        }
    }

    @Override
    public void next(boolean route) {
        if (route) {
            currentNode = currentNode.getPositive();
        } else {
            currentNode = currentNode.getNegative();
        }
    }

    @Override
    public void drop() {
        currentNode = rootNode;
    }

    private boolean isNewDifference(String difference) {
        return !passedDifferences.contains(difference);
    }
}
