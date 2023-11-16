import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for CompositeBlock interface.
 */
public class DefaultCompositeBlock implements CompositeBlock {
    
    private List<Block> blocks;

    public DefaultCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {

        String result = "";

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                List<Block> resBlocks = new ArrayList<>();
                getAllCmpBlocks(resBlocks);

                for (Block resBlock : resBlocks) {
                    result += resBlock.getColor() + ", ";
                }
            } else {
                result += block.getColor() + ", ";
            }
        }

        return result.substring(0, result.length() - 2);
    }

    @Override
    public String getMaterial() {

        String result = "";

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                List<Block> resBlocks = new ArrayList<>();
                getAllCmpBlocks(resBlocks);

                for (Block resBlock : resBlocks) {
                    result += resBlock.getMaterial() + ", ";
                }
            } else {
                result += block.getMaterial() + ", ";
            }
        }

        return result.substring(0, result.length() - 2);
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String toString() {
        return "DefaultCompositeBlock{" +
                "blocks=" + blocks +
                '}';
    }

    @Override
    public void getAllCmpBlocks(List<Block> resBlocks) {

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                ((CompositeBlock)block).getAllCmpBlocks(resBlocks);
            } else {
                resBlocks.add(block);
            }
        }
    }
}
