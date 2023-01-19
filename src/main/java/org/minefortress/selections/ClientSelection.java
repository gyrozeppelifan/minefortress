package org.minefortress.selections;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vector4f;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

public class ClientSelection {

    private final Set<BlockPos> blockPositions;
    private final Vector4f color;
    private final BiFunction<World, BlockPos, Boolean> shouldRenderBlock;

    public ClientSelection(Iterable<BlockPos> blockPositions,  Vector4f color) {
        this(blockPositions, color, (w, p) -> true);
    }

    public ClientSelection(Iterable<BlockPos> blockPositions,
                           Vector4f color,
                           BiFunction<World, BlockPos, Boolean> shouldRenderBlock) {
        HashSet<BlockPos> positions = new HashSet<>();
        for(BlockPos pos: blockPositions) {
            positions.add(pos.toImmutable());
        }
        this.blockPositions = positions;
        this.color = color;
        this.shouldRenderBlock = shouldRenderBlock;
    }

    public Set<BlockPos> getBlockPositions() {
        return blockPositions;
    }


    public Vector4f getColor() {
        return color;
    }

    public boolean shouldRenderBlock(World world, BlockPos pos) {
        return shouldRenderBlock.apply(world, pos);
    }
}
