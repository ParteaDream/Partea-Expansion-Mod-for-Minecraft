package partea.partea_expansion.CustomItems.CustomMaskItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Objects;

public class CustomFoolsMaskItem extends ArmorItem {
    public CustomFoolsMaskItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
}
