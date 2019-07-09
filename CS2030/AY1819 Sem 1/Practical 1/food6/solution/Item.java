abstract class Item {
    protected static int numOfItems = 0;
    protected String desc;
    protected int price;
    protected int id;

    protected Item() {
        this.id = numOfItems++;
    }

    int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "#" + id + " " + desc + " (" + getPrice() + ")";
    }
}
