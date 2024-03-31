package net.builderdog.ancient_aether.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.entity.passive.Fluffalo;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class FluffaloModel<T extends Fluffalo> extends EntityModel<T> {

    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart head;
    private final ModelPart fluffalo;

    public FluffaloModel(ModelPart root) {
        fluffalo = root.getChild("fluffalo");
        head = fluffalo.getChild("head");
        leftFrontLeg = fluffalo.getChild("left_front_leg");
        rightFrontLeg = fluffalo.getChild("right_front_leg");
        leftHindLeg = fluffalo.getChild("left_hind_leg");
        rightHindLeg = fluffalo.getChild("right_hind_leg");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition fluffalo = partdefinition.addOrReplaceChild("fluffalo", CubeListBuilder.create(), PartPose.offset(6.0F, 14.0F, 10.0F));

        fluffalo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 77).addBox(-5.0F, -5.0F, -4.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(63, 0).addBox(-10.0F, -10.0F, 1.0F, 20.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(76, 77).addBox(-5.0F, 0.0F, -9.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(8, 34).addBox(5.0F, -3.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-8.0F, -3.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -13.0F, -26.0F));

        fluffalo.addOrReplaceChild("outer_body", CubeListBuilder.create().texOffs(63, 53).addBox(-16.0F, -11.0F, -7.0F, 20.0F, 13.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-17.0F, -13.0F, -25.0F, 22.0F, 15.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(63, 10).addBox(-16.0F, 2.0F, 4.0F, 20.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 46).addBox(-17.0F, 2.0F, -6.0F, 22.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 42).addBox(-17.0F, 2.0F, -25.0F, 22.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(57, 19).addBox(5.0F, 2.0F, -25.0F, 0.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(57, 15).addBox(-17.0F, 2.0F, -25.0F, 0.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(20, 75).addBox(-16.0F, 2.0F, -6.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 75).addBox(4.0F, 2.0F, -6.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        fluffalo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 64).addBox(-9.0F, -20.0F, 3.0F, 18.0F, 11.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-10.0F, -22.0F, -14.0F, 20.0F, 13.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 10.0F, -10.0F));

        fluffalo.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        fluffalo.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        fluffalo.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));
        fluffalo.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, -20.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void prepareMobModel(@NotNull T p_103687_, float p_103688_, float p_103689_, float p_103690_) {
        super.prepareMobModel(p_103687_, p_103688_, p_103689_, p_103690_);
        head.y = 4.0F + p_103687_.getHeadEatPositionScale(p_103690_) * 4.0F;
        head.xRot = p_103687_.getHeadEatAngleScale(p_103690_);
    }

    @Override
    public void setupAnim(@Nonnull Fluffalo fluffalo, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        head.yRot = netHeadYaw * 0.017453292F;
        head.xRot = headPitch * 0.017453292F;
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer consumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        fluffalo.render(poseStack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}