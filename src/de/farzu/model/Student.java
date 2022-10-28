package de.farzu.model;

import de.farzu.logic.FileHandler;

/**
 *    Diese Klasse repräsentiert einen Schüler,
 *    der an einer realen Musikschule eingeschrieben ist.
 *    Enthält den Vornamen, den Nachnamen, das Alter, die Band und
 *    eine Flag zum Ausleihen von Musikinstrumenten des Schülers
 */
public class Student {
//    region Konstanten
    public static final String DEFAULT_STRING_VALUE = ">noValueSetYes<";
    public static final int DEFAULT_INT_NUM_VALUE = 0;
    private static final boolean  DEFAULT_BOOLEAN_VALUE = false;
    public static final int DEFAULT_INT_VALUE =1001;
    public static final int INDEX_STD_ID = 0;
    public static final int INDEX_STD_NAME = 1;
    public static final int INDEX_STD_SURNAME = 2;
    public static final int INDEX_CLASS_GROUP = 3;
    public static final int INDEX_STD_AGE = 4;
    public static final int INDEX_STD_LEVEL = 5;

    private static final int INDEX_STD_RENTINSTRUMENT = 6;

//    endregion

//    region Attribute

    private int id;
    private String name;
    private String surName;
    private String group;
    private int age;
    private String level;
    private boolean rentInstrument;

//    endregion

//    regionKonstruktor
    /**
     * Standardkonstruktor, welcher Eigenschaften mit eigenen
     * Standardwerten initialisiert.
     */

    public Student(){

        id = DEFAULT_INT_VALUE;
        name = DEFAULT_STRING_VALUE;
        surName = DEFAULT_STRING_VALUE;
        group = DEFAULT_STRING_VALUE;
        age = DEFAULT_INT_NUM_VALUE;
        level = DEFAULT_STRING_VALUE;
        rentInstrument=DEFAULT_BOOLEAN_VALUE;

    }
    public Student(int id, String name, String group){
        this();
        this.id=id;
        this.name=name;
        this.group=group;
    }

    public Student(int id, String name, String surName, String group, int age, String level, boolean rentInstrument) {
        this.id =id;
        this.name = name;
        this.surName = surName;
        this.group = group;
        this.age = age;
        this.level = level;
        this.rentInstrument = rentInstrument;
    }
    /**
     * Überladener Konstruktor, welcher ine CSV-Zeile entgegennimmt
     * und über eine passende Methode alle Attribute initialisiert.
     *
     * @param cvsLine : {@link String} : Csv-Zeile mit Attributen
     */

    public Student(String cvsLine){
        setAttributesFromCsvLine(cvsLine);
    }
    //    endregion

//    regionMethoden
    /**
     * Liefert ale Attribute als Csv-String zurück.
     * D.h. ein String mit Attributwerten getrennt durch ein bestimmtes Trennzeichen
     *
     * @return {@link String} : Csv-Zeile
     */
    public String getAttributesAsCvsLine() {
        return  id + FileHandler.DELIMITER+
                name + FileHandler.DELIMITER+
                surName + FileHandler.DELIMITER+
                group + FileHandler.DELIMITER+
                age + FileHandler.DELIMITER+
                level + FileHandler.DELIMITER+
                rentInstrument+"\n";
    }
    /**
     * Befüllt alle Attribute mittels eines Csv-Strings
     *
     * @param cvsLine : {@link String} : Csv-String mit Attributwerten
     */
    private void setAttributesFromCsvLine(String cvsLine) {
        String[] allAttributes = cvsLine.split(FileHandler.DELIMITER);
        id = Integer.parseInt(allAttributes[INDEX_STD_ID]);
        name = allAttributes[INDEX_STD_NAME];
        surName = allAttributes[INDEX_STD_SURNAME];
        group = allAttributes[INDEX_CLASS_GROUP];
        age = Integer.parseInt(allAttributes[INDEX_STD_AGE]);
        level = allAttributes[INDEX_STD_LEVEL];
        rentInstrument = Boolean.parseBoolean(allAttributes[INDEX_STD_RENTINSTRUMENT]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean RentInstrument() {
        return rentInstrument;
    }

    public void setRentInstrument(boolean rentInstrument) {
        this.rentInstrument = rentInstrument;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", group='" + group + '\'' +
                ", age='" + age + '\'' +
                ", level='" + level + '\'' +
                ", rentInstrument=" + rentInstrument +
                '}';
    }

    //    endregion

}
