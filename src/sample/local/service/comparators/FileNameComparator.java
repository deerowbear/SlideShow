package sample.local.service.comparators;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator {


    private boolean ascending;

    public void setAscending(boolean _ascending) {
        this.ascending = _ascending;
    }

    @Override
    public int compare(Object arg0 , Object arg1) {
        File file1 = (File) arg0;
        File file2 = (File) arg1;
        int comparison = file1.getName().compareTo(file2.getName());

        if ( ascending ) {
            return comparison;
        } else {
            return -comparison;
        }

    }

}
