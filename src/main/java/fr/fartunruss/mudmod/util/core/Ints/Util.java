package fr.fartunruss.mudmod.util.core.Ints;

import com.mojang.serialization.DataResult;
import net.minecraft.util.SharedConstants;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

public class Util extends net.minecraft.util.Util {
    private static Consumer<String> thePauser = (p_201905_) -> {
    };
    static final Logger LOGGER = (Logger) LogManager.getLogger();
    public static <T> DataResult<List<T>> fixedSize(List<T> p_143796_, int p_143797_) {
        if (p_143796_.size() != p_143797_) {
            String s = "Input is not a list of " + p_143797_ + " elements";
            return p_143796_.size() >= p_143797_ ? DataResult.error(s, p_143796_.subList(0, p_143797_)) : DataResult.error(s);
        } else {
            return DataResult.success(p_143796_);
        }
    }
    public static <T> T getRandom(List<T> p_214622_, Random p_214623_) {
        return p_214622_.get(p_214623_.nextInt(p_214622_.size()));
    }
    public static <T> Optional<T> getRandomSafe(List<T> p_214677_, Random p_214678_) {
        return p_214677_.isEmpty() ? Optional.empty() : Optional.of(getRandom(p_214677_, p_214678_));
    }
    public static void logAndPauseIfInIde(String p_143786_) {
        LOGGER.error(p_143786_);
        if (SharedConstants.IS_RUNNING_IN_IDE) {
            doPause(p_143786_);
        }

    }
    private static void doPause(String p_183985_) {
        Instant instant = Instant.now();
        LOGGER.warn("Did you remember to set a breakpoint here?");
        boolean flag = Duration.between(instant, Instant.now()).toMillis() > 500L;
        if (!flag) {
            thePauser.accept(p_183985_);
        }

    }
}
