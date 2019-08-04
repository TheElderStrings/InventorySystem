package com.github.theelderstrings.model.weapon;

import com.github.theelderstrings.model.side.CounterTerrorist;
import com.github.theelderstrings.model.weapon.PrimaryWeapon;

public class M4A4 extends PrimaryWeapon implements CounterTerrorist {
  public M4A4(int cost) {
    super(cost);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof M4A4)) {
      return false;
    }
    M4A4 m4A4 = (M4A4) o;
    return cost == m4A4.getCost();
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(cost);
  }

  @Override
  public String toString() {
    return "M4A4[cost=" + cost + "]";
  }
}
