package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		Menu.displaymenu();
		TodoUtil.loadList(l,"todolist.txt");
		
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				System.out.println("Sorting complete");
				TodoUtil.listAll(l,"title",1);
				isList = true;
				break;

			case "ls_name_desc":
				System.out.println("Sorting complete");
				TodoUtil.listAll (l,"title",0);
				isList = true;
				break;
				
			case "ls_date":
		 		System.out.println("Sorting complete");
		 		TodoUtil.listAll (l,"due_date",1);
				isList = true;
				break;
				
			case "ls_date_desc":
				System.out.println("Sorting complete");
				TodoUtil.listAll (l,"due_date",0);
				isList = true;
				break;
				
			case "help":
				Menu.displaymenu();
				break;
				
			case "find":
				String keyword = sc.next().trim();
				TodoUtil.findList(l, keyword);
				break;
				
			case "find_cate":
				String keyword1 = sc.next();
				TodoUtil.findCateList(l,keyword1);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;
				
			case "comp":
				int number = sc.nextInt();
				TodoUtil.listAll(l,number);
				break;
				
			case "ls_comp":
				TodoUtil.completeItem(l);
				break;

			case "exit":
				quit = true;
				break;

			default:
				System.out.println("Please enter one of the command mentioned above (see menu - help)");
				break;
			}
			
			if(isList) l.listAll();
		} while (!quit);
		TodoUtil.saveList(l,"todolist.txt");
	}
}