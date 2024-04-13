package net.builderdog.ancient_aether.advancement;

import com.google.gson.JsonObject;
import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ObeliskTrigger extends SimpleCriterionTrigger<ObeliskTrigger.Instance> {
    private static final ResourceLocation ID = new ResourceLocation(AncientAether.MODID, "obelisk_trigger");
    public static final ObeliskTrigger INSTANCE = new ObeliskTrigger();

    @Override
    public @NotNull ResourceLocation getId() {
        return ID;
    }

    @Override
    public ObeliskTrigger.@NotNull Instance createInstance(JsonObject json, @NotNull ContextAwarePredicate predicate, @NotNull DeserializationContext context) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(json.get("item"));
        return new ObeliskTrigger.Instance(predicate, itemPredicate);
    }

    public void trigger(ServerPlayer player, ItemStack stack) {
        trigger(player, (instance) -> instance.test(stack));
    }

    public static class Instance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate item;

        public Instance(ContextAwarePredicate predicate, ItemPredicate item) {
            super(ObeliskTrigger.ID, predicate);
            this.item = item;
        }

        public static ObeliskTrigger.Instance activate() {
            return new ObeliskTrigger.Instance(ContextAwarePredicate.ANY, ItemPredicate.ANY);
        }

        public boolean test(ItemStack stack) {
            return item.matches(stack);
        }

        @Override
        public @NotNull JsonObject serializeToJson(@NotNull SerializationContext context) {
            JsonObject jsonObject = super.serializeToJson(context);
            jsonObject.add("item", item.serializeToJson());
            return jsonObject;
        }
    }
}