package model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Ability {
    CLEVER(Profession.ADEPT, 0, "POJĘTNY", "+20% przyrost wiedza, skupienie, charyzma (co piąty punkt za darmo)"),
    VEIN(Profession.ADEPT, 1, "WENA", "Zwiększenie o 15 wartości wiedzy przed rzutem na czar.\nMożliwe raz dziennie. Koszt 2PM"),
    SWEET_EYES(Profession.ADEPT, 2, "SŁODKIE OCZY", "Zwiększenie o 15 wartości charyzmy przed rzutem na zdobycie informacji.\nMożliwe raz dziennie. Koszt 2PM"),
    INBORN_DEXTERITY(Profession.RASCAL, 0, "WRODZONA ZRĘCZNOŚĆ", "+20% przyrost oko, ręka, zwinność (co piąty punkt za darmo)"),
    BARELY(Profession.RASCAL, 1, "LEDWO, LEDWO", "Zmniejszenie o 5 wyniku po rzucie na trafienie.\nMożliwe raz dziennie. Koszt 2PM"),
    CLOSE_CALL(Profession.RASCAL, 2, "O MAŁY WŁOS", "Zmniejszenie o 5 wyniku po rzucie na unik. Możliwe raz dziennie. Koszt 2PM"),
    STRENGTH_ARGUMENT(Profession.BULLY, 0, "ARGUMENT SIŁY", "+20% przyrost siła, wytrzymałość, kondycja (co piąty punkt za darmo)"),
    LEFT_STRAIGHT(Profession.BULLY, 1, "LEWY PROSTY", "Cios z wolnej lewej reki za siła/20 + obr. tarczy przed właściwym uderzeniem.\nMożliwy raz dziennie. Koszt 2PM"),
    RIGHT_PUNCH(Profession.BULLY, 2, "PRAWY SIERPOWY", "Cios rękojeścią broni, możliwy po sparowaniu, zadaje 4 obr..\nMożliwy raz dziennie. Koszt 2PM"),

    WARM_HANDS(Profession.HEALER, 0, "CIEPŁE DŁONIE", "+skupienie/10 do leczonych PZ. Medycyna: na dzień. Nie do regeneracji podczas snu."),
    SACRIFICE(Profession.HEALER, 1, "POŚWIĘCENIE", "Poświęcenie: Przelanie do 5 PZ w PM*3. Możliwe raz na 2 dni."),
    CURE(Profession.HEALER, 1, "KURACJA", "Walka z chorobą 4h, szansa = (skupienie + wiedza + wytrzymałość pacjenta) / 5 / (stopień choroby).\nKoszt PM: 3 Możliwe raz na 2 dni."),
    SPECIALIZATION(Profession.MASTER, 0, "SPECJALIZACJA", "Możliwość poznania jednego czaru wyższego kręgu  wybranej, znanej szkoły magii, częściowy wstęp do uniwersytetów"),
    FAST_READING(Profession.MASTER, 1, "SZYBKIE CZYTANIE", "Użycie zwoju bez zużycia go.\nMożliwe raz na 2 dni. Koszt 3PM."),
    CONNECTIONS(Profession.MASTER, 2, "ZNAJOMOŚCI", "Zwiększenie dyplomacji o 30 na 1h.\nMożliwe raz na 2 dni. Koszt 3PM."),
    SPELL_BUNCH(Profession.WIZARD, 0, "WIĄZANKA ZAKLĘĆ", "Drugi i kolejne czary z rzędu (inny) maja koszt PM zmniejszony o 20%."),
    MAGIC_INTUITION(Profession.WIZARD, 1, "MAGICZNA INTUICJA", "Możliwość rzucenia nieznanego czaru ze znanej szkoły i kręgu magii.\nMożliwe raz na 2 dni. Koszt 3PM."),
    WIZARD_POSTURE(Profession.WIZARD, 2, "POSTAWA CZARODZIEJA", "Możliwość przelania zwinności na wiedzę. Zwinność jest obniżona przez 3 s, wiedza zwiększona przez 1s.\nMożliwe raz na 2 dni. Koszt 3PM."),

    QUIET_WALK(Profession.SHADOW, 0, "CICHY CHÓD", "Pełna prędkość skradania"),
    WILL_HOLD_THIS(Profession.SHADOW, 1, "POTRZYMAM TO", "Po zakradnięciu do wroga mając wolną dłoń możesz odebrać mu broń z szansą ręka + siła – (siła wroga/2).\nMożliwe raz na 2 dni. Koszt 3PM."),
    FRONT_FLIP(Profession.SHADOW, 2, "PRZEWRÓT W PRZÓD", "Następny unik ustawi cię za wrogiem, jest 50% na danie ci 1s zaraz po nim.\nMożliwe raz na 2 dni. Koszt 3PM."),
    EYE_WINK(Profession.HUNTER, 0, "PRZYMKNIĘCIE OKA", "+skupienie/10 do traf. na dystans"),
    ARROW_IN_MOUTH(Profession.HUNTER, 1, "STRZAŁA W ZĘBACH", "Redukcja o 1s czasu przeładowania łuku/kuszy.\nMożliwe raz na 2 dni. Koszt 3PM."),
    BACK_FLIP(Profession.HUNTER, 2, "SALTO W TYŁ", "odskok przedłużony do 6m.\nMożliwe raz na 2 dni. Koszt 3PM."),
    WEIGHT_IN_GOLD(Profession.MERCENARY, 0, "WAGA W ZŁOCIE", "+25% złota za zadania"),
    WILL_PARRY_THIS(Profession.MERCENARY, 1, "SPARUJĘ I TO", "Dodatkowe 2 parowania. Możliwe raz na 2 dni. Koszt 3PM."),
    MARKED_STRIKE(Profession.MERCENARY, 2, "MARKOWANY CIOS", "Uniemożliwienie przeciwnikowi wykonania akcji obronnych przed wykonaniem ciosu.\nMożliwe raz na 2 dni. Koszt 3PM.\n"),

    WAR_PATH(Profession.SOLDIER, 0, "DROGA WOJNY", "+2 do maks. akcji po potyczce. Do momentu snu."),
    ATTACK(Profession.SOLDIER, 1, "DO ATAKU!", "+30 do ręki przed ciosem wręcz.\nMożliwe raz na 2 dni. Koszt 5PM."),
    DEFEND(Profession.SOLDIER, 2, "BROŃ SIĘ!", "+30 do zwinności przed spodziewanym ciosem.\nMożliwe raz na 2 dni. Koszt 5PM."),
    BORN_TO_FIGHT(Profession.WARRIOR, 0, "URODZONY BY WALCZYĆ", "+3 do wszystkich testÓw podczas walki"),
    KNOW_MY_POWER(Profession.WARRIOR, 1, "ZNAJ MĄ SIŁĘ", "dodanie +4 obr. przed ciosem wręcz. Możliwe raz na 2 dni. Koszt 3PM."),
    NO_BREAK(Profession.WARRIOR, 2, "NIE ZŁAMIESZ MNIE", "odjęcie 4 obr. od spodziewanego ciosu. Możliwe raz na 2 dni. Koszt 3PM."),
    OBSTINATION(Profession.FANATIC, 0, "ZAWZIĘTOŚĆ", "+1 obr. każdy następny cios z rzędu (tj. bez żadnej akcji pomiędzy)"),
    FOR_GODS(Profession.FANATIC, 1, "ZA BOGÓW!", "Zwalczenie przerażenia.\nMożliwe raz na 2 dni. Koszt 3PM"),
    FOR_FAITH(Profession.FANATIC, 2, "W IMIĘ WIARY!", "przerażenie przeciwnika.\nMożliwe raz na 2 dni. Koszt 3PM"),

    NEVERENDING_ROAD(Profession.MONK, 0, "NIEUSTANNA DROGA", "+30% tempo marszu, wizyta w świątyni przywraca maks. akcji"),
    PATIENCE(Profession.MONK, 1, "CIERPLIWOŚĆ", "Wyłączenie licznika akcji na czas walki po 2 sekundach skupienia.\nMożliwe raz na 3 dni. Koszt PM: 5."),
    MEDITATION(Profession.MONK, 2, "MEDYTACJA", "Zamiana punktów maks. akcji na PZ w tempie 1PZ/(s/h). Jakakolwiek akcja twoja/przeciw tobie przerywa.\nKoszt PM: 5. Możliwe raz na 3 dni.")
    ;

    private final Profession profession;
    private final int number; // 0 - passive; 1, 2 - active
    private final String namePL;
    private final String descriptionPL;

    Ability(Profession profession, int number, String namePL, String descriptionPL) {
        this.profession = profession;
        this.number = number;
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
    }

    public static Ability findAbility(Profession profession, int number) {
        final Optional<Ability> optionalAbility = Arrays.stream(Ability.values())
                .filter(ability -> ability.profession.equals(profession) && ability.number == number)
                .findFirst();
        return optionalAbility.orElse(null);
    }
}
