package de.farzu.settings;

import de.rhistel.logic.ConsoleReader;

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
        boolean exitApp = false;
        do {
            printMainMenu();
            int selectMenu = ConsoleReader.in.readPositivInt();

            switch (selectMenu){

                case  AppCommands.USER_CMD_SHOW:
                    showRegist();
                    break;
                case AppCommands.USER_CMD_CREATE:
                    createStd();
                    break;
                case AppCommands.USER_CMD_EDIT:
                    editStd();
                    break;
                case AppCommands.USER_CMD_DELETE:
                    deleteStd();
                    break;
                case AppCommands.USER_CMD_EXIT:
                    exitApp =true;
                    break;
                default:
                    System.err.println(AppTexts.INVALID_SELECTION);
            }
        }while (!exitApp);
    }

    private void deleteStd() {
    }

    private void editStd() {
    }

    private void createStd() {
    }

    private void showRegist() {
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
