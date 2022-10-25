package de.farzu.ui;

import de.farzu.settings.AppTexts;

public class UiController {
//    regionKonstanten
//    endregion

//    region Attribute
//    endregion

//    regionKonstruktor
//    endregion

//    regionMethoden
    public void startUi(){
        printApplicationName();
        handleUserInteraction();
    }

    private void handleUserInteraction() {
        do {
            printMainMenu();
        }while ();
    }

    private void printMainMenu() {
        System.out.println(AppTexts.TXT_SHOW_LIST);
        System.out.println(AppTexts.TXT_CREATE_STD);
        System.out.println(AppTexts.TXT_EDIT_INFO);
        System.out.println(AppTexts.TXT_DELETE_INFO);
        System.out.println(AppTexts.FINISH_PORGRAM);
    }

    private void printApplicationName(){
        System.out.println(AppTexts.TXT_APP_NAME);
    }
//    endregion

}
