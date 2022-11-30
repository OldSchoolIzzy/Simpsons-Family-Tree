import java.util.ArrayList;
import java.util.TreeMap;

public class FamilyTree {
    Person root = null;

    TreeMap<String, Person> tree = new TreeMap<>();

    public void addPerson( String name, Person p ){
        tree.put( name, p );
    }
    public void addChild( String parent, ArrayList<Person> children){
        if ( tree.containsKey(parent)){
            Person p = tree.get(parent);
            p.children = children;
            tree.put( p.name, p );
        }
    }
    public Person getThisPerson( String person ){
        if ( tree.containsKey(person)){
            return tree.get(person);
        } else {
            return null;
        }
    }
    public boolean addParent( String person, Person parent){
        boolean gotParent = false;
        if ( tree.containsKey(person)){
            Person p = tree.get(person);
            p.parent.add(parent);
            tree.put( p.name, p );
            return true;
        } else {
            return gotParent;
        }
    }
    public boolean addChild( String person, Person child){
        boolean gotParent = false;
        if ( tree.containsKey(person)){
            Person p = tree.get(person);
            p.children.add(child);
            tree.put( p.name, p );
            return true;
        } else {
            return gotParent;
        }
    }
    public TreeMap<String , Person> getAllPeople( ){
        return tree;
    }
}