package lab3;

/**
 * Class representing a clothing item with basic attributes.
 */
class Clothing {
  // Class fields
  private String type;         // Type of clothing
  private String brand;        // Brand
  private double price;        // Price
  private String color;        // Color
  private String size;         // Size

  /**
   * Constructor to create a clothing object.
   * 
   * @param type  Type of clothing
   * @param brand Brand name
   * @param price Price of the item
   * @param color Color of the item
   * @param size  Size of the item
   */
  public Clothing(String type, String brand, double price, String color, String size) {
      this.type = type;
      this.brand = brand;
      this.price = price;
      this.color = color;
      this.size = size;
  }

  // Getters for the fields
  public String getType() { return type; }
  public String getBrand() { return brand; }
  public double getPrice() { return price; }
  public String getColor() { return color; }
  public String getSize() { return size; }

  /**
   * Overridden toString method for displaying clothing information.
   * 
   * @return Formatted string with clothing details
   */
  @Override
  public String toString() {
      return String.format("Clothing: type=%s, brand=%s, price=%.2f, color=%s, size=%s", 
                            type, brand, price, color, size);
  }

  /**
   * Overridden equals method to compare clothing objects.
   * 
   * @param obj Object to compare
   * @return true if objects have identical properties
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;

      Clothing clothing = (Clothing) obj;
      return Double.compare(clothing.price, price) == 0 &&
             type.equals(clothing.type) &&
             brand.equals(clothing.brand) &&
             color.equals(clothing.color) &&
             size.equals(clothing.size);
  }
}
