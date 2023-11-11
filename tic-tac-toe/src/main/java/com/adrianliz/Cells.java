package com.adrianliz;

import java.util.HashSet;
import java.util.Set;

public class Cells {
  private final Set<Position> positionsWithX = new HashSet<>();
  private final Set<Position> positionsWithO = new HashSet<>();

  public void put(Player player, Position position) {
    if (positionsWithX.contains(position) || positionsWithO.contains(position)) {
      return;
    }

    if (player.equals(Player.X)) {
      positionsWithX.add(position);
      return;
    }
    positionsWithO.add(position);
  }

  private boolean thereIsLine(Set<Position> positions) {
    return positions.size() == 3
        && (positions.stream().allMatch(p -> p.x() == 0)
            || positions.stream().allMatch(p -> p.x() == 1)
            || positions.stream().allMatch(p -> p.x() == 2)
            || positions.stream().allMatch(p -> p.y() == 0)
            || positions.stream().allMatch(p -> p.y() == 1)
            || positions.stream().allMatch(p -> p.y() == 2)
            || positions.stream().allMatch(p -> p.x() == p.y())
            || positions.stream().allMatch(p -> p.x() + p.y() == 2));
  }

  public boolean playerHasLine(Player player) {
    return player.equals(Player.X) ? thereIsLine(positionsWithX) : thereIsLine(positionsWithO);
  }
}
