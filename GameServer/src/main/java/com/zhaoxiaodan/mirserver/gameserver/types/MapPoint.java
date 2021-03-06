package com.zhaoxiaodan.mirserver.gameserver.types;

import javax.persistence.Embeddable;

@Embeddable
public class MapPoint implements Cloneable{
	public String mapId = "0";
	public short x;
	public short y;

	@Override
	public MapPoint clone() {
		try {
			return (MapPoint) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public void move(Direction direction, short distance){
		switch (direction){
			case UP:
				y -= distance;
				break;
			case UPRIGHT:
				x += distance;
				y -= distance;
				break;
			case RIGHT:
				x += distance;
				break;
			case DOWNRIGHT:
				x+=distance;
				y+=distance;
				break;
			case DOWN:
				y+=distance;
				break;
			case DOWNLEFT:
				x-=distance;
				y+=distance;
				break;
			case LEFT:
				x-=distance;
				break;
			case UPLEFT:
				x-=distance;
				y-=distance;
				break;
		}
	}

}
