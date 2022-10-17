package de.scriptsdk.api.model.network;

import de.scriptsdk.api.enums.*;
import de.scriptsdk.api.exceptions.api.ApiException;
import de.scriptsdk.api.interfaces.event.EventAction;
import de.scriptsdk.api.interfaces.event.ExtendedEventAction;
import de.scriptsdk.api.model.account.CharacterCreationRequest;
import de.scriptsdk.api.model.assets.*;
import de.scriptsdk.api.model.buffs.BuffIconResponse;
import de.scriptsdk.api.model.context.ContextMenuResponse;
import de.scriptsdk.api.model.event.*;
import de.scriptsdk.api.model.geometry.Point2DResponse;
import de.scriptsdk.api.model.geometry.Point3DRequest;
import de.scriptsdk.api.model.geometry.Point3DResponse;
import de.scriptsdk.api.model.geometry.QuestArrowResponse;
import de.scriptsdk.api.model.gump.components.GumpResponse;
import de.scriptsdk.api.model.handler.EventHandler;
import de.scriptsdk.api.model.menu.MenuResponseResponse;
import de.scriptsdk.api.model.mobile.ExtendedPlayerInfoResponse;
import de.scriptsdk.api.model.process.ProcessHelper;
import de.scriptsdk.api.model.properties.ClilocPropertyResponse;
import de.scriptsdk.api.model.system.ExtendedScriptInfoResponse;
import de.scriptsdk.api.model.system.StealthInfoResponse;
import de.scriptsdk.api.model.system.Version;
import de.scriptsdk.api.model.target.TargetInfoResponse;
import de.scriptsdk.core.enums.network.PacketType;
import de.scriptsdk.core.enums.network.ScriptState;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.model.generic.BaseList;
import de.scriptsdk.core.model.io.PacketReader;
import de.scriptsdk.core.model.io.PacketWriter;
import de.scriptsdk.core.model.network.PacketClient;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ApiClient {

    final PacketClient client;
    private final EventHandler handler;
    private Integer contextDelay;
    private Boolean targetHookIsEnabled;

    public ApiClient(String url, Integer port) {
        this.client = new PacketClient(url, port);

        this.setTargetHookIsEnabled(false);
        this.setContextDelay(0);
        this.handler = new EventHandler(this);
        client.setOnEventAction(handler::onEventAction);
    }

    public String getApiClientUrl() {
        return client.getUrl();
    }

    public Integer getApiClientPort() {
        return client.getPort();
    }

    public UUID getApiClientId() {
        return client.getId();
    }

    public ScriptState getApiClientScriptState() {
        return client.getState();
    }

    public Boolean isTargetHookIsEnabled() {
        return targetHookIsEnabled;
    }

    private void setTargetHookIsEnabled(Boolean targetHookIsEnabled) {
        this.targetHookIsEnabled = targetHookIsEnabled;
    }

    public void authenticate(LanguageType languageType, Version version) {
        if (Objects.equals(client.connect(), true)) {

            PacketWriter writer = new PacketWriter().
                    addSmallInteger(languageType.getId(), version.getMajor(),
                            version.getMinor(), version.getRevision(), version.getBuild());

            client.send(PacketType.LANG_VERSION, writer);
        }
    }

    public Boolean revokeAuthentication() {
        return client.disconnect();
    }

    public void confirmTrade(Integer tradeNumber) {
        PacketWriter writer = new PacketWriter().
                addSmallInteger(tradeNumber);

        client.send(PacketType.CONFIRM_TRADE, writer);
    }

    public Boolean cancelTrade(Integer tradeNumber) {
        PacketWriter writer = new PacketWriter().
                addSmallInteger(tradeNumber);

        return client.exchange(PacketType.CANCEL_TRADE, writer).readBoolean();
    }

    public Long getTradeOpponent(Integer tradeNumber) {
        PacketWriter writer = new PacketWriter().
                addSmallInteger(tradeNumber);

        return client.exchange(PacketType.GET_TRADE_OPPONENT, writer).readCardinal();
    }

    public Integer getTradeCount() {
        return client.exchange(PacketType.GET_TRADE_COUNT).readSmallInteger();
    }

    public String getTradeOpponentName(Integer tradeNumber) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(tradeNumber);

        return client.exchange(PacketType.GET_TRADE_OPPONENT_NAME, writer).readString();
    }

    public Boolean tradeCheck(Integer tradeNumber, Integer number) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(tradeNumber);
        writer.writeSmallInteger(number);

        return client.exchange(PacketType.TRADE_CHECK, writer).readBoolean();
    }

    public Boolean checkTradeState() {
        return client.exchange(PacketType.CHECK_TRADE_STATE).readBoolean();
    }

    public Long getTradeContainer(Integer tradeIndex, Integer number) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(tradeIndex);
        writer.writeSmallInteger(number);

        return client.exchange(PacketType.GET_TRADE_CONTAINER, writer).readCardinal();
    }

    public Integer getContextDelay() {
        return contextDelay;
    }

    public void setContextDelay(Integer contextDelay) {
        this.contextDelay = contextDelay;
    }

    public void requestContextMenu(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        client.send(PacketType.REQUEST_CONTEXT_MENU, writer);

    }

    public void setContextMenuHook(Long identity, Integer entryNumber) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);
        writer.writeSmallInteger(entryNumber);

        client.send(PacketType.SET_CONTEXT_MENU_HOOK, writer);
    }

    public BaseList<String> getContextMenuAsString() {
        return client.exchange(PacketType.GET_CONTEXT_MENU).
                readList(PacketReader::readString);
    }

    public void clearContextMenu() {
        client.send(PacketType.CLEAR_CONTEXT_MENU);
    }

    public ContextMenuResponse getContextMenuAsRecord() {
        return client.exchange(PacketType.GET_CONTEXT_MENU_REC).readObject(ContextMenuResponse.class);
    }

    public void waitForClient(Integer delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    public void changeStatLockState(StatKind statKind, LockState lockState) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(statKind.getId());
        writer.writeSmallInteger(lockState.getId());

        client.send(PacketType.CHANGE_STAT_LOCK_STATE, writer);
    }

    public LockState getStatLockState(StatKind statKind) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(statKind.getId());

        return Enumerable.valueOf(client.exchange(PacketType.
                GET_STAT_LOCK_STATE, writer).readSmallInteger(), LockState.class);
    }

    public Integer getStrength() {
        return client.exchange(PacketType.GET_SELF_STR).readInteger();
    }

    public Integer getIntelligence() {
        return client.exchange(PacketType.GET_SELF_INT).readInteger();
    }

    public Integer getDexterity() {
        return client.exchange(PacketType.GET_SELF_DEX).readInteger();
    }

    public Integer getHitPoints() {
        return client.exchange(PacketType.GET_SELF_LIFE).readInteger();
    }

    public Integer getMaxHitPoints() {
        return client.exchange(PacketType.GET_SELF_MAX_LIFE).readInteger();
    }

    public Integer getMana() {
        return client.exchange(PacketType.GET_SELF_MANA).readInteger();
    }

    public Integer getMaxMana() {
        return client.exchange(PacketType.GET_SELF_MAX_MANA).readInteger();
    }

    public Integer getStamina() {
        return client.exchange(PacketType.GET_SELF_STAMINA).readInteger();
    }

    public Integer getMaxStamina() {
        return client.exchange(PacketType.GET_SELF_MAX_STAMINA).readInteger();
    }

    public Integer getLuck() {
        return client.exchange(PacketType.GET_SELF_LUCK).readInteger();
    }

    public Integer getTotalStats() {
        return this.getStrength() + this.getDexterity() + this.getIntelligence();
    }

    public Integer getArmor() {
        return client.exchange(PacketType.GET_SELF_ARMOR).readInteger();
    }

    public Integer getWeight() {
        return client.exchange(PacketType.GET_SELF_WEIGHT).readInteger();
    }

    public ExtendedPlayerInfoResponse getExtendedInfo() {
        return client.exchange(PacketType.GET_EXT_INFO).readObject(ExtendedPlayerInfoResponse.class);
    }

    public void openDoor() {
        client.send(PacketType.OPEN_DOOR);
    }

    public void bow() {
        client.send(PacketType.BOW);
    }

    public void salute() {
        client.send(PacketType.SALUTE);
    }

    public Integer getX(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        return client.exchange(PacketType.GET_X, writer).readInteger();
    }

    public Integer getY(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        return client.exchange(PacketType.GET_Y, writer).readInteger();
    }

    public Layer getLayer(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return Enumerable.valueOf(client.exchange(PacketType.GET_LAYER, writer).readSmallInteger(), Layer.class);
    }

    public void requestStatus(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        client.send(PacketType.REQUEST_STATS, writer);
    }

    public Integer getZ(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        return client.exchange(PacketType.GET_Z, writer).readSmallInteger();
    }

    public String getTooltip(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_CLILOC,
                writer).readString();
    }

    public Integer getType(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_TYPE, writer).readWord();
    }

    public String getClilocByID(Long id) {
        PacketWriter writer = new PacketWriter().addCardinal(id);

        return client.exchange(PacketType.GET_CLILOC_BY_ID, writer).readString();

    }

    public BaseList<ClilocPropertyResponse> getProperties(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);


        return client.exchange(PacketType.GET_TOOL_TIP_REC, writer).
                readList(reader -> reader.readObject(ClilocPropertyResponse.class));
    }

    public Integer getPrice(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_PRICE, writer).readWord();
    }

    public Boolean isObjectExists(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);


        return client.exchange(PacketType.IS_OBJECT_EXISTS, writer).readBoolean();
    }

    public Direction getDirection(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return Enumerable.valueOf(client.exchange(PacketType.GET_DIRECTION, writer).readSmallInteger(), Direction.class);
    }

    public Integer getDistance(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_DISTANCE, writer).readWord();
    }

    public Integer getColor(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_COLOR, writer).readWord();
    }

    public Boolean isHidden(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);


        return client.exchange(PacketType.IS_HIDDEN, writer).readBoolean();
    }

    public Boolean isMovable(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);


        return client.exchange(PacketType.IS_MOVABLE, writer).readBoolean();
    }

    public Long getParent(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        return client.exchange(PacketType.GET_PARENT, writer).readCardinal();
    }

    public void useItemOnMobile(Long itemId, Long mobileId) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(itemId);
        writer.writeCardinal(mobileId);

        client.send(PacketType.USE_ITEM_ON_MOBILE, writer);
    }

    public Integer getQuantity(Long itemIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(itemIdentity);

        return client.exchange(PacketType.GET_QUANTITY, writer).readWord();
    }

    public Boolean isContainer(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        return client.exchange(PacketType.IS_CONTAINER, writer).readBoolean();
    }

    public void usePrimaryAbility() {
        client.send(PacketType.USE_PRIMARY_ABILITY);
    }

    public void useSecondaryAbility() {
        client.send(PacketType.USE_SECONDARY_ABILITY);
    }

    public String getActiveAbility() {
        return client.exchange(PacketType.GET_ACTIVE_ABILITY).readString();
    }

    public void toggleFly() {
        client.send(PacketType.TOGGLE_FLY);
    }

    public void useObject(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        client.send(PacketType.USE_OBJECT, writer);
    }

    public Long useType(Integer objectType, Integer objectColor) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);
        writer.writeWord(objectColor);

        return client.exchange(PacketType.USE_TYPE, writer).readCardinal();
    }

    public Long useFromGround(Integer objectType, Integer objectColor) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);
        writer.writeWord(objectColor);

        return client.exchange(PacketType.USE_FROM_GROUND, writer).readCardinal();
    }

    public void clickOnObject(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        client.send(PacketType.CLICK_ON_OBJECT, writer);
    }

    public void wearItem(Layer layer, Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(layer.getId());
        writer.writeCardinal(objectIdentity);

        client.send(PacketType.WEAR_ITEM, writer);
    }

    public Integer getDressSpeed() {
        return client.exchange(PacketType.GET_DRESS_SPEED).readWord();
    }

    public void setDressSpeed(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_DRESS_SPEED, writer);
    }

    public void setDress() {
        client.send(PacketType.SET_DRESS);
    }

    public void requestHelpGump() {
        client.send(PacketType.HELP_REQUEST);
    }

    public void requestQuestGump() {
        client.send(PacketType.QUEST_REQUEST);
    }

    public void requestVirtuesGump() {
        client.send(PacketType.REQ_VIRTUES_GUMP);
    }

    public void useVirtue(VirtueType virtue) {
        this.useVirtueById(virtue.getId());
    }

    public void useVirtueById(Integer virtueAsValue) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(virtueAsValue);

        client.send(PacketType.USE_VIRTUE, writer);
    }

    public QuestArrowResponse getQuestArrow() {
        return client.exchange(PacketType.GET_QUEST_ARROW).readCustom(reader ->
                reader.readObject(QuestArrowResponse.class));
    }

    public void castSpellById(Integer spellID) {
        PacketWriter writer = new PacketWriter();
        writer.writeInteger(spellID);
        client.send(PacketType.CAST_SPELL, writer);
    }

    public Boolean getOpenDoorThroughMovement() {
        return client.exchange(PacketType.GET_MOVE_OPEN_DOOR).readBoolean();
    }

    public void setOpenDoorThroughMovement(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_MOVE_OPEN_DOOR, writer);
    }

    public Integer getMovementThroughNPC() {
        return client.exchange(PacketType.GET_MOVE_THROUGH_NPC).readWord();
    }

    public void setMovementThroughNPC(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_MOVE_THROUGH_NPC, writer);
    }

    public Boolean getMovementThroughCorner() {
        return client.exchange(PacketType.GET_MOVE_THROUGH_CORNER).readBoolean();
    }

    public void setMovementThroughCorner(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_MOVE_THROUGH_CORNER, writer);
    }

    public Integer getMoveHeuristicMulti() {
        return client.exchange(PacketType.GET_MOVE_HEURISTIC_MULTI).readInteger();
    }

    public void setMoveHeuristicMulti(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(value);

        client.send(PacketType.SET_MOVE_HEURISTIC_MULTI, writer);
    }

    public Integer getMoveCheckStamina() {
        return client.exchange(PacketType.GET_MOVE_CHECK_STAMINA).readInteger();
    }

    public void setMoveCheckStamina(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_MOVE_CHECK_STAMINA, writer);
    }

    public Integer getMovementTurnCost() {
        return client.exchange(PacketType.GET_MOVE_TURN_COST).readInteger();
    }

    public void setMovementTurnCost(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(value);

        client.send(PacketType.SET_MOVE_TURN_COST, writer);
    }

    public Boolean getMovingBetweenTwoCorners() {
        return client.exchange(PacketType.GET_MOVE_BETWEEN_TWO_CORNERS).readBoolean();
    }

    public void setMovingBetweenTwoCorners(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_MOVE_BETWEEN_TWO_CORNERS, writer);
    }

    public Integer getPredictedX() {
        return client.exchange(PacketType.PREDICTED_X).readInteger();
    }

    public Integer getPredictedY() {
        return client.exchange(PacketType.PREDICTED_Y).readInteger();
    }

    public Integer getPredictedZ() {
        return client.exchange(PacketType.PREDICTED_Z).readInteger();
    }

    public Direction getPredictedDirection() {
        return Enumerable.valueOf(client.exchange(PacketType.PREDICTED_DIRECTION).readSmallInteger(), Direction.class);
    }

    public Integer getLastStepQUsedDoor() {
        return client.exchange(PacketType.GET_LAST_STEP_Q_USED_DOOR).readWord();
    }

    public BaseList<BuffIconResponse> getBuffBarInfo() {
        return client.exchange(PacketType.GET_BUFF_BAR_INFO).readList(reader ->
                reader.readObject(BuffIconResponse.class));
    }

    public Double getCurrentSkillValue(SkillType skillType) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());

        return client.exchange(PacketType.SKILL_CURRENT_VALUE, writer).readDouble();
    }

    public void useSkill(SkillType skillType) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());

        client.send(PacketType.USE_SKILL, writer);
    }

    public Double getSkillCap(SkillType skillType) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());

        return client.exchange(PacketType.GET_SKILL_CAP, writer).readDouble();
    }

    public Double getSkillValue(SkillType skillType) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());

        return client.exchange(PacketType.SKILL_VALUE, writer).readDouble();
    }

    public Boolean isActiveAbility(Ability ability) {
        return isActiveSpellOrAbilityById(ability.getId());
    }

    public Boolean isActiveSpellOrAbilityById(Integer id) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(id);

        return client.exchange(PacketType.IS_ACTIVE_SPELL_ABILITY, writer).readBoolean();
    }

    public void setUnmountTimer(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_RUN_UNMOUNT_TIMER, writer);
    }

    public Integer getRunMountTimer() {
        return client.exchange(PacketType.GET_RUN_MOUNT_TIMER).readInteger();
    }

    public void setRunMountTimer(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_RUN_MOUNT_TIMER, writer);
    }

    public Integer getWalkMountTimer() {
        return client.exchange(PacketType.GET_WALK_MOUNT_TIMER).readInteger();
    }

    public void setWalkMountTimer(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_WALK_MOUNT_TIMER, writer);
    }

    public Integer getRunUnmountTimer() {
        return client.exchange(PacketType.GET_RUN_UNMOUNT_TIMER).readInteger();
    }

    public Integer getWalkUnmountTimer() {
        return client.exchange(PacketType.GET_WALK_UNMOUNT_TIMER).readInteger();
    }

    public void setWalkUnmountTimer(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_WALK_UNMOUNT_TIMER, writer);
    }

    public Integer step(Direction direction, Boolean performAsRunner) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(direction.getId());
        writer.writeBoolean(performAsRunner);

        return client.exchange(PacketType.STEP, writer).readWord();
    }

    public Integer stepQ(Direction direction, Boolean performAsRunner) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(direction.getId());
        writer.writeBoolean(performAsRunner);

        return client.exchange(PacketType.STEP_Q, writer).readWord();
    }

    public void useBandageSelf() {
        client.send(PacketType.BANDAGE_SELF);
    }

    public LockState getSkillLockState(SkillType skillType) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());

        return Enumerable.valueOf(client.exchange(PacketType.
                GET_SKILL_LOCK_STATE, writer).readSmallInteger(), LockState.class);
    }

    public void equipLastWeapon() {
        client.send(PacketType.EQUIP_LAST_WEAPON);
    }

    public void setUnequipItemsMacro() {
        client.send(PacketType.UNEQUIP_ITEMS_SET_MACRO);
    }

    public void setEquipItemsMacro() {
        client.send(PacketType.EQUIP_ITEMS_SET_MACRO);
    }

    public Long useType(Integer objectType) {
        return useType(objectType, 0xFFFF);
    }

    public Boolean dragItem(Long itemID, Integer count) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(itemID);
        writer.writeInteger(count);

        return client.exchange(PacketType.DRAG_ITEM, writer).readBoolean();
    }

    public Boolean dropItem(Long moveIntoID, Integer x, Integer y, Integer z) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(moveIntoID);
        writer.writeInteger(x);
        writer.writeInteger(y);
        writer.writeInteger(z);


        return client.exchange(PacketType.DROP_ITEM, writer).readBoolean();
    }

    public Boolean moveXYZ(Integer x, Integer y, Integer z, Integer accuracyXY, Integer accuracyZ, Boolean performAsRunner) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeSmallInteger(z);
        writer.writeInteger(accuracyXY);
        writer.writeInteger(accuracyZ);
        writer.writeBoolean(performAsRunner);

        return client.exchange(PacketType.MOVE_XYZ, writer).readBoolean();
    }

    public Boolean moveXY(Integer x, Integer y, Boolean optimized, Integer accuracyXY, Boolean performAsRunner) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeBoolean(optimized);
        writer.writeInteger(accuracyXY);
        writer.writeBoolean(performAsRunner);

        return client.exchange(PacketType.MOVE_XY, writer).readBoolean();
    }

    public void setBadLocation(Integer x, Integer y) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);

        client.send(PacketType.SET_BAD_LOCATION, writer);
    }

    public void setGoodLocation(Integer x, Integer y) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);

        client.send(PacketType.SET_GOOD_LOCATION, writer);
    }

    public void clearBadLocationList() {
        client.send(PacketType.CLEAR_BAD_LOCATION_LIST);
    }

    public void setBadObject(Integer objectType, Integer objectColor, Integer radius) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);
        writer.writeWord(objectColor);
        writer.writeSmallInteger(radius);

        client.send(PacketType.SET_BAD_OBJECT, writer);
    }

    public void clearBadObjectList() {
        client.send(PacketType.CLEAR_BAD_OBJECT_LIST);
    }

    public Boolean checkLineOfSight(Point3DRequest from, Point3DRequest to,
                                    Facet facet,
                                    LineOfSightType losType, LineOfSightOption losOption) {

        if ((!Objects.equals(losOption, LineOfSightOption.NONE)) &&
                (Objects.equals(losOption.containsType(losType), false))) {
            throw new ApiException("LOS-Type %s not found in Option %s!",
                    losType.name(), losOption.name());
        }

        PacketWriter writer = new PacketWriter().addObject(from, to).addSmallInteger(facet.getId(), losType.getId()).
                addInteger(losOption.getId());

        return client.exchange(PacketType.CHECK_LOS, writer).readBoolean();
    }

    public BaseList<Point2DResponse> getPathArray(Integer destinationX, Integer destinationY,
                                                  Boolean optimizedMovement, Integer accuracy) {
        PacketWriter writer = new PacketWriter().addWord(destinationX, destinationY).
                addBoolean(optimizedMovement).addInteger(accuracy);

        return client.exchange(PacketType.GET_PATH_ARRAY, writer).readList(reader ->
                reader.readObject(Point2DResponse.class));
    }

    public BaseList<Point3DResponse> getPathArray3D(Point3DRequest from, Point3DRequest to,
                                                    Facet facet, Integer accuracyXY,
                                                    Integer accuracyZ, Boolean performAsRunner) {

        PacketWriter writer = new PacketWriter().addObject(from, to).addSmallInteger(facet.getId()).
                addInteger(accuracyXY, accuracyZ).addBoolean(performAsRunner);

        return client.exchange(PacketType.GET_PATH_ARRAY_3D, writer).readList(reader ->
                reader.readObject(Point3DResponse.class));
    }

    public Long getPickupItem() {
        return client.exchange(PacketType.GET_PICKUP_ITEM).readCardinal();
    }

    public void setPickupItem(Long itemIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(itemIdentity);

        client.send(PacketType.SET_PICKUP_ITEM, writer);
    }

    public Boolean getCoordinationCheckOnDrop() {
        return client.exchange(PacketType.GET_DROP_CHECK_COORDINATION).readBoolean();
    }

    public void setCoordinationCheckOnDrop(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_DROP_CHECK_COORDINATION, writer);
    }

    public Integer getDropDelay() {
        return client.exchange(PacketType.GET_DROP_DELAY).readInteger();
    }

    public void setDropDelay(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(value);

        client.send(PacketType.SET_DROP_DELAY, writer);
    }

    public void stopMover() {
        client.send(PacketType.MOVER_STOP);
    }

    public Integer getNextStepZ(Integer fromX, Integer fromY, Integer toX, Integer toY, Facet facet, Integer currentZ) {
        PacketWriter writer = new PacketWriter().addWord(fromX, fromY, toX, toY).
                addSmallInteger(facet.getId(), currentZ);

        return client.exchange(PacketType.GET_NEXT_STEP_Z, writer).readWord();
    }

    public Long getPlayerID() {
        return client.exchange(PacketType.GET_SELF_ID).readCardinal();
    }

    public String getName() {
        return client.exchange(PacketType.GET_CHAR_NAME).readString();
    }

    public Facet getFacet() {
        return Enumerable.valueOf(client.exchange(PacketType.GET_WORLD_NUM).readSmallInteger(), Facet.class);
    }

    public String getTitle() {
        return client.exchange(PacketType.GET_CHAR_TITLE).readString();
    }

    public Integer getGold() {
        return client.exchange(PacketType.GET_SELF_GOLD).readInteger();
    }

    public Integer getMaxWeight() {
        return client.exchange(PacketType.GET_SELF_MAX_WEIGHT).readInteger();
    }

    public Race getRace() {
        return Enumerable.valueOf(client.exchange(PacketType.GET_SELF_RACE).readSmallInteger(), Race.class);
    }

    public Integer getMaxPets() {
        return client.exchange(PacketType.GET_SELF_PETS_MAX).readInteger();
    }

    public Integer getPets() {
        return client.exchange(PacketType.GET_SELF_PETS_CURRENT).readInteger();
    }

    public Integer getFireResistence() {
        return client.exchange(PacketType.GET_SELF_FIRE_RESIST).readInteger();
    }

    public Integer getColdResistence() {
        return client.exchange(PacketType.GET_SELF_COLD_RESIST).readInteger();
    }

    public Integer getPoisonResistence() {
        return client.exchange(PacketType.GET_SELF_POISON_RESIST).readInteger();
    }

    public Integer getEnergyResistence() {
        return client.exchange(PacketType.GET_SELF_ENERGY_RESIST).readInteger();
    }

    public Long getLastContainer() {
        return client.exchange(PacketType.GET_LAST_CONTAINER).readCardinal();
    }

    public Long getLastTarget() {
        return client.exchange(PacketType.GET_LAST_TARGET).readCardinal();
    }

    public Long getLastAttacker() {
        return client.exchange(PacketType.GET_LAST_ATTACK).readCardinal();
    }

    public Long getLastStatus() {
        return client.exchange(PacketType.GET_LAST_STATUS).readCardinal();
    }

    public Long getLastObject() {
        return client.exchange(PacketType.GET_LAST_OBJECT).readCardinal();
    }

    public Long getBackpackID() {
        return client.exchange(PacketType.GET_BACKPACK_ID).readCardinal();
    }

    public Boolean isHidden() {
        return client.exchange(PacketType.GET_HIDDEN_STATUS).readBoolean();
    }

    public Boolean isPoisoned() {
        return client.exchange(PacketType.GET_POISONED_STATUS).readBoolean();
    }

    public Boolean isParalyzed() {
        return client.exchange(PacketType.GET_PARALYZED_STATUS).readBoolean();
    }

    public Boolean isDead() {
        return client.exchange(PacketType.GET_DEAD_STATUS).readBoolean();
    }

    public Long getCombatTarget() {
        return client.exchange(PacketType.GET_WAR_TARGET).readCardinal();
    }

    public void setCombatMode(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_WAR_MODE, writer);
    }

    public Boolean isImmortal() {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(this.getPlayerID());

        return client.exchange(PacketType.IS_YELLOW_HITS, writer).readBoolean();
    }

    public void attack(Long combatTarget) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(combatTarget);

        client.send(PacketType.ATTACK, writer);
    }

    public void usePaperdollScroll() {
        client.send(PacketType.USE_SELF_PAPERDOLL_SCROLL);

    }

    public void changeSkillLockState(SkillType skillType, LockState lockState) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(skillType.getId());
        writer.writeSmallInteger(lockState.getId());

        client.send(PacketType.CHANGE_SKILL_LOCK_STATE, writer);
    }

    public BaseList<LayerInfoResponse> getDressSet() {
        PacketReader reader = client.exchange(PacketType.GET_DRESS_SET);

        return reader.readList(reader1 -> reader1.readObject(LayerInfoResponse.class), reader.readInteger());
    }

    public Long findTypes(BaseList<Integer> objectTypeList, BaseList<Integer> objectColorList, BaseList<Long> containerIdList, Boolean scanRecursive) {
        PacketWriter writer = new PacketWriter();

        writer.writeList(objectTypeList, PacketWriter::writeWord);

        writer.writeList(objectColorList, PacketWriter::writeWord);

        writer.writeList(containerIdList, PacketWriter::writeCardinal);

        writer.writeBoolean(scanRecursive);

        return client.exchange(PacketType.FIND_TYPES_ARRAY_EX, writer).readCardinal();
    }

    public Integer getFindDistance() {
        return client.exchange(PacketType.GET_FIND_DISTANCE).readInteger();
    }

    public void setFindDistance(Integer distance) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(distance);

        client.send(PacketType.SET_FIND_DISTANCE, writer);
    }

    public Integer getFindVertical() {
        return client.exchange(PacketType.GET_FIND_VERTICAL).readInteger();
    }

    public void setFindVertical(Integer distance) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(distance);
        client.send(PacketType.SET_FIND_VERTICAL, writer);
    }

    public Long findType(Integer objectType, Integer objectColor, Long containerId, Boolean scanRecursive) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);
        writer.writeWord(objectColor);
        writer.writeCardinal(containerId);
        writer.writeBoolean(scanRecursive);

        return client.exchange(PacketType.FIND_TYPE_EX, writer).readCardinal();
    }

    public Long findNotoriety(Integer objectType, Notoriety notoriety) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);
        writer.writeSmallInteger(notoriety.getId());

        return client.exchange(PacketType.FIND_NOTORIETY, writer).readCardinal();
    }

    public Long findAtCoordination(Integer x, Integer y) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);
        return client.exchange(PacketType.FIND_AT_COORDINATION, writer).readCardinal();
    }

    public void ignore(Long objectId) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectId);

        client.send(PacketType.IGNORE, writer);
    }

    public void removeFromIgnoreList(Long objectId) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectId);

        client.send(PacketType.IGNORE_OFF, writer);
    }

    public void resetIgnoreList() {
        client.send(PacketType.IGNORE_RESET);
    }

    public BaseList<Long> getIgnoreList() {
        return client.exchange(PacketType.GET_IGNORE_LIST).readList(PacketReader::readCardinal);
    }

    public BaseList<Long> getFindList() {
        return client.exchange(PacketType.GET_FIND_LIST).readList(PacketReader::readCardinal);
    }

    public Boolean getFindInNullPointLocation() {
        return client.exchange(PacketType.GET_FIND_IN_NUL_POINT).readBoolean();
    }

    public void setFindInNullPointLocation(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_FIND_IN_NUL_POINT, writer);
    }

    public Long findType(Integer objectType, Integer objectColor, Long containerId) {
        return this.findType(objectType, objectColor, containerId, false);
    }

    public Long getFindItem() {
        return client.exchange(PacketType.GET_FIND_ITEM).readCardinal();
    }

    public Integer getFindCount() {
        return client.exchange(PacketType.GET_FIND_COUNT).readInteger();
    }

    public Integer getFindQuantity() {
        return client.exchange(PacketType.GET_FIND_QUANTITY).readInteger();
    }

    public Integer getFindTotalQuantity() {
        return client.exchange(PacketType.GET_FIND_FULL_QUANTITY).readInteger();
    }

    public void autoBuy(Integer itemType, Integer itemColor, Integer amount) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(itemType);
        writer.writeWord(itemColor);
        writer.writeWord(amount);

        client.send(PacketType.AUTO_BUY, writer);
    }

    public BaseList<String> getShopList() {
        PacketReader reader = client.exchange(PacketType.GET_SHOP_LIST);

        return reader.readList(PacketReader::readString, reader.readInteger());
    }

    public void clearShopList() {
        client.send(PacketType.CLEAR_SHOP_LIST);
    }

    public void autoBuyExtended(Integer itemType, Integer itemColor, Integer amount, Long price, String name) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(itemType);
        writer.writeInteger(itemColor);
        writer.writeInteger(amount);
        writer.writeCardinal(price);
        writer.writeString(name);

        client.send(PacketType.AUTO_BUY_EX, writer);
    }

    public Integer getAutoBuyDelay() {
        return client.exchange(PacketType.GET_AUTO_BUY_DELAY).readWord();
    }

    public void setAutoBuyDelay(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_AUTO_BUY_DELAY, writer);
    }

    public Integer getAutoSellDelay() {
        return client.exchange(PacketType.GET_AUTO_SELL_DELAY).readWord();
    }

    public void setAutoSellDelay(Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(value);

        client.send(PacketType.SET_AUTO_SELL_DELAY, writer);
    }

    public void autoSell(Integer itemType, Integer itemColor, Integer amount) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(itemType);
        writer.writeWord(itemColor);
        writer.writeWord(amount);

        client.send(PacketType.AUTO_SELL, writer);
    }

    public void joinGlobalChatChannel(String channelName) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(channelName);

        client.send(PacketType.GLOBAL_CHAT_JOIN_CHANNEL, writer);
    }

    public void leaveGlobalChatChannel() {
        client.send(PacketType.GLOBAL_CHAT_LEAVE_CHANNEL);
    }

    public void sendGlobalChannelChatMessage(String messageText) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(messageText);

        client.send(PacketType.GLOBAL_CHAT_SEND_MSG, writer);
    }

    public String getActiveGlobalChatChannel() {
        return client.exchange(PacketType.GLOBAL_CHAT_ACTIVE_CHANNEL).readString();
    }

    public BaseList<String> getGlobalChannelList() {
        return client.exchange(PacketType.GLOBAL_CHAT_CHANNELS_LIST).readList(PacketReader::readString);
    }

    public void clearChatUserIgnore() {
        client.send(PacketType.CLEAR_CHAT_USER_IGNORE);
    }

    public void addChatUserIgnore(String userName) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(userName);

        client.send(PacketType.ADD_CHAT_USER_IGNORE, writer);
    }

    public void clearGumpsIgnore() {
        client.send(PacketType.CLEAR_GUMPS_IGNORE);
    }

    public void waitGumpInt(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(index);

        client.send(PacketType.WAIT_GUMP_INT, writer);
    }

    public void waitGumpTextEntry(String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(value);

        client.send(PacketType.WAIT_GUMP_TEXT_ENTRY, writer);
    }

    public void gumpAutoTextEntry(Integer textEntryID, String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(textEntryID);
        writer.writeString(value);

        client.send(PacketType.GUMP_AUTO_TEXT_ENTRY, writer);
    }

    public void gumpAutoRadiobutton(Integer radioButtonID, Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(radioButtonID);
        writer.writeInteger(value);

        client.send(PacketType.GUMP_AUTO_RADIOBUTTON, writer);
    }

    public void gumpAutoCheckBox(Integer checkBoxID, Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(checkBoxID);
        writer.writeInteger(value);

        client.send(PacketType.GUMP_AUTO_CHECK_BOX, writer);
    }

    public Boolean clickGumpButton(Integer gumpIndex, Integer buttonID) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);
        writer.writeInteger(buttonID);

        return client.exchange(PacketType.NUM_GUMP_BUTTON, writer).readBoolean();
    }

    public Boolean editGumpTextEntry(Integer gumpIndex, Integer textEntryID, String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);
        writer.writeInteger(textEntryID);
        writer.writeString(value);

        return client.exchange(PacketType.NUM_GUMP_TEXT_ENTRY, writer).readBoolean();
    }

    public Boolean editGumpRadioButton(Integer gumpIndex, Integer radioButtonID, Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);
        writer.writeInteger(radioButtonID);
        writer.writeInteger(value);

        return client.exchange(PacketType.NUM_GUMP_RADIOBUTTON, writer).readBoolean();
    }

    public Boolean editGumpCheckBox(Integer gumpIndex, Integer checkBoxID, Integer value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);
        writer.writeInteger(checkBoxID);
        writer.writeInteger(value);

        return client.exchange(PacketType.NUM_GUMP_CHECK_BOX, writer).readBoolean();
    }

    public Integer getGumpsCount() {
        return client.exchange(PacketType.GET_GUMPS_COUNT).readInteger();
    }

    public void closeSimpleGump(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        client.send(PacketType.CLOSE_SIMPLE_GUMP, writer);
    }

    public Long getGumpSerial(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        return client.exchange(PacketType.GET_GUMP_SERIAL, writer).readCardinal();
    }

    public Long getGumpID(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        return client.exchange(PacketType.GET_GUMP_ID, writer).readCardinal();
    }

    public Boolean getGumpNoClose(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        return client.exchange(PacketType.GET_GUMP_NO_CLOSE, writer).readBoolean();
    }

    public BaseList<String> getGumpTextLines(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        PacketReader reader = client.exchange(PacketType.GET_GUMP_TEXT_LINES, writer);

        return reader.readList(PacketReader::readString);
    }

    public BaseList<String> getGumpFullLines(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        PacketReader reader = client.exchange(PacketType.GET_GUMP_FULL_LINES, writer);

        return reader.readList(PacketReader::readString, reader.readInteger());
    }

    public BaseList<String> getGumpShortLines(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        PacketReader reader = client.exchange(PacketType.GET_GUMP_SHORT_LINES, writer);

        return reader.readList(PacketReader::readString, reader.readInteger());
    }

    public BaseList<String> getGumpButtonsDescription(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        PacketReader reader = client.exchange(PacketType.GET_GUMP_BUTTONS_DESCRIPTION, writer);

        return reader.readList(PacketReader::readString, reader.readInteger());
    }

    public GumpResponse getGumpInfo(Integer gumpIndex) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(gumpIndex);

        return client.exchange(PacketType.GET_GUMP_INFO, writer).readObject(GumpResponse.class);
    }

    public void addGumpIgnoreByID(Long gumpID) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(gumpID);

        client.send(PacketType.ADD_GUMP_IGNORE_BY_ID, writer);

    }

    public void addGumpIgnoreBySerial(Long gumpSerial) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(gumpSerial);

        client.send(PacketType.ADD_GUMP_IGNORE_BY_SERIAL, writer);
    }

    public void closeClientGump(Integer gumpID) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(gumpID);

        client.send(PacketType.CLOSE_CLIENT_GUMP, writer);
    }

    public String getBookPageText(Integer page) {
        PacketWriter writer = new PacketWriter().
                addWord(page);

        return client.exchange(PacketType.BOOK_GET_PAGE_TEXT, writer).readString();
    }

    public void setBookText(String text) {
        PacketWriter writer = new PacketWriter().
                addString(text);

        client.send(PacketType.BOOK_SET_TEXT, writer);
    }

    public void setBookPageText(Integer page, String text) {
        PacketWriter writer = new PacketWriter().
                addWord(page).
                addString(text);

        client.send(PacketType.BOOK_SET_PAGE_TEXT, writer);
    }

    public void clearBookText() {
        client.send(PacketType.BOOK_CLEAR_TEXT);
    }

    public void setBookHeader(String title, String author) {
        PacketWriter writer = new PacketWriter().
                addString(title).
                addString(author);

        client.send(PacketType.BOOK_SET_HEADER, writer);
    }

    public String getProfileName() {
        return client.exchange(PacketType.GET_PROFILE_NAME).readString();
    }

    public Boolean isConnected() {
        return client.exchange(PacketType.GET_CONNECTED_STATUS).readBoolean();
    }

    public void addToSystemJournal(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.ADD_TO_SYSTEM_JOURNAL, writer);
    }

    public StealthInfoResponse getStealthInfo() {
        return client.exchange(PacketType.GET_STEALTH_INFO).readObject(StealthInfoResponse.class);
    }

    public Boolean getAutoReconnectMode() {
        return client.exchange(PacketType.GET_AR_STATUS).readBoolean();
    }

    public void setAutoReconnectMode(Boolean newState) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(newState);

        client.send(PacketType.SET_AR_STATUS, writer);
    }

    public Boolean getPauseOnDisconnectMode() {
        return client.exchange(PacketType.GET_PAUSE_SCRIPT_ON_DISCONNECT_STATUS).readBoolean();
    }

    public void setPauseOnDisconnectMode(Boolean newState) {

        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(newState);

        client.send(PacketType.SET_PAUSE_SCRIPT_ON_DISCONNECT_STATUS, writer);
    }

    public LocalDateTime getLastDisconnectTime() {
        return client.exchange(PacketType.GET_DISCONNECTED_TIME).readDateTime();
    }

    public LocalDateTime getLastConnectTime() {
        return client.exchange(PacketType.GET_CONNECTED_TIME).readDateTime();
    }

    public void connect() {
        client.send(PacketType.CONNECT);
    }

    public void disconnect() {
        client.send(PacketType.DISCONNECT);
    }

    public String getShardName() {
        return client.exchange(PacketType.GET_SHARD_NAME).readString();
    }

    public String getProxyIp() {
        return client.exchange(PacketType.GET_PROXY_IP).readString();
    }

    public Integer getProxyPort() {
        return client.exchange(PacketType.GET_PROXY_PORT).readInteger();
    }

    public Boolean isProxyMode() {
        return client.exchange(PacketType.GET_USE_PROXY).readBoolean();
    }

    public Integer changeProfile(String nextProfileName) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(nextProfileName);

        return client.exchange(PacketType.CHANGE_PROFILE, writer).readInteger();
    }

    public void startCheckLag() {
        client.send(PacketType.CHECK_LAG_BEGIN);
    }

    public void stopCheckLag() {
        client.send(PacketType.CHECK_LAG_END);
    }

    public Boolean isCheckLagStopped() {
        return client.exchange(PacketType.IS_CHECK_LAG_END).readBoolean();
    }

    public Boolean getSilentMode() {
        return client.exchange(PacketType.GET_SILENT_MODE).readBoolean();
    }

    public void setSilentMode(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.SET_SILENT_MODE, writer);
    }

    public void fillNewWindow(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.FILL_NEW_WINDOW, writer);
    }

    public String getStealthPath() {
        return client.exchange(PacketType.GET_STEALTH_PATH).readString();
    }

    public String getStealthProfilePath() {
        return client.exchange(PacketType.GET_STEALTH_PROFILE_PATH).readString();
    }

    public String getShardPath() {
        return client.exchange(PacketType.GET_SHARD_PATH).readString();
    }

    public void sendTextToUO(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.SEND_TEXT_TO_UO, writer);
    }

    public void sendTextToUOColor(String text, Integer color) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);
        writer.writeWord(color);

        client.send(PacketType.SEND_TEXT_TO_UO_COLOR, writer);
    }

    public void setGlobalVariable(VarRegion region, String keyName, String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(region.getId());
        writer.writeString(keyName);
        writer.writeString(value);

        client.send(PacketType.SET_GLOBAL, writer);
    }

    public String getGlobalVariable(VarRegion region, String keyName) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(region.getId());
        writer.writeString(keyName);

        return client.exchange(PacketType.GET_GLOBAL, writer).readString();
    }

    public void replyToConsoleEntry(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.CONSOLE_ENTRY_REPLY, writer);

    }

    public void setAlarm() {
        client.send(PacketType.SET_ALARM);
    }

    public void printToClient(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.CLIENT_PRINT, writer);
    }

    public void printToClient(Long sender, Integer color, Integer font, String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(sender);
        writer.writeWord(color);
        writer.writeWord(font);
        writer.writeString(text);

        client.send(PacketType.CLIENT_PRINT_EX, writer);
    }

    public void closeClientUIWindow(UIWindowType uiWindowType, Long id) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(uiWindowType.getId());
        writer.writeCardinal(id);

        client.send(PacketType.CLOSE_CLIENT_UI_WINDOW, writer);
    }

    public void requestClientObjectTarget() {
        client.send(PacketType.CLIENT_REQUEST_OBJECT_TARGET);
    }

    public void requestClientTileTarget() {
        client.send(PacketType.CLIENT_REQUEST_TILE_TARGET);
    }

    public Boolean isClientTargetResponsePresent() {
        return client.exchange(PacketType.CLIENT_TARGET_RESPONSE_PRESENT).readBoolean();
    }

    public TargetInfoResponse getClientTargetResponse() {
        return client.exchange(PacketType.CLIENT_TARGET_RESPONSE).readObject(TargetInfoResponse.class);
    }

    public LocalDateTime getStealthDateTimeUnixNow() {
        return client.exchange(PacketType.GET_NOW_UNIX).readDateTime();
    }

    public LocalDateTime getStealthDateTimeNow() {
        return client.exchange(PacketType.GET_NOW).readDateTime();
    }

    public Integer getScriptCount() {
        return client.exchange(PacketType.GET_SCRIPTS_COUNT).readInteger();
    }

    public String getScriptPath(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);

        return client.exchange(PacketType.GET_SCRIPT_PATH, writer).readString();
    }

    public ScriptState getScriptState(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);

        return Enumerable.valueOf(client.exchange(PacketType.GET_SCRIPT_STATE, writer).readSmallInteger(), ScriptState.class);
    }

    public Integer startScript(String scriptPath) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(scriptPath);

        return client.exchange(PacketType.START_SCRIPT, writer).readWord();
    }

    public void stopScript(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);

        client.send(PacketType.STOP_SCRIPT, writer);
    }

    public void pauseOrResumeSelectedScript(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);

        client.send(PacketType.PAUSE_RESUME_SEL_SCRIPT, writer);
    }

    public void stopAllScripts() {
        client.send(PacketType.STOP_ALL_SCRIPTS);
    }

    public void setScriptName(Integer index, String scriptName) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);
        writer.writeString(scriptName);

        client.send(PacketType.SET_SCRIPT_NAME, writer);
    }

    public String getScriptName(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);

        return client.exchange(PacketType.GET_SCRIPT_NAME, writer).readString();
    }

    public ExtendedScriptInfoResponse getScriptParameter() {
        return client.exchange(PacketType.GET_SCRIPT_PARAMS).
                readObject(ExtendedScriptInfoResponse.class);
    }

    public void clearSystemJournal() {
        client.send(PacketType.CLEAR_SYSTEM_JOURNAL);
    }

    public void clearInfoWindow() {
        client.send(PacketType.CLEAR_INFO_WINDOW);
    }

    public Integer changeProfile(String profileName, String shardName, String charName) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(profileName);
        writer.writeString(shardName);
        writer.writeString(charName);

        return client.exchange(PacketType.CHANGE_PROFILE_EX, writer).readWord();
    }

    public void setAutoReconnectParameter(String shardName, String charName, Boolean useItAtEveryReconnect) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(shardName);
        writer.writeString(charName);
        writer.writeBoolean(useItAtEveryReconnect);

        client.send(PacketType.SET_AR_EXT_PARAMS, writer);
    }

    public String getGameServerIP() {
        return client.exchange(PacketType.GAME_SERVER_IP_STRING).readString();
    }

    public String getProfileShardName() {
        return client.exchange(PacketType.GET_PROFILE_SHARD_NAME).readString();
    }

    public Integer getClientVersionAsInteger() {
        return client.exchange(PacketType.GET_CLIENT_VERSION_INT).readInteger();
    }

    public void dumbObjectsCache() {
        client.send(PacketType.DUMP_OBJECTS_CACHE);
    }

    public void hideClient(Long pid) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(pid);

        client.send(PacketType.CLIENT_HIDE, writer);
    }

    public void replyToConsoleEntryAsUnicode(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        client.send(PacketType.CONSOLE_ENTRY_UNICODE_REPLY, writer);
    }

    public void createCharacter(CharacterCreationRequest creation) {
        PacketWriter writer = new PacketWriter();

        writer.writeObject(creation);

        client.send(PacketType.CREATE_CHAR, writer);
    }

    public Boolean getShowIPCExceptionWindow() {
        return client.exchange(PacketType.GET_SHOW_IPC_EXCEPTION_WINDOW).readBoolean();
    }

    public void setShowIPCExceptionWindow(Boolean state) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(state);

        client.send(PacketType.SET_SHOW_IPC_EXCEPTION_WINDOW, writer);

    }

    private void clearEventProcedure(EventType eventType) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(eventType.getId());

        client.send(PacketType.CLEAR_EVENT_PROC, writer);
        handler.unsubscribe(eventType);
    }

    private void setEventProcedure(EventType eventType) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(eventType.getId());
        client.send(PacketType.SET_EVENT_PROC, writer);
    }

    public Integer getFoundParamID() {
        return client.exchange(PacketType.GET_FOUNDED_PARAM_ID).readInteger();
    }

    public Long getJournalLineID() {
        return client.exchange(PacketType.GET_LINE_ID).readCardinal();
    }

    public Integer getJournalLineType() {
        return client.exchange(PacketType.GET_LINE_TYPE).readInteger();
    }

    public LocalDateTime getJournalLineTime() {
        return client.exchange(PacketType.GET_LINE_TIME).readDateTime();
    }

    public Integer getJournalMessageLineType() {
        return client.exchange(PacketType.GET_LINE_MSG_TYPE).readInteger();
    }

    public Integer getJournalLineColor() {
        return client.exchange(PacketType.GET_LINE_TEXT_COLOR).readInteger();
    }

    public Integer getJournalLineFont() {
        return client.exchange(PacketType.GET_LINE_TEXT_FONT).readInteger();
    }

    public Integer getJournalLineIndex() {
        return client.exchange(PacketType.GET_LINE_INDEX).readInteger();
    }

    public Integer getJournalLineCount() {
        return client.exchange(PacketType.GET_LINE_COUNT).readInteger();
    }

    public String getJournalLineName() {
        return client.exchange(PacketType.GET_LINE_NAME).readString();
    }

    public Integer isInJournal(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);

        return client.exchange(PacketType.IN_JOURNAL, writer).readWord();
    }

    public void addJournalIgnore(String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(value);

        client.send(PacketType.ADD_JOURNAL_IGNORE, writer);
    }


    public void clearJournal() {
        client.send(PacketType.CLEAR_JOURNAL);
    }

    public String getLastJournalMessage() {
        return client.exchange(PacketType.LAST_JOURNAL_MESSAGE).readString();
    }

    public Integer inJournal(String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(value);

        return client.exchange(PacketType.IN_JOURNAL, writer).readWord();
    }

    public Integer inJournalBetweenTime(String value, LocalDateTime start, LocalDateTime end) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(value);
        writer.writeDateTime(start);
        writer.writeDateTime(end);

        return client.exchange(PacketType.IN_JOURNAL_BETWEEN_TIMES, writer).readWord();
    }

    public String journal(Integer index) {
        PacketWriter writer = new PacketWriter();

        writer.writeInteger(index);

        return client.exchange(PacketType.JOURNAL, writer).readString();
    }

    public void setJournalLine(Integer index, String value) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(index);
        writer.writeString(value);

        client.send(PacketType.SET_JOURNAL_LINE, writer);
    }

    public Integer getLowJournal() {
        return client.exchange(PacketType.LOW_JOURNAL).readInteger();
    }

    public Integer getHighJournal() {
        return client.exchange(PacketType.HIGH_JOURNAL).readInteger();
    }

    public void addToJournal(String text) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(text);
        client.send(PacketType.ADD_TO_JOURNAL, writer);
    }

    public void clearJournalIgnore() {
        client.send(PacketType.CLEAR_JOURNAL_IGNORE);
    }


    public void setCatchBag(Long objectIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectIdentity);

        client.send(PacketType.SET_CATCH_BAG, writer);
    }

    public void unsetCatchBag() {
        client.send(PacketType.UNSET_CATCH_BAG);
    }

    public void waitMenu(String menuCaption, String elementCaption) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(menuCaption);
        writer.writeString(elementCaption);

        client.send(PacketType.WAIT_MENU, writer);
    }

    public void autoMenu(String menuCaption, String elementCaption) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(menuCaption);
        writer.writeString(elementCaption);

        client.send(PacketType.AUTO_MENU, writer);
    }

    public Boolean menuHookPresent() {
        return client.exchange(PacketType.MENU_HOOK_PRESENT).readBoolean();
    }

    public Boolean menuPresent() {
        return client.exchange(PacketType.MENU_PRESENT).readBoolean();
    }

    public void cancelMenu() {
        client.send(PacketType.CANCEL_MENU);
    }

    public void closeMenu() {
        client.send(PacketType.CLOSE_MENU);
    }

    public BaseList<String> getLastMenuItems() {
        return client.exchange(PacketType.GET_LAST_MENU_ITEMS).readList(PacketReader::readString);
    }

    public BaseList<String> getMenuItemsAsString(String menuCaption) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(menuCaption);

        return client.exchange(PacketType.GET_MENU_ITEMS, writer).readList(PacketReader::readString);
    }

    public BaseList<MenuResponseResponse> getMenuItems(String menuCaption) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(menuCaption);

        return client.exchange(PacketType.GET_MENU_ITEMS_EX, writer).
                readList(reader -> reader.readObject(MenuResponseResponse.class));
    }

    public Gender getGender(Long identity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(identity);

        return Objects.equals(client.exchange(PacketType.
                IS_FEMALE, writer).readBoolean(), true) ?
                Gender.FEMALE : Gender.MALE;
    }

    public Gender getGender() {
        return Objects.equals(client.exchange(PacketType.
                GET_SELF_SEX).readBoolean(), true) ?
                Gender.FEMALE : Gender.MALE;
    }

    public void usePaperdollScroll(Long mobileTarget) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileTarget);

        client.send(PacketType.USE_OTHER_PAPERDOLL_SCROLL, writer);
    }

    public Long getObjectAtLayer(Layer layer, Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeSmallInteger(layer.getId());
        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.OBJ_AT_LAYER_EX, writer).readCardinal();
    }

    public void renameMobile(Long mobIdentity, String name) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobIdentity);
        writer.writeString(name);
        client.send(PacketType.RENAME_MOBILE, writer);
    }

    public Boolean mobileCanBeRenamed(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.MOBILE_CAN_BE_RENAMED, writer).readBoolean();
    }

    public String getName(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_NAME, writer).readString();
    }

    public String getAlternativeName(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_ALT_NAME, writer).readString();
    }

    public String getTitle(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_TITLE, writer).readString();
    }

    public Integer getStrength(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_STR, writer).readWord();
    }

    public Integer getIntelligence(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_INT, writer).readWord();
    }

    public Integer getDexterity(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_DEX, writer).readWord();
    }

    public Integer getHitPoints(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_HP, writer).readWord();
    }

    public Integer getMaxHitPoints(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_MAX_HP, writer).readWord();
    }

    public Integer getMana(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_MANA, writer).readWord();
    }

    public Integer getMaxMana(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_MAX_MANA, writer).readWord();
    }

    public Integer getStamina(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_STAMINA, writer).readWord();
    }

    public Integer getMaxStamina(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.GET_MAX_STAMINA, writer).readWord();
    }

    public Notoriety getNotoriety(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return Enumerable.valueOf(client.exchange(PacketType.
                GET_NOTORIETY, writer).readSmallInteger(), Notoriety.class);
    }

    public Boolean isInCombatMode(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_WAR_MODE, writer).readBoolean();
    }

    public Boolean isNPC(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_NPC, writer).readBoolean();
    }

    public Boolean isDead(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_DEAD, writer).readBoolean();
    }

    public Boolean isRunning(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_RUNNING, writer).readBoolean();
    }

    public Boolean isImmortal(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_YELLOW_HITS, writer).readBoolean();
    }

    public Boolean isPoisoned(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_POISONED, writer).readBoolean();
    }

    public Boolean isParalyzed(Long mobileIdentity) {
        PacketWriter writer = new PacketWriter().
                addCardinal(mobileIdentity);

        return client.exchange(PacketType.IS_PARALYZED, writer).readBoolean();
    }

    public void inviteToParty(Long partyMember) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(partyMember);

        client.send(PacketType.INVITE_TO_PARTY, writer);
    }

    public void removeFromParty(Long partyMember) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(partyMember);

        client.send(PacketType.REMOVE_FROM_PARTY, writer);
    }

    public void sayToPartyMember(Long partyMember, String message) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(partyMember);
        writer.writeString(message);

        client.send(PacketType.PARTY_MESSAGE_TO, writer);
    }


    public void sayToParty(String message) {
        PacketWriter writer = new PacketWriter();

        writer.writeString(message);

        client.send(PacketType.PARTY_SAY, writer);
    }

    public void canPartyLootMe(Boolean value) {
        PacketWriter writer = new PacketWriter();

        writer.writeBoolean(value);

        client.send(PacketType.PARTY_CAN_LOOT_ME, writer);
    }

    public void acceptPartyInvitation() {
        client.send(PacketType.PARTY_ACCEPT_INVITE);
    }

    public void declinePartyInvitation() {
        client.send(PacketType.PARTY_DECLINE_INVITE);
    }

    public void leaveParty() {
        client.send(PacketType.PARTY_LEAVE);
    }

    public BaseList<Long> getPartyMemberList() {
        return client.exchange(PacketType.PARTY_MEMBERS_LIST).readList(PacketReader::readCardinal);
    }

    public Boolean isInParty() {
        return client.exchange(PacketType.IN_PARTY).readBoolean();
    }

    public Long getTargetID() {
        return client.exchange(PacketType.GET_TARGET_ID).readCardinal();
    }

    public void cancelTarget() {
        client.send(PacketType.CANCEL_TARGET);
    }

    public void targetToObject(Long objectId) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectId);

        client.send(PacketType.TARGET_TO_OBJECT, writer);
    }

    public void targetToXYZ(Integer x, Integer y, Integer z) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeSmallInteger(z);

        client.send(PacketType.TARGET_TO_XYZ, writer);
    }

    public void targetToTile(Integer tileModel, Integer x, Integer y, Integer z) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(tileModel);
        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeSmallInteger(z);

        client.send(PacketType.TARGET_TO_TILE, writer);
    }

    public void waitTargetObject(Long objectId) {
        PacketWriter writer = new PacketWriter();

        writer.writeCardinal(objectId);

        client.send(PacketType.WAIT_TARGET_OBJECT, writer);
        this.setTargetHookIsEnabled(true);
    }

    public void waitTargetTile(Integer tileModel, Integer x, Integer y, Integer z) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(tileModel);
        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeSmallInteger(z);

        client.send(PacketType.WAIT_TARGET_TILE, writer);
        this.setTargetHookIsEnabled(true);
    }

    public void waitTargetXYZ(Integer x, Integer y, Integer z) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(x);
        writer.writeWord(y);
        writer.writeSmallInteger(z);

        client.send(PacketType.WAIT_TARGET_XYZ, writer);
        this.setTargetHookIsEnabled(true);
    }

    public void waitTargetSelf() {
        client.send(PacketType.WAIT_TARGET_SELF);
        this.setTargetHookIsEnabled(true);
    }

    public void waitTargetType(Integer objectType) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);

        client.send(PacketType.WAIT_TARGET_TYPE, writer);
        this.setTargetHookIsEnabled(true);
    }

    public void cancelWaitTarget() {
        client.send(PacketType.CANCEL_WAIT_TARGET);
        this.setTargetHookIsEnabled(false);
    }

    public void waitTargetGround(Integer objectType) {
        PacketWriter writer = new PacketWriter();

        writer.writeWord(objectType);

        client.send(PacketType.WAIT_TARGET_GROUND, writer);
        this.setTargetHookIsEnabled(true);
    }

    public void waitTargetLast() {
        client.send(PacketType.WAIT_TARGET_LAST);
        this.setTargetHookIsEnabled(true);
    }

    public Boolean waitForTargetState(Boolean newState) {
        return waitForTargetState(newState, 5);
    }


    public Boolean waitForTargetState(Boolean newState, Integer delay) {
        while (!Objects.equals(this.isTargetPresent(), newState)) {
            this.waitForClient(delay);
        }
        return this.isTargetPresent();
    }

    public Boolean isTargetPresent() {
        Long lastTarget = this.getTargetID();

        return lastTarget != 0;
    }

    public Boolean isStealthRunning() {
        final ProcessHelper helper = new ProcessHelper();

        BaseList<ProcessHandle> x86List = helper.getProcessList("Stealth.exe");
        BaseList<ProcessHandle> x64List = helper.getProcessList("Stealth_x64.exe");


        return Objects.equals(x86List.isEmpty(), false) || Objects.equals(x64List.isEmpty(), false);
    }

    public MapCellResponse getMapCell(Integer x, Integer y, Facet facet) {
        PacketWriter writer = new PacketWriter().addWord(x, y).addSmallInteger(facet.getId());
        return client.exchange(PacketType.GET_CELL, writer).readObject(MapCellResponse.class);

    }

    public WorldCellResponse isWorldCellPassable(Integer fromX, Integer fromY, Integer fromZ,
                                                 Integer toX, Integer toY, Facet facet) {
        PacketWriter writer = new PacketWriter().addWord(fromX, fromY).addSmallInteger(fromZ)
                .addWord(toX, toY).addSmallInteger(facet.getId());

        return client.exchange(PacketType.IS_WORLD_CELL_PASSABLE, writer).readObject(WorldCellResponse.class);
    }

    public BaseList<TileResultResponse> getTiles(TileType type, Integer xMin, Integer yMin,
                                                 Integer xMax, Integer yMax, Facet facet, BaseList<Integer> tiles) {
        PacketWriter writer = new PacketWriter().addWord(xMin, yMin, xMax, yMax).addSmallInteger(facet.getId());

        writer.writeList(tiles, PacketWriter::writeWord);

        if (Objects.equals(type, TileType.LAND_TILE)) {
            return client.exchange(PacketType.GET_LAND_TILES_ARRAY, writer).
                    readList(packetReader -> packetReader.readObject(TileResultResponse.class));
        } else {
            return client.exchange(PacketType.GET_STATIC_TILES_ARRAY, writer).
                    readList(packetReader -> packetReader.readObject(TileResultResponse.class));
        }
    }

    public String getSkillById(Integer id) {
        PacketWriter writer = new PacketWriter().addInteger(id);

        return client.exchange(PacketType.GET_SKILL_ID, writer).readString();
    }

    public byte[] getStaticArtBitmapAsArray(Integer type, Integer color) {
        PacketWriter writer = new PacketWriter().addWord(type, color);
        return client.exchange(PacketType.GET_STATIC_ART_BITMAP, writer).readBytes();
    }

    public Long getTileFlags(Integer group, Integer tile) {
        PacketWriter writer = new PacketWriter().addSmallInteger(group).addWord(tile);

        return client.exchange(PacketType.GET_TILE_FLAGS, writer).readCardinal();
    }

    public LandTileResponse getLandTileData(Integer tile) {
        PacketWriter writer = new PacketWriter().addWord(tile);

        return client.exchange(PacketType.GET_LAND_TILE_DATA, writer).readObject(LandTileResponse.class);
    }

    public StaticTileResponse getStaticTileData(Integer tile) {
        PacketWriter writer = new PacketWriter().addWord(tile);

        return client.exchange(PacketType.GET_STATIC_TILE_DATA, writer).readObject(StaticTileResponse.class);
    }

    public Integer getSurfaceZ(Integer x, Integer y, Facet facet) {
        PacketWriter writer = new PacketWriter().addWord(x, y).addSmallInteger(facet.getId());

        return client.exchange(PacketType.GET_SURFACE_Z, writer).readSmallInteger();
    }

    public BaseList<StaticItemResponse> readStaticsXY(Integer x, Integer y, Facet facet) {
        PacketWriter writer = new PacketWriter().addWord(x, y).addSmallInteger(facet.getId());

        return client.exchange(PacketType.READ_STATICS_XY, writer).readList(packetReader -> packetReader.readObject(StaticItemResponse.class));
    }

    public Integer getLayerCount(Integer x, Integer y, Facet facet) {
        PacketWriter writer = new PacketWriter().addWord(x, y).addSmallInteger(facet.getId());

        return client.exchange(PacketType.GET_LAYER_COUNT, writer).readSmallInteger();
    }

    public Long convertIntegerToTileFlags(Integer group, Long flags) {
        PacketWriter writer = new PacketWriter().addSmallInteger(group).addCardinal(flags);

        return client.exchange(PacketType.CONVERT_INTEGER_TO_FLAGS, writer).readCardinal();
    }

    public BaseList<MultiItemResponse> getAllMultis() {
        return client.exchange(PacketType.GET_MULTIS).
                readList(packetReader -> packetReader.readObject(MultiItemResponse.class));
    }


    public void setItemInfoEvent(ExtendedEventAction<ItemInfoEvent> event) {
        final EventType type = EventType.ITEM_INFO;
        if (event == null) {
            if (handler.getItemInfoEvent() != null) {
                clearEventProcedure(type);
                this.handler.setItemInfoEvent(null);
            }
        } else {
            if (handler.getItemInfoEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setItemInfoEvent(event);
        }
    }

    public void setTimer1Event(EventAction event) {
        final EventType type = EventType.TIMER_1;
        if (event == null) {
            if (handler.getTimer1Event() != null) {
                clearEventProcedure(type);
                this.handler.setTimer1Event(null);
            }
        } else {
            if (handler.getTimer1Event() == null) {
                setEventProcedure(type);
            }
            this.handler.setTimer1Event(event);
        }
    }

    public void setTimer2Event(EventAction event) {
        final EventType type = EventType.TIMER_2;
        if (event == null) {
            if (handler.getTimer2Event() != null) {
                clearEventProcedure(type);
                this.handler.setTimer2Event(null);
            }
        } else {
            if (handler.getTimer2Event() == null) {
                setEventProcedure(type);
            }
            this.handler.setTimer2Event(event);
        }
    }

    public void setItemDeletedEvent(ExtendedEventAction<ItemDeletedEvent> event) {
        final EventType type = EventType.ITEM_DELETED;
        if (event == null) {
            if (handler.getItemDeletedEvent() != null) {
                clearEventProcedure(type);
                this.handler.setItemDeletedEvent(null);
            }
        } else {
            if (handler.getItemDeletedEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setItemDeletedEvent(event);
        }
    }

    public void setSpeechEvent(ExtendedEventAction<SpeechEvent> event) {
        final EventType type = EventType.SPEECH;
        if (event == null) {
            if (handler.getSpeechEvent() != null) {
                clearEventProcedure(type);
                this.handler.setSpeechEvent(null);
            }
        } else {
            if (handler.getSpeechEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setSpeechEvent(event);
        }
    }

    public void setDrawPlayerEvent(ExtendedEventAction<DrawGamePlayerEvent> event) {
        final EventType type = EventType.DRAW_GAME_PLAYER;
        if (event == null) {
            if (handler.getDrawPlayerEvent() != null) {
                clearEventProcedure(type);
                this.handler.setDrawPlayerEvent(null);
            }
        } else {
            if (handler.getDrawPlayerEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setDrawPlayerEvent(event);
        }
    }

    public void setUpdateCharacterEvent(ExtendedEventAction<UpdateCharEvent> event) {
        final EventType type = EventType.UPDATE_CHAR;
        if (event == null) {
            if (handler.getUpdateCharacterEvent() != null) {
                clearEventProcedure(type);
                this.handler.setUpdateCharacterEvent(null);
            }
        } else {
            if (handler.getUpdateCharacterEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setUpdateCharacterEvent(event);
        }
    }

    public void setDrawObjectEvent(ExtendedEventAction<DrawObjectEvent> event) {
        final EventType type = EventType.DRAW_OBJECT;
        if (event == null) {
            if (handler.getDrawObjectEvent() != null) {
                clearEventProcedure(type);
                this.handler.setDrawObjectEvent(null);
            }
        } else {
            if (handler.getDrawObjectEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setDrawObjectEvent(event);
        }
    }

    public void setAddMultipleItemsInContainerEvent(ExtendedEventAction<AddMultipleItemsInContainerEvent> event) {
        final EventType type = EventType.ADD_MULTIPLE_ITEMS_IN_CONT;
        if (event == null) {
            if (handler.getAddMultipleItemsInContainerEvent() != null) {
                clearEventProcedure(type);
                this.handler.setAddMultipleItemsInContainerEvent(null);
            }
        } else {
            if (handler.getAddMultipleItemsInContainerEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setAddMultipleItemsInContainerEvent(event);
        }
    }

    public void setWindowsMessageEvent(ExtendedEventAction<WindowsMessageEvent> event) {
        final EventType type = EventType.WINDOWS_MESSAGE;
        if (event == null) {
            if (handler.getWindowsMessageEvent() != null) {
                clearEventProcedure(type);
                this.handler.setWindowsMessageEvent(null);
            }
        } else {
            if (handler.getWindowsMessageEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setWindowsMessageEvent(event);
        }
    }

    public void setClientSendResyncEvent(EventAction event) {
        final EventType type = EventType.CLIENT_SEND_RESYNC;
        if (event == null) {
            if (handler.getClientSendResyncEvent() != null) {
                clearEventProcedure(type);
                this.handler.setClientSendResyncEvent(null);
            }
        } else {
            if (handler.getClientSendResyncEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setClientSendResyncEvent(event);
        }
    }

    public void setMoveRejectionEvent(ExtendedEventAction<MoveRejectionEvent> event) {
        final EventType type = EventType.MOVE_REJECTION;
        if (event == null) {
            if (handler.getMoveRejectionEvent() != null) {
                clearEventProcedure(type);
                this.handler.setMoveRejectionEvent(null);
            }
        } else {
            if (handler.getMoveRejectionEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setMoveRejectionEvent(event);
        }
    }

    public void setAddItemToContainerEvent(ExtendedEventAction<AddItemToContainerEvent> event) {
        final EventType type = EventType.ADD_ITEM_TO_CONTAINER;
        if (event == null) {
            if (handler.getAddItemToContainerEvent() != null) {
                clearEventProcedure(type);
                this.handler.setAddItemToContainerEvent(null);
            }
        } else {
            if (handler.getAddItemToContainerEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setAddItemToContainerEvent(event);
        }
    }

    public void setDrawContainerEvent(ExtendedEventAction<DrawContainerEvent> event) {
        final EventType type = EventType.DRAW_CONTAINER;
        if (event == null) {
            if (handler.getDrawContainerEvent() != null) {
                clearEventProcedure(type);
                this.handler.setDrawContainerEvent(null);
            }
        } else {
            if (handler.getDrawContainerEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setDrawContainerEvent(event);
        }
    }

    public void setRejectMoveItemEvent(ExtendedEventAction<RejectMoveItemEvent> event) {
        final EventType type = EventType.REJECT_MOVE_ITEM;
        if (event == null) {
            if (handler.getRejectMoveItemEvent() != null) {
                clearEventProcedure(type);
                this.handler.setRejectMoveItemEvent(null);
            }
        } else {
            if (handler.getRejectMoveItemEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setRejectMoveItemEvent(event);
        }
    }

    public void setMenuEvent(ExtendedEventAction<MenuEvent> event) {
        final EventType type = EventType.MENU;
        if (event == null) {
            if (handler.getMenuEvent() != null) {
                clearEventProcedure(type);
                this.handler.setMenuEvent(null);
            }
        } else {
            if (handler.getMenuEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setMenuEvent(event);
        }
    }

    public void setMapMessageEvent(ExtendedEventAction<MapMessageEvent> event) {
        final EventType type = EventType.MAP_MESSAGE;
        if (event == null) {
            if (handler.getMapMessageEvent() != null) {
                clearEventProcedure(type);
                this.handler.setMapMessageEvent(null);
            }
        } else {
            if (handler.getMapMessageEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setMapMessageEvent(event);
        }
    }

    public void setAllowRefuseAttackEvent(ExtendedEventAction<AllowRefuseAttackEvent> event) {
        final EventType type = EventType.ALLOW_REFUSE_ATTACK;
        if (event == null) {
            if (handler.getAllowRefuseAttackEvent() != null) {
                clearEventProcedure(type);
                this.handler.setAllowRefuseAttackEvent(null);
            }
        } else {
            if (handler.getAllowRefuseAttackEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setAllowRefuseAttackEvent(event);
        }
    }

    public void setClilocSpeechEvent(ExtendedEventAction<ClilocSpeechEvent> event) {
        final EventType type = EventType.CLILOC_SPEECH;
        if (event == null) {
            if (handler.getClilocSpeechEvent() != null) {
                clearEventProcedure(type);
                this.handler.setClilocSpeechEvent(null);
            }
        } else {
            if (handler.getClilocSpeechEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setClilocSpeechEvent(event);
        }
    }

    public void setClilocSpeechAffixEvent(ExtendedEventAction<ClilocSpeechAffixEvent> event) {
        final EventType type = EventType.CLILOC_SPEECH_AFFIX;
        if (event == null) {
            if (handler.getClilocSpeechAffixEvent() != null) {
                clearEventProcedure(type);
                this.handler.setClilocSpeechAffixEvent(null);
            }
        } else {
            if (handler.getClilocSpeechAffixEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setClilocSpeechAffixEvent(event);
        }
    }

    public void setUnicodeSpeechEvent(ExtendedEventAction<UnicodeSpeechEvent> event) {
        final EventType type = EventType.UNICODE_SPEECH;
        if (event == null) {
            if (handler.getUnicodeSpeechEvent() != null) {
                clearEventProcedure(type);
                this.handler.setUnicodeSpeechEvent(null);
            }
        } else {
            if (handler.getUnicodeSpeechEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setUnicodeSpeechEvent(event);
        }
    }

    public void setBuffDebuffSystemEvent(ExtendedEventAction<BuffDebuffSystemEvent> event) {
        final EventType type = EventType.BUFF_DEBUFF_SYSTEM;
        if (event == null) {
            if (handler.getBuffDebuffSystemEvent() != null) {
                clearEventProcedure(type);
                this.handler.setBuffDebuffSystemEvent(null);
            }
        } else {
            if (handler.getBuffDebuffSystemEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setBuffDebuffSystemEvent(event);
        }
    }

    public void setCharAnimationEvent(ExtendedEventAction<CharAnimationEvent> event) {
        final EventType type = EventType.CHAR_ANIMATION;
        if (event == null) {
            if (handler.getCharAnimationEvent() != null) {
                clearEventProcedure(type);
                this.handler.setCharAnimationEvent(null);
            }
        } else {
            if (handler.getCharAnimationEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setCharAnimationEvent(event);
        }
    }

    public void setIncomingGumpEvent(ExtendedEventAction<IncomingGumpEvent> event) {
        final EventType type = EventType.INCOMING_GUMP;
        if (event == null) {
            if (handler.getIncomingGumpEvent() != null) {
                clearEventProcedure(type);
                this.handler.setIncomingGumpEvent(null);
            }
        } else {
            if (handler.getIncomingGumpEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setIncomingGumpEvent(event);
        }
    }

    public void setSoundEvent(ExtendedEventAction<SoundEvent> event) {
        final EventType type = EventType.SOUND;
        if (event == null) {
            if (handler.getSoundEvent() != null) {
                clearEventProcedure(type);
                this.handler.setSoundEvent(null);
            }
        } else {
            if (handler.getSoundEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setSoundEvent(event);
        }
    }

    public void setDeathEvent(ExtendedEventAction<DeathEvent> event) {
        final EventType type = EventType.DEATH;
        if (event == null) {
            if (handler.getDeathEvent() != null) {
                clearEventProcedure(type);
                this.handler.setDeathEvent(null);
            }
        } else {
            if (handler.getDeathEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setDeathEvent(event);
        }
    }

    public void setQuestArrowEvent(ExtendedEventAction<QuestArrowEvent> event) {
        final EventType type = EventType.QUEST_ARROW;
        if (event == null) {
            if (handler.getQuestArrowEvent() != null) {
                clearEventProcedure(type);
                this.handler.setQuestArrowEvent(null);
            }
        } else {
            if (handler.getQuestArrowEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setQuestArrowEvent(event);
        }
    }

    public void setGlobalChatEvent(ExtendedEventAction<GlobalChatEvent> event) {
        final EventType type = EventType.GLOBAL_CHAT;
        if (event == null) {
            if (handler.getGlobalChatEvent() != null) {
                clearEventProcedure(type);
                this.handler.setGlobalChatEvent(null);
            }
        } else {
            if (handler.getGlobalChatEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setGlobalChatEvent(event);
        }
    }

    public void setGraphicalEffectEvent(ExtendedEventAction<GraphicalEffectEvent> event) {
        final EventType type = EventType.GRAPHICAL_EFFECT;
        if (event == null) {
            if (handler.getGraphicalEffectEvent() != null) {
                clearEventProcedure(type);
                this.handler.setGraphicalEffectEvent(null);
            }
        } else {
            if (handler.getGraphicalEffectEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setGraphicalEffectEvent(event);
        }
    }

    public void setGumpTextEntryEvent(ExtendedEventAction<GumpTextEntryEvent> event) {
        final EventType type = EventType.GUMP_TEXT_ENTRY;
        if (event == null) {
            if (handler.getGumpTextEntryEvent() != null) {
                clearEventProcedure(type);
                this.handler.setGumpTextEntryEvent(null);
            }
        } else {
            if (handler.getGumpTextEntryEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setGumpTextEntryEvent(event);
        }
    }

    public void setIrcIncomingTextEvent(ExtendedEventAction<IRCIncomingTextEvent> event) {
        final EventType type = EventType.IRC_INCOMING_TEXT;
        if (event == null) {
            if (handler.getIrcIncomingTextEvent() != null) {
                clearEventProcedure(type);
                this.handler.setIrcIncomingTextEvent(null);
            }
        } else {
            if (handler.getIrcIncomingTextEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setIrcIncomingTextEvent(event);
        }
    }

    public void setMapPinEvent(ExtendedEventAction<MapPinEvent> event) {
        final EventType type = EventType.MAP_PIN;
        if (event == null) {
            if (handler.getMapPinEvent() != null) {
                clearEventProcedure(type);
                this.handler.setMapPinEvent(null);
            }
        } else {
            if (handler.getMapPinEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setMapPinEvent(event);
        }
    }

    public void setPartyInviteEvent(ExtendedEventAction<PartyInviteEvent> event) {
        final EventType type = EventType.PARTY_INVITE;
        if (event == null) {
            if (handler.getPartyInviteEvent() != null) {
                clearEventProcedure(type);
                this.handler.setPartyInviteEvent(null);
            }
        } else {
            if (handler.getPartyInviteEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setPartyInviteEvent(event);
        }
    }

    public void setSetGlobalVarEvent(ExtendedEventAction<SetGlobalVarEvent> event) {
        final EventType type = EventType.SET_GLOBAL_VAR;
        if (event == null) {
            if (handler.getSetGlobalVarEvent() != null) {
                clearEventProcedure(type);
                this.handler.setSetGlobalVarEvent(null);
            }
        } else {
            if (handler.getSetGlobalVarEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setSetGlobalVarEvent(event);
        }
    }

    public void setObjectStatusEvent(ExtendedEventAction<UpdateObjectStatusEvent> event) {
        final EventType type = EventType.UPDATE_OBJ_STATS;
        if (event == null) {
            if (handler.getObjectStatusEvent() != null) {
                clearEventProcedure(type);
                this.handler.setObjectStatusEvent(null);
            }
        } else {
            if (handler.getObjectStatusEvent() == null) {
                setEventProcedure(type);
            }
            this.handler.setObjectStatusEvent(event);
        }
    }
}