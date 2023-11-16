/**
 * Implementation class for Block interface.
 */
public class DefaultBlock implements Block {

    private String color;

    private String material;

    public DefaultBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "DefaultBlock{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
