package net.builderdog.ancient_aether.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.entity.boss.ancient_guardian.AncientGuardian;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class AncientGuardianModel<T extends AncientGuardian> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ancient_aether", "ancient_guardian"), "main");
    private final ModelPart bone;
    public AncientGuardianModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -53.0F, -8.0F, 34.0F, 44.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(-16.0F, -28.0F, -7.0F, 32.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(72, 78).addBox(-9.0F, -68.0F, -7.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(92, 42).addBox(-8.0F, -67.0F, -6.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(132, 86).addBox(-9.0F, -48.0F, 13.0F, 20.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(132, 78).addBox(-9.0F, -76.0F, 13.0F, 20.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(84, 0).addBox(-56.0F, -57.0F, 12.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 98).addBox(13.0F, -50.0F, 18.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 134).addBox(15.0F, -33.0F, 20.0F, 14.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(56, 150).addBox(-28.0F, -33.0F, 20.0F, 14.0F, 24.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(56, 118).addBox(-29.0F, -49.0F, 19.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(120, 118).addBox(14.0F, -49.0F, 19.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(100, 0).addBox(-30.0F, -50.0F, 18.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 192, 192);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}