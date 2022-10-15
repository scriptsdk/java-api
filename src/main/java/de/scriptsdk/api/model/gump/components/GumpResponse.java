package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class GumpResponse implements Deserializable {
    private Integer serial = 0;
    private Long gumpId = 0L;
    private Integer x;
    private Integer y;
    private Integer pages = 0;
    private Boolean movable = false;
    private Boolean resizable = false;
    private Boolean disposable = false;
    private Boolean closable = false;
    private List<GroupResponse> groups = new ArrayList<>();
    private List<GroupResponse> endGroups = new ArrayList<>();
    private List<GumpButtonResponse> buttons = new ArrayList<>();
    private List<ButtonTileArtResponse> buttonTileArts = new ArrayList<>();
    private List<CheckBoxResponse> checkBoxes = new ArrayList<>();
    private List<CheckerTransResponse> checkerTrans = new ArrayList<>();
    private List<CroppedTextResponse> croppedTexts = new ArrayList<>();
    private List<GumpPictureResponse> gumpPictures = new ArrayList<>();
    private List<GumpTilePictureResponse> gumpTilePictures = new ArrayList<>();
    private List<RadioButtonResponse> radioButtons = new ArrayList<>();
    private List<ResizablePictureResponse> resizablePictures = new ArrayList<>();
    private List<GumpTextResponse> gumpTexts = new ArrayList<>();
    private List<TextEntryResponse> textEntries = new ArrayList<>();
    private List<String> texts = new ArrayList<>();
    private List<LimitedTextEntryResponse> limitedTextEntries = new ArrayList<>();
    private List<TilePictureResponse> tilePictures = new ArrayList<>();
    private List<HuedTilePictureResponse> huedTilePictures = new ArrayList<>();
    private List<GumpTooltipResponse> gumpTooltips = new ArrayList<>();
    private List<HtmlGumpResponse> htmlGumps = new ArrayList<>();
    private List<XmfHtmlGumpResponse> xmfHtmlGumps = new ArrayList<>();
    private List<XmfHtmlGumpColorResponse> xmfHtmlGumpColors = new ArrayList<>();
    private List<XmfHtmlTokenResponse> xmfHtmlTokens = new ArrayList<>();
    private List<ItemPropertyResponse> itemProperties = new ArrayList<>();
    private List<PictureInPictureResponse> pictureInPictures = new ArrayList<>();
    private List<TilePictureAsGumpPictureResponse> tilePictureAsGumpPictures = new ArrayList<>();
    private List<UpperWordCaseToggleResponse> upperWordCaseToggles = new ArrayList<>();
    private List<HuedGumpPictureResponse> huedGumpPictures = new ArrayList<>();

    @Override
    public void deserialize(PacketReader reader) {
        this.setSerial(reader.readInteger());
        this.setGumpId(reader.readCardinal());
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setPages(reader.readInteger());
        this.setMovable(!reader.readBoolean());
        this.setResizable(!reader.readBoolean());
        this.setDisposable(!reader.readBoolean());
        this.setClosable(!reader.readBoolean());

        this.setGroups(reader.readList(subReader ->
                subReader.readObject(GroupResponse.class), reader.readInteger()));

        this.setEndGroups(reader.readList(subReader ->
                subReader.readObject(GroupResponse.class), reader.readInteger()));

        this.setButtons(reader.readList(subReader ->
                subReader.readObject(GumpButtonResponse.class), reader.readInteger()));

        this.setButtonTileArts(reader.readList(subReader ->
                subReader.readObject(ButtonTileArtResponse.class), reader.readInteger()));

        this.setCheckBoxes(reader.readList(subReader ->
                subReader.readObject(CheckBoxResponse.class), reader.readInteger()));

        this.setCheckerTrans(reader.readList(subReader ->
                subReader.readObject(CheckerTransResponse.class), reader.readInteger()));

        this.setCroppedTexts(reader.readList(subReader ->
                subReader.readObject(CroppedTextResponse.class), reader.readInteger()));

        this.setGumpPictures(reader.readList(subReader ->
                subReader.readObject(GumpPictureResponse.class), reader.readInteger()));

        this.setGumpTilePictures(reader.readList(subReader ->
                subReader.readObject(GumpTilePictureResponse.class), reader.readInteger()));

        this.setRadioButtons(reader.readList(subReader ->
                subReader.readObject(RadioButtonResponse.class), reader.readInteger()));

        this.setResizablePictures(reader.readList(subReader ->
                subReader.readObject(ResizablePictureResponse.class), reader.readInteger()));

        this.setGumpTexts(reader.readList(subReader ->
                subReader.readObject(GumpTextResponse.class), reader.readInteger()));

        this.setTextEntries(reader.readList(subReader ->
                subReader.readObject(TextEntryResponse.class), reader.readInteger()));

        this.setTexts(reader.readList(PacketReader::readString, reader.readInteger()));

        this.setLimitedTextEntries(reader.readList(subReader ->
                subReader.readObject(LimitedTextEntryResponse.class), reader.readInteger()));

        this.setTilePictures(reader.readList(subReader ->
                subReader.readObject(TilePictureResponse.class), reader.readInteger()));

        this.setHuedTilePictures(reader.readList(subReader ->
                subReader.readObject(HuedTilePictureResponse.class), reader.readInteger()));

        this.setGumpTooltips(reader.readList(subReader ->
                subReader.readObject(GumpTooltipResponse.class), reader.readInteger()));

        this.setHtmlGumps(reader.readList(subReader ->
                subReader.readObject(HtmlGumpResponse.class), reader.readInteger()));

        this.setXmfHtmlGumps(reader.readList(subReader ->
                subReader.readObject(XmfHtmlGumpResponse.class), reader.readInteger()));

        this.setXmfHtmlGumpColors(reader.readList(subReader ->
                subReader.readObject(XmfHtmlGumpColorResponse.class), reader.readInteger()));

        this.setXmfHtmlTokens(reader.readList(subReader ->
                subReader.readObject(XmfHtmlTokenResponse.class), reader.readInteger()));

        this.setItemProperties(reader.readList(subReader ->
                subReader.readObject(ItemPropertyResponse.class), reader.readInteger()));

        this.setPictureInPictures(reader.readList(subReader ->
                subReader.readObject(PictureInPictureResponse.class), reader.readInteger()));

        this.setTilePictureAsGumpPictures(reader.readList(subReader ->
                subReader.readObject(TilePictureAsGumpPictureResponse.class), reader.readInteger()));

        this.setUpperWordCaseToggles(reader.readList(subReader ->
                subReader.readObject(UpperWordCaseToggleResponse.class), reader.readInteger()));

        this.setHuedGumpPictures(reader.readList(subReader ->
                subReader.readObject(HuedGumpPictureResponse.class), reader.readInteger()));
    }
}
