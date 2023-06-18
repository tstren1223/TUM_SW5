package de.tum.in.ase.eist;

public class Policy {
    private Context context;
    public Policy(Context con2) {
        context = con2;
    }
    public void configure() {
        if (context.isChaptersSortedByName()) {
            context.setSearchAlgorithm(new BinarySearch());
        }
        else {
            context.setSearchAlgorithm(new LinearSearch());
        }
    }
}
