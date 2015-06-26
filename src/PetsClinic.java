import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by X1 on 26.06.2015.
 */
public class PetsClinic {
    private final static int MAX_PERSONS_IN_CLINIC = 100;
    private  static ArrayList<Person> persons = new ArrayList<Person>(MAX_PERSONS_IN_CLINIC);
    public static void main(String[] args) {

        String exitFromProgram = "no";
        Scanner scanner = new Scanner(System.in);
        while (!exitFromProgram.equals("yes")) {
            System.out.println("Cal the type of operation: 1 - Add new Person, 2 - View all Persons, \n " +
                    "3 - Find Person by name, 4 - Find Person by Pet name, 5 - Remove Person by name, \n " +
                    "6 - Remove Person by Pet name, 7 - Edit Person name, 8 - Edit Pet name");
            int typeOfOperation = scanner.nextInt();
            switch (typeOfOperation) {
                case 1: addPerson();
                        break;
                case 2: viewPersons();
                        break;
                case 3: viewPersonByPersonName();
                        break;
                case 4: viewPersonByPetName();
                        break;
                case 5: removePersonByName();
                        break;
                case 6: removePersonByPetName();
                        break;
                case 7: renamePerson();
                        break;
                case 8: renamePetPerson();
                        break;
                default: break;
            }
            System.out.println("Do you wanna leave or continue? yes/no");
            exitFromProgram = scanner.next();
        }

    }

    public static void addPerson() {
        if (persons.size() == MAX_PERSONS_IN_CLINIC) {
            System.out.printf("Clinic is FULL, max is %s please delete unnecessary Persons", MAX_PERSONS_IN_CLINIC);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name of Person:");
        String personName = scanner.next();
        if (isPersonAlreadyExists(personName)) {
            System.out.println("Person with name " +personName +", already exists");
            return;
        }
        System.out.println("Please enter name of Pet:");
        String petName = scanner.next();
        System.out.println("Please enter type of Pet: 1 - CAT, 2 - DOG, 3 - BIRD, 4 - REPTILE (default CAT)");
        int numberOfPet = scanner.nextInt();
        TypeOfPet typeOfPet;
        switch (numberOfPet) {
            case 1: typeOfPet = TypeOfPet.CAT;
                    break;
            case 2: typeOfPet = TypeOfPet.DOG;
                    break;
            case 3: typeOfPet = TypeOfPet.BIRD;
                    break;
            case 4: typeOfPet = TypeOfPet.REPTILE;
                    break;
            default:typeOfPet = TypeOfPet.CAT;
        }
        Person person = new Person(personName, new Pet(typeOfPet, petName));
        persons.add(person);
    }

    public static void viewPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons in clinic");
            return;
        }
        for (Person person: persons) {
            System.out.println(person);
        }
    }

    public static void viewPersonByPersonName() {
        String personName = getStringFromKeyb("Enter a Pet name for the search");
        for (int i = 0; i < persons.size(); i++) {
            if (personName.equals(persons.get(i).getPersonName())) {
                System.out.println(persons.get(i).toString());
                return;
            }
        }
        System.out.println("Person with name " +personName +", not found in clinic!");
    }

    public static void viewPersonByPetName() {
        String petName = getStringFromKeyb("Enter a Person name for the search");
        for (int i = 0; i < persons.size(); i++) {
            if (petName.equals(persons.get(i).getPetName())) {
                System.out.println(persons.get(i).toString());
                return;
            }
        }
        System.out.println("Person with name " +petName +", not found in clinic!");
    }

    public static void removePersonByName() {
        String personName = getStringFromKeyb("Enter a Person name for the remove");
        for (int i = 0; i < persons.size(); i++) {
            if (personName.equals(persons.get(i).getPersonName())) {
                persons.remove(i);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("Person with name " +personName +", not found in clinic!");
    }

    public static void removePersonByPetName() {
        String petName = getStringFromKeyb("Enter a Pet name for the remove");
        for (int i = 0; i < persons.size(); i++) {
            if (petName.equals(persons.get(i).getPetName())) {
                persons.remove(i);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("Person with Pet name " +petName +", not found in clinic!");
    }

    public static void renamePerson() {
        String personName = getStringFromKeyb("Enter a Person name for the rename");
        for (int i = 0; i < persons.size(); i++) {
            if (personName.equals(persons.get(i).getPersonName())) {
                String newPersonName = getStringFromKeyb("Enter a new Person name");
                if (isPersonAlreadyExists(newPersonName)) {
                    System.out.println("Person with name " +newPersonName +", already exists");
                    return;
                }
                persons.get(i).setPersonName(newPersonName);
                System.out.println("Person rename successfully");
                return;
            }
        }
        System.out.println("Person with name " +personName +", not found in clinic!");
    }

    public static void renamePetPerson() {
        String petName = getStringFromKeyb("Enter a Pet name for the rename");
        for (int i = 0; i < persons.size(); i++) {
            if (petName.equals(persons.get(i).getPetName())) {
                String newPetPersonName = getStringFromKeyb("Enter a new Person name");
                persons.get(i).setPetPersonName(newPetPersonName);
                System.out.println("Pet rename successfully");
                return;
            }
        }
        System.out.println("Person with Pet name " +petName +", not found in clinic!");
    }

    public static boolean isPersonAlreadyExists(String personName) {
        boolean result = false;
        for (int i = 0; i < persons.size(); i++) {
            if (personName.equals(persons.get(i).getPersonName().toLowerCase())) {
                result = true;
            }
        }
        return result;
    }

    private static String getStringFromKeyb(String reason) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reason);
        return scanner.next();
    }

}
