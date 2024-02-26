package partea.partea_expansion.mixin.lapisreserve;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Plugins.lapisreserve.PlayerInterface;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerReserve extends PlayerEntity {
	public ServerPlayerReserve(World world, BlockPos pos, float yaw, GameProfile gameProfile, PlayerPublicKey publicKey) {
		super(world, pos, yaw, gameProfile);
	}

	@Inject(method = "copyFrom",at=@At("TAIL"))
	public void copyFrom(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo info) {
		((PlayerInterface)getInventory()).setLapisreserve(((PlayerInterface)oldPlayer.getInventory()).getLapisreserve());
	}
}
