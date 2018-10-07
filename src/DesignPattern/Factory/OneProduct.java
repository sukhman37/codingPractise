package DesignPattern.Factory;

public class OneProduct extends Product{

	static{
		Factory.registerProduct("P1", new OneProduct());
	}
	
	@Override
	public Product createProduct() {
		return new OneProduct();
	}

	@Override
	public String productName() {
		return "First Product";
	}

}
