package codyhuh.unusualfishmod.common.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class WeatherShellItem extends Item {
    private final String weather;

    public WeatherShellItem(String weather, Properties builder) {
        super(builder);
        this.weather = weather;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity holder, int duration) {

        if (holder instanceof Player player) {
            InteractionHand hand = player.getUsedItemHand();

            if (level instanceof ServerLevel sl) {
                if (weather.equals("thunder") && !level.getLevelData().isThundering()) {
                    sl.setWeatherParameters(0, 1200, true, true);
                    stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(hand));
                }
                else if (weather.equals("rain") && !level.getLevelData().isRaining()) {
                    sl.setWeatherParameters(0, 1200, true, false);
                    stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(hand));
                }
                else if (weather.equals("clear") && (level.getLevelData().isRaining() || level.getLevelData().isThundering())) {
                    sl.setWeatherParameters(36000, 0, false, false);
                    stack.hurtAndBreak(1, player, (e) -> e.broadcastBreakEvent(hand));
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!player.isUsingItem() && !player.getCooldowns().isOnCooldown(stack.getItem())) {
            player.startUsingItem(hand);
            player.playSound(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(1), 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, getUseDuration(stack));
        }

        return InteractionResultHolder.success(stack);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.TOOT_HORN;
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 40;
    }

}
