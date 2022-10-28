package de.farzu.ui;

import de.farzu.logic.FileHandler;
import de.farzu.model.Student;
import de.farzu.settings.AppCommands;
import de.farzu.settings.AppTexts;
import de.rhistel.logic.ConsoleReader;

import java.util.List;
import static de.farzu.settings.AppTexts.*;
/**
 * Implementiert die Interaktion zwischen UI (User Interface / Benutzeroberfläche) und dem Benutzer.
 * Anhand von Nutzereingaben wird dann weitere Logik eingeleitet.
 * TODO 2 Auslesen der Datei an der passenden einleiten
 * TODO 3 Speichern der Schülern in der Datei an den passenden Stellen aufrufen
 * TODO 4 Sortieren an den passenden Stellen aufrufen
 */

public class UiController {
    //    regionKonstanten
    //    endregion

    //    region Attribute
    private final List<Student> students ;

    private final UiInputHandler inputHandler;

    //    endregion

    //    regionKonstruktor
    public UiController(){

        students = FileHandler.getInstance().readStudentListFromCvsFile();

    inputHandler=new UiInputHandler();
    }
    //    endregion

    //    regionMethoden
    public void startUi(){
        printApplicationName();
        handleUserInteraction();
    }
    /**
     * Gibt das Hauptmenü aus, erwartet eine Nutzereingabe, wertet diese aus
     * und leitet weiter Logik ein.
     * Die Interaktion mit dem Hauptmenü ist fortlaufend über eine
     * while-Schleife und switch case realisiert.
     */
    private void handleUserInteraction() {
        boolean exitApp = false;
        do {
            printMainMenu();
            int selectMenu = ConsoleReader.in.readPositivInt();

            switch (selectMenu) {
                case AppCommands.USER_CMD_SHOW -> showRegist();
                case AppCommands.USER_CMD_CREATE -> createStd();
                case AppCommands.USER_CMD_EDIT -> editStd();
                case AppCommands.USER_CMD_DELETE -> deleteStd();
                case AppCommands.USER_CMD_GET -> getStd();
                case AppCommands.USER_CMD_SORT -> sortByGroup();
                case AppCommands.USER_CMD_EXIT -> exitApp = true;

                default -> System.err.println(INVALID_SELECTION);
            }
        }while (!exitApp);
    }

    /**
     * Löscht ein Element aus der Liste anhand einer Nutzereingabe für
     * den Index.
     */
    private void deleteStd() {
        System.out.println(MSG_SELECT_DELETE_STD_INFO);
        showRegist();

        int indexToDelete = ConsoleReader.in.readPositivInt();

        if (indexToDelete < students.size()){
            students.remove((indexToDelete));
            sortAndSaveListInCsvFile();
            System.out.println(MSG_DELETE_DONE);
        }else {
            System.out.println(MSG_INVALID_SELECT);
        }
    }
    /**
     * Lässt den Nutzer einen Schüler zum Bearbeiten auswählen.
     * Danach werden neue Daten eingelesen und die Schülerinformationen abgeändert.
     */
    private void editStd() {
        System.out.println(MSG_SELECT_STD_EDIT);
        showRegist();

        int indexToEdit = ConsoleReader.in.readPositivInt();

        if (indexToEdit<students.size()){
            Student student = inputHandler.getListFromeConsole();
            students.set((indexToEdit),student);

            sortAndSaveListInCsvFile();
            System.out.println(MSG_STD_INFO_EDITED);
        }else {
            System.out.println(MSG_INVALID_SELECT);
        }
    }
    /**
     * Legt einen neuen Schüler anhand von Nutzereingaben an
     * und fügt sie der Liste hinzu.
     */
    private void createStd() {
        Student student = inputHandler.getListFromeConsole();
        students.add(student);
        sortAndSaveListInCsvFile();
        System.out.println(MSG_NOTE_REGISTRATION_COMPLETED);
    }
    /**
     * Zeigt alle gespeicherten Schülern auf der Konsole an
     */
    private void showRegist() {
        System.out.printf(AppTexts.FORMAT_STRING_APP_LIST_HEADER, APP_INDEX,
                ID, NAME, SURNAME, GROUP,
                AGE, LEVEL, RENT_INSTRUMENT);
        System.out.println(TXT_LONG_LINE);
        for (int i = 0 ; i <students.size() ; i++){
            Student student = students.get(i);
            System.out.printf(AppTexts.FORMAT_STRING_APP_LIST, i, student.getId(), student.getName(), student.getSurName(),
                    student.getGroup(), student.getAge(),  student.getLevel(), student.RentInstrument());
        }
    }
    /**
     * Zeigt Main Menu auf der Konsole an
     */
    private void printMainMenu() {
        System.out.println(TXT_SHORT_LINE);
        System.out.println(TXT_SHOW_LIST);
        System.out.println(TXT_CREATE_STD);
        System.out.println(TXT_EDIT_INFO);
        System.out.println(TXT_DELETE_INFO);
        System.out.println(TXT_GET_STD);
        System.out.println(TXT_SORT_GROUP);
        System.out.println(FINISH_PORGRAM);
        System.out.println(TXT_SHORT_LINE);
    }
    /**
     * Zeigt Applikation name auf der Konsole an
     */
    private void printApplicationName(){
        System.out.println(TXT_APP_NAME);
    }

    /**
     * Speichert den momentanen Stand der Liste in der Csv-Datei nach dem Sortieren der Liste
     */
    private void sortAndSaveListInCsvFile() {
        sortById();
        FileHandler.getInstance().saveStdToCvsFile(students);
    }

    /**
     * Bringt die gewünschten indizierten Schülerinformationen in die Schülerliste
     */
    private void getStd() {
        System.out.println(MSG_GET_STD);
        showRegist();
        int indexToGet = ConsoleReader.in.readPositivInt();
        if (indexToGet<students.size()){
            System.out.println(MSG_STD_INFOS);
            System.out.println(students.get(indexToGet));
        }else {
            System.out.println(MSG_INVALID_SELECT);
        }
    }

    /**
     * Sortiert die Studentenliste nach ihrer ID-Nummer von der kleinsten zur größten.
     */
    public void sortById(){

        students.sort((firstId, secondId) -> {
            Integer  firstIdList = firstId.getId();
            Integer secondIdList = secondId.getId();

                      int campareId = firstIdList.compareTo(secondIdList);

            return campareId;
        });
    }
    /**
     * Sortiert die Schülerliste nach einem ausgewählten Parameter (Musikgruppe),
     * von Kleinbuchstaben nach Großbuchstaben.
     */
    private void sortByGroup() {
        students.sort((firstGroup, secondGroup) -> {
            String firstGroupList = firstGroup.getGroup();
            String secondGroupList = secondGroup.getGroup();

            int campareGroup = firstGroupList.compareTo(secondGroupList);

            System.out.println(MSG_SORT_STD_COPMLETED);
            showRegist();
            return campareGroup;
        });
    }

    //    endregion

}