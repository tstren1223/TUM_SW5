package de.tum.in.ase.eist;
import java.util.List;
public class BinarySearch implements SearchStrategy {
    @Override
     public int performSearch(List<Chapter> book, String name) {
        int low = 0;
        int high = book.size() - 1;
        while (low <= high) {
            int med = (low + high) / 2;
            if (book.get(med).getName().compareTo(name) == 0) {
                return book.get(med).getPageNumber();
            }
            else if (book.get(med).getName().compareTo(name) < 0) {
                low = med + 1;
            }
            else {
                high = med - 1;
            }
        }
        return -1;
    }
}
