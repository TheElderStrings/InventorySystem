package com.github.theelderstrings.model.loadout;

import com.github.theelderstrings.model.side.Side;
import com.github.theelderstrings.model.weapon.PrimaryWeapon;
import com.github.theelderstrings.model.weapon.SecondaryWeapon;
import java.util.HashSet;
import java.util.Set;

public class Loadout<T extends Side> {
  private LoadoutProperties properties;
  private Set<T> weapons;

  public Loadout() {
    weapons = new HashSet<>();
  }

  public LoadoutProperties withProperties() {
    properties = new LoadoutProperties();
    return properties;
  }

  public boolean buy(T weapon) {
    if (weapon instanceof PrimaryWeapon) {
      long count = weapons.stream().filter(w -> w instanceof PrimaryWeapon).count();
      if (count >= properties.getPrimarySlots()) {
        throw new LoadoutException("Slot limit for primary weapons reached.");
      }
      return weapons.add(weapon);
    }
    if (weapon instanceof SecondaryWeapon) {
      long count = weapons.stream().filter(w -> w instanceof SecondaryWeapon).count();
      if (count >= properties.getSecondarySlots()) {
        throw new LoadoutException("Slot limit for secondary weapons reached.");
      }
      return weapons.add(weapon);
    }
    return false;
  }

  public Set<T> getWeapons() {
    return weapons;
  }

  public LoadoutProperties getProperties() {
    return properties;
  }
}
