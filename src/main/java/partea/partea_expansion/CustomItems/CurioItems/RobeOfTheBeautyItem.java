package partea.partea_expansion.CustomItems.CurioItems;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.CustomItems.ArmorItems.ModArmorMaterial;
import partea.partea_expansion.ModItems;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RobeOfTheBeautyItem extends ArmorItem {
    public static int level = 0;
    public RobeOfTheBeautyItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    public static int countLevels(PlayerEntity player){
        int a = 0;
        for (int i = 0; i < 35; i++){
            if (player.getInventory().getStack(i).getItem() == ModItems.COIN){
                a += player.getInventory().getStack(i).getCount();
            }
        }
        a = a / 32;
        return a;
    }


    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_STATUS_EFFECT_INSTANCE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial,StatusEffectInstance>())
                    .put(ModArmorMaterial.ROBE_OF_THE_BEAUTY,new StatusEffectInstance(StatusEffects.LUCK,20,0,
                            false,false,false)).build();
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
        level = countLevels(player);
        if(hasCorrectArmorOn(armorMaterial,player)){
            player.addStatusEffect(new StatusEffectInstance(statusEffectInstance));
            if (level > 0){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, level - 1, false,false,false));
            }
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, PlayerEntity player) {
        ItemStack a = player.getEquippedStack(EquipmentSlot.CHEST);
        for (ItemStack armorStack:player.getInventory().armor){
            if(!(Objects.equals(a.getItem().getName(), Text.translatable("item.partea_expansion.robe_of_the_beauty")))){
                return false;
            }
        }
        ArmorItem chests = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        return chests.getMaterial() == material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.robe_of_the_beauty.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
