import java.util.ArrayList;

/**
 * �û���
 */

/**
 * �û���<br>
 * ע�⣺������������ʱΪnull<br>
 * @author Jeremie
 *
 */
public class User {
	/**
	 * �û���
	 */
	private String name;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �Ѿ��򵽵ĺ��Ѿ��赽��DVD��
	 */
	private ArrayList<DVDUser> userDVDArrayList; //= new ArrayList<DVDUser>();
	/**
	 * �ֽ�
	 */
	private double money;
	/**
	 * ָ�����������ľ��
	 */
	private ArrayList<DVD> dateHandle;
	/**
	 * ���캯��<br>
	 * <br>
	 * <br>
	 * �Զ�������������null<br>
	 * @param money	��ʼ���
	 * @param handle	ָ�����������ľ��
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
	 * ������������Ĺ��캯��<br>
	 * @param name
	 * @param password
	 * @param money
	 * @param handle
	 */
	public User(String name, String password, double money, 	ArrayList<DVD> handle) {
		this.name = name;
		this.password = password;
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
		this.dateHandle = handle;
		if (handle==null) {
			throw new ExceptionInInitializerError("\n\tHandle Cant are null !!");
		}
	}

	/**
	 * �����ֽ�����<br>
	 * �����Ǹ���<br>
	 * @param m	���ӵ���
	 * @return	���Ӻ����
	 */
	public double addMoney(double m) {
		this.money += m;
		return this.money;
	}

	/**
	 * ��һ��DVD<br>
	 * @param n	DVD�±�
	 * @param Date	��DVD�б������
	 * @return	��������or��Ǯ����orû���践��false
	 */
	public boolean rentDVD(int n) {
		if (n < dateHandle.size()) {
			// û��Խ��
			if (this.money >= dateHandle.get(n).getRentPrice()) {
				// Ǯ��
				if (dateHandle.get(n).rentOne()) {
					// �ܽ�
					this.addRentDate(dateHandle.get(n).getTitle(), dateHandle.get(n).getID());
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ��DVD
	 * @param name DVD��
	 * @return	��û�н����orû�����DVD ����false
	 */
	public boolean reDVD(String name) {
		for (int i = 0; i < this.userDVDArrayList.size(); i++) {
			if (this.userDVDArrayList.get(i).getName().equals(name)) {
				// ������¼
				for (DVD a : this.dateHandle) {
					// ����DVD
					if ( a.getTitle().equals(name) ) {
						// ����һ��
						if (a.getID() == this.userDVDArrayList.get(i).getID()) {
							// IDһ��
							if ( this.userDVDArrayList.get(i).rentAmount > 0 ) {
								// ȷʵ����
								if ( a.surrenderOne() ) {
									// ȷʵ����
									--this.userDVDArrayList.get(i).rentAmount;	// �������� TAT
									// ��Ϊ0Ҫɾ����¼
									if (this.userDVDArrayList.get(i).rentAmount == 0 && this.userDVDArrayList.get(i).buyAmount == 0) {
										this.userDVDArrayList.remove(i);
									}
									return true;
								}
							}
						}
					}
				}
				break;		// �м�¼����û�ж�ӦDVD
			}
		}
		return false;
	}
	
	/**
	 * ��һ��DVD<br>
	 * @param n	DVD�±�
	 * @param Date	��DVD�б������
	 * @return	��������orǮ����orû���践��false
	 */
	public boolean buyDVD(int n) {
		if (n < dateHandle.size()) {
			// δԽ��
			if (this.money >= dateHandle.get(n).getBuyPrice()) {
				// Ǯ��
				if (dateHandle.get(n).sellOne()) {
					// ����
					this.addBuyDate(dateHandle.get(n).getTitle(), dateHandle.get(n).getID());
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ���ӽ��¼
	 * @return	�����ķ���true �Ѿ��еķ���false
	 */
	private boolean addRentDate(String name,long ID) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// �ҵ�
				++a.rentAmount;
				return false;
			}
		}
		// δ�ҵ�
		this.userDVDArrayList.add(new DVDUser(name,ID,1,0));
		return true;
	}
	
	
	/**
	 * �������¼
	 * @return	�����ķ���true �Ѿ��еķ���false
	 */
	private boolean addBuyDate(String name, long ID) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// �ҵ�
				++a.buyAmount;
				return false;
			}
		}
		// δ�ҵ�
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
	 * @param name Ҫ���õ� name
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
	 * @param password Ҫ���õ� password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}














/**
 * User��¼��DVD��<br>
 * @author Jeremie
 *
 */
class DVDUser {
	/**
	 * DVD��<br>
	 * ������Ϊ����<br>
	 * <br>
	 * <br>
	 * ��DVD��ID&nameΪ����<br>
	 * 
	 */
	private String name;
	/**
	 * DVD��ID
	 */
	private long ID;
	/**
	 * �Ѿ��������
	 */
	public int rentAmount = 0;
	/**
	 * �Ѿ��������
	 */
	public int buyAmount = 0;
	
	/**
	 * ���캯��
	 * @param name
	 * @param ID	��ӦDVD��ID
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

