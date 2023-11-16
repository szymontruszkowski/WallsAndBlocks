import java.util.List;

public class Main {

    public static void main(String[] args) {

        BlockFactory blockFactory = new BlockFactory();


        Block defaultBlock1 = blockFactory.createBlock("red", "brick");

        Block defaultBlock2 = blockFactory.createBlock("black", "brick");

        Block defaultBlock3 = blockFactory.createBlock("brown", "wood");


        Block defaultCompositeBlock3 = blockFactory.createBlock(List.of(defaultBlock1, defaultBlock3));

        Block defaultCompositeBlock2 = blockFactory.createBlock(List.of(defaultBlock2, defaultCompositeBlock3));

        Block defaultCompositeBlock1 = blockFactory.createBlock(List.of(defaultBlock1, defaultCompositeBlock2, defaultBlock1));


        StructureFactory structureFactory = new WallFactory();
        Structure structure = structureFactory.createStructure(List.of(defaultCompositeBlock1, defaultCompositeBlock2, defaultBlock1));


        System.out.println(structure.count());

        System.out.println(structure.findBlockByColor("brown"));

        System.out.println(structure.findBlocksByMaterial("wood"));

    }
}
