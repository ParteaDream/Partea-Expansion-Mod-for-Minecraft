package partea.partea_expansion.Plugins.interactic;

import partea.partea_expansion.ParteaExpansion;
import partea.partea_expansion.Plugins.interactic.util.ServerSideConfigOption;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.ui.ConfigScreen;
import io.wispforest.owo.config.ui.OptionComponentFactory;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class InteracticConfigScreen extends ConfigScreen {

    public InteracticConfigScreen(@Nullable Screen parent) {
        super(DEFAULT_MODEL_ID, ParteaExpansion.getConfig(), parent);
    }

    @Override
    protected @Nullable OptionComponentFactory<?> factoryForOption(Option<?> option) {
        return ParteaExpansion.getConfig().clientOnlyMode() && option.backingField().hasAnnotation(ServerSideConfigOption.class)
                ? null
                : super.factoryForOption(option);
    }
}
