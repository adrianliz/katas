package com.adrianliz;

import java.util.ArrayList;
import java.util.List;

public class Cells {
  private final List<Position> positionsWithX = new ArrayList<Position>();
  private final List<Position> positionsWithO = new ArrayList<Position>();

  public void put(String player, Position position) {
    if (player.equals("X")) {
      positionsWithX.add(position);
      return;
    }
    positionsWithO.add(position);
  }

  private boolean thereIsLine(List<Position> positions) {
    return positions.stream().allMatch(p -> p.x() == 0)
        || positions.stream().allMatch(p -> p.x() == 1)
        || positions.stream().allMatch(p -> p.x() == 2)
        || positions.stream().allMatch(p -> p.y() == 0)
        || positions.stream().allMatch(p -> p.y() == 1)
        || positions.stream().allMatch(p -> p.y() == 2)
        || positions.stream().allMatch(p -> p.x() == p.y())
        || positions.stream().allMatch(p -> p.x() + p.y() == 2);
  }

  public boolean playerHasLine(String player) {
    return player.equals("X") ? thereIsLine(positionsWithX) : thereIsLine(positionsWithO);
  }
}