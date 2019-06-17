public abstract class Monster {
	private String name;
	
	public Monster(String name) { this.name = name; }
	
	public abstract String getInfo();
	public String getName() { return name; }
}