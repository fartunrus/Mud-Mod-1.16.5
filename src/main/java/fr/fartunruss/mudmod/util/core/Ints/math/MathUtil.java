package fr.fartunruss.mudmod.util.core.Ints.math;

import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MathUtil extends MathHelper {
    public static int randomBetweenInclusive(Random p_216288_, int p_216289_, int p_216290_) {
        return p_216288_.nextInt(p_216290_ - p_216289_ + 1) + p_216289_;
    }
    public static float normal(Random p_216292_, float p_216293_, float p_216294_) {
        return p_216293_ + (float)p_216292_.nextGaussian() * p_216294_;
    }
}
