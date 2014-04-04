package Core;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 文件操作类
 */

/**
 * 文件操作类
 * @author Jeremie
 *
 */
public class ControlFile {
	
	private File mainFile;
	
	private Read mainReadHandle;
	
	private PrintWriter mainWriteHandle;
	
	private ControlMain mainDate;
	
	public static final String[] FILE_VERSION_STRINGS = { "DVDSystemFileDateBase" , "DateBaseVersion:v1.0" };
	
	

	/**
	 * 专为连续的文件读取而包装的类<br>
	 * 内部类，无需且禁止外部使用<br>
	 * 包装解决next对象后不换行的问题<br>
	 * @author Jeremie
	 *
	 */
	private class Read{
		private Boolean lastIsLine;
		private Scanner inHandle;
		/**
		 * 初始化构造
		 * @param in 要包装的Scanner对象
		 */
		protected Read( Scanner in ) {
			// 初始化为true避免第一次读取既排空回车
			lastIsLine = true;
			inHandle = in;
		}
		/**
		 * 初始化构造
		 * @param inFile File对象
		 * @throws FileNotFoundException
		 */
		protected Read(File inFile) throws FileNotFoundException {
			this(new Scanner(inFile));
		}
		/**
		 * 获取下一个Line
		 * @return 正确完成返回下一个Line
		 * @throws Exception 如果 无法读取 或 排空回车时出现异常 或 已经关闭，抛出异常<br>
		 * 【排空回车时出现异常则说明有外部修改或内部错误】<br>
		 */
		protected String nextLine() throws Exception {
			if (inHandle==null) {
				throw new Exception("Read Object Be Closed.");
			}
			if (!lastIsLine) {
				if (!inHandle.hasNextLine()) {
					throw new Exception("Read Error.");
				}
				if (!inHandle.nextLine().isEmpty()) {
					throw new Exception("This mast be empty.");
				}
				lastIsLine = true;
			}
			if (!inHandle.hasNextLine()) {
				throw new Exception("Read Error.");
			}
			return inHandle.nextLine();
		}
		/**
		 * 读取下一个int
		 * @return 成功则返回
		 * @throws Exception 无法读取 或 已经关闭 抛异常
		 */
		protected int nextInt() throws Exception {
			if (inHandle==null) {
				throw new Exception("Read Object Be Closed.");
			}
			lastIsLine = false;
			if (!inHandle.hasNextInt()) {
				throw new Exception("Read Error.");
			}
			return inHandle.nextInt();
		}
		/**
		 * 读取下一个Long
		 * @return 成功则返回
		 * @throws Exception 无法读取 或 已经关闭 抛异常
		 */
		protected Long nextLong() throws Exception {
			if (inHandle==null) {
				throw new Exception("Read Object Be Closed.");
			}
			lastIsLine = false;
			if (!inHandle.hasNextLong()) {
				throw new Exception("Read Error.");
			}
			return inHandle.nextLong();
		}
		/**
		 * 读取下一个Double
		 * @return 成功则返回
		 * @throws Exception 无法读取 或 已经关闭 抛异常
		 */
		protected Double nextDouble() throws Exception {
			if (inHandle==null) {
				throw new Exception("Read Object Be Closed.");
			}
			lastIsLine = false;
			if (!inHandle.hasNextDouble()) {
				throw new Exception("Read Error.");
			}
			return inHandle.nextDouble();
		}
		/**
		 * 读取下一个Boolean
		 * @return 成功则返回
		 * @throws Exception 无法读取 或 已经关闭 抛异常
		 */
		protected Boolean nextBoolean() throws Exception {
			if (inHandle==null) {
				throw new Exception("Read Object Be Closed.");
			}
			lastIsLine = false;
			if (!inHandle.hasNextBoolean()) {
				throw new Exception("Read Error.");
			}
			return inHandle.nextBoolean();
		}
		/**
		 * 安全关闭并析构对象<br>
		 * 在使用该方法后请停止使用该对象并设置到此对象的引用为null<br>
		 * @throws Throwable
		 */
		protected void close() {
			this.inHandle.close();
			inHandle = null;
		}
		/**
		 * 重载析构函数
		 */
		@Override
		protected void finalize() throws Throwable {
			this.inHandle.close();
			inHandle = null;
			super.finalize();
		}
	}


	
	
	
	
	
	/**
	 * 构造函数
	 * @param filePathName
	 * @param mainDate
	 */
	protected ControlFile( String filePathName, ControlMain mainDate) throws ExceptionInInitializerError {
		this.mainDate = mainDate;
		if (  this.mainDate == null) {
			throw new ExceptionInInitializerError("ControlMain Handle Cant Are null.");
		}
		this.mainFile = new File(filePathName);
		if ( mainFile.exists() && !( mainFile.canRead() && mainFile.canWrite() ) ) {
			throw new ExceptionInInitializerError("File Cant Read or Write.");
		}
		if ( mainFile.exists() && !mainFile.isFile() ) {
			throw new ExceptionInInitializerError("Not a file");
		}
		mainReadHandle = null;
		mainWriteHandle = null;
	}
	
	/**
	 * 文件是否存在
	 * @return bool
	 */
	protected boolean isFileExists() {
		return mainFile.exists();
	}
	
	/**
	 * 创建新文件
	 * @return 异常返回false 成功返回true
	 */
	protected boolean createNewFile() {
		try {
			mainFile.createNewFile();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 析构函数<br>
	 * 关闭句柄<br>
	 */
	@Override
	protected void finalize() throws Throwable {
		if ( mainReadHandle != null ) {
			mainReadHandle.close();
			mainReadHandle = null;
		}
		if ( mainWriteHandle != null ) {
			mainWriteHandle.close();
			mainWriteHandle = null;
		}
		super.finalize();
	}
	
	/**
	 * 关闭读文件句柄
	 */
	protected void closeReadHandle() {
		if ( mainReadHandle != null ) {
			mainReadHandle.close();
			mainReadHandle = null;
		}
	}
	
	/**
	 * 关闭写文件句柄
	 */
	protected void closeWriteHandle() {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.close();
			mainWriteHandle = null;
		}
	}
	
	/**
	 * 打开读取用文件句柄
	 * @return bool
	 */
	protected boolean openReadHandle() {
		if (mainReadHandle == null) {
			try {
				mainReadHandle = new Read(mainFile);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 读取用文件句柄是否打开
	 * @return bool
	 */
	protected boolean isOpenReadHandle() {
		if ( mainReadHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * 读取下一行
	 * @return	句柄为null or 没有下一行 则返回 null
	 */
	protected String readNextLN() {
		if ( mainReadHandle != null) {
			try {
				return mainReadHandle.nextLine();
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 读取下一个int
	 * @return	句柄为null or 没有下一个int 则返回 null
	 */
	protected Integer readNextInt() {
		if ( mainReadHandle != null ) {
			try {
				return mainReadHandle.nextInt();
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 打开写入用文件句柄
	 * @return bool
	 */
	protected boolean openWriteHandle() {
		if (mainWriteHandle == null) {
			try {
				mainWriteHandle = new PrintWriter(mainFile);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 写入用文件句柄是否打开
	 * @return bool
	 */
	protected boolean isOpenWriteHandle() {
		if ( mainWriteHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * 写入一行<br>
	 * 重载<br>
	 * @param line	
	 * @return 句柄为空返回null
	 */
	protected boolean writeNextLN( String line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	protected boolean writeNextLN( int line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	protected boolean writeNextLN() {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println();
			return true;
		}
		return false;
	}
	
	/**
	 * 写入一个DVD对象<br>
	 * @param dbject
	 * @return 句柄为null返回null
	 */
	protected boolean writeDVD(DVD dbject) {
		if ( mainWriteHandle == null ) {
			return false;
		}
		if (dbject == null) {
			return false;
		}
		mainWriteHandle.println();
		mainWriteHandle.println("DVDObjectB");
		mainWriteHandle.println(dbject.getTitle());	// String
		mainWriteHandle.println(dbject.getID());	// Long
		mainWriteHandle.println(dbject.getYear());	// int
		mainWriteHandle.println(dbject.getAmount());	// int
		mainWriteHandle.println(dbject.getBuyPrice());	// double
		mainWriteHandle.println(dbject.getRentPrice());	// double
		mainWriteHandle.println(dbject.getRentAmount());	// int
		mainWriteHandle.println(dbject.canSell());	// bool
		mainWriteHandle.println(dbject.canRent());	// bool
		// 未来扩展的插入位置
		mainWriteHandle.println("DVDObjectSB");
		mainWriteHandle.println(dbject.styleGetSize());	// int
		for (Long a : dbject.styleGetAll()) {
			mainWriteHandle.println(a);	// Long
		}
		mainWriteHandle.println("DVDObjectSE");
		mainWriteHandle.println("DVDObjectE");
		return true;
	}
	
	/**
	 * 读取一个DVD对象<br>
	 * 包括前导空行<br>
	 * <br>
	 * 成功返回构造好的对象<br>
	 * 失败抛出异常<br>
	 * @return DVD对象
	 * @throws Exception
	 */
	protected DVD readDVD() throws Exception {
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Read in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectB")) {
			throw new Exception("Read Error.");
		}
		// String title, long iD, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice, int rentAmount
		// 为填充构造函数做准备
		String title = in.nextLine();
		long iD = in.nextLong();
		int year = in.nextInt();
		int amount = in.nextInt();
		double buyprice = in.nextDouble();
		double rentPrice = in.nextDouble();
		int rentAmount = in.nextInt();
		boolean sell = in.nextBoolean();
		boolean rent = in.nextBoolean();
		if ( !in.nextLine().equals("DVDObjectSB")) {
			throw new Exception("Read Error.");
		}	// 为类型数组做准备
		ArrayList<Long> style = new ArrayList<Long>();
		int iTemp = in.nextInt();
		for (int i = 0; i < iTemp; i++) {
			style.add(in.nextLong());
		}
		if ( !in.nextLine().equals("DVDObjectSE")) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectE")) {
			throw new Exception("Read Error.");
		}
		return new DVD(title, iD, year, style, amount, sell, rent, buyprice, rentPrice, rentAmount);
	}
	
	/**
	 * 写入一个Style对象
	 * @param sbject
	 * @return	句柄为null返回null
	 */
	protected boolean writeStyle(Style sbject) {
		if ( mainWriteHandle == null ) {
			return false;
		}
		if (sbject == null) {
			return false;
		}
		mainWriteHandle.println();
		mainWriteHandle.println("StyleObjectB");
		mainWriteHandle.println(sbject.getName());
		mainWriteHandle.println(sbject.getID());
		mainWriteHandle.println("StyleObjectE");
		return true;
	}
	
	/**
	 * 读取一个Style对象<br>
	 * 包括前导空行<br>
	 * <br>
	 * 成功返回对象 失败抛出异常<br>
	 * @return Style对象
	 * @throws Exception
	 */
	protected Style readStyle() throws Exception {
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Read in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("StyleObjectB")) {
			throw new Exception("Read Error.");
		}
		// 为填充构造函数做准备
		String name;
		Long iD;
		name = in.nextLine();
		iD = in.nextLong();
		// 注意：在next具体对象之后跟nextline，会读取到一个空字串
		// （在next具体对象之后却没有换行的没有字符）
		// 【实际上这个nextline是取走了具体对象之后的那个换行符】
		// Note：以上问题已经在Read类中以包装形式解决了
		if ( !in.nextLine().equals("StyleObjectE")) {
			throw new Exception("Read Error.");
		}
		return new Style(name, iD);
	}
	
	/**
	 * 写入一个User对象
	 * @param ubject
	 * @return	句柄为null返回null
	 */
	protected boolean writeUser(User ubject) {
		if ( mainWriteHandle == null ) {
			return false;
		}
		if (ubject == null) {
			return false;
		}
		mainWriteHandle.println();
		mainWriteHandle.println("UserObjectB");
		mainWriteHandle.println(ubject.getName());
		mainWriteHandle.println(ubject.getPassword());
		mainWriteHandle.println(ubject.getMoney());
		mainWriteHandle.println("UserObjectDB");
		mainWriteHandle.println(ubject.getDVDListSize());
		for (int i = 0; i < ubject.getDVDListSize(); i++) {
			mainWriteHandle.println("UserObjectDUB");
			mainWriteHandle.println(ubject.getDVDListIndexName(i));
			mainWriteHandle.println(ubject.getDVDListIndexID(i));
			mainWriteHandle.println(ubject.getDVDListIndexBuyAmount(i));
			mainWriteHandle.println(ubject.getDVDListIndexRentAmount(i));
			mainWriteHandle.println("UserObjectDUE");
		}
		mainWriteHandle.println("UserObjectDE");
		mainWriteHandle.println("UserObjectE");
		return true;
	}
	
	/**
	 * 读取一个User对象<br>
	 * 成功返回对象 失败抛出异常<br>
	 * @return	User对象
	 * @throws Exception
	 */
	protected User readUser() throws Exception {
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Read in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("UserObjectB")) {
			throw new Exception("Read Error.");
		}
		// 为填充构造函数做准备
		String name;
		String password;
		double money;
		name = in.nextLine();
		password = in.nextLine();
		money = in.nextDouble();
		User Temp = new User(name,password,money,mainDate.getDVDMainDateArrayList());
		if ( !in.nextLine().equals("UserObjectDB")) {
			throw new Exception("Read Error.");
		}
		int size = in.nextInt();
		for (int i = 0; i < size; i++) {
			if ( !in.nextLine().equals("UserObjectDUB")) {
				throw new Exception("Read Error.");
			}
			String named = in.nextLine();
			long ID = in.nextLong();
			int buyAmount = in.nextInt();
			int rentAmount = in.nextInt();
			Temp.addSelfsDVDDate(named, ID, rentAmount, buyAmount);
			if ( !in.nextLine().equals("UserObjectDUE")) {
				throw new Exception("Read Error.");
			}
		}
		if ( !in.nextLine().equals("UserObjectDE")) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("UserObjectE")) {
			throw new Exception("Read Error.");
		}
		return Temp;
	}
	
	/**
	 * 写入整个ControlMain对象所有数据
	 * @return	只有完全写入完成才返回true
	 */
	protected boolean writeMainDate() {
		if ( mainWriteHandle == null ) {
			return false;
		}
		// 顺序：Style、DVD、User
		// 版本等校验信息
		for (String a : FILE_VERSION_STRINGS) {
			mainWriteHandle.println(a);
		}
		mainWriteHandle.println();
		mainWriteHandle.println("FileB");
		mainWriteHandle.println();
		mainWriteHandle.println("StyleListB");
		{
			ArrayList<Style> TempStyle = mainDate.getDVDStyleArrayList();
			mainWriteHandle.println(TempStyle.size());
			for (Style a : TempStyle) {
				if ( !this.writeStyle(a) ) {
					return false;
				}
			}
		}
		mainWriteHandle.println("StyleListE");
		mainWriteHandle.println();
		mainWriteHandle.println("DVDListB");
		{
			ArrayList<DVD> TempDVD = mainDate.getDVDMainDateArrayList();
			mainWriteHandle.println(TempDVD.size());
			for (DVD a : TempDVD) {
				if ( !this.writeDVD(a) ) {
					return false;
				}
			}
		}
		mainWriteHandle.println("DVDListE");
		mainWriteHandle.println();
		mainWriteHandle.println("UserListB");
		{
			ArrayList<User> TempUser = mainDate.getUsersMainDateArrayList();
			mainWriteHandle.println(TempUser.size());
			for (User a : TempUser) {
				if ( !this.writeUser(a) ) {
					return false;
				}
			}
		}
		mainWriteHandle.println("UserListE");
		mainWriteHandle.println();
		mainWriteHandle.println("FileE");
		return true;
	}
	
	/**
	 * 读取整个文件所有数据并追加到主数据中<br>
	 * @return 正常完成读取返回true 任何的读取失败返回false
	 */
	protected boolean readMainDate() {
		try {
			if ( mainReadHandle == null) {
				return false;
			}
			Read in = mainReadHandle;
			for (String a : FILE_VERSION_STRINGS) {
				if ( !in.nextLine().equals(a)) {
					return false;
				}
			}
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
			if ( !in.nextLine().equals("FileB")) {
				return false;
			}
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
			if ( !in.nextLine().equals("StyleListB")) {
				return false;
			}
			{
				int size = in.nextInt();
				for (int i = 0; i < size; i++) {
					try {
						mainDate.addStyle(this.readStyle());
					} catch (Exception e) {
						return false;
					}
				}
			}
			if ( !in.nextLine().equals("StyleListE")) {
				return false;
			}
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
			if ( !in.nextLine().equals("DVDListB")) {
				return false;
			}
			{
				int size = in.nextInt();
				for (int i = 0; i < size; i++) {
					try {
						mainDate.addDVD(this.readDVD());
					} catch (Exception e) {
						return false;
					}
				}
			}
			if ( !in.nextLine().equals("DVDListE")) {
				return false;
			}
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
			if ( !in.nextLine().equals("UserListB")) {
				return false;
			}
			{
				int size = in.nextInt();
				for (int i = 0; i < size; i++) {
					try {
						mainDate.addUser(this.readUser());
					} catch (Exception e) {
						return false;
					}
				}
			}
			if ( !in.nextLine().equals("UserListE")) {
				return false;
			}
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
			if ( !in.nextLine().equals("FileE")) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}









