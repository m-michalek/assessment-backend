package de.assecor.backend.datascource;

import de.assecor.backend.model.Person;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class CsvDatasource {

    private String path = "/Users/max/dev/assecor/Abgabe/backend/src/main/java/de/assecor/backend/assets/sample-input.csv";
    private BufferedReader br;
    private ArrayList<Person> csvData = new ArrayList<>();
    private int lineNumber = 1;

    public ArrayList<Person> readCsv() {
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            String tmpLine = "";

            // Assumption:
            // The CSV records are complete. That means there is no missing first or last name
            // A CSV tuple consists of 4 items

            // TBD: How to handle "- ☀"

            while((line = br.readLine()) != null) {
                // Remove spaces from the start and end of line
                line = line.trim();

                // A comma at the end of the line means that the record continues
                if(line.endsWith(",")) {
                    tmpLine = tmpLine + line;

                    // A CSV tuple ends
                } else {
                    String[] lineArray;

                    // The line before was a complete tuple
                    if(tmpLine.length() == 0) {

                        // Split the string
                        lineArray = line.split(",");


                        // The line before was not a complete tuple
                    } else {

                        // Split the string
                        lineArray = (tmpLine + line).split(",");


                        // Reset tmpLine
                        tmpLine = "";
                    }

                    Person person = new Person(
                            // id
                            String.valueOf(this.lineNumber),
                            // name
                            lineArray[1].trim(),
                            // lastname
                            lineArray[0].trim(),
                            // zipcode
                            lineArray[2].trim().substring(0,5),
                            // city
                            lineArray[2].trim().substring(6, lineArray[2].trim().length()),
                            // color
                            idToColor(lineArray[3].trim())
                    );
                    this.csvData.add(person);
                    lineNumber++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.csvData;
    }

    private String idToColor(String id) {
        switch (id) {
            case "1":
                return "blau";
            case "2":
                return "grün";
            case "3":
                return "violett";
            case "4":
                return "rot";
            case "5":
                return "gelb";
            case "6":
                return "türkis";
            case "7":
                return "weiß";
            default:
                return "N/A";
        }
    }
}
