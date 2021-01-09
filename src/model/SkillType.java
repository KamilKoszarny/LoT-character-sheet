package model;

import lombok.Getter;

@Getter
public enum SkillType {
    STUNN("Ogłuszenie", "Możliwość ogłuszenia wroga na (sukcesy siła – wytrz./2 wroga) tur. Cios zada ¼ / ½ / ¾ normalnych obrażeń. \n" +
            "Wymaga: siła > 30 / 50 / 75"),
    CHARGE("Szarża"),
    FURY("Szał", "Szansa na zadanie + 1 / 2 / 3 ciosow \n" +
            "= (Sprawność + kondycja - skupienie) / 10. Zwinnosc = 0 na 1 s po.\n" +
            "Wymaga: s > 40 / 75 / 90\n"),
    SWING("Zamach"),
    REGENERATION("Regeneracja", "+ 2 / 4 / (4 i 1/s 3s po otrzymaniu ciosu) PZ/sen, \n" +
            "1.5/2/2.5 * szansa na zanik choroby ciała\n" +
            "Wymaga: w > 35 / 55 / 80, s > 20 / 30 / 45"),
    STONE_SKIN("Kamienna skóra", "+ wytrzymałość / (10 / 5 / 3) odporności na magię i żywioły\n" +
            "Wymaga: w > 40 / 60 / 90"),
    WRATH("Gniew", "+ 2 / 4 / 6 do obrażeń gdy < 40% PZ\n" +
            "Wymaga: s > 20 / 45 / 70, w > 20 / 40 / 60"),
    SHIELDMAN("Tarczownik"),
    INTIMIDATE("Zastraszanie"),
    BALCKSMITHING("Kowalstwo"),

    MULTISHOT("Wielostrzał"),
    CRITICAL_STRIKE("Krytyczny cios"),
    RECOGNITION("Rozpoznanie", "Znajomość PZ i PM / atrybutów i statystyk / odporności wroga\n" +
            "Wymaga: o > 25 / 40 / 60, w > 20 / 40 / 60"),
    KNOCK_OFF("Wytrącenie"),
    TAMING("Oswajanie"),
    DODGE_MASTER("Mistrz uników"),
    HUNTER("Myśliwy", "+ 10 / 20 / 30 do tropienia i polowania\n" +
            "zbodywanie kośćca / skór / składników \n" +
            "Wymaga: o > 30 / 50 / 70, w > 20 / 35 / 50"),
    CONTRA("Kontra"),
    HORSEMEN("Jeździectwo"),
    ESCAPE("Ucieczka"),

    LIGHT_MAGIC("Magia światła", "I krąg, + 20% odporności na choroby ciała i trucizny /\n" +
            "II krąg, + 30% obrażenia nieumarłym /\n" +
            "III krąg, + 3 PZ max\n" +
            "Wym. w > 25/50/75, s > 30/60/85, k > 15/30/45"),
    DARK_MAGIC("Magia mroku"),
    ELEMENTAL_MAGIC("Magia żywiołów", "I krąg, odp. na żywioły + 10 /\n" +
            "II krąg, rozpoznanie żywiołów /\n" +
            "III krąg, odp. na żywioły + 30 \n" +
            "Wym. w > 30/55/80, s > 20/40/60, o > 15/30/40"),
    CHANGE_MAGIC("Magia przemian"),
    MAGIC_TALENT("Talent magiczny", "+ 3 / 6 / 9 PM/sen + 10 / 20 / 30 PM \n" +
            "Wymaga w > 25 / 50 / 75, s > 25 / 50 / 75 "),
    ALCHEMY("Alchemia", "Wytwarzanie mikstur I / II / II poziom\n" +
            " Wymaga s > 30 / 50 / 80, o > 15 / 30 / 45"),
    MEDICINE("Medycyna", "Leczenie lekkich/ciezkich/krytycznych ran .25/.5/1 PZ/h oraz chorob z w/(5/3/2) na dzien\n" +
            " Wymaga w > 30 / 50 / 80, c > 15 / 30 / 45"),
    ENGINEERING("Inżynieria"),
    TRADING("Targowanie"),
    PERSUASION("Perswazja");

    private final String namePL;
    private final String descriptionPL;

    SkillType(String namePL) {
        this.namePL = namePL;
        this.descriptionPL = "descriptionPL";
    }

    SkillType(String namePL, String descriptionPL) {
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
