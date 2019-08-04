package com.github.theelderstrings.model.weapon;

import com.github.theelderstrings.model.side.CounterTerrorist;
import com.github.theelderstrings.model.side.Terrorist;
import com.github.theelderstrings.model.weapon.SecondaryWeapon;

public class P250 extends SecondaryWeapon implements CounterTerrorist, Terrorist {
  public P250(int cost) {
    super(cost);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof P250)) {
      return false;
    }
    P250 p250 = (P250) o;
    return cost == p250.getCost();
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(cost);
  }

  @Override
  public String toString() {
    return "P250[cost=" + cost + "]";
  }
}
