package net.builderdog.ancient_aether.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.entity.animals.HighlandBuffalo;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nonnull;

public class HighlandBuffaloModel<T extends HighlandBuffalo> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ancient_aether", "highland_buffalo"), "main");

    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart head;
    private final ModelPart highland_buffalo;

    public HighlandBuffaloModel(ModelPart root) {
        highland_buffalo = root.getChild("highland_buffalo");
        leftFrontLeg = highland_buffalo.getChild("left_front_leg");
        rightFrontLeg = highland_buffalo.getChild("right_front_leg");
        leftHindLeg = highland_buffalo.getChild("left_hind_leg");
        rightHindLeg = highland_buffalo.getChild("right_hind_leg");
        head = highland_buffalo.getChild("head");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition buffalo = partdefinition.addOrReplaceChild("highland_buffalo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition body = buffalo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -24.0F, -15.0F, 20.0F, 12.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(10.0F, -12.0F, -15.0F, 0.0F, 6.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(40, 64).addBox(-10.0F, -12.0F, -15.0F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 62).addBox(-10.0F, -12.0F, 15.0F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-10.0F, -12.0F, -15.0F, 0.0F, 6.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = buffalo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 12).addBox(-8.0F, -8.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 54).addBox(-10.0F, -14.0F, 1.0F, 20.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 9).addBox(5.0F, -8.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(50, 44).addBox(-5.0F, -10.0F, -4.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -16.0F));

        PartDefinition left_front_leg = buffalo.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(16, 68).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -10.0F, -10.0F));
        PartDefinition right_front_leg = buffalo.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(70, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -10.0F, -10.0F));
        PartDefinition left_hind_leg = buffalo.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 68).addBox(-14.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -10.0F, 10.0F));
        PartDefinition right_hind_leg = buffalo.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -10.0F, 10.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@Nonnull HighlandBuffalo buffalo, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        head.xRot = limbSwing * ((float)Math.PI / 180F);
        head.yRot = limbSwing * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer consumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        highland_buffalo.render(poseStack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}