package codyhuh.unusualfishmod.common.entity.hostile;

import codyhuh.unusualfishmod.core.registry.UFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.RandomSource;

public class Prawn extends Monster {

    public Prawn(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.6F).add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new Prawn.CustomAttackGoal());
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.6F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.6F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
        if (flag) {
            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

    protected SoundEvent getAmbientSound() {
        return UFSounds.EVIL_CHATTERING.get();
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SILVERFISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_28281_) {
        return SoundEvents.SILVERFISH_HURT;
    }

    protected void playStepSound(BlockPos p_33804_, BlockState p_33805_) {
        this.playSound(UFSounds.CRAB_SCUTTLING.get(), 0.15F, 1.0F);
    }

    public static boolean canSpawn(EntityType<Prawn> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return reason == MobSpawnType.SPAWNER || !iServerWorld.canSeeSky(pos) && pos.getY() <= 0 && checkMonsterSpawnRules(entityType, iServerWorld, reason, pos, random);
    }

    class CustomAttackGoal extends MeleeAttackGoal {
        public CustomAttackGoal() {
            super(Prawn.this, 1.0D, true);
        }

        protected double getAttackReachSqr(LivingEntity p_25556_) {
            return this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 1.0F + p_25556_.getBbWidth();
        }
    }
}
