package com.github.theelderstrings;

import com.github.theelderstrings.model.player.Player;
import com.github.theelderstrings.model.side.Terrorist;
import com.github.theelderstrings.model.weapon.P250;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
  public static void main(String[] args) {
    Map<String, Integer> loadout = loadProperties();
    Player<Terrorist> player = new Player();
    player
        .getLoadout()
        .withProperties()
        .primarySlots(loadout.get("PrimarySlots"))
        .secondarySlots(loadout.get("SecondarySlots"))
        .meleSlots(loadout.get("MeleSlots"))
        .utilitySlots(loadout.get("UtilitySlots"))
        .maxUtilityStack(loadout.get("MaxUtilityStack"));
    // it is posible to buy a P250 due to Player's Terrorist parameter
    player.getLoadout().buy(new P250(300));
    // nevertheless, this player can not buy a M4A4, so the following
    // line would not let the application compile
    // player.getLoadout().buy(new M4A4(3100));
  }

  private static Map<String, Integer> loadProperties() {
    Properties properties = new Properties();
    Map<String, Integer> loadout = new HashMap<>();
    try (InputStream inputStream = Main.class.getResourceAsStream("/loadout.properties")) {
      properties.load(inputStream);
      System.err.println(properties);
      if (!properties.isEmpty()) {
        for (String key : properties.stringPropertyNames()) {
          int value = Integer.valueOf(properties.getProperty(key));
          loadout.put(key, value);
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return loadout;
  }
}
