package model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Ability {
    CLEVER(Proffesion.ADEPT, 0, "POJĘTNY", "+20% przyrost wiedza, skupienie, charyzma (co piąty punkt za darmo)"),
    VEIN(Proffesion.ADEPT, 1, "WENA", "Zwiększenie o 15 wartości wiedzy przed rzutem na czar.\nMożliwe raz dziennie. Koszt 2PM"),
    SWEET_EYES(Proffesion.ADEPT, 2, "SŁODKIE OCZY", "zwiększenie o 15 wartości c przed rzutem na zdobycie informacji.\nMożliwe raz dziennie. Koszt 2PM"),
    INBORN_DEXTERITY(Proffesion.RASCAL, 0, "WRODZONA ZRĘCZNOŚĆ", "+20% przyrost oko, ręka, zwinność (co piąty punkt za darmo)"),
    BARELY(Proffesion.RASCAL, 1, "LEDWO, LEDWO", "Zmniejszenie o 5 wyniku po rzucie na trafienie.\nMożliwe raz dziennie. Koszt 2PM"),
    CLOSE_CALL(Proffesion.RASCAL, 2, "O MAŁY WŁOS", "Zmniejszenie o 5 wyniku po rzucie na unik. Możliwe raz dziennie. Koszt 2PM"),
    STRENGTH_ARGUMENT(Proffesion.BULLY, 0, "ARGUMENT SIŁY", "+20% przyrost siła, wytrzymałość, kondycja (co piąty punkt za darmo)"),
    LEFT_STRAIGHT(Proffesion.BULLY, 1, "LEWY PROSTY", "Cios z wolnej lewej reki za siła/20 + obr. tarczy przed właściwym uderzeniem.\nMożliwy raz dziennie. Koszt 2PM"),
    RIGHT_PUNCH(Proffesion.BULLY, 2, "PRAWY SIERPOWY", "Cios rękojeścią broni, możliwy po sparowaniu, zadaje 4 obr..\nMożliwy raz dziennie. Koszt 2PM"),

    SPELL_BUNCH(Proffesion.WIZARD, 0, "WIĄZANKA ZAKLĘĆ", "Drugi i kolejne czary z rzędu (inny) maja koszt PM zmniejszony o 20%."),
    MAGIC_INTUITION(Proffesion.WIZARD, 1, "MAGICZNA INTUICJA", "Możliwość rzucenia nieznanego czaru ze znanej szkoły i kręgu magii.\nMożliwe raz na 2 dni. Koszt 3PM."),
    WIZARD_POSTURE(Proffesion.WIZARD, 2, "POSTAWA CZARODZIEJA", "Możliwość przelania zwinności na wiedzę. Zwinność jest obniżona przez 3 s, wiedza zwiększona przez 1s.\nMożliwe raz na 2 dni. Koszt 3PM."),

    WAR_PATH(Proffesion.SOLDIER, 0, "DROGA WOJNY", "+2 do maks. akcji po potyczce. Do momentu snu."),
    ATTACK(Proffesion.SOLDIER, 1, "DO ATAKU!", "+30 do ręki przed ciosem wręcz.\nMożliwe raz na 2 dni. Koszt 5PM."),
    DEFEND(Proffesion.SOLDIER, 2, "BROŃ SIĘ!", "+30 do zwinności przed spodziewanym ciosem.\nMożliwe raz na 2 dni. Koszt 5PM."),
    OBSTINATION(Proffesion.FANATIC, 0, "ZAWZIĘTOŚĆ", "+1 obr. każdy następny cios z rzędu (tj. bez żadnej akcji pomiędzy)"),
    FOR_GODS(Proffesion.FANATIC, 1, "ZA BOGÓW!", "Zwalczenie przerażenia.\nMożliwe raz na 2 dni. Koszt 3PM"),
    FOR_FAITH(Proffesion.FANATIC, 2, "W IMIĘ WIARY!", "przerażenie przeciwnika.\nMożliwe raz na 2 dni. Koszt 3PM"),

    NEVERENDING_ROAD(Proffesion.MONK, 0, "NIEUSTANNA DROGA", "+30% tempo marszu, wizyta w świątyni przywraca maks. akcji"),
    PATIENCE(Proffesion.MONK, 1, "CIERPLIWOŚĆ", "Wyłączenie licznika akcji na czas walki po 2 sekundach skupienia.\nMożliwe raz na 3 dni. Koszt PM: 5."),
    MEDITATION(Proffesion.MONK, 2, "MEDYTACJA", "Zamiana punktów maks. akcji na PZ w tempie 1PZ/(s/h). Jakakolwiek akcja twoja/przeciw tobie przerywa.\nKoszt PM: 5. Możliwe raz na 3 dni.")
    ;

    private final Proffesion proffesion;
    private final int number; // 0 - passive; 1, 2 - active
    private final String namePL;
    private final String descriptionPL;

    Ability(Proffesion proffesion, int number, String namePL, String descriptionPL) {
        this.proffesion = proffesion;
        this.number = number;
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
    }

    public static Ability findAbility(Proffesion proffesion, int number) {
        final Optional<Ability> optionalAbility = Arrays.stream(Ability.values())
                .filter(ability -> ability.proffesion.equals(proffesion) && ability.number == number)
                .findFirst();
        return optionalAbility.orElse(null);
    }
}
