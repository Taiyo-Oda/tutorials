package com.emc.test;

import com.emc.entities.Event;
import com.emc.entities.Organizer;
import com.emc.managers.EventManagarImpl2;
import com.emc.managers.EventManager;

public class Test {
	
	public static void main(String[] args) {
		
		//オブジェクトのインスタンスを作成（参照しているクラスのメンバーにアクセスできるようにする）
		Organizer organizer = new Organizer();
		//organizerクラスのidとnameを初期化する
		organizer.setId(123l);
		organizer.setName("Apple Inc");
		
		System.out.println(organizer);
		System.out.println(organizer.getName());
		
		//Eventクラスにカスタムコンストラクタを作成したので、インスタンスに引数を指定すれば、Eventクラスのメンバ変数を初期化できる
		Event event = new Event(456l, "IPhone 100 Launch", "Grand Lanch");
		System.out.println(event.getDescription());
		
		//インターフェイスを使用しているので、左側を変更する必要がない
		EventManager em = new EventManagarImpl2();
		System.out.println(em.create(123l).getName());
		
	}

}
