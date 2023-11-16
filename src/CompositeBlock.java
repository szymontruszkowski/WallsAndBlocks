import java.util.List;

interface CompositeBlock extends Block {

    List<Block> getBlocks();

    void getAllCmpBlocks(List<Block> resBlocks);
}
