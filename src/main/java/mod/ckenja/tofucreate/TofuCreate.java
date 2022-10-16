package mod.ckenja.tofucreate;

import baguchan.tofucraft.registry.TofuBlocks;
import com.mojang.logging.LogUtils;
import com.simibubi.create.AllMovementBehaviours;
import com.simibubi.create.Create;
import com.simibubi.create.api.event.TileEntityBehaviourEvent;
import com.simibubi.create.content.contraptions.components.press.MechanicalPressTileEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import mod.ckenja.tofucreate.create.BlockPressBehaviour;
import mod.ckenja.tofucreate.create.BlockPressMovementBehavior;
import mod.ckenja.tofucreate.create.SpoutTofu;
import mod.ckenja.tofucreate.register.AllBlocks;
import mod.ckenja.tofucreate.register.AllFluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.simibubi.create.api.behaviour.BlockSpoutingBehaviour.addCustomSpoutInteraction;

@Mod(BuildConfig.MODID)
public class TofuCreate {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
    public static final CreateRegistrate registrate = CreateRegistrate.lazy(BuildConfig.MODID).get();
    public TofuCreate(){
        addCustomSpoutInteraction(Create.asResource("tofucreate"), new SpoutTofu());
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        forgeEventBus.addGenericListener(MechanicalPressTileEntity.class, (TileEntityBehaviourEvent<MechanicalPressTileEntity> event) -> event
                .attach(new BlockPressBehaviour(event.getTileEntity())));
        AllFluids.register();
        AllBlocks.register(modEventBus);
        //AllMovementBehaviours.registerBehaviour(AllBlocks.MECHANICAL_PRESS.get(), new BlockPressMovementBehavior());
        //AllMovementBehaviours.registerBehaviour(AllBlocks.SPOUT.get(), new BlockSpoutMovementBehavior());
        //AllRecipeTypes.register(modEventBus);
        //https://cadiboo.github.io/tutorials/1.15.2/forge/1.4-proxies/
        //プロキシ、いらない
        //DistExecutor.safeRunForDist(()-> ClientProxy::new, () -> ServerProxy::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("登録");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        //使い道、なさそう
    }

    private void processIMC(final InterModProcessEvent event) {
        //そもそも名前なんでこんなわかりにくやつなの
    }
}