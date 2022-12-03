import java.util.ArrayList;
public class Person {

    String name;
    int birthYear;
    ArrayList<Person> children = new ArrayList<>();
    ArrayList<Person> parent = new ArrayList<>();
    Person spouse = null;
    public Person( ) {

    }
    public Person ( String name, int birthYear ){
        this.name = name;
        this.birthYear = birthYear;
    }
    public Person( String name, int birthYear, ArrayList<Person> children, ArrayList<Person> parent, Person spouse) {

        this.name = name;
        this.birthYear = birthYear;
        this.children = children;
        this.parent = parent;
        this.spouse = spouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public ArrayList<Person> getParent() {
        return parent;
    }

    public void addParent( Person p) {
        this.parent.add( p );
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public void showTree( ){
        boolean gotKids = true;
        this.toString();
    }

    @Override
    public String toString() {
        String spouse = null;
        if (this.spouse != null ) spouse = this.spouse.name;
        return "Person:" +
                " name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", children=" + children.size() +
                ", parent=" + parent.size() +
                ", spouse=" + spouse ;
    }
}
