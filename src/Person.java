/**
 * Created by X1 on 26.06.2015.
 */
public class Person {

    private String personName;
    private Pet personPet;

    public Person(String personName, Pet personPet) {
        this.personName = personName;
        this.personPet = personPet;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPetPersonName(String petPersonName) {
        personPet.setPetName(petPersonName);
    }

    public String getPersonName() {
        return personName;
    }

    public String getPetName(){
        return personPet.getPetName();
    }

    @Override
    public String toString() {
        return "Name of person: " +personName +" // Name of Pet: " +personPet.getPetName()  +
                " / Type of Pet: " +personPet.getTypeOfPet() +" / Pet ability is " +personPet.getPetAbility() ;
    }

}
