/**
 * Created by X1 on 26.06.2015.
 */
public enum TypeOfPet {
    CAT ("climb trees"),
    DOG("bark"),
    BIRD("fly"),
    REPTILE("creep");

    private final String PET_ABILITY;

    TypeOfPet (final String PET_ABILITY) {
        this.PET_ABILITY = PET_ABILITY;
    }

    String petAbility() {
        return PET_ABILITY;
    }
}
