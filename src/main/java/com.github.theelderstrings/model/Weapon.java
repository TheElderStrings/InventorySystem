package com.github.theelderstrings.model;

public abstract class Weapon {
  protected final int cost;

  protected Weapon(int cost) {
    this.cost = cost;
  }
}
