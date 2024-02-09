package net.builderdog.ancient_aether.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class AeronauticLeaperModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart aeronautic_leaper;

    public AeronauticLeaperModel(ModelPart root) {
        aeronautic_leaper = root.getChild("aeronautic_leaper");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition aerotic_leaper = partdefinition.addOrReplaceChild("aeronautic_leaper", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

        PartDefinition cube_r1 = aerotic_leaper.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 32).addBox(6.0F, -8.0F, -4.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        PartDefinition cube_r2 = aerotic_leaper.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, -12.0F, -2.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r3 = aerotic_leaper.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 22).addBox(-8.0F, -8.0F, -4.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        aeronautic_leaper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}