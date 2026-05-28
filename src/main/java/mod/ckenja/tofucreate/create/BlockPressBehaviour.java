package mod.ckenja.tofucreate.create;

import baguchan.tofucraft.utils.RecipeHelper;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BehaviourType;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static com.simibubi.create.content.kinetics.press.PressingBehaviour.CYCLE;
import static com.simibubi.create.content.kinetics.press.PressingBehaviour.ENTITY_SCAN;

public class BlockPressBehaviour extends BlockEntityBehaviour {

    public static final BehaviourType<BlockPressBehaviour> TYPE = new BehaviourType<>();
    //public PressingBehaviour pressingBehaviour;
    public MechanicalPressBlockEntity pressTileEntity;
    int entityScanCooldown;
    boolean onBlock;
    Block lastBlock;
    ItemStack lastResult = ItemStack.EMPTY;

    public BlockPressBehaviour(MechanicalPressBlockEntity tileEntity) {
        super(tileEntity);
        pressTileEntity = tileEntity;
        onBlock = false;
        entityScanCooldown = ENTITY_SCAN;
    }
    public BehaviourType<?> getType(){
        return TYPE;
        //return new BehaviourType<>("tofu_block_press_behaviour");
    }

    @Override
    public void tick() {
        super.tick();

        Level level = getWorld();
        BlockPos worldPosition = getPos();
        if(!pressTileEntity.pressingBehaviour.running || level == null){
            if(level != null && !level.isClientSide) {
                if (pressTileEntity.getKineticSpeed() == 0)
                    return;
                if (entityScanCooldown > 0)
                    entityScanCooldown--;
                if (entityScanCooldown <= 0) {
                    entityScanCooldown = ENTITY_SCAN;
                    if(level.getBlockState(worldPosition.below(2)).getBlock() != lastBlock) {
                        lastBlock = level.getBlockState(worldPosition.below(2)).getBlock();
                        ItemStack result = RecipeHelper.getTofu((ServerLevel) level, level.getBlockState(worldPosition.below(2)).getBlock());
                        if (result != null) {
                            lastResult = result.copy();
                            onBlock = true;
                            pressTileEntity.pressingBehaviour.running = true;
                            pressTileEntity.pressingBehaviour.prevRunningTicks = 0;
                            pressTileEntity.pressingBehaviour.runningTicks = 0;
                            pressTileEntity.pressingBehaviour.particleItems.clear();
                            pressTileEntity.pressingBehaviour.mode.headOffset = 19f / 16f;
                            blockEntity.sendData();
                        }else {
                            lastResult = ItemStack.EMPTY;
                        }
                    }else {
                        if (this.lastResult != null && this.lastResult != ItemStack.EMPTY) {
                            onBlock = true;
                            pressTileEntity.pressingBehaviour.running = true;
                            pressTileEntity.pressingBehaviour.prevRunningTicks = 0;
                            pressTileEntity.pressingBehaviour.runningTicks = 0;
                            pressTileEntity.pressingBehaviour.particleItems.clear();
                            pressTileEntity.pressingBehaviour.mode.headOffset = 19f / 16f;
                            blockEntity.sendData();
                        }
                    }
                }
            }
            return;
        }
        if (pressTileEntity.pressingBehaviour.runningTicks == CYCLE / 2 && pressTileEntity.getKineticSpeed() != 0) {
            pressTileEntity.pressingBehaviour.particleItems.clear();
            if (onBlock) {
                onBlock = false;
                if (level.isClientSide)
                    return;
                else
                    blockEntity.sendData();

                if (lastResult.isEmpty())
                    return;
                if (level.random.nextInt(30) != 0) {
                    level.levelEvent(2001, worldPosition.below(2), Block.getId(level.getBlockState(worldPosition.below(2))));

                    return;
                }
                level.setBlock(worldPosition.below(2), Block.byItem(lastResult.getItem()).defaultBlockState(), 11);
                level.levelEvent(2001, worldPosition.below(2), Block.getId(level.getBlockState(worldPosition.below(2))));
            }
        }
    }
}
