package thread.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test01 {
    volatile List<Integer> list = new ArrayList<>();
    public void add(int i){
        list.add(i);
    }
    public int size(){
        return list.size();
    }
}
