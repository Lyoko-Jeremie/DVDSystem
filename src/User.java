import java.util.ArrayList;

/**
 * 用户类
 */

/**
 * 用户类<br>
 * 做成可扩展的比较好<br>
 * @author Jeremie
 *
 */
public class User {
	/**
	 * 已经买到的和已经借到的DVD列
	 */
	private ArrayList<DVDUser> userDVDArrayList; //= new ArrayList<DVDUser>();
	/**
	 * 现金
	 */
	private double money;
	/**
	 * 指向主数据链的句柄
	 */
	private ArrayList<DVD> dateHandle;
	/**
	 * 唯一的构造函数<br>
	 * @param money	初始金额
	 * @param Handle	指向主数据链的句柄
	 */
	public User(double money, ArrayList<DVD> Handle) {
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
		this.dateHandle = Handle;
		if (Handle==null) {
			throw new ExceptionInInitializerError(new Throwable("Handle Cant are null !!"));
		}
	}
	
	/**
	 * 增加现金数量<br>
	 * 可以是负数<br>
	 * @param m	增加的量
	 * @return	增加后的量
	 */
	public double addMoney(double m) {
		this.money += m;
		return this.money;
	}

	/**
	 * 借一个DVD<br>
	 * @param n	DVD下标
	 * @param Date	对DVD列表的引用
	 * @return	超出界限or者钱不够or没法借返回false
	 */
	public boolean rentDVD(int n) {
		if (n < dateHandle.size()) {
			// 没有越界
			if (this.money >= dateHandle.get(n).getRentPrice()) {
				// 钱够
				if (dateHandle.get(n).rentOne()) {
					// 能借
					this.addRentDate(dateHandle.get(n).getTitle(), n);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 还DVD
	 * @param name DVD名
	 * @return	并没有借这个&没有这个 返回false
	 */
	public boolean reDVD(String name) {
		int i = 0;
		for (; i < this.userDVDArrayList.size(); i++) {
			if (this.userDVDArrayList.get(i).getName().equals(name)) {	// 找到
				{	// 判断开始
					if (this.dateHandle.size() > this.userDVDArrayList.get(i).getIndex()) {
						// 没有越界
						if ( this.dateHandle.get(this.userDVDArrayList.get(i).getIndex()).getTitle().equals(name) ) {
							// 名字一样
							if ( this.userDVDArrayList.get(i).rentAmount > 0 ) {
								// 确实有租
								if ( this.dateHandle.get(this.userDVDArrayList.get(i).getIndex()).surrenderOne() ) {
									// 确实能退
									--this.userDVDArrayList.get(i).rentAmount;	// 终于退了 TAT
									return true;
								}
							}
						}
					}
				}	// 判断结束
				break;
			}
		}
		return false;
	}
	
	/**
	 * 买一个DVD<br>
	 * @param n	DVD下标
	 * @param Date	对DVD列表的引用
	 * @return	超出界限or钱不够or没法借返回false
	 */
	public boolean buyDVD(int n) {
		if (n < dateHandle.size()) {
			// 未越界
			if (this.money >= dateHandle.get(n).getBuyPrice()) {
				// 钱够
				if (dateHandle.get(n).sellOne()) {
					// 能买
					this.addBuyDate(dateHandle.get(n).getTitle(), n);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 增加借记录
	 * @return	新增的返回true 已经有的返回false
	 */
	private boolean addRentDate(String name,int index) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// 找到
				++a.rentAmount;
				return false;
			}
		}
		// 未找到
		this.userDVDArrayList.add(new DVDUser(name,index,1,0));
		return true;
	}
	
	 //TODO 减少借记录（还记录）
	
	/**
	 * 增加买记录
	 * @return	新增的返回true 已经有的返回false
	 */
	private boolean addBuyDate(String name, int index) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// 找到
				++a.buyAmount;
				return false;
			}
		}
		// 未找到
		this.userDVDArrayList.add(new DVDUser(name,index,0,1));
		return true;
	}
	
}














/**
 * User记录用DVD类<br>
 * 传送记录用<br>
 * @author Jeremie
 *
 */
class DVDUser {
	/**
	 * DVD名<br>
	 * 以名字为鉴别<br>
	 * <br>
	 * <br>
	 * TO DO：<br>
	 * 以DVD的hash为鉴别<br>
	 * 以DVD对象为鉴别<br>
	 * 以DVD编号为鉴别<br>
	 * 
	 */
	private String name;
	/**
	 * 下标
	 */
	private int index;
	/**
	 * 已经借的数量
	 */
	public int rentAmount = 0;
	/**
	 * 已经买的数量
	 */
	public int buyAmount = 0;
	
	/**
	 * 构造函数
	 * @param name
	 * @param index
	 * @param rentAmount
	 * @param buyAmount
	 */
	public DVDUser(String name, int index, int rentAmount, int buyAmount) {
		this.name = name;
		this.rentAmount = rentAmount;
		this.buyAmount = buyAmount;
		this.index = index;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	
}

