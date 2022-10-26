package de.farzu.ui;

import de.farzu.model.Student;
import de.farzu.settings.AppTexts;
import de.farzu.settings.ContentSettings;
import de.rhistel.logic.ConsoleReader;

public class UiInputHandler {
    //    region Konstanten
//    endregion

//    region Attribute
//    endregion

//    regionKonstruktor
//    endregion

//    regionMethoden
    public Student getListFromeConsole(){

        int id = getValidID();
        String name = getValidName();
        String surName = getValidSurname();
        String group = getValidGroup();
        int age = getValidAge();
        String level = getValidLevel();
        System.out.println(AppTexts.MSG_RENT_INSTRUMENT);
        boolean rentInstrument = ConsoleReader.in.readMandatoryAnswerToBinaryQuestion();
        
        
        
        return new Student(id, name, surName, group, age, level, rentInstrument);
    }



    private String getValidLevel() {
        String level = Student.DEFAULT_STRING_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_LEVEL);
            level = ConsoleReader.in.readMandatoryString();

            if (level.length() >= ContentSettings.MIN_LENGTH_CONTENT && level.length() <= ContentSettings.MAX_LENGTH_CONTENT){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_LEVEL,ContentSettings.MIN_LENGTH_CONTENT,ContentSettings.MAX_LENGTH_CONTENT);
            }

        }
        return level;
    }

    private static int getValidAge() {
        int age = Student.DEFAULT_INT_NUM_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_AGE);
            age = ConsoleReader.in.readPositivInt();

            if (age >= ContentSettings.MIN_LENGTH_AGE_CONTENT && age <= ContentSettings.MAX_LENGTH_AGE_CONTENT){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_AGE,ContentSettings.MIN_LENGTH_AGE_CONTENT,ContentSettings.MAX_LENGTH_AGE_CONTENT);
            }

        }
        return age;

    }

    private String getValidGroup() {
        String group = Student.DEFAULT_STRING_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_GROUP);
            group = ConsoleReader.in.readMandatoryString();

            if (group.length() >= ContentSettings.MIN_LENGTH_LEVEL_CONTENT && group.length() <= ContentSettings.MAX_LENGTH_LEVEL_CONTENT){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_GROUP,ContentSettings.MIN_LENGTH_LEVEL_CONTENT,ContentSettings.MAX_LENGTH_LEVEL_CONTENT);
            }

        }
        return group;
    }

    private String getValidSurname() {
        String surName = Student.DEFAULT_STRING_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_SURNAME);
            surName = ConsoleReader.in.readMandatoryString();

            if (surName.length() >= ContentSettings.MIN_LENGTH_CONTENT && surName.length() <= ContentSettings.MAX_LENGTH_CONTENT){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_SURNAME,ContentSettings.MIN_LENGTH_CONTENT,ContentSettings.MAX_LENGTH_CONTENT);
            }

        }
        return surName;
    }

    private String getValidName() {
        String name = Student.DEFAULT_STRING_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_NAME);
            name = ConsoleReader.in.readMandatoryString();

            if (name.length() >= ContentSettings.MIN_LENGTH_CONTENT && name.length() <= ContentSettings.MAX_LENGTH_CONTENT){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_NAME,ContentSettings.MIN_LENGTH_CONTENT,ContentSettings.MAX_LENGTH_CONTENT);
            }

        }
        return name;
    }

    private int getValidID() {
        int id = Student.DEFAULT_INT_NUM_VALUE;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(AppTexts.MSG_INPUT_ID);
            id = ConsoleReader.in.readInt();

            if (id >= ContentSettings.MIN_LENGTH_ID && id <= ContentSettings.MAX_LENGTH_ID){
                isValid = true;
            }else {
                System.out.printf(AppTexts.MSG_INVALID_ID,ContentSettings.MIN_LENGTH_ID,ContentSettings.MAX_LENGTH_ID);
            }

        }
        return id;
    }

//    endregion

}
