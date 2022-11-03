package de.scriptsdk.api.model.handler;

import de.scriptsdk.api.enums.EventType;
import de.scriptsdk.api.exceptions.event.EventException;
import de.scriptsdk.api.interfaces.event.EventAction;
import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.interfaces.event.ExtendedEventAction;
import de.scriptsdk.api.model.entity.ApiEntity;
import de.scriptsdk.api.model.event.*;
import de.scriptsdk.api.model.io.EventReader;
import de.scriptsdk.api.model.network.ApiClient;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.model.io.PacketReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author Crome696
 * @version 1.0
 */
public class EventHandler extends ApiEntity {

    private ExtendedEventAction<ItemInfoEvent> itemInfoEvent;
    private EventAction timer1Event;
    private EventAction timer2Event;
    private ExtendedEventAction<ItemDeletedEvent> itemDeletedEvent;
    private ExtendedEventAction<SpeechEvent> speechEvent;
    private ExtendedEventAction<DrawGamePlayerEvent> drawPlayerEvent;
    private ExtendedEventAction<UpdateCharEvent> updateCharacterEvent;
    private ExtendedEventAction<DrawObjectEvent> drawObjectEvent;
    private ExtendedEventAction<AddMultipleItemsInContainerEvent> addMultipleItemsInContainerEvent;
    private ExtendedEventAction<WindowsMessageEvent> windowsMessageEvent;
    private EventAction clientSendResyncEvent;
    private ExtendedEventAction<MoveRejectionEvent> moveRejectionEvent;
    private ExtendedEventAction<AddItemToContainerEvent> addItemToContainerEvent;
    private ExtendedEventAction<DrawContainerEvent> drawContainerEvent;
    private ExtendedEventAction<RejectMoveItemEvent> rejectMoveItemEvent;
    private ExtendedEventAction<MenuEvent> menuEvent;
    private ExtendedEventAction<MapMessageEvent> mapMessageEvent;
    private ExtendedEventAction<AllowRefuseAttackEvent> allowRefuseAttackEvent;
    private ExtendedEventAction<ClilocSpeechEvent> clilocSpeechEvent;
    private ExtendedEventAction<ClilocSpeechAffixEvent> clilocSpeechAffixEvent;
    private ExtendedEventAction<UnicodeSpeechEvent> unicodeSpeechEvent;
    private ExtendedEventAction<BuffDebuffSystemEvent> buffDebuffSystemEvent;
    private ExtendedEventAction<CharAnimationEvent> charAnimationEvent;
    private ExtendedEventAction<IncomingGumpEvent> incomingGumpEvent;
    private ExtendedEventAction<SoundEvent> soundEvent;
    private ExtendedEventAction<DeathEvent> deathEvent;
    private ExtendedEventAction<QuestArrowEvent> questArrowEvent;
    private ExtendedEventAction<GlobalChatEvent> globalChatEvent;
    private ExtendedEventAction<GraphicalEffectEvent> graphicalEffectEvent;
    private ExtendedEventAction<GumpTextEntryEvent> gumpTextEntryEvent;
    private ExtendedEventAction<IRCIncomingTextEvent> ircIncomingTextEvent;
    private ExtendedEventAction<MapPinEvent> mapPinEvent;
    private ExtendedEventAction<PartyInviteEvent> partyInviteEvent;
    private ExtendedEventAction<SetGlobalVarEvent> setGlobalVarEvent;
    private ExtendedEventAction<UpdateObjectStatusEvent> objectStatusEvent;

    public EventHandler(ApiClient client) {
        super(client);
    }

    public ExtendedEventAction<ItemInfoEvent> getItemInfoEvent() {
        return itemInfoEvent;
    }

    public void setItemInfoEvent(ExtendedEventAction<ItemInfoEvent> itemInfoEvent) {
        this.itemInfoEvent = itemInfoEvent;
    }

    public EventAction getTimer1Event() {
        return timer1Event;
    }

    public void setTimer1Event(EventAction timer1Event) {
        this.timer1Event = timer1Event;
    }

    public EventAction getTimer2Event() {
        return timer2Event;
    }

    public void setTimer2Event(EventAction timer2Event) {
        this.timer2Event = timer2Event;
    }

    public ExtendedEventAction<ItemDeletedEvent> getItemDeletedEvent() {
        return itemDeletedEvent;
    }

    public void setItemDeletedEvent(ExtendedEventAction<ItemDeletedEvent> itemDeletedEvent) {
        this.itemDeletedEvent = itemDeletedEvent;
    }

    public ExtendedEventAction<SpeechEvent> getSpeechEvent() {
        return speechEvent;
    }

    public void setSpeechEvent(ExtendedEventAction<SpeechEvent> speechEvent) {
        this.speechEvent = speechEvent;
    }

    public ExtendedEventAction<DrawGamePlayerEvent> getDrawPlayerEvent() {
        return drawPlayerEvent;
    }

    public void setDrawPlayerEvent(ExtendedEventAction<DrawGamePlayerEvent> drawPlayerEvent) {
        this.drawPlayerEvent = drawPlayerEvent;
    }

    public ExtendedEventAction<UpdateCharEvent> getUpdateCharacterEvent() {
        return updateCharacterEvent;
    }

    public void setUpdateCharacterEvent(ExtendedEventAction<UpdateCharEvent> updateCharacterEvent) {
        this.updateCharacterEvent = updateCharacterEvent;
    }

    public ExtendedEventAction<DrawObjectEvent> getDrawObjectEvent() {
        return drawObjectEvent;
    }

    public void setDrawObjectEvent(ExtendedEventAction<DrawObjectEvent> drawObjectEvent) {
        this.drawObjectEvent = drawObjectEvent;
    }

    public ExtendedEventAction<AddMultipleItemsInContainerEvent> getAddMultipleItemsInContainerEvent() {
        return addMultipleItemsInContainerEvent;
    }

    public void setAddMultipleItemsInContainerEvent(ExtendedEventAction<AddMultipleItemsInContainerEvent> addMultipleItemsInContainerEvent) {
        this.addMultipleItemsInContainerEvent = addMultipleItemsInContainerEvent;
    }

    public ExtendedEventAction<WindowsMessageEvent> getWindowsMessageEvent() {
        return windowsMessageEvent;
    }

    public void setWindowsMessageEvent(ExtendedEventAction<WindowsMessageEvent> windowsMessageEvent) {
        this.windowsMessageEvent = windowsMessageEvent;
    }

    public EventAction getClientSendResyncEvent() {
        return clientSendResyncEvent;
    }

    public void setClientSendResyncEvent(EventAction clientSendResyncEvent) {
        this.clientSendResyncEvent = clientSendResyncEvent;
    }

    public ExtendedEventAction<MoveRejectionEvent> getMoveRejectionEvent() {
        return moveRejectionEvent;
    }

    public void setMoveRejectionEvent(ExtendedEventAction<MoveRejectionEvent> moveRejectionEvent) {
        this.moveRejectionEvent = moveRejectionEvent;
    }

    public ExtendedEventAction<AddItemToContainerEvent> getAddItemToContainerEvent() {
        return addItemToContainerEvent;
    }

    public void setAddItemToContainerEvent(ExtendedEventAction<AddItemToContainerEvent> addItemToContainerEvent) {
        this.addItemToContainerEvent = addItemToContainerEvent;
    }

    public ExtendedEventAction<DrawContainerEvent> getDrawContainerEvent() {
        return drawContainerEvent;
    }

    public void setDrawContainerEvent(ExtendedEventAction<DrawContainerEvent> drawContainerEvent) {
        this.drawContainerEvent = drawContainerEvent;
    }

    public ExtendedEventAction<RejectMoveItemEvent> getRejectMoveItemEvent() {
        return rejectMoveItemEvent;
    }

    public void setRejectMoveItemEvent(ExtendedEventAction<RejectMoveItemEvent> rejectMoveItemEvent) {
        this.rejectMoveItemEvent = rejectMoveItemEvent;
    }

    public ExtendedEventAction<MenuEvent> getMenuEvent() {
        return menuEvent;
    }

    public void setMenuEvent(ExtendedEventAction<MenuEvent> menuEvent) {
        this.menuEvent = menuEvent;
    }

    public ExtendedEventAction<MapMessageEvent> getMapMessageEvent() {
        return mapMessageEvent;
    }

    public void setMapMessageEvent(ExtendedEventAction<MapMessageEvent> mapMessageEvent) {
        this.mapMessageEvent = mapMessageEvent;
    }

    public ExtendedEventAction<AllowRefuseAttackEvent> getAllowRefuseAttackEvent() {
        return allowRefuseAttackEvent;
    }

    public void setAllowRefuseAttackEvent(ExtendedEventAction<AllowRefuseAttackEvent> allowRefuseAttackEvent) {
        this.allowRefuseAttackEvent = allowRefuseAttackEvent;
    }

    public ExtendedEventAction<ClilocSpeechEvent> getClilocSpeechEvent() {
        return clilocSpeechEvent;
    }

    public void setClilocSpeechEvent(ExtendedEventAction<ClilocSpeechEvent> clilocSpeechEvent) {
        this.clilocSpeechEvent = clilocSpeechEvent;
    }

    public ExtendedEventAction<ClilocSpeechAffixEvent> getClilocSpeechAffixEvent() {
        return clilocSpeechAffixEvent;
    }

    public void setClilocSpeechAffixEvent(ExtendedEventAction<ClilocSpeechAffixEvent> clilocSpeechAffixEvent) {
        this.clilocSpeechAffixEvent = clilocSpeechAffixEvent;
    }

    public ExtendedEventAction<UnicodeSpeechEvent> getUnicodeSpeechEvent() {
        return unicodeSpeechEvent;
    }

    public void setUnicodeSpeechEvent(ExtendedEventAction<UnicodeSpeechEvent> unicodeSpeechEvent) {
        this.unicodeSpeechEvent = unicodeSpeechEvent;
    }

    public ExtendedEventAction<BuffDebuffSystemEvent> getBuffDebuffSystemEvent() {
        return buffDebuffSystemEvent;
    }

    public void setBuffDebuffSystemEvent(ExtendedEventAction<BuffDebuffSystemEvent> buffDebuffSystemEvent) {
        this.buffDebuffSystemEvent = buffDebuffSystemEvent;
    }

    public ExtendedEventAction<CharAnimationEvent> getCharAnimationEvent() {
        return charAnimationEvent;
    }

    public void setCharAnimationEvent(ExtendedEventAction<CharAnimationEvent> charAnimationEvent) {
        this.charAnimationEvent = charAnimationEvent;
    }

    public ExtendedEventAction<IncomingGumpEvent> getIncomingGumpEvent() {
        return incomingGumpEvent;
    }

    public void setIncomingGumpEvent(ExtendedEventAction<IncomingGumpEvent> incomingGumpEvent) {
        this.incomingGumpEvent = incomingGumpEvent;
    }

    public ExtendedEventAction<SoundEvent> getSoundEvent() {
        return soundEvent;
    }

    public void setSoundEvent(ExtendedEventAction<SoundEvent> itemSoundEvent) {
        this.soundEvent = itemSoundEvent;
    }

    public ExtendedEventAction<DeathEvent> getDeathEvent() {
        return deathEvent;
    }

    public void setDeathEvent(ExtendedEventAction<DeathEvent> deathEvent) {
        this.deathEvent = deathEvent;
    }

    public ExtendedEventAction<QuestArrowEvent> getQuestArrowEvent() {
        return questArrowEvent;
    }

    public void setQuestArrowEvent(ExtendedEventAction<QuestArrowEvent> questArrowEvent) {
        this.questArrowEvent = questArrowEvent;
    }

    public ExtendedEventAction<GlobalChatEvent> getGlobalChatEvent() {
        return globalChatEvent;
    }

    public void setGlobalChatEvent(ExtendedEventAction<GlobalChatEvent> globalChatEvent) {
        this.globalChatEvent = globalChatEvent;
    }

    public ExtendedEventAction<GraphicalEffectEvent> getGraphicalEffectEvent() {
        return graphicalEffectEvent;
    }

    public void setGraphicalEffectEvent(ExtendedEventAction<GraphicalEffectEvent> graphicalEffectEvent) {
        this.graphicalEffectEvent = graphicalEffectEvent;
    }

    public ExtendedEventAction<GumpTextEntryEvent> getGumpTextEntryEvent() {
        return gumpTextEntryEvent;
    }

    public void setGumpTextEntryEvent(ExtendedEventAction<GumpTextEntryEvent> gumpTextEntryEvent) {
        this.gumpTextEntryEvent = gumpTextEntryEvent;
    }

    public ExtendedEventAction<IRCIncomingTextEvent> getIrcIncomingTextEvent() {
        return ircIncomingTextEvent;
    }

    public void setIrcIncomingTextEvent(ExtendedEventAction<IRCIncomingTextEvent> ircIncomingTextEvent) {
        this.ircIncomingTextEvent = ircIncomingTextEvent;
    }

    public ExtendedEventAction<MapPinEvent> getMapPinEvent() {
        return mapPinEvent;
    }

    public void setMapPinEvent(ExtendedEventAction<MapPinEvent> mapPinEvent) {
        this.mapPinEvent = mapPinEvent;
    }

    public ExtendedEventAction<PartyInviteEvent> getPartyInviteEvent() {
        return partyInviteEvent;
    }

    public void setPartyInviteEvent(ExtendedEventAction<PartyInviteEvent> partyInviteEvent) {
        this.partyInviteEvent = partyInviteEvent;
    }

    public ExtendedEventAction<SetGlobalVarEvent> getSetGlobalVarEvent() {
        return setGlobalVarEvent;
    }

    public void setSetGlobalVarEvent(ExtendedEventAction<SetGlobalVarEvent> setGlobalVarEvent) {
        this.setGlobalVarEvent = setGlobalVarEvent;
    }

    public ExtendedEventAction<UpdateObjectStatusEvent> getObjectStatusEvent() {
        return objectStatusEvent;
    }

    public void setObjectStatusEvent(ExtendedEventAction<UpdateObjectStatusEvent> objectStatusEvent) {
        this.objectStatusEvent = objectStatusEvent;
    }

    public void onEventAction(PacketReader reader) {
        EventType eventType = Enumerable.valueOf(reader.readSmallInteger(), EventType.class);
        Integer size = reader.readSmallInteger();
        switch (eventType) {

            case ITEM_INFO -> onExtendedEvent(reader, ItemInfoEvent.class, itemInfoEvent, size);
            case ITEM_DELETED -> onExtendedEvent(reader, ItemDeletedEvent.class, itemDeletedEvent, size);
            case SPEECH -> onExtendedEvent(reader, SpeechEvent.class, speechEvent, size);
            case DRAW_GAME_PLAYER -> onExtendedEvent(reader, DrawGamePlayerEvent.class, drawPlayerEvent, size);
            case MOVE_REJECTION -> onExtendedEvent(reader, MoveRejectionEvent.class, moveRejectionEvent, size);
            case DRAW_CONTAINER -> onExtendedEvent(reader, DrawContainerEvent.class, drawContainerEvent, size);
            case ADD_ITEM_TO_CONTAINER ->
                    onExtendedEvent(reader, AddItemToContainerEvent.class, addItemToContainerEvent, size);
            case ADD_MULTIPLE_ITEMS_IN_CONT ->
                    onExtendedEvent(reader, AddMultipleItemsInContainerEvent.class, addMultipleItemsInContainerEvent, size);
            case REJECT_MOVE_ITEM -> onExtendedEvent(reader, RejectMoveItemEvent.class, rejectMoveItemEvent, size);
            case UPDATE_CHAR -> onExtendedEvent(reader, UpdateCharEvent.class, updateCharacterEvent, size);
            case DRAW_OBJECT -> onExtendedEvent(reader, DrawObjectEvent.class, drawObjectEvent, size);
            case MENU -> onExtendedEvent(reader, MenuEvent.class, menuEvent, size);
            case MAP_MESSAGE -> onExtendedEvent(reader, MapMessageEvent.class, mapMessageEvent, size);
            case ALLOW_REFUSE_ATTACK ->
                    onExtendedEvent(reader, AllowRefuseAttackEvent.class, allowRefuseAttackEvent, size);
            case CLILOC_SPEECH -> onExtendedEvent(reader, ClilocSpeechEvent.class, clilocSpeechEvent, size);
            case CLILOC_SPEECH_AFFIX ->
                    onExtendedEvent(reader, ClilocSpeechAffixEvent.class, clilocSpeechAffixEvent, size);
            case UNICODE_SPEECH -> onExtendedEvent(reader, UnicodeSpeechEvent.class, unicodeSpeechEvent, size);
            case BUFF_DEBUFF_SYSTEM ->
                    onExtendedEvent(reader, BuffDebuffSystemEvent.class, buffDebuffSystemEvent, size);
            case CLIENT_SEND_RESYNC -> onEvent(clientSendResyncEvent, size);
            case CHAR_ANIMATION -> onExtendedEvent(reader, CharAnimationEvent.class, charAnimationEvent, size);
            case INCOMING_GUMP -> onExtendedEvent(reader, IncomingGumpEvent.class, incomingGumpEvent, size);
            case TIMER_1 -> onEvent(timer1Event, size);
            case TIMER_2 -> onEvent(timer2Event, size);
            case WINDOWS_MESSAGE -> onExtendedEvent(reader, WindowsMessageEvent.class, windowsMessageEvent, size);
            case SOUND -> onExtendedEvent(reader, SoundEvent.class, soundEvent, size);
            case DEATH -> onExtendedEvent(reader, DeathEvent.class, deathEvent, size);
            case QUEST_ARROW -> onExtendedEvent(reader, QuestArrowEvent.class, questArrowEvent, size);
            case PARTY_INVITE -> onExtendedEvent(reader, PartyInviteEvent.class, partyInviteEvent, size);
            case MAP_PIN -> onExtendedEvent(reader, MapPinEvent.class, mapPinEvent, size);
            case GUMP_TEXT_ENTRY -> onExtendedEvent(reader, GumpTextEntryEvent.class, gumpTextEntryEvent, size);
            case GRAPHICAL_EFFECT -> onExtendedEvent(reader, GraphicalEffectEvent.class, graphicalEffectEvent, size);
            case IRC_INCOMING_TEXT -> onExtendedEvent(reader, IRCIncomingTextEvent.class, ircIncomingTextEvent, size);
            case SET_GLOBAL_VAR -> onExtendedEvent(reader, SetGlobalVarEvent.class, setGlobalVarEvent, size);
            case UPDATE_OBJ_STATS -> onExtendedEvent(reader, UpdateObjectStatusEvent.class, objectStatusEvent, size);
            case GLOBAL_CHAT -> onExtendedEvent(reader, GlobalChatEvent.class, globalChatEvent, size);
            default -> throw new EventException("Unsupported event type %s!", eventType.name());
        }
    }

    private void onEvent(EventAction handle, Integer size) {
        if (!Objects.equals(size, 0)) {
            throw new EventException("Error on Parsing Event, 0 expected but %d args actual!", size);
        }
        if (handle != null) {
            handle.onEvent(getClient());
        }
    }

    private <T extends EventReadable> void onExtendedEvent(PacketReader reader, Class<T> clazz, ExtendedEventAction<T> handle, Integer size) {
        if (Objects.equals(size, 0)) {
            throw new EventException("Error on Parsing Event, more than 0 expected but %d args actual!", size);
        }
        if (handle != null) {
            try {
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                T data = constructor.newInstance();
                data.deserialize(new EventReader(reader));
                handle.onEvent(getClient(), data);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new EventException(e.getLocalizedMessage());
            }
        }
    }

    public void unsubscribe(EventType eventType) {
        switch (eventType) {
            case ITEM_INFO -> itemInfoEvent = null;
            case ITEM_DELETED -> itemDeletedEvent = null;
            case SPEECH -> speechEvent = null;
            case DRAW_GAME_PLAYER -> drawPlayerEvent = null;
            case MOVE_REJECTION -> moveRejectionEvent = null;
            case DRAW_CONTAINER -> drawContainerEvent = null;
            case ADD_ITEM_TO_CONTAINER -> addItemToContainerEvent = null;
            case ADD_MULTIPLE_ITEMS_IN_CONT -> addMultipleItemsInContainerEvent = null;
            case REJECT_MOVE_ITEM -> rejectMoveItemEvent = null;
            case UPDATE_CHAR -> updateCharacterEvent = null;
            case DRAW_OBJECT -> drawObjectEvent = null;
            case MENU -> menuEvent = null;
            case MAP_MESSAGE -> mapMessageEvent = null;
            case ALLOW_REFUSE_ATTACK -> allowRefuseAttackEvent = null;
            case CLILOC_SPEECH -> clilocSpeechEvent = null;
            case CLILOC_SPEECH_AFFIX -> clilocSpeechAffixEvent = null;
            case UNICODE_SPEECH -> unicodeSpeechEvent = null;
            case BUFF_DEBUFF_SYSTEM -> buffDebuffSystemEvent = null;
            case CLIENT_SEND_RESYNC -> clientSendResyncEvent = null;
            case CHAR_ANIMATION -> charAnimationEvent = null;
            case INCOMING_GUMP -> incomingGumpEvent = null;
            case TIMER_1 -> timer1Event = null;
            case TIMER_2 -> timer2Event = null;
            case WINDOWS_MESSAGE -> windowsMessageEvent = null;
            case SOUND -> soundEvent = null;
            case DEATH -> deathEvent = null;
            case QUEST_ARROW -> questArrowEvent = null;
            case PARTY_INVITE -> partyInviteEvent = null;
            case MAP_PIN -> mapPinEvent = null;
            case GUMP_TEXT_ENTRY -> gumpTextEntryEvent = null;
            case GRAPHICAL_EFFECT -> graphicalEffectEvent = null;
            case IRC_INCOMING_TEXT -> ircIncomingTextEvent = null;
            case SET_GLOBAL_VAR -> setGlobalVarEvent = null;
            case UPDATE_OBJ_STATS -> objectStatusEvent = null;
            case GLOBAL_CHAT -> globalChatEvent = null;
            default -> throw new EventException("Unsupported event type %s!", eventType.name());
        }
    }
}

