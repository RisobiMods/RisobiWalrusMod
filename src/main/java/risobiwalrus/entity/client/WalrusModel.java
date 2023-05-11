package risobiwalrus.entity.client;

import net.minecraft.resources.ResourceLocation;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.entity.custom.WalrusEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WalrusModel extends AnimatedGeoModel<WalrusEntity> {
    @Override
    public ResourceLocation getModelLocation(WalrusEntity object) {
        return new ResourceLocation(RisobiWalrusMain.MOD_ID, "geo/walrus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WalrusEntity object) {
        return new ResourceLocation(RisobiWalrusMain.MOD_ID, "textures/entity/walrus/skintone.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WalrusEntity animatable) {
        return new ResourceLocation(RisobiWalrusMain.MOD_ID, "animations/walrus.animation.json");
    }
}
