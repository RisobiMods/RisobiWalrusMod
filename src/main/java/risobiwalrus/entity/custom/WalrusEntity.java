package risobiwalrus.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;
import risobiwalrus.RisobiWalrusMain;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Random;

public class WalrusEntity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public static boolean checkWalrusSpawnRules(EntityType<WalrusEntity> pWalrusEntity, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, Random pRandom) {
        Holder<Biome> holder = pLevel.getBiome(pPos);

        double chance = Math.random();
        if (chance <= .1) {
            if (!holder.is(Biomes.FROZEN_OCEAN) && !holder.is(Biomes.DEEP_FROZEN_OCEAN)) {
                RisobiWalrusMain.LOGGER.info("amongus"+checkAnimalSpawnRules(pWalrusEntity, pLevel, pSpawnType, pPos, pRandom));
                return checkAnimalSpawnRules(pWalrusEntity, pLevel, pSpawnType, pPos, pRandom);
            } else {
                RisobiWalrusMain.LOGGER.info("" + (isBrightEnoughToSpawn(pLevel, pPos) && pLevel.getBlockState(pPos.below()).is(BlockTags.POLAR_BEARS_SPAWNABLE_ON_IN_FROZEN_OCEAN)));
                return isBrightEnoughToSpawn(pLevel, pPos) && pLevel.getBlockState(pPos.below()).is(BlockTags.GOATS_SPAWNABLE_ON);
            }
        }
        return false;
    }



    public WalrusEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob p_146744_) {
        return null;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walking.new", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("mouth_idle_test.new",true));
        return PlayState.CONTINUE;
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 4.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
