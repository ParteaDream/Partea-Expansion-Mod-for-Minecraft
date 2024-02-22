package partea.partea_expansion.CustomItems;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ModNightVisionGlassesItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_STATUS_EFFECT_INSTANCE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial,StatusEffectInstance>())
                    .put(ModArmorMaterial.NIGHT_VISION_GLASSES,new StatusEffectInstance(StatusEffects.NIGHT_VISION,220,0,
                            false,false,false)).build();
    public ModNightVisionGlassesItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial,StatusEffectInstance> entry : MATERIAL_STATUS_EFFECT_INSTANCE_MAP.entrySet()){
            ArmorMaterial armorMaterial = entry.getKey();
            StatusEffectInstance statusEffectInstance = entry.getValue();

            if (hasCorrectArmorOn(armorMaterial,player)){
                addStatusEffectForMaterial(player,armorMaterial,statusEffectInstance);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial armorMaterial, StatusEffectInstance statusEffectInstance) {
        boolean hasEffects = player.hasStatusEffect(statusEffectInstance.getEffectType());
        if(hasCorrectArmorOn(armorMaterial,player) ){
            player.addStatusEffect(new StatusEffectInstance(statusEffectInstance));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, PlayerEntity player) {
        ItemStack a = player.getEquippedStack(EquipmentSlot.HEAD);
        for (ItemStack armorStack:player.getInventory().armor){
            if(!(a.getItem().getMaxDamage() == 275)){
                System.out.println(2);
                return false;
            }
        }
        System.out.println(1);
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        return helmet.getMaterial() == material;
    }
}
