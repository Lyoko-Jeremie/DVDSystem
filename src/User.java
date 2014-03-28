import java.util.ArrayList;

/**
 * 用户类
 */

/**
 * 用户类<br>
 * 注意：名字与密码有时为null<br>
 * @author Jeremie
 *
 */
public class User {
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 现金
	 */
	private double money;
	
	/**
	 * 已经买到的和已经借到的DVD列
	 */
	private ArrayList<DVDUser> userDVDArrayList;
	
	/**
	 * 指向主数据链的句柄
	 */
	private ArrayList<DVD> dateHandle;
	
	/**
	 * 构造函数<br>
	 * <br>
	 * <br>
	 * 自动将名字密码置null<br>
	 * @param money	初始金额
	 * @param handle	指向主数据链的句柄
	 */
	public User(double money, ArrayList<DVD> handle) {
		this.name = null;
		this.password = null;
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
		this.dateHandle = handle;
		if (handle==null) {
			throw new ExceptionInInitializerError("\n\tHandle Cant are null !!");
		}
	}
	
	/**
	 * 带名字与密码的构造函数<br>
	 * @param name
	 * @param password
	 * @param money
	 * @param DVDhandle
	 */
	public User(String name, String password, double money, 	ArrayList<DVD> DVDhandle) {
		this.name = name;
		this.password = password;
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
		this.dateHandle = DVDhandle;
		if ( DVDhandle == null) {
			throw new ExceptionInInitializerError("\n\tHandle Cant are null !!");
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
	 * @return	 超出界限or钱不够or没法借返回false
	 */
	public boolean rentDVD(int n) {
		try {
			if (this.money >= dateHandle.get(n).getRentPrice()) {
				// 钱够
				if (dateHandle.get(n).rentOne()) {
					// 能借
					this.addRentDate(dateHandle.get(n).getTitle(), dateHandle.get(n).getID());
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * 借一个DVD<br>
	 * @param DVD
	 * @return	 钱不够or没法借返回false
	 */
	public boolean rentDVD(DVD temp) {
		if (this.money >= temp.getRentPrice()) {
			// 钱够
			if ( temp.rentOne()) {
				// 能借
				this.addRentDate( temp.getTitle(), temp.getID());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 还DVD<br>
	 * 会对DVD名和ID进行校验<br>
	 * @param name DVD名
	 * @return	并没有借这个or没有这个DVD 返回false
	 */
	public boolean reDVD(String name) {
		for (int i = 0; i < this.userDVDArrayList.size(); i++) {
			if (this.userDVDArrayList.get(i).getName().equals(name)) {
				// 搜索记录
				for (DVD a : this.dateHandle) {
					// 搜索DVD
					if ( a.getTitle().equals(name) ) {
						// 名字一样
						if (a.getID() == this.userDVDArrayList.get(i).getID()) {
							// ID一样
							if ( this.userDVDArrayList.get(i).rentAmount > 0 ) {
								// 确实有租
								if ( a.surrenderOne() ) {
									// 确实能退
									--this.userDVDArrayList.get(i).rentAmount;	// 终于退了 TAT
									// 都为0要删除记录
									if (this.userDVDArrayList.get(i).rentAmount == 0 && this.userDVDArrayList.get(i).buyAmount == 0) {
										this.userDVDArrayList.remove(i);
									}
									return true;
								}
							}
						}
					}
				}
				break;		// 有记录但是没有对应DVD
			}
		}
		return false;
	}
	
	/**
	 * 还DVD<br>
	 * 会对DVD名和ID进行校验<br>
	 * @param index DVD下标
	 * @return	下标越界or两数据表数据不一致 返回false
	 */
	public boolean reDVD(int index) {
		DVDUser b;
		try {
			b = this.userDVDArrayList.get(index);
		} catch (Exception e) {
			return false;
		}
		for (DVD a : this.dateHandle) {
			// 搜索DVD
			if ( a.getTitle().equals(b.getName()) ) {
				// 名字一样
				if (a.getID() == b.getID()) {
					// ID一样
					if ( b.rentAmount > 0 ) {
						// 确实有租
						if ( a.surrenderOne() ) {
							// 确实能退
							--b.rentAmount;	// 终于退了 TAT
							// 都为0要删除记录
							if (b.rentAmount == 0 && b.buyAmount == 0) {
								this.userDVDArrayList.remove(index);
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 买一个DVD<br>
	 * @param n	DVD下标
	 * @return	超出界限or钱不够or没法借返回false
	 */
	public boolean buyDVD(int n) {
		try {
			if (this.money >= dateHandle.get(n).getBuyPrice()) {
				// 钱够
				if (dateHandle.get(n).sellOne()) {
					// 能买
					this.addBuyDate(dateHandle.get(n).getTitle(), dateHandle.get(n).getID());
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * 买一个DVD<br>
	 * @param DVD
	 * @return		钱不够or没法借返回false
	 */
	public boolean buyDVD(DVD temp) {
		if (this.money >= temp.getBuyPrice()) {
			// 钱够
			if (temp.sellOne()) {
				// 能买
				this.addBuyDate(temp.getTitle(), temp.getID());
				return true;
			}
		}
		return false;
	}

	/**
	 * 增加借记录
	 * @return	新增的返回true 已经有的返回false
	 */
	private boolean addRentDate(String name,long ID) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// 找到
				++a.rentAmount;
				return false;
			}
		}
		// 未找到
		this.userDVDArrayList.add(new DVDUser(name,ID,1,0));
		return true;
	}
	
	
	/**
	 * 增加买记录
	 * @return	新增的返回true 已经有的返回false
	 */
	private boolean addBuyDate(String name, long ID) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// 找到
				++a.buyAmount;
				return false;
			}
		}
		// 未找到
		this.userDVDArrayList.add(new DVDUser(name,ID,0,1));
		return true;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money 要设置的 money
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * 获取拥有DVD列表总数
	 * @return int
	 */
	public int getDVDListSize() {
		return this.userDVDArrayList.size();
	}

	/**
	 * @param index	
	 * @return	Name
	 */
	public String getDVDListIndexName(int index) {
		return this.userDVDArrayList.get(index).getName();
	}
	
	/**
	 * @param index
	 * @return	ID
	 */
	public long getDVDListIndexID(int index) {
		return this.userDVDArrayList.get(index).getID();
	}
	
	/**
	 * @param index
	 * @return	RentAmount
	 */
	public int getDVDListIndexRentAmount(int index) {
		return this.userDVDArrayList.get(index).rentAmount;
	}
	
	/**
	 * @param index
	 * @return	BuyAmount
	 */
	public int getDVDListIndexBuyAmount(int index) {
		return this.userDVDArrayList.get(index).buyAmount;
	}
	
	/**
	 * 强制添加一个已拥有的DVD记录<br>
	 * 这个函数为文件读取而设计<br>
	 * @param name
	 * @param ID
	 * @param rentAmount
	 * @param buyAmount
	 * @return
	 */
	public boolean addSelfsDVDDate(String name, long ID, int rentAmount, int buyAmount) {
		for (DVDUser a : this.userDVDArrayList) {	// 数据有效性互斥约束
			if (a.getName().equals(name)) {
				return false;
			}
			if (a.getID() == ID) {
				return false;
			}
		}
		this.userDVDArrayList.add( new DVDUser(name, ID, rentAmount, buyAmount) );
		return true;
	}
	
}














/**
 * User记录用DVD类<br>
 * @author Jeremie
 *
 */
class DVDUser {
	/**
	 * DVD名<br>
	 * 以名字为鉴别<br>
	 * <br>
	 * <br>
	 * 以DVD的ID&name为鉴别<br>
	 * 
	 */
	private String name;
	/**
	 * DVD的ID
	 */
	private long ID;
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
	 * @param ID	对应DVD的ID
	 * @param rentAmount
	 * @param buyAmount
	 */
	public DVDUser(String name, long ID, int rentAmount, int buyAmount) {
		this.name = name;
		this.rentAmount = rentAmount;
		this.buyAmount = buyAmount;
		this.ID = ID;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return iD
	 */
	public long getID() {
		return ID;
	}
	
	
}

