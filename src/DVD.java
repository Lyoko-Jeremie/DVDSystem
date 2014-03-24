import java.util.ArrayList;
import java.util.Random;

/**
 * DVD�������<br>
 * @author Jeremie
 */

/**
 * DVD������<br>
 * ����DVD������<br>
 * @author Jeremie
 *
 */
public class DVD {
	private String title;
	private int year;
	
	/**
	 * ��Ӱ����&���<br>
	 * ��ʹ�ùؼ����б��ѯ����Ӧ��Ϣ<br>
	 */
	private ArrayList<Long> style;
	
	/**
	 * �ܼ�����
	 */
	private int amount;
	/**
	 * �Ѿ����������<br>
	 * ���ڽ��˭�ˣ����û�������Լ�¼�Ѿ���ıȽϱ��ڹ���
	 */
	private int rentAmount;
	/**
	 * ����
	 */
	private boolean sell;
	/**
	 * �ɽ�
	 */
	private boolean rent;
	/**
	 * �۸�
	 */
	private double buyPrice;
	private double rentPrice;
	
	// �ع�ʱ����޸�;������ʵ�ֹ���Ա����
	/**
	 * ��������
	 */
	private static final int SELL_LIMIT = 3;
	private  int sellLimit;
	/**
	 * �������
	 */
	private static final int RENT_LIMIT = 0;
	private  int rentLimit;
	
	/**
	 * ��������ɵ�ID<br>
	 * ��title��ID��ͬ���DVD<br>
	 */
	private long ID;
	
	/**
	 * Ϊ��������õ�Ĭ�ϳ�ʼ������<br>
	 * <br>
	 * ��ʼ�����ݣ�<br>
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
	 * ���췽��<br>
	 * style != null<br>
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
	public DVD( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice) {
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
		this.buyPrice = byprice;
		this.rentPrice = rentPrice;
		this.rentAmount = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
		Random r = new Random();
		this.ID = r.nextLong();
	}
	/**
	 * �����������ݣ��������Ϊ����������ӳ����ö����<br>
	 * style != null<br>
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
	public void setAllDate( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice, int rentAmount) {
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
		this.buyPrice = byprice;
		this.rentPrice = rentPrice;
		this.rentAmount = rentAmount;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * �����������ݣ��������Ϊ�ļ���ȡ�����<br>
	 * style != null<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param ID
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 * @param rentAmount
	 */
	public void setAllDate( String title, long iD, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice, int rentAmount) {
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
		this.buyPrice = byprice;
		this.rentPrice = rentPrice;
		this.rentAmount = rentAmount;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * �����������ݣ��������Ϊ����������ӳ����ö����<br>
	 * ��������rentAmount<br>
	 * style != null<br>
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
	public void setAllDate( String title, int year, ArrayList<Long> style, int amount, boolean sell, boolean rent, double byprice, double rentPrice) {
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
		this.buyPrice = byprice;
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
	 * @param buyPrice Ҫ���õ� buyPrice
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
	 * @param rentPrice Ҫ���õ� rentPrice
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

// ����δ����չ��
//	/**
//	 * @return sellLimit
//	 */
//	public int getSellLimit() {
//		return sellLimit;
//	}
//	/**
//	 * @param sellLimit Ҫ���õ� sellLimit
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
//	 * @param rentLimit Ҫ���õ� rentLimit
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
	 * @param title Ҫ���õ� title
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
	 * @param year Ҫ���õ� year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return style	��Ϊ��Ҫ�����ڲ����� ���ص�����ʱ���� TMDjava�������ɵ��ڴ�й©����Դռ���ҾͲ�����
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
	 * @return long		�����Խ��
	 */
	public long styleGet(int index) {
		return style.get(index);
	}
	/**
	 * ���������� style
	 * @param style
	 */
	public void styleSetALL(ArrayList<Long> style) {
		this.style = style;
	}
	/**
	 * @param style Ҫ���ӵ� style
	 * @return �Ѿ�����false
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
	 * @param style Ҫ���ҵ� style
	 * @return �ҵ�true
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
	 * @param style Ҫɾ���� style
	 * @return �ҵ�true
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
	 * ����ʱ��������sellLimit
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
	 * �ɽ�ʱ��������rentLimit
	 */
	public boolean canRent() {
		// ˳��ˢ��
		if (this.amount > rentLimit) {
			this.rent = true;
		}else {
			this.rent = false;
		}
		return rent;
	}
	/**
	 * ��һ��
	 * �赽rentLimit�Ͳ��ܽ���
	 * @return boolean ��ɹ�����true ʧ�ܷ���false
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
	 * ��һ��<br>
	 * ����sellLimit���Ͳ��������ˣ�ֻ�ܽ�
	 * @return boolean ���ɹ�����true ʧ�ܷ���false
	 */
	public boolean sellOne() {
		if (this.amount > sellLimit) {
			--this.amount;
			// ����SELL_LIMIT���Ͳ�������
			if (this.amount <= sellLimit) {
				this.sell = false;
			}
			return true;
		}
		return false;
	}
	/**
	 * ��һ��
	 * @return ����ɹ�����true��ʧ�ܣ���û�н����ô�ࣩ����false
	 */
	public boolean surrenderOne() {
		if (this.rentAmount > rentLimit ) {
			--this.rentAmount;
			++this.amount;
			// �ָ�����״̬
			if (this.amount > sellLimit) {
				this.sell = true;
			}
			// �϶���������
			this.rent = true;
			return true;
		} else {
			return false;
		}
	}

}
