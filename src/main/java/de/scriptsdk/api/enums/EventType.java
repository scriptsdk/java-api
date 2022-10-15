package de.scriptsdk.api.enums;

import de.scriptsdk.api.interfaces.event.EventAction;
import de.scriptsdk.api.model.event.*;
import de.scriptsdk.core.interfaces.Enumerable;


public enum EventType implements Enumerable {
    ITEM_INFO(0, ItemInfoEvent.class),
    ITEM_DELETED(1, ItemDeletedEvent.class),
    SPEECH(2, SpeechEvent.class),
    DRAW_GAME_PLAYER(3, DrawGamePlayerEvent.class),
    MOVE_REJECTION(4, MoveRejectionEvent.class),
    DRAW_CONTAINER(5, DrawContainerEvent.class),
    ADD_ITEM_TO_CONTAINER(6, AddItemToContainerEvent.class),
    ADD_MULTIPLE_ITEMS_IN_CONT(7, AddMultipleItemsInContainerEvent.class),
    REJECT_MOVE_ITEM(8, RejectMoveItemEvent.class),
    UPDATE_CHAR(9, UpdateCharEvent.class),
    DRAW_OBJECT(10, DrawObjectEvent.class),
    MENU(11, MenuEvent.class),
    MAP_MESSAGE(12, MapMessageEvent.class),
    ALLOW_REFUSE_ATTACK(13, AllowRefuseAttackEvent.class),
    CLILOC_SPEECH(14, ClilocSpeechEvent.class),
    CLILOC_SPEECH_AFFIX(15, ClilocSpeechAffixEvent.class),
    UNICODE_SPEECH(16, UnicodeSpeechEvent.class),
    BUFF_DEBUFF_SYSTEM(17, BuffDebuffSystemEvent.class),
    CLIENT_SEND_RESYNC(18, EventAction.class),
    CHAR_ANIMATION(19, CharAnimationEvent.class),
    INCOMING_GUMP(24, IncomingGumpEvent.class),
    TIMER_1(25, EventAction.class),
    TIMER_2(26, EventAction.class),
    WINDOWS_MESSAGE(27, WindowsMessageEvent.class),
    SOUND(28, SoundEvent.class),
    DEATH(29, DeathEvent.class),
    QUEST_ARROW(30, QuestArrowEvent.class),
    PARTY_INVITE(31, PartyInviteEvent.class),
    MAP_PIN(32, MapPinEvent.class),
    GUMP_TEXT_ENTRY(33, GumpTextEntryEvent.class),
    GRAPHICAL_EFFECT(34, GraphicalEffectEvent.class),
    IRC_INCOMING_TEXT(35, IRCIncomingTextEvent.class),
    MESSENGER_EVENT(36, Void.class),
    SET_GLOBAL_VAR(37, SetGlobalVarEvent.class),
    UPDATE_OBJ_STATS(38, UpdateObjectStatusEvent.class),
    GLOBAL_CHAT(39, GlobalChatEvent.class);

    private final Integer id;
    private final Class<?> clazz;

    EventType(Integer id, Class<?> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
