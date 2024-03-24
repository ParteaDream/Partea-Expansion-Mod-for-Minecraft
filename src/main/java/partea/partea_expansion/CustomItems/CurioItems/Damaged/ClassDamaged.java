package partea.partea_expansion.CustomItems.CurioItems.Damaged;

import net.minecraft.item.Item;
import partea.partea_expansion.CustomItems.CurioItems.ClassCurioItem;

public class ClassDamaged extends ClassCurioItem {
    Item product;

    public ClassDamaged(Settings settings) {
        super(settings);
    }
    public Item getProduct(){
        return product;
    }
}
