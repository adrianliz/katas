package com.adrianliz;

import java.util.HashSet;
import java.util.Set;

public final class Positions {
  private final Set<Position> positions = new HashSet<>();

  public boolean contains(Position position) {
    return positions.contains(position);
  }

  public void add(Position position) {
    if (positions.size() == 3) {
      return;
    }
    if (contains(position)) {
      return;
    }
    positions.add(position);
  }

  public boolean isThreeInLine() {
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
}
