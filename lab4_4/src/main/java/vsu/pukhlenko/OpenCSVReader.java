package vsu.pukhlenko;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OpenCSVReader {
    public static void main(String pathFile, String separator, ArrayList<Person> people, Divisions divisions) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(pathFile));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                String str = nextRecord[0];
                String[] strCells;
                strCells = str.split(separator);
                int id = Integer.parseInt(strCells[0]);
                String name = strCells[1];
                Sex sex;
                if (strCells[2] == "Male") {
                    sex = Sex.MALE;
                } else {
                    sex = Sex.FEMALE;
                }
                String bDay = strCells[3];
                String sDivision = strCells[4];
                int salary = Integer.parseInt(strCells[5]);

                divisions.add(sDivision);
                Person person = new Person(id, name, sex, salary, bDay, sDivision);

                people.add(person);

                System.out.println(person.PersonToString());
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

    }
}
