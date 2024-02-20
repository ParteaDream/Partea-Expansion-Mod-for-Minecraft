package partea.partea_expansion.util;
import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;

import java.util.function.Consumer;

public class InteracticConfig extends ConfigWrapper<partea.partea_expansion.Plugins.interactic.util.InteracticConfigModel> {

    public final Keys keys = new Keys();

    private final Option<Boolean> clientOnlyMode = this.optionForKey(this.keys.clientOnlyMode);
    private final Option<Boolean> rightClickPickup = this.optionForKey(this.keys.rightClickPickup);
    private final Option<Boolean> itemThrowing = this.optionForKey(this.keys.itemThrowing);
    private final Option<Boolean> itemFilterEnabled = this.optionForKey(this.keys.itemFilterEnabled);
    private final Option<Boolean> itemsActAsProjectiles = this.optionForKey(this.keys.itemsActAsProjectiles);
    private final Option<Boolean> autoPickup = this.optionForKey(this.keys.autoPickup);
    private final Option<Boolean> fancyItemRendering = this.optionForKey(this.keys.fancyItemRendering);
    private final Option<Boolean> renderItemTooltips = this.optionForKey(this.keys.renderItemTooltips);
    private final Option<Boolean> renderFullTooltip = this.optionForKey(this.keys.renderFullTooltip);
    private final Option<Boolean> swingArm = this.optionForKey(this.keys.swingArm);
    private final Option<Boolean> blocksLayFlat = this.optionForKey(this.keys.blocksLayFlat);

    private InteracticConfig() {
        super(partea.partea_expansion.Plugins.interactic.util.InteracticConfigModel.class);
    }

    private InteracticConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(partea.partea_expansion.Plugins.interactic.util.InteracticConfigModel.class, janksonBuilder);
    }

    public static InteracticConfig createAndLoad() {
        var wrapper = new InteracticConfig();
        wrapper.load();
        return wrapper;
    }

    public static InteracticConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new InteracticConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public boolean clientOnlyMode() {
        return clientOnlyMode.value();
    }

    public void clientOnlyMode(boolean value) {
        clientOnlyMode.set(value);
    }

    public void subscribeToClientOnlyMode(Consumer<Boolean> subscriber) {
        clientOnlyMode.observe(subscriber);
    }

    public boolean rightClickPickup() {
        return rightClickPickup.value();
    }

    public void rightClickPickup(boolean value) {
        rightClickPickup.set(value);
    }

    public void subscribeToRightClickPickup(Consumer<Boolean> subscriber) {
        rightClickPickup.observe(subscriber);
    }

    public boolean itemThrowing() {
        return itemThrowing.value();
    }

    public void itemThrowing(boolean value) {
        itemThrowing.set(value);
    }

    public void subscribeToItemThrowing(Consumer<Boolean> subscriber) {
        itemThrowing.observe(subscriber);
    }

    public boolean itemFilterEnabled() {
        return itemFilterEnabled.value();
    }

    public void itemFilterEnabled(boolean value) {
        itemFilterEnabled.set(value);
    }

    public void subscribeToItemFilterEnabled(Consumer<Boolean> subscriber) {
        itemFilterEnabled.observe(subscriber);
    }

    public boolean itemsActAsProjectiles() {
        return itemsActAsProjectiles.value();
    }

    public void itemsActAsProjectiles(boolean value) {
        itemsActAsProjectiles.set(value);
    }

    public void subscribeToItemsActAsProjectiles(Consumer<Boolean> subscriber) {
        itemsActAsProjectiles.observe(subscriber);
    }

    public boolean autoPickup() {
        return autoPickup.value();
    }

    public void autoPickup(boolean value) {
        autoPickup.set(value);
    }

    public void subscribeToAutoPickup(Consumer<Boolean> subscriber) {
        autoPickup.observe(subscriber);
    }

    public boolean fancyItemRendering() {
        return fancyItemRendering.value();
    }

    public void fancyItemRendering(boolean value) {
        fancyItemRendering.set(value);
    }

    public boolean renderItemTooltips() {
        return renderItemTooltips.value();
    }

    public void renderItemTooltips(boolean value) {
        renderItemTooltips.set(value);
    }

    public boolean renderFullTooltip() {
        return renderFullTooltip.value();
    }

    public void renderFullTooltip(boolean value) {
        renderFullTooltip.set(value);
    }

    public boolean swingArm() {
        return swingArm.value();
    }

    public void swingArm(boolean value) {
        swingArm.set(value);
    }

    public boolean blocksLayFlat() {
        return blocksLayFlat.value();
    }

    public void blocksLayFlat(boolean value) {
        blocksLayFlat.set(value);
    }


    public static class Keys {
        public final Option.Key clientOnlyMode = new Option.Key("clientOnlyMode");
        public final Option.Key rightClickPickup = new Option.Key("rightClickPickup");
        public final Option.Key itemThrowing = new Option.Key("itemThrowing");
        public final Option.Key itemFilterEnabled = new Option.Key("itemFilterEnabled");
        public final Option.Key itemsActAsProjectiles = new Option.Key("itemsActAsProjectiles");
        public final Option.Key autoPickup = new Option.Key("autoPickup");
        public final Option.Key fancyItemRendering = new Option.Key("fancyItemRendering");
        public final Option.Key renderItemTooltips = new Option.Key("renderItemTooltips");
        public final Option.Key renderFullTooltip = new Option.Key("renderFullTooltip");
        public final Option.Key swingArm = new Option.Key("swingArm");
        public final Option.Key blocksLayFlat = new Option.Key("blocksLayFlat");
    }
}

