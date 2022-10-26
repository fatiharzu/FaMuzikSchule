package de.farzu.logic;

import de.farzu.model.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    //    region Konstanten
    public static final String CVS_FILE_PATH = "src/de/farzu/resources/list.csv";

    public static final String DELIMITER = "\t";
//    endregion

    //    region Attribute
    private static FileHandler instance;
//    endregion

    //    regionKonstruktor
    private FileHandler() {
        System.out.println("File handler created");
    }
//    endregion

    //    regionMethoden
    public static synchronized FileHandler getInstance() {

        if (instance == null) {
            instance = new FileHandler();
        }
        System.out.println("Filehandler returned");
        return instance;
    }

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
