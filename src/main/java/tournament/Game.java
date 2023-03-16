package tournament;

import java.util.List;

public class Game {
    private List<Player> listPlayers;

    public Game(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public boolean register(Player player) {
        return listPlayers.contains(player);
    }

    public int round(String playerName1, String playerName2) {
        if (!register(findByName(playerName1))) {
            throw new NotRegisteredException(playerName1);
        }
        if (!register(findByName(playerName2))) {
            throw new NotRegisteredException(playerName2);
        }
        if (findByName(playerName1).equals(findByName(playerName2))) {
            throw new IncorrectDataException("Введите имя второго игрока");
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        if (name == null) {
            throw new IncorrectDataException("Введите имя игрока");
        }
        if (name.equals("")) {
            throw new IncorrectDataException("Введите имя игрока");
        }
        for (Player gamer : listPlayers) {
            if (gamer.getName().contains(name))
                return gamer;
        }
        return null;
    }
}