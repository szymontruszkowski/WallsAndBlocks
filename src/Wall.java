import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> wallBlocks;

    public Wall(List<Block> wallBlocks) {
        this.wallBlocks = wallBlocks;
    }

    /**
     * Returns any element wit a given color.
     * @param color     the given color
     * @return          the element
     */
    @Override
    public Optional<Block> findBlockByColor(String color) {

        for (Block block : wallBlocks) {
            if (block instanceof CompositeBlock) {
                List<Block> resBlocks = new ArrayList<>();
                ((CompositeBlock) block).getAllCmpBlocks(resBlocks);

                for (Block resBlock : resBlocks) {
                    if (resBlock.getColor().equals(color)) {
                        return Optional.of(resBlock);
                    }
                }
            } else if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    // Przy założeniu, że kompozyt jest koloru X, jeżeli zawiera przynajmniej jeden Block w kolorze X
    // ta metoda mogłaby zostać zastosowana.
    public Optional<Block> findBlockByColor2(String color) {

        for (Block block : wallBlocks) {
            if (block.getColor().contains(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    /**
     * Return all elements made of a given material.
     * @param material      the given material
     * @return              the list of all elements
     */
    @Override
    public List<Block> findBlocksByMaterial(String material) {

        List<Block> matBlocks = new ArrayList<>();

        for (Block block : wallBlocks) {
            if (block instanceof CompositeBlock) {
                List<Block> resBlocks = new ArrayList<>();
                ((CompositeBlock) block).getAllCmpBlocks(resBlocks);

                for (Block resBlock : resBlocks) {
                    if (resBlock.getMaterial().equals(material)) {
                        matBlocks.add(resBlock);
                    }
                }
            } else if (block.getMaterial().equals(material)) {
                matBlocks.add(block);
            }
        }

        return matBlocks;
    }

    // Przy założeniu, że kompozyt jest zbudowany z materiału X, jeżeli zawiera przynajmniej jeden Block zbudowany z materiału X
    // ta metoda mogłaby zostać zastosowana.
    public List<Block> findBlocksByMaterial2(String material) {

        List<Block> matBlocks = new ArrayList<>();

        for (Block block : wallBlocks) {
            if (block.getMaterial().contains(material)) {
                matBlocks.add(block);
            }
        }

        return matBlocks;
    }


        /**
         * Returns the number of all elements that make up the structure.
         * @return      the number of elements
         */
    @Override
    public int count() {

        int counter = 0;

        for (Block wallBlock : wallBlocks) {
            if (wallBlock instanceof CompositeBlock) {
                List<Block> resBlocks = new ArrayList<>();
                ((CompositeBlock)wallBlock).getAllCmpBlocks(resBlocks);
                counter += resBlocks.size();
                continue;
            }
            counter++;
        }

        return counter;
    }

}
