package mod.ckenja.tofucreate.register;

import baguchan.tofucraft.TofuCraftReload;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.function.Consumer;

public class ModAllFluids {
    public static final CreateRegistrate registrate = TofuCreate.registrate;

    public static final FluidEntry<VirtualFluid> SOYMILK_ANNIN =
            registrate.virtualFluid("soymilk_annin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFFFFF, 0xFFFFFF), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_APPLE =
            registrate.virtualFluid("soymilk_apple", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFEEDC85, 0xEEDC85), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_COCOA =
            registrate.virtualFluid("soymilk_cocoa", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFF8B3C0D, 0x8B3C0D), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_FRUITS =
            registrate.virtualFluid("soymilk_fruits", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFF7C00A, 0xF7C00A), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_HONEY =
            registrate.virtualFluid("soymilk_honey", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFA65B, 0xFFA65B), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_KINAKO =
            registrate.virtualFluid("soymilk_kinako", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFD3B92C, 0xD3B92C), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUDDING =
            registrate.virtualFluid("soymilk_pudding", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFEEDC85, 0xEEDC85), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUMPKIN =
            registrate.virtualFluid("soymilk_pumpkin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFA556, 0xFFA556), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_RAMUNE =
            registrate.virtualFluid("soymilk_ramune", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFF9EC4FB, 0x9EC4FB), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_SAKURA =
            registrate.virtualFluid("soymilk_sakura", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFBCED4, 0xFBCED4), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_TEA =
            registrate.virtualFluid("soymilk_tea", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFACF96, 0xFACF96), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_STRAWBERRY =
            registrate.virtualFluid("soymilk_strawberry", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFF0A1B4, 0xF0A1B4), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SOYOIL =
            registrate.virtualFluid("soyoil", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFFF00, 0xFFFF00), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> SHROOM =
            registrate.virtualFluid("shroom", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFEC07B, 0xFEC07B), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> CRIMSON_FLUID =
            registrate.virtualFluid("crimson_fluid", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFB12727, 0xB12727), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();

    public static final FluidEntry<VirtualFluid> WARPED_FLUID =
            registrate.virtualFluid("warped_fluid", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFF118066, 0x118066), ModAllFluids::createSource, ModAllFluids::createFlowing)
                    .register();
    public static void register() {
    }


    public static VirtualFluid createSource(ForgeFlowingFluid.Properties properties) {
        return new VirtualFluid(properties, true);
    }

    public static VirtualFluid createFlowing(ForgeFlowingFluid.Properties properties) {
        return new VirtualFluid(properties, false);
    }

    public static FluidBuilder.FluidTypeFactory create(int color) {
        return (p, s, f) -> {
            FluidType fluidType = defaultFluidType(p, s, f, color, color);
            return fluidType;
        };
    }

    public static FluidBuilder.FluidTypeFactory create(int color, int colorBlock) {
        return (p, s, f) -> {
            FluidType fluidType = defaultFluidType(p, s, f, color, colorBlock);
            return fluidType;
        };
    }

    public static FluidType defaultFluidType(FluidType.Properties properties, ResourceLocation stillTexture,
                                             ResourceLocation flowingTexture, int color, int colorBlock) {
        return new FluidType(properties) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return stillTexture;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return flowingTexture;
                    }

                    @Override
                    public int getTintColor(FluidStack stack) {
                        return color;
                    }

                    @Override
                    public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
                        return colorBlock;
                    }


                });
            }
        };
    }
}