package tconstruct.library.crafting;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

public class FluidType {

    public final Block renderBlock;
    public final int renderMeta;
    public final int baseTemperature;
    public final Fluid fluid;
    public final boolean isToolpart;

    public static HashMap<String, FluidType> fluidTypes = new HashMap<>();

    public FluidType(Block block, int meta, int baseTemperature, Fluid fluid, boolean isToolpart) {
        this.renderBlock = block;
        this.renderMeta = meta;
        this.baseTemperature = baseTemperature;
        this.fluid = fluid;
        this.isToolpart = isToolpart;
    }

    public static void registerFluidType(String name, FluidType type) {
        fluidTypes.put(name, type);
    }

    public static void registerFluidType(String name, Block block, int meta, int baseTemperature, Fluid fluid,
            boolean isToolpart) {
        FluidType type = new FluidType(block, meta, baseTemperature, fluid, isToolpart);
        registerFluidType(name, type);
    }

    public static FluidType getFluidType(String typeName) {
        return fluidTypes.get(typeName);
    }

    public static FluidType getFluidType(Fluid searchedFluid) {
        for (Map.Entry<String, FluidType> stringFluidTypeEntry : fluidTypes.entrySet()) {
            if (stringFluidTypeEntry.getValue().fluid.equals(searchedFluid)) {
                return stringFluidTypeEntry.getValue();
            }
        }
        return null;
    }

    public static int getTemperatureByFluid(Fluid searchedFluid) {
        for (Map.Entry<String, FluidType> stringFluidTypeEntry : fluidTypes.entrySet()) {
            if (stringFluidTypeEntry.getValue().fluid.equals(searchedFluid)) {
                return stringFluidTypeEntry.getValue().baseTemperature;
            }
        }
        return 800;
    }
}
