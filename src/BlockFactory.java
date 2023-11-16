import java.util.List;

public class BlockFactory {

    public Block createBlock(String color, String material) {
        return new DefaultBlock(color, material);
    }

    public Block createBlock(List<Block> blocks) {
        return new DefaultCompositeBlock(blocks);
    }
}
