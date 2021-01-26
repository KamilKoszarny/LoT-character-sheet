package model;

import lombok.Getter;
import model.items.ModifierType;

@Getter
public enum SkillType {
    STUNN("Ogłuszenie", "Możliwość ogłuszenia wroga na (sukcesy siła – wytrz./2 wroga) tur. Cios zada ¼ / ½ / ¾ normalnych obrażeń. \n" +
            "Wymaga: siła > 30 / 50 / 75", ModifierType.STUNN),
    CHARGE("Szarża", "Cios z dobiegu >2m zadaje dodatkowe obrażenia:\n" +
            "m(max 10) * (5 / 10 / 15) %. Odpycha 1m\n" +
            "Wymaga: k > 30 / 50 / 80, s > 20 / 40 / 60 ", ModifierType.CHARGE),
    FURY("Szał", "Szansa na zadanie + 1 / 2 / 3 ciosów \n" +
            "= (Sprawność + kondycja - skupienie) / 10. Zwinność = 0 na 1 s po.\n" +
            "Wymaga: s > 40 / 75 / 90\n", ModifierType.FURY),
    SWING("Zamach", "Cios zadający wrogom wokół \n" +
            "40 / 50 / 60% normalnych obrażeń\n" +
            "Wymaga: r > 30 / 45 / 60, k > 30 / 50 / 70", ModifierType.SWING),
    REGENERATION("Regeneracja", "+ 2 / 4 / (4 i 1/s 3s po otrzymaniu ciosu) PZ/sen, \n" +
            "1.5/2/2.5 * szansa na zanik choroby ciała\n" +
            "Wymaga: w > 35 / 55 / 80, s > 20 / 30 / 45", ModifierType.REGENERATION),
    STONE_SKIN("Kamienna skóra", "+ wytrzymałość / (10 / 5 / 3) odporności na magię i żywioły\n" +
            "Wymaga: w > 40 / 60 / 90", ModifierType.STONE_SKIN),
    WRATH("Gniew", "+ 2 / 4 / 6 do obrażeń gdy < 40% PZ\n" +
            "Wymaga: s > 20 / 45 / 70, w > 20 / 40 / 60", ModifierType.WRATH),
    SHIELDMAN("Tarczownik", "+ 5 / 10 / 15 p% na blok tarczą\n" +
            "+ 1 / 2 / 3 do obr. tarczy\n" +
            "Wymaga: z > 20 / 35 / 50, w > 40 / 60 / 80", ModifierType.SHIELDMAN),
    INTIMIDATE("Zastraszanie", "+ 15 / 30 / 40 zdobywanie informacji i dyplomacja\n" +
            "Wymaga: s > 20 / 45 / 60", ModifierType.INTIMIDATE),
    BLACKSMITHING("Kowalstwo", "Wytwarzanie i naprawa ekwipunku \u000BI / II / III poziom \n" +
            "Wymaga w > 20 / 40 / 60, s > 25 / 45 / 65 \n", ModifierType.BLACKSMITHING),

    MULTISHOT("Wielostrzał", "Strzał 2 / 2 / 3 pociskami z 60 / 75 / 60 % normalnych szans na trafienie każda. Jeśli różni przeciwnicy: -30.\n" +
            "Wymaga: o > 40 / 60 / 90", ModifierType.MULTISHOT),
    CRITICAL_STRIKE("Krytyczny cios", "Szansa na zadanie 1.5 / 2 / 2.5 x obr. \n" +
            "= (o + r) / 10\n" +
            "Wymaga: o > 30 / 55 / 80, r > 25 / 50 / 75", ModifierType.CRITICAL_STRIKE),
    RECOGNITION("Rozpoznanie", "Znajomość PZ i PM / atrybutów i statystyk / odporności wroga\n" +
            "Wymaga: o > 25 / 40 / 60, w > 20 / 40 / 60", ModifierType.RECOGNITION),
    KNOCK_OFF("Wytrącenie", "Cios wytrącający broń przeciwnika z szansą \n" +
            "= r  /  (4 / 3 / 2) – wytrącanie wroga na (sukcesy) m. Nie zadaje obrażeń.\n" +
            "Wymaga: r > 25 / 50 / 80, s > 20 / 40 / 60", ModifierType.KNOCK_OFF),
    TAMING("Oswajanie", "Możliwość oswojenia zwierzęcia. Skutki:\n" +
            "I: neutralne przez sukcesy z testu r + s s/h\n" +
            "II: kontrola przez sukcesy r + s – 5 sukc. lub I\n" +
            "III: wieczna kontrola jeśli 10 sukcesów r + s \n" +
            "Wymaga: r > 35 / 55 / 80, c > 20 / 40 / 65", ModifierType.TAMING),
    DODGE_MASTER("Mistrz uników", "Dodatkowe 1 / 2 / 3 uniki na ture\n" +
            "Wymaga: z > 35 / 60 / 85", ModifierType.DODGE_MASTER),
    HUNTER("Myśliwy", "+ 10 / 20 / 30 do tropienia i polowania\n" +
            "zbodywanie kośćca / skór / składników \n" +
            "Wymaga: o > 30 / 50 / 70, w > 20 / 35 / 50", ModifierType.HUNTER),
    CONTRA("Kontra", "Szansa = z/2 po uniku i  = r/2 po parowaniu.\n" +
            "na zadanie ¼ / 1/3 / ½ śr. obrażeń. \n" +
            "Wymaga: z > 40 / 60 / 80, s > 15 / 30 / 50", ModifierType.CONTRA),
    HORSEMEN("Jeździectwo", "+ 10 / 20 / 30 PZ konia, + 2 / 4 / 6 km/h, \n+ 2 / 3 / 4 m/s, kontrola podczas walki\n" +
            "Wymaga: z > 25 / 45 / 75, r > 15 / 30 / 50", ModifierType.HORSEMEN),
    ESCAPE("Ucieczka", "+ 2 / 4 / 6 m/s przy ucieczce, \n- 50% wroga na trafienie\n" +
            "Wymaga: z > 30 / 50 / 80, k > 15 / 30 / 55", ModifierType.ESCAPE),

    LIGHT_MAGIC("Magia światła", "I krąg, + 10% odp. choroby ciała i trucizny / \n" +
            "II krąg, + 25% obr. nieumarłym /\n" +
            "III krąg, + 3 PZ max\n" +
            "Wym. w > 25/50/75, s > 30/60/85, k > 15/30/45", ModifierType.LIGHT_MAGIC),
    DARK_MAGIC("Magia mroku", "I krąg, widzenie w ciemności /\n" +
            "II krąg, + 10 PM max, - 10 c  /\n" +
            "III krąg, cechy nieumarłego \n" +
            "Wymaga w > 30 / 60 / 90, w > 15 / 25 / 35", ModifierType.DARK_MAGIC),
    ELEMENTAL_MAGIC("Magia żywiołów", "I krąg, odp. na żywioły + 5 /\n" +
            "II krąg, rozpoznanie żywiołów /\n" +
            "III krąg, odp. na żywioły + 12 \n" +
            "Wym. w > 30/55/80, s > 20/40/60, o > 15/30/40", ModifierType.ELEMENTAL_MAGIC),
    CHANGE_MAGIC("Magia przemian", " I krąg, przewid. pogody (sukcesy w*3 h)/\n" +
            "II krąg, odp. na magie + 20 /\n" +
            "III krąg, +5 Punktów Szczęścia\n" +
            "Wymaga s > 30 / 60 / 90, z > 15 / 25 / 40", ModifierType.CHANGE_MAGIC),
    MAGIC_TALENT("Talent magiczny", "+ 3 / 6 / 9 PM/sen + 10 / 20 / 30 PM \n" +
            "Wymaga w > 25 / 50 / 75, s > 25 / 50 / 75 ", ModifierType.MAGIC_TALENT),
    ALCHEMY("Alchemia", "Wytwarzanie mikstur I / II / II poziom\n" +
            " Wymaga s > 30 / 50 / 80, o > 15 / 30 / 45", ModifierType.ALCHEMY),
    MEDICINE("Medycyna", "Leczenie lekkich/ciezkich/krytycznych ran .25/.5/1 PZ/h oraz chorob z w/(5/3/2) na dzien\n" +
            " Wymaga w > 30 / 50 / 80, c > 15 / 30 / 45", ModifierType.MEDICINE),
    ENGINEERING("Inżynieria", "Leczenie lekkich/ciężkich/krytycznych ran .25/.5/1 PZ/h oraz chorób z w/(5/3/2) na dzień\n" +
            " Wymaga w > 30 / 50 / 80, c > 15 / 30 / 45", ModifierType.ENGINEERING),
    TRADING("Targowanie", "Wytwarzanie i naprawa przedmiotów, pułapek, pojazdów itp. I / II / III poziom \n" +
            "Wymaga w > 25 / 45 / 70, r > 20 / 35 / 55", ModifierType.TRADING),
    PERSUASION("Perswazja", "+ 30 do sprzedaży, wycena zwykłych/ \n" +
            "+ 30 do zakupu, wycena magicznych, zwiększona dostępność / \n" +
            "+ 30 do usług, pelna wycena, zwiększona dostępność \n" +
            "Wymaga c > 25 / 50 / 75 ", ModifierType.PERSUASION);

    private final String namePL;
    private final String descriptionPL;
    private final ModifierType modifierType;

    SkillType(String namePL, String descriptionPL, ModifierType modifierType) {
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
        this.modifierType = modifierType;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
