package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotRegisteredException;

public class GameTest {

    Player player1 = new Player(1, "Vova", 19);
    Player player2 = new Player(2, "Sasha", 75);
    Player player3 = new Player(3, "Kirill", 19);
    Player player4 = new Player(4, "Maksim", 12);
    Player player5 = new Player(5, "Vika", 6);

    Game game = new Game();

    @BeforeEach
    public void start() {
        game.register("Vova", player1);
        game.register("Sasha", player2);
        game.register("Kirill", player3);
        game.register("Maksim", player4);
    }

    @Test  // Победа первого игрока
    public void shouldTheFirstPlayerWin() {

        int expected = game.round("Sasha", "Kirill");
        int actual = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test  // Победа второго игрока
    public void shouldTheSecondPlayerWin() {

        int expected = game.round("Maksim", "Vova");
        int actual = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test  // Ничья
    public void shouldBeADraw() {

        int expected = game.round("Vova", "Kirill");
        int actual = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test  // Пользователь не зарегистрирован
    public void shouldExceptionThrown() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vova", "Vika");
        });

    }

    @Test  // Список зарегистрированных игроков пустой
    public void shouldExceptionThrownIfListIsEmpty() {

        Game game1 = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game1.round("Vova", "Vika");
        });
    }
}
