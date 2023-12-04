import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure cds;

    public CourseDBManager() {
        cds = new CourseDBStructure(100);
    }

    @Override
    public void add(String id, int crn, int credits, String room, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, room, instructor);
        cds.add(element);
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } 
        catch (IOException e) {
            throw new RuntimeException("Unable to get the course with CRN: " + crn, e);
        }
    }

    @Override
    public ArrayList<String> showAll() {
        return cds.showAll();
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] details = line.split(" ", 5);
            if (details.length == 5) {
                add(details[0], Integer.parseInt(details[1]), Integer.parseInt(details[2]), details[3], details[4]);
            } 
            else {
                scanner.close();
                throw new FileNotFoundException("Invalid line format: " + line);
            }
        }
        scanner.close();
    }
}
