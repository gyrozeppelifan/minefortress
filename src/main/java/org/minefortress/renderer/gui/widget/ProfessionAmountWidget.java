package org.minefortress.renderer.gui.widget;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ProfessionAmountWidget extends MinefortressWidget implements Drawable, Element {

    private final int x;
    private final int y;
    private final ItemStack stack;
    private final Supplier<Integer> amountSupplier;

    public ProfessionAmountWidget(int x, int y, ItemStack stack, Supplier<Integer> profAmountSupplier) {
        this.x = x;
        this.y = y;
        this.stack = stack;
        this.amountSupplier = profAmountSupplier;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        final var itemRenderer = getItemRenderer();
        itemRenderer.renderGuiItemIcon(stack, x, y);
        itemRenderer.renderGuiItemOverlay(getTextRenderer(), stack, x, y, String.valueOf(amountSupplier.get()));
    }

}
