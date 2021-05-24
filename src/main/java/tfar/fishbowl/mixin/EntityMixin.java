package tfar.fishbowl.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.tags.ITag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.fishbowl.Fishbowl;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(at = @At("HEAD"), method = "areEyesInFluid",cancellable = true)
	private void init(ITag<Fluid> tagIn, CallbackInfoReturnable<Boolean> cir) {
		Entity entity = (Entity)(Object)this;
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == Fishbowl.FISH_BOWL) {
				cir.setReturnValue(true);
			}
		}
	}
}
