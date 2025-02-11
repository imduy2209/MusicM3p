package com.example.musicm3p;
import java.util.Random;
public class AnimalNameGenerator {
    private static final String[] animalNames = {"Tiger", "Lion", "Elephant", "Giraffe", "Monkey", "Panda", "Kangaroo", "Zebra","GOAT CR7","PEPSi","FISH","Cow"};

    public static String getRandomAnimalName() {
        Random random = new Random();
        int index = random.nextInt(animalNames.length);
        return animalNames[index];
    }
}
