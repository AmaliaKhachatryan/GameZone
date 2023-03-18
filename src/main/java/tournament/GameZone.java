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
        Player pleyer1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (!register(pleyer1)) {
            throw new NotRegisteredException(playerName1);
        }
        if (!register(player2)) {
            throw new NotRegisteredException(playerName2);
        }
        if (pleyer1.equals(player2)) {
            throw new IncorrectDataException("Введите имя второго игрока");
        }
        if (pleyer1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (pleyer1.getStrength() < player2.getStrength()) {
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
