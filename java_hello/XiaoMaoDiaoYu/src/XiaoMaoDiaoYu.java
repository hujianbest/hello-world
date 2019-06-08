import java.util.LinkedList;
import java.util.List;

public class XiaoMaoDiaoYu {
	private final int PLAY_NUM = 2;
	private String[] players = new String[PLAY_NUM];
	private List<String>[] playersCards = new List[PLAY_NUM];

	public void initPlayer(String... names) {
		for (int i = 0; i < names.length; i++)
			players[i] = names[i];
	}

	public void initPlayersCards() {
		for (int i = 0; i < players.length; i++)
			playersCards[i] = new LinkedList<String>();
	}

	public void deliverCard(Card card, String who){
		int whoPos = ArrayUtils.search(players, who);
				playersCards[whoPos].add(card.cards.get(0));
				card.cards.remove(0);
	}
	public void showPlayerCards(){
		for(int i=0;i<PLAY_NUM;i++){
			if(players[i]!=null){
				System.out.print(players[i]+": ");
				for(String card: playersCards[i])
					System.out.println(card+"\t");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args){
		int a=0;
		int b=0;
		Card card= new Card();
		XiaoMaoDiaoYu xm= new XiaoMaoDiaoYu();
		List<String> insCards = new LinkedList<>();
		card.initCards();
		xm.initPlayer("玩家A","玩家B");
		xm.initPlayersCards();
		System.out.println("--------洗牌结果作为参考----------");
		card.showAllCards();
		System.out.println("----------游戏开始-------------");
		int count=0;
		for(int i=0;i<52;i++){
			insCards.add(card.cards.get(0));

			System.out.print("玩家A: ");
			System.out.println(card.cards.get(0));
//			card.cards.remove(0);
			xm.deliverCard(card, "玩家A");
			if(count>0){
				for(int j=0;j<count;j++){
					if(insCards.get(count).substring(2).equals(insCards.get(j).substring(2))){
						for(int k=count;k>=j;k--){
							insCards.remove(k);
						}
						a=a+(count-j+1);
						System.out.println("玩家A匹配成功,A获得共"+a+"张牌--剩下的牌为:");
						for (String inscard : insCards)
							System.out.println(inscard);
						count=j-1;
					}
				}
				//System.out.println("没有匹配到-游戏继续");
			}
			i++;
			count++;
			insCards.add(card.cards.get(0));
			System.out.print("玩家B: ");
			System.out.println(card.cards.get(0));
//			card.cards.remove(0);
			xm.deliverCard(card, "玩家B");
			if(count>0){
				for(int j=count-1;j>=0;j--){
					if(insCards.get(count).substring(2).equals(insCards.get(j).substring(2))){
						for(int k=count;k>=j;k--){
							insCards.remove(k);
						}
						b=b+(count-j+1);
						System.out.println("玩家B匹配成功,B获得共"+b+"张牌--剩下的牌为:");
						for (String inscard : insCards)
							System.out.println(inscard);
						count=j-1;
					}
				}
				//System.out.println("没有匹配到-游戏继续");
			}
			count++;
		}
		System.out.println("----------游戏结束-------------");
		System.out.println("最后A获得牌的数量为:"+a);
		System.out.println("最后B获得牌的数量为:"+b);
		System.out.println("剩下的牌为:");
		for (String inscard : insCards)
			System.out.println(inscard);
	}
}
	
	