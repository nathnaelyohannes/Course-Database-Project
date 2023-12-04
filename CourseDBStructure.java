import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure {
    private LinkedList<CourseDBElement>[] hashTable;
    private int size;

    public CourseDBStructure(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public CourseDBStructure(String testing, int size) {
        this(size);
    }

    public void add(CourseDBElement element) {
        int index = element.hashCode() % hashTable.length;
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].removeIf(e -> e.getCRN() == element.getCRN());
        hashTable[index].add(element);
    }

    public CourseDBElement get(int crn) throws IOException {
        int index = crn % hashTable.length;
        for (CourseDBElement e : hashTable[index]) {
            if (e.getCRN() == crn) {
                return e;
            }
        }
        throw new IOException("Element with CRN " + crn + " not found.");
    }

    public ArrayList<String> showAll() {
        ArrayList<String> list = new ArrayList<>();
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            if (bucket != null) {
                for (CourseDBElement element : bucket) {
                    list.add(element.toString());
                }
            }
        }
        return list;
    }

    public int getTableSize() {
        return size;
    }
}
