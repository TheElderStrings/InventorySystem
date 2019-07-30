package com.github.theelderstrings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
  public static void main(String[] args) {
    printProperties();
  }

  private static void printProperties() {
    Properties prop = new Properties();
    try (InputStream inputStream = Main.class.getResourceAsStream("/loadout.properties")) {
      prop.load(inputStream);
      System.err.println(prop);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
