import java.util.Random;

/**
 * Ϊ�����չ�Զ�ΪDVD��עStyle
 */

/**
 * DVD�����<br>
 * ʹ��ID����ע����Ա�������ʹ��<br>
 * @author Jeremie
 *
 */
public class Style {
	private String Name;
	private long ID;
	/**
	 * Ψһ�Ĺ��캯��
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
	 * @param name Ҫ���õ� name
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



