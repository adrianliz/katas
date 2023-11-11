package com.adrianliz;

public enum Player {
  X("X"),
  O("O");

  private final String value;

  Player(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
