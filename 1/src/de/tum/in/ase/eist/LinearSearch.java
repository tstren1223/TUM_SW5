package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    @Override
    public int performSearch(List<Chapter> book, String name) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getName().compareTo(name) == 0) {
                return book.get(i).getPageNumber();
            }
        }
        return -1;
    }
}
