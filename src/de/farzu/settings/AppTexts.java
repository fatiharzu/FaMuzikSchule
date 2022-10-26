package de.farzu.settings;

import de.farzu.model.Student;
import de.rhistel.logic.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class AppTexts {

    //    region Konstanten
    public static final String TXT_APP_NAME = """
            __________________________
             ======
             |    | Note Musik Schule
            o'   o'
            __________________________
            """;
    public static final String TXT_SHOW_LIST = "\n( "+AppCommands.USER_CMD_SHOW+" ) Registered List";
    public static final String TXT_CREATE_STD = "( "+AppCommands.USER_CMD_CREATE+" ) Create A Student";
    public static final String TXT_EDIT_INFO = "( "+AppCommands.USER_CMD_EDIT+" ) Edit Information";
    public static final String TXT_DELETE_INFO = "( "+AppCommands.USER_CMD_DELETE+" ) Delete Registration";
    public static final String FINISH_PORGRAM = "( "+AppCommands.USER_CMD_EXIT+" ) Ending the program\n";
    public static final String INVALID_SELECTION = "\nIncorrect selection. Please select again.\n";
    public static final String NUM ="NUM";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String SURNAME = "SURNAME";
    public static final String GROUP = "GROUP";
    public static final String AGE = "AGE";
    public static final String LEVEL = "LEVEL";
    public static final String RENT_INSTRUMENT = "RENT_INSTRUMENT";
    public static final String MSG_RENT_INSTRUMENT = "Rent Instrument";
    public static final String MSG_INPUT_ID = "Please enter your ID";
    public static final String MSG_INVALID_ID = "\nUngültige ID. Das ID muss zwischen %d und %d Zeichen haben.";
    public static final String MSG_INVALID_NAME = "\nUngültiger Name. Der Name muss zwischen %d und %d Zeichen haben.";
    public static final String MSG_INVALID_SURNAME = "\nUngültiger Surname. Der Surname muss zwischen %d und %d Zeichen haben.";
    public static final String MSG_INVALID_GROUP = "\nUngültiger Group Name. Der Group Name muss zwischen %d und %d Zeichen haben.";
    public static final String MSG_INVALID_AGE = "\nUngültiger Age. Der Schüler muss zwischen %d und %d Jahre alt sein.";
    public static final String MSG_INVALID_LEVEL= "\nUngültiges Level. Das Level muss zwischen %d und %d Zeichen haben.";
    public static final String MSG_INPUT_LEVEL = "Please enter level; Beginner, Elementary, Intermediate";
    public static final String MSG_INPUT_AGE = "Student age must be between 10 and 35 years old ";
    public static final String MSG_INPUT_GROUP = "Choose one of the instruments; Guitar, Violin, Saxophone, Drum";
    public static final String MSG_INPUT_SURNAME = "Please enter Surname";
    public static final String MSG_INPUT_NAME = "Please enter name";
    public static final String FORMAT_STRING_APP_LIST_HEADER = "\n%5s %15s %15s %15s %15s %15s %20s\n";
    public static final String FORMAT_STRING_APP_LIST = "%5s %15s %15s %15s %15s %15s %20s\n";
    public static final String MSG_NOTE_REGISTRAION_COMPLETED = "Registration is completed";
    public static final String MSG_SELECT_STD_EDIT = "Please select a Student to edit.";
    public static final String MSG_STD_INFO_EDITED = "Student information has been successfully edited.";
    public static final String MSG_INVALID_SELECT = "Invalid Select";
    public static final String MSG_SELECT_DELETE_STD_INFO = "Select the student information you want to delete!";
    public static final String MSG_DELETE_DONE = "You have deleted the student information you requested!";
    //    region Konstanten
    //    endregion

    //    region Attribute
    //    endregion

    //    regionKonstruktor
    //    endregion

    //    regionMethoden
    //    endregion


}
