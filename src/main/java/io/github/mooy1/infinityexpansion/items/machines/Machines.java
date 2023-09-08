package io.github.mooy1.infinityexpansion.items.machines;

import java.util.EnumMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.Location;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.categories.Groups;
import io.github.mooy1.infinityexpansion.items.SlimefunExtension;
import io.github.mooy1.infinityexpansion.items.blocks.InfinityWorkbench;
import io.github.mooy1.infinityexpansion.items.materials.Materials;
import io.github.mooy1.infinitylib.machines.MachineBlock;
import io.github.mooy1.infinitylib.machines.MachineLore;
import io.github.mooy1.infinitylib.common.Scheduler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricSmeltery;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.CarbonPress;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import io.github.mooy1.infinityexpansion.items.quarries.Quarries;
import io.github.mooy1.infinityexpansion.items.quarries.Oscillator;
import io.github.mooy1.infinityexpansion.items.blocks.Blocks;
@UtilityClass
public final class Machines {

    public static final SlimefunItemStack COBBLE_PRESS = new SlimefunItemStack(
            "COBBLE_PRESS",
            Material.SMOOTH_STONE,
            "&8圆石压缩机",
            "&7高效压缩圆石",
            "",
            MachineLore.energyPerSecond(120)
    );
    public static final SlimefunItemStack INFINITY_COBBLE_PRESS = new SlimefunItemStack(
            "INFINITY_COBBLE_PRESS",
            Material.SMOOTH_STONE,
            "&b瓜瓜版无尽&8圆石压缩机",
            "&7利用木瓜能量压缩圆石",
            "",
            MachineLore.speed(240),
            MachineLore.energyPerSecond(17000)
    );
    public static final SlimefunItemStack KILLALL_WITHER = new SlimefunItemStack(
            "KILLALL_WITHER",
            Material.LODESTONE,
            "&6瓜瓜版&8高级杀凋机",
            "&7利用木瓜能量快速杀凋零",
            "",
            MachineLore.speed(240),
            MachineLore.energyPerSecond(2500)
    );
     public static final SlimefunItemStack INFINITY_GUA_CIRCUIT = new SlimefunItemStack(
            "INFINITY_GUA_CIRCUIT",
            Material.DIAMOND_BLOCK,
            "&6瓜瓜版&b无尽晶格合成机",
            "&7需8个无尽锭8个虚空锭",
            "&7利用木瓜能量快速合成",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(100000)
    );
     public static final SlimefunItemStack INFINITY_GUA_CORE = new SlimefunItemStack(
            "INFINITY_GUA_CORE",
            Material.DIAMOND_BLOCK,
            "&6瓜瓜版&b无尽核心合成机",
            "&7需8个无尽锭8个虚空锭",
            "&7利用木瓜能量快速合成",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(100000)
    );
    public static final SlimefunItemStack RESOURCE_SYNTHESIZER = new SlimefunItemStack(
            "RESOURCE_SYNTHESIZER",
            Material.LODESTONE,
            "&6资源合成器",
            "&7通过两种材料合成资源",
            "",
            MachineLore.energy(1_000_000) + "每次使用"
    );
    public static final SlimefunItemStack BASIC_GROWER = new SlimefunItemStack(
            "BASIC_VIRTUAL_FARM",
            Material.GRASS_BLOCK,
            "&9基础&a自动农场",
            "&7自动种植、收获和再种植作物",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(18)
    );
    public static final SlimefunItemStack ADVANCED_GROWER = new SlimefunItemStack(
            "ADVANCED_VIRTUAL_FARM",
            Material.CRIMSON_NYLIUM,
            "&c高级&a自动农场",
            "&7自动种植、收获和再种植作物",
            "",
            MachineLore.speed(5),
            MachineLore.energyPerSecond(90)
    );
    public static final SlimefunItemStack INFINITY_GROWER = new SlimefunItemStack(
            "INFINITY_VIRTUAL_FARM",
            Material.WARPED_NYLIUM,
            "&b无尽&a自动农场",
            "&7自动种植、收获和再种植作物",
            "",
            MachineLore.speed(25),
            MachineLore.energyPerSecond(900)
    );
    public static final SlimefunItemStack BASIC_TREE = new SlimefunItemStack(
            "BASIC_TREE_GROWER",
            Material.STRIPPED_OAK_WOOD,
            "&9基础&2自动植树机",
            "&7自动种植、收获和再种植树木",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(36)
    );
    public static final SlimefunItemStack ADVANCED_TREE = new SlimefunItemStack(
            "ADVANCED_TREE_GROWER",
            Material.STRIPPED_ACACIA_WOOD,
            "&c高级&2自动植树机",
            "&7自动种植、收获和再种植树木",
            "",
            MachineLore.speed(5),
            MachineLore.energyPerSecond(180)
    );
    public static final SlimefunItemStack INFINITY_TREE = new SlimefunItemStack(
            "INFINITY_TREE_GROWER",
            Material.STRIPPED_WARPED_HYPHAE,
            "&b无尽&2自动植树机",
            "&7自动种植、收获和再种植树木",
            "",
            MachineLore.speed(25),
            MachineLore.energyPerSecond(1800)
    );
    private static final int BEDROCK_ENERGY = 10_000;
    public static final SlimefunItemStack POWERED_BEDROCK = new SlimefunItemStack(
            "POWERED_BEDROCK",
            Material.NETHERITE_BLOCK,
            "&4充能基岩",
            "&7通电后变成基岩",
            "&7失去充能后可被破坏",
            "",
            MachineLore.energyPerSecond(BEDROCK_ENERGY)
    );
    private static final int GEO_QUARRY_INTERVAL = 400;
    private static final int GEO_QUARRY_ENERGY = 450;
    public static final SlimefunItemStack GEO_QUARRY = new SlimefunItemStack(
            "GEO_QUARRY",
            Material.QUARTZ_BRICKS,
            "&f地理资源矿机",
            "&7利用电力缓慢获取地理资源",
            "&7无需地形扫描",
            "&7不受剩余地理资源数量影响",
            "",
            MachineLore.energyPerSecond(GEO_QUARRY_ENERGY)
    );
    public static final SlimefunItemStack EXTREME_FREEZER = new SlimefunItemStack(
            "EXTREME_FREEZER",
            Material.LIGHT_BLUE_CONCRETE,
            "&b极寒冰柜",
            "&7将冰转化为冷却剂",
            "&7将岩浆块转化为下界冰冷却剂",
            "",
            MachineLore.energyPerSecond(90)
    );
    public static final SlimefunItemStack DUST_EXTRACTOR = new SlimefunItemStack(
            "DUST_EXTRACTOR",
            Material.FURNACE,
            "&8磨粉机",
            "&7将圆石变为矿粉",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(240)
    );
     public static final SlimefunItemStack GUA_MODI = new SlimefunItemStack(
            "GUA_MODI",
            Material.FURNACE,
            "&8末地石转换机",
            "&7将圆石变为末地石",
            "",
            MachineLore.speed(4),
            MachineLore.energyPerSecond(240)
         
    );
    public static final SlimefunItemStack GUA_SHENBAN = new SlimefunItemStack(
            "GUA_SHENBAN",
            Material.FURNACE,
            "&8深板岩转换机",
            "&7将圆石变为深板岩",
            "",
            MachineLore.speed(4),
            MachineLore.energyPerSecond(240)
    );
    public static final SlimefunItemStack INFINITY_DUST_EXTRACTOR = new SlimefunItemStack(
            "INFINITY_DUST_EXTRACTOR",
            Material.FURNACE,
            "&b无尽&8磨粉机",
            "&7将圆石变为矿粉",
            "",
            MachineLore.speed(16),
            MachineLore.energyPerSecond(7200)
    );
    public static final SlimefunItemStack INGOT_FORMER = new SlimefunItemStack(
            "INGOT_FORMER",
            Material.FURNACE,
            "&8铸锭机",
            "&7将矿粉变为锭",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(240)
    );
      public static final SlimefunItemStack CARBON_PRESS_4 = new SlimefunItemStack(
            "CARBON_PRESS_4",
            Material.BLACK_STAINED_GLASS,
            "&8瓜瓜版碳压机器",
            "&7高效压缩",
            "",
            MachineLore.speed(30),
            MachineLore.energyPerSecond(500)
    );
    public static final SlimefunItemStack INFINITY_INGOT_FORMER = new SlimefunItemStack(
            "INFINITY_INGOT_FORMER",
            Material.FURNACE,
            "&b无尽&8铸锭机",
            "&7将矿粉变为锭",
            "",
            MachineLore.speed(8),
            MachineLore.energyPerSecond(3600)
     );
    public static final SlimefunItemStack INFINITY_DUST_INGOT_FORMER = new SlimefunItemStack(
            "INFINITY_DUST_INGOT_FORMER",
            Material.FURNACE,
            "&b无尽&8铸锭一体机",
            "&7将圆石随机变为锭",
            "",
            MachineLore.speed(32),
            MachineLore.energyPerSecond(10000)
    );
    public static final SlimefunItemStack INFINITY_GUA_INGOT_FORMER = new SlimefunItemStack(
            "INFINITY_GUA_INGOT_FORMER",
            Material.FURNACE,
            "&b瓜瓜版无尽&8铸锭机",
            "&7利用木瓜能量将矿粉变为锭",
            "",
            MachineLore.speed(16),
            MachineLore.energyPerSecond(7500)
    );
    public static final SlimefunItemStack INFINITY_GUA = new SlimefunItemStack(
            "INFINITY_GUA",
            Material.FURNACE,
            "&6瓜瓜版&b无尽钻石&8吞噬者",
            "&7利用木瓜能量消耗钻石获得碳",
            "&7利用木瓜能量消耗碳获得煤炭",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(16000)
    );
    public static final SlimefunItemStack URANIUM_EXTRACTOR = new SlimefunItemStack(
            "URANIUM_EXTRACTOR",
            Material.LIME_CONCRETE,
            "&a铀提取器",
            "&7将圆石变为铀",
            "",
            MachineLore.energyPerSecond(240)
     ); 
         public static final SlimefunItemStack QUARTZ_EXTRACTOR = new SlimefunItemStack(
            "QUARTZ_EXTRACTOR",
            Material.POLISHED_BLACKSTONE,
            "&6瓜瓜版&8石英提取器",
            "&7利用木瓜能量在下届岩提取石英",
            "",
            MachineLore.speed(16),
            MachineLore.energyPerSecond(1200)
     ); 
      public static final SlimefunItemStack ADVANCED_QUARTZ_EXTRACTOR = new SlimefunItemStack(
            "ADVANCED_QUARTZ_EXTRACTOR",
            Material.POLISHED_BLACKSTONE,
            "&6高级瓜瓜版&8石英提取器",
            "&7利用木瓜能量在下届岩提取石英",
            "",
            MachineLore.speed(32),
            MachineLore.energyPerSecond(3500)
     ); 
     public static final SlimefunItemStack INFINITY_QUARTZ_EXTRACTOR = new SlimefunItemStack(
            "INFINITY_QUARTZ_EXTRACTOR",
            Material.POLISHED_BLACKSTONE,
            "&b无尽瓜瓜版&8石英提取器",
            "&7利用木瓜能量在下届岩提取石英",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(18000)
    );
    public static final SlimefunItemStack DECOMPRESSOR = new SlimefunItemStack(
            "DECOMPRESSOR",
            Material.TARGET,
            "&7分解机",
            "&7将方块还原成基础材料",
            "",
            MachineLore.energyPerSecond(60)
    );
    private static final int GEAR_TRANSFORMER_ENERGY = 12000;
    public static final SlimefunItemStack GEAR_TRANSFORMER = new SlimefunItemStack(
            "GEAR_TRANSFORMER",
            Material.EMERALD_BLOCK,
            "&7装备材质转换器",
            "&7改变原版工具或装备的材质",
            "",
            MachineLore.energy(GEAR_TRANSFORMER_ENERGY) + "每次使用"
    );
    public static final SlimefunItemStack BASIC_COBBLE = new SlimefunItemStack(
            "BASIC_COBBLE_GEN",
            Material.SMOOTH_STONE,
            "&9基础&8圆石生成器",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(24)
    );
    public static final SlimefunItemStack ADVANCED_COBBLE = new SlimefunItemStack(
            "ADVANCED_COBBLE_GEN",
            Material.SMOOTH_STONE,
            "&c高级&8圆石生成器",
            "",
            MachineLore.speed(4),
            MachineLore.energyPerSecond(120)
    );
    public static final SlimefunItemStack INFINITY_COBBLE = new SlimefunItemStack(
            "INFINITY_COBBLE_GEN",
            Material.SMOOTH_STONE,
            "&c无尽&8圆石生成器",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(800)
   );
    public static final SlimefunItemStack BASIC_NETHERRACK = new SlimefunItemStack(
            " BASIC_NETHERRACK",
            Material.NETHERRACK,
            "&9基础&下届岩生成器",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(24)
        );
    public static final SlimefunItemStack ADVANCED_NETHERRACK = new SlimefunItemStack(
            "ADVANCED_NETHERRACK",
            Material.NETHERRACK,
            "&6高级&8下届岩生成器",
            "",
            MachineLore.speed(8),
            MachineLore.energyPerSecond(240)
         );
    public static final SlimefunItemStack INFINITY_NETHERRACK = new SlimefunItemStack(
            "INFINITY_NETHERRACK",
            Material.NETHERRACK,
            "&6瓜瓜版&b无尽&8下届岩生成器",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(900)
    );
    public static final SlimefunItemStack INFINITY_REDSTONE = new SlimefunItemStack(
            "INFINITY_REDSTONE",
            Material.NETHERRACK,
            "&6瓜瓜版&b无尽&8红石生成器",
            "来自木瓜的后备隐藏能源",
            MachineLore.speed(24),
            MachineLore.energyPerSecond(60000)
    );
     public static final SlimefunItemStack INFINITY_LAPIS_LAZULI = new SlimefunItemStack(
            "INFINITY_LAPIS_LAZULI",
            Material.NETHERRACK,
            "&6瓜瓜版&b无尽&8青金石生成器",
            "来自木瓜的后备隐藏能源",
            MachineLore.speed(24),
            MachineLore.energyPerSecond(60000)
    );
    public static final SlimefunItemStack BASIC_OBSIDIAN = new SlimefunItemStack(
            "BASIC_OBSIDIAN_GEN",
            Material.SMOOTH_STONE,
            "&8黑曜石生成器",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(240)
    );
    public static final SlimefunItemStack SINGULARITY_CONSTRUCTOR = new SlimefunItemStack(
            "SINGULARITY_CONSTRUCTOR",
            Material.QUARTZ_BRICKS,
            "&f奇点构造机",
            "&7凝聚大量资源",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(120)
    );
    public static final SlimefunItemStack INFINITY_CONSTRUCTOR = new SlimefunItemStack(
            "INFINITY_CONSTRUCTOR",
            Material.CHISELED_QUARTZ_BLOCK,
            "&b无尽&f奇点构造机",
            "&7快速凝聚大量资源",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(1200)
    );
    public static final SlimefunItemStack STONEWORKS_FACTORY = new SlimefunItemStack(
            "STONEWORKS_FACTORY",
            Material.BLAST_FURNACE,
            "&8石材厂",
            "&7生成圆石并将其加工成各种材料",
            "",
            MachineLore.energyPerSecond(240)
    );
    public static final SlimefunItemStack VOID_HARVESTER = new SlimefunItemStack(
            "VOID_HARVESTER",
            Material.OBSIDIAN,
            "&8虚空收集者",
            "&7从虚无中缓慢收集&8虚空粉",
            "",
            MachineLore.speed(1),
            MachineLore.energyPerSecond(700)
    );
    public static final SlimefunItemStack INFINITE_VOID_HARVESTER = new SlimefunItemStack(
            "INFINITE_VOID_HARVESTER",
            Material.CRYING_OBSIDIAN,
            "&b无尽&8虚空收集者",
            "&7从虚无中收集&8虚空粉",
            "",
            MachineLore.speed(64),
            MachineLore.energyPerSecond(60000)
    );
    public static final SlimefunItemStack CONCRETE_MOLDING_MACHINE = new SlimefunItemStack(
        "CONCRETE_MOLDING_MACHINE",
        Material.FURNACE,
        "&8混凝土浇筑机",
        "&7全自动浇筑混凝土",
        "",
        MachineLore.speed(8),
        MachineLore.energyPerSecond(80)
    );

    public static void setup(InfinityExpansion plugin) {
        new VoidHarvester(Groups.ADVANCED_MACHINES, VOID_HARVESTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.TITANIUM, Materials.TITANIUM, Materials.TITANIUM,
                Materials.MACHINE_PLATE, SlimefunItems.GEO_MINER, Materials.MACHINE_PLATE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }, 1).energyPerTick(700).register(plugin);
        new VoidHarvester(Groups.INFINITY_CHEAT, INFINITE_VOID_HARVESTER, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE,
                Materials.MAGNONIUM, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.MAGNONIUM,
                Materials.MAGNONIUM, Materials.VOID_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT, Materials.MAGNONIUM,
                Materials.MAGNONIUM, Materials.VOID_INGOT, VOID_HARVESTER, VOID_HARVESTER, Materials.VOID_INGOT, Materials.MAGNONIUM,
                Materials.MAGNONIUM, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.MAGNONIUM,
                Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE
        }, 64).energyPerTick(60000).register(plugin);
        new StoneworksFactory(Groups.ADVANCED_MACHINES, STONEWORKS_FACTORY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, BASIC_COBBLE, Materials.MAGSTEEL_PLATE,
                SlimefunItems.ELECTRIC_FURNACE_3, Materials.MACHINE_CIRCUIT, SlimefunItems.ELECTRIC_ORE_GRINDER,
                Materials.MAGSTEEL_PLATE, SlimefunItems.ELECTRIC_PRESS, Materials.MAGSTEEL_PLATE
        }).energyPerTick(240).register(plugin);

        new SingularityConstructor(Groups.ADVANCED_MACHINES, SINGULARITY_CONSTRUCTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL, Materials.MAGSTEEL, Materials.MAGSTEEL,
                Materials.MACHINE_PLATE, SlimefunItems.CARBON_PRESS_3, Materials.MACHINE_PLATE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).speed(1).energyPerTick(120).register(plugin);
        new SingularityConstructor(Groups.INFINITY_CHEAT, INFINITY_CONSTRUCTOR, InfinityWorkbench.TYPE, new ItemStack[] {
                null, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, Materials.MACHINE_PLATE, null,
                null, Materials.VOID_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT, null,
                null, Materials.VOID_INGOT, SINGULARITY_CONSTRUCTOR, SINGULARITY_CONSTRUCTOR, Materials.VOID_INGOT, null,
                null, Materials.VOID_INGOT, SINGULARITY_CONSTRUCTOR, SINGULARITY_CONSTRUCTOR, Materials.VOID_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_INGOT, null,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT
        }).speed(64).energyPerTick(1200).register(plugin);

        new ResourceSynthesizer(Groups.ADVANCED_MACHINES, RESOURCE_SYNTHESIZER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.ADAMANTITE, Materials.ADAMANTITE, Materials.ADAMANTITE,
                Materials.MACHINE_PLATE, SlimefunItems.REINFORCED_FURNACE, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.MACHINE_CORE, Materials.MACHINE_PLATE
        }).recipes(new SlimefunItemStack[] {
                Materials.IRON_SINGULARITY, Materials.COAL_SINGULARITY, new SlimefunItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT, 32),
                Materials.IRON_SINGULARITY, Materials.REDSTONE_SINGULARITY, new SlimefunItemStack(SlimefunItems.REDSTONE_ALLOY, 32),
                Materials.DIAMOND_SINGULARITY, Materials.COAL_SINGULARITY, new SlimefunItemStack(SlimefunItems.CARBONADO, 16),
                Materials.GOLD_SINGULARITY, Materials.EMERALD_SINGULARITY, new SlimefunItemStack(SlimefunItems.BLISTERING_INGOT_3, 16),
                Materials.COPPER_SINGULARITY, Materials.ZINC_SINGULARITY, new SlimefunItemStack(SlimefunItems.ELECTRO_MAGNET, 64),
                Materials.IRON_SINGULARITY, Materials.QUARTZ_SINGULARITY, new SlimefunItemStack(SlimefunItems.SOLAR_PANEL, 64)
        }).energyPerTick(1_000_000).register(plugin);

        new PoweredBedrock(Groups.INFINITY_CHEAT, POWERED_BEDROCK, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5,
                Materials.COBBLE_5, Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.MACHINE_PLATE, Materials.COBBLE_5,
                Materials.COBBLE_5, Materials.VOID_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ENERGIZED_CAPACITOR, Materials.VOID_INGOT, Materials.COBBLE_5,
                Materials.COBBLE_5, Materials.VOID_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT, Materials.COBBLE_5,
                Materials.COBBLE_5, Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.MACHINE_PLATE, Materials.COBBLE_5,
                Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5, Materials.COBBLE_5
        }, BEDROCK_ENERGY).register(plugin);
        new MaterialGenerator(Groups.BASIC_MACHINES, BASIC_COBBLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL, new ItemStack(Material.DIAMOND_PICKAXE), Materials.MAGSTEEL,
                new ItemStack(Material.WATER_BUCKET), Materials.COBBLE_2, new ItemStack(Material.LAVA_BUCKET),
                Materials.MAGSTEEL, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL
        }).material(Material.COBBLESTONE).speed(1).energyPerTick(24).register(plugin);
        new MaterialGenerator(Groups.ADVANCED_MACHINES, ADVANCED_COBBLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, BASIC_COBBLE, Materials.MAGSTEEL_PLATE,
                new ItemStack(Material.WATER_BUCKET), Materials.COBBLE_3, new ItemStack(Material.LAVA_BUCKET),
                Materials.MACHINE_CIRCUIT, BASIC_COBBLE, Materials.MACHINE_CIRCUIT
        }).material(Material.COBBLESTONE).speed(4).energyPerTick(75).register(plugin);
        new MaterialGenerator(Groups.INFINITY_CHEAT, INFINITY_COBBLE, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, ADVANCED_COBBLE, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT
        }).material(Material.COBBLESTONE).speed(64).energyPerTick(800).register(plugin);
        
       new MaterialGenerator(Groups.BASIC_MACHINES, BASIC_NETHERRACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL, new ItemStack(Material.DIAMOND_PICKAXE), Materials.MAGSTEEL,
                new ItemStack(Material.NETHERRACK), Materials.COBBLE_3, new ItemStack(Material.LAVA_BUCKET),
                Materials.MAGSTEEL, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL
        }).material(Material.NETHERRACK).speed(1).energyPerTick(24).register(plugin); 
        
        new MaterialGenerator(Groups.ADVANCED_MACHINES, ADVANCED_NETHERRACK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, BASIC_NETHERRACK, Materials.MAGSTEEL_PLATE,
                new ItemStack(Material.NETHERRACK), Materials.COBBLE_4, new ItemStack(Material.LAVA_BUCKET),
                Materials.MACHINE_CIRCUIT, BASIC_NETHERRACK, Materials.MACHINE_CIRCUIT
        }).material(Material.NETHERRACK).speed(4).energyPerTick(240).register(plugin);
        
        new MaterialGenerator(Groups.INFINITY_CHEAT, INFINITY_NETHERRACK, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, Materials.VOID_INGOT,
                Materials.VOID_INGOT, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, ADVANCED_NETHERRACK, ADVANCED_NETHERRACK, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT
        }).material(Material.NETHERRACK).speed(64).energyPerTick(900).register(plugin);
        
        new MaterialGenerator(Groups.ADVANCED_MACHINES, BASIC_OBSIDIAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.FLUID_PUMP, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.FLUID_PUMP,
                new ItemStack(Material.DISPENSER), Materials.VOID_INGOT, new ItemStack(Material.DISPENSER),
                Materials.MACHINE_CIRCUIT, ADVANCED_COBBLE, Materials.MACHINE_CIRCUIT
        }).material(Material.OBSIDIAN).speed(1).energyPerTick(240).register(plugin);

        EnumMap<Material, ItemStack[]> crops = new EnumMap<>(Material.class);
        crops.put(Material.WHEAT_SEEDS, new ItemStack[] { new ItemStack(Material.WHEAT, 2) });
        crops.put(Material.CARROT, new ItemStack[] { new ItemStack(Material.CARROT, 2) });
        crops.put(Material.POTATO, new ItemStack[] { new ItemStack(Material.POTATO, 2) });
        crops.put(Material.BEETROOT_SEEDS, new ItemStack[] { new ItemStack(Material.BEETROOT, 2) });
        crops.put(Material.PUMPKIN_SEEDS, new ItemStack[] { new ItemStack(Material.PUMPKIN) });
        crops.put(Material.MELON_SEEDS, new ItemStack[] { new ItemStack(Material.MELON_SLICE, 4) });
        crops.put(Material.SUGAR_CANE, new ItemStack[] { new ItemStack(Material.SUGAR_CANE, 2) });
        crops.put(Material.COCOA_BEANS, new ItemStack[] { new ItemStack(Material.COCOA_BEANS, 2) });
        crops.put(Material.CACTUS, new ItemStack[] { new ItemStack(Material.CACTUS, 2) });
        crops.put(Material.BAMBOO, new ItemStack[] { new ItemStack(Material.BAMBOO, 6) });
        crops.put(Material.CHORUS_FLOWER, new ItemStack[] { new ItemStack(Material.CHORUS_FRUIT, 6) });
        crops.put(Material.NETHER_WART, new ItemStack[] { new ItemStack(Material.NETHER_WART, 2) });

        new GrowingMachine(Groups.BASIC_MACHINES, BASIC_GROWER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS),
                Materials.MAGSTEEL, new ItemStack(Material.DIAMOND_HOE), Materials.MAGSTEEL,
                Materials.MACHINE_CIRCUIT, new ItemStack(Material.GRASS_BLOCK), Materials.MACHINE_CIRCUIT
        }).recipes(crops).ticksPerOutput(300).energyPerTick(18).register(plugin);
        new GrowingMachine(Groups.ADVANCED_MACHINES, ADVANCED_GROWER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS,
                Materials.MAGNONIUM, BASIC_GROWER, Materials.MAGNONIUM,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).recipes(crops).ticksPerOutput(60).energyPerTick(90).register(plugin);
        new GrowingMachine(Groups.INFINITY_CHEAT, INFINITY_GROWER, InfinityWorkbench.TYPE, new ItemStack[] {
                new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), null, null, null, null, new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), null, null, null, null, new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.GLASS),
                Materials.MACHINE_PLATE, SlimefunItems.CROP_GROWTH_ACCELERATOR_2, ADVANCED_GROWER, ADVANCED_GROWER, SlimefunItems.CROP_GROWTH_ACCELERATOR_2, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_CIRCUIT, Materials.MACHINE_PLATE
        }).recipes(crops).ticksPerOutput(12).energyPerTick(900).register(plugin);

        EnumMap<Material, ItemStack[]> trees = new EnumMap<>(Material.class);

        trees.put(Material.OAK_SAPLING, new ItemStack[] {
                new ItemStack(Material.OAK_LEAVES, 8), new ItemStack(Material.OAK_LOG, 6), new ItemStack(Material.STICK), new ItemStack(Material.APPLE)
        });
        trees.put(Material.SPRUCE_SAPLING, new ItemStack[] {
                new ItemStack(Material.SPRUCE_LEAVES, 8), new ItemStack(Material.SPRUCE_LOG, 6), new ItemStack(Material.STICK, 2)
        });
        trees.put(Material.DARK_OAK_SAPLING, new ItemStack[] {
                new ItemStack(Material.DARK_OAK_LEAVES, 8), new ItemStack(Material.DARK_OAK_LOG, 6), new ItemStack(Material.APPLE)
        });
        trees.put(Material.BIRCH_SAPLING, new ItemStack[] {
                new ItemStack(Material.BIRCH_LEAVES, 8), new ItemStack(Material.BIRCH_LOG, 6)
        });
        trees.put(Material.ACACIA_SAPLING, new ItemStack[] {
                new ItemStack(Material.ACACIA_LEAVES, 8), new ItemStack(Material.ACACIA_LOG, 6)
        });
        trees.put(Material.JUNGLE_SAPLING, new ItemStack[] {
                new ItemStack(Material.JUNGLE_LEAVES, 8), new ItemStack(Material.JUNGLE_LOG, 6), new ItemStack(Material.COCOA_BEANS)
        });
        trees.put(Material.WARPED_FUNGUS, new ItemStack[] {
                new ItemStack(Material.WARPED_HYPHAE, 8), new ItemStack(Material.WARPED_STEM, 6), new ItemStack(Material.SHROOMLIGHT)
        });
        trees.put(Material.CRIMSON_FUNGUS, new ItemStack[] {
                new ItemStack(Material.CRIMSON_HYPHAE, 8), new ItemStack(Material.CRIMSON_STEM, 6), new ItemStack(Material.WEEPING_VINES)
        });

        new GrowingMachine(Groups.BASIC_MACHINES, BASIC_TREE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS),
                Materials.MAGSTEEL, new ItemStack(Material.PODZOL), Materials.MAGSTEEL,
                Materials.MACHINE_CIRCUIT, BASIC_GROWER, Materials.MACHINE_CIRCUIT
        }).recipes(trees).ticksPerOutput(600).energyPerTick(36).register(plugin);
        new GrowingMachine(Groups.ADVANCED_MACHINES, ADVANCED_TREE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS,
                Materials.MAGNONIUM, BASIC_TREE, Materials.MAGNONIUM,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).recipes(trees).ticksPerOutput(120).energyPerTick(180).register(plugin);
        new GrowingMachine(Groups.INFINITY_CHEAT, INFINITY_TREE, InfinityWorkbench.TYPE, new ItemStack[] {
                new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), SlimefunItems.TREE_GROWTH_ACCELERATOR, null, null, SlimefunItems.TREE_GROWTH_ACCELERATOR, new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), ADVANCED_TREE, null, null, ADVANCED_TREE, new ItemStack(Material.GLASS),
                new ItemStack(Material.GLASS), SlimefunItems.TREE_GROWTH_ACCELERATOR, null, null, SlimefunItems.TREE_GROWTH_ACCELERATOR, new ItemStack(Material.GLASS),
                Materials.MACHINE_PLATE, new ItemStack(Material.PODZOL), new ItemStack(Material.PODZOL), new ItemStack(Material.PODZOL), new ItemStack(Material.PODZOL), Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_CIRCUIT, Materials.MACHINE_PLATE
        }).recipes(trees).ticksPerOutput(24).energyPerTick(1800).register(plugin);

        new MachineBlock(Groups.ADVANCED_MACHINES, EXTREME_FREEZER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.FREEZER_2, SlimefunItems.FREEZER_2, SlimefunItems.FREEZER_2,
                new ItemStack(Material.WATER_BUCKET), SlimefunItems.FLUID_PUMP, new ItemStack(Material.WATER_BUCKET),
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).addRecipe(SlimefunItems.NETHER_ICE_COOLANT_CELL, new ItemStack(Material.MAGMA_BLOCK, 2))
                .ticksPerOutput(1)
                .addRecipe(SlimefunItems.REACTOR_COOLANT_CELL, new ItemStack(Material.ICE, 2))
                .energyPerTick(90).register(plugin);

        RandomizedItemStack twoDust = new RandomizedItemStack(
                new SlimefunItemStack(SlimefunItems.COPPER_DUST, 2),
                new SlimefunItemStack(SlimefunItems.ZINC_DUST, 2),
                new SlimefunItemStack(SlimefunItems.TIN_DUST, 2),
                new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST, 2),
                new SlimefunItemStack(SlimefunItems.LEAD_DUST, 2),
                new SlimefunItemStack(SlimefunItems.SILVER_DUST, 2),
                new SlimefunItemStack(SlimefunItems.GOLD_DUST, 2),
                new SlimefunItemStack(SlimefunItems.IRON_DUST, 2),
                new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST, 2)
        );
        new MachineBlock(Groups.ADVANCED_MACHINES, DUST_EXTRACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3,
                SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).ticksPerOutput(1).addRecipe(twoDust, new ItemStack(Material.COBBLESTONE, 4))
                .addRecipe(twoDust, new ItemStack(Material.ANDESITE, 4))
                .addRecipe(twoDust, new ItemStack(Material.STONE, 4))
                .addRecipe(twoDust, new ItemStack(Material.DIORITE, 4))
                .addRecipe(twoDust, new ItemStack(Material.GRANITE, 4))
                .energyPerTick(240).register(plugin);

        RandomizedItemStack sixtyFourDust = new RandomizedItemStack(
                new SlimefunItemStack(SlimefunItems.COPPER_DUST, 64),
                new SlimefunItemStack(SlimefunItems.ZINC_DUST, 64),
                new SlimefunItemStack(SlimefunItems.TIN_DUST, 64),
                new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST, 64),
                new SlimefunItemStack(SlimefunItems.LEAD_DUST, 64),
                new SlimefunItemStack(SlimefunItems.SILVER_DUST, 64),
                new SlimefunItemStack(SlimefunItems.GOLD_DUST, 64),
                new SlimefunItemStack(SlimefunItems.IRON_DUST, 64),
                new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST, 64)
        );
        new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_DUST_EXTRACTOR, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, DUST_EXTRACTOR, DUST_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, DUST_EXTRACTOR, DUST_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, DUST_EXTRACTOR, DUST_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
        }).addRecipe(sixtyFourDust, new ItemStack(Material.COBBLESTONE, 64))
                .addRecipe(sixtyFourDust, new ItemStack(Material.ANDESITE, 64))
                .addRecipe(sixtyFourDust, new ItemStack(Material.STONE, 64))
                .addRecipe(sixtyFourDust, new ItemStack(Material.DIORITE, 64))
                .addRecipe(sixtyFourDust, new ItemStack(Material.GRANITE, 64))
                .ticksPerOutput(1).energyPerTick(7200).register(plugin);
        
         RandomizedItemStack thirtyTwoIngot = new RandomizedItemStack(
                new SlimefunItemStack(SlimefunItems.COPPER_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.ZINC_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.TIN_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.LEAD_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.SILVER_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.GOLD_24K, 16),
                new ItemStack(Material.IRON_INGOT, 32),
                new SlimefunItemStack(SlimefunItems.MAGNESIUM_INGOT, 32)
              );
        new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_DUST_INGOT_FORMER, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INFINITY_INGOT_FORMER, INFINITY_DUST_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, DUST_EXTRACTOR, DUST_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER, INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
        }).addRecipe(thirtyTwoIngot, new ItemStack(Material.COBBLESTONE, 64))
                .addRecipe(thirtyTwoIngot, new ItemStack(Material.ANDESITE, 64))
                .addRecipe(thirtyTwoIngot, new ItemStack(Material.STONE, 64))
                .addRecipe(thirtyTwoIngot, new ItemStack(Material.DIORITE, 64))
                .addRecipe(thirtyTwoIngot, new ItemStack(Material.GRANITE, 64))
                .ticksPerOutput(1).energyPerTick(10000).register(plugin);
    
        
        new MachineBlock(Groups.ADVANCED_MACHINES, COBBLE_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MACHINE_PLATE, Materials.COBBLE_3, Materials.MACHINE_PLATE,
                SlimefunItems.ELECTRIC_PRESS_2, SlimefunItems.ELECTRIC_PRESS_2, SlimefunItems.ELECTRIC_PRESS_2,
                Materials.MACHINE_PLATE, Materials.COBBLE_3, Materials.MACHINE_PLATE
        }).addRecipe(new SlimefunItemStack(Materials.COBBLE_1, 8), new ItemStack(Material.COBBLESTONE, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_2, 8), new SlimefunItemStack(Materials.COBBLE_1, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_3, 8), new SlimefunItemStack(Materials.COBBLE_2, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_4, 8), new SlimefunItemStack(Materials.COBBLE_3, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_5, 8), new SlimefunItemStack(Materials.COBBLE_4, 64))
                .ticksPerOutput(1).energyPerTick(120).register(plugin);
        
         new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_COBBLE_PRESS, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, COBBLE_PRESS, COBBLE_PRESS, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, COBBLE_PRESS, COBBLE_PRESS, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
              }).addRecipe(new SlimefunItemStack(Materials.COBBLE_1, 32), new ItemStack(Material.COBBLESTONE, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_2, 32), new SlimefunItemStack(Materials.COBBLE_1, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_3, 32), new SlimefunItemStack(Materials.COBBLE_2, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_4, 32), new SlimefunItemStack(Materials.COBBLE_3, 64))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_5, 32), new SlimefunItemStack(Materials.COBBLE_4, 64))
                .ticksPerOutput(1).energyPerTick(17000).register(plugin);
        

        new MachineBlock(Groups.ADVANCED_MACHINES, INGOT_FORMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2,
                SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new SlimefunItemStack(SlimefunItems.COPPER_INGOT, 4), new SlimefunItemStack(SlimefunItems.COPPER_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ZINC_INGOT, 4), new SlimefunItemStack(SlimefunItems.ZINC_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.TIN_INGOT, 4), new SlimefunItemStack(SlimefunItems.TIN_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT, 4), new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.LEAD_INGOT, 4), new SlimefunItemStack(SlimefunItems.LEAD_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.SILVER_INGOT, 4), new SlimefunItemStack(SlimefunItems.SILVER_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.GOLD_24K, 1), new SlimefunItemStack(SlimefunItems.GOLD_DUST, 8))
                .addRecipe(new ItemStack(Material.IRON_INGOT, 4), new SlimefunItemStack(SlimefunItems.IRON_DUST, 8))
                .addRecipe(new SlimefunItemStack(SlimefunItems.MAGNESIUM_INGOT, 4), new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST, 8))
                .ticksPerOutput(1).energyPerTick(240).register(plugin);
                
         new CarbonPress(Groups.ADVANCED_MACHINES, CARBON_PRESS_4, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.CARBON_PRESS_2, SlimefunItems.CARBON_PRESS_2, SlimefunItems.CARBON_PRESS_2,
                SlimefunItems.CARBON_PRESS_2, SlimefunItems.CARBON_PRESS_2, SlimefunItems.CARBON_PRESS_2,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
                }).setCapacity(6400).setEnergyConsumption(800).setProcessingSpeed(240).register(plugin);
        
        new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_GUA, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, SlimefunItems.ELECTRIC_ORE_GRINDER_3, SlimefunItems.ELECTRIC_ORE_GRINDER_3, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, SlimefunItems.ELECTRIC_ORE_GRINDER_3, SlimefunItems.ELECTRIC_ORE_GRINDER_3, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, SlimefunItems.ELECTRIC_ORE_GRINDER_3, SlimefunItems.ELECTRIC_ORE_GRINDER_3, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
        }).addRecipe(new SlimefunItemStack(SlimefunItems.CARBON, 64), new ItemStack(Material.DIAMOND, 16))
                .addRecipe(new ItemStack(Material.COAL, 64), new SlimefunItemStack(SlimefunItems.CARBON, 8))
                .addRecipe(new ItemStack(Material.SAND, 64), new ItemStack(Material.COBBLESTONE, 64))
                .addRecipe(new ItemStack(Material.SOUL_SAND, 64), new ItemStack(Material.NETHERRACK, 64))
                .ticksPerOutput(1).energyPerTick(16000).register(plugin);
        
        
        new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_INGOT_FORMER, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER, INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER, INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER, INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
        }).addRecipe(new SlimefunItemStack(SlimefunItems.COPPER_INGOT, 32), new SlimefunItemStack(SlimefunItems.COPPER_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ZINC_INGOT, 32), new SlimefunItemStack(SlimefunItems.ZINC_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.TIN_INGOT, 32), new SlimefunItemStack(SlimefunItems.TIN_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT, 32), new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.LEAD_INGOT, 32), new SlimefunItemStack(SlimefunItems.LEAD_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.SILVER_INGOT, 32), new SlimefunItemStack(SlimefunItems.SILVER_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.GOLD_24K, 10), new SlimefunItemStack(SlimefunItems.GOLD_DUST, 64))
                .addRecipe(new ItemStack(Material.IRON_INGOT, 32), new SlimefunItemStack(SlimefunItems.IRON_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.MAGNESIUM_INGOT, 32), new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST, 64))
                .ticksPerOutput(1).energyPerTick(3600).register(plugin);
        
          new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_GUA_INGOT_FORMER, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER,INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INFINITY_INGOT_FORMER, INFINITY_INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER, INGOT_FORMER, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, INGOT_FORMER,  Materials.VOID_SINGULARITY, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
        }).addRecipe(new SlimefunItemStack(SlimefunItems.COPPER_INGOT, 64), new SlimefunItemStack(SlimefunItems.COPPER_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ZINC_INGOT, 64), new SlimefunItemStack(SlimefunItems.ZINC_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.TIN_INGOT, 64), new SlimefunItemStack(SlimefunItems.TIN_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.ALUMINUM_INGOT, 64), new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.LEAD_INGOT, 64), new SlimefunItemStack(SlimefunItems.LEAD_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.SILVER_INGOT, 64), new SlimefunItemStack(SlimefunItems.SILVER_DUST, 64))
                .addRecipe(new ItemStack(Material.GOLD_INGOT, 64), new SlimefunItemStack(SlimefunItems.GOLD_DUST, 64))
                .addRecipe(new ItemStack(Material.IRON_INGOT, 64), new SlimefunItemStack(SlimefunItems.IRON_DUST, 64))
                .addRecipe(new SlimefunItemStack(SlimefunItems.MAGNESIUM_INGOT, 64), new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST, 64))
                .ticksPerOutput(1).energyPerTick(7500).register(plugin);

        new MachineBlock(Groups.ADVANCED_MACHINES, URANIUM_EXTRACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2,
                SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3, SlimefunItems.ENHANCED_AUTO_CRAFTER,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(SlimefunItems.SMALL_URANIUM, new ItemStack(Material.COBBLESTONE, 4))
                .addRecipe(SlimefunItems.SMALL_URANIUM, new ItemStack(Material.ANDESITE, 4))
                .addRecipe(SlimefunItems.SMALL_URANIUM, new ItemStack(Material.STONE, 4))
                .addRecipe(SlimefunItems.SMALL_URANIUM, new ItemStack(Material.DIORITE, 4))
                .addRecipe(SlimefunItems.SMALL_URANIUM, new ItemStack(Material.GRANITE, 4))
                .ticksPerOutput(1).energyPerTick(240).register(plugin);
        
         new MachineBlock(Groups.ADVANCED_MACHINES, KILLALL_WITHER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               SlimefunItems.WITHER_ASSEMBLER, SlimefunItems.WITHER_ASSEMBLER, SlimefunItems.WITHER_ASSEMBLER,
               SlimefunItems.WITHER_ASSEMBLER, SlimefunItems.WITHER_ASSEMBLER, SlimefunItems.WITHER_ASSEMBLER,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
              }).addRecipe(new ItemStack(Material.NETHER_STAR, 1), new ItemStack(Material.SOUL_SAND, 4), new ItemStack(Material.WITHER_SKELETON_SKULL, 3))
               .ticksPerOutput(1).energyPerTick(1500).register(plugin);
        
         new MachineBlock(Groups.ADVANCED_MACHINES, INFINITY_GUA_CIRCUIT, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT,
               Materials.INFINITE_CIRCUIT, Blocks.INFINITY_FORGE, Materials.INFINITE_CIRCUIT,
               Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT,
              }).addRecipe(new SlimefunItemStack(Materials.INFINITE_CIRCUIT, 1), new SlimefunItemStack(Materials.INFINITE_INGOT, 8), new SlimefunItemStack(Materials.VOID_INGOT, 8))
               .ticksPerOutput(1).energyPerTick(100000).register(plugin);
        
         new MachineBlock(Groups.ADVANCED_MACHINES, INFINITY_GUA_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               Materials.INFINITE_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_INGOT,
               Materials.INFINITE_CORE, Blocks.INFINITY_FORGE, Materials.INFINITE_CORE,
               Materials.INFINITE_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_INGOT,
              }).addRecipe(new SlimefunItemStack(Materials.INFINITE_CORE, 1), new SlimefunItemStack(Materials.INFINITE_INGOT, 8), new SlimefunItemStack(Materials.VOID_INGOT, 8))
               .ticksPerOutput(1).energyPerTick(100000).register(plugin);
        
        new MachineBlock(Groups.ADVANCED_MACHINES, QUARTZ_EXTRACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2, SlimefunItems.ELECTRIC_ORE_GRINDER_2,
                SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3, SlimefunItems.ELECTRIC_GOLD_PAN_3,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new ItemStack(Material.QUARTZ, 1), new ItemStack(Material.NETHERRACK, 8 ))
               .ticksPerOutput(1).energyPerTick(1200).register(plugin);
        
        new MachineBlock(Groups.ADVANCED_MACHINES, ADVANCED_QUARTZ_EXTRACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               QUARTZ_EXTRACTOR, QUARTZ_EXTRACTOR, QUARTZ_EXTRACTOR,
               QUARTZ_EXTRACTOR, QUARTZ_EXTRACTOR, QUARTZ_EXTRACTOR,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new ItemStack(Material.QUARTZ, 4), new ItemStack(Material.NETHERRACK, 16))
               .ticksPerOutput(1).energyPerTick(3200).register(plugin);
        
        new MachineBlock(Groups.ADVANCED_MACHINES, GUA_MODI, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               Materials.VOID_INGOT,COBBLE_PRESS, Materials.VOID_INGOT,
               Materials.VOID_INGOT,COBBLE_PRESS, Materials.VOID_INGOT,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new ItemStack(Material.END_STONE, 4), new ItemStack(Material.COBBLESTONE, 4))
               .ticksPerOutput(4).energyPerTick(240).register(plugin);
        
           new MachineBlock(Groups.ADVANCED_MACHINES, GUA_SHENBAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
               Materials.VOID_INGOT,Materials.VOID_INGOT, Materials.VOID_INGOT,
               Materials.VOID_INGOT,COBBLE_PRESS, Materials.VOID_INGOT,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new ItemStack(Material.DEEPSLATE, 4), new ItemStack(Material.COBBLESTONE, 4))
               .ticksPerOutput(4).energyPerTick(240).register(plugin);
        new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_QUARTZ_EXTRACTOR, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, ADVANCED_QUARTZ_EXTRACTOR, ADVANCED_QUARTZ_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, ADVANCED_QUARTZ_EXTRACTOR, ADVANCED_QUARTZ_EXTRACTOR, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
         }).addRecipe(new ItemStack(Material.QUARTZ, 32), new ItemStack(Material.NETHERRACK, 64))
               .ticksPerOutput(1).energyPerTick(25600).register(plugin);
        
         new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_REDSTONE, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Quarries.VOID_QUARRY, Quarries.VOID_QUARRY,Quarries.VOID_QUARRY, Quarries.VOID_QUARRY,Materials.VOID_INGOT,
                Materials.VOID_INGOT, Quarries.REDSTONE_OSCILLATOR,Quarries.REDSTONE_OSCILLATOR, Quarries.REDSTONE_OSCILLATOR,Quarries.REDSTONE_OSCILLATOR, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Quarries.REDSTONE_OSCILLATOR,Quarries.REDSTONE_OSCILLATOR, Quarries.REDSTONE_OSCILLATOR,Quarries.REDSTONE_OSCILLATOR, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Quarries.VOID_QUARRY, Quarries.VOID_QUARRY,Quarries.VOID_QUARRY, Quarries.VOID_QUARRY, Materials.VOID_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
         }).addRecipe(new ItemStack(Material.REDSTONE, 24), new ItemStack(Material.COBBLESTONE, 32))
               .ticksPerOutput(1).energyPerTick(60000).register(plugin);
        
         new MachineBlock(Groups.INFINITY_CHEAT, INFINITY_LAPIS_LAZULI, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Quarries.VOID_QUARRY, Quarries.VOID_QUARRY, Quarries.VOID_QUARRY, Quarries.VOID_QUARRY, Materials.VOID_INGOT,
                Materials.VOID_INGOT,Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Materials.VOID_INGOT,
                Materials.VOID_INGOT,Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Quarries.LAPIS_OSCILLATOR, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Quarries.VOID_QUARRY,Quarries.VOID_QUARRY, Quarries.VOID_QUARRY,Quarries.VOID_QUARRY, Materials.VOID_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
         }).addRecipe(new ItemStack(Material.LAPIS_LAZULI, 24), new ItemStack(Material.COBBLESTONE, 32))
               .ticksPerOutput(1).energyPerTick(60000).register(plugin);
        
        new MachineBlock(Groups.ADVANCED_MACHINES, DECOMPRESSOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, Materials.MAGSTEEL_PLATE, Materials.MAGSTEEL_PLATE,
                new ItemStack(Material.STICKY_PISTON), SlimefunItems.ELECTRIC_PRESS_2, new ItemStack(Material.STICKY_PISTON),
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT,
        }).addRecipe(new ItemStack(Material.EMERALD, 9), new ItemStack(Material.EMERALD_BLOCK))
                .addRecipe(new ItemStack(Material.DIAMOND, 9), new ItemStack(Material.DIAMOND_BLOCK))
                .addRecipe(new ItemStack(Material.GOLD_INGOT, 9), new ItemStack(Material.GOLD_BLOCK))
                .addRecipe(new ItemStack(Material.IRON_INGOT, 9), new ItemStack(Material.IRON_BLOCK))
                .addRecipe(new ItemStack(Material.NETHERITE_INGOT, 9), new ItemStack(Material.NETHERITE_BLOCK))
                .addRecipe(new ItemStack(Material.REDSTONE, 9), new ItemStack(Material.REDSTONE_BLOCK))
                .addRecipe(new ItemStack(Material.QUARTZ, 4), new ItemStack(Material.QUARTZ_BLOCK))
                .addRecipe(new ItemStack(Material.LAPIS_LAZULI, 9), new ItemStack(Material.LAPIS_BLOCK))
                .addRecipe(new ItemStack(Material.COAL, 9), new ItemStack(Material.COAL_BLOCK))
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_4, 8), Materials.COBBLE_5)
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_3, 8), Materials.COBBLE_4)
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_2, 8), Materials.COBBLE_3)
                .addRecipe(new SlimefunItemStack(Materials.COBBLE_1, 8), Materials.COBBLE_2)
                .addRecipe(new ItemStack(Material.COBBLESTONE, 8), Materials.COBBLE_1)
                .ticksPerOutput(1).energyPerTick(60).register(plugin);

        new GearTransformer(Groups.ADVANCED_MACHINES, GEAR_TRANSFORMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL_PLATE,
                Materials.MACHINE_CIRCUIT, new ItemStack(Material.SMITHING_TABLE), Materials.MACHINE_CIRCUIT,
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL_PLATE
        }, GEAR_TRANSFORMER_ENERGY).register(plugin);

        new GeoQuarry(Groups.ADVANCED_MACHINES, GEO_QUARRY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
                Materials.VOID_INGOT, SlimefunExtension.ADVANCED_GEO_MINER, Materials.VOID_INGOT,
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
        }).ticksPerOutput(GEO_QUARRY_INTERVAL).energyPerTick(GEO_QUARRY_ENERGY).register(plugin);

        new MachineBlock(Groups.ADVANCED_MACHINES, CONCRETE_MOLDING_MACHINE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Materials.VOID_INGOT, Materials.VOID_DUST, Materials.VOID_INGOT,
            Materials.VOID_INGOT, SlimefunItems.FLUID_PUMP, Materials.VOID_INGOT,
            SlimefunItems.AUTO_DRIER, SlimefunItems.BIG_CAPACITOR, SlimefunItems.AUTO_DRIER
        }).addRecipe(new ItemStack(Material.WHITE_CONCRETE, 8), new ItemStack(Material.WHITE_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.ORANGE_CONCRETE, 8), new ItemStack(Material.ORANGE_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.MAGENTA_CONCRETE, 8), new ItemStack(Material.MAGENTA_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.LIGHT_BLUE_CONCRETE, 8), new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.YELLOW_CONCRETE, 8), new ItemStack(Material.YELLOW_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.LIME_CONCRETE, 8), new ItemStack(Material.LIME_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.PINK_CONCRETE, 8), new ItemStack(Material.PINK_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.GRAY_CONCRETE, 8), new ItemStack(Material.GRAY_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.LIGHT_GRAY_CONCRETE, 8), new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.CYAN_CONCRETE, 8), new ItemStack(Material.CYAN_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.PURPLE_CONCRETE, 8), new ItemStack(Material.PURPLE_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.BLUE_CONCRETE, 8), new ItemStack(Material.BLUE_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.BROWN_CONCRETE, 8), new ItemStack(Material.BROWN_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.GREEN_CONCRETE, 8), new ItemStack(Material.GREEN_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.RED_CONCRETE, 8), new ItemStack(Material.RED_CONCRETE_POWDER, 8))
            .addRecipe(new ItemStack(Material.BLACK_CONCRETE, 8), new ItemStack(Material.BLACK_CONCRETE_POWDER, 8))
            .ticksPerOutput(1).energyPerTick(80).register(plugin);
    }

    private static final class RandomizedItemStack extends ItemStack {

        private final ItemStack[] items;

        public RandomizedItemStack(ItemStack... outputs) {
            super(outputs[0]);
            this.items = outputs;
        }

        @Nonnull
        @Override
        public ItemStack clone() {
            return this.items[ThreadLocalRandom.current().nextInt(this.items.length)].clone();
        }

    }

}
