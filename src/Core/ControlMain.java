package Core;
import java.util.ArrayList;

/**
 * 整个系统核心控制结构<br>
 * @author Jeremie
 */

/**
 * 主系统主要结构<br>
 * 同时只能使用一个<br>
 * @author Jeremie
 */
public class ControlMain {
	
	/**
	 * DVD主数组结构<br>
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
	 * 文件操作类
	 */
	private ControlFile mainFile;
	
	/**
	 * 反多对象保护
	 */
	private static int PRO = 0;
	
	
	/**
	 * 唯一的构造方法<br>
	 * 做反多对象保护操作<br>
	 * 初始化所有主数组结构<br>
	 * 并设置数据库文件<br>
	 */
	public ControlMain() {
		if ( ControlMain.PRO>0) {
			// 反多对象保护
			throw new ExceptionInInitializerError("\n\tOnly Can Create One ControlMain Object!!!");
		}
		++ControlMain.PRO;
		this.dVDMainDateArrayList = new ArrayList<DVD>();
		this.dVDStyleArrayList = new ArrayList<Style>();
		this.usersMainDateArrayList = new ArrayList<User>();
		this.mainFile = new ControlFile("DVDSystemDate.DVDSystemDAteBaseFile", this);
//		this.mainFile = new ControlFile("C:\\", this);
	}
	
	/**
	 * 析构<br>
	 * 减少计数
	 */
	@Override
	public void finalize() {
		--ControlMain.PRO;
	}
	
	// TO DO 在DVD类使用设置租买限制时，要添加一个可设置限制的DVDadd
	
	/**
	 * 添加一个DVD，附带完整DVD参数<br>
	 * 根据title和year判断重复<br>
	 * @param title
	 * @param year
	 * @param style	
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyPrice
	 * @param rentPrice
	 * @return 没有查到重复既添加成功返回true
	 */
	public boolean addDVD(String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyPrice, double rentPrice) {
		// 查重
		for (DVD a : this.dVDMainDateArrayList) {
			if ( a.getTitle().equals(title) && a.getYear() == year ) {
				return false;
			}
		}
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
		return true;
	}
	
	/**
	 * 添加一个DVD，自动计算是否可租可卖，自动计算风格<br>
	 * 根据title和year判断重复<br>
	 * @param title
	 * @param year
	 * @param style	以空格分离的风格字串 如为空字串或为null则自动为空
	 * @param amount
	 * @param buyPrice
	 * @param rentPrice
	 * @return 没有查到重复既添加成功返回true
	 */
	public Boolean addDVD(String title, int year, String style, int amount, double buyPrice, double rentPrice) {
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
		ArrayList<Long> tAL = new ArrayList<Long>();
		if (style != null) {
			String[] tString = style.split(" ");
			for (String a : tString) {
				if (!a.equals("")) {
					tAL.add( this.addStyleRID(a) );
				}
			}
		}
		// 查重
		for (DVD a : this.dVDMainDateArrayList) {
			if ( a.getTitle().equals(title) && a.getYear() == year ) {
				return false;
			}
		}
		dVDMainDateArrayList.add( new DVD(title, year, tAL, amount, sell, rent, buyPrice, rentPrice));
		return true;
	}

	/**
	 * 添加一个DVD，自动计算是否可租可卖<br>
	 * 根据title和year判断重复<br>
	 * @param title
	 * @param year
	 * @param style	
	 * @param amount
	 * @param buyPrice
	 * @param rentPrice
	 * @return 没有查到重复既添加成功返回true
	 */
	public boolean addDVD(String title, int year, ArrayList<Long> style, int amount, double buyPrice, double rentPrice) {
		// 查重
		for (DVD a : this.dVDMainDateArrayList) {
			if ( a.getTitle().equals(title) && a.getYear() == year ) {
				return false;
			}
		}
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
		return false;
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
	 * 添加一个Style
	 * @param name
	 * @return 返回ID 重名则返回已有对象ID
	 */
	public long addStyleRID(String name){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getName().equals(name)) {
				return a.getID();
			}
		}
		this.dVDStyleArrayList.add( new Style(name) );
		return this.getStyleID(name);
	}

	/**
	 * 从Index获取Style名<br>
	 * 遍历用【Only】<br>
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
	 * 从Style名获取ID<br>
	 * <br>
	 * @param style
	 * @return	找不到，返回0
	 */
	public long getStyleID(String style){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getName().equals(style)) {
				return a.getID();
			}
		}
		return 0;
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
	 * 获取Style总数量
	 * @return int  Size
	 */
	public int getStyleSize() {
		return this.dVDStyleArrayList.size();
	}
	
	/**
	 * 添加一个用户<br>
	 * 并初始化现金额度<br>
	 * 以name判断重复<br>
	 * @param money
	 * @param name
	 * @return dVDMainDateArrayList句柄为null 或 重复 返回false
	 */
	public boolean addOneUser(String name, String password, double money) {
		if (this.dVDMainDateArrayList != null) {
			// 查重
			for (User a : this.usersMainDateArrayList) {
				if (a.getName().equals(name)) {
					return false;
				}
			}
			usersMainDateArrayList.add(new User(name, password, money, this.dVDMainDateArrayList));
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
	protected User getUser(int Index) {
		try {
			return this.usersMainDateArrayList.get(Index);
		} catch (Exception e) {
			return null;
		}
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
		try {
			return this.dVDMainDateArrayList.get(Index);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取DVD总数量
	 * @return	int
	 */
	public int getDVDSize() {
		return this.dVDMainDateArrayList.size();
	}
	
	/**
	 * 获取指定DVD对象<br>
	 * 查找用<br>
	 * @param Title		名字
	 * @return		找不到返回null
	 */
	public DVD getDVD(String Title) {
		for (DVD a : this.dVDMainDateArrayList) {
			if (a.getTitle().equals(Title)) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * 获取指定DVD对象<br>
	 * 查找用<br>
	 * @param iD		名字
	 * @return		找不到返回null
	 */
	public DVD getDVD(Long iD) {
		for (DVD a : this.dVDMainDateArrayList) {
			if (a.getID() == iD) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * 获取指定DVD对象的指定风格
	 * @param A	指定的DVD对象
	 * @param index	列下标
	 * @return String	Style字串，没有找到or超范围返回空字串
	 */
	public String getDVDStyle( DVD A, int index) {
		if (index >= 0 && index < A.styleGetSize()) {
			String t = this.getStyle(A.styleGet(index));
			return ( ( t != null )? t : "" );
		}
		return "";
	}

	/**
	 * @return dVDMainDateArrayList
	 * Waring:低效
	 */
	public ArrayList<DVD> getDVDMainDateArrayList() {
		return new  ArrayList<DVD>(dVDMainDateArrayList);
	}

	/**
	 * @return dVDStyleArrayList
	 * Waring:低效
	 */
	public ArrayList<Style> getDVDStyleArrayList() {
		return new ArrayList<Style>(dVDStyleArrayList);
	}

	/**
	 * @return usersMainDateArrayList
	 * Waring:低效
	 */
	public ArrayList<User> getUsersMainDateArrayList() {
		return new ArrayList<User>(usersMainDateArrayList);
	}
	
	/**
	 * 添加DVD对象到主数据链<br>
	 * 以title和year判断相同<br>
	 * @param dbject
	 * @return	 没有重复则添加成功返回true
	 */
	protected boolean addDVD(DVD dbject) {
		for (DVD a : dVDMainDateArrayList) {
			if (a.getTitle().equals(dbject.getTitle()) && a.getYear() == dbject.getYear() ) {
				return false;
			}
		}
		dVDMainDateArrayList.add(dbject);
		return true;
	}
	
	/**
	 * 添加User对象到主数据链<br>
	 * 以name判断重复<br>
	 * @param ubject
	 * @return	 没有重复则添加成功返回true
	 */
	protected boolean addUser(User ubject) {
		for (User a : usersMainDateArrayList) {
			if (a.getName().equals(ubject.getName()) ) {
				return false;
			}
		}
		usersMainDateArrayList.add(ubject);
		return true;
	}
	
	/**
	 * 添加Style对象到主数据链<br>
	 * 以name判断重复<br>
	 * @param sbject
	 * @return 没有重复则添加成功返回true
	 */
	protected boolean addStyle(Style sbject) {
		for (Style a : dVDStyleArrayList) {
			if ( a.getName().equals(sbject.getName()) ) {
				return false;
			}
		}
		dVDStyleArrayList.add(sbject);
		return true;
	}
	
	/**
	 * 保存数据
	 * @return 成功返回true
	 * @throws Exception 失败抛出异常 异常的string包含了出现异常的位置信息
	 */
	public boolean saveDate() throws Exception {
		if (!mainFile.createNewFile()) {
			throw new Exception("Cant Create File.");
		}
		if (!mainFile.openWriteHandle()) {
			throw new Exception("Cant Open File.");
		}
		if (!mainFile.writeMainDate()) {
			throw new Exception("Save is Fail.");
		}
		mainFile.closeWriteHandle();
		return true;
	}
	
	/**
	 * 读取数据
	 * @return 成功返回true
	 * @throws Exception 失败抛出异常 异常的string包含了出现异常的位置信息
	 */
	public boolean LoadDate() throws Exception {
		if (!mainFile.openReadHandle()) {
			throw new Exception("Cant Open File.");
		}
		if (!mainFile.readMainDate()) {
			throw new Exception("Load is Fail.");
		}
		mainFile.closeReadHandle();
		return true;
	}

}
