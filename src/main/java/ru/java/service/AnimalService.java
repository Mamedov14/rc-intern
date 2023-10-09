package ru.java.service;

import ru.java.utils.Resettable;
import ru.java.utils.AnimalUtils;

public interface AnimalService extends Resettable, AnimalUtils {
    boolean isEnd(boolean route);
}
