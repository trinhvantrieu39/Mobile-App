package giaodien;

public class LeftMenuItem {
	private String name;
	private String iconName;
	public LeftMenuItem(String name, String iconName) {
		this.name = name;
		this.iconName = iconName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	@Override
	public String toString() {
		return name;
	}
}
