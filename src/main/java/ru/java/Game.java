package ru.java;


import ru.java.service.AnimalServiceImpl;
import ru.java.service.AnimalService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final AnimalService animalService = new AnimalServiceImpl("кит", "кот", "живет на суше");

    public void play() throws IOException {
        String animal = "Это животное ";
        boolean answer;
        System.out.print("Сыграем в игру? (да/нет): ");
        while (playerAnswer()) {
            System.out.println("Загадай животное, а я попробую угадать...");
            do {
                System.out.print(animal + animalService.getDifference() + "? ");
                answer = playerAnswer();
            } while (!animalService.isEnd(answer));
            String currentAnimal = animalService.getAnimalByRoute(answer);
            System.out.print(animal + currentAnimal + "? ");
            if (playerAnswer()) {
                animalService.drop();
            }
            else {
                System.out.print("Какое животное ты загадал? ");
                String newAnimal = reader.readLine();
                System.out.format("Чем %s отличается от %s: ", newAnimal, currentAnimal);
                String newDifference = reader.readLine();
                boolean exit;
                do {
                    exit = animalService.saveAnimal(newAnimal, newDifference, answer);
                    if (!exit) {
                        System.out.print("Такое отличие уже есть. Попробуй придумать другое: ");
                        newDifference = reader.readLine();
                    }
                } while (!exit);
            }
            System.out.print("Сыграем еще раз? ");
        }
        System.out.println("Пока");
    }

    private boolean playerAnswer() throws IOException {
        boolean isCorrect = false;
        String ans = reader.readLine();
        while (!isCorrect) {
            if (ans.equals("да") || ans.equals("нет"))
                isCorrect = true;
            else {
                System.out.print("Можно ответить только \"да\" или \"нет\". Попробуй еще раз: ");
                ans = reader.readLine();
            }
        }
        return ans.equals("да");
    }
}
