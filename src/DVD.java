import java.util.ArrayList;
import java.util.Random;

/**
 * DVD对象的类<br>
 * @author Jeremie
 */

/**
 * DVD对象类<br>
 * 包含DVD的属性<br>
 * @author Jeremie
 *
 */
public class DVD {
	private String title;
	private int year;
	
	/**
	 * 电影类型&风格<br>
	 * 另使用关键字列表查询所对应信息<br>
	 */
	private ArrayList<Long> style;
	
	/**
	 * 总计余量
	 */
	private int amount;
	/**
	 * 已经借出的数量<br>
	 * 至于借给谁了，由用户对象各自记录已经借的比较便于管理
	 */
	private int rentAmount;
	/**
	 * 可卖
	 */
	private boolean sell;
	/**
	 * 可借
	 */
	private boolean rent;
	/**
	 * 价格
	 */
	private double buyPrice;
	private double rentPrice;
	
	// 重构时添加修改途径即可实现管理员设置
	/**
	 * 卖出限制
	 */
	private static final int SELL_LIMIT = 3;
	private  int sellLimit;
	/**
	 * 借出限制
	 */
	private static final int RENT_LIMIT = 0;
	private  int rentLimit;
	
	/**
	 * 随机数生成的ID<br>
	 * 由title和ID共同辨别DVD<br>
	 */
	private long ID;
	
	/**
	 * 为数组而设置的默认初始化函数<br>
	 * <br>
	 * 初始化内容：<br>
	 * title = ""<br>
	 * year = 0<br>
	 * style = new ArrayList< Long >()<br>
	 * amount = 0<br>
	 * sell = false<br>
	 * rent =  false<br>
	 * rentAmount = 0<br>
	 * buyPrice = 0<br>
	 * rentPrice = 0<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 */
	public DVD() {
		this.title = "";
		this.year = 0;
		this.style = new ArrayList<Long>();
		this.amount = 0;
		this.sell = false;
		this.rent =  false;
		this.rentAmount = 0;
		this.buyPrice = 0;
		this.rentPrice = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
		Random r = new Random();
		this.ID = r.nextLong();
	}
	/**
	 * 构造方法<br>
	 * style <> null<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 */
	public DVD( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyprice, double rentPrice) {
		this.title = title;
		this.year = year;
		if (style != null) {
			this.style = style;
		} else {
			throw new ExceptionInInitializerError("style cant are null");
		}
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.buyPrice = buyprice;
		this.rentPrice = rentPrice;
		this.rentAmount = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
		Random r = new Random();
		this.ID = r.nextLong();
	}
	/**
	 * 设置所有数据，这个方法为数组的数据延迟设置而设计<br>
	 * style <> null<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 * @param rentAmount
	 */
	public void setAllDate( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyprice, double rentPrice, int rentAmount) {
		this.title = title;
		this.year = year;
		if (style != null) {
			this.style = style;
		} else {
			throw new ExceptionInInitializerError("style cant are null");
		}
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.buyPrice = buyprice;
		this.rentPrice = rentPrice;
		this.rentAmount = rentAmount;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * 构造所有数据，这个方法为文件读取而设计<br>
	 * style <> null<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param iD
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 * @param rentAmount
	 */
	public DVD( String title, long iD, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyprice, double rentPrice, int rentAmount) {
		this.title = title;
		this.ID = iD;
		this.year = year;
		if (style != null) {
			this.style = style;
		} else {
			throw new ExceptionInInitializerError("style cant are null");
		}
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.buyPrice = buyprice;
		this.rentPrice = rentPrice;
		this.rentAmount = rentAmount;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * 设置所有数据，这个方法为数组的数据延迟设置而设计<br>
	 * 无需设置rentAmount<br>
	 * style <> null<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 */
	public void setAllDate( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyprice, double rentPrice) {
		this.title = title;
		this.year = year;
		if (style != null) {
			this.style = style;
		} else {
			throw new ExceptionInInitializerError("style cant are null");
		}
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.buyPrice = buyprice;
		this.rentPrice = rentPrice;
		this.rentAmount = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * @return buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}
	/**
	 * @param buyPrice 要设置的 buyPrice
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * @return rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}
	/**
	 * @param rentPrice 要设置的 rentPrice
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	/**
	 * @return sELL_LIMIT
	 */
	public static int getSELL_LIMIT() {
		return SELL_LIMIT;
	}
	/**
	 * @return rENT_LIMIT
	 */
	public static int getRENT_LIMIT() {
		return RENT_LIMIT;
	}

// 留给未来扩展用
//	/**
//	 * @return sellLimit
//	 */
//	public int getSellLimit() {
//		return sellLimit;
//	}
//	/**
//	 * @param sellLimit 要设置的 sellLimit
//	 */
//	public void setSellLimit(int sellLimit) {
//		this.sellLimit = sellLimit;
//	}
//	/**
//	 * @return rentLimit
//	 */
//	public int getRentLimit() {
//		return rentLimit;
//	}
//	/**
//	 * @param rentLimit 要设置的 rentLimit
//	 */
//	public void setRentLimit(int rentLimit) {
//		this.rentLimit = rentLimit;
//	}
	
	
	/**
	 * @return rentAmount
	 */
	public int getRentAmount() {
		return rentAmount;
	}
	/**
	 * @return iD
	 */
	public long getID() {
		return ID;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title 要设置的 title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year 要设置的 year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return style	因为需要保护内部对象 返回的是临时对象 TMDjava虚拟机造成的内存泄漏和资源占用我就不管了
	 */
	public ArrayList<Long> styleGetAll() {
		return new ArrayList<Long>(style);
	}
	/**
	 * @return int
	 */
	public int styleGetSize() {
		return style.size();
	}
	/**
	 * @return long		不检查越界
	 */
	public long styleGet(int index) {
		return style.get(index);
	}
	/**
	 * 重设整个的 style
	 * @param style	不能为null
	 * @throws Exception 
	 */
	public void styleSetALL(ArrayList<Long> style) throws Exception {
		if (style == null) {
			throw new Exception("Cant Are null.");
		}
		this.style = style;
	}
	/**
	 * @param style 要增加的 style
	 * @return 已经有了false
	 */
	public boolean styleAdd(long style) {
		for (Long a : this.style) {
			if (a.equals(style)) {
				return false;
			}
		}
		this.style.add(style);
		return true;
	}
	/**
	 * @param style 要查找的 style
	 * @return 找到true
	 */
	public boolean styleTest(long style) {
		for (Long a : this.style) {
			if (a.equals(style)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @param style 要删除的 style
	 * @return 找到true
	 */
	public boolean styleDelete(long style) {
		for (int i = 0; i != this.style.size(); ++i) {
			if (this.style.get(i).equals(style)) {
				this.style.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @return sell
	 * 可卖时余量大于sellLimit
	 */
	public boolean canSell() {
		if (this.amount > sellLimit) {
			this.sell = true;
		} else {
			this.sell = false;
		}
		return sell;
	}
	/**
	 * @return rent
	 * 可借时余量大于rentLimit
	 */
	public boolean canRent() {
		// 顺便刷新
		if (this.amount > rentLimit) {
			this.rent = true;
		}else {
			this.rent = false;
		}
		return rent;
	}
	/**
	 * 借一个
	 * 借到rentLimit就不能借了
	 * @return boolean 借成功返回true 失败返回false
	 */
	public boolean rentOne() {
		if (this.amount > this.rentLimit) {
			--this.amount;
			if (this.amount <= this.rentLimit) {
				this.rent = false;
				this.sell = false;
			}
			++this.rentAmount;
			return true;
		}
		return false;
	}
	/**
	 * 卖一个<br>
	 * 卖到sellLimit个就不能再卖了，只能借
	 * @return boolean 卖成功返回true 失败返回false
	 */
	public boolean sellOne() {
		if (this.amount > sellLimit) {
			--this.amount;
			// 卖到SELL_LIMIT个就不能卖了
			if (this.amount <= sellLimit) {
				this.sell = false;
			}
			return true;
		}
		return false;
	}
	/**
	 * 还一个
	 * @return 退租成功返回true，失败（并没有借出这么多）返回false
	 */
	public boolean surrenderOne() {
		if (this.rentAmount > rentLimit ) {
			--this.rentAmount;
			++this.amount;
			// 恢复可卖状态
			if (this.amount > sellLimit) {
				this.sell = true;
			}
			// 肯定可以再租
			this.rent = true;
			return true;
		} else {
			return false;
		}
	}

}
