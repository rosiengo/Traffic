package com.kcl.keepitclean.main.roadnetwork.laneSection;

public class RightLane extends AbstractLaneSection {

	@Override
	public boolean isOpenForward() {
		return getOpen();
	}

	@Override
	public boolean isOpenLeft() {
		return getOpen();
	}

	@Override
	public boolean isOpenRight() {
		return getClosed();
	}

	@Override
	public boolean isOpeanBackward() {
		return getClosed();
	}
}
