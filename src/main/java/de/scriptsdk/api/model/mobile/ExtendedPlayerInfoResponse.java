package de.scriptsdk.api.model.mobile;

import de.scriptsdk.api.enums.Race;
import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public final class ExtendedPlayerInfoResponse implements Deserializable {
    private Integer maxWeight = 0;
    private Race race = Race.HUMAN;
    private Integer statCap = 0;
    private Integer maximumPets = 0;
    private Integer currentPets = 0;
    private Integer currentFireResistance = 0;
    private Integer currentColdResistance = 0;
    private Integer currentPoisonResistance = 0;
    private Integer currentEnergyResistance = 0;
    private Integer maximumFireResistance = 0;
    private Integer maximumColdResistance = 0;
    private Integer maximumPoisonResistance = 0;
    private Integer maximumEnergyResistance = 0;
    private Integer tithingPoints = 0;
    private Integer luck = 0;
    private Integer minimumDamage = 0;
    private Integer maximumDamage = 0;
    private Integer maximumArmor = 0;
    private Integer defenseChance = 0;
    private Integer maximumDefenseChance = 0;
    private Integer hitChanceIncrease = 0;
    private Integer damageIncrease = 0;
    private Integer swingSpeedIncrease = 0;
    private Integer lowerReagentCost = 0;
    private Integer spellDamageIncrease = 0;
    private Integer fasterCastRecovery = 0;
    private Integer fasterCasting = 0;
    private Integer lowerManaCost = 0;
    private Integer hitPointRegeneration = 0;
    private Integer staminaRegeneration = 0;
    private Integer manaRegeneration = 0;
    private Integer reflectPhysicalDamage = 0;
    private Integer enhancePotions = 0;
    private Integer strengthIncrease = 0;
    private Integer dexterityIncrease = 0;
    private Integer intelligenceIncrease = 0;
    private Integer hitPointIncrease = 0;
    private Integer staminaIncrease = 0;
    private Integer manaIncrease = 0;

    @Override
    public void deserialize(PacketReader reader) {
        setMaxWeight(reader.readWord());
        setRace(Enumerable.valueOf(reader.readSmallInteger(), Race.class));
        setStatCap(reader.readWord());
        setCurrentPets(reader.readSmallInteger());
        setMaximumPets(reader.readSmallInteger());
        setCurrentFireResistance(reader.readWord());
        setCurrentColdResistance(reader.readWord());
        setCurrentPoisonResistance(reader.readWord());
        setCurrentEnergyResistance(reader.readWord());
        setLuck(reader.readSmallInteger());
        setMinimumDamage(reader.readWord());
        setMaximumDamage(reader.readWord());
        setTithingPoints(reader.readInteger());

        setMaximumArmor(reader.readWord());
        setMaximumFireResistance(reader.readWord());
        setMaximumColdResistance(reader.readWord());
        setMaximumPoisonResistance(reader.readWord());
        setMaximumEnergyResistance(reader.readWord());
        setDefenseChance(reader.readWord());
        setMaximumDefenseChance(reader.readWord());
        setHitChanceIncrease(reader.readWord());
        setDamageIncrease(reader.readWord());
        setSwingSpeedIncrease(reader.readWord());
        setLowerReagentCost(reader.readWord());
        setSpellDamageIncrease(reader.readWord());
        setFasterCastRecovery(reader.readWord());
        setFasterCasting(reader.readWord());
        setLowerManaCost(reader.readWord());
        setHitPointRegeneration(reader.readWord());
        setStaminaRegeneration(reader.readWord());
        setManaRegeneration(reader.readWord());
        setReflectPhysicalDamage(reader.readWord());
        setEnhancePotions(reader.readWord());
        setStrengthIncrease(reader.readWord());
        setDexterityIncrease(reader.readWord());
        setIntelligenceIncrease(reader.readWord());
        setHitPointIncrease(reader.readWord());
        setStaminaIncrease(reader.readWord());
        setManaIncrease(reader.readWord());
    }
}