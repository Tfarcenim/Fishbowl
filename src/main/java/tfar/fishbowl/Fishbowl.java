package tfar.fishbowl;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fishbowl.MODID)
public class Fishbowl {
    // Directly reference a log4j logger.

    public static final String MODID = "fishbowl";

    private static final Logger LOGGER = LogManager.getLogger();

    public static final IArmorMaterial GLASS = new IArmorMaterial() {
        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return 22;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 1;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return SoundEvents.BLOCK_GLASS_STEP;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromTag(Tags.Items.GLASS_COLORLESS);
        }

        @Override
        public String getName() {
            return MODID+":glass";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    };

    public static final Item FISH_BOWL = new ArmorItem(GLASS,EquipmentSlotType.HEAD,new Item.Properties().group(ItemGroup.COMBAT));

    public Fishbowl() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addGenericListener(Item.class,this::items);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void items(final RegistryEvent.Register<Item> e) {
        // register a new block here
        e.getRegistry().register(FISH_BOWL.setRegistryName("fish_bowl"));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
