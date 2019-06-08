import java.awt.*;
import java.awt.event.*;

public class AwtTest{
	Frame f = new Frame("���Դ���");
	TextArea ta = new TextArea(6,40);
	MenuBar mb = new MenuBar();
	Menu file = new Menu("�ļ�");
	Menu edit = new Menu("�༭");
	MenuItem newItem = new MenuItem("�½�");
	MenuItem saveItem = new MenuItem("����");
	MenuItem exitItem = new MenuItem("�˳�",new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("�Զ�����");
	MenuItem copyItem = new MenuItem("����");
	MenuItem pasteItem = new MenuItem("ճ��");
	MenuItem commentItem = new MenuItem("ע��");
	MenuItem cancelItem = new MenuItem("ȡ��ע��");
	Menu format = new Menu("��ʽ");
	
	
	Button b1 = new Button("��ťһ");
	Button b2 = new Button("��ť��");
	public void init(){
		ActionListener menuListener = e ->{
			String cmd = e.getActionCommand();
			ta.append("����"+cmd+"\n");
			if (cmd.equals("�˳�")){
				System.exit(0);
			}
		};
		exitItem.addActionListener(menuListener);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		format.add(commentItem);
		format.add(cancelItem);
		edit.add(new MenuItem("-"));
		edit.add(format);
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);
		
		FirstListener f1 = new FirstListener();
		b1.addActionListener(f1);
		b1.addActionListener(new SecondListener());
		b2.addActionListener(f1);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.add(ta);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	class FirstListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append("��һ���¼����������������¼�Դ�ǣ�"+e.getActionCommand()+"\n"	);
		}
	}
	class SecondListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append("�����ˡ�"+e.getActionCommand()+"����ť\n");
		}
	}
	public static void main(String[] args){
		new AwtTest().init();
	}
}