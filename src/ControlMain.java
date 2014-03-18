import java.util.ArrayList;

/**
 * 整个系统核心控制结构<br>
 * @author Jeremie
 */

/**
 * 主系统主要结构<br>
 * @author Jeremie
 */
public class ControlMain {
	
	/**
	 * DVD主数组结构
	 */
	private ArrayList<DVD> dVDMainDateArrayList;
	
	/**
	 * Style数据列		DVD.Style为long，长64^2，可记录64-1个
	 */
	private String[] styleArray;	// = new String[64];
	private static final int STYLE_ARRAY_LONG = 64;
	
	//TODO UserMainDateArrayList
	
	/**
	 * 唯一的构造方法<br>
	 * 初始化主数组结构ArrayList
	 */
	public ControlMain() {
		this.dVDMainDateArrayList = new ArrayList<DVD>();
		this.styleArray = new String[64];
		this.styleArray[0] = new String("");
	}
	/**
	 * 添加一个DVD，附带完整DVD参数
	 * @param title
	 * @param year
	 * @param style	注意商和
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param price
	 */
	public void addDVD(String title, int year, long style, int amount, boolean sell, boolean rent, double price) {
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, price));
	}
	/**
	 * 添加一个DVD，自动计算是否可租可卖
	 * @param title
	 * @param year
	 * @param style	注意商和
	 * @param amount
	 * @param price
	 */
	public void addDVD(String title, int year, long style, int amount, double price) {
		boolean sell;
		if (amount > DVD.getSELL_LIMIT()) {
			sell = true;
		} else {
			sell = false;
		}
		boolean rent;
		if (amount > DVD.getRENT_LIMIT()) {
			rent = true;
		} else {
			rent = false;
		}
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, price));
	}
	/**
	 * @param n	不可大于总长度
	 * @return styleArray	返回NULL对象表示没有设置这个位置
	 */
	public String getStyleName( int n) {
		if (n<STYLE_ARRAY_LONG) {
			return styleArray[n];
		} else {
			return styleArray[0];
		}
	}
	/**
	 * @param n 设置的style的位置
	 * @param style 要设置的 style
	 * @return 超出范围返回false	设置成功返回true
	 */
	public boolean setStyleName( int n, String style) {
		if (n<STYLE_ARRAY_LONG) {
			this.styleArray[n] = style;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 获取整个styleArray<br>
	 * 不可改变内容<br>
	 * @return styleArray
	 */
	public final String[] getStyleArray() {
		return styleArray;
	}
	

}
