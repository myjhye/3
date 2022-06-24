package com.sist.client;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;
import com.sist.data.*;
import com.sist.main.NetworkMain;

// 포스터 보여주는 기능
public class FoodManager extends JPanel implements MouseListener{
    public PosterCard[] FoodLocationVOs=new PosterCard[15];
    public JPanel pan=new JPanel();
    public ControllerPanel cp;
    
    public FoodManager(ControllerPanel cp)
    {
    	this.cp=cp;
    }
    
    // 포스터 출력하는 기능
    public void cardPrint(ArrayList<FoodLocationVO> list)
    {
    	setLayout(null);
    	//JPanel p=new JPanel();
    	pan.setLayout(new GridLayout(3,5));
    	int i=0;
    	for(FoodLocationVO m:list)
    	{
    		
    		FoodLocationVOs[i]=new PosterCard(m);
    		pan.add(FoodLocationVOs[i]);
    		FoodLocationVOs[i].addMouseListener(this);
    		i++;
    	}
    	
    	pan.setBounds(10, 35, 840, 750);
    	add(pan);
    	
    	
    }
    
    // 포스터 지웠다가 출력하는 기능
    public void cardInit(ArrayList<FoodLocationVO> list)
    {
    	for(int i=0;i<list.size();i++)
    	{
    		
    		FoodLocationVOs[i].poster.setIcon(null);
    		FoodLocationVOs[i].singer.setText("");
    		FoodLocationVOs[i].title.setText("");
   
    	}
    	pan.removeAll();
		pan.validate();
    }
	@Override
	public void mouseClicked(MouseEvent e) {

		for(int i=0;i<FoodLocationVOs.length;i++)
		{
			if(e.getSource()==FoodLocationVOs[i])
			{
				String title=FoodLocationVOs[i].title.getText();
				for(int j=0;j<FoodSystem.getList().size();j++)
				{
					FoodLocationVO m=FoodSystem.getList().get(j);
					if(m.getName().equals(title))
					{
						// 상세보기
						/*cp.df.album.setText(m.getAlbum());
						cp.df.title.setText(m.getTitle());
						cp.df.singer.setText(m.getSinger());
						String s="";
						if(m.getState().equals("유지"))
						{
							s="-";
						}
						else if(m.getState().equals("상승"))
						{
							s="▲"+m.getIdcrement();
						}
						else if(m.getState().equals("하강"))
						{
							s="▼"+m.getIdcrement();
						}
						cp.df.idcrement.setText(s);
						cp.df.movie.setText(m.getKey());*/
						try
				    	{
				    		URL url=new URL("http:"+m.getPoster());
				    		Image img=NetworkMain.getImage(new ImageIcon(url), 350, 250);
				    		cp.df.posterLa.setIcon(new ImageIcon(img));
				    		
				    	}catch(Exception ex) {}
						break;
					}
				}
				cp.card.show(cp, "DF");// 화면 이동 
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}