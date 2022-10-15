package de.scriptsdk.api.model.account;

import de.scriptsdk.api.enums.Gender;
import de.scriptsdk.api.enums.City;
import de.scriptsdk.api.enums.Race;
import de.scriptsdk.api.enums.SkillType;
import de.scriptsdk.core.interfaces.Serializable;
import de.scriptsdk.core.model.io.PacketWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CharacterCreationRequest implements Serializable {
    private String profileNam = "";
    private String shardName = "";
    private String charName = "";
    private Gender gender = Gender.FEMALE;
    private Race race = Race.HUMAN;
    private Integer strength = 0;
    private Integer dexterity = 0;
    private Integer intelligence = 0;
    private SkillType skillType1 = SkillType.ANATOMY;
    private SkillType skillType2 = SkillType.ANATOMY;
    private SkillType skillType3 = SkillType.ANATOMY;
    private SkillType skillType4 = SkillType.ANATOMY;
    private Double skillValue1 = 0.00;
    private Double skillValue2 = 0.00;
    private Double skillValue3 = 0.00;
    private Double skillValue4 = 0.00;
    private City city = City.NEW_HAVEN;
    private Integer slotIndex = 0;

    @Override
    public void serialize(PacketWriter writer) {

        writer.writeString(profileNam);
        writer.writeString(shardName);
        writer.writeString(charName);

        writer.writeBoolean(Objects.equals(gender, Gender.FEMALE));
        writer.writeSmallInteger(race.getId());

        writer.writeSmallInteger(strength);
        writer.writeSmallInteger(dexterity);
        writer.writeSmallInteger(intelligence);

        writer.writeString(skillType1.getName());
        writer.writeString(skillType2.getName());
        writer.writeString(skillType3.getName());
        writer.writeString(skillType4.getName());

        writer.writeInteger(skillValue1.intValue());
        writer.writeInteger(skillValue2.intValue());
        writer.writeInteger(skillValue3.intValue());
        writer.writeInteger(skillValue4.intValue());

        writer.writeSmallInteger(city.getId());

        writer.writeInteger(slotIndex);
    }
}
