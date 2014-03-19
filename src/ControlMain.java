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
	 * DVD主数组结构<br>
	 * User中DVDUser以DVD下标辨识DVD，所以不可删除<br>
	 */
	private ArrayList<DVD> dVDMainDateArrayList;
	
	/**
	 * Style数组结构
	 */
	private ArrayList<Style> dVDStyleArrayList;
	
	/**
	 * 用户列表
	 */
	private ArrayList<User> usersMainDateArrayList;
	
	/**
	 * 唯一的构造方法<br>
	 * 初始化主数组结构ArrayList
	 */
	public ControlMain() {
		this.dVDMainDateArrayList = new ArrayList<DVD>();
		this.dVDStyleArrayList = new ArrayList<Style>();
		this.usersMainDateArrayList = new ArrayList<User>();
	}
	
	// TO DO 在DVD类使用设置租买限制时，要添加一个可设置限制的DVDadd
	
	/**
	 * 添加一个DVD，附带完整DVD参数
	 * @param title
	 * @param year
	 * @param style	注意商和
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 */
	public void addDVD(String title, int year, long style, int amount, boolean sell, boolean rent, double buyPrice, double rentPrice) {
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
	}
	
	/**
	 * 添加一个DVD，自动计算是否可租可卖
	 * @param title
	 * @param year
	 * @param style	注意商和
	 * @param amount
	 * @param buyprice
	 * @param rentPrice
	 */
	public void addDVD(String title, int year, long style, int amount, double buyPrice, double rentPrice) {
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
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
	}
	
	/**
	 * 添加一个Style
	 * @param name
	 * @return 重名返回false
	 */
	public boolean addStyle(String name){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getName().equals(name)) {
				return false;
			}
		}
		this.dVDStyleArrayList.add( new Style(name) );
		return true;
	}

	/**
	 * 从Index获取Style名<br>
	 * 遍历用<br>
	 * <br>
	 * Java没有size_type吗.<br>
	 * @param Index
	 * @return	找不到，返回null
	 */
	public String getStyle(int Index){
		if (Index < this.dVDStyleArrayList.size()) {
			return this.dVDStyleArrayList.get(Index).getName();
		}
		return null;
	}
	
	/**
	 * 从ID获取Style名<br>
	 * @param ID
	 * @return	找不到，返回null
	 */
	public String getStyle( long ID){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getID() == ID) {
				return a.getName();
			}
		}
		return null;
	}
	
	/**
	 * 添加一个用户<br>
	 * 并初始化现金额度<br>
	 * @return dVDMainDateArrayList句柄为null时返回false
	 */
	public boolean addOneUser( double money) {
		if (this.dVDMainDateArrayList != null) {
			usersMainDateArrayList.add(new User(money, this.dVDMainDateArrayList));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取指定用户对象<br>
	 * 遍历用<br>
	 * @param Index	下标
	 * @return	超出范围返回null
	 */
	public User getUser(int Index) {
		if (Index > this.usersMainDateArrayList.size()) {
			return null;
		}
		return this.usersMainDateArrayList.get(Index);
	}
	
	/**
	 * 获取指定用户对象<br>
	 * 查找<br>
	 * @param name		用户名
	 * @return	找不到返回null
	 */
	public User getUser(String name) {
		for (User a : this.usersMainDateArrayList) {
			// 注意：有为null字符串的用户
			// 其实，只要不为null，仅仅为""都不需要检测null
			if (a.getName() != null) {
				if (a.getName().equals(name)) {
					return a;
				}
			}
		}
		return null;
	}

	/**
	 * 获取指定DVD对象<br>
	 * 遍历用<br>
	 * @param Index	下标
	 * @return	超出范围返回null
	 */
	public DVD getDVD(int Index) {
		if (Index > this.dVDMainDateArrayList.size()) {
			return null;
		}
		return this.dVDMainDateArrayList.get(Index);
	}
	
	/**
	 * 获取指定DVD对象<br>
	 * 查找用<br>
	 * @param Title		名字
	 * @return	超出范围返回null
	 */
	public DVD getDVD(String Title) {
		for (DVD a : this.dVDMainDateArrayList) {
			if (a.getTitle().equals(Title)) {
				return a;
			}
		}
		return null;
	}
	

}
