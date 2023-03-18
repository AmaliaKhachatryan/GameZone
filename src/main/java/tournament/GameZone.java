package tournament;

import java.util.HashMap;
import java.util.Map;

public class GameZone {
    HashMap <String, Player> listPlayers;

    public GameZone(HashMap<String, Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public boolean register(Player player) {
        return listPlayers.containsValue(player);
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
        for (Map.Entry gamer : listPlayers.entrySet()) {
            if (gamer.getKey().equals(name)) {
                return listPlayers.get(name);
            }
        } return null;
    }
}
