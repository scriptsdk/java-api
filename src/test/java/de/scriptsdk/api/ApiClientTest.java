package de.scriptsdk.api;

import de.scriptsdk.api.enums.*;
import de.scriptsdk.api.interfaces.event.EventAction;
import de.scriptsdk.api.interfaces.event.ExtendedEventAction;
import de.scriptsdk.api.model.account.CharacterCreationRequest;
import de.scriptsdk.api.model.assets.MapCellResponse;
import de.scriptsdk.api.model.event.*;
import de.scriptsdk.api.model.geometry.Point3DRequest;
import de.scriptsdk.api.model.system.Version;
import de.scriptsdk.core.model.generic.BaseList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

class ApiClientTest extends BaseTest {
    @Test
    void authenthicate() {
        final LanguageType languageType = LanguageType.OTHER;
        final Version version = new Version(1, 0, 0, 0);

        Assertions.assertDoesNotThrow(() ->
                getClient().authenticate(languageType, version));
    }

    @Test
    void getBookPageText() {
        final int page = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getBookPageText(page)));
    }

    @Test
    void setBookText() {
        final String text = "This is a unit test!";
        Assertions.assertDoesNotThrow(() ->
                getClient().setBookText(text));
    }

    @Test
    void setBookPageText() {
        final int page = 1;
        final String text = "This is a unit test!";

        Assertions.assertDoesNotThrow(() ->
                getClient().setBookPageText(page, text));
    }

    @Test
    void clearBookText() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearBookText());
    }

    @Test
    void setBookHeader() {
        final String title = "Unit Test";
        final String author = "Crome";
        Assertions.assertDoesNotThrow(() ->
                getClient().setBookHeader(title, author));
    }

    @Test
    void joinGlobalChatChannel() {
        final String channel = "Global";
        Assertions.assertDoesNotThrow(() ->
                getClient().joinGlobalChatChannel(channel));
    }

    @Test
    void leaveGlobalChatChannel() {
        Assertions.assertDoesNotThrow(() ->
                getClient().leaveGlobalChatChannel());
    }

    @Test
    void sendGlobalChannelChatMessage() {
        final String text = "Hello World!";
        Assertions.assertDoesNotThrow(() ->
                getClient().sendGlobalChannelChatMessage(text));
    }

    @Test
    void getActiveGlobalChatChannel() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getActiveGlobalChatChannel()));
    }

    @Test
    void getGlobalChannelList() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGlobalChannelList()));
    }

    @Test
    void addChatUserIgnore() {
        final String value = "user";

        Assertions.assertDoesNotThrow(() ->
                getClient().addChatUserIgnore(value));
    }

    @Test
    void clearChatUserIgnore() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearChatUserIgnore()
        );
    }


    @Test
    void getGender() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGender(objectId)));
    }

    @Test
    void usePaperdollScroll() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().usePaperdollScroll(objectId));
    }

    @Test
    void getObjectAtLayer() {
        final long objectId = getClient().getPlayerID();
        final Layer layer = Layer.RING;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getObjectAtLayer(layer, objectId)));
    }

    @Test
    void renameMobile() {
        final long objectId = getClient().getPlayerID();
        final String name = "Unit Test";

        Assertions.assertDoesNotThrow(() ->
                getClient().renameMobile(objectId, name));
    }

    @Test
    void mobileCanBeRenamed() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().mobileCanBeRenamed(objectId)));
    }

    @Test
    void getName() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getName(objectId)));
    }

    @Test
    void getAlternativeName() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getAlternativeName(objectId)));
    }

    @Test
    void getTitle() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTitle(objectId)));
    }

    @Test
    void getPlayerStrength() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStrength()));
    }

    @Test
    void getPlayerIntelligence() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getIntelligence()));
    }

    @Test
    void getPlayerDexterity() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDexterity()));
    }

    @Test
    void getPlayerHitPoints() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getHitPoints()));
    }

    @Test
    void getPlayerMaxHitPoints() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxHitPoints()));
    }

    @Test
    void getPlayerMana() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMana()));
    }

    @Test
    void getPlayerMaxMana() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxMana()));
    }

    @Test
    void getPlayerStamina() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStamina()));
    }

    @Test
    void getPlayerMaxStamina() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxStamina()));
    }

    @Test
    void getNotoriety() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getNotoriety(objectId)));
    }

    @Test
    void isInCombatMode() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isInCombatMode(objectId)));
    }

    @Test
    void isNPC() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isNPC(objectId)));
    }

    @Test
    void isPlayerDead() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isDead()));
    }

    @Test
    void isRunning() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isRunning(objectId)));
    }

    @Test
    void isImmortal() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isImmortal(objectId)));
    }

    @Test
    void isPlayerPoisoned() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isPoisoned()));
    }

    @Test
    void isPlayerParalyzed() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isParalyzed()));
    }

    @Test
    void getQuantity() {
        final long itemId = 0x40026A35;
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getQuantity(itemId)));
    }

    @Test
    void isContainer() {
        final long itemId = 0x40026A35;
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isContainer(itemId)));
    }

    @Test
    void getLayer() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLayer(objectId)));
    }

    @Test
    void requestStats() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().requestStatus(objectId));
    }

    @Test
    void getTooltip() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTooltip(objectId)));
    }

    @Test
    void getObjectType() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getType(objectId)));
    }

    @Test
    void getObjectProperty() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getProperties(objectId)));
    }

    @Test
    void getPrice() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPrice(objectId)));
    }

    @Test
    void isObjectExists() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isObjectExists(objectId)));
    }

    @Test
    void getDirection() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDirection(objectId)));
    }

    @Test
    void getDistance() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDistance(objectId)));
    }

    @Test
    void getColor() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getColor(objectId)));
    }

    @Test
    void isPlayerHidden() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isHidden()));
    }

    @Test
    void isMovable() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isMovable(objectId)));
    }

    @Test
    void getParent() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getParent(objectId)));
    }

    @Test
    void useItemOnMobile() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().useItemOnMobile(objectId, objectId));
    }

    @Test
    void getProfileName() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getProfileName()));
    }

    @Test
    void isConnected() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isConnected()));
    }

    @Test
    void addToSystemJournal() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().addToSystemJournal(text));
    }


    @Test
    void getStealthInfo() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStealthInfo()));
    }

    @Test
    void getAutoReconnectMode() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getAutoReconnectMode()));
    }

    @Test
    void setAutoReconnectMode() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setAutoReconnectMode(state));
    }

    @Test
    void getPauseOnDisconnectMode() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPauseOnDisconnectMode()));
    }

    @Test
    void setPauseOnDisconnectMode() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setPauseOnDisconnectMode(state));
    }

    @Test
    void getLastDisconnectTime() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastDisconnectTime()));
    }

    @Test
    void getLastConnectTime() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastConnectTime()));
    }


    @Test
    void connect() {
        getClient().disconnect();

        while (getClient().isConnected()) {
            getClient().waitForClient(50);
        }

        Assertions.assertDoesNotThrow(() ->
                getClient().connect());

        while (!getClient().isConnected()) {
            getClient().waitForClient(50);
        }
    }


    @Test
    void disconnect() {
        Assertions.assertDoesNotThrow(() ->
                getClient().disconnect());

        while (getClient().isConnected()) {
            getClient().waitForClient(50);
        }
    }

    @Test
    void getShardName() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getShardName()));
    }

    @Test
    void getProxyIp() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getProxyIp()));
    }

    @Test
    void getProxyPort() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getProxyPort()));
    }

    @Test
    void isProxyMode() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isProxyMode()));
    }

    @Test
    void changeProfile() {
        final String profileName = "admin";
        Assertions.assertDoesNotThrow(() ->
                log(getClient().changeProfile(profileName)));
    }

    @Test
    void changeProfileAdvanced() {
        final String profileName = "admin";
        final String shardName = "ServUO";
        final String charName = "Crome";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().changeProfile(profileName, shardName, charName)));
    }


    @Test
    void startCheckLag() {
        Assertions.assertDoesNotThrow(() ->
                getClient().startCheckLag());
    }

    @Test
    void stopCheckLag() {
        Assertions.assertDoesNotThrow(() ->
                getClient().stopCheckLag());
    }

    @Test
    void isCheckLagStopped() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isCheckLagStopped()));
    }

    @Test
    void getSilentMode() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSilentMode()));
    }

    @Test
    void setSilentMode() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setSilentMode(state));
    }

    @Test
    void fillNewWindow() {
        final String text = "Unit Test";

        Assertions.assertDoesNotThrow(() ->
                getClient().fillNewWindow(text));
    }

    @Test
    void getStealthPath() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStealthPath()));
    }

    @Test
    void getStealthProfilePath() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStealthProfilePath()));
    }

    @Test
    void getShardPath() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getShardPath()));
    }

    @Test
    void sendTextToUO() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().sendTextToUO(text));
    }

    @Test
    void sendTextToUOColor() {
        final String text = "Hello World";
        final int color = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                getClient().sendTextToUOColor(text, color));
    }

    @Test
    void setGlobalVariable() {
        VarRegion region = VarRegion.STEALTH;
        String keyName = "Crome";
        String value = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().setGlobalVariable(region, keyName, value));
    }

    @Test
    void getGlobalVariable() {
        VarRegion region = VarRegion.STEALTH;
        String keyName = "Crome";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGlobalVariable(region, keyName)));
    }

    @Test
    void replyToConsoleEntry() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().replyToConsoleEntry(text));
    }

    @Test
    void setAlarm() {
        Assertions.assertDoesNotThrow(() ->
                getClient().setAlarm());
    }

    @Test
    void printToClient() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().printToClient(text));
    }

    @Test
    void printToClientAdvanced() {
        final String text = "Hello World";
        final long sender = getClient().getPlayerID();
        final int color = 0x1234;
        final int font = 0;

        Assertions.assertDoesNotThrow(() ->
                getClient().printToClient(sender, color, font, text));
    }

    @Test
    void closeClientUIWindow() {
        final UIWindowType uiWindowType = UIWindowType.CHAR_PROFILE;
        final long sender = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().closeClientUIWindow(uiWindowType, sender));
    }

    @Test
    void requestClientObjectTarget() {
        Assertions.assertDoesNotThrow(() ->
                getClient().requestClientObjectTarget());
    }

    @Test
    void requestClientTileTarget() {
        Assertions.assertDoesNotThrow(() ->
                getClient().requestClientTileTarget());
    }

    @Test
    void isClientTargetResponsePresent() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isClientTargetResponsePresent()));
    }


    @Test
    void getClientTargetResponse() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getClientTargetResponse()));
    }

    @Test
    void getStealthDateTimeUnixNow() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStealthDateTimeUnixNow()));
    }

    @Test
    void getStealthDateTimeNow() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStealthDateTimeNow()));
    }

    @Test
    void getScriptCount() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getScriptCount()));
    }

    @Test
    void getScriptPath() {
        final int index = 99;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getScriptPath(index)));
    }

    @Test
    void getScriptState() {
        final int index = 99;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getScriptState(index)));
    }

    @Test
    void startScript() {
        final String path = "C:\\files\\script.pas";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().startScript(path)));
    }

    @Test
    void pauseOrResumeSelectedScript() {
        final int index = 99;

        Assertions.assertDoesNotThrow(() ->
                getClient().pauseOrResumeSelectedScript(index));
    }

    @Test
    void setScriptName() {
        final String name = "test.java";
        final int index = 99;

        Assertions.assertDoesNotThrow(() ->
                getClient().setScriptName(index, name));
    }

    @Test
    void getScriptName() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getScriptName(index)));
    }

    @Test
    void getScriptParameter() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getScriptParameter()));
    }

    @Test
    void clearSystemJournal() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearSystemJournal());
    }

    @Test
    void clearInfoWindow() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearInfoWindow());
    }

    @Test
    void setAutoReconnectParameter() {
        final String shardName = "ServUO";
        final String charName = "Crome";
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setAutoReconnectParameter(shardName, charName, state));
    }

    @Test
    void getGameServerIP() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGameServerIP()));
    }

    @Test
    void getProfileShardName() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getProfileShardName()));
    }

    @Test
    void getClientVersionAsInteger() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getClientVersionAsInteger()));
    }

    @Test
    void dumbObjectsCache() {
        Assertions.assertDoesNotThrow(() ->
                getClient().dumbObjectsCache());
    }

    @Test
    void hideClient() {
        List<ProcessHandle> list = ProcessHandle.allProcesses().toList().
                stream().filter(handle ->
                        Objects.equals(Path.of(handle.info().command().orElse("")).
                                getFileName().toString(), "Stealth.exe")
                ).toList();

        if (list.isEmpty()) {
            list = ProcessHandle.allProcesses().toList().
                    stream().filter(handle ->
                            Objects.equals(Path.of(handle.info().command().orElse("")).
                                    getFileName().toString(), "Stealth_x64.exe")
                    ).toList();
        }

        if (list.size() > 0) {
            long pid = list.get(0).pid();

            Assertions.assertDoesNotThrow(() ->
                    getClient().hideClient(pid));
        } else {
            Assertions.fail("There is no Stealth client found!");
        }

    }

    @Test
    void replyToConsoleEntryAsUnicode() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().replyToConsoleEntryAsUnicode(text));
    }

    @Test
    void waitForClient() {
        Assertions.assertDoesNotThrow(() ->
                getClient().waitForClient(50));
    }

    @Test
    void setShowIPCExceptionWindow() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setShowIPCExceptionWindow(state));
    }

    @Test
    void getShowIPCExceptionWindow() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getShowIPCExceptionWindow()));
    }


    @Test
    void getFoundParamID() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFoundParamID()));
    }

    @Test
    void getJournalLineID() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineID()));
    }

    @Test
    void getJournalLineType() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineType()));
    }

    @Test
    void getJournalLineTime() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineTime()));
    }

    @Test
    void getJournalMessageLineType() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalMessageLineType()));
    }

    @Test
    void getJournalLineColor() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineColor()));
    }

    @Test
    void getJournalLineFont() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineFont()));
    }

    @Test
    void getJournalLineIndex() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineIndex()));
    }

    @Test
    void getJournalLineCount() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineCount()));
    }

    @Test
    void getJournalLineName() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getJournalLineName()));
    }

    @Test
    void isInJournal() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isInJournal(text)));
    }

    @Test
    void addJournalIgnore() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().addJournalIgnore(text));
    }

    @Test
    void clearJournalIgnore() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearJournalIgnore());
    }


    @Test
    void clearJournal() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearJournal());
    }

    @Test
    void getLastJournalMessage() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastJournalMessage()));
    }

    @Test
    void inJournal() {
        final String value = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().inJournal(value)));
    }

    @Test
    void inJournalBetweenTime() {
        final String value = "Hello World";
        LocalDateTime max = LocalDateTime.now();
        LocalDateTime min = max.minusMinutes(1L);

        Assertions.assertDoesNotThrow(() ->
                log(getClient().inJournalBetweenTime(value, min, max)));
    }

    @Test
    void journal() {
        final int index = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().journal(index)));
    }

    @Test
    void setJournalLine() {
        final int index = 1;
        final String value = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().setJournalLine(index, value));
    }

    @Test
    void getLowJournal() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLowJournal()));
    }

    @Test
    void getHighJournal() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getHighJournal()));
    }

    @Test
    void addToJournal() {
        final String value = "Hello World";
        Assertions.assertDoesNotThrow(() ->
                getClient().addToJournal(value));
    }


    @Test
    void getCell() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final Facet facet = getClient().getFacet();


        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMapCell(x, y, facet)));
    }

    @Test
    void getTileFlags() {
        final int group = 1;
        final int tile = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTileFlags(group, tile)));
    }

    @Test
    void getLandTileData() {
        final int tile = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLandTileData(tile)));
    }

    @Test
    void getStaticTileData() {
        final int tile = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStaticTileData(tile)));
    }

    @Test
    void getLayerCount() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        final Facet facet = getClient().getFacet();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLayerCount(x, y, facet)));
    }

    @Test
    void readStaticsXY() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        final Facet facet = getClient().getFacet();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().readStaticsXY(x, y, facet)));
    }

    @Test
    void getSurfaceZ() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final Facet facet = getClient().getFacet();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSurfaceZ(x, y, facet)));
    }

    @Test
    void isWorldCellPassable() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int z = getClient().getZ(playerId);
        final Facet facet = getClient().getFacet();

        final int x2 = x + 1;
        final int y2 = y + 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isWorldCellPassable(x, y, z,
                        x2, y2, facet)));
    }

    @Test
    void getTiles() {
        final int tile = 0x1234;

        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        final Facet facet = getClient().getFacet();

        final int x2 = x + 1;
        final int y2 = y + 1;
        final BaseList<Integer> list = new BaseList<>(tile);

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTiles(TileType.LAND_TILE, x, y,
                        x2, y2, facet, list)));

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTiles(TileType.STATIC_TILE, x, y,
                        x2, y2, facet, list)));
    }

    @Test
    void convertIntegerToTileFlags() {
        final int group = 1;
        final long flags = 1L;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().convertIntegerToTileFlags(group, flags)));
    }

    @Test
    void getAllMultis() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getAllMultis()));
    }

    @Test
    void getClilocByID() {

        final long clilocId = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getClilocByID(clilocId)));
    }

    @Test
    void getStaticArtAsBitmap() {
        final int objectType = 0;
        final int color = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStaticArtBitmapAsArray(objectType, color)));
    }

    @Test
    void confirmTrade() {
        final int index = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().confirmTrade(index));
    }

    @Test
    void cancelTrade() {
        final int index = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().cancelTrade(index)));
    }

    @Test
    void getTradeOpponent() {
        final int index = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTradeOpponent(index)));
    }

    @Test
    void getTradeCount() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTradeCount()));
    }

    @Test
    void getTradeOpponentName() {
        final int index = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTradeOpponentName(index)));
    }

    @Test
    void tradeCheck() {
        final int tradeNumber = 1;
        final int number = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().tradeCheck(tradeNumber, number)));
    }

    @Test
    void checkTradeState() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().checkTradeState()));
    }

    @Test
    void getTradeContainer() {
        final int tradeIndex = 1;
        final int number = 1;
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTradeContainer(tradeIndex, number)));
    }

    @Test
    void getTargetID() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTargetID()));
    }

    @Test
    void cancelTarget() {
        Assertions.assertDoesNotThrow(() ->
                getClient().cancelTarget());
    }

    @Test
    void targetToObject() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().targetToObject(playerId));
    }

    @Test
    void targetToXYZ() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int z = getClient().getZ(playerId);

        Assertions.assertDoesNotThrow(() ->
                getClient().targetToXYZ(x, y, z));
    }

    @Test
    void targetToTile() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        final Facet facet = getClient().getFacet();

        final MapCellResponse mapCell = getClient().getMapCell(x, y, facet);

        Assertions.assertDoesNotThrow(() ->
                getClient().targetToTile(mapCell.getTile(),
                        x, y, mapCell.getZ()));
    }

    @Test
    void waitTargetObject() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetObject(playerId));

        getClient().cancelWaitTarget();
    }

    @Test
    void waitTargetTile() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        final Facet facet = getClient().getFacet();

        final MapCellResponse mapCell = getClient().getMapCell(x, y, facet);

        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetTile(mapCell.getTile(),
                        x, y, mapCell.getZ()));

        getClient().cancelWaitTarget();
    }

    @Test
    void waitTargetXYZ() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int z = getClient().getZ(playerId);

        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetXYZ(x, y, z));

        getClient().cancelWaitTarget();
    }

    @Test
    void waitTargetSelf() {
        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetSelf());

        getClient().cancelWaitTarget();
    }

    @Test
    void waitTargetType() {
        final int objecttype = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetType(objecttype));

        getClient().cancelWaitTarget();
    }

    @Test
    void cancelWaitTarget() {
        Assertions.assertDoesNotThrow(() ->
                getClient().cancelWaitTarget());
    }

    @Test
    void waitTargetGround() {
        final int objecttype = 0x1234;

        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetGround(objecttype));

        getClient().cancelWaitTarget();
    }

    @Test
    void waitTargetLast() {
        Assertions.assertDoesNotThrow(() ->
                getClient().waitTargetLast());

        getClient().cancelWaitTarget();
    }

    @Test
    void waitForTargetState() {
        final boolean state = false;
        Assertions.assertDoesNotThrow(() ->
                getClient().waitForTargetState(state));

        getClient().cancelWaitTarget();
    }

    @Test
    void isTargetPresent() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isTargetPresent()));
    }

    @Test
    void autoBuy() {
        final int itemType = 0x0E21;
        final int itemColor = 0x0000;
        final int amount = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().autoBuy(itemType, itemColor, amount));
    }

    @Test
    void getShopList() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getShopList()));
    }

    @Test
    void clearShopList() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearShopList());
    }

    @Test
    void autoBuyExtended() {
        final int itemType = 0x0E21;
        final int itemColor = 0x0000;
        final int amount = 1;
        final long price = 50;
        final String name = "Bandage";

        Assertions.assertDoesNotThrow(() ->
                getClient().autoBuyExtended(itemType, itemColor,
                        amount, price, name));
    }

    @Test
    void getAutoBuyDelay() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getAutoBuyDelay()));
    }

    @Test
    void setAutoBuyDelay() {
        final int delay = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setAutoBuyDelay(delay));
    }

    @Test
    void getAutoSellDelay() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getAutoSellDelay()));
    }

    @Test
    void setAutoSellDelay() {
        final int delay = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setAutoSellDelay(delay));
    }

    @Test
    void autoSell() {
        final int itemType = 0x0E21;
        final int itemColor = 0x0000;
        final int amount = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().autoSell(itemType, itemColor, amount));
    }


    @Test
    void findTypes() {
        final BaseList<Integer> itemTypes = new BaseList<>(0x0E21);
        final BaseList<Integer> itemColors = new BaseList<>(0x0000);
        final BaseList<Long> containers = new BaseList<>(getClient().getBackpackID());
        final boolean scanRecursive = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().findTypes(itemTypes, itemColors,
                        containers, scanRecursive)));
    }

    @Test
    void getFindDistance() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindDistance()));
    }

    @Test
    void setFindDistance() {
        final int distance = 10;
        Assertions.assertDoesNotThrow(() ->
                getClient().setFindDistance(distance));
    }

    @Test
    void getFindVertical() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindVertical()));
    }

    @Test
    void setFindVertical() {
        final int distance = 10;

        Assertions.assertDoesNotThrow(() ->
                getClient().setFindVertical(distance));
    }

    @Test
    void findType() {
        final int itemType = 0x0E21;
        final int itemColor = 0x0000;
        final long backpackId = getClient().getBackpackID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().findType(itemType, itemColor, backpackId)));
    }

    @Test
    void findNotoriety() {
        final int itemType = 0x0E21;
        final Notoriety notoriety = Notoriety.INNOCENT;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().findNotoriety(itemType, notoriety)));
    }

    @Test
    void findAtCoordination() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        Assertions.assertDoesNotThrow(() ->
                log(getClient().findAtCoordination(x, y)));
    }

    @Test
    void ignore() {
        final long itemId = 0x40026A35;

        Assertions.assertDoesNotThrow(() ->
                getClient().ignore(itemId));
    }

    @Test
    void removeFromIgnoreList() {
        final long itemId = 0x40026A35;

        Assertions.assertDoesNotThrow(() ->
                getClient().removeFromIgnoreList(itemId));
    }

    @Test
    void resetIgnoreList() {
        Assertions.assertDoesNotThrow(() ->
                getClient().resetIgnoreList());
    }

    @Test
    void getIgnoreList() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getIgnoreList()));
    }

    @Test
    void getFindList() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindList()));
    }

    @Test
    void getFindInNullPointLocation() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindInNullPointLocation()));
    }

    @Test
    void setFindInNullPointLocation() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setFindInNullPointLocation(state));
    }

    @Test
    void getFindItem() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindItem()));
    }

    @Test
    void getFindCount() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindCount()));
    }

    @Test
    void getFindQuantity() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindQuantity()));
    }

    @Test
    void getFindTotalQuantity() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFindTotalQuantity()));
    }


    @Test
    void getPlayerID() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPlayerID()));
    }

    @Test
    void getX() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getX(playerId)));
    }

    @Test
    void getY() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getY(playerId)));
    }

    @Test
    void getZ() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getZ(playerId)));
    }

    @Test
    void getPlayerName() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getName()));
    }

    @Test
    void getFacet() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFacet()));
    }

    @Test
    void getPlayerGender() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGender()));
    }

    @Test
    void getPlayerTitle() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTitle()));
    }

    @Test
    void getGold() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGold()));
    }

    @Test
    void getArmor() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getArmor()));
    }

    @Test
    void getWeight() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getWeight()));
    }

    @Test
    void getMaxWeight() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxWeight()));
    }

    @Test
    void getRace() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getRace()));
    }

    @Test
    void getMaxPets() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxPets()));
    }

    @Test
    void getPets() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPets()));
    }

    @Test
    void getFireResistance() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getFireResistance()));
    }

    @Test
    void getColdResistance() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getColdResistance()));
    }

    @Test
    void getPoisonResistance() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPoisonResistance()));
    }

    @Test
    void getEnergyResistance() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getEnergyResistance()));
    }

    @Test
    void getLastContainer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastContainer()));
    }

    @Test
    void getLastTarget() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastTarget()));
    }

    @Test
    void getLastAttack() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastAttacker()));
    }

    @Test
    void getLastStatus() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastStatus()));
    }

    @Test
    void getLastObject() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastObject()));
    }

    @Test
    void getBackpackID() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getBackpackID()));
    }

    @Test
    void getLuck() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLuck()));
    }

    @Test
    void getExtendedInfo() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getExtendedInfo()));
    }

    @Test
    void getCombatTarget() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getCombatTarget()));
    }

    @Test
    void setCombatMode() {
        final boolean state = false;
        Assertions.assertDoesNotThrow(() ->
                getClient().setCombatMode(state));
    }

    @Test
    void attack() {
        final long targetID = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().attack(targetID));
    }

    @Test
    void usePlayerPaperdollScroll() {
        Assertions.assertDoesNotThrow(() ->
                getClient().usePaperdollScroll());
    }

    @Test
    void changeSkillLockState() {
        final SkillType skillType = SkillType.ANATOMY;
        final LockState lockState = LockState.LOCKED;

        Assertions.assertDoesNotThrow(() ->
                getClient().changeSkillLockState(skillType, lockState));
    }

    @Test
    void usePrimaryAbility() {
        Assertions.assertDoesNotThrow(() ->
                getClient().usePrimaryAbility());
    }

    @Test
    void useSecondaryAbility() {
        Assertions.assertDoesNotThrow(() ->
                getClient().useSecondaryAbility());
    }

    @Test
    void getActiveAbility() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getActiveAbility()));
    }

    @Test
    void toggleFly() {
        Assertions.assertDoesNotThrow(() ->
                getClient().toggleFly());
    }

    @Test
    void useObject() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().useObject(objectId));
    }

    @Test
    void useType() {
        final int objectType = 0x0190;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().useType(objectType)));
    }

    @Test
    void useFromGround() {
        final int objectType = 0x0190;
        final int objectColor = 0xFFFF;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().useFromGround(objectType, objectColor)));
    }

    @Test
    void clickOnObject() {
        final long objectId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().clickOnObject(objectId));
    }

    @Test
    void wearItem() {
        final long objectId = 0x40028C48;
        final Layer layer = Layer.RING;

        Assertions.assertDoesNotThrow(() ->
                getClient().wearItem(layer, objectId));
    }

    @Test
    void getDressSpeed() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDressSpeed()));
    }

    @Test
    void setDressSpeed() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setDressSpeed(value));
    }

    @Test
    void setDress() {
        Assertions.assertDoesNotThrow(() ->
                getClient().setDress());
    }

    @Test
    void getDressSet() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDressSet()));
    }

    @Test
    void requestVirtuesGump() {
        Assertions.assertDoesNotThrow(() ->
                getClient().requestVirtuesGump());
    }

    @Test
    void useVirtue() {
        final VirtueType virtue = VirtueType.JUSTICE;

        Assertions.assertDoesNotThrow(() ->
                getClient().useVirtue(virtue));
    }

    @Test
    void useVirtueById() {
        final VirtueType virtue = VirtueType.JUSTICE;

        Assertions.assertDoesNotThrow(() ->
                getClient().useVirtueById(virtue.getId()));
    }

    @Test
    void getQuestArrow() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getQuestArrow()));
    }

    @Test
    void getStateLockState() {
        final StatKind statKind = StatKind.STRENGTH;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStatLockState(statKind)));
    }

    @Test
    void castSpellById() {
        final Spell spell = Spell.CREATE_FOOD;

        Assertions.assertDoesNotThrow(() ->
                getClient().castSpellById(spell.getId()));
    }

    @Test
    void getOpenDoorThroughMovement() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getOpenDoorThroughMovement()));
    }

    @Test
    void setOpenDoorThroughMovement() {
        final boolean value = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setOpenDoorThroughMovement(value));
    }

    @Test
    void getMovementThroughNPC() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMovementThroughNPC()));
    }

    @Test
    void setMovementThroughNPC() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setMovementThroughNPC(value));
    }

    @Test
    void setMovementThroughCorner() {
        final boolean value = false;
        Assertions.assertDoesNotThrow(() ->
                getClient().setMovementThroughCorner(value));
    }

    @Test
    void getMoveHeuristicMulti() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMoveHeuristicMulti()));
    }

    @Test
    void setMoveHeuristicMulti() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setMoveHeuristicMulti(value));
    }

    @Test
    void getMoveCheckStamina() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMoveCheckStamina()));
    }

    @Test
    void setMoveCheckStamina() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setMoveCheckStamina(value));
    }

    @Test
    void getMovementTurnCost() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMovementTurnCost()));
    }

    @Test
    void setMovementTurnCost() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setMovementTurnCost(value));
    }

    @Test
    void setMovingBetweenTwoCorners() {
        final boolean value = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setMovingBetweenTwoCorners(value));
    }

    @Test
    void isMovingBetweenTwoCorners() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMovingBetweenTwoCorners()));
    }

    @Test
    void getPredictedX() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPredictedX()));
    }

    @Test
    void getPredictedY() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPredictedY()));
    }

    @Test
    void getPredictedZ() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPredictedZ()));
    }

    @Test
    void getPredictedDirection() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPredictedDirection()));
    }

    @Test
    void openDoor() {
        Assertions.assertDoesNotThrow(() ->
                getClient().openDoor());
    }

    @Test
    void bow() {
        Assertions.assertDoesNotThrow(() ->
                getClient().bow());
    }

    @Test
    void salute() {
        Assertions.assertDoesNotThrow(() ->
                getClient().salute());
    }

    @Test
    void getLastStepQUsedDoor() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastStepQUsedDoor()));
    }

    @Test
    void getBuffBarInfo() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getBuffBarInfo()));
    }

    @Test
    void getCurrentSkillValue() {
        final SkillType skillType = SkillType.ANATOMY;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getCurrentSkillValue(skillType)));
    }

    @Test
    void useSkill() {
        final SkillType skillType = SkillType.ANATOMY;

        Assertions.assertDoesNotThrow(() ->
                getClient().useSkill(skillType));
    }

    @Test
    void getSkillCap() {
        final SkillType skillType = SkillType.ANATOMY;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSkillCap(skillType)));
    }

    @Test
    void getSkillValue() {
        final SkillType skillType = SkillType.ANATOMY;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSkillValue(skillType)));
    }

    @Test
    void isActiveAbility() {
        final Ability ability = Ability.BODYGUARD;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isActiveAbility(ability)));
    }

    @Test
    void setUnmountTimer() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setUnmountTimer(value));
    }

    @Test
    void getRunMountTimer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getRunMountTimer()));
    }

    @Test
    void setRunMountTimer() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setRunMountTimer(value));
    }

    @Test
    void getWalkMountTimer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getWalkMountTimer()));
    }

    @Test
    void setWalkMountTimer() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setWalkMountTimer(value));
    }

    @Test
    void getRunUnmountTimer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getRunUnmountTimer()));
    }

    @Test
    void getWalkUnmountTimer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getWalkUnmountTimer()));
    }

    @Test
    void setWalkUnmountTimer() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setWalkUnmountTimer(value));
    }

    @Test
    void step() {
        final Direction direction = Direction.NORTH;
        final boolean performAsRunner = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().step(direction, performAsRunner)));
    }

    @Test
    void stepQ() {
        final Direction direction = Direction.SOUTH;
        final boolean performAsRunner = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().stepQ(direction, performAsRunner)));
    }

    @Test
    void useBandageSelf() {
        Assertions.assertDoesNotThrow(() ->
                getClient().useBandageSelf());
    }

    @Test
    void getSkillLockState() {
        SkillType skillType = SkillType.ANATOMY;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSkillLockState(skillType)));
    }

    @Test
    void equipLastWeapon() {
        Assertions.assertDoesNotThrow(() ->
                getClient().equipLastWeapon());
    }

    @Test
    void setUnequipItemsMacro() {
        Assertions.assertDoesNotThrow(() ->
                getClient().setUnequipItemsMacro());
    }

    @Test
    void setEquipItemsMacro() {
        Assertions.assertDoesNotThrow(() ->
                getClient().setEquipItemsMacro());
    }

    @Test
    void changeStatLockState() {
        StatKind statKind = StatKind.STRENGTH;
        LockState lockState = LockState.LOCKED;

        Assertions.assertDoesNotThrow(() ->
                getClient().changeStatLockState(statKind, lockState));
    }

    @Test
    void dragItem() {
        final long itemId = 0x40026A35;
        final long targetContainer = getClient().getBackpackID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().dragItem(itemId, 1)));

        getClient().dropItem(targetContainer, 0, 0, 0);
    }

    @Test
    void dropItem() {
        final long objectID = getClient().getBackpackID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().dropItem(objectID, 0, 0, 0)));
    }

    @Test
    void moveXYZ() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int z = getClient().getZ(playerId);
        final int accuracyXY = 0;
        final int accuracyZ = 0;
        final boolean performAsRunner = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().moveXYZ(x, y, z, accuracyXY, accuracyZ,
                        performAsRunner)));
    }

    @Test
    void moveXY() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int accuracyXY = 0;
        final boolean optimize = false;
        final boolean performAsRunner = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().moveXY(x, y, optimize, accuracyXY, performAsRunner)));
    }

    @Test
    void setBadLocation() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        Assertions.assertDoesNotThrow(() ->
                getClient().setBadLocation(x, y));
    }

    @Test
    void setGoodLocation() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);

        Assertions.assertDoesNotThrow(() ->
                getClient().setGoodLocation(x, y));
    }

    @Test
    void clearBadLocationList() {

        Assertions.assertDoesNotThrow(() ->
                getClient().clearBadLocationList());
    }

    @Test
    void setBadObject() {
        final int itemType = 0x0E21;
        final int itemColor = 0x0000;
        final int radius = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().setBadObject(itemType, itemColor, radius));
    }

    @Test
    void checkLineOfSight() {
        final long playerId = getClient().getPlayerID();

        Point3DRequest from = new Point3DRequest(getClient().getX(playerId),
                getClient().getY(playerId), getClient().getZ(playerId));
        Point3DRequest to = new Point3DRequest(getClient().getX(playerId),
                getClient().getY(playerId), getClient().getZ(playerId));

        final Facet facet = getClient().getFacet();
        final LineOfSightOption option = LineOfSightOption.NONE;
        final LineOfSightType type = LineOfSightType.RUNUO;


        Assertions.assertDoesNotThrow(() ->
                log(getClient().checkLineOfSight(from, to, facet, type, option)));
    }

    @Test
    void getPathArray() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final boolean useOptimisation = false;
        final int accuracy = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPathArray(x, y, useOptimisation, accuracy)));
    }

    @Test
    void getPathArray3D() {
        final long playerId = getClient().getPlayerID();

        Point3DRequest from = new Point3DRequest(getClient().getX(playerId),
                getClient().getY(playerId), getClient().getZ(playerId));
        Point3DRequest to = new Point3DRequest(getClient().getX(playerId),
                getClient().getY(playerId), getClient().getZ(playerId));

        final Facet facet = getClient().getFacet();
        final int accuracyXY = 0;
        final int accuracyZ = 0;
        final boolean performAsRunner = false;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPathArray3D(from, to, facet, accuracyXY, accuracyZ, performAsRunner)));
    }

    @Test
    void getPickupItem() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPickupItem()));
    }

    @Test
    void setPickupItem() {
        final long containerId = getClient().getBackpackID();

        Assertions.assertDoesNotThrow(() ->
                getClient().setPickupItem(containerId));
    }

    @Test
    void getCoordinationCheckOnDrop() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getCoordinationCheckOnDrop()));
    }

    @Test
    void setCoordinationCheckOnDrop() {
        final boolean value = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().setCoordinationCheckOnDrop(value));
    }


    @Test
    void getDropDelay() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDropDelay()));
    }

    @Test
    void setDropDelay() {
        final int value = 500;

        Assertions.assertDoesNotThrow(() ->
                getClient().setDropDelay(value));
    }

    @Test
    void stopMover() {
        Assertions.assertDoesNotThrow(() ->
                getClient().stopMover());
    }

    @Test
    void getNextStepZ() {
        final long playerId = getClient().getPlayerID();

        final int x = getClient().getX(playerId);
        final int y = getClient().getY(playerId);
        final int z = getClient().getZ(playerId);
        final Facet facet = getClient().getFacet();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getNextStepZ(x, y, x, y, facet, z)));
    }

    @Test
    void requestContextMenu() {
        final long playerId = getClient().getPlayerID();

        getClient().setContextMenuHook(playerId, 0);

        Assertions.assertDoesNotThrow(() ->
                getClient().requestContextMenu(playerId));

        getClient().setContextMenuHook(0L, 0);
        getClient().requestContextMenu(0L);
    }

    @Test
    void setContextMenuHook() {
        final long playerId = getClient().getPlayerID();
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                getClient().setContextMenuHook(playerId, index));

        getClient().requestContextMenu(playerId);

        getClient().setContextMenuHook(0L, 0);
        getClient().requestContextMenu(0L);
    }

    @Test
    void getContextMenuAsString() {
        final long playerId = getClient().getPlayerID();

        getClient().requestContextMenu(playerId);

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getContextMenuAsString()));

        getClient().clearContextMenu();
    }

    @Test
    void clearContextMenu() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearContextMenu());
    }

    @Test
    void inviteToParty() {
        final long targetId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().inviteToParty(targetId));
    }

    @Test
    void removeFromParty() {
        final long targetId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                getClient().removeFromParty(targetId));
    }

    @Test
    void sayToPartyMember() {
        final long targetId = getClient().getPlayerID();
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().sayToPartyMember(targetId, text));
    }

    @Test
    void sayToParty() {
        final String text = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().sayToParty(text));
    }

    @Test
    void canPartyLootMe() {
        final boolean state = false;

        Assertions.assertDoesNotThrow(() ->
                getClient().canPartyLootMe(state));
    }

    @Test
    void acceptPartyInvitation() {
        Assertions.assertDoesNotThrow(() ->
                getClient().acceptPartyInvitation());
    }

    @Test
    void declinePartyInvitation() {
        Assertions.assertDoesNotThrow(() ->
                getClient().declinePartyInvitation());
    }

    @Test
    void leaveParty() {
        Assertions.assertDoesNotThrow(() ->
                getClient().leaveParty());
    }

    @Test
    void getPartyMemberList() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getPartyMemberList()));
    }

    @Test
    void isInParty() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isInParty()));
    }

    @Test
    void waitMenu() {
        final String menuCaption = "menu";
        final String elementCaption = "element";

        Assertions.assertDoesNotThrow(() ->
                getClient().waitMenu(menuCaption, elementCaption));
    }

    @Test
    void autoMenu() {
        final String menuCaption = "menu";
        final String elementCaption = "element";

        Assertions.assertDoesNotThrow(() ->
                getClient().autoMenu(menuCaption, elementCaption));
    }

    @Test
    void menuHookPresent() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().menuHookPresent()));
    }

    @Test
    void menuPresent() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().menuPresent()));
    }

    @Test
    void cancelMenu() {
        Assertions.assertDoesNotThrow(() ->
                getClient().cancelMenu());
    }

    @Test
    void closeMenu() {
        Assertions.assertDoesNotThrow(() ->
                getClient().closeMenu());
    }

    @Test
    void getLastMenuItems() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getLastMenuItems()));
    }

    @Test
    void getMenuItemsAsString() {
        final String menuCaption = "menu";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMenuItemsAsString(menuCaption)));
    }

    @Test
    void getMenuItems() {
        final String menuCaption = "menu";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMenuItems(menuCaption)));
    }

    @Test
    void setCatchBag() {
        final long backpackId = getClient().getBackpackID();
        Assertions.assertDoesNotThrow(() ->
                getClient().setCatchBag(backpackId));
    }

    @Test
    void unsetCatchBag() {
        Assertions.assertDoesNotThrow(() ->
                getClient().unsetCatchBag());
    }

    @Test
    void clearGumpsIgnore() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearGumpsIgnore());
    }

    @Test
    void waitGumpInt() {
        final int value = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().waitGumpInt(value));
    }

    @Test
    void waitGumpTextEntry() {
        final String value = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().waitGumpTextEntry(value));
    }

    @Test
    void gumpAutoTextEntry() {
        final int entryId = 1;
        final String value = "Hello World";

        Assertions.assertDoesNotThrow(() ->
                getClient().gumpAutoTextEntry(entryId, value));
    }

    @Test
    void gumpAutoRadiobutton() {
        final int entryId = 1;
        final int value = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().gumpAutoRadiobutton(entryId, value));
    }

    @Test
    void gumpAutoCheckBox() {
        final int entryId = 1;
        final int value = 1;

        Assertions.assertDoesNotThrow(() ->
                getClient().gumpAutoCheckBox(entryId, value));
    }

    @Test
    void clickGumpButton() {
        final int entryId = 1;
        final int buttonId = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().clickGumpButton(entryId, buttonId)));
    }

    @Test
    void editGumpTextEntry() {
        final int index = 1;
        final int entryId = 1;
        final String value = "Hello world";

        Assertions.assertDoesNotThrow(() ->
                log(getClient().editGumpTextEntry(index, entryId, value)));
    }

    @Test
    void editGumpRadioButton() {
        final int index = 1;
        final int entryId = 1;
        final int value = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().editGumpRadioButton(index, entryId, value)));
    }

    @Test
    void editGumpCheckBox() {
        final int index = 1;
        final int entryId = 1;
        final int value = 1;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().editGumpCheckBox(index, entryId, value)));
    }

    @Test
    void getGumpsCount() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpsCount()));
    }

    @Test
    void closeSimpleGump() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                getClient().closeSimpleGump(index));
    }

    @Test
    void getGumpSerial() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpSerial(index)));
    }

    @Test
    void getGumpID() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpID(index)));
    }

    @Test
    void getGumpNoClose() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpNoClose(index)));
    }

    @Test
    void getGumpTextLines() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpTextLines(index)));
    }

    @Test
    void getGumpFullLines() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpFullLines(index)));
    }

    @Test
    void getGumpShortLines() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpShortLines(index)));
    }

    @Test
    void getGumpButtonsDescription() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpButtonsDescription(index)));
    }

    @Test
    void getGumpInfo() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getGumpInfo(index)));
    }

    @Test
    void addGumpIgnoreByID() {
        final long value = 1L;

        Assertions.assertDoesNotThrow(() ->
                getClient().addGumpIgnoreByID(value));
    }

    @Test
    void addGumpIgnoreBySerial() {
        final long value = 1L;

        Assertions.assertDoesNotThrow(() ->
                getClient().addGumpIgnoreBySerial(value));
    }

    @Test
    void closeClientGump() {
        final int index = 0;

        Assertions.assertDoesNotThrow(() ->
                getClient().closeClientGump(index));
    }

    @Test
    void createCharacter() {
        final CharacterCreationRequest request = new CharacterCreationRequest();

        Assertions.assertDoesNotThrow(() ->
                getClient().createCharacter(request));
    }

    @Test
    void getContextDelay() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getContextDelay()));
    }

    @Test
    void getContextMenuAsRecord() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getContextMenuAsRecord()));
    }

    @Test
    void getTotalStats() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getTotalStats()));
    }

    @Test
    void requestQuestGump() {
        Assertions.assertDoesNotThrow(() ->
                getClient().requestQuestGump());
    }

    @Test
    void requestHelpGump() {
        Assertions.assertDoesNotThrow(() ->
                getClient().requestHelpGump());
    }

    @Test
    void getMovementThroughCorner() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMovementThroughCorner()));
    }

    @Test
    void clearBadObjectList() {
        Assertions.assertDoesNotThrow(() ->
                getClient().clearBadObjectList());
    }

    @Test
    void isImmortalPlayer() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isImmortal()));
    }

    @Test
    void isTargetHookIsEnabled() {
        Assertions.assertDoesNotThrow(() ->
                log(getClient().isTargetHookIsEnabled()));
    }

    @Test
    void isHidden() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isHidden(playerId)));
    }

    @Test
    void getStrength() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStrength(playerId)));
    }

    @Test
    void getIntelligence() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getIntelligence(playerId)));
    }

    @Test
    void getMaxHitPoints() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxHitPoints(playerId)));
    }

    @Test
    void getMana() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMana(playerId)));
    }

    @Test
    void getMaxMana() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxMana(playerId)));
    }

    @Test
    void getStamina() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getStamina(playerId)));
    }

    @Test
    void getMaxStamina() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getMaxStamina(playerId)));
    }

    @Test
    void isDead() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isDead(playerId)));
    }

    @Test
    void isPoisoned() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isPoisoned(playerId)));
    }

    @Test
    void isParalyzed() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().isParalyzed(playerId)));
    }

    @Test
    void getSkillById() {
        final int id = SkillType.ANIMAL_LORE.getId();
        Assertions.assertDoesNotThrow(() ->
                log(getClient().getSkillById(id)));
    }

    @Test
    void getDexterity() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getDexterity(playerId)));
    }

    @Test
    void getHitPoints() {
        final long playerId = getClient().getPlayerID();

        Assertions.assertDoesNotThrow(() ->
                log(getClient().getHitPoints(playerId)));
    }


    @Test
    void setItemInfoEvent() {
        final ExtendedEventAction<ItemInfoEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setItemInfoEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setItemInfoEvent(null));
    }

    @Test
    void setItemDeletedEvent() {
        final ExtendedEventAction<ItemDeletedEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setItemDeletedEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setItemDeletedEvent(null));
    }

    @Test
    void setSpeechEvent() {
        final ExtendedEventAction<SpeechEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setSpeechEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setSpeechEvent(null));
    }


    @Test
    void setDrawPlayerEvent() {
        final ExtendedEventAction<DrawGamePlayerEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawPlayerEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawPlayerEvent(null));
    }


    @Test
    void setUpdateCharacterEvent() {
        final ExtendedEventAction<UpdateCharEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setUpdateCharacterEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setUpdateCharacterEvent(null));
    }


    @Test
    void setDrawObjectEvent() {
        final ExtendedEventAction<DrawObjectEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawObjectEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawObjectEvent(null));
    }


    @Test
    void setAddMultipleItemsInContainerEvent() {
        final ExtendedEventAction<AddMultipleItemsInContainerEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setAddMultipleItemsInContainerEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setAddMultipleItemsInContainerEvent(null));
    }

    @Test
    void setWindowsMessageEvent() {
        final ExtendedEventAction<WindowsMessageEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setWindowsMessageEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setWindowsMessageEvent(null));
    }

    @Test
    void setClientSendResyncEvent() {
        final EventAction action = client1 -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setClientSendResyncEvent(action));

        Assertions.assertDoesNotThrow(() ->
                getClient().setClientSendResyncEvent(null));
    }

    @Test
    void setMoveRejectionEvent() {
        final ExtendedEventAction<MoveRejectionEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setMoveRejectionEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setMoveRejectionEvent(null));
    }

    @Test
    void setAddItemToContainerEvent() {
        final ExtendedEventAction<AddItemToContainerEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setAddItemToContainerEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setAddItemToContainerEvent(null));
    }

    @Test
    void setDrawContainerEvent() {
        final ExtendedEventAction<DrawContainerEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawContainerEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setDrawContainerEvent(null));
    }

    @Test
    void setRejectMoveItemEvent() {
        final ExtendedEventAction<RejectMoveItemEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setRejectMoveItemEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setRejectMoveItemEvent(null));
    }

    @Test
    void setMenuEvent() {
        final ExtendedEventAction<MenuEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setMenuEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setMenuEvent(null));
    }

    @Test
    void setMapMessageEvent() {
        final ExtendedEventAction<MapMessageEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setMapMessageEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setMapMessageEvent(null));
    }

    @Test
    void setAllowRefuseAttackEvent() {
        final ExtendedEventAction<AllowRefuseAttackEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setAllowRefuseAttackEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setAllowRefuseAttackEvent(null));
    }

    @Test
    void setClilocSpeechEvent() {
        final ExtendedEventAction<ClilocSpeechEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setClilocSpeechEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setClilocSpeechEvent(null));
    }

    @Test
    void setClilocSpeechAffixEvent() {
        final ExtendedEventAction<ClilocSpeechAffixEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setClilocSpeechAffixEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setClilocSpeechAffixEvent(null));
    }

    @Test
    void setUnicodeSpeechEvent() {
        final ExtendedEventAction<UnicodeSpeechEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setUnicodeSpeechEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setUnicodeSpeechEvent(null));
    }

    @Test
    void setBuffDebuffSystemEvent() {
        final ExtendedEventAction<BuffDebuffSystemEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setBuffDebuffSystemEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setBuffDebuffSystemEvent(null));
    }

    @Test
    void setCharAnimationEvent() {
        final ExtendedEventAction<CharAnimationEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setCharAnimationEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setCharAnimationEvent(null));
    }

    @Test
    void setIncomingGumpEvent() {
        final ExtendedEventAction<IncomingGumpEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setIncomingGumpEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setIncomingGumpEvent(null));
    }

    @Test
    void setSoundEvent() {
        final ExtendedEventAction<SoundEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setSoundEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setSoundEvent(null));
    }

    @Test
    void setDeathEvent() {
        final ExtendedEventAction<DeathEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setDeathEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setDeathEvent(null));
    }

    @Test
    void setQuestArrowEvent() {
        final ExtendedEventAction<QuestArrowEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setQuestArrowEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setClilocSpeechEvent(null));
    }

    @Test
    void setGlobalChatEvent() {
        final ExtendedEventAction<GlobalChatEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setGlobalChatEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setGlobalChatEvent(null));
    }

    @Test
    void setGraphicalEffectEvent() {
        final ExtendedEventAction<GraphicalEffectEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setGraphicalEffectEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setGraphicalEffectEvent(null));
    }

    @Test
    void setGumpTextEntryEvent() {
        final ExtendedEventAction<GumpTextEntryEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setGumpTextEntryEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setGumpTextEntryEvent(null));
    }

    @Test
    void setIrcIncomingTextEvent() {
        final ExtendedEventAction<IRCIncomingTextEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setIrcIncomingTextEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setIrcIncomingTextEvent(null));
    }

    @Test
    void setMapPinEvent() {
        final ExtendedEventAction<MapPinEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setMapPinEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setMapPinEvent(null));
    }

    @Test
    void setPartyInviteEvent() {
        final ExtendedEventAction<PartyInviteEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setPartyInviteEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setPartyInviteEvent(null));
    }

    @Test
    void setSetGlobalVarEvent() {
        final ExtendedEventAction<SetGlobalVarEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setSetGlobalVarEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setSetGlobalVarEvent(null));
    }

    @Test
    void setObjectStatusEvent() {
        final ExtendedEventAction<UpdateObjectStatusEvent> event = (client1, eventData) -> {
        };

        Assertions.assertDoesNotThrow(() ->
                getClient().setObjectStatusEvent(event));

        Assertions.assertDoesNotThrow(() ->
                getClient().setObjectStatusEvent(null));
    }
}