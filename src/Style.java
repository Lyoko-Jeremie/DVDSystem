import java.util.Random;

/**
 * 为提高扩展性而为DVD标注Style
 */

/**
 * DVD风格类<br>
 * 使用ID来标注风格以便于搜索使用<br>
 * @author Jeremie
 *
 */
public class Style {
	private String Name;
	private long ID;
	/**
	 * 唯一的构造函数
	 * @param name
	 * @param iD
	 */
	public Style(String name) {
		this.Name = name;
		Random r = new Random();
		this.ID = r.nextLong();
		// System.out.println(this.ID);
	}
	/**
	 * @return name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return iD
	 */
	public long getID() {
		return ID;
	}
	

}



