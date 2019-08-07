package com.github.theelderstrings.model.player;

import com.github.theelderstrings.model.loadout.Loadout;
import com.github.theelderstrings.model.side.Side;

public class Player<T extends Side> {
  private Loadout<T> loadout;

  public Player() {
    loadout = new Loadout();
  }

  public Loadout<T> getLoadout() {
    return loadout;
  }
}
