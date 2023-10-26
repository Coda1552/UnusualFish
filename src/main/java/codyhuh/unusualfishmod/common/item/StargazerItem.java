package codyhuh.unusualfishmod.common.item;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StargazerItem extends Item {

    public StargazerItem(Properties p_151205_) {
        super(p_151205_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {

            /*
              0t = 0.75
              6000t = 0.0
              12000t = 0.25
              18000t = 0.5
             */

            var time = level.getDayTime() % 24000; // Correct
            var i = Mth.frac((double)time / 24000.0D - 0.25D); //
            var i1 = 0.5D - Math.cos(i * Math.PI) / 2.0D;
            var i2 = (float)(i * 2.0D + i1) / 3.0F;
            System.out.println("time of day: " + level.getTimeOfDay(1.0F));


            if (level.getSunAngle(1.0F) == player.getXRot()) {
                System.out.println("IT WORKED!");

            }

        }

        return super.use(level, player, hand);
    }
}
