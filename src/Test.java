import java.util.Scanner;


/**
 * 开发期测试用<br>
 * @author Jeremie
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		ControlMain Test = new ControlMain();
		Menu a = new Menu();
//		Menu b = new Menu();
		a.mainMenu(in);
		
		in.close();

	}
	
	public static void init( ControlMain TR ) {
		TR.addOneUser("", "", Integer.MAX_VALUE);
		// TR.addStyle("爱情");
		// TR.addStyle("喜剧");
		// TR.addStyle("校园");
		// TR.addStyle("犯罪");
		// TR.addStyle("剧情");
		// TR.addStyle("惊怵");
		// TR.addStyle("冒险");
		// TR.addStyle("西部");
		// TR.addStyle("剧情");
		// TR.addStyle("神秘");
		// TR.addStyle("传记");
		// TR.addStyle("剧情");
		// TR.addStyle("历史");
		// TR.addStyle("战争");
		// TR.addStyle("动作");
		// TR.addStyle("冒险");
		// TR.addStyle("科幻");
		// TR.addStyle("动作");
		// TR.addStyle("冒险");
		// TR.addStyle("剧情");
		// TR.addStyle("奇幻");
		TR.addDVD("小时代", 2004, "爱情 喜剧 校园", 1000, 100, 100);
		TR.addDVD("肖申克的救赎", 1994, "", 1000, 100, 100);
		TR.addDVD("教父", 1972, "犯罪 剧情 惊怵", 1000, 100, 100);
		TR.addDVD("教父：II", 1974, "犯罪 剧情 惊怵", 1000, 100, 100);
		TR.addDVD("低俗小说", 1994, "", 1000, 100, 100);
		TR.addDVD("黄金三镖客", 1967, "冒险 西部", 1000, 100, 100);
		TR.addDVD("十二怒汉", 1957, "剧情 神秘", 1000, 100, 100);
		TR.addDVD("辛德勒名单", 1993, "传记 剧情 历史 战争", 1000, 100, 100);
		TR.addDVD("指环王：王者归来", 2003, "", 1000, 100, 100);
		TR.addDVD("搏击俱乐部", 1999, "", 1000, 100, 100);
		TR.addDVD("星球大战Ⅴ：帝国反击战", 1980, "动作 冒险 科幻", 1000, 100, 100);
		TR.addDVD("飞越疯人院", 1975, "", 1000, 100, 100);
		TR.addDVD("指环王：护戒使者", 2001, "动作 冒险 剧情 奇幻", 1000, 100, 100);
		TR.addDVD("盗梦空间", 2010, "", 1000, 100, 100);
		TR.addDVD("好家伙", 1990, "", 1000, 100, 100);
		TR.addDVD("星球大战IV：新希望", 1977, "动作 冒险 奇幻 科幻", 1000, 100, 100);
		TR.addDVD("七武士", 1956, "动作 冒险 剧情", 1000, 100, 100);
		TR.addDVD("黑客帝国", 1999, "动作 冒险 科幻", 1000, 100, 100);
		TR.addDVD("上帝之城", 2002, "", 1000, 100, 100);
		TR.addDVD("阿甘正传", 1994, "剧情 爱情", 1000, 100, 100);
		TR.addDVD("指环王：双塔奇兵", 2002, "动作 冒险 奇幻", 1000, 100, 100);
		TR.addDVD("西部往事", 1968, "西部", 1000, 100, 100);
		TR.addDVD("卡萨布兰卡", 1943, "剧情 爱情 战争", 1000, 100, 100);
		TR.addDVD("七宗罪", 1995, "犯罪 剧情 神秘 惊怵", 1000, 100, 100);
		TR.addDVD("沉默的羔羊", 1991, "犯罪 惊怵", 1000, 100, 100);
		TR.addDVD("夺宝奇兵", 1981, "动作 冒险", 1000, 100, 100);
		TR.addDVD("非常嫌疑犯", 1995, "犯罪 神秘 惊怵", 1000, 100, 100);
		TR.addDVD("后窗", 1955, "犯罪 神秘 爱情 惊怵", 1000, 100, 100);
		TR.addDVD("蝙蝠侠：黑暗骑士崛起", 2012, "", 1000, 100, 100);
		TR.addDVD("惊魂记", 1960, "剧情 恐怖 神秘 惊怵", 1000, 100, 100);
		TR.addDVD("美好人生", 1947, "剧情 奇幻 爱情", 1000, 100, 100);
		TR.addDVD("杀手莱昂", 1994, "犯罪 剧情 惊怵", 1000, 100, 100);
		TR.addDVD("日落大道", 1950, "剧情 黑色", 1000, 100, 100);
		TR.addDVD("记忆碎片", 2000, "犯罪 剧情 神秘 惊怵", 1000, 100, 100);
		TR.addDVD("美国X档案", 1998, "", 1000, 100, 100);
		TR.addDVD("现代启示录", 1979, "剧情 战争", 1000, 100, 100);
		TR.addDVD("终结者2：审判日", 1991, "动作 科幻 惊怵", 1000, 100, 100);
		TR.addDVD("奇爱博士", 1964, "喜剧 剧情", 1000, 100, 100);
		TR.addDVD("拯救大兵瑞恩", 1998, "动作 剧情 历史 战争", 1000, 100, 100);
		TR.addDVD("异形", 1979, "恐怖 科幻", 1000, 100, 100);
		TR.addDVD("西北偏北", 1959, "动作 冒险 剧情 神秘 爱情 惊怵", 1000, 100, 100);
		TR.addDVD("城市之光", 1931, "喜剧 剧情 爱情", 1000, 100, 100);
		TR.addDVD("千与千寻", 2001, "动画 冒险 家庭 奇幻", 1000, 100, 100);
		// TR.addDVD("", , "", 1000, 100, 100);
		
//		{
//			System.out.println(TR.getMainFile().createNewFile());
//			System.out.println(TR.getMainFile().openWriteHandle());
//			System.out.println(TR.getMainFile().isOpenWriteHandle());
//			System.out.println(TR.getMainFile().writeMainDate());
//			TR.getMainFile().closeWriteHandle();
//		}
		
	}

}



