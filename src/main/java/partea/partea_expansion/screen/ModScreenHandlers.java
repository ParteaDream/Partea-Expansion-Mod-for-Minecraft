package partea.partea_expansion.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<QualitativeAnalyzerScreenHandler> QUALITATIVE_ANALYZER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier("partea_expansion","qualitative_analyzer"),
                    new ExtendedScreenHandlerType<>(QualitativeAnalyzerScreenHandler::new));
    public static void registerScreenHandlers(){

    }
}
