import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = configureTree();
        TreeMap<String, Person> treeEntries = ft.getAllPeople();

        //HashMap<String, Person> treeEntries = configureTree();
        showAllPeople(treeEntries);
        ft = AddNewPerson( ft );   // ToDO Add Maggie born 2021 with bart and lisa siblings
        // and homer and marge (Mom and dad)
        System.out.print("\n -------- All people with Maggie ---------");
        TreeMap<String, Person> treeEntries2 = ft.getAllPeople();
        showAllPeople(treeEntries2);
        String name = "Jackie";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        ShowDirectDescendants( name );
        name = "Abbey";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        ShowDirectDescendants( name);
        name = "Lisa";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        ShowDirectDescendants( name);

        name = "Mona";
        System.out.printf("\n --- Showing Direct Descendants of %s", name);
        ShowDirectDescendants( name);

        name="Homer";
        System.out.printf("\n --- Showing Siblings of %s", name);
        ShowMySiblings( name);
        name="Maggie";
        System.out.printf("\n --- Showing Siblings of %s", name);
        ShowMySiblings(name);

        name="Clancy";
        System.out.printf("\n --- Showing Siblings of %s", name);
        ShowMySiblings(name);

//        showThisPersonsTree(treeEntries, "Marge");
    }

    private static void ShowMySiblings(String person) {
        // ToDo:
        // Output all of the siblings of this person. That is someone who shares a mother or father
        // For example if Person is Marge you would show Marge, Patty and Selma

    }

    private static void ShowDirectDescendants(String ancestor) {
        // ToDo: Write this method that shows the direct descendant
        // For example, if anester="Jackie" it would show:
        //    Jackie married to Clancy
        //     Patty
        //     Selma
        //     Marge
        //       Bart
        //       Lisa
    }

    private static FamilyTree AddNewPerson(FamilyTree ft) {
        // ToDo: Prompt the user for new person:
        //    Name and year birth
        //    Mom and Dad
        //    Spouse
        //   Add this person to the tree

        return ft;
    }



    private static void showAllPeople(TreeMap<String, Person> treeEntries) {
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }

    private static void showThisPersonsTree(HashMap<String, Person> treeEntries, String searchPerson) {
        System.out.printf("\n =--------------");
        if (treeEntries.containsKey(searchPerson)) {
            Person targetPerson = treeEntries.get(searchPerson);
            boolean gotMoreToDo = true;
            while (gotMoreToDo) {
                gotMoreToDo = false;

            }
        } else {
            System.out.printf("\n The Person:%s does not exist", searchPerson);
        }
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }


    private static FamilyTree configureTree() {
        // ToDo: Configure tree for Homers side of the family
        FamilyTree ft = new FamilyTree();
//        ft.addPerson( );
        Person nullPerson = null;
        Person nullSpouse = null;

        ArrayList<Person> nullChildrenList = new ArrayList<>();
        ArrayList<Person> nullParentList = new ArrayList<>();

        // bart and lisa and maggie
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

        // Lets add Marges Sisters
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
        return ft;
    }
}