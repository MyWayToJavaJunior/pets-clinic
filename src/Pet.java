/**
 * Created by X1 on 26.06.2015.
 */
public class Pet {

    private TypeOfPet typeOfPet;
    private String petName;

    public Pet(TypeOfPet typeOfPet, String petName) {
        this.typeOfPet = typeOfPet;
        this.petName = petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }

    public String getTypeOfPet() {
        return typeOfPet.toString();
    }

    public String getPetAbility() {
        return typeOfPet.petAbility();
    }
}
