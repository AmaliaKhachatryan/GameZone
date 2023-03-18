package tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class GameZoneTest {
    Player anton = new Player(1, "Anton", 125);
    Player alex = new Player(2, "Alex", 125);
    Player vlad = new Player(3, "Vlad", 138);
    Player maksim = new Player(4, "Maksim", 99);
    Player dima = new Player(5, "Dima", 145);
    HashMap<String, Player> listPlayers = new HashMap<>();
    GameZone gameZone = new GameZone(listPlayers);

    @BeforeEach
    public void setUp() {
        listPlayers.put("Anton", anton);//  Anton  Dima
        listPlayers.put("Alex", alex); //  Alex
        listPlayers.put("Vlad", vlad); // Vlad
        listPlayers.put("Maksim", maksim); // Maksim
    }

    @Test
    public void CheckWithNullPlayersTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round(null, null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckTheSamePlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("Alex", "Alex");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithNullSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("Alex", null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithNullFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round(null, "Alex");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutPlayersTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("", "");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("Alex", "");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("", "Anton");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckNotRegisteredFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("Dima", "Vlad");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckNotRegisteredSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.round("Maksim", "Dima");
        });
        Assertions.assertNotNull(exception.getMessage().contains("Не зарегистрирован игрок"));
    }

    @Test
    public void roundSecondPlayerStrongerTest() {
        Assertions.assertEquals(2, gameZone.round("Alex", "Vlad"));
    }

    @Test
    public void roundFirstPlayerStrongerTest() {
        Assertions.assertEquals(1, gameZone.round("Alex", "Maksim"));
    }

    @Test
    public void registerStrengthAreEqualTest() {
        Assertions.assertEquals(0, gameZone.round("Alex", "Anton"));
    }

    @Test
    public void registerValidTest() {
        Assertions.assertEquals(true, gameZone.register(anton));
    }


    @Test
    public void registerNotValidTest() {
        Assertions.assertEquals(false, gameZone.register(dima));
    }

    @Test
    public void findByNameValidTest() {
        Assertions.assertEquals(alex, gameZone.findByName("Alex"));
    }

    @Test
    public void findByNameNotValidTest() {
        Assertions.assertEquals(null, gameZone.findByName("Dima"));
    }

    @Test
    public void findByNameExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.findByName("");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void findByNameNullExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameZone.findByName(null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }
}
