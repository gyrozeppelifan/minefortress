package org.minefortress.interfaces;

import net.minecraft.util.math.BlockPos;
import org.minefortress.blueprints.BlueprintBlockDataManager;
import org.minefortress.blueprints.BlueprintManager;
import org.minefortress.blueprints.BlueprintMetadataManager;
import org.minefortress.fortress.FortressClientManager;
import org.minefortress.renderer.gui.FortressHud;
import org.minefortress.selections.SelectionManager;

public interface FortressMinecraftClient {

    SelectionManager getSelectionManager();
    FortressHud getFortressHud();
    BlueprintManager getBlueprintManager();
    BlueprintMetadataManager getBlueprintMetadataManager();
    FortressClientManager getFortressClientManager();
    BlueprintBlockDataManager getBlueprintBlockDataManager();
    boolean isNotFortressGamemode();
    boolean isFortressGamemode();
    BlockPos getHoveredBlockPos();

}
