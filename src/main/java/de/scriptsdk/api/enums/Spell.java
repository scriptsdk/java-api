package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Spell implements Enumerable {
    NONE(0, "None", AbilityType.NONE),

    CLUMSY(1, "Clumsy", AbilityType.MAGERY_SPELL),
    CREATE_FOOD(2, "Create Food", AbilityType.MAGERY_SPELL),
    FEEBLEMIND(3, "Feeblemind", AbilityType.MAGERY_SPELL),
    HEAL(4, "Heal", AbilityType.MAGERY_SPELL),
    MAGIC_ARROW(5, "Magic Arrow", AbilityType.MAGERY_SPELL),
    NIGHT_SIGHT(6, "NightSight", AbilityType.MAGERY_SPELL),
    REACTIVE_ARMOR(7, "Reactive Armor", AbilityType.MAGERY_SPELL),
    WEAKEN(8, "Weaken", AbilityType.MAGERY_SPELL),
    AGILITY(9, "Agility", AbilityType.MAGERY_SPELL),
    CUNNING(10, "Cunning", AbilityType.MAGERY_SPELL),
    CURE(11, "Cure", AbilityType.MAGERY_SPELL),
    HARM(12, "Harm", AbilityType.MAGERY_SPELL),
    MAGIC_TRAP(13, "Magic Trap", AbilityType.MAGERY_SPELL),
    MAGIC_UNTRAP(14, "Magic Untrap", AbilityType.MAGERY_SPELL),
    PROTECTION(15, "Protection", AbilityType.MAGERY_SPELL),
    STRENGTH(16, "Strength", AbilityType.MAGERY_SPELL),
    BLESS(17, "Bless", AbilityType.MAGERY_SPELL),
    FIREBALL(18, "Fireball", AbilityType.MAGERY_SPELL),
    MAGIC_LOCK(19, "Magic Lock", AbilityType.MAGERY_SPELL),
    POISON(20, "Poison", AbilityType.MAGERY_SPELL),
    TELEKINESIS(21, "Telekinesis", AbilityType.MAGERY_SPELL),
    TELEPORT(22, "Teleport", AbilityType.MAGERY_SPELL),
    UNLOCK(23, "Unlock", AbilityType.MAGERY_SPELL),
    WALL_OF_STONE(24, "Wall Of Stone", AbilityType.MAGERY_SPELL),
    ARCH_CURE(25, "Arch Cure", AbilityType.MAGERY_SPELL),
    ARCH_PROTECTION(26, "Arch Protection", AbilityType.MAGERY_SPELL),
    CURSE(27, "Curse", AbilityType.MAGERY_SPELL),
    FIRE_FIELD(28, "Fire Field", AbilityType.MAGERY_SPELL),
    GREATER_HEAL(29, "Greater Heal", AbilityType.MAGERY_SPELL),
    LIGHTNING(30, "Lightning", AbilityType.MAGERY_SPELL),
    MANA_DRAIN(31, "Mana Drain", AbilityType.MAGERY_SPELL),
    RECALL(32, "Recall", AbilityType.MAGERY_SPELL),
    BLADE_SPIRIT(33, "Blade Spirit", AbilityType.MAGERY_SPELL),
    DISPEL_FIELD(34, "Dispel Field", AbilityType.MAGERY_SPELL),
    INCOGNITO(35, "Incognito", AbilityType.MAGERY_SPELL),
    MAGIC_REFLECTION(36, "MagicReflection", AbilityType.MAGERY_SPELL),
    MIND_BLAST(37, "Mind Blast", AbilityType.MAGERY_SPELL),
    PARALYZE(38, "Paralyze", AbilityType.MAGERY_SPELL),
    POISON_FIELD(39, "Poison Field", AbilityType.MAGERY_SPELL),
    SUMMON_CREATURE(40, "Summon Creature", AbilityType.MAGERY_SPELL),
    DISPEL(41, "Dispel", AbilityType.MAGERY_SPELL),
    ENERGY_BOLT(42, "Energy Bolt", AbilityType.MAGERY_SPELL),
    EXPLOSION(43, "Explosion", AbilityType.MAGERY_SPELL),
    INVISIBILITY(44, "Invisibility", AbilityType.MAGERY_SPELL),
    MARK(45, "Mark", AbilityType.MAGERY_SPELL),
    MASS_CURSE(46, "Mass Curse", AbilityType.MAGERY_SPELL),
    PARALYZE_FIELD(47, "Paralyze Field", AbilityType.MAGERY_SPELL),
    REVEAL(48, "Reveal", AbilityType.MAGERY_SPELL),
    CHAIN_LIGHTNING(49, "Chain Lightning", AbilityType.MAGERY_SPELL),
    ENERGY_FIELD(50, "Energy Field", AbilityType.MAGERY_SPELL),
    FLAME_STRIKE(51, "Flame Strike", AbilityType.MAGERY_SPELL),
    GATE_TRAVEL(52, "Gate Travel", AbilityType.MAGERY_SPELL),
    MANA_VAMPIRE(53, "Mana Vampire", AbilityType.MAGERY_SPELL),
    MASS_DISPEL(54, "Mass Dispel", AbilityType.MAGERY_SPELL),
    METEOR_SWARM(55, "Meteor Swarm", AbilityType.MAGERY_SPELL),
    POLYMORPH(56, "Polymorph", AbilityType.MAGERY_SPELL),
    EARTHQUAKE(57, "Earthquake", AbilityType.MAGERY_SPELL),
    ENERGY_VORTEX(58, "Energy Vortex", AbilityType.MAGERY_SPELL),
    RESURRECTION(59, "Resurrection", AbilityType.MAGERY_SPELL),
    SUMMON_AIR_ELEMENTAL(60, "Summon Air Elemental", AbilityType.MAGERY_SPELL),
    SUMMON_DAEMON(61, "Summon Daemon", AbilityType.MAGERY_SPELL),
    SUMMON_EARTH_ELEMENTAL(62, "Summon Earth Elemental", AbilityType.MAGERY_SPELL),
    SUMMON_FIRE_ELEMENTAL(63, "Summon Fire Elemental", AbilityType.MAGERY_SPELL),
    SUMMON_WATER_ELEMENTAL(64, "Summon Water Elemental", AbilityType.MAGERY_SPELL),

    ANIMATE_DEAD(101, "Animate Dead", AbilityType.NECROMANCY_SPELL),
    BLOOD_OATH(102, "Blood Oath", AbilityType.NECROMANCY_SPELL),
    CORPSE_SKIN(103, "Corpse Skin", AbilityType.NECROMANCY_SPELL),
    CURSE_WEAPON(104, "Curse Weapon", AbilityType.NECROMANCY_SPELL),
    EVIL_OMEN(105, "Evil Omen", AbilityType.NECROMANCY_SPELL),
    HORRIFIC_BEAST(106, "Horrific Beast", AbilityType.NECROMANCY_SPELL),
    LICH_FORM(107, "Lich Form", AbilityType.NECROMANCY_SPELL),
    MIND_ROT(108, "Mind Rot", AbilityType.NECROMANCY_SPELL),
    PAIN_SPIKE(109, "Pain Spike", AbilityType.NECROMANCY_SPELL),
    POISON_STRIKE(110, "Poison Strike", AbilityType.NECROMANCY_SPELL),
    STRANGLE(111, "Strangle", AbilityType.NECROMANCY_SPELL),
    SUMMON_FAMILIAR(112, "Summon Familiar", AbilityType.NECROMANCY_SPELL),
    VAMPIRIC_EMBRACE(113, "Vampiric Embrace", AbilityType.NECROMANCY_SPELL),
    VENGEFUL_SPIRIT(114, "Vengeful Spirit", AbilityType.NECROMANCY_SPELL),
    WITHER(115, "Wither", AbilityType.NECROMANCY_SPELL),
    WRAITH_FORM(116, "Wraith Form", AbilityType.NECROMANCY_SPELL),
    EXORCISM(117, "Exorcism", AbilityType.NECROMANCY_SPELL),

    CLEANSE_BY_FIRE(201, "Cleanse By Fire", AbilityType.CHIVALRY_SPELL),
    CLOSE_WOUNDS(202, "Close Wounds", AbilityType.CHIVALRY_SPELL),
    CONSECRATE_WEAPON(203, "Consecrate Weapon", AbilityType.CHIVALRY_SPELL),
    DISPEL_EVIL(204, "Dispel Evil", AbilityType.CHIVALRY_SPELL),
    DIVINE_FURY(205, "Divine Fury", AbilityType.CHIVALRY_SPELL),
    ENEMY_OF_ONE(206, "Enemy Of One", AbilityType.CHIVALRY_SPELL),
    HOLY_LIGHT(207, "Holy Light", AbilityType.CHIVALRY_SPELL),
    NOBLE_SACRIFICE(208, "Noble Sacrifice", AbilityType.CHIVALRY_SPELL),
    REMOVE_CURSE(209, "Remove Curse", AbilityType.CHIVALRY_SPELL),
    SACRED_JOURNEY(210, "Sacred Journey", AbilityType.CHIVALRY_SPELL),

    HONORABLE_EXECUTION(401, "Honorable Execution", AbilityType.BUSHIDO_SPELL),
    CONFIDENCE(402, "Confidence", AbilityType.BUSHIDO_SPELL),
    EVASION(403, "Evasion", AbilityType.BUSHIDO_SPELL),
    COUNTER_ATTACK(404, "Counter Attack", AbilityType.BUSHIDO_SPELL),
    LIGHTNING_STRIKE(405, "Lightning Strike", AbilityType.BUSHIDO_SPELL),
    MOMENTUM_STRIKE(406, "Momentum Strike", AbilityType.BUSHIDO_SPELL),

    FOCUS_ATTACK(501, "Focus Attack", AbilityType.NINJITSU_SPELL),
    DEATH_STRIKE(502, "Death Strike", AbilityType.NINJITSU_SPELL),
    ANIMAL_FORM(503, "Animal Form", AbilityType.NINJITSU_SPELL),
    KI_ATTACK(504, "Ki Attack", AbilityType.NINJITSU_SPELL),
    SURPRISE_ATTACK(505, "Surprise Attack", AbilityType.NINJITSU_SPELL),
    BACKSTAB(506, "Backstab", AbilityType.NINJITSU_SPELL),
    SHADOW_JUMP(507, "Shadow jump", AbilityType.NINJITSU_SPELL),
    MIRROR_IMAGE(508, "Mirror Image", AbilityType.NINJITSU_SPELL),

    ARCANE_CIRCLE(601, "Arcane Circle", AbilityType.SPELLWEAVING_SPELL),
    GIFT_OF_RENEWAL(602, "Gift Of Renewal", AbilityType.SPELLWEAVING_SPELL),
    IMMOLATING_WEAPON(603, "Immolating Weapon", AbilityType.SPELLWEAVING_SPELL),
    ATTUNEMENT(604, "Attunement", AbilityType.SPELLWEAVING_SPELL),
    THUNDERSTORM(605, "Thunderstorm", AbilityType.SPELLWEAVING_SPELL),
    NATURE_FURY(606, "Nature Fury", AbilityType.SPELLWEAVING_SPELL),
    SUMMON_FEY(607, "Summon Fey", AbilityType.SPELLWEAVING_SPELL),
    SUMMON_FIEND(608, "Summon Fiend", AbilityType.SPELLWEAVING_SPELL),
    REAPER_FORM(609, "Reaper Form", AbilityType.SPELLWEAVING_SPELL),
    WILDFIRE(610, "Wildfire", AbilityType.SPELLWEAVING_SPELL),
    ESSENCE_OF_WIND(611, "Essence Of Wind", AbilityType.SPELLWEAVING_SPELL),
    DRYAD_ALLURE(612, "Dryad Allure", AbilityType.SPELLWEAVING_SPELL),
    ETHEREAL_VOYAGE(613, "Ethereal Voyage", AbilityType.SPELLWEAVING_SPELL),
    WORD_OF_DEATH(614, "Word Of Death", AbilityType.SPELLWEAVING_SPELL),
    GIFT_OF_LIFE(615, "Gift Of Life", AbilityType.SPELLWEAVING_SPELL),
    ARCANE_EMPOWERMENT(616, "Arcane Empowerment", AbilityType.SPELLWEAVING_SPELL),

    NETHER_BOLT(678, "Nether Bolt", AbilityType.MYSTICISM_SPELL),
    HEALING_STONE(679, "Healing Stone", AbilityType.MYSTICISM_SPELL),
    PURE_MAGIC(680, "Pure Magic", AbilityType.MYSTICISM_SPELL),
    ENCHANT(681, "Enchant", AbilityType.MYSTICISM_SPELL),
    SLEEP(682, "Sleep", AbilityType.MYSTICISM_SPELL),
    EAGLE_STRIKE(683, "Eagle Strike", AbilityType.MYSTICISM_SPELL),
    ANIMATED_WEAPON(684, "Animated Weapon", AbilityType.MYSTICISM_SPELL),
    STONE_FORM(685, "Stone Form", AbilityType.MYSTICISM_SPELL),
    SPELL_TRIGGER(686, "Spell Trigger", AbilityType.MYSTICISM_SPELL),
    MASS_SLEEP(687, "Mass Sleep", AbilityType.MYSTICISM_SPELL),
    CLEANSING_WINDS(688, "Cleansing Winds", AbilityType.MYSTICISM_SPELL),
    BOMBARD(689, "Bombard", AbilityType.MYSTICISM_SPELL),
    SPELL_PLAGUE(690, "Spell Plague", AbilityType.MYSTICISM_SPELL),
    HAIL_STORM(691, "Hail Storm", AbilityType.MYSTICISM_SPELL),
    NETHER_CYCLONE(692, "Nether Cyclone", AbilityType.MYSTICISM_SPELL),
    RISING_COLOSSUS(693, "Rising Colossus", AbilityType.MYSTICISM_SPELL);

    private final AbilityType type;
    private final Integer id;
    private final String name;

    Spell(Integer id, String name, AbilityType type) {
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
