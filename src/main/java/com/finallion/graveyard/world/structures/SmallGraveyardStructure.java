package com.finallion.graveyard.world.structures;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.config.StructureConfigEntry;
import com.finallion.graveyard.init.TGConfiguredStructures;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.audio.Library;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;


import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class SmallGraveyardStructure extends AbstractGraveyardStructure {

    public SmallGraveyardStructure(Codec<JigsawConfiguration> codec) {
        super(codec, new StructureConfigEntry(20, 18,
                Arrays.asList("#" + Biome.BiomeCategory.PLAINS.getName()),
                Collections.emptyList(), Arrays.asList("#minecraft"), false),
                15, 240451934, SmallGraveyardGenerator.STARTING_POOL, "small_graveyard");
    }


    @Override
    public ConfiguredStructureFeature<?, ?> getStructureFeature() {
        return TGConfiguredStructures.SMALL_GRAVEYARD_STRUCTURE_CONFIG;
    }

    public static class SmallGraveyardGenerator {
        public static final StructureTemplatePool STARTING_POOL;

        public SmallGraveyardGenerator() {
        }

        public static void init() {
        }

        static {
            STARTING_POOL = Pools.register(new StructureTemplatePool(new ResourceLocation(TheGraveyard.MOD_ID, "small_graveyard"), new ResourceLocation("empty"), ImmutableList.of(
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_01"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_02"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_03"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_04"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_05"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_06"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_07"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_08"), 1),
                    Pair.of(StructurePoolElement.legacy(TheGraveyard.MOD_ID + ":small_graveyard/small_graveyard_09"), 1)),
                    StructureTemplatePool.Projection.RIGID));
        }
    }

}
