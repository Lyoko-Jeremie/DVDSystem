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
	 * 唯一的构造函数<br>
	 * @param money	初始金额
	 */
	public User(double money) {
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
	}
	
	/**
	 * 增加现金数量
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
	public boolean rentDVD(int n, ArrayList<DVD> Date) {
		if (n < Date.size()) {
			if (this.money >= Date.get(n).getRentPrice()) {
				if (Date.get(n).rentOne()) {
					this.addRentDate(Date.get(n).getTitle());
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 买一个DVD<br>
	 * @param n	DVD下标
	 * @param Date	对DVD列表的引用
	 * @return	超出界限or者钱不够or没法借返回false
	 */
	public boolean buyDVD(int n, ArrayList<DVD> Date) {
		if (n < Date.size()) {
			if (this.money >= Date.get(n).getBuyPrice()) {
				if (Date.get(n).sellOne()) {
					this.addBuyDate(Date.get(n).getTitle());
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
	private boolean addRentDate(String name) {
		DVDUser pDvdUser = null;
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.name)) {
				pDvdUser = a;
				break;
			}
		}
		if (pDvdUser == null) {
			this.userDVDArrayList.add(new DVDUser(name,1,0));
			return true;
		} else {
			++pDvdUser.rentAmount;
			return false;
		}
	}
	
	//TODO 还DVD
	 //TODO 减少借记录（还记录）
	
	/**
	 * 增加买记录
	 * @return	新增的返回true 已经有的返回false
	 */
	private boolean addBuyDate(String name) {
		DVDUser pDvdUser = null;
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.name)) {
				pDvdUser = a;
				break;
			}
		}
		if (pDvdUser == null) {
			this.userDVDArrayList.add(new DVDUser(name,0,1));
			return true;
		} else {
			++pDvdUser.buyAmount;
			return false;
		}
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
	public String name;
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
	 * @param rentAmount
	 * @param buyAmount
	 */
	public DVDUser(String name, int rentAmount, int buyAmount) {
		this.name = name;
		this.rentAmount = rentAmount;
		this.buyAmount = buyAmount;
	}
}

