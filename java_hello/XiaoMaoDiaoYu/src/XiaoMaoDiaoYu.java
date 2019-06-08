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
		xm.initPlayer("���A","���B");
		xm.initPlayersCards();
		System.out.println("--------ϴ�ƽ����Ϊ�ο�----------");
		card.showAllCards();
		System.out.println("----------��Ϸ��ʼ-------------");
		int count=0;
		for(int i=0;i<52;i++){
			insCards.add(card.cards.get(0));

			System.out.print("���A: ");
			System.out.println(card.cards.get(0));
//			card.cards.remove(0);
			xm.deliverCard(card, "���A");
			if(count>0){
				for(int j=0;j<count;j++){
					if(insCards.get(count).substring(2).equals(insCards.get(j).substring(2))){
						for(int k=count;k>=j;k--){
							insCards.remove(k);
						}
						a=a+(count-j+1);
						System.out.println("���Aƥ��ɹ�,A��ù�"+a+"����--ʣ�µ���Ϊ:");
						for (String inscard : insCards)
							System.out.println(inscard);
						count=j-1;
					}
				}
				//System.out.println("û��ƥ�䵽-��Ϸ����");
			}
			i++;
			count++;
			insCards.add(card.cards.get(0));
			System.out.print("���B: ");
			System.out.println(card.cards.get(0));
//			card.cards.remove(0);
			xm.deliverCard(card, "���B");
			if(count>0){
				for(int j=count-1;j>=0;j--){
					if(insCards.get(count).substring(2).equals(insCards.get(j).substring(2))){
						for(int k=count;k>=j;k--){
							insCards.remove(k);
						}
						b=b+(count-j+1);
						System.out.println("���Bƥ��ɹ�,B��ù�"+b+"����--ʣ�µ���Ϊ:");
						for (String inscard : insCards)
							System.out.println(inscard);
						count=j-1;
					}
				}
				//System.out.println("û��ƥ�䵽-��Ϸ����");
			}
			count++;
		}
		System.out.println("----------��Ϸ����-------------");
		System.out.println("���A����Ƶ�����Ϊ:"+a);
		System.out.println("���B����Ƶ�����Ϊ:"+b);
		System.out.println("ʣ�µ���Ϊ:");
		for (String inscard : insCards)
			System.out.println(inscard);
	}
}
	
	