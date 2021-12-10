package vsu.pukhlenko;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import static vsu.pukhlenko.Sex.MALE;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
            Divisions divisions = new Divisions();
            Person person = new Person(12,"Мужчина", MALE, 1000, "10.06.2001", "I");

            String pathFile = "src/main/resources/foreign_names.csv";
            String separator = ";";

            ArrayList<Person> people = new ArrayList<Person>();

            OpenCSVReader.main(pathFile, separator, people, divisions);

        }
    }

