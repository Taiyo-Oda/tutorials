package com.emc.managers;

import com.emc.entities.Event;

public class EventManagarImpl2 implements EventManager {

	@Override
	public Event create(Long id) {
		return new Event(id, "Mac Book launch", "New Generation Of Mac Book Launch");
	}

}
