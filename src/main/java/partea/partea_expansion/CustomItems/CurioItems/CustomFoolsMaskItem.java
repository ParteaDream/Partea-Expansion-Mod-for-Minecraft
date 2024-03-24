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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.CustomItems.ArmorItems.ModArmorMaterial;
import partea.partea_expansion.ModItems;

import java.util.List;
import java.util.Map;

public class CustomFoolsMaskItem extends ClassCurioArmor {
    public CustomFoolsMaskItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.fools_mask.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_STATUS_EFFECT_INSTANCE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial,StatusEffectInstance>())
                    .put(ModArmorMaterial.FOOLS_MASK,new StatusEffectInstance(StatusEffects.SPEED,20,4,
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
                ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);
                NbtCompound nbtCompound = stack.getOrCreateNbt();
                int level = nbtCompound.getInt("strengthLevel");
                if (level > 0){
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 10, level - 1));
                }
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
            if(a.getItem() != ModItems.FOOLS_MASK){
                return false;
            }
        }
        ArmorItem head = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());
        return head.getMaterial() == material;
    }

}
