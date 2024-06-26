package net.builderdog.ancient_aether.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.entity.projectile.SporeBomb;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class SporeBombModel<T extends SporeBomb> extends EntityModel<T> {
    private final ModelPart sporeBomb;

    public SporeBombModel(ModelPart root) {
        sporeBomb = root.getChild("spore_bomb");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("spore_bomb", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -7.0F, 2.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(2.0F, -7.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -7.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(@NotNull SporeBomb entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer consumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        sporeBomb.render(poseStack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}