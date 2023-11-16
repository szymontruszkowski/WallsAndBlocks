import java.util.List;

public class WallFactory implements StructureFactory {

    @Override
    public Structure createStructure(List<Block> blocks) {
        return new Wall(blocks);
    }
}
