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
 * @author Jeremie
 *
 */
public class ControlFile {
	
	private File mainFile;
	
	private Scanner mainReadHandle;
	
	private PrintWriter mainWriteHandle;
	
	private ControlMain mainDate;
	
	public static final String[] FILE_VERSION_STRINGS = { "DVDSystemFileDateBase" , "DateBaseVersion:v1.0" };
	
	/**
	 * 构造函数
	 * @param filePathName
	 * @param mainDate
	 */
	public ControlFile( String filePathName, ControlMain mainDate) throws ExceptionInInitializerError {
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
	 * @return
	 */
	public boolean isFileExists() {
		return mainFile.exists();
	}
	
	/**
	 * 创建新文件
	 * @return 异常返回false 成功返回true
	 */
	public boolean createNewFile() {
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
	public void closeReadHandle() {
		if ( mainReadHandle != null ) {
			mainReadHandle.close();
			mainReadHandle = null;
		}
	}
	
	/**
	 * 关闭写文件句柄
	 */
	public void closeWriteHandle() {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.close();
			mainWriteHandle = null;
		}
	}
	
	/**
	 * 打开读取用文件句柄
	 * @return
	 */
	public boolean openReadHandle() {
		if (mainReadHandle == null) {
			try {
				mainReadHandle = new Scanner(mainFile);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 读取用文件句柄是否打开
	 * @return
	 */
	public boolean isOpenReadHandle() {
		if ( mainReadHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * 读取下一行
	 * @return	句柄为null or 没有下一行 则返回 null
	 */
	public String readNextLN() {
		if ( mainReadHandle != null && mainReadHandle.hasNextLine() ) {
			return mainReadHandle.nextLine();
		}
		return null;
	}
	
	/**
	 * 读取下一个int
	 * @return	句柄为null or 没有下一个int 则返回 null
	 */
	public Integer readNextInt() {
		if ( mainReadHandle != null && mainReadHandle.hasNextLine() ) {
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
	 * @return
	 */
	public boolean openWriteHandle() {
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
	 * @return
	 */
	public boolean isOpenWriteHandle() {
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
	public boolean writeNextLN( String line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	public boolean writeNextLN( int line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	public boolean writeNextLN() {
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
	public boolean writeDVD(DVD dbject) {
		if ( mainWriteHandle == null ) {
			return false;
		}
		if (dbject == null) {
			return false;
		}
		mainWriteHandle.println();
		mainWriteHandle.println("DVDObjectB");
		mainWriteHandle.println(dbject.getTitle());
		mainWriteHandle.println(dbject.getID());
		mainWriteHandle.println(dbject.getYear());
		mainWriteHandle.println(dbject.getAmount());
		mainWriteHandle.println(dbject.getBuyPrice());
		mainWriteHandle.println(dbject.getRentPrice());
		mainWriteHandle.println(dbject.getRentAmount());
		mainWriteHandle.println(dbject.canSell());
		mainWriteHandle.println(dbject.canRent());
		// 未来扩展的插入位置
		mainWriteHandle.println("DVDObjectSB");
		mainWriteHandle.println(dbject.styleGetSize());
		for (Long a : dbject.styleGetAll()) {
			mainWriteHandle.println(a);
		}
		mainWriteHandle.println("DVDObjectSE");
		mainWriteHandle.println("DVDObjectE");
		return true;
	}
	
	/**
	 * 写入一个Style对象
	 * @param sbject
	 * @return	句柄为null返回null
	 */
	public boolean writeStyle(Style sbject) {
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
	 * 写入一个User对象
	 * @param ubject
	 * @return	句柄为null返回null
	 */
	public boolean writeUser(User ubject) {
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
	 * 写入整个ControlMain对象所有数据
	 * @return	只有完全写入完成才返回true
	 */
	public boolean writeMainDate() {
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
	

}
