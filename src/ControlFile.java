import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * �ļ�������
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
	 * ���캯��
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
	 * �ļ��Ƿ����
	 * @return
	 */
	public boolean isFileExists() {
		return mainFile.exists();
	}
	
	/**
	 * �������ļ�
	 * @return �쳣����false �ɹ�����true
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
	 * ��������<br>
	 * �رվ��<br>
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
	 * �رն��ļ����
	 */
	public void closeReadHandle() {
		if ( mainReadHandle != null ) {
			mainReadHandle.close();
			mainReadHandle = null;
		}
	}
	
	/**
	 * �ر�д�ļ����
	 */
	public void closeWriteHandle() {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.close();
			mainWriteHandle = null;
		}
	}
	
	/**
	 * �򿪶�ȡ���ļ����
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
	 * ��ȡ���ļ�����Ƿ��
	 * @return
	 */
	public boolean isOpenReadHandle() {
		if ( mainReadHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * ��ȡ��һ��
	 * @return	���Ϊnull or û����һ�� �򷵻� null
	 */
	public String readNextLN() {
		if ( mainReadHandle != null && mainReadHandle.hasNextLine() ) {
			return mainReadHandle.nextLine();
		}
		return null;
	}
	
	/**
	 * ��ȡ��һ��int
	 * @return	���Ϊnull or û����һ��int �򷵻� null
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
	 * ��д�����ļ����
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
	 * д�����ļ�����Ƿ��
	 * @return
	 */
	public boolean isOpenWriteHandle() {
		if ( mainWriteHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * д��һ��<br>
	 * ����<br>
	 * @param line	
	 * @return ���Ϊ�շ���null
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
	 * д��һ��DVD����<br>
	 * @param dbject
	 * @return ���Ϊnull����null
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
		mainWriteHandle.println(dbject.getTitle());	// String
		mainWriteHandle.println(dbject.getID());	// Long
		mainWriteHandle.println(dbject.getYear());	// int
		mainWriteHandle.println(dbject.getAmount());	// int
		mainWriteHandle.println(dbject.getBuyPrice());	// double
		mainWriteHandle.println(dbject.getRentPrice());	// double
		mainWriteHandle.println(dbject.getRentAmount());	// int
		mainWriteHandle.println(dbject.canSell());	// bool
		mainWriteHandle.println(dbject.canRent());	// bool
		// δ����չ�Ĳ���λ��
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
	 * ��ȡһ��DVD����<br>
	 * ����ǰ������<br>
	 * <br>
	 * �ɹ����ع���õĶ���<br>
	 * ʧ���׳��쳣<br>
	 * @return DVD����
	 * @throws Exception
	 */
	public DVD readDVD() throws Exception {	// TODO ��ȡ���д���
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Scanner in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectB")) {
			throw new Exception("Read Error.");
		}
		// String title, long iD, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice, int rentAmount
		String title;
		long iD;
		int year;
		ArrayList<Long> style = new ArrayList<Long>();
		int amount;
		boolean sell;
		boolean rent;
		double byprice;
		double rentPrice;
		int rentAmount;
		if ( !in.hasNextLine() ) {
			throw new Exception("Read Error.");
		}
		title = in.nextLine();
		if ( !in.hasNextLong() ) {
			throw new Exception("Read Error.");
		}
		iD = in.nextLong();
		if ( !in.hasNextInt() ) {
			throw new Exception("Read Error.");
		}
		year = in.nextInt();
		if ( !in.hasNextInt() ) {
			throw new Exception("Read Error.");
		}
		amount = in.nextInt();
		if ( !in.hasNextDouble() ) {
			throw new Exception("Read Error.");
		}
		byprice = in.nextDouble();
		if ( !in.hasNextDouble() ) {
			throw new Exception("Read Error.");
		}
		rentPrice = in.nextDouble();
		if ( !in.hasNextInt() ) {
			throw new Exception("Read Error.");
		}
		rentAmount = in.nextInt();
		if ( !in.hasNextBoolean() ) {
			throw new Exception("Read Error.");
		}
		sell = in.nextBoolean();
		if ( !in.hasNextBoolean() ) {
			throw new Exception("Read Error.");
		}
		rent = in.nextBoolean();
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectSB")) {
			throw new Exception("Read Error.");
		}
		if ( !in.hasNextInt() ) {
			throw new Exception("Read Error.");
		}
		int iTemp = in.nextInt();
		for (int i = 0; i < iTemp; i++) {
			if ( !in.hasNextLong() ) {
				throw new Exception("Read Error.");
			}
			style.add(in.nextLong());
		}
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectSE")) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("DVDObjectE")) {
			throw new Exception("Read Error.");
		}
		return new DVD(title, iD, year, style, amount, sell, rent, byprice, rentPrice, rentAmount);
	}
	
	/**
	 * д��һ��Style����
	 * @param sbject
	 * @return	���Ϊnull����null
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
	 * ��ȡһ��Style����<br>
	 * ����ǰ������<br>
	 * <br>
	 * �ɹ����ض��� ʧ���׳��쳣<br>
	 * @return Style����
	 * @throws Exception
	 */
	public Style readStyle() throws Exception {	// TODO ��ȡ���д���
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Scanner in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("StyleObjectB")) {
			throw new Exception("Read Error.");
		}
		String name;
		Long iD;
		if (!in.hasNextLine()) {
			throw new Exception("Read Error.");
		}
		name = in.nextLine();
		if (!in.hasNextLong()) {
			throw new Exception("Read Error.");
		}
		iD = in.nextLong();
		// ע�⣺��next�������֮���nextline�����ȡ��һ�����ִ�
		// ����next�������֮��ȴû�л��е�û���ַ���
		// ��ʵ�������nextline��ȡ���˾������֮����Ǹ����з���
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("StyleObjectE")) {
			throw new Exception("Read Error.");
		}
		return new Style(name, iD);
	}
	
	/**
	 * д��һ��User����
	 * @param ubject
	 * @return	���Ϊnull����null
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
	 * ��ȡһ��User����<br>
	 * �ɹ����ض��� ʧ���׳��쳣<br>
	 * @return	User����
	 * @throws Exception
	 */
	public User readUser() throws Exception {	// TODO ��ȡ���д���
		if ( mainReadHandle == null ) {
			throw new Exception("Read Handle is null.");
		}
		Scanner in = mainReadHandle;
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("UserObjectB")) {
			throw new Exception("Read Error.");
		}
		String name;
		String password;
		double money;
		if ( !in.hasNextLine()) {
			throw new Exception("Read Error.");
		}
		name = in.nextLine();
		if ( !in.hasNextLine()) {
			throw new Exception("Read Error.");
		}
		password = in.nextLine();
		if ( !in.hasNextDouble()) {
			throw new Exception("Read Error.");
		}
		money = in.nextDouble();
		User Temp = new User(name,password,money,mainDate.getDVDMainDateArrayList());
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		if ( !in.nextLine().equals("UserObjectDB")) {
			throw new Exception("Read Error.");
		}
		if ( !in.hasNextInt()) {
			throw new Exception("Read Error.");
		}
		int size = in.nextInt();
		if ( !in.nextLine().isEmpty()) {
			throw new Exception("Read Error.");
		}
		for (int i = 0; i < size; i++) {
			if ( !in.nextLine().equals("UserObjectDUB")) {
				throw new Exception("Read Error.");
			}
			String named;
			long ID;
			int rentAmount;
			int buyAmount;
			if ( !in.hasNextLine()) {
				throw new Exception("Read Error.");
			}
			named = in.nextLine();
			if ( !in.hasNextLong()) {
				throw new Exception("Read Error.");
			}
			ID = in.nextLong();
			if ( !in.hasNextInt()) {
				throw new Exception("Read Error.");
			}
			buyAmount = in.nextInt();
			if ( !in.hasNextInt()) {
				throw new Exception("Read Error.");
			}
			rentAmount = in.nextInt();
			if ( !in.nextLine().isEmpty()) {
				throw new Exception("Read Error.");
			}
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
	 * д������ControlMain������������
	 * @return	ֻ����ȫд����ɲŷ���true
	 */
	public boolean writeMainDate() {
		if ( mainWriteHandle == null ) {
			return false;
		}
		// ˳��Style��DVD��User
		// �汾��У����Ϣ
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
	 * ��ȡ�����ļ��������ݲ�׷�ӵ���������<br>
	 * @return ������ɶ�ȡ����true �κεĶ�ȡʧ�ܷ���false
	 */
	public boolean readMainDate() {
		if ( mainReadHandle == null) {
			return false;
		}
		Scanner in = mainReadHandle;
		for (String a : FILE_VERSION_STRINGS) {
			if ( !in.hasNextLine() || !in.nextLine().equals(a)) {
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
			int size;
			if ( !in.hasNextInt()) {
				return false;
			}
			size = in.nextInt();
			in.hasNextLine(); // Test
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
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
			int size;
			if ( !in.hasNextInt()) {
				return false;
			}
			size = in.nextInt();
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
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
			int size;
			if ( !in.hasNextInt()) {
				return false;
			}
			size = in.nextInt();
			if ( !in.nextLine().isEmpty()) {
				return false;
			}
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
	}

}
