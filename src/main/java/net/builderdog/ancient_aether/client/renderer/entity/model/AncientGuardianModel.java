package net.builderdog.ancient_aether.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.entity.monster.dungeon.boss.AncientGuardian;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class AncientGuardianModel<T extends AncientGuardian> extends EntityModel<T> {
    private final ModelPart bone;
    public AncientGuardianModel(ModelPart root) {
        bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -53.0F, -8.0F, 30.0F, 44.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(-14.0F, -28.0F, -7.0F, 28.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(64, 78).addBox(-10.0F, -68.0F, -7.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(84, 42).addBox(-9.0F, -67.0F, -6.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(124, 78).addBox(-10.0F, -48.0F, 13.0F, 20.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(124, 88).addBox(-10.0F, -76.0F, 13.0F, 20.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(92, 0).addBox(13.0F, -50.0F, 18.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 136).addBox(15.0F, -33.0F, 20.0F, 14.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(122, 136).addBox(-29.0F, -33.0F, 20.0F, 14.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(72, 118).addBox(-30.0F, -49.0F, 19.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(128, 102).addBox(14.0F, -49.0F, 19.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 100).addBox(-31.0F, -50.0F, 18.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}