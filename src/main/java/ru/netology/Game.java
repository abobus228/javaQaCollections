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

        if (listRegister.isEmpty()) {
            throw new NotRegisteredException(
                    "Пользователь не зарегистрирован!"
            );
        }

        Player playerOne = null;
        Player playerTwo = null;
        int strengthOne = 0;
        int strengthTwo = 0;

        // Проверка зарегистрированы ли пользователи
        for (Player playerName : listRegister) {
            if (playerName.getName().equals(playerName1)) {
                playerOne = playerName;
                strengthOne = playerOne.getStrength();
            } else if (playerName.getName().equals(playerName2)) {
                playerTwo = playerName;
                strengthTwo = playerTwo.getStrength();
            }

            if (playerOne != null && playerTwo != null) break;
            else if (listRegister.indexOf(playerName) == (listRegister.size() - 1)) {
                throw new NotRegisteredException(
                        "Пользователь не зарегистрирован!"
                );
            }
        }

        if (strengthOne > strengthTwo) {
            return 1;
        } else if (strengthOne < strengthTwo) {
            return 2;
        } else {
            return 0;
        }
    }

}
