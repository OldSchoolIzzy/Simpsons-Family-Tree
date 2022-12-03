import java.util.*;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = configureTree();

        TreeMap<String, Person> treeEntries = ft.getAllPeople();

        showAllPeople(treeEntries);

        System.out.println();
        AddNewPerson(ft);

        System.out.print("\n-------- All people ---------");
        TreeMap<String, Person> treeEntries2 = ft.getAllPeople();

        showAllPeople(treeEntries2);

        String name = "Jackie";
        System.out.printf("\n ---- Showing Direct Descendants of %s", name);
        System.out.println();
        ShowDirectDescendants( name , treeEntries2 );

        name = "Abbey";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        System.out.println();
        ShowDirectDescendants( name, treeEntries2);

        name = "Lisa";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        System.out.println();
        ShowDirectDescendants( name, treeEntries2 );

        name = "Mona";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        System.out.println();
        ShowDirectDescendants( name, treeEntries2 );

        name = "Homer";
        System.out.printf("\n --- Showing Siblings of %s", name);
        System.out.println();
        ShowMySiblings( name, treeEntries2 );

        name = "Maggie";
        System.out.printf("\n --- Showing Siblings of %s", name);
        System.out.println();
        ShowMySiblings(name, treeEntries2);

        name = "Clancy";
        System.out.printf("\n --- Showing Siblings of %s", name);
        System.out.println();
        ShowMySiblings(name, treeEntries2 );
    }

    private static void ShowMySiblings(String person, TreeMap<String, Person> tree) {
        HashSet<Person> siblings = new HashSet<>();
        for (String p : tree.keySet()){
            Person person1 = tree.get(p);
            if (person1.getName().equals(person)){
                ArrayList<Person> parents = person1.parent;
                for (Person parent : parents){
                    ArrayList<Person> children = parent.children;
                    for (Person child : children){
                        if (!child.getName().equals(person)){
                            siblings.add(child);
                        }
                    }
                }
            }
        }
        System.out.println(person + " siblings are ...");
        for (Person sibling : siblings){
            System.out.println(sibling.getName());
        }
    }

    private static void ShowDirectDescendants(String ancestor, TreeMap<String, Person> tree) {
        for (String p : tree.keySet()){
            Person person = tree.get(p);
            if (person.getName().equals(ancestor)){
                ArrayList<Person> children = person.children;
                for (Person child : children){
                    System.out.println(child.getName());
                    if (child.children.size() != 0){
                        ArrayList<Person> children2 = child.children;
                        for (Person ch : children2){
                            System.out.println(ch.getName());
                        }
                    }
                }
            }
        }
    }

    private static void AddNewPerson(FamilyTree ft) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter name of person you want to add: ");
        String name = scan.nextLine();

        System.out.println("Enter their birth year: ");
        int birthYear = scan.nextInt();

        System.out.println("Enter name of their mom: ");
        String momName = scan.next();

        System.out.println("Enter their birth year: ");
        int momBirthYear = scan.nextInt();

        System.out.println("Enter name of their dad: ");
        String dadName = scan.next();

        System.out.println("Enter their birth year: ");
        int dadBirthYear = scan.nextInt();

        System.out.println("Enter name of their spouse: ");
        String spouseName = scan.next();

        System.out.println("Enter their birth year: ");
        int spouseBirthYear = scan.nextInt();

        Person p1 = new Person(name, birthYear);
        ft.addPerson(name, p1);

        Person spouse = new Person(spouseName, spouseBirthYear);
        ft.addPerson(spouseName, spouse);

        p1.spouse = spouse;
        spouse.spouse = p1;

        Person mom = new Person(momName, momBirthYear);
        ft.addPerson(momName, mom);

        Person dad = new Person(dadName, dadBirthYear);
        ft.addPerson(dadName, dad);

        mom.spouse = dad;
        dad.spouse = mom;

        ft.addParent(name, mom);
        ft.addParent(name, dad);
        ft.addChild(momName, p1);
        ft.addChild(dadName, p1);
    }

    private static void showAllPeople(TreeMap<String, Person> treeEntries) {
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }

    private static FamilyTree configureTree() {

        FamilyTree ft = new FamilyTree();

        Person bart = new Person( "Bart", 2020 );
        ft.addPerson( "Bart", bart);
        Person lisa = new Person( "Lisa", 2021 );
        ft.addPerson("Lisa", lisa);
        Person maggie = new Person( "Maggie", 2022);
        ft.addPerson("Maggie", maggie);

        Person marge = new Person( "Marge", 1990);
        Person homer = new Person( "Homer", 1991);
        homer.spouse = marge;
        ft.addPerson("Homer", homer);
        marge.spouse = homer;
        ft.addPerson( "Marge", marge);

        ft.addParent("Bart", homer);
        ft.addParent( "Lisa", homer);
        ft.addParent("Maggie", homer);
        ft.addParent("Bart", marge );
        ft.addParent( "Lisa", marge);
        ft.addParent("Maggie", marge);
        ft.addChild("Marge",lisa);
        ft.addChild("Marge",bart);
        ft.addChild("Marge",maggie);
        ft.addChild("Homer", lisa);
        ft.addChild("Homer", bart);
        ft.addChild("Homer", maggie);

        Person Selma = new Person( "Selma", 1991 );
        ft.addPerson("Selma", Selma);

        Person patty = new Person( "Patty", 1992 );
        ft.addPerson("Patty", patty);

        Person clancy = new Person( "Clancy", 1960 );
        Person jackie = new Person( "Jackie", 1961 );
        clancy.spouse = jackie;
        jackie.spouse = clancy;

        ft.addPerson("Clancy", clancy);
        ft.addPerson( "Jackie", jackie);

        ft.addChild("Clancy", Selma);
        ft.addChild("Clancy", marge);
        ft.addChild("Clancy", patty);

        ft.addChild("Jackie", Selma);
        ft.addChild("Jackie", marge);
        ft.addChild("Jackie", patty);

        ft.addParent("Marge", clancy);
        ft.addParent("Marge", jackie);
        ft.addParent("Patty", clancy);
        ft.addParent("Patty", jackie);
        ft.addParent("Selma", clancy);
        ft.addParent("Selma", jackie);

        Person mona = new Person("Mona", 1950);
        ft.addPerson("Mona", mona);
        ft.addParent("Homer", mona);

        Person Abraham = new Person("Abraham", 1950);
        ft.addPerson("Abraham", Abraham);
        ft.addParent("Homer", Abraham);

        Abraham.spouse = mona;
        mona.spouse = Abraham;

        Person herbert = new Person("Herbert", 1990);
        Person abbey = new Person("Abbey", 1994);
        ft.addChild("Abraham", herbert);
        ft.addChild("Abraham", abbey);
        ft.addChild("Abraham", homer);
        ft.addChild("Mona", homer);

        ft.addParent("Herbert", Abraham);
        ft.addParent("Abbey", Abraham);
        return ft;
    }
}