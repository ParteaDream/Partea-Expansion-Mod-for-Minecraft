package partea.partea_expansion.CustomBlocks.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.screen.QualitativeAnalyzerScreenHandler;

public class QualitativeAnalyzerBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 2;
    private static final int E_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 36;
    public QualitativeAnalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.QUALITATIVE_ANALYZER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> QualitativeAnalyzerBlockEntity.this.progress;
                    case 1 -> QualitativeAnalyzerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> QualitativeAnalyzerBlockEntity.this.progress = value;
                    case 1 -> QualitativeAnalyzerBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.partea_expansion.qualitative_analyzer.title");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new QualitativeAnalyzerScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("polishing_machine",progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
        progress = nbt.getInt("qualitative_analyzer");
    }

    public void tick(World world1, BlockPos pos, BlockState state1) {
        if (world1.isClient()){
            return;
        }
        if (isOutputSlotAvailable()){
            if (this.hasRecipe()){
                this.increaseCraftProgress();
                markDirty(world1,pos,state1);

                if (hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            }else {
                this.resetProgress();
            }
        }else {
            this.resetProgress();
            markDirty(world1, pos, state1);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(ModItems.AMETHYST);
        if (getStack(INPUT_SLOT).getItem() == Items.IRON_AXE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.IRON_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.IRON_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.IRON_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HOE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HORSE_ARMOR){
            result = new ItemStack(Items.IRON_INGOT);
        }
        if (getStack(INPUT_SLOT).getItem() == Items.DIAMOND_AXE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HOE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HORSE_ARMOR){
            result = new ItemStack(Items.DIAMOND);
        }
        if (getStack(INPUT_SLOT).getItem() == Items.GOLDEN_AXE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HOE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HORSE_ARMOR){
            result = new ItemStack(Items.GOLD_INGOT);
        }
        if (getStack(INPUT_SLOT).getItem() == ModItems.AMETHYST_STILLETO
                || getStack(INPUT_SLOT).getItem() == ModItems.AMETHYST_SWORD){
            result = new ItemStack(Items.AMETHYST_SHARD);
        }
        if (getStack(INPUT_SLOT).getItem() == ModItems.RAW_AZURE){
            result = new ItemStack(ModItems.AZURE_INGOT);
        }
        if (getStack(INPUT_SLOT).getItem() == Items.COAL
                || getStack(INPUT_SLOT).getItem() == Items.CHARCOAL){
            result = new ItemStack(Items.GLOWSTONE_DUST);
        }
        if (getStack(INPUT_SLOT).getItem() == Items.ENDER_EYE
                || getStack(INPUT_SLOT).getItem() == Items.ENDER_PEARL){
            result = new ItemStack(ModItems.ANCIENT_PEARL);
        }
        this.removeStack(INPUT_SLOT,1);
        this.removeStack(E_SLOT,1);
        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.AMETHYST);
        boolean hasInput = (getStack(INPUT_SLOT).getItem() == ModItems.CRUDE_AMETHYST);
        if (getStack(INPUT_SLOT).getItem() == Items.IRON_AXE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.IRON_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.IRON_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.IRON_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HOE
                || getStack(INPUT_SLOT).getItem() == Items.IRON_HORSE_ARMOR){
            result = new ItemStack(Items.IRON_INGOT);
            return EhasCOD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.DIAMOND_AXE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HOE
                || getStack(INPUT_SLOT).getItem() == Items.DIAMOND_HORSE_ARMOR){
            result = new ItemStack(Items.DIAMOND);
            return EhasCOD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.GOLDEN_AXE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_PICKAXE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_SHOVEL
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_SWORD
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HELMET
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_CHESTPLATE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_LEGGINGS
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_BOOTS
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HOE
                || getStack(INPUT_SLOT).getItem() == Items.GOLDEN_HORSE_ARMOR){
            result = new ItemStack(Items.GOLD_INGOT);
            return EhasCOD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == ModItems.AMETHYST_STILLETO
                || getStack(INPUT_SLOT).getItem() == ModItems.AMETHYST_SWORD){
            result = new ItemStack(Items.AMETHYST_SHARD);
            return EhasCOD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == ModItems.RAW_AZURE){
            result = new ItemStack(ModItems.AZURE_INGOT);
            return EhasNS() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.COAL
                || getStack(INPUT_SLOT).getItem() == Items.CHARCOAL){
            result = new ItemStack(Items.GLOWSTONE_DUST);
            return EhasQD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.ENDER_EYE
                || getStack(INPUT_SLOT).getItem() == Items.ENDER_PEARL){
            result = new ItemStack(ModItems.ANCIENT_PEARL);
            return EhasCOD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }



        return EhasCLD() && hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean isOutputSlotAvailable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
    private boolean EhasCOD(){
        return this.getStack(E_SLOT).getItem() == ModItems.CRYING_OBSIDIAN_DUST;
    }
    private boolean EhasCLD(){
        return this.getStack(E_SLOT).getItem() == ModItems.CRYSTALLIZED_LAPIS_DUST;
    }
    private boolean EhasQD(){
        return this.getStack(E_SLOT).getItem() == ModItems.QUARTZ_DUST;
    }
    private boolean EhasNS(){
        return this.getStack(E_SLOT).getItem() == Items.NETHER_STAR;
    }
}
