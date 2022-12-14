package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum AbilityType implements Enumerable {
    NONE(0),
    MAGERY_SPELL(1),
    NECROMANCY_SPELL(2),
    CHIVALRY_SPELL(3),
    BUSHIDO_SPELL(4),
    NINJITSU_SPELL(5),
    SPELLWEAVING_SPELL(6),
    MYSTICISM_SPELL(7),
    PROVOCATION_SKILL_MASTERY(8),
    PEACEMAKING_SKILL_MASTERY(9),
    DISCORDANCE_SKILL_MASTERY(10),
    BUSHIDO_SKILL_MASTERY(11),
    MAGERY_SKILL_MASTERY(12),
    MYSTICISM_SKILL_MASTERY(13),
    NECROMANCY_SKILL_MASTERY(14),
    SPELLWEAVING_SKILL_MASTERY(15),
    CHIVALRY_SKILL_MASTERY(16),
    NINJITSU_SKILL_MASTERY(17),
    ARCHERY_SKILL_MASTERY(18),
    FENCING_SKILL_MASTERY(19),
    MACE_FIGHTING_SKILL_MASTERY(20),
    SWORDSMANSHIP_SKILL_MASTERY(21),
    PARRYING_SKILL_MASTERY(22),
    THROWING_SKILL_MASTERY(23),
    POISONING_SKILL_MASTERY(24),
    WRESTLING_SKILL_MASTERY(25),
    ANIMAL_TAMING_SKILL_MASTERY(26),
    SHARED_PASSIVES(27);

    private final Integer id;

    AbilityType(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
