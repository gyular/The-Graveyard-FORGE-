package com.finallion.graveyard.init.structureKeys;

import com.finallion.graveyard.TheGraveyard;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class TGStructureSetKeys {
    public static ResourceKey<StructureSet> HAUNTED_HOUSES = of("haunted_house");
    public static ResourceKey<StructureSet> LARGE_GRAVEYARDS = of("large_graveyards");
    public static ResourceKey<StructureSet> MEDIUM_GRAVEYARDS = of("medium_graveyards");
    public static ResourceKey<StructureSet> SMALL_GRAVEYARDS = of("small_graveyards");
    public static ResourceKey<StructureSet> SMALL_DESERT_GRAVEYARDS = of("small_desert_graveyards");
    public static ResourceKey<StructureSet> SMALL_GRAVES = of("small_graves");
    public static ResourceKey<StructureSet> SMALL_DESERT_GRAVES = of("small_desert_graves");
    public static ResourceKey<StructureSet> SMALL_SAVANNA_GRAVES = of("small_savanna_graves");
    public static ResourceKey<StructureSet> SMALL_MOUNTAIN_GRAVES = of("small_mountain_graves");
    public static ResourceKey<StructureSet> MUSHROOM_GRAVES = of("mushroom_graves");
    public static ResourceKey<StructureSet> MEMORIAL_TREES = of("memorial_trees");
    public static ResourceKey<StructureSet> ALTARS = of("altars");
    public static ResourceKey<StructureSet> GIANT_MUSHROOMS = of("giant_mushrooms");
    public static ResourceKey<StructureSet> CRYPTS = of("crypts");


    private static ResourceKey<StructureSet> of(String p_209839_) {
        return ResourceKey.create(Registry.STRUCTURE_SET_REGISTRY, new ResourceLocation(p_209839_));
    }
}
