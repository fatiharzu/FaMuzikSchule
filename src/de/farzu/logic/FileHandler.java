package de.farzu.logic;

import de.farzu.model.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    //    region Konstanten
    public static final String CVS_FILE_PATH = "src/de/farzu/resources/list.csv";

    public static final String DELIMITER = "\t\t;\t\t";
//    endregion

    //    region Attribute
    private static FileHandler instance;
//    endregion

    //    regionKonstruktor
    private FileHandler() {
    }
//    endregion

    //    regionMethoden
    /**
     * Instanziiert beim ersten Aufruf ein Objekt der Klasse.
     * Danach wird dieses Objekt nur noch zurückgeliefert.
     *
     * @return {@link FileHandler} : EINZIGE Instanz der Klasse
     */
    public static synchronized FileHandler getInstance() {

        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }
    /**
     * Speichert eine bestimmte Liste von Schülern als CSV-Strings in der CSV-Datei.
     *
     * @param stdsToSave : {@link List<Student>} : Liste mit zu speichernden Schülern
     */

    public void saveStdToCvsFile(List<Student> stdsToSave) {

        File cvsFile = new File(CVS_FILE_PATH);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter out = null;

        try {

            fos = new FileOutputStream(cvsFile);
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            out = new BufferedWriter(osw);

            for (Student stdToSave : stdsToSave) {
                out.write(stdToSave.getAttributesAsCvsLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Liest die Datei Zeile für Zeile aus, generiert aus jeder Zeile ein Schüler-Objekt
     * und fügt es einer Liste hinzu. Diese Liste wird zurückgegeben.
     *
     * @return {@link List<Student>} : Liste von Schülern
     * TODO 0 Auslesen der Datei implementieren
     */

    public List<Student> readStudentListFromCvsFile() {
        List<Student> students = new ArrayList<>();
        File csvFile = new File(CVS_FILE_PATH);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader in = null;

        try {
            if (!csvFile.exists()) {
                csvFile.createNewFile();
            }
            fis = new FileInputStream(csvFile);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            in = new BufferedReader(isr);

            boolean eof = false;
            while (!eof) {
                String csvLine = in.readLine();
                if (csvLine == null) {
                    eof = true;
                } else {
                    Student student = new Student(csvLine);
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //Brücke zur Datei schließen
                in.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return students;
    }
//    endregion

}
