package risobiwalrus.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

public class WalkingCaneItem extends Item {
    public WalkingCaneItem(Properties pProperties) {
        super(pProperties);
    }

    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pItemSlot, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            if (pIsSelected || pEntity instanceof Player && ((Player)pEntity).getOffhandItem() == pStack) {
                Player player = (Player)pEntity;
                MobEffectInstance effect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1);
                player.addEffect(effect, player);
            }
        }
    }
}
