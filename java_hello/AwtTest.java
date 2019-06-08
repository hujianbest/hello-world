import java.awt.*;
import java.awt.event.*;

public class AwtTest{
	Frame f = new Frame("测试窗口");
	TextArea ta = new TextArea(6,40);
	MenuBar mb = new MenuBar();
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");
	MenuItem exitItem = new MenuItem("退出",new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	MenuItem commentItem = new MenuItem("注释");
	MenuItem cancelItem = new MenuItem("取消注释");
	Menu format = new Menu("格式");
	
	
	Button b1 = new Button("按钮一");
	Button b2 = new Button("按钮二");
	public void init(){
		ActionListener menuListener = e ->{
			String cmd = e.getActionCommand();
			ta.append("单击"+cmd+"\n");
			if (cmd.equals("退出")){
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
			ta.append("第一个事件监听器被触发，事件源是："+e.getActionCommand()+"\n"	);
		}
	}
	class SecondListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append("单击了“"+e.getActionCommand()+"”按钮\n");
		}
	}
	public static void main(String[] args){
		new AwtTest().init();
	}
}