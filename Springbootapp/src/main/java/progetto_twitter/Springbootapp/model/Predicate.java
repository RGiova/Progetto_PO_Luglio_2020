package progetto_twitter.Springbootapp.model;

import java.util.ArrayList;

public interface Predicate<T> {
    public boolean evaluate(T t);
    
    public static <T> T find(ArrayList<T> l, Predicate<T> p) { 
        for (T t : l) { if (p.evaluate(t)) return t; }
        return null;
    }
}