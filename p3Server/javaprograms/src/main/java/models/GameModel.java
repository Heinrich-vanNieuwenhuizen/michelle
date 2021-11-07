package models;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static int id = 1;
    int _id;
    String name;
    int allowedPlayers;
    int _owner;
    List<PlayerModel> players = new ArrayList<>();
}
