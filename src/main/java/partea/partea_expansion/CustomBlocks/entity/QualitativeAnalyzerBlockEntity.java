package partea.partea_expansion.CustomBlocks.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

import java.util.Random;

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
        Random random = new Random();
        //赌博质变
        if (getStack(INPUT_SLOT).getItem() == ModItems.NETHER_SUSPICIOUS_STONE){
            float r = random.nextFloat();
            if(r < 0.03){
                result = new ItemStack(Items.NETHERITE_SCRAP, 1);
            } else if (r >= 0.03 && r < 0.08) {
                result = new ItemStack(Items.DIAMOND, 1);
            } else if (r >= 0.08 && r < 0.15) {
                result = new ItemStack(Items.EMERALD, 2);
            } else if (r >= 0.15 && r < 0.32) {
                result = new ItemStack(Items.RAW_GOLD, 2);
            } else if (r >= 0.32 && r < 0.45 ) {
                result = new ItemStack(Items.RAW_IRON, 3);
            } else if (r >= 0.45 && r < 0.55) {
                result = new ItemStack(Items.RAW_COPPER, 3);
            } else if (r >= 0.55 && r < 0.8) {
                result = new ItemStack(Items.COAL, 3);
            } else if (r >= 0.8 && r < 0.84) {
                result = new ItemStack(Items.LAPIS_LAZULI, 3);
            } else if (r >= 0.84 && r < 0.88){
                result = new ItemStack(Items.REDSTONE, 5);
            } else if (r >= 0.88 && r < 0.95){
                result = new ItemStack(Items.AMETHYST_SHARD, 5);
            } else if (r >= 0.95){
                result = new ItemStack(ModItems.SUSPICIOUS_SQUAMA, 1);
            }
        }
        if (getStack(INPUT_SLOT).getItem() == ModItems.SUSPICIOUS_STONE){
            float r = random.nextFloat();
            if(r < 0.016){
                result = new ItemStack(Items.NETHERITE_SCRAP, 1);
            } else if (r >= 0.016 && r < 0.06) {
                result = new ItemStack(Items.DIAMOND, 1);
            } else if (r >= 0.06 && r < 0.12) {
                result = new ItemStack(Items.EMERALD, 2);
            } else if (r >= 0.12 && r < 0.25) {
                result = new ItemStack(Items.RAW_GOLD, 2);
            } else if (r >= 0.25 && r < 0.45 ) {
                result = new ItemStack(Items.RAW_IRON, 3);
            } else if (r >= 0.45 && r < 0.55) {
                result = new ItemStack(Items.RAW_COPPER, 3);
            } else if (r >= 0.55 && r < 0.8) {
                result = new ItemStack(Items.COAL, 3);
            } else if (r >= 0.8 && r < 0.84) {
                result = new ItemStack(Items.LAPIS_LAZULI, 3);
            } else if (r >= 0.84 && r < 0.88){
                result = new ItemStack(Items.REDSTONE, 5);
            } else if (r >= 0.88 && r < 0.95){
                result = new ItemStack(Items.AMETHYST_SHARD, 5);
            } else if (r >= 0.95){
                result = new ItemStack(ModItems.SUSPICIOUS_SQUAMA, 1);
            }
        }
        if (getStack(INPUT_SLOT).getItem() == Items.TOTEM_OF_UNDYING){
            result = new ItemStack(Items.TOTEM_OF_UNDYING, random.nextInt(0,2));
            this.removeStack(INPUT_SLOT,random.nextInt(0,1));
            this.removeStack(E_SLOT,1);
            this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
        }
        if (getStack(INPUT_SLOT).getItem() == Items.EMERALD){
            result = new ItemStack(Items.EMERALD);
            float r = random.nextFloat();
            if(r < 0.55){
                this.removeStack(INPUT_SLOT,0);
                this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + 1));
            }else{
                this.removeStack(INPUT_SLOT,1);
            }
            this.removeStack(E_SLOT,1);
            return;
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
        Random random = new Random();
        //赌博质变
        if (getStack(INPUT_SLOT).getItem() == ModItems.SUSPICIOUS_STONE ||
                getStack(INPUT_SLOT).getItem() == ModItems.NETHER_SUSPICIOUS_STONE){
            result = new ItemStack(Blocks.BEDROCK, 1);
            return EhasQD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.TOTEM_OF_UNDYING
                || getStack(INPUT_SLOT).getItem() == Items.TOTEM_OF_UNDYING){
            result = new ItemStack(Items.TOTEM_OF_UNDYING, random.nextInt(0,1));
            return EhasCLD() && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
        }
        if (getStack(INPUT_SLOT).getItem() == Items.EMERALD){
            result = new ItemStack(Items.EMERALD);
            return EhasCLD() && canInsertItemIntoOutputSlot(result.getItem()) && canInsertAmountIntoOutputSlot(result);
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
