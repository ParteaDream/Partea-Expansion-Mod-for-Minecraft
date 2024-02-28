package partea.partea_expansion.mixin.enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.EnchantVigour;

@Mixin(PlayerEntity.class)
public abstract class VigourMixin {

    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    private final DefaultedList<ItemStack> cache = DefaultedList.ofSize(4, ItemStack.EMPTY);

    @Inject(method = "tick", at = @At("HEAD"))
    private void tickTank(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        int i = 0;
        for (ItemStack stack : getArmorItems()) {
            ItemStack cacheStack = cache.get(i);
            if (cacheStack.getItem() != stack.getItem()) {
                if (EnchantmentHelper.getLevel(EnchantVigour.VIGOUR, cacheStack) > 0 && player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, EnchantVigour.ATTRIBUTE_UUID)) {
                    player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(EnchantVigour.ATTRIBUTE_UUID);
                }
                cache.set(i, stack.copy());
            }
            ++i;
        }

        int lvl = EnchantmentHelper.getLevel(EnchantVigour.VIGOUR, player.getEquippedStack(EquipmentSlot.CHEST));
        if (lvl > 0 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, EnchantVigour.ATTRIBUTE_UUID)) {
            EntityAttributeModifier modifier = new EntityAttributeModifier(EnchantVigour.ATTRIBUTE_UUID, "Tank Enchantment", 1D * lvl, EntityAttributeModifier.Operation.ADDITION);
            player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(modifier);
        }
    }
}
