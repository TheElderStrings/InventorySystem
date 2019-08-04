package com.github.theelderstrings.model.weapon;

public abstract class Weapon {
  private final int cost;

  public Weapon(int cost) {
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }
}
