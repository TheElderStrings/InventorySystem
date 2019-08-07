package com.github.theelderstrings.model.loadout;

public class LoadoutProperties {
  private int primarySlots;
  private int secondarySlots;
  private int meleSlots;
  private int utilitySlots;
  private int maxUtilityStack;

  public LoadoutProperties primarySlots(int primarySlots) {
    this.primarySlots = primarySlots;
    return this;
  }

  public LoadoutProperties secondarySlots(int secondarySlots) {
    this.secondarySlots = secondarySlots;
    return this;
  }

  public LoadoutProperties meleSlots(int meleSlots) {
    this.meleSlots = meleSlots;
    return this;
  }

  public LoadoutProperties utilitySlots(int utilitySlots) {
    this.utilitySlots = utilitySlots;
    return this;
  }

  public LoadoutProperties maxUtilityStack(int maxUtilityStack) {
    this.maxUtilityStack = maxUtilityStack;
    return this;
  }

  public int getPrimarySlots() {
    return primarySlots;
  }

  public int getSecondarySlots() {
    return secondarySlots;
  }

  public int getMeleSlots() {
    return meleSlots;
  }

  public int getUtilitySlots() {
    return utilitySlots;
  }

  public int getMaxUtilityStack() {
    return maxUtilityStack;
  }
}
