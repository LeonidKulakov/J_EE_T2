package ru.kulakov.server.service;

import java.util.Objects;
import java.util.Random;

public final class PlayService {

    private PlayService() {
    }

    public static String getMove() {
        String[] arr = {"Камень", "Ножницы", "Бумага"};
        return arr[new Random().nextInt(3)];
    }

    /**
     * Это не плохое название метода, а хорошая отсылка
     * */
    public static String timeToPlayTheGame(String moveOne, String moveTwo) {
        if (moveOne.equals(moveTwo)) return "Ничья";
        else {
            switch (moveOne) {
                case "Камень" -> {
                    return moveTwo.equals("Ножницы") ? "Победа" : "Поражение";
                }
                case "Ножницы" -> {
                    return moveTwo.equals("Бумага") ? "Победа" : "Поражение";
                }
                case "Бумага" -> {
                    return moveTwo.equals("Камень") ? "Победа" : "Поражение";
                }
            }
        }
        return "Что то пошло не так";
    }
}
