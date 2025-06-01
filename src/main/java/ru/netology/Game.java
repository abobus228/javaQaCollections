package ru.netology;

import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> listRegister = new ArrayList<>();

    public void register(Player player) {
        listRegister.add(player);  // Регистрация игрока
    }

    public int round(String playerName1, String playerName2) {

        Player playerOne = null;
        Player playerTwo = null;

        // Проверка зарегистрированы ли пользователи
        for (Player playerName : listRegister) {
            if (playerName.getName().equals(playerName1)) {
                playerOne = playerName;
            } else if (playerName.getName().equals(playerName2)) {
                playerTwo = playerName;
            } else {
                throw new NotRegisteredException(
                        "Пользователь не зарегистрирован!"
                );
            }
        }

        if (playerOne.getStrength() > playerTwo.getStrength()) {
            return 1;
        } else if (playerOne.getStrength() < playerTwo.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
