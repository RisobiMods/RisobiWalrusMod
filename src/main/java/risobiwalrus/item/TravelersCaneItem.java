package risobiwalrus.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class TravelersCaneItem extends Item {
    public TravelersCaneItem(Item.Properties pProperties) {
        super(pProperties);

    }
    //this adds item description to mouse hover display
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }
    //grabbing description from en_us json
    public MutableComponent getDisplayName() {
        return new TranslatableComponent(this.getDescriptionId() + ".desc");
    }


    //this gives the player speed effect if the item is held in either main or off hand
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pItemSlot, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            if (pIsSelected || pEntity instanceof Player && ((Player)pEntity).getOffhandItem() == pStack) {
                Player player = (Player)pEntity;
                MobEffectInstance effect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1);
                player.addEffect(effect, player);
            }
        }
    }
   //this adds the enchantment glint to the item
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}

