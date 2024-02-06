package net.builderdog.ancient_aether.client.renderer.entity.model;

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
    private final ModelPart buffalo;

    public HighlandBuffaloModel(ModelPart root) {
        buffalo = root.getChild("buffalo");
        head = buffalo.getChild("head");
        leftFrontLeg = buffalo.getChild("left_front_leg");
        rightFrontLeg = buffalo.getChild("right_front_leg");
        leftHindLeg = buffalo.getChild("left_hind_leg");
        rightHindLeg = buffalo.getChild("right_hind_leg");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition buffalo = partdefinition.addOrReplaceChild("buffalo", CubeListBuilder.create(), PartPose.offset(6.0F, 14.0F, 10.0F));

        PartDefinition head = buffalo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 77).addBox(-5.0F, -5.0F, -4.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(63, 0).addBox(-10.0F, -10.0F, 1.0F, 20.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(76, 77).addBox(-5.0F, 0.0F, -9.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(8, 34).addBox(5.0F, -3.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-8.0F, -3.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -13.0F, -26.0F));

        PartDefinition outer_body = buffalo.addOrReplaceChild("outer_body", CubeListBuilder.create().texOffs(63, 53).addBox(-16.0F, -11.0F, -7.0F, 20.0F, 13.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-17.0F, -13.0F, -25.0F, 22.0F, 15.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(63, 10).addBox(-16.0F, 2.0F, 4.0F, 20.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 46).addBox(-17.0F, 2.0F, -6.0F, 22.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 42).addBox(-17.0F, 2.0F, -25.0F, 22.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 19).addBox(5.0F, 2.0F, -25.0F, 0.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(57, 15).addBox(-17.0F, 2.0F, -25.0F, 0.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(20, 75).addBox(-16.0F, 2.0F, -6.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 75).addBox(4.0F, 2.0F, -6.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = buffalo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 64).addBox(-9.0F, -20.0F, 3.0F, 18.0F, 11.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-10.0F, -22.0F, -14.0F, 20.0F, 13.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 10.0F, -10.0F));

        PartDefinition right_hind_leg = buffalo.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_hind_leg = buffalo.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_front_leg = buffalo.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));

        PartDefinition left_front_leg = buffalo.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, -20.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@Nonnull HighlandBuffalo buffalo, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        head.yRot = netHeadYaw * 0.017453292F;
        head.xRot = headPitch * 0.017453292F;
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer consumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        buffalo.render(poseStack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}