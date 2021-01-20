
public class ComboBoxDisplayItem {
	private int value;
    private String label;

    public ComboBoxDisplayItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}
