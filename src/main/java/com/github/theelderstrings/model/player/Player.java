package com.github.theelderstrings.model.player;

import com.github.theelderstrings.model.loadout.Loadout;
import com.github.theelderstrings.model.side.Side;
import java.util.Objects;

public class Player<T extends Side> {
  private Loadout<T> loadout;
  private Loadout.Builder builder;

  public Player() {
    builder = new Loadout.Builder();
  }

  public Loadout<T> getLoadout() {
    if (Objects.isNull(loadout)) {
      loadout = builder.build();
    }
    return loadout;
  }

  public Loadout.Builder configureLoadout() {
    return builder;
  }
}
