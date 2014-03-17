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
	 * ʹ�ö�����λ�ͱ�ʾ��<br>
	 * ������λ������ɱ�ʾ��������(2����)<br>
	 * ��ʹ�ùؼ����б��ѯ����Ӧ��Ϣ<br>
	 * <br>
	 * PS:��ʵ���������������ˣ��ѱ����������ڷ������<br>
	 * ������ʱ��Ӧ�ķ����������ɱ�Ŵ�<br>
	 */
	private long style;
	
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
	private double price;
	
	// �ع�ʱ����޸�;������ʵ�ֹ���Ա����
	/**
	 * ��������
	 */
	private final int SELL_LIMIT = 3;
	private  int sellLimit;
	/**
	 * �������
	 */
	private final int RENT_LIMIT = 0;
	private  int rentLimit;
	/**
	 * Ϊ��������õ�Ĭ�ϳ�ʼ������<br>
	 * <br>
	 * ��ʼ�����ݣ�<br>
	 * title = ""<br>
	 * year = 0<br>
	 * style = 0<br>
	 * amount = 0<br>
	 * sell = false<br>
	 * rent =  false<br>
	 * rentAmount = 0<br>
	 * price = 0<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 */
	public DVD() {
		this.title = "";
		this.year = 0;
		this.style = 0;
		this.amount = 0;
		this.sell = false;
		this.rent =  false;
		this.rentAmount = 0;
		this.price = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * ���췽��<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @author Jeremie
	 */
	public DVD( String title, int year, long style, int amount, boolean sell, boolean rent, double price) {
		this.title = title;
		this.year = year;
		this.style = style;
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.price = price;
		this.rentAmount = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * �����������ݣ��������Ϊ����������ӳ����ö����<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param price
	 * @param rentAmount
	 */
	public void setAllDate( String title, int year, long style, int amount, boolean sell, boolean rent, double price, int rentAmount) {
		this.title = title;
		this.year = year;
		this.style = style;
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.price = price;
		this.rentAmount = rentAmount;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * �����������ݣ��������Ϊ����������ӳ����ö����<br>
	 * ��������rentAmount<br>
	 * sellLimit = SELL_LIMIT<br>
	 * rentLimit = RENT_LIMIT<br>
	 * @param title
	 * @param year
	 * @param style
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param price
	 */
	public void setAllDate( String title, int year, long style, int amount, boolean sell, boolean rent, double price) {
		this.title = title;
		this.year = year;
		this.style = style;
		this.amount = amount;
		this.sell = sell;
		this.rent =  rent;
		this.price = price;
		this.rentAmount = 0;
		this.sellLimit = SELL_LIMIT;
		this.rentLimit = RENT_LIMIT;
	}
	/**
	 * @return sELL_LIMIT
	 */
	public int getSELL_LIMIT() {
		return SELL_LIMIT;
	}
	/**
	 * @return rENT_LIMIT
	 */
	public int getRENT_LIMIT() {
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
	 * @return style
	 */
	public long getStyle() {
		return style;
	}
	/**
	 * @param style Ҫ���õ� style
	 */
	public void setStyle(long style) {
		this.style = style;
	}
	/**
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price Ҫ���õ� price
	 */
	public void setPrice(double price) {
		this.price = price;
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
		if (this.amount > rentLimit) {
			--this.amount;
			if (this.amount <= rentLimit) {
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
