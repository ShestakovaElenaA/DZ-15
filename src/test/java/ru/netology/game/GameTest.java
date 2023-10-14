package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Колобок", 5);
    Player player2 = new Player(2, "Бабушка", 2);
    Player player3 = new Player(3, "Дедушка", 2);
    Player player4 = new Player(3, "Зайчик", 3);
    Player player5 = new Player(5, "Лиса", 6);

    @Test
    public void ShudReturnNotFoundExceptionTwoPlaers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Волк", "Медведь");
        });
    }

    @Test
    public void ShudReturnNotFoundExceptionOneOfTwoPlaers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Колобок", "Медведь");
        });
    }

    @Test
    public void ShudReturnWonPlayer1() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expexted = 1;
        int actual = game.round("Колобок", "Бабушка");
        Assertions.assertEquals(expexted, actual);
    }

    @Test
    public void ShudReturnWonPlayer2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expexted = 2;
        int actual = game.round("Колобок", "Лиса");
        Assertions.assertEquals(expexted, actual);
    }

    @Test
    public void ShudReturnDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expexted = 0;
        int actual = game.round("Дедушка", "Бабушка");
        Assertions.assertEquals(expexted, actual);
    }
}
