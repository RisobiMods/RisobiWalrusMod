package risobiwalrus.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.entity.custom.WalrusEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WalrusRenderer extends GeoEntityRenderer<WalrusEntity> {
    public WalrusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WalrusModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(WalrusEntity instance) {
        return new ResourceLocation(RisobiWalrusMain.MOD_ID, "textures/entity/walrus/skintone.png");
    }

    @Override
    public RenderType getRenderType(WalrusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
