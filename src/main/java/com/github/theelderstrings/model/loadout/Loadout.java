package com.github.theelderstrings.model.loadout;

import com.github.theelderstrings.model.side.Side;
import com.github.theelderstrings.model.weapon.PrimaryWeapon;
import com.github.theelderstrings.model.weapon.SecondaryWeapon;
import java.util.HashSet;
import java.util.Set;

public class Loadout<T extends Side> {
  private Set<T> weapons;
  private int primarySlots;
  private int secondarySlots;
  private int meleSlots;
  private int utilitySlots;
  private int maxUtilityStack;

  public static class Builder {
    private int primarySlots;
    private int secondarySlots;
    private int meleSlots;
    private int utilitySlots;
    private int maxUtilityStack;

    public Builder primarySlots(int primarySlots) {
      this.primarySlots = primarySlots;
      return this;
    }

    public Builder secondarySlots(int secondarySlots) {
      this.secondarySlots = secondarySlots;
      return this;
    }

    public Builder meleSlots(int meleSlots) {
      this.meleSlots = meleSlots;
      return this;
    }

    public Builder utilitySlots(int utilitySlots) {
      this.utilitySlots = utilitySlots;
      return this;
    }

    public Builder maxUtilityStack(int maxUtilityStack) {
      this.maxUtilityStack = maxUtilityStack;
      return this;
    }

    public Loadout build() {
      return new Loadout(this);
    }
  }

  public Loadout(Builder builder) {
    weapons = new HashSet<>();
    primarySlots = builder.primarySlots;
    secondarySlots = builder.secondarySlots;
    meleSlots = builder.meleSlots;
    utilitySlots = builder.utilitySlots;
    maxUtilityStack = builder.maxUtilityStack;
  }

  public void buy(T weapon) {
    if (checkWeaponValidity(weapon)) {
      weapons.add(weapon);
    }
  }

  public Set<T> getWeapons() {
    return weapons;
  }

  private boolean checkWeaponValidity(T weapon) {
    if (weapon instanceof PrimaryWeapon) {
      if (weapons.stream().filter(PrimaryWeapon.class::isInstance).count() >= primarySlots) {
        throw new LoadoutException("Slot limit for primary weapons reached.");
      }
      return true;
    }
    if (weapon instanceof SecondaryWeapon) {
      if (weapons.stream().filter(SecondaryWeapon.class::isInstance).count() >= secondarySlots) {
        throw new LoadoutException("Slot limit for secondary weapons reached.");
      }
      return true;
    }
    return false;
  }
}
