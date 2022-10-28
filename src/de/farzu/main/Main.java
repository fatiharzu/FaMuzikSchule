package de.farzu.main;

import de.farzu.settings.AppTexts;
import de.farzu.ui.UiController;
/**
 * Startklasse des Hauptprogramms
 */
public class Main {
    /**
     * Startmethode des Programms
     *
     * @param args : {@link String[]} : Startparameter
     */
    public static void main(String[] args) {


        UiController uiController = new UiController();
        uiController.startUi();
    }

}