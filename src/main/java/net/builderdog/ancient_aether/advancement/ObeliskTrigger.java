package net.builderdog.ancient_aether.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.util.ExtraCodecs;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ObeliskTrigger extends SimpleCriterionTrigger<ObeliskTrigger.Instance> {
    @Override
    public @NotNull Codec<Instance> codec() {
        return Instance.CODEC;
    }

    public void trigger() {}

    public record Instance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<ObeliskTrigger.Instance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                        ExtraCodecs.strictOptionalField(EntityPredicate.ADVANCEMENT_CODEC, "player").forGetter(ObeliskTrigger.Instance::player))
                .apply(instance, ObeliskTrigger.Instance::new));
    }
}