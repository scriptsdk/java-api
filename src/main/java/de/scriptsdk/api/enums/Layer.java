package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Layer implements Enumerable {

    INVALID(0x00),
    ONE_HANDED(0x01),
    TWO_HANDED(0x02),
    SHOES(0x03),
    PANTS(0x04),
    SHIRT(0x05),
    HELM(0x06),
    GLOVES(0x07),
    RING(0x08),
    TALISMAN(0x09),
    NECK(0x0A),
    HAIR(0x0B),
    WAIST(0x0C),
    INNER_TORSO(0x0D),
    BRACELET(0x0E),
    FACE(0x0F),
    FACIAL_HAIR(0x10),
    MIDDLE_TORSO(0x11),
    EARRINGS(0x12),
    ARMS(0x13),
    CLOAK(0x14),
    BACKPACK(0x15),
    OUTER_TORSO(0x16),
    OUTER_LEGS(0x17),
    INNER_LEGS(0x18),
    MOUNT(0x19),
    SHOP_BUY(0x1A),
    SHOP_RESALE(0x1B),
    SHOP_SELL(0x1C),
    BANK(0x1D),
    SECURE_TRADE(0x1F);

    private final Integer id;

    Layer(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
