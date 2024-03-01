package partea.partea_expansion.world.biome;

import net.minecraft.util.Identifier;
import partea.partea_expansion.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier("partea_expansion","overworld"),4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,"partea_expansion", ModMaterialRules.makeRules());
    }
}
