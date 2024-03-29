package partea.partea_expansion.Plugins.interactic.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import partea.partea_expansion.ParteaExpansion;
import partea.partea_expansion.Plugins.interactic.ItemFilterItem;
import partea.partea_expansion.mixin.interacic.PlayerInventoryAccessor;

import java.util.Collection;
import java.util.List;

public class Helpers {

    public static ItemEntity raycastItem(Entity camera, float reach) {
        Vec3d normalizedFacing = camera.getRotationVec(1.0F);
        Vec3d denormalizedFacing = camera.getCameraPosVec(0).add(normalizedFacing.x * reach, normalizedFacing.y * reach, normalizedFacing.z * reach);

        final EntityHitResult result = ProjectileUtil.raycast(camera, camera.getCameraPosVec(0), denormalizedFacing,
                camera.getBoundingBox().stretch(normalizedFacing.multiply(reach)).expand(1), entity -> entity instanceof ItemEntity, reach * reach);

        if (result != null) {
            var distance = camera.getPos().distanceTo(result.getPos()) - .3;
            if (camera.raycast(distance, 1f, false) instanceof BlockHitResult blockResult) {
                if (!camera.getWorld().getBlockState(blockResult.getBlockPos()).getCollisionShape(camera.getWorld(), blockResult.getBlockPos()).isEmpty()) {
                    return null;
                }
            }
        }

        return result == null ? null : (ItemEntity) result.getEntity();
    }

    public static boolean canPlayerPickUpItem(PlayerEntity player, ItemEntity item) {
        if (!ParteaExpansion.getConfig().autoPickup() && player.isSneaking() && !item.getCommandTags().contains("partea_expansion.ignore_auto_pickup_rule")) {
            return true;
        }
        if (ParteaExpansion.getConfig().itemFilterEnabled()) return true;
        var filters = ((PlayerInventoryAccessor) player.getInventory()).getCombinedInventory().stream()
                .flatMap(Collection::stream)
                .filter(stack -> stack.isOf(ParteaExpansion.getItemFilter()))
                .filter(stack -> {
                    if (stack.getNbt() != null) {
                        return stack.hasNbt() && stack.getNbt().getBoolean("Enabled");
                    }
                    return false;
                })
                .map(stack -> {
                    if (stack.getNbt() != null) {
                        return new FilterEntry(stack, ItemFilterItem.getItemsInFilter(stack), stack.getNbt().getBoolean("BlockMode"));
                    }
                    return null;
                })
                .toList();

        if (filters.isEmpty()) return true;

        var allowed = filters.stream().allMatch(FilterEntry::blockMode);
        for (var entry : filters) {
            if (entry.blockMode) continue;

            if (entry.filterItems.contains(item.getStack().getItem())) {
                return true;
            }
        }

        if (!allowed) return false;

        for (var entry : filters) {
            if (!entry.blockMode) continue;

            if (entry.filterItems.contains(item.getStack().getItem())) {
                return false;
            }
        }

        return true;
    }

    private record FilterEntry(ItemStack filter, List<Item> filterItems, boolean blockMode) {}
}
