package com.finallion.graveyard.config;

import com.finallion.graveyard.init.TGConfiguredStructures;
import com.finallion.graveyard.init.TGEntities;
import com.finallion.graveyard.init.TGStructures;
import com.finallion.graveyard.world.structures.AbstractGraveyardStructure;
import com.google.common.collect.Lists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class CommonConfig {


    public final ForgeConfigSpec.ConfigValue<List<? extends String>> blacklistedBiomes;

    public final ForgeConfigSpec.BooleanValue enableGhoul;
    public final ForgeConfigSpec.IntValue weightGhoul;
    public final ForgeConfigSpec.IntValue minGroupSizeGhoul;
    public final ForgeConfigSpec.IntValue maxGroupSizeGhoul;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesGhoul;

    public final ForgeConfigSpec.BooleanValue enableRevenant;
    public final ForgeConfigSpec.IntValue weightRevenant;
    public final ForgeConfigSpec.IntValue minGroupSizeRevenant;
    public final ForgeConfigSpec.IntValue maxGroupSizeRevenant;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesRevenant;

    public final ForgeConfigSpec.BooleanValue enableReaper;
    public final ForgeConfigSpec.IntValue weightReaper;
    public final ForgeConfigSpec.IntValue minGroupSizeReaper;
    public final ForgeConfigSpec.IntValue maxGroupSizeReaper;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesReaper;

    public final ForgeConfigSpec.BooleanValue enableNightmare;
    public final ForgeConfigSpec.IntValue weightNightmare;
    public final ForgeConfigSpec.IntValue minGroupSizeNightmare;
    public final ForgeConfigSpec.IntValue maxGroupSizeNightmare;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesNightmare;

    public final ForgeConfigSpec.BooleanValue enableSkeletonCreeper;
    public final ForgeConfigSpec.IntValue weightSkeletonCreeper;
    public final ForgeConfigSpec.IntValue minGroupSizeSkeletonCreeper;
    public final ForgeConfigSpec.IntValue maxGroupSizeSkeletonCreeper;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesSkeletonCreeper;

    public final ForgeConfigSpec.BooleanValue enableAcolyte;
    public final ForgeConfigSpec.IntValue weightAcolyte;
    public final ForgeConfigSpec.IntValue minGroupSizeAcolyte;
    public final ForgeConfigSpec.IntValue maxGroupSizeAcolyte;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> allowedBiomesAndCategoriesAcolyte;

    public final ForgeConfigSpec.BooleanValue enableHorde;
    public final ForgeConfigSpec.IntValue sizeHorde;
    public final ForgeConfigSpec.IntValue ticksUntilSpawnHorde;

    public final ForgeConfigSpec.BooleanValue enableMossParticle;
    public final ForgeConfigSpec.IntValue particleFrequency;


    public CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.push("The Graveyard - Structures Config");
        this.blacklistedBiomes = builder.comment("To whitelist biomes: add the biome category to the whitelist. If you want to allow a specific biome from a biome category, whitelist the category and blacklist all biomes except the one biome you like to be able to generate structures. \n" +
                "To blacklist biomes: add the biome name to the blacklist. A full list of all the biomes can be found here https://minecraft.fandom.com/wiki/Biome#Biome_IDs").defineList("global.blacklisted_biomes", getAllBiomesForCategory(Biome.BiomeCategory.RIVER, Biome.BiomeCategory.OCEAN, Biome.BiomeCategory.BEACH), this::validateBiome);

        for (StructureFeature<?> structure : TGStructures.MOD_STRUCTURES) {
            AbstractGraveyardStructure graveyardStructure = (AbstractGraveyardStructure) structure;
            StructureConfigEntry structureConfig = graveyardStructure.getStructureConfigEntry();

            String name = ((AbstractGraveyardStructure) structure).getStructureName();

            structureConfig.canGenerate = builder.comment("Graveyard structure can generate: ").define(name + ".generate", true);
            structureConfig.spacing = builder.comment("Structure spacing (needs to be higher than separation): ").defineInRange(name + ".spacing", structureConfig.getSpacing(), 0, 200);
            structureConfig.spacing = builder.comment("Structure separation: ").defineInRange(name + ".separation", structureConfig.getSeparation(), 0, 200);
            structureConfig.biomeCategories = builder.comment("Biome categories the structure can generate in: " + getAllOverworldBiomeCategories()).defineList(name + ".validBiomeCategories", structureConfig.getBiomeCategories(), o -> o instanceof String);
            structureConfig.blacklistedBiomes = builder.comment("Biomes (not biome categories!) the structure can NOT generate in").defineList(name + ".blacklistedBiomeCategories", structureConfig.getBlacklistedBiomes(), this::validateBiome);
        }

        builder.pop();

        builder.push("The Graveyard - Mob Spawning Config");
        this.enableGhoul = builder.comment("Allow the Ghoul to spawn: ").define("ghoul.enabled", true);
        this.weightGhoul = builder.comment("Set the spawn weight: ").defineInRange("ghoul.weight", 45, 0, 100);
        this.minGroupSizeGhoul = builder.comment("Set the min group size on spawn: ").defineInRange("ghoul.minGroupSizeGhoul", 2, 1, 100);
        this.maxGroupSizeGhoul = builder.comment("Set the max group size on spawn: ").defineInRange("ghoul.maxGroupSizeGhoul", 5, 1, 100);
        this.allowedBiomesAndCategoriesGhoul = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("ghoul.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        this.enableRevenant = builder.comment("Allow the Revenant to spawn: ").define("revenant.enabled", true);
        this.weightRevenant = builder.comment("Set the spawn weight: ").defineInRange("revenant.weight", 45, 0, 100);
        this.minGroupSizeRevenant = builder.comment("Set the min group size on spawn: ").defineInRange("revenant.minGroupSizeRevenant", 5, 1, 100);
        this.maxGroupSizeRevenant = builder.comment("Set the max group size on spawn: ").defineInRange("revenant.maxGroupSizeRevenant", 8, 1, 100);
        this.allowedBiomesAndCategoriesRevenant = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("revenant.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        this.enableReaper = builder.comment("Allow the Reaper to spawn: ").define("reaper.enabled", false);
        this.weightReaper = builder.comment("Set the spawn weight: ").defineInRange("reaper.weight", 0, 0, 100);
        this.minGroupSizeReaper = builder.comment("Set the min group size on spawn: ").defineInRange("reaper.minGroupSizeReaper", 2, 1, 100);
        this.maxGroupSizeReaper = builder.comment("Set the max group size on spawn: ").defineInRange("reaper.maxGroupSizeGhoul", 3, 1, 100);
        this.allowedBiomesAndCategoriesReaper = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("reaper.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        this.enableNightmare = builder.comment("Allow the Nightmare to spawn: ").define("nightmare.enabled", true);
        this.weightNightmare = builder.comment("Set the spawn weight: ").defineInRange("nightmare.weight", 15, 0, 100);
        this.minGroupSizeNightmare = builder.comment("Set the min group size on spawn: ").defineInRange("nightmare.minGroupSizeNightmare", 1, 1, 100);
        this.maxGroupSizeNightmare = builder.comment("Set the max group size on spawn: ").defineInRange("nightmare.maxGroupSizeNightmare", 1, 1, 100);
        this.allowedBiomesAndCategoriesNightmare = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("nightmare.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        this.enableSkeletonCreeper = builder.comment("Allow the Skeleton Creeper to spawn: ").define("skeleton_creeper.enabled", true);
        this.weightSkeletonCreeper = builder.comment("Set the spawn weight: ").defineInRange("skeleton_creeper.weight", 35, 0, 100);
        this.minGroupSizeSkeletonCreeper = builder.comment("Set the min group size on spawn: ").defineInRange("skeleton_creeper.minGroupSizeSkeletonCreeper", 1, 1, 100);
        this.maxGroupSizeSkeletonCreeper = builder.comment("Set the max group size on spawn: ").defineInRange("skeleton_creeper.maxGroupSizeSkeletonCreeper", 4, 1, 100);
        this.allowedBiomesAndCategoriesSkeletonCreeper = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("skeleton_creeper.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        this.enableAcolyte = builder.comment("Allow the Acolyte to spawn: ").define("acolyte.enabled", false);
        this.weightAcolyte = builder.comment("Set the spawn weight: ").defineInRange("acolyte.weight", 0, 0, 100);
        this.minGroupSizeAcolyte = builder.comment("Set the min group size on spawn: ").defineInRange("acolyte.minGroupSizeAcolyte", 2, 1, 100);
        this.maxGroupSizeAcolyte = builder.comment("Set the max group size on spawn: ").defineInRange("acolyte.maxGroupSizeAcolyte", 3, 1, 100);
        this.allowedBiomesAndCategoriesAcolyte = builder.comment("Allowed biomes and biome categories to spawn: ").defineList("acolyte.biomes", getAllOverworldBiomeCategories(), o -> o instanceof String);

        builder.pop();


        builder.push("The Graveyard - Horde Config");
        this.enableHorde = builder.comment("Enable large Graveyard mob groups to spawn: ").define("horde.generate", true);
        this.sizeHorde = builder.comment("Set the size of the horde: ").defineInRange("horde.size", 40, 0, 1000);
        this.ticksUntilSpawnHorde = builder.comment("Set the ticks until the next horde spawn attempt: ").defineInRange("horde.ticksUntilSpawnHorde", 12000, 1, 1000000);
        builder.pop();

        builder.push("The Graveyard - Particle Config");
        this.enableMossParticle = builder.comment("Enable particle rising from Graveyard moss blocks: ").define("particle.generate", true);
        this.particleFrequency = builder.comment("Set the change of particles spawning (higher numbers = lower spawn rate): ").defineInRange("particle.frequency",50, 1, 500);
        builder.pop();
    }


    private boolean validateBiome(Object o) {
        return o == null || ((String) o).contains("*") || ForgeRegistries.BIOMES.containsKey(new ResourceLocation((String) o));
    }

    public static List<String> getAllBiomesForCategory(Biome.BiomeCategory... categories) {
        List<String> biomes = new ArrayList<>();

        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            for (Biome.BiomeCategory category : categories) {
                if (biome.getBiomeCategory() == category) {
                    biomes.add(Objects.requireNonNull(biome.getRegistryName()).toString());
                }
            }
        }

        return biomes;
    }

    private List<String> getAllOverworldBiomeCategories() {
        Set<String> biomeNames = new HashSet<>();
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            if (biome.getBiomeCategory() == Biome.BiomeCategory.OCEAN || biome.getBiomeCategory() == Biome.BiomeCategory.RIVER || biome.getBiomeCategory() == Biome.BiomeCategory.NONE || biome.getBiomeCategory() == Biome.BiomeCategory.THEEND || biome.getBiomeCategory() == Biome.BiomeCategory.NETHER) {
                continue;
            }
            biomeNames.add(biome.getBiomeCategory().getName().toLowerCase(Locale.ROOT));
        }
        return new ArrayList<>(biomeNames);

    }
}
