package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Ability implements Enumerable {
    NONE(0, "None", AbilityType.NONE),

    INSPIRE(701, "Inspire", AbilityType.PROVOCATION_SKILL_MASTERY),
    INVIGORATE(702, "Invigorate", AbilityType.PROVOCATION_SKILL_MASTERY),

    RESILIENCE(703, "Resilience", AbilityType.PEACEMAKING_SKILL_MASTERY),
    PERSEVERANCE(704, "Perseverance", AbilityType.PEACEMAKING_SKILL_MASTERY),

    TRIBULATION(705, "Tribulation", AbilityType.DISCORDANCE_SKILL_MASTERY),
    DESPAIR(706, "Despair", AbilityType.DISCORDANCE_SKILL_MASTERY),

    DEATH_RAY(707, "DeathRay", AbilityType.MAGERY_SKILL_MASTERY),
    ETHEREAL_BURST(708, "Ethereal Burst", AbilityType.MAGERY_SKILL_MASTERY),

    NETHER_BLAST(709, "Nether Blast", AbilityType.MYSTICISM_SKILL_MASTERY),
    MYSTIC_WEAPON(710, "Mystic Weapon", AbilityType.MYSTICISM_SKILL_MASTERY),

    COMMAND_UNDEAD(711, "CommandUndead", AbilityType.NECROMANCY_SKILL_MASTERY),
    CONDUIT(712, "Conduit", AbilityType.NECROMANCY_SKILL_MASTERY),

    MANA_SHIELD(713, "ManaShield", AbilityType.SPELLWEAVING_SKILL_MASTERY),
    SUMMON_REAPER(714, "SummonReaper", AbilityType.SPELLWEAVING_SKILL_MASTERY),

    ANTICIPATE_HIT(716, "Anticipate Hit", AbilityType.BUSHIDO_SKILL_MASTERY),
    WARCRY(717, "Warcry", AbilityType.BUSHIDO_SKILL_MASTERY),

    REJUVENATE(719, "Rejuvenate", AbilityType.CHIVALRY_SKILL_MASTERY),
    HOLY_FIST(720, "Holy Fist", AbilityType.CHIVALRY_SKILL_MASTERY),

    SHADOW(721, "Shadow", AbilityType.NINJITSU_SKILL_MASTERY),
    WHITE_TIGER_FORM(722, "WhiteTigerForm", AbilityType.NINJITSU_SKILL_MASTERY),

    FLAMING_SHOT(723, "FlamingShot", AbilityType.ARCHERY_SKILL_MASTERY),
    PLAYING_THE_ODDS(724, "PlayingTheOdds", AbilityType.ARCHERY_SKILL_MASTERY),

    THRUST(725, "Thrust", AbilityType.FENCING_SKILL_MASTERY),
    PIERCE(726, "Pierce", AbilityType.FENCING_SKILL_MASTERY),

    STAGGER(727, "Stagger", AbilityType.MACE_FIGHTING_SKILL_MASTERY),
    TOUGHNESS(728, "Toughness", AbilityType.MACE_FIGHTING_SKILL_MASTERY),

    ONSLAUGHT(729, "Onslaught", AbilityType.SWORDSMANSHIP_SKILL_MASTERY),
    FOCUSED_EYE(730, "Focused Eye", AbilityType.SWORDSMANSHIP_SKILL_MASTERY),

    ELEMENTAL_FURY(731, "Elemental Fury", AbilityType.THROWING_SKILL_MASTERY),
    CALLED_SHOT(732, "Called Shot", AbilityType.THROWING_SKILL_MASTERY),

    SHIELD_BASH(734, "Shield Bash", AbilityType.PARRYING_SKILL_MASTERY),
    BODYGUARD(735, "Bodyguard", AbilityType.PARRYING_SKILL_MASTERY),
    HEIGHTEN_SENSES(736, "Heighten Senses", AbilityType.PARRYING_SKILL_MASTERY),

    TOLERANCE(737, "Tolerance", AbilityType.POISONING_SKILL_MASTERY),
    INJECTED_STRIKE(738, "Injected Strike", AbilityType.POISONING_SKILL_MASTERY),
    POTENCY(739, "Potency", AbilityType.POISONING_SKILL_MASTERY),

    RAMPAGE(740, "Rampage", AbilityType.WRESTLING_SKILL_MASTERY),
    FISTS_OF_FURY(741, "Fists Of Fury", AbilityType.WRESTLING_SKILL_MASTERY),
    KNOCKOUT(742, "Knockout", AbilityType.WRESTLING_SKILL_MASTERY),

    WHISPERING(743, "Whispering", AbilityType.ANIMAL_TAMING_SKILL_MASTERY),
    COMBAT_TRAINING(744, "Combat Training", AbilityType.ANIMAL_TAMING_SKILL_MASTERY),
    BOARDING(745, "Boarding", AbilityType.ANIMAL_TAMING_SKILL_MASTERY),

    ENCHANTED_SUMMONING(715, "Enchanted Summoning", AbilityType.SHARED_PASSIVES),
    INTUITION(718, "Intuition", AbilityType.SHARED_PASSIVES),
    WARRIORS_GIFTS(733, "Warriors Gifts", AbilityType.SHARED_PASSIVES);

    private final AbilityType type;
    private final Integer id;
    private final String name;

    Ability(Integer id, String name, AbilityType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public AbilityType getType() {
        return type;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
