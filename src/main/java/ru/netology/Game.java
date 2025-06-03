package ru.netology;

import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;


public class Game {

    private HashMap<String, Player> listRegister = new HashMap<>();

    public void register(String name, Player player) {
        listRegister.put(name, player);  // Регистрация игрока
    }

    public int round(String playerName1, String playerName2) {

        Player playerOne = null;
        Player playerTwo = null;
        int strengthOne = 0;
        int strengthTwo = 0;

        if (listRegister.containsKey(playerName1) && listRegister.containsKey(playerName2)) {
            playerOne = listRegister.get(playerName1);
            playerTwo = listRegister.get(playerName2);
            strengthOne = playerOne.getStrength();
            strengthTwo = playerTwo.getStrength();
        } else {
            throw new NotRegisteredException(
                    "Пользователь не зарегистрирован!"
            );
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
