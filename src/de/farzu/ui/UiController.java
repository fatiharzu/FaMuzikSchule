package de.farzu.ui;

import de.farzu.logic.FileHandler;
import de.farzu.model.Student;
import de.farzu.settings.AppCommands;
import de.farzu.settings.AppTexts;
import de.rhistel.logic.ConsoleReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static de.farzu.settings.AppTexts.*;

public class UiController {
    //    regionKonstanten
    //    endregion

    //    region Attribute
    private final List<Student> students = new ArrayList<>();

    private final UiInputHandler inputHandler;

    //    endregion

    //    regionKonstruktor
    public UiController(){

    inputHandler=new UiInputHandler();
    }
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
                    System.err.println(INVALID_SELECTION);
            }
        }while (!exitApp);
    }

    private void deleteStd() {
        System.out.println(MSG_SELECT_DELETE_STD_INFO);
        showRegist();

        int indexToDelete = ConsoleReader.in.readPositivInt();

        if (indexToDelete < students.size()){
            students.remove(indexToDelete);
            sortAndSaveListInCsvFile();
            System.out.println(MSG_DELETE_DONE);
        }else {
            System.out.println(MSG_INVALID_SELECT);
        }
    }

    private void editStd() {
        System.out.println(MSG_SELECT_STD_EDIT);
        showRegist();

        int indexToEdit = ConsoleReader.in.readPositivInt();

        if (indexToEdit<students.size()){
            Student student = inputHandler.getListFromeConsole();
            students.set(indexToEdit,student);

            sortAndSaveListInCsvFile();
            System.out.println(MSG_STD_INFO_EDITED);
        }else {
            System.out.println(MSG_INVALID_SELECT);
        }
    }

    private void createStd() {
        Student student = inputHandler.getListFromeConsole();

        students.add(student);

        sortAndSaveListInCsvFile();

        System.out.println(MSG_NOTE_REGISTRAION_COMPLETED);
    }


    private void showRegist() {
        System.out.printf(AppTexts.FORMAT_STRING_APP_LIST_HEADER,
                NUM, ID, NAME, SURNAME, GROUP,
                AGE, LEVEL, RENT_INSTRUMENT);
        for (int i = 0 ; i <students.size() ; i++){
            Student student = students.get(i);
            System.out.printf(AppTexts.FORMAT_STRING_APP_LIST, i, student.getId(), student.getName(), student.getSurName(),
                    student.getGroup(), student.getAge(),  student.getLevel(), student.RentInstrument());
        }
    }

    private void printMainMenu() {
        System.out.println(TXT_SHOW_LIST);
        System.out.println(TXT_CREATE_STD);
        System.out.println(TXT_EDIT_INFO);
        System.out.println(TXT_DELETE_INFO);
        System.out.println(FINISH_PORGRAM);
    }

    private void printApplicationName(){
        System.out.println(TXT_APP_NAME);
    }

    private void sortAndSaveListInCsvFile() {
 //       sortById();
        FileHandler.getInstance().saveStdToCvsFile(students);
    }

//    private void sortById() {
//        students.sort(firstId,secondId) -> {
//            int firstIdList =firstId.id();
//        }
//    }
//    students.sort(new Comparator<Student>() {
//        @Override
//        public int compare(Student firstId, Student secondId) {
//
//            //Sortieren nach Wichtigkeit absteigend (true > false)
//            Integer firstIdcomp = firstId.getId();
//            Boolean secondIdComp = secondId.getId();
//
//            int idCompare = firstIdcomp.compareTo(secondIdComp);
//
//            if (idCompare != 0) {
//                return -idCompare;
//            }
//
//        }
//    });
    //    endregion

}