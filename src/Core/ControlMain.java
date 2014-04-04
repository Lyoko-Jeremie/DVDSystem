package Core;
import java.util.ArrayList;

/**
 * ����ϵͳ���Ŀ��ƽṹ<br>
 * @author Jeremie
 */

/**
 * ��ϵͳ��Ҫ�ṹ<br>
 * ͬʱֻ��ʹ��һ��<br>
 * @author Jeremie
 */
public class ControlMain {
	
	/**
	 * DVD������ṹ<br>
	 */
	private ArrayList<DVD> dVDMainDateArrayList;
	
	/**
	 * Style����ṹ
	 */
	private ArrayList<Style> dVDStyleArrayList;
	
	/**
	 * �û��б�
	 */
	private ArrayList<User> usersMainDateArrayList;
	
	/**
	 * �ļ�������
	 */
	private ControlFile mainFile;
	
	/**
	 * ������󱣻�
	 */
	private static int PRO = 0;
	
	
	/**
	 * Ψһ�Ĺ��췽��<br>
	 * ��������󱣻�����<br>
	 * ��ʼ������������ṹ<br>
	 * ���������ݿ��ļ�<br>
	 */
	public ControlMain() {
		if ( ControlMain.PRO>0) {
			// ������󱣻�
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
	 * ����<br>
	 * ���ټ���
	 */
	@Override
	public void finalize() {
		--ControlMain.PRO;
	}
	
	// TO DO ��DVD��ʹ��������������ʱ��Ҫ���һ�����������Ƶ�DVDadd
	
	/**
	 * ���һ��DVD����������DVD����<br>
	 * ����title��year�ж��ظ�<br>
	 * @param title
	 * @param year
	 * @param style	
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyPrice
	 * @param rentPrice
	 * @return û�в鵽�ظ�����ӳɹ�����true
	 */
	public boolean addDVD(String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double buyPrice, double rentPrice) {
		// ����
		for (DVD a : this.dVDMainDateArrayList) {
			if ( a.getTitle().equals(title) && a.getYear() == year ) {
				return false;
			}
		}
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
		return true;
	}
	
	/**
	 * ���һ��DVD���Զ������Ƿ����������Զ�������<br>
	 * ����title��year�ж��ظ�<br>
	 * @param title
	 * @param year
	 * @param style	�Կո����ķ���ִ� ��Ϊ���ִ���Ϊnull���Զ�Ϊ��
	 * @param amount
	 * @param buyPrice
	 * @param rentPrice
	 * @return û�в鵽�ظ�����ӳɹ�����true
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
		// ����
		for (DVD a : this.dVDMainDateArrayList) {
			if ( a.getTitle().equals(title) && a.getYear() == year ) {
				return false;
			}
		}
		dVDMainDateArrayList.add( new DVD(title, year, tAL, amount, sell, rent, buyPrice, rentPrice));
		return true;
	}

	/**
	 * ���һ��DVD���Զ������Ƿ�������<br>
	 * ����title��year�ж��ظ�<br>
	 * @param title
	 * @param year
	 * @param style	
	 * @param amount
	 * @param buyPrice
	 * @param rentPrice
	 * @return û�в鵽�ظ�����ӳɹ�����true
	 */
	public boolean addDVD(String title, int year, ArrayList<Long> style, int amount, double buyPrice, double rentPrice) {
		// ����
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
	 * ���һ��Style
	 * @param name
	 * @return ��������false
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
	 * ���һ��Style
	 * @param name
	 * @return ����ID �����򷵻����ж���ID
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
	 * ��Index��ȡStyle��<br>
	 * �����á�Only��<br>
	 * <br>
	 * Javaû��size_type��.<br>
	 * @param Index
	 * @return	�Ҳ���������null
	 */
	public String getStyle(int Index){
		if (Index < this.dVDStyleArrayList.size()) {
			return this.dVDStyleArrayList.get(Index).getName();
		}
		return null;
	}
	
	/**
	 * ��Style����ȡID<br>
	 * <br>
	 * @param style
	 * @return	�Ҳ���������0
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
	 * ��ID��ȡStyle��<br>
	 * @param ID
	 * @return	�Ҳ���������null
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
	 * ��ȡStyle������
	 * @return int  Size
	 */
	public int getStyleSize() {
		return this.dVDStyleArrayList.size();
	}
	
	/**
	 * ���һ���û�<br>
	 * ����ʼ���ֽ���<br>
	 * ��name�ж��ظ�<br>
	 * @param money
	 * @param name
	 * @return dVDMainDateArrayList���Ϊnull �� �ظ� ����false
	 */
	public boolean addOneUser(String name, String password, double money) {
		if (this.dVDMainDateArrayList != null) {
			// ����
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
	 * ��ȡָ���û�����<br>
	 * ������<br>
	 * @param Index	�±�
	 * @return	������Χ����null
	 */
	protected User getUser(int Index) {
		try {
			return this.usersMainDateArrayList.get(Index);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * ��ȡָ���û�����<br>
	 * ����<br>
	 * @param name		�û���
	 * @return	�Ҳ�������null
	 */
	public User getUser(String name) {
		for (User a : this.usersMainDateArrayList) {
			// ע�⣺��Ϊnull�ַ������û�
			// ��ʵ��ֻҪ��Ϊnull������Ϊ""������Ҫ���null
			if (a.getName() != null) {
				if (a.getName().equals(name)) {
					return a;
				}
			}
		}
		return null;
	}

	/**
	 * ��ȡָ��DVD����<br>
	 * ������<br>
	 * @param Index	�±�
	 * @return	������Χ����null
	 */
	protected DVD getDVD(int Index) {
		try {
			return this.dVDMainDateArrayList.get(Index);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * ��ȡDVD������
	 * @return	int
	 */
	public int getDVDSize() {
		return this.dVDMainDateArrayList.size();
	}
	
	/**
	 * ��ȡָ��DVD����<br>
	 * ������<br>
	 * @param Title		����
	 * @return		�Ҳ�������null
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
	 * ��ȡָ��DVD����<br>
	 * ������<br>
	 * @param iD		����
	 * @return		�Ҳ�������null
	 */
	public DVD getDVD(long iD) {
		for (DVD a : this.dVDMainDateArrayList) {
			if (a.getID() == iD) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * ��ȡָ��DVD�����ָ�����
	 * @param A	ָ����DVD����
	 * @param index	���±�
	 * @return String	Style�ִ���û���ҵ�or����Χ���ؿ��ִ�
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
	 * Waring:��Ч
	 */
	public ArrayList<DVD> getDVDMainDateArrayList() {
		return new  ArrayList<DVD>(dVDMainDateArrayList);
	}

	/**
	 * @return dVDStyleArrayList
	 * Waring:��Ч
	 */
	public ArrayList<Style> getDVDStyleArrayList() {
		return new ArrayList<Style>(dVDStyleArrayList);
	}

	/**
	 * @return usersMainDateArrayList
	 * Waring:��Ч
	 */
	public ArrayList<User> getUsersMainDateArrayList() {
		return new ArrayList<User>(usersMainDateArrayList);
	}
	
	/**
	 * ���DVD������������<br>
	 * ��title��year�ж���ͬ<br>
	 * @param dbject
	 * @return	 û���ظ�����ӳɹ�����true
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
	 * ���User������������<br>
	 * ��name�ж��ظ�<br>
	 * @param ubject
	 * @return	 û���ظ�����ӳɹ�����true
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
	 * ���Style������������<br>
	 * ��name�ж��ظ�<br>
	 * @param sbject
	 * @return û���ظ�����ӳɹ�����true
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
	 * ��������
	 * @return �ɹ�����true
	 * @throws Exception ʧ���׳��쳣 �쳣��string�����˳����쳣��λ����Ϣ
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
	 * ��ȡ����
	 * @return �ɹ�����true
	 * @throws Exception ʧ���׳��쳣 �쳣��string�����˳����쳣��λ����Ϣ
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
