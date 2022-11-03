package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum SkillType implements Enumerable {
    INVALID(-999, "Invalid"),
    ALCHEMY(0, "Alchemy"),
    ANATOMY(1, "Anatomy"),
    ANIMAL_LORE(2, "Animal Lore"),
    ITEM_IDENTITY(3, "Item Identification"),
    ARMS_LORE(4, "Arms Lore"),
    PARRY(5, "Parrying"),
    BEGGING(6, "Begging"),
    BLACKSMITH(7, "Blacksmithy"),
    FLETCHING(8, "Bowcraft/Fletching"),
    PEACEMAKING(9, "Peacemaking"),
    CAMPING(10, "Camping"),
    CARPENTRY(11, "Carpentry"),
    CARTOGRAPHY(12, "Cartography"),
    COOKING(13, "Cooking"),
    DETECT_HIDDEN(14, "Detecting Hidden"),
    DISCORDANCE(15, "Discordance"),
    EVALUATE_INTELLIGENCE(16, "Evaluating Intelligence"),
    HEALING(17, "Healing"),
    FISHING(18, "Fishing"),
    FORENSICS(19, "Forensic Evaluation"),
    HERDING(20, "Herding"),
    HIDING(21, "Hiding"),
    PROVOCATION(22, "Provocation"),
    INSCRIPTION(23, "Inscription"),
    LOCKPICKING(24, "Lockpicking"),
    MAGERY(25, "Magery"),
    MAGIC_RESIST(26, "Resisting Spells"),
    TACTICS(27, "Tactics"),
    SNOOPING(28, "Snooping"),
    MUSICIANSHIP(29, "Musicianship"),
    POISONING(30, "Poisoning"),
    ARCHERY(31, "Archery"),
    SPIRIT_SPEAK(32, "Spirit Speak"),
    STEALING(33, "Stealing"),
    TAILORING(34, "Tailoring"),
    ANIMAL_TAMING(35, "Animal Taming"),
    TASTE_IDENTITY(36, "Taste Identification"),
    TINKERING(37, "Tinkering"),
    TRACKING(38, "Tracking"),
    VETERINARY(39, "Veterinary"),
    SWORDMANSHIP(40, "Swordsmanship"),
    MACING(41, "Mace Fighting"),
    FENCING(42, "Fencing"),
    WRESTLING(43, "Wrestling"),
    LUMBERJACKING(44, "Lumberjacking"),
    MINING(45, "Mining"),
    MEDITATION(46, "Meditation"),
    STEALTH(47, "Stealth"),
    REMOVE_TRAP(48, "Remove Trap"),
    NECROMANCY(49, "Necromancy"),
    FOCUS(50, "Focus"),
    CHIVALRY(51, "Chivalry"),
    BUSHIDO(52, "Bushido"),
    NINJITSU(53, "Ninjitsu"),
    SPELLWEAVING(54, "Spellweaving"),
    MYSTICISM(55, "Mysticism"),
    IMBUING(56, "Imbuing"),
    THROWING(57, "Throwing");


    private final Integer id;
    private final String name;

    SkillType(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
