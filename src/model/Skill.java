package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class Skill implements Serializable {

    private SkillType type;

    @Setter
    private int level;

    public Skill(SkillType type) {
        this.type = type;
        this.level = 1;
    }
}
